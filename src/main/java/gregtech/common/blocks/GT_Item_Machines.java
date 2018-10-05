package gregtech.common.blocks;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.metatileentity.IConnectable;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_ItsNotMyFaultException;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

import static gregtech.api.enums.GT_Values.DUMMY_WORLD;
import static gregtech.api.enums.GT_Values.EMPTY_STRING;
import static gregtech.api.enums.GT_Values.VOLTAGE_ABBRS;

public class GT_Item_Machines
        extends ItemBlock {
    public GT_Item_Machines(Block par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
        setCreativeTab(GregTech_API.TAB_GREGTECH);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addInformation(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean par4) {
        try {
            int tDamage = getDamage(aStack);
            if ((tDamage <= 0) || (tDamage >= GregTech_API.METATILEENTITIES.length)) {
                return;
            }

            TileEntity tDummyTE = GregTech_API.sBlockMachines.createTileEntity(aPlayer == null ? DUMMY_WORLD : aPlayer.worldObj, GregTech_API.METATILEENTITIES[tDamage] == null ? 0 : GregTech_API.METATILEENTITIES[tDamage].getTileEntityBaseType());
            if (tDummyTE != null) {
                tDummyTE.setWorldObj(aPlayer == null ? DUMMY_WORLD : aPlayer.worldObj);
                tDummyTE.xCoord = 0;
                tDummyTE.yCoord = 0;
                tDummyTE.zCoord = 0;
                if ((tDummyTE instanceof IGregTechTileEntity)) {
                    IGregTechTileEntity tTileEntity = (IGregTechTileEntity) tDummyTE;
                    tTileEntity.setInitialValuesAsNBT(new NBTTagCompound(), (short) tDamage);
                    if (tTileEntity.getDescription() != null) {
                        int i = 0;
                        for (String tDescription : tTileEntity.getDescription()) {
                            if (GT_Utility.isStringValid(tDescription)) {
                                aList.add(GT_LanguageManager.addStringLocalization("TileEntity_DESCRIPTION_" + tDamage + "_Index_" + i++, tDescription, !GregTech_API.sPostloadFinished));
                            }
                        }
                    }
                    if (tTileEntity.getEUCapacity() > 0L) {
                        if (tTileEntity.getInputVoltage() > 0L) {
                            aList.add(GT_LanguageManager.addStringLocalization("TileEntity_EUp_IN", "Voltage IN: ", !GregTech_API.sPostloadFinished) + EnumChatFormatting.GREEN + tTileEntity.getInputVoltage() + " (" + VOLTAGE_ABBRS[GT_Utility.getTier(tTileEntity.getInputVoltage())] + ")" + EnumChatFormatting.GRAY);
                        }
                        if (tTileEntity.getOutputVoltage() > 0L) {
                            aList.add(GT_LanguageManager.addStringLocalization("TileEntity_EUp_OUT", "Voltage OUT: ", !GregTech_API.sPostloadFinished) + EnumChatFormatting.GREEN + tTileEntity.getOutputVoltage() + " (" + VOLTAGE_ABBRS[GT_Utility.getTier(tTileEntity.getOutputVoltage())] + ")" + EnumChatFormatting.GRAY);
                        }
                        if (tTileEntity.getOutputAmperage() > 1L) {
                            aList.add(GT_LanguageManager.addStringLocalization("TileEntity_EUp_AMOUNT", "Amperage: ", !GregTech_API.sPostloadFinished) + EnumChatFormatting.YELLOW + tTileEntity.getOutputAmperage() + EnumChatFormatting.GRAY);
                        }
                        aList.add(GT_LanguageManager.addStringLocalization("TileEntity_EUp_STORE", "Capacity: ", !GregTech_API.sPostloadFinished) + EnumChatFormatting.BLUE + tTileEntity.getEUCapacity() + EnumChatFormatting.GRAY);
                    }

                    NBTTagCompound aNBT = aStack.getTagCompound();
                    if (aNBT != null) {
                        if (aNBT.getBoolean("mMuffler")) {
                            aList.add(GT_LanguageManager.addStringLocalization("GT_TileEntity_MUFFLER", "has Muffler Upgrade", !GregTech_API.sPostloadFinished));
                        }
                        if (aNBT.getBoolean("mSteamConverter")) {
                            aList.add(GT_LanguageManager.addStringLocalization("GT_TileEntity_STEAMCONVERTER", "has Steam Upgrade", !GregTech_API.sPostloadFinished));
                        }
                        int tAmount = aNBT.getByte("mSteamTanks");
                        if (tAmount > 0) {
                            aList.add(tAmount + " " + GT_LanguageManager.addStringLocalization("GT_TileEntity_STEAMTANKS", "Steam Tank Upgrades", !GregTech_API.sPostloadFinished));
                        }
                        FluidStack tFluidStack = FluidStack.loadFluidStackFromNBT(aNBT.getCompoundTag("GT.FluidContent"));
                        if (tFluidStack != null && tFluidStack.amount > 0) {
                            String tName = tFluidStack.getLocalizedName();
                            aList.add(EnumChatFormatting.BLUE.toString() + tName + EnumChatFormatting.GRAY.toString());
                            aList.add(EnumChatFormatting.BLUE.toString() + tFluidStack.amount + "L / " + (tTileEntity.getInfoData()[4]) + EnumChatFormatting.GRAY.toString());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(GT_Log.err);
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        return false;
    }

    @Override
    public String getUnlocalizedName(ItemStack aStack) {
        short tDamage = (short) getDamage(aStack);
        if ((tDamage < 0) || (tDamage >= GregTech_API.METATILEENTITIES.length)) {
            return EMPTY_STRING;
        }
        if (GregTech_API.METATILEENTITIES[tDamage] != null) {
            return getUnlocalizedName() + "." + GregTech_API.METATILEENTITIES[tDamage].getMetaName();
        }
        return EMPTY_STRING;
    }

    @Override
    public void onCreated(ItemStack aStack, World aWorld, EntityPlayer aPlayer) {
        super.onCreated(aStack, aWorld, aPlayer);
        short tDamage = (short) getDamage(aStack);
        if ((tDamage < 0) || ((tDamage >= GregTech_API.METATILEENTITIES.length) && (GregTech_API.METATILEENTITIES[tDamage] != null))) {
            GregTech_API.METATILEENTITIES[tDamage].onCreated(aStack, aWorld, aPlayer);
        }
    }

    @Override
    public boolean placeBlockAt(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int side, float hitX, float hitY, float hitZ, int aMeta) {
        short tDamage = (short) getDamage(aStack);
        if (tDamage > 0) {
            if (GregTech_API.METATILEENTITIES[tDamage] == null) {
                return false;
            }
            int tMetaData = GregTech_API.METATILEENTITIES[tDamage].getTileEntityBaseType();
            if (!aWorld.setBlock(aX, aY, aZ, this.field_150939_a, tMetaData, 3)) {
                return false;
            }
            if (aWorld.getBlock(aX, aY, aZ) != this.field_150939_a) {
                throw new GT_ItsNotMyFaultException("Failed to place Block even though World.setBlock returned true. It COULD be MCPC/Bukkit causing that. In case you really have that installed, don't report this Bug to me, I don't know how to fix it.");
            }
            if (aWorld.getBlockMetadata(aX, aY, aZ) != tMetaData) {
                throw new GT_ItsNotMyFaultException("Failed to set the MetaValue of the Block even though World.setBlock returned true. It COULD be MCPC/Bukkit causing that. In case you really have that installed, don't report this Bug to me, I don't know how to fix it.");
            }
            IGregTechTileEntity tTileEntity = (IGregTechTileEntity) aWorld.getTileEntity(aX, aY, aZ);
            if (tTileEntity != null) {
                tTileEntity.setInitialValuesAsNBT(tTileEntity.isServerSide() ? aStack.getTagCompound() : null, tDamage);
                if (aPlayer != null) {
                    tTileEntity.setOwnerName(aPlayer.getDisplayName());
                }
                tTileEntity.getMetaTileEntity().initDefaultModes(aStack.getTagCompound());
                final byte aSide = GT_Utility.getOppositeSide(side);
                if (tTileEntity.getMetaTileEntity() instanceof IConnectable) {
                    // If we're connectable, try connecting to whatever we're up against
                	((IConnectable) tTileEntity.getMetaTileEntity()).connect(aSide);
                } else if (aPlayer != null && aPlayer.isSneaking()) {
                    // If we're being placed against something that is connectable, try telling it to connect to us
                    IGregTechTileEntity aTileEntity = tTileEntity.getIGregTechTileEntityAtSide(aSide);
                    if (aTileEntity != null && aTileEntity.getMetaTileEntity() instanceof IConnectable) {
                        ((IConnectable) aTileEntity.getMetaTileEntity()).connect((byte)side);
                    }
                }
            }
        } else if (!aWorld.setBlock(aX, aY, aZ, this.field_150939_a, tDamage, 3)) {
            return false;
        }
        if (aWorld.getBlock(aX, aY, aZ) == this.field_150939_a) {
            this.field_150939_a.onBlockPlacedBy(aWorld, aX, aY, aZ, aPlayer, aStack);
            this.field_150939_a.onPostBlockPlaced(aWorld, aX, aY, aZ, tDamage);
        }
        return true;
    }
}
