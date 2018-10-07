package gregtech.loaders.oreprocessing;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.MOD_ID_RC;
import static gregtech.api.enums.GT_Values.NULL_FLUID_STACK;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingLog implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingLog() {
        OrePrefixes.log.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.equals("logRubber")) {
            RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(1L, aStack), null, null, MaterialsOld.Methane.getGas(60L), ItemList.IC2_Resin.get(1L), GT_ModHandler.getIC2Item("plantBall", 1L), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Carbon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 1L), null, null, new int[]{5000, 3750, 2500, 2500}, 200, 20);
            GT_ModHandler.addSawmillRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.IC2_Resin.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 16L));
            GT_ModHandler.addExtractionRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Rubber, 1L));
            GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 6L), ItemList.IC2_Resin.get(1L), 33, false);
        } else {
            GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 1L), 80, false);
        }

        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stickLong, MaterialsOld.Wood, 2L), gregtech.api.util.GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | gregtech.api.util.GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"sLf", 'L', GT_Utility.copyAmount(1L, aStack)});
        RECIPE_ADDER_INSTANCE.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.stickLong, MaterialsOld.Wood, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 2L), 160, 8);
        RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), MaterialsOld.SeedOil.getFluid(50L), ItemList.FR_Stick.get(1L), 16, 8);
        RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(8L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), MaterialsOld.SeedOil.getFluid(250L), ItemList.FR_Casing_Impregnated.get(1L), 64, 16);
        RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), MaterialsOld.Creosote.getFluid(1000L), NULL_FLUID_STACK, GT_ModHandler.getModItem(MOD_ID_RC, "tile.railcraft.cube", 1L, 8), null, null, null, 16, 16);
        RECIPE_ADDER_INSTANCE.addPyrolyseRecipe(GT_Utility.copyAmount(16, aStack), null, 1,  (GT_OreDictUnificator.get(OrePrefixes.gem, MaterialsOld.Charcoal, 20)), MaterialsOld.Creosote.getFluid(4000), 640, 30);

        short aMeta = (short) aStack.getItemDamage();

        if (aMeta == Short.MAX_VALUE) {
            if ((GT_Utility.areStacksEqual(GT_ModHandler.getSmeltingOutput(GT_Utility.copyAmount(1L, aStack), false, null), new ItemStack(Items.coal, 1, 1)))) {
                if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "wood2charcoalsmelting", false)) {
                    GT_ModHandler.removeFurnaceSmelting(GT_Utility.copyAmount(1L, aStack));
                }
            }
            for (int i = 0; i < OreDictionary.WILDCARD_VALUE; i++) {
                if ((GT_Utility.areStacksEqual(GT_ModHandler.getSmeltingOutput(new ItemStack(aStack.getItem(), 1, i), false, null), new ItemStack(Items.coal, 1, 1)))) {
                    if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "wood2charcoalsmelting", false)) {
                        GT_ModHandler.removeFurnaceSmelting(new ItemStack(aStack.getItem(), 1, i));
                    }
                }
                ItemStack tStack = GT_ModHandler.getRecipeOutput(new ItemStack(aStack.getItem(), 1, i));
                if (tStack == null) {
                    if (i >= 16) {
                        break;
                    }
                }
                else
                {

                    ItemStack tPlanks = GT_Utility.copy(tStack);
                    tPlanks.stackSize = (tPlanks.stackSize * 3 / 2);
                    RECIPE_ADDER_INSTANCE.addCutterRecipe(new ItemStack(aStack.getItem(), 1, i), MaterialsOld.Lubricant.getFluid(1L), GT_Utility.copy(tPlanks), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 1L), 200, 8);
                    RECIPE_ADDER_INSTANCE.addCutterRecipe(new ItemStack(aStack.getItem(), 1, i), GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 2L), 200, 8);
                    GT_ModHandler.addSawmillRecipe(new ItemStack(aStack.getItem(), 1, i), tPlanks, GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 1L));
                    GT_ModHandler.removeRecipe(new ItemStack(aStack.getItem(), 1, i));
                    GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), new Object[]{"s", "L", 'L', new ItemStack(aStack.getItem(), 1, i)});
                    GT_ModHandler.addShapelessCraftingRecipe(GT_Utility.copyAmount(tStack.stackSize / (GT_Mod.gregtechproxy.mNerfedWoodPlank ? 2 : 1), tStack), new Object[]{new ItemStack(aStack.getItem(), 1, i)});
                }
            }
        } else {
            if ((GT_Utility.areStacksEqual(GT_ModHandler.getSmeltingOutput(GT_Utility.copyAmount(1L, aStack), false, null), new ItemStack(Items.coal, 1, 1)))) {
                 if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "wood2charcoalsmelting", false)) {
                    GT_ModHandler.removeFurnaceSmelting(GT_Utility.copyAmount(1L, aStack));
                }
            }
            ItemStack tStack = GT_ModHandler.getRecipeOutput(GT_Utility.copyAmount(1L, aStack));
            if (tStack != null) {
                ItemStack tPlanks = GT_Utility.copy(tStack);
                tPlanks.stackSize = (tPlanks.stackSize * 3 / 2);
                RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), MaterialsOld.Lubricant.getFluid(1L), GT_Utility.copy(tPlanks), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 1L), 200, 8);
                RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 2L), 200, 8);
                GT_ModHandler.addSawmillRecipe(GT_Utility.copyAmount(1L, aStack), tPlanks, GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Wood, 1L));
                GT_ModHandler.removeRecipe(GT_Utility.copyAmount(1L, aStack));
                GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), new Object[]{"s", "L", 'L', GT_Utility.copyAmount(1L, aStack)});
                GT_ModHandler.addShapelessCraftingRecipe(GT_Utility.copyAmount(tStack.stackSize / (GT_Mod.gregtechproxy.mNerfedWoodPlank ? 2 : 1), tStack), new Object[]{GT_Utility.copyAmount(1L, aStack)});
            }
        }

        if ((GT_Utility.areStacksEqual(GT_ModHandler.getSmeltingOutput(GT_Utility.copyAmount(1L, aStack), false, null), new ItemStack(Items.coal, 1, 1)))) {
            if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "wood2charcoalsmelting", false))
                GT_ModHandler.removeFurnaceSmelting(GT_Utility.copyAmount(1L, aStack));
        }
    }
}