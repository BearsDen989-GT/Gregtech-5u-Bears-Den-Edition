package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.MATERIAL_UNIT;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingFood implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingFood() {
        OrePrefixes.food.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.equals("foodCheese")) {
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Cheese.get(4L), 64, 4);
            GT_OreDictUnificator.addItemData(aStack, new gregtech.api.objects.ItemData(MaterialsOld.Cheese, MATERIAL_UNIT));
        } else if (aOreDictName.equals("foodDough")) {
            GT_ModHandler.removeFurnaceSmelting(aStack);
            RECIPE_ADDER_INSTANCE.addBenderRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Food_Flat_Dough.get(1L), 16, 4);

            RECIPE_ADDER_INSTANCE.addMixerRecipe(aStack, GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Sugar, 1L), null, null, null, null, ItemList.Food_Dough_Sugar.get(2L), 32, 8);
            RECIPE_ADDER_INSTANCE.addMixerRecipe(aStack, GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Cocoa, 1L), null, null, null, null, ItemList.Food_Dough_Chocolate.get(2L), 32, 8);
            RECIPE_ADDER_INSTANCE.addMixerRecipe(aStack, GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Chocolate, 1L), null, null, null, null, ItemList.Food_Dough_Chocolate.get(2L), 32, 8);

            RECIPE_ADDER_INSTANCE.addFormingPressRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Shape_Mold_Bun.get(0L), ItemList.Food_Raw_Bun.get(1L), 128, 4);
            RECIPE_ADDER_INSTANCE.addFormingPressRecipe(GT_Utility.copyAmount(2L, aStack), ItemList.Shape_Mold_Bread.get(0L), ItemList.Food_Raw_Bread.get(1L), 256, 4);
            RECIPE_ADDER_INSTANCE.addFormingPressRecipe(GT_Utility.copyAmount(3L, aStack), ItemList.Shape_Mold_Baguette.get(0L), ItemList.Food_Raw_Baguette.get(1L), 384, 4);
        }
    }
}
