package gregtech.common.tileentities.machines.multi;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.gui.GT_GUIContainer_MultiMachine;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_MultiBlockBase;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;

public class GT_MetaTileEntity_HydroFarm extends GT_MetaTileEntity_MultiBlockBase {

    public GT_MetaTileEntity_HydroFarm(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_HydroFarm(String aName) {
        super(aName);
    }

    public String[] getDescription() {
        return new String[]{
                "Controller Block for the Hydroponic Farm",
                "Grows Plants Inside with Water & Fertilizer",
                "Size(WxHxD): 5x4x5, Controller (Bottom center)",
                "25x Plastic Casings (Centered 3x1x3 area in Bottom layer)",
                "1x Input Hatch/Bus (Centered 3x1x3 area in Top layer)",
                "1x Output Hatch/Bus (Any bottom layer casing)",
                "1x Maintenance Hatch (Any bottom layer casing)",
                "1x Muffler Hatch (Centered 3x1x3 area in Top layer)",
                "1x Energy Hatch (Any bottom layer casing)",
                "Plastic Casings for the rest (64 at least!)"};
    }

    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            return new ITexture[]{Textures.BlockIcons.CASING_BLOCKS[1],
                    new GT_RenderedTexture(aActive ? Textures.BlockIcons.OVERLAY_SCREEN : Textures.BlockIcons.OVERLAY_SCREEN)};
        }
        return new ITexture[]{Textures.BlockIcons.CASING_BLOCKS[1]};
    }

    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_MultiMachine(aPlayerInventory, aBaseMetaTileEntity, getLocalName(), "HydroFarm.png");
    }

    @Override
    public boolean checkRecipe(ItemStack aStack) {
        ArrayList<ItemStack> tInputList = getStoredInputs();
        ArrayList<FluidStack> tFluidInputs = getStoredFluids();
        for (ItemStack tInput : tInputList) {
            long tVoltage = getMaxInputVoltage();
            byte tTier = (byte) Math.max(1, GT_Utility.getTier(tVoltage));
            GT_Recipe tRecipe = GT_Recipe.GT_Recipe_Map.sHydroFarmRecipes.findRecipe(getBaseMetaTileEntity(), false, gregtech.api.enums.GT_Values.V[tTier], tFluidInputs.isEmpty() ? null : new FluidStack[]{tFluidInputs.get(0)}, mInventory[1], tInput);
            if (tRecipe != null) {
                if (tRecipe.isRecipeInputEqual(true, tFluidInputs.isEmpty() ? null : new FluidStack[]{tFluidInputs.get(0)}, tInput, mInventory[1])) {
                    this.mEfficiency = (10000 - (getIdealStatus() - getRepairStatus()) * 1000);
                    this.mEfficiencyIncrease = 10000;

                    this.mEUt = tRecipe.mEUt;
                    this.mMaxProgresstime = tRecipe.mDuration;
                    if (tRecipe.mEUt <= 16) {
                        this.mEUt = (tRecipe.mEUt * (1 << tTier - 1) * (1 << tTier - 1));
                        this.mMaxProgresstime = (tRecipe.mDuration / (1 << tTier - 1));
                    } else {
                        this.mEUt = tRecipe.mEUt;
                        this.mMaxProgresstime = tRecipe.mDuration;
                        while (this.mEUt <= gregtech.api.enums.GT_Values.V[(tTier - 1)]) {
                            this.mEUt *= 4;
                            this.mMaxProgresstime /= 2;
                        }
                    }
                    if (this.mEUt > 0) {
                        this.mEUt = (-this.mEUt);
                    }
                    this.mMaxProgresstime = Math.max(1, this.mMaxProgresstime);
                    if (tRecipe.mOutputs.length > 0) this.mOutputItems = new ItemStack[]{tRecipe.getOutput(0)};
                    if (tRecipe.mFluidOutputs.length > 0)
                        this.mOutputFluids = new FluidStack[]{tRecipe.getFluidOutput(0)};
                    updateSlots();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        int xDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetX * 2;
        int zDir = ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()).offsetZ * 2;
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                for (int h = 0; h < 4; h++) {
                    IGregTechTileEntity tTileEntity = aBaseMetaTileEntity.getIGregTechTileEntityOffset(xDir + i, h, zDir + j);
                    if ((i != -2 && i != 2) && (j != -2 && j != 2)) {// innerer 3x3 ohne h�he
                        if (h == 0) {// innen boden (plastic casings)
                            if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GregTech_API.sBlockCasings4) {
                                return false;
                            }
                            if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 14) {
                                return false;
                            }
                        } else if (h == 3) {// innen decke (plastic casings + input + muffler)
                            if ((!addInputToMachineList(tTileEntity, 62)) && (!addMufflerToMachineList(tTileEntity, 62))) {
                                if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GregTech_API.sBlockCasings4) {
                                    return false;
                                }
                                if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 14) {
                                    return false;
                                }
                            }
                        } else {// innen air
                            if (!aBaseMetaTileEntity.getAirOffset(xDir + i, h, zDir + j)) {
                                return false;
                            }
                        }
                    } else {// Au�erer 5x5 ohne h�he
                        if (h == 0) {// au�en boden (controller, output, energy, maintainance, rest plastic casings)
                            if ((!addMaintenanceToMachineList(tTileEntity, 62)) && (!addOutputToMachineList(tTileEntity, 62)) && (!addEnergyInputToMachineList(tTileEntity, 62))) {
                                if ((xDir + i != 0) || (zDir + j != 0)) {//no controller
                                    if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GregTech_API.sBlockCasings4) {
                                        return false;
                                    }
                                    if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 14) {
                                        return false;
                                    }
                                }
                            }
                        } else {// au�en �ber boden (plastic)
                            if (aBaseMetaTileEntity.getBlockOffset(xDir + i, h, zDir + j) != GregTech_API.sBlockCasings4) {
                                return false;
                            }
                            if (aBaseMetaTileEntity.getMetaIDOffset(xDir + i, h, zDir + j) != 14) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getPollutionPerTick(ItemStack aStack) {
        return 0;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }

    @Override
    public int getAmountOfOutputs() {
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_HydroFarm(this.mName);
    }

}