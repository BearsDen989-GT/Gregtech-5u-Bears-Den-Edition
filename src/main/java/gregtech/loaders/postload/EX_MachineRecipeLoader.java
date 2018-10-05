package gregtech.loaders.postload;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_OreDictUnificator;

import static gregtech.api.enums.GT_Values.NULL_FLUID_STACK;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;


public class EX_MachineRecipeLoader {

	@SuppressWarnings("unused")
	private static MaterialStack[][] mAlloySmelterList;

	public void LOAD_RECIPES(){
		run();
	}

	private final static void run(){

		// Solid EBF Recipes
		RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 9L), NULL_FLUID_STACK, NULL_FLUID_STACK, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantaloy60, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), (int) Math.max(Materials.Tantaloy60.getMass() / 80L, 1L) * Materials.Tantaloy60.mBlastFurnaceTemp, 480, Materials.Tantaloy60.mBlastFurnaceTemp);
		RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantaloy60, 1L), NULL_FLUID_STACK, NULL_FLUID_STACK, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantaloy61, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), (int) Math.max(Materials.Tantaloy61.getMass() / 80L, 1L) * Materials.Tantaloy61.mBlastFurnaceTemp, 480, Materials.Tantaloy61.mBlastFurnaceTemp);
		RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uranium, 9L), NULL_FLUID_STACK, NULL_FLUID_STACK, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Staballoy, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Carbon, 1L), (int) Math.max(Materials.Staballoy.getMass() / 80L, 1L) * Materials.Staballoy.mBlastFurnaceTemp, 1000, Materials.Staballoy.mBlastFurnaceTemp);
	}


}
