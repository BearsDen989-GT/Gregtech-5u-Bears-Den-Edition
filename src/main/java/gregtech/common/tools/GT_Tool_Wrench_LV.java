package gregtech.common.tools;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Tool;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class GT_Tool_Wrench_LV
        extends GT_Tool_Wrench {
    public float getNormalDamageAgainstEntity(float aOriginalDamage, Entity aEntity, ItemStack aStack, EntityPlayer aPlayer) {
        return aOriginalDamage;
    }

    public int getToolDamagePerBlockBreak() {
        return 50;
    }

    public int getToolDamagePerDropConversion() {
        return 100;
    }

    public int getToolDamagePerContainerCraft() {
        return 800;
    }

    public int getToolDamagePerEntityAttack() {
        return 200;
    }

    public int getBaseQuality() {
        return 0;
    }

    public float getBaseDamage() {
        return 1.0F;
    }

    public float getSpeedMultiplier() {
        return 2.0F;
    }

    public float getMaxDurabilityMultiplier() {
        return 1.0F;
    }

    public ItemStack getBrokenItem(ItemStack aStack) {
        return (ItemList.ToolHull_LV.get(1L));
    }

    public boolean canBlock() {
        return false;
    }

    public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).getTextureSet().mTextures[gregtech.api.enums.OrePrefixes.toolHeadWrench.mTextureIndex] : Textures.ItemIcons.POWER_UNIT_LV;
    }

    public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).getRGBa() : GT_MetaGenerated_Tool.getSecondaryMaterial(aStack).getRGBa();
    }
}
