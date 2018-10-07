package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.MATERIAL_UNIT;
import static gregtech.api.enums.GT_Values.NULL_FLUID_STACK;
import static gregtech.api.enums.GT_Values.NULL_ITEM_STACK;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingTransforming
        implements IOreRecipeRegistrator {
    public ProcessingTransforming() {
        for (OrePrefixes tPrefix : OrePrefixes.values())
            if (((tPrefix.mMaterialAmount > 0L) && (!tPrefix.mIsContainer) && (!tPrefix.mIsEnchantable)) || (tPrefix == OrePrefixes.plank))
                tPrefix.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aPrefix == OrePrefixes.plank) aPrefix = OrePrefixes.plate;
        switch (aMaterial.name()) {
            case "Wood":
                RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.SeedOil.getFluid(GT_Utility.translateMaterialToAmount(aPrefix.mMaterialAmount, 120L, true)), NULL_FLUID_STACK, GT_OreDictUnificator.get(aPrefix, Materials.WoodSealed, 1L), NULL_ITEM_STACK, NULL_ITEM_STACK, null, 100, 8);
                RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.SeedOilLin.getFluid(GT_Utility.translateMaterialToAmount(aPrefix.mMaterialAmount, 80L, true)), NULL_FLUID_STACK, GT_OreDictUnificator.get(aPrefix, Materials.WoodSealed, 1L), NULL_ITEM_STACK, NULL_ITEM_STACK, null, 100, 8);
                RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.SeedOilHemp.getFluid(GT_Utility.translateMaterialToAmount(aPrefix.mMaterialAmount, 80L, true)), NULL_FLUID_STACK, GT_OreDictUnificator.get(aPrefix, Materials.WoodSealed, 1L), NULL_ITEM_STACK, NULL_ITEM_STACK, null, 100, 8);
                break;
            case "Iron":
                RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.FierySteel.getFluid(GT_Utility.translateMaterialToAmount(aPrefix.mMaterialAmount, 250L, true)), NULL_FLUID_STACK, GT_OreDictUnificator.get(aPrefix, Materials.FierySteel, 1L), NULL_ITEM_STACK, NULL_ITEM_STACK, null, 100, 8);
                RECIPE_ADDER_INSTANCE.addPolarizerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(aPrefix, Materials.IronMagnetic, 1L), (int) Math.max(16L, aPrefix.mMaterialAmount * 128L / MATERIAL_UNIT), 16);
                break;
            case "WroughtIron":
                RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.FierySteel.getFluid(GT_Utility.translateMaterialToAmount(aPrefix.mMaterialAmount, 225L, true)), NULL_FLUID_STACK, GT_OreDictUnificator.get(aPrefix, Materials.FierySteel, 1L), NULL_ITEM_STACK, NULL_ITEM_STACK, null, 100, 8);
                RECIPE_ADDER_INSTANCE.addPolarizerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(aPrefix, Materials.IronMagnetic, 1L), (int) Math.max(16L, aPrefix.mMaterialAmount * 128L / MATERIAL_UNIT), 16);
                break;
            case "Steel":
                RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.FierySteel.getFluid(GT_Utility.translateMaterialToAmount(aPrefix.mMaterialAmount, 200L, true)), NULL_FLUID_STACK, GT_OreDictUnificator.get(aPrefix, Materials.FierySteel, 1L), NULL_ITEM_STACK, NULL_ITEM_STACK, null, 100, 8);
                RECIPE_ADDER_INSTANCE.addPolarizerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(aPrefix, Materials.SteelMagnetic, 1L), (int) Math.max(16L, aPrefix.mMaterialAmount * 128L / MATERIAL_UNIT), 16);
                break;
            case "Neodymium":
                RECIPE_ADDER_INSTANCE.addPolarizerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(aPrefix, Materials.NeodymiumMagnetic, 1L), (int) Math.max(16L, aPrefix.mMaterialAmount * 128L / MATERIAL_UNIT), 256);
        }
    }
}
