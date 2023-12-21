package gregtech.common.items.behaviors;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import gregtech.api.enums.SoundResource;
import gregtech.api.items.GT_MetaBase_Item;
import gregtech.api.items.GT_MetaGenerated_Tool;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import ic2.api.tile.IWrenchable;

public class Behaviour_Wrench extends Behaviour_None {

    private final int mCosts;
    private final String mTooltip = GT_LanguageManager
        .addStringLocalization("gt.behaviour.wrench", "Rotates Blocks on Rightclick");

    public Behaviour_Wrench(int aCosts) {
        this.mCosts = aCosts;
    }

    @Override
    public boolean onItemUseFirst(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX,
        int aY, int aZ, ForgeDirection side, float hitX, float hitY, float hitZ) {
        if (aWorld.isRemote || aPlayer.isSneaking()) {
            return false;
        }
        final Block aBlock = aWorld.getBlock(aX, aY, aZ);
        if (aBlock == null) {
            return false;
        }
        final byte aMeta = (byte) aWorld.getBlockMetadata(aX, aY, aZ);
        final short targetSideOrdinal = (short) GT_Utility.determineWrenchingSide(side, hitX, hitY, hitZ)
            .ordinal();
        final TileEntity aTileEntity = aWorld.getTileEntity(aX, aY, aZ);
        try {
            if (aTileEntity instanceof IWrenchable wrenchable) {
                if (wrenchable.wrenchCanSetFacing(aPlayer, targetSideOrdinal)) {
                    if ((aPlayer.capabilities.isCreativeMode)
                        || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts))) {
                        wrenchable.setFacing(targetSideOrdinal);
                        GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
                    }
                    return true;
                }
                if (wrenchable.wrenchCanRemove(aPlayer)) {
                    final int tDamage = wrenchable.getWrenchDropRate() < 1.0F ? 10 : 3;
                    if ((aPlayer.capabilities.isCreativeMode)
                        || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, (long) tDamage * this.mCosts))) {
                        ItemStack tOutput = wrenchable.getWrenchDrop(aPlayer);
                        for (final ItemStack tStack : aBlock.getDrops(aWorld, aX, aY, aZ, aMeta, 0)) {
                            if (tOutput == null) {
                                aWorld.spawnEntityInWorld(
                                    new EntityItem(aWorld, aX + 0.5D, aY + 0.5D, aZ + 0.5D, tStack));
                            } else {
                                aWorld.spawnEntityInWorld(
                                    new EntityItem(aWorld, aX + 0.5D, aY + 0.5D, aZ + 0.5D, tOutput));
                                tOutput = null;
                            }
                        }
                        aWorld.setBlockToAir(aX, aY, aZ);
                        GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
                    }
                    return true;
                }
                return true;
            }
        } catch (Throwable ignored) {}
        if ((aBlock == Blocks.log) || (aBlock == Blocks.log2) || (aBlock == Blocks.hay_block)) {
            if ((aPlayer.capabilities.isCreativeMode)
                || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts))) {
                aWorld.setBlockMetadataWithNotify(aX, aY, aZ, (aMeta + 4) % 12, 3);
                GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
            }
            return true;
        }
        if ((aBlock == Blocks.powered_repeater) || (aBlock == Blocks.unpowered_repeater)) {
            if ((aPlayer.capabilities.isCreativeMode)
                || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts))) {
                aWorld.setBlockMetadataWithNotify(aX, aY, aZ, aMeta / 4 * 4 + (aMeta % 4 + 1) % 4, 3);
                GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
            }
            return true;
        }
        if ((aBlock == Blocks.powered_comparator) || (aBlock == Blocks.unpowered_comparator)) {
            if ((aPlayer.capabilities.isCreativeMode)
                || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts))) {
                aWorld.setBlockMetadataWithNotify(aX, aY, aZ, aMeta / 4 * 4 + (aMeta % 4 + 1) % 4, 3);
                GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
            }
            return true;
        }
        if ((aBlock == Blocks.crafting_table) || (aBlock == Blocks.bookshelf)) {
            if ((aPlayer.capabilities.isCreativeMode)
                || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts))) {
                aWorld.spawnEntityInWorld(
                    new EntityItem(aWorld, aX + 0.5D, aY + 0.5D, aZ + 0.5D, new ItemStack(aBlock, 1, aMeta)));
                aWorld.setBlockToAir(aX, aY, aZ);
                GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
            }
            return true;
        }
        if (aMeta == targetSideOrdinal) {
            if ((aBlock == Blocks.pumpkin) || (aBlock == Blocks.lit_pumpkin)
                || (aBlock == Blocks.piston)
                || (aBlock == Blocks.sticky_piston)
                || (aBlock == Blocks.dispenser)
                || (aBlock == Blocks.dropper)
                || (aBlock == Blocks.furnace)
                || (aBlock == Blocks.lit_furnace)
                || (aBlock == Blocks.chest)
                || (aBlock == Blocks.trapped_chest)
                || (aBlock == Blocks.ender_chest)
                || (aBlock == Blocks.hopper)) {
                if ((aPlayer.capabilities.isCreativeMode)
                    || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts))) {
                    aWorld.spawnEntityInWorld(
                        new EntityItem(aWorld, aX + 0.5D, aY + 0.5D, aZ + 0.5D, new ItemStack(aBlock, 1, 0)));
                    aWorld.setBlockToAir(aX, aY, aZ);
                    GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
                }
                return true;
            }
        } else {
            if ((aBlock == Blocks.piston) || (aBlock == Blocks.sticky_piston)
                || (aBlock == Blocks.dispenser)
                || (aBlock == Blocks.dropper)) {
                if ((aMeta < 6) && ((aPlayer.capabilities.isCreativeMode)
                    || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts)))) {
                    aWorld.setBlockMetadataWithNotify(aX, aY, aZ, targetSideOrdinal, 3);
                    GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
                }
                return true;
            }
            if ((aBlock == Blocks.pumpkin) || (aBlock == Blocks.lit_pumpkin)
                || (aBlock == Blocks.furnace)
                || (aBlock == Blocks.lit_furnace)
                || (aBlock == Blocks.chest)
                || (aBlock == Blocks.ender_chest)
                || (aBlock == Blocks.trapped_chest)) {
                if ((targetSideOrdinal > 1) && ((aPlayer.capabilities.isCreativeMode)
                    || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts)))) {
                    aWorld.setBlockMetadataWithNotify(aX, aY, aZ, targetSideOrdinal, 3);
                    GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
                }
                return true;
            }
            if (aBlock == Blocks.hopper) {
                if ((targetSideOrdinal != 1) && ((aPlayer.capabilities.isCreativeMode)
                    || (((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts)))) {
                    aWorld.setBlockMetadataWithNotify(aX, aY, aZ, targetSideOrdinal, 3);
                    GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
                }
                return true;
            }
        }
        if ((Arrays.asList(aBlock.getValidRotations(aWorld, aX, aY, aZ))
            .contains(ForgeDirection.getOrientation(targetSideOrdinal)))
            && ((aPlayer.capabilities.isCreativeMode) || (!GT_ModHandler.isElectricItem(aStack))
                || (GT_ModHandler.canUseElectricItem(aStack, this.mCosts)))
            && (aBlock.rotateBlock(aWorld, aX, aY, aZ, ForgeDirection.getOrientation(targetSideOrdinal)))) {
            if (!aPlayer.capabilities.isCreativeMode) {
                ((GT_MetaGenerated_Tool) aItem).doDamage(aStack, this.mCosts);
            }
            GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_WRENCH, 1.0F, -1.0F, aX, aY, aZ);
            return true;
        }
        return false;
    }

    @Override
    public List<String> getAdditionalToolTips(GT_MetaBase_Item aItem, List<String> aList, ItemStack aStack) {
        aList.add(this.mTooltip);
        return aList;
    }
}
