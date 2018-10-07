package gregtech.api.enchants;

import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.util.GT_Config;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Utility;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class Enchantment_Radioactivity extends EnchantmentDamage {
    public static Enchantment_Radioactivity INSTANCE;

    public Enchantment_Radioactivity() {
        super(GT_Config.addIDConfig(ConfigCategories.IDs.enchantments, "Radioactivity", 14), 0, -1);
        GT_LanguageManager.addStringLocalization(getName(), "Radioactivity");
        MaterialsOld.Plutonium.setEnchantmentForTools(this, 1).setEnchantmentForArmors(this, 1);
        MaterialsOld.Uranium235.setEnchantmentForTools(this, 2).setEnchantmentForArmors(this, 2);
        MaterialsOld.Plutonium241.setEnchantmentForTools(this, 3).setEnchantmentForArmors(this, 3);
        MaterialsOld.NaquadahEnriched.setEnchantmentForTools(this, 4).setEnchantmentForArmors(this, 4);
        MaterialsOld.Naquadria.setEnchantmentForTools(this, 5).setEnchantmentForArmors(this, 5);
        INSTANCE = this;
    }

    @Override
    public int getMinEnchantability(int aLevel) {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getMaxEnchantability(int aLevel) {
        return 0;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public boolean canApply(ItemStack par1ItemStack) {
        return false;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return false;
    }

    @Override
    public void func_151367_b(EntityLivingBase aHurtEntity, Entity aDamagingEntity, int aLevel) {
        GT_Utility.applyRadioactivity(aHurtEntity, aLevel, 1);
    }

    @Override
    public String getName() {
        return "enchantment.damage.radioactivity";
    }
}