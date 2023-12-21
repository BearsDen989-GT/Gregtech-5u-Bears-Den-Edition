package gregtech.api.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import gregtech.api.enums.SoundResource;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;

public class GT_Spray_Bug_Item extends GT_Tool_Item {

    public GT_Spray_Bug_Item(String aUnlocalized, String aEnglish, int aMaxDamage, int aEntityDamage) {
        super(
            aUnlocalized,
            aEnglish,
            "A very 'buggy' Spray",
            aMaxDamage,
            aEntityDamage,
            true); /*
                    * addToEffectiveList(EntityCaveSpider.class.getName());
                    * addToEffectiveList(EntitySpider.class.getName()); addToEffectiveList("EntityTFHedgeSpider");
                    * addToEffectiveList("EntityTFKingSpider"); addToEffectiveList("EntityTFSwarmSpider");
                    * addToEffectiveList("EntityTFTowerBroodling"); addToEffectiveList("EntityTFFireBeetle");
                    * addToEffectiveList("EntityTFSlimeBeetle"); setCraftingSound(Sounds.IC2_TOOLS_PAINTER);
                    * setBreakingSound(Sounds.IC2_TOOLS_PAINTER); setEntityHitSound(Sounds.IC2_TOOLS_PAINTER);
                    * setUsageAmounts(8, 4, 1);
                    */
    }

    /*
     * @Override public void onHitEntity(Entity aEntity) { if (aEntity instanceof EntityLiving) {
     * ((EntityLiving)aEntity).addPotionEffect(new PotionEffect(Potion.poison.getId(), 60, 1, false));
     * ((EntityLiving)aEntity).addPotionEffect(new PotionEffect(Potion.confusion.getId(), 600, 1, false)); } }
     * @Override public ItemStack getEmptiedItem(ItemStack aStack) { return ItemList.Spray_Empty.get(1); }
     */
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
            if (aTileEntity instanceof ic2.api.crops.ICropTile) {
                int tCropBefore = ((ic2.api.crops.ICropTile) aTileEntity).getWeedExStorage();
                if (tCropBefore <= 100 && GT_ModHandler.damageOrDechargeItem(aStack, 1, 1000, aPlayer)) {
                    ((ic2.api.crops.ICropTile) aTileEntity).setWeedExStorage(tCropBefore + 100);
                    GT_Utility.sendSoundToPlayers(aWorld, SoundResource.IC2_TOOLS_PAINTER, 1.0F, -1, aX, aY, aZ);
                    return true;
                }
            }
        } catch (Throwable e) {
            /* Do nothing */
        }

        return false;
    }
}
