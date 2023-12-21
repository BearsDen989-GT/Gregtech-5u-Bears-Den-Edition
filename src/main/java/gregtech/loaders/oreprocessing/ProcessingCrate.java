package gregtech.loaders.oreprocessing;

import static gregtech.api.recipe.RecipeMaps.packagerRecipes;
import static gregtech.api.recipe.RecipeMaps.unpackagerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.GT_Proxy;

public class ProcessingCrate implements gregtech.api.interfaces.IOreRecipeRegistrator {

    public ProcessingCrate() {
        OrePrefixes.crateGtDust.add(this);
        OrePrefixes.crateGtIngot.add(this);
        OrePrefixes.crateGtGem.add(this);
        OrePrefixes.crateGtPlate.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName,
        ItemStack aStack) {
        boolean aSpecialRecipeReq2 = aMaterial.mUnificatable && (aMaterial.mMaterialInto == aMaterial)
            && !aMaterial.contains(SubTag.NO_WORKING);
        switch (aPrefix) {
            case crateGtDust -> {
                if (GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L) != null) {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crateGtDust, aMaterial, 1L))
                        .duration(5 * SECONDS)
                        .eut(8)
                        .addTo(packagerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_OreDictUnificator.get(OrePrefixes.crateGtDust, aMaterial, 1L))
                        .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .duration(40 * SECONDS)
                        .eut(1)
                        .addTo(unpackagerRecipes);
                }
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 16L),
                    GT_Proxy.tBits,
                    new Object[] { "Xc", 'X', OrePrefixes.crateGtDust.get(aMaterial) });
            }
            case crateGtIngot -> {
                if (GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L) != null) {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crateGtIngot, aMaterial, 1L))
                        .duration(5 * SECONDS)
                        .eut(8)
                        .addTo(packagerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_OreDictUnificator.get(OrePrefixes.crateGtIngot, aMaterial, 1L))
                        .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .duration(40 * SECONDS)
                        .eut(1)
                        .addTo(unpackagerRecipes);
                }
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 16L),
                    GT_Proxy.tBits,
                    new Object[] { "Xc", 'X', OrePrefixes.crateGtIngot.get(aMaterial) });
            }
            case crateGtGem -> {
                if (GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L) != null) {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crateGtGem, aMaterial, 1L))
                        .duration(5 * SECONDS)
                        .eut(8)
                        .addTo(packagerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_OreDictUnificator.get(OrePrefixes.crateGtGem, aMaterial, 1L))
                        .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .duration(40 * SECONDS)
                        .eut(1)
                        .addTo(unpackagerRecipes);
                }
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 16L),
                    GT_Proxy.tBits,
                    new Object[] { "Xc", 'X', OrePrefixes.crateGtGem.get(aMaterial) });
            }
            case crateGtPlate -> {
                if (GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L) != null) {
                    GT_Values.RA.stdBuilder()
                        .itemInputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crateGtPlate, aMaterial, 1L))
                        .duration(5 * SECONDS)
                        .eut(8)
                        .addTo(packagerRecipes);
                    GT_Values.RA.stdBuilder()
                        .itemInputs(GT_OreDictUnificator.get(OrePrefixes.crateGtPlate, aMaterial, 1L))
                        .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 16L),
                            ItemList.Crate_Empty.get(1L))
                        .duration(40 * SECONDS)
                        .eut(1)
                        .addTo(unpackagerRecipes);
                }
                if (aSpecialRecipeReq2) GT_ModHandler.addCraftingRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 16L),
                    GT_Proxy.tBits,
                    new Object[] { "Xc", 'X', OrePrefixes.crateGtPlate.get(aMaterial) });
            }
            default -> {}
        }
    }
}
