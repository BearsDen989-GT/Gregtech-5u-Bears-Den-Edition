package gregtech.loaders.oreprocessing;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProcessingLog implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingLog() {
        OrePrefixes.log.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.equals("logRubber")) {
            GT_Values.RA.addCentrifugeRecipe(GT_Utility.copyAmount(1L, aStack), null, null, Materials.Methane.getGas(60L), ItemList.IC2_Resin.get(1L), GT_ModHandler.getIC2Item("plantBall", 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), null, null, new int[]{5000, 3750, 2500, 2500}, 200, 20);
            GT_ModHandler.addSawmillRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.IC2_Resin.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 16L));
            GT_ModHandler.addExtractionRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 1L));
            GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 6L), ItemList.IC2_Resin.get(1L), 33, false);
        } else {
            GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 6L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), 80, false);
        }

        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Wood, 2L), gregtech.api.util.GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | gregtech.api.util.GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"sLf", 'L', GT_Utility.copyAmount(1L, aStack)});
        GT_Values.RA.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Wood, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L), 160, 8);
        GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), Materials.SeedOil.getFluid(50L), ItemList.FR_Stick.get(1L), 16, 8);
        GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(8L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), Materials.SeedOil.getFluid(250L), ItemList.FR_Casing_Impregnated.get(1L), 64, 16);
        GT_Values.RA.addChemicalBathRecipe(GT_Utility.copyAmount(1L, aStack), Materials.Creosote.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_RC, "tile.railcraft.cube", 1L, 8), null, null, null, 16, 16);
        GT_Values.RA.addPyrolyseRecipe(GT_Utility.copyAmount(16, aStack), null, 1,  (GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Charcoal, 20)), Materials.Creosote.getFluid(4000), 640, 30);

        short aMeta = (short) aStack.getItemDamage();

        if (aMeta == Short.MAX_VALUE) {
            if ((GT_Utility.areStacksEqual(GT_ModHandler.getSmeltingOutput(GT_Utility.copyAmount(1L, aStack), false, null), new ItemStack(Items.coal, 1, 1)))) {
                if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "wood2charcoalsmelting", false)) {
                    GT_ModHandler.removeFurnaceSmelting(GT_Utility.copyAmount(1L, aStack));
                }
            }
            for (int i = 0; i < GT_Values.W; i++) {
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
                    GT_Values.RA.addCutterRecipe(new ItemStack(aStack.getItem(), 1, i), Materials.Lubricant.getFluid(1L), GT_Utility.copy(tPlanks), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), 200, 8);
                    GT_Values.RA.addCutterRecipe(new ItemStack(aStack.getItem(), 1, i), GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L), 200, 8);
                    GT_ModHandler.addSawmillRecipe(new ItemStack(aStack.getItem(), 1, i), tPlanks, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L));
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
                GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), Materials.Lubricant.getFluid(1L), GT_Utility.copy(tPlanks), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), 200, 8);
                GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L), 200, 8);
                GT_ModHandler.addSawmillRecipe(GT_Utility.copyAmount(1L, aStack), tPlanks, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L));
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