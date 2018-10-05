package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingGemChipped implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingGemChipped() {
        OrePrefixes.gemChipped.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial.mFuelPower > 0)
            RECIPE_ADDER_INSTANCE.addFuel(GT_Utility.copyAmount(1L, aStack), null, aMaterial.mFuelPower / 2, aMaterial.mFuelType);
        if (!aMaterial.contains(gregtech.api.enums.SubTag.NO_WORKING))
            RECIPE_ADDER_INSTANCE.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.bolt, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, aMaterial, 1L), (int) Math.max(aMaterial.getMass(), 1L), 8);
    }
}
