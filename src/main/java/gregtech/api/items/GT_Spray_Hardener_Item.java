package gregtech.api.items;

import static gregtech.api.enums.GT_Values.D1;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import gregtech.api.enums.SoundResource;
import gregtech.api.metatileentity.BaseMetaPipeEntity;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;

public class GT_Spray_Hardener_Item extends GT_Tool_Item {

    public GT_Spray_Hardener_Item(String aUnlocalized, String aEnglish, int aMaxDamage, int aEntityDamage) {
        super(
            aUnlocalized,
            aEnglish,
            "Construction Foam Hardener",
            aMaxDamage,
            aEntityDamage,
            true); /*
                    * setCraftingSound(Sounds.IC2_TOOLS_PAINTER); setBreakingSound(Sounds.IC2_TOOLS_PAINTER);
                    * setEntityHitSound(Sounds.IC2_TOOLS_PAINTER); setUsageAmounts(16, 3, 1);
                    */
    }

    @Override
    public boolean onItemUseFirst(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ,
        int ordinalSide, float hitX, float hitY, float hitZ) {
        super.onItemUseFirst(aStack, aPlayer, aWorld, aX, aY, aZ, ordinalSide, hitX, hitY, hitZ);
        if (aWorld.isRemote) {
            return false;
        }
        Block aBlock = aWorld.getBlock(aX, aY, aZ);
        if (aBlock == null) return false;
        // byte aMeta = (byte)aWorld.getBlockMetadata(aX, aY, aZ);
        TileEntity aTileEntity = aWorld.getTileEntity(aX, aY, aZ);

        try {
            if (GT_Utility.getClassName(aTileEntity)
                .startsWith("TileEntityCable")) {
                if (GT_Utility.getPublicField(aTileEntity, "foamed")
                    .getByte(aTileEntity) == 1) {
                    if (GT_ModHandler.damageOrDechargeItem(aStack, 1, 1000, aPlayer)) {
                        GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_PAINTER, 1.0F, -1, aX, aY, aZ);
                        GT_Utility.callPublicMethod(aTileEntity, "changeFoam", (byte) 2);
                        return true;
                    }
                }
                return false;
            }
        } catch (Throwable e) {
            if (D1) e.printStackTrace(GT_Log.err);
        }

        ItemStack tStack1 = GT_ModHandler.getIC2Item("constructionFoam", 1),
            tStack2 = GT_ModHandler.getIC2Item("constructionFoamWall", 1);
        if (tStack1 != null && tStack1.isItemEqual(new ItemStack(aBlock))
            && tStack2 != null
            && tStack2.getItem() instanceof ItemBlock) {
            if (GT_ModHandler.damageOrDechargeItem(aStack, 1, 1000, aPlayer)) {
                GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_PAINTER, 1.0F, -1, aX, aY, aZ);
                aWorld.setBlock(aX, aY, aZ, GT_Utility.getBlockFromStack(tStack2), 7, 3);
            }
            return true;
        }

        if (aTileEntity instanceof BaseMetaPipeEntity
            && (((BaseMetaPipeEntity) aTileEntity).mConnections & -64) == 64) {
            if (GT_ModHandler.damageOrDechargeItem(aStack, 1, 1000, aPlayer)) {
                GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_PAINTER, 1.0F, -1, aX, aY, aZ);
                ((BaseMetaPipeEntity) aTileEntity).mConnections = (byte) ((((BaseMetaPipeEntity) aTileEntity).mConnections
                    & ~64) | -128);
            }
            return true;
        }

        return false;
    }
}
