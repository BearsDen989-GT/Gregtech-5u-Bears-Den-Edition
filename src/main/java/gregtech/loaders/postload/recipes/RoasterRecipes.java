package gregtech.loaders.postload.recipes;

import gregtech.api.enums.*;
import gregtech.api.util.GT_OreDictUnificator;


import static gregtech.api.recipe.RecipeMaps.roasterRecipes;

import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;


public class RoasterRecipes implements Runnable {

    @Override
    public void run() {

        //TODO Add Roaster RECIPES
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chalcopyrite, 1))
            .fluidInputs(Materials.Oxygen.getGas(4000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron , 1)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(1000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenite, 1))
            .fluidInputs(Materials.Oxygen.getGas(6000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Molybdenum, 1)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(200))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobaltite, 1))
            .fluidInputs(Materials.Oxygen.getGas(3000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Cobalt, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Arsenic , 1)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(1000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentlandite, 1))
            .fluidInputs(Materials.Oxygen.getGas(8000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Nickel, 2)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(1000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stibnite, 1))
            .fluidInputs(Materials.Oxygen.getGas(5000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Antimony, 1)

            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(1000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sphalerite, 1))
            .fluidInputs(Materials.Oxygen.getGas(4000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Zinc, 2)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(1000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
            .fluidInputs(Materials.Oxygen.getGas(2000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Silver, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lead , 1)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(500))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pyrite, 1))
            .fluidInputs(Materials.Oxygen.getGas(3000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron , 1)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(1000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1))
            .fluidInputs(Materials.Oxygen.getGas(8000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny , Materials.Sulfur, 1)
            )
            .outputChances(1000)
            .fluidOutputs(Materials.SulfurDioxide.getGas(3000))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1))
            .fluidInputs(Materials.Oxygen.getGas(2000))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall , Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Antimony , 1)
            )
            .fluidOutputs(Materials.SulfurDioxide.getGas(500))
            .eut(16)
            .duration(25 * SECONDS + 12 * TICKS)
            .addTo(roasterRecipes);
    }
}
