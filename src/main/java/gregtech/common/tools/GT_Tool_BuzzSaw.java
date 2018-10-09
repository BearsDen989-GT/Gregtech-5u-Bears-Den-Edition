package gregtech.common.tools;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Tool;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class GT_Tool_BuzzSaw
        extends GT_Tool_Saw {
    public int getToolDamagePerContainerCraft() {
        return 100;
    }

    public int getToolDamagePerEntityAttack() {
        return 300;
    }

    public float getBaseDamage() {
        return 1.0F;
    }

    public float getMaxDurabilityMultiplier() {
        return 1.0F;
    }

    public String getCraftingSound() {
        return GregTech_API.sSoundList.get(104);
    }

    public String getEntityHitSound() {
        return GregTech_API.sSoundList.get(105);
    }

    public String getBreakingSound() {
        return GregTech_API.sSoundList.get(0);
    }

    public String getMiningSound() {
        return GregTech_API.sSoundList.get(104);
    }

    public boolean isMinableBlock(Block aBlock, byte aMetaData) {
        return false;
    }

    public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
        return !aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).getTextureSet().mTextures[gregtech.api.enums.OrePrefixes.toolHeadBuzzSaw.mTextureIndex] : Textures.ItemIcons.HANDLE_BUZZSAW;
    }

    public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
        return !aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).getRGBa() : GT_MetaGenerated_Tool.getSecondaryMaterial(aStack).getRGBa();
    }

    public IChatComponent getDeathMessage(EntityLivingBase aPlayer, EntityLivingBase aEntity) {
        return new ChatComponentText(EnumChatFormatting.RED + aEntity.getCommandSenderName() + EnumChatFormatting.WHITE + " got buzzed by " + EnumChatFormatting.GREEN + aPlayer.getCommandSenderName() + EnumChatFormatting.WHITE);
    }
}
