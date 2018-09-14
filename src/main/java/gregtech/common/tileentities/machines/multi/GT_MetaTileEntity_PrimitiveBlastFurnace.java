package gregtech.common.tileentities.machines.multi;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.objects.GT_ItemStack;
import gregtech.api.objects.XSTR;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.gui.GT_Container_BronzeBlastFurnace;
import gregtech.common.gui.GT_GUIContainer_BronzeBlastFurnace;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.ChunkPosition;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class GT_MetaTileEntity_PrimitiveBlastFurnace
        extends MetaTileEntity {
    public int mMaxProgresstime = 0;
    public int mUpdate = 5;
    public int mProgresstime = 0;
    public boolean mMachine = false;
    public ItemStack mOutputItem1;
    public ItemStack mOutputItem2;

    public GT_MetaTileEntity_PrimitiveBlastFurnace(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional, 4);
    }

    public GT_MetaTileEntity_PrimitiveBlastFurnace(String aName) {
        super(aName, 4);
    }

    public boolean isSteampowered() {
        return false;
    }

    public boolean isElectric() {
        return false;
    }

    public boolean isPneumatic() {
        return false;
    }

    public boolean isEnetInput() {
        return false;
    }

    public boolean isEnetOutput() {
        return false;
    }

    public boolean isInputFacing(byte aSide) {
        return false;
    }

    public boolean isOutputFacing(byte aSide) {
        return false;
    }

    public boolean isTeleporterCompatible() {
        return false;
    }

    public boolean isFacingValid(byte aFacing) {
        return aFacing > 1;
    }

    public boolean isAccessAllowed(EntityPlayer aPlayer) {
        return true;
    }

    public int getProgresstime() {
        return this.mProgresstime;
    }

    public int maxProgresstime() {
        return this.mMaxProgresstime;
    }

    public int increaseProgress(int aProgress) {
        this.mProgresstime += aProgress;
        return this.mMaxProgresstime - this.mProgresstime;
    }

    public boolean allowCoverOnSide(byte aSide, GT_ItemStack aCoverID) {
        return (GregTech_API.getCoverBehavior(aCoverID.toStack()).isSimpleCover()) && (super.allowCoverOnSide(aSide, aCoverID));
    }

    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_BronzeBlastFurnace(this.mName);
    }

    public void saveNBTData(NBTTagCompound aNBT) {
        aNBT.setInteger("mProgresstime", this.mProgresstime);
        aNBT.setInteger("mMaxProgresstime", this.mMaxProgresstime);
        if (this.mOutputItem1 != null) {
            NBTTagCompound tNBT = new NBTTagCompound();
            this.mOutputItem1.writeToNBT(tNBT);
            aNBT.setTag("mOutputItem1", tNBT);
        }
        if (this.mOutputItem2 != null) {
            NBTTagCompound tNBT = new NBTTagCompound();
            this.mOutputItem2.writeToNBT(tNBT);
            aNBT.setTag("mOutputItem2", tNBT);
        }
    }

    public void loadNBTData(NBTTagCompound aNBT) {
        this.mUpdate = 5;
        this.mProgresstime = aNBT.getInteger("mProgresstime");
        this.mMaxProgresstime = aNBT.getInteger("mMaxProgresstime");
        this.mOutputItem1 = GT_Utility.loadItem(aNBT, "mOutputItem1");
        this.mOutputItem2 = GT_Utility.loadItem(aNBT, "mOutputItem2");
    }

    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        if (aBaseMetaTileEntity.isClientSide()) {
            return true;
        }
        aBaseMetaTileEntity.openGUI(aPlayer);
        return true;
    }

    public Object getServerGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_Container_BronzeBlastFurnace(aPlayerInventory, aBaseMetaTileEntity);
    }

    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_BronzeBlastFurnace(aPlayerInventory, aBaseMetaTileEntity);
    }

    private boolean checkMachine() {
        int xDir = ForgeDirection.getOrientation(getBaseMetaTileEntity().getBackFacing()).offsetX;
        int zDir = ForgeDirection.getOrientation(getBaseMetaTileEntity().getBackFacing()).offsetZ;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 3; j++) {
                for (int k = -1; k < 2; k++) {
                    if ((xDir + i != 0) || (j != 0) || (zDir + k != 0)) {
                        if ((i != 0) || (j == -1) || (k != 0)) {
                            if (!isCorrectCasingBlock(getBaseMetaTileEntity().getBlockOffset(xDir + i, j, zDir + k)) || !isCorrectCasingMetaID(getBaseMetaTileEntity().getMetaIDOffset(xDir + i, j, zDir + k))) {
                                return false;
                            }
                        } else if ((!GT_Utility.arrayContains(getBaseMetaTileEntity().getBlockOffset(xDir + i, j, zDir + k), new Object[]{Blocks.lava, Blocks.flowing_lava, null})) && (!getBaseMetaTileEntity().getAirOffset(xDir + i, j, zDir + k))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    protected abstract boolean isCorrectCasingBlock(Block block);

    protected abstract boolean isCorrectCasingMetaID(int metaID);

    public void onMachineBlockUpdate() {
        this.mUpdate = 5;
    }

    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTimer) {
        if ((aBaseMetaTileEntity.isClientSide()) &&
                (aBaseMetaTileEntity.isActive())) {
            aBaseMetaTileEntity.getWorld().spawnParticle("largesmoke", aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1) + (new XSTR()).nextFloat(), aBaseMetaTileEntity.getOffsetY(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1) + (new XSTR()).nextFloat(), 0.0D, 0.3D, 0.0D);
        }
        if (aBaseMetaTileEntity.isServerSide()) {
            if (this.mUpdate-- == 0) {
                this.mMachine = checkMachine();
            }
            if (this.mMachine) {
                if (this.mMaxProgresstime > 0) {
                    if (++this.mProgresstime >= this.mMaxProgresstime) {
                        addOutputProducts();
                        this.mOutputItem1 = null;
                        this.mOutputItem2 = null;
                        this.mProgresstime = 0;
                        this.mMaxProgresstime = 0;
                        GT_Mod.achievements.issueAchievement(aBaseMetaTileEntity.getWorld().getPlayerEntityByName(aBaseMetaTileEntity.getOwnerName()), "steel");
                    }
                } else if (aBaseMetaTileEntity.isAllowedToWork()) {
                    checkRecipe();
                }
            }
            if(this.mMaxProgresstime>0 && (aTimer % 20L == 0L)){}

            aBaseMetaTileEntity.setActive((this.mMaxProgresstime > 0) && (this.mMachine));
            if (aBaseMetaTileEntity.isActive()) {
                if (aBaseMetaTileEntity.getAir(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord(), aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1))) {
                    aBaseMetaTileEntity.getWorld().setBlock(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord(), aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1), Blocks.lava, 1, 2);
                    this.mUpdate = 1;
                }
                if (aBaseMetaTileEntity.getAir(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord() + 1, aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1))) {
                    aBaseMetaTileEntity.getWorld().setBlock(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord() + 1, aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1), Blocks.lava, 1, 2);
                    this.mUpdate = 1;
                }
            } else {
                if (aBaseMetaTileEntity.getBlock(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord(), aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1)) == Blocks.lava) {
                    aBaseMetaTileEntity.getWorld().setBlock(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord(), aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1), Blocks.air, 0, 2);
                    this.mUpdate = 1;
                }
                if (aBaseMetaTileEntity.getBlock(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord() + 1, aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1)) == Blocks.lava) {
                    aBaseMetaTileEntity.getWorld().setBlock(aBaseMetaTileEntity.getOffsetX(aBaseMetaTileEntity.getBackFacing(), 1), aBaseMetaTileEntity.getYCoord() + 1, aBaseMetaTileEntity.getOffsetZ(aBaseMetaTileEntity.getBackFacing(), 1), Blocks.air, 0, 2);
                    this.mUpdate = 1;
                }
            }
        }
    }

    private void addOutputProducts() {
        if (this.mOutputItem1 != null) {
            if (this.mInventory[2] == null) {
                this.mInventory[2] = GT_Utility.copy(new Object[]{this.mOutputItem1});
            } else if (GT_Utility.areStacksEqual(this.mInventory[2], this.mOutputItem1)) {
                this.mInventory[2].stackSize = Math.min(this.mOutputItem1.getMaxStackSize(), this.mOutputItem1.stackSize + this.mInventory[2].stackSize);
            }
        }
        if (this.mOutputItem2 != null) {
            if (this.mInventory[3] == null) {
                this.mInventory[3] = GT_Utility.copy(new Object[]{this.mOutputItem2});
            } else if (GT_Utility.areStacksEqual(this.mInventory[3], this.mOutputItem2)) {
                this.mInventory[3].stackSize = Math.min(this.mOutputItem2.getMaxStackSize(), this.mOutputItem2.stackSize + this.mInventory[3].stackSize);
            }
        }
    }

    private boolean spaceForOutput(ItemStack aStack1, ItemStack aStack2) {
        if (((this.mInventory[2] == null) || (aStack1 == null) || ((this.mInventory[2].stackSize + aStack1.stackSize <= this.mInventory[2].getMaxStackSize()) && (GT_Utility.areStacksEqual(this.mInventory[2], aStack1)))) && (
                (this.mInventory[3] == null) || (aStack2 == null) || ((this.mInventory[3].stackSize + aStack2.stackSize <= this.mInventory[3].getMaxStackSize()) && (GT_Utility.areStacksEqual(this.mInventory[3], aStack2))))) {
            return true;
        }
        return false;
    }

    private boolean checkRecipe() {
        if (!this.mMachine) {
            return false;
        }
        if ((this.mInventory[0] != null) && (this.mInventory[1] != null) && (this.mInventory[0].stackSize >= 1)) {
            if ((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[0], "dustIron")) || (GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[0], "ingotIron"))) {
                if ((this.mInventory[1].getItem() == Items.coal) && (this.mInventory[1].stackSize >= 4) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 4L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 4);
                    this.mMaxProgresstime = 7200;
                    return true;
                }
                if ((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "fuelCoke")) && (this.mInventory[1].stackSize >= 2) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 4L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 2);
                    this.mMaxProgresstime = 4800;
                    return true;
                }
                if ((this.mInventory[0].stackSize >= 9) && ((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "blockCoal")) || (GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "blockCharcoal"))) && (this.mInventory[1].stackSize >= 4) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 4L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 9);
                    getBaseMetaTileEntity().decrStackSize(1, 4);
                    this.mMaxProgresstime = 64800;
                    return true;
                }
            } else if (GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[0], "dustSteel")) {
                if ((this.mInventory[1].getItem() == Items.coal) && (this.mInventory[1].stackSize >= 2) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 2L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 2);
                    this.mMaxProgresstime = 3600;
                    return true;
                }
                if ((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "fuelCoke")) && (this.mInventory[1].stackSize >= 1) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 1);
                    this.mMaxProgresstime = 2400;
                    return true;
                }
                if ((this.mInventory[0].stackSize >= 9) && ((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "blockCoal")) || (GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "blockCharcoal"))) && (this.mInventory[1].stackSize >= 2) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 2L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 9);
                    getBaseMetaTileEntity().decrStackSize(1, 2);
                    this.mMaxProgresstime = 32400;
                    return true;
                }
            } else if (GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[0], "blockIron")) {
                if ((this.mInventory[1].getItem() == Items.coal) && (this.mInventory[1].stackSize >= 36) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 4L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 36);
                    this.mMaxProgresstime = 64800;
                    return true;
                }
                if ((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "fuelCoke")) && (this.mInventory[1].stackSize >= 18) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 4L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 18);
                    this.mMaxProgresstime = 43200;
                    return true;
                }
                if (((GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "blockCoal")) || (GT_OreDictUnificator.isItemStackInstanceOf(this.mInventory[1], "blockCharcoal"))) && (this.mInventory[1].stackSize >= 4) && (spaceForOutput(this.mOutputItem1 = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 9L), this.mOutputItem2 = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 4L)))) {
                    getBaseMetaTileEntity().decrStackSize(0, 1);
                    getBaseMetaTileEntity().decrStackSize(1, 4);
                    this.mMaxProgresstime = 64800;
                    return true;
                }
            }
        }
        this.mOutputItem1 = null;
        this.mOutputItem2 = null;
        return false;
    }

    public boolean isGivingInformation() {
        return false;
    }

    public boolean allowPullStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide, ItemStack aStack) {
        return aIndex > 1;
    }

    public boolean allowPutStack(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, byte aSide, ItemStack aStack) {
        return !GT_Utility.areStacksEqual(aStack, this.mInventory[0]);
    }

    public byte getTileEntityBaseType() {
        return 0;
    }
}