package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingIngot1 implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingIngot1() {
        OrePrefixes.ingot.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial.mFuelPower > 0) {
            RECIPE_ADDER_INSTANCE.addFuel(GT_Utility.copyAmount(1L, aStack), null, aMaterial.mFuelPower, aMaterial.mFuelType);
        }
        RECIPE_ADDER_INSTANCE.addBoxingRecipe(GT_Utility.copyAmount(16L, aStack), ItemList.Crate_Empty.get(1L), GT_OreDictUnificator.get(OrePrefixes.crateGtIngot, aMaterial, 1L), 100, 8);
        RECIPE_ADDER_INSTANCE.addUnboxingRecipe(GT_OreDictUnificator.get(OrePrefixes.crateGtIngot, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 16L), ItemList.Crate_Empty.get(1L), 800, 1);

        if (aMaterial.mStandardMoltenFluid != null)
            RECIPE_ADDER_INSTANCE.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ingot.get(0L), aMaterial.getMolten(144L), GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L), 32, 8);
        GT_RecipeRegistrator.registerReverseFluidSmelting(aStack, aMaterial, aPrefix.mMaterialAmount, null);
        GT_RecipeRegistrator.registerReverseMacerating(aStack, aMaterial, aPrefix.mMaterialAmount, null, null, null, false);
        if (aMaterial.mSmeltInto.mArcSmeltInto != aMaterial) {
            GT_RecipeRegistrator.registerReverseArcSmelting(GT_Utility.copyAmount(1L, aStack), aMaterial, aPrefix.mMaterialAmount, null, null, null);
        }
        if (!aMaterial.contains(SubTag.NO_SMASHING)) {
            RECIPE_ADDER_INSTANCE.addWiremillRecipe(GT_Utility.copyAmount(1L, aStack), GT_Utility.copy(GT_OreDictUnificator.get(OrePrefixes.wireGt01, aMaterial, 2L), GT_OreDictUnificator.get(OrePrefixes.wireFine, aMaterial, 8L)), 100, 4);
            RECIPE_ADDER_INSTANCE.addForgeHammerRecipe(GT_Utility.copyAmount(3L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 2L), (int) Math.max(aMaterial.getMass(), 1L), 16);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 1L, 1L), 24);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(2L, aStack), GT_OreDictUnificator.get(OrePrefixes.plateDouble, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 2L, 1L), 96);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(3L, aStack), GT_OreDictUnificator.get(OrePrefixes.plateTriple, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 3L, 1L), 96);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(4L, aStack), GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 4L, 1L), 96);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(5L, aStack), GT_OreDictUnificator.get(OrePrefixes.plateQuintuple, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 5L, 1L), 96);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(9L, aStack), GT_OreDictUnificator.get(OrePrefixes.plateDense, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 9L, 1L), 96);
        }


        if (!OrePrefixes.block.isIgnored(aMaterial))
            GT_ModHandler.addCompressionRecipe(GT_Utility.copyAmount(9L, aStack), GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L));
        if (!aMaterial.contains(SubTag.NO_WORKING))
            RECIPE_ADDER_INSTANCE.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.stick, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, aMaterial.mMacerateInto, 2L), (int) Math.max(aMaterial.getMass() * 5L, 1L), 16);
        if (!aMaterial.contains(SubTag.NO_SMELTING)) {
            RECIPE_ADDER_INSTANCE.addAlloySmelterRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Shape_Mold_Nugget.get(0L), GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial, 9L), 100, 1);
            if ((GT_ModHandler.getSmeltingOutput(aStack, false, null) == null) && (GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial.mSmeltInto, 1L) != null) && (!GT_ModHandler.addSmeltingRecipe(aStack, GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial.mSmeltInto, 9L))))
                GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial.mSmeltInto, 9L), new Object[]{aOreDictName});
        }
        ItemStack tStack;
        if ((null != (tStack = GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 1L))) && (
                (aMaterial.mBlastFurnaceRequired) || (aMaterial.contains(SubTag.NO_SMELTING)))) {
            GT_ModHandler.removeFurnaceSmelting(tStack);
        }

        GT_RecipeRegistrator.registerUsagesForMaterials(GT_Utility.copyAmount(1L, aStack), OrePrefixes.plate.get(aMaterial).toString(), !aMaterial.contains(SubTag.NO_SMASHING));

        if (aMaterial == MaterialsOld.Mercury) {
            System.err.println("Quicksilver Ingots?, Don't tell me there is an Armor made of that highly toxic and very likely to be melting Material!");
        }
    }
}
