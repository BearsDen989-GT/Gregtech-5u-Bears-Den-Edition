package gregtech.common.tools;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Tool;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public class GT_Tool_Multi
        extends GT_Tool {
    public int getToolDamagePerBlockBreak() {
        return 100;
    }

    public int getToolDamagePerDropConversion() {
        return 100;
    }

    public int getToolDamagePerContainerCraft() { return 400; }

    public int getToolDamagePerEntityAttack() { return 200; }

    public int getBaseQuality() { return 0; }

    public float getBaseDamage() { return 2.0F; }

    public float getSpeedMultiplier() { return 1.0F; }

    public float getMaxDurabilityMultiplier() { return 1.0F; }

    public String getCraftingSound() { return null; }

    public String getEntityHitSound() { return null; }

    public String getBreakingSound() { return GregTech_API.sSoundList.get(Integer.valueOf(0)); }

    public String getMiningSound() { return null; }

    public boolean canBlock() { return true; }

    public boolean isCrowbar() {
        return false;
    }

    public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? Textures.ItemIcons.MULTI :  null;
    }

    public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
        return aIsToolHead ? GT_MetaGenerated_Tool.getPrimaryMaterial(aStack).mRGBa : GT_MetaGenerated_Tool.getSecondaryMaterial(aStack).mRGBa;
    }

    public boolean isMinableBlock(Block aBlock, byte aMetaData) {
        String tTool = aBlock.getHarvestTool(aMetaData);
        return ((tTool != null) && (tTool.equals("screwdriver"))) || (aBlock.getMaterial() == Material.circuits);
    }

    //public boolean isMinableBlock(Block aBlock, byte aMetaData) {
    //    String tTool = aBlock.getHarvestTool(aMetaData);
    //    return (tTool != null) && (tTool.equals("screwdriver")) ||
    //            (tTool.equals("cutter") ||
    //                    (tTool.equals("wrench") ||
    //                             (tTool.equals("saw") ||
    //                                     (tTool.equals("sword")))));
    //}

    public IChatComponent getDeathMessage(EntityLivingBase aPlayer, EntityLivingBase aEntity) {
        return new ChatComponentText(EnumChatFormatting.GREEN + aPlayer.getCommandSenderName() + EnumChatFormatting.WHITE + " M-M-M-M-Multi Killed " + EnumChatFormatting.RED + aEntity.getCommandSenderName() + EnumChatFormatting.WHITE);
    }
}
