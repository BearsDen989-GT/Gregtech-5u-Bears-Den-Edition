package gregtech.common.tools;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Tool;

public class GT_Tool_Wrench_HV extends GT_Tool_Wrench_LV {

    @Override
    public int getToolDamagePerBlockBreak() {
        return 800;
    }

    @Override
    public int getToolDamagePerDropConversion() {
        return 1600;
    }

    @Override
    public int getToolDamagePerContainerCraft() {
        return 12800;
    }

    @Override
    public int getToolDamagePerEntityAttack() {
        return 3200;
    }

    @Override
    public int getBaseQuality() {
        return 1;
    }

    @Override
    public float getBaseDamage() {
        return 2.0F;
    }

    @Override
    public float getSpeedMultiplier() {
        return 4.0F;
    }

    @Override
    public float getMaxDurabilityMultiplier() {
        return 4.0F;
    }

    @Override
    public boolean canBlock() {
        return false;
    }

    @Override
    public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead
            ? GT_MetaGenerated_Tool.getPrimaryMaterial(
                aStack).mIconSet.mTextures[gregtech.api.enums.OrePrefixes.toolHeadWrench.mTextureIndex]
            : Textures.ItemIcons.POWER_UNIT_HV;
    }

    @Override
    public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mRGBa
            : GT_MetaGenerated_Tool.getSecondaryMaterial(aStack).mRGBa;
    }
}
