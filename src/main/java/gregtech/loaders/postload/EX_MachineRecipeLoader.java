package gregtech.loaders.postload;

import gregtech.api.enums.MaterialsOld;
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
		RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Tantalum, 9L), NULL_FLUID_STACK, NULL_FLUID_STACK, GT_OreDictUnificator.get(OrePrefixes.ingotHot, MaterialsOld.Tantaloy60, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.DarkAsh, 1L), (int) Math.max(MaterialsOld.Tantaloy60.getMass() / 80L, 1L) * MaterialsOld.Tantaloy60.mBlastFurnaceTemp, 480, MaterialsOld.Tantaloy60.mBlastFurnaceTemp);
		RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Tantaloy60, 1L), NULL_FLUID_STACK, NULL_FLUID_STACK, GT_OreDictUnificator.get(OrePrefixes.ingotHot, MaterialsOld.Tantaloy61, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.DarkAsh, 1L), (int) Math.max(MaterialsOld.Tantaloy61.getMass() / 80L, 1L) * MaterialsOld.Tantaloy61.mBlastFurnaceTemp, 480, MaterialsOld.Tantaloy61.mBlastFurnaceTemp);
		RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Uranium, 9L), NULL_FLUID_STACK, NULL_FLUID_STACK, GT_OreDictUnificator.get(OrePrefixes.ingotHot, MaterialsOld.Staballoy, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Carbon, 1L), (int) Math.max(MaterialsOld.Staballoy.getMass() / 80L, 1L) * MaterialsOld.Staballoy.mBlastFurnaceTemp, 1000, MaterialsOld.Staballoy.mBlastFurnaceTemp);
	}


}
