package gregtech.loaders.postload;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.EMPTY_STRING;
import static gregtech.api.enums.GT_Values.MOD_ID_GS;
import static gregtech.api.enums.GT_Values.MOD_ID_RC;

public class GT_CraftingRecipeLoader
        implements Runnable {

    private static final String RCA = "machine.alpha";
    private static final String RCB = "machine.beta";
    private static final String RCGEAR = "part.gear";
    private static final String GFIBER = "glassFiberCableItem";
    private static final String LCRYST = "lapotronCrystal";
    private static final String IC2M = "machine";
    private static final String MVT = "mvTransformer";
    private static final String HVT = "hvTransformer";
    private static final String LUM = "luminator";
    private static final String FREQT = "frequencyTransmitter";
    private static final String ODS = "odScanner";
    private static final String DRILL1 = "diamondDrill";
    private static final String DRILL2 = "miningDrill";
    private static final String ECTOOLS = "electricsteeltools";
    private static final String ADVJET = "advJetpack";
    private static final String GSITEM = "itemSimpleItem";
    private static final String DOUGH = "foodDough";

    public void run() {
        GT_Log.out.println("GT_Mod: Adding nerfed Vanilla Recipes.");
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bucket, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"XhX", " X ", 'X', OrePrefixes.plate.get(Materials.AnyIron)});
        if (!GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Bucket", true)) {
            GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bucket, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"X X", " X ", 'X', OrePrefixes.ingot.get(Materials.AnyIron)});
        }
        ItemStack tMat = new ItemStack(Items.iron_ingot);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.PressurePlate", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, null, null, null, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XXh", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.AnyIron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Door", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, tMat, tMat, null, tMat, tMat, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XX ", "XXh", "XX ", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.AnyIron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Cauldron", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, null, tMat, tMat, null, tMat, tMat, tMat, tMat))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"X X", "XhX", "XXX", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.AnyIron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Hopper", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, null, tMat, tMat, new ItemStack(Blocks.chest, 1, 0), tMat, null, tMat, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XwX", "XCX", " X ", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.AnyIron), 'C', "craftingChest"});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Bars", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, tMat, tMat, tMat, tMat, null, null, null))) {
                tStack.stackSize /= 2;
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{" w ", "XXX", "XXX", 'X', OrePrefixes.stick.get(Materials.AnyIron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.AnyIron)});
            }
        }
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ironFence", 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"XXX", "XXX", " w ", 'X', OrePrefixes.stick.get(Materials.AnyIron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.AnyIron)});

        tMat = new ItemStack(Items.gold_ingot);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Gold.PressurePlate", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, null, null, null, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XXh", 'X', OrePrefixes.plate.get(Materials.Gold), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.Gold)});
            }
        }
        tMat = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Rubber.Sheet", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, tMat, tMat, tMat, tMat, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XXX", "XXX", 'X', OrePrefixes.plate.get(Materials.Rubber)});
            }
        }
        GT_ModHandler.removeRecipeByOutput(ItemList.Bottle_Empty.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Spray_WeedEx.get(1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reBattery", 1L));

        ItemStack tStack = GT_ModHandler.removeRecipe(new ItemStack(Blocks.planks, 1, 0), null, null, new ItemStack(Blocks.planks, 1, 0));
        if (tStack != null) {
            GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"s", "P", "P", 'P', OrePrefixes.plank.get(Materials.Wood)});
            GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize / 2 : tStack.stackSize, tStack), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"P", "P", 'P', OrePrefixes.plank.get(Materials.Wood)});
        }
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PP", 'P', OrePrefixes.plank.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_button, 2, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"S", "S", 'S', OrePrefixes.stone});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stone_pressure_plate, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"SS", 'S', OrePrefixes.stone});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.stone_button, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stone});

        GT_Log.out.println("GT_Mod: Adding Vanilla Convenience Recipes.");

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stonebrick, 1, 3), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"f", "X", 'X', new ItemStack(Blocks.double_stone_slab, 1, 8)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.gravel, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.cobblestone, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.cobblestone, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.stone, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stonebrick, 1, 2), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.stonebrick, 1, 0)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 8), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.double_stone_slab, 1, 0)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.double_stone_slab, 1, 8)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.cobblestone, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 3)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.brick_block, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 4)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stonebrick, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 5)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.nether_brick, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 6)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.quartz_block, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 7)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 8), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 8)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 1)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 2), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 2)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 3), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 3)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 4), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 4)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 5), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 5)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 6), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 6)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 7), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 7)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.stick, 2, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"s", "X", 'X', new ItemStack(Blocks.deadbush, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.stick, 2, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"s", "X", 'X', new ItemStack(Blocks.tallgrass, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.stick, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"s", "X", 'X', OrePrefixes.treeSapling});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.comparator, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" T ", "TQT", "SSS", 'Q', OreDictNames.craftingQuartz, 'S', OrePrefixes.stoneSmooth, 'T', OreDictNames.craftingRedstoneTorch});

        GT_Log.out.println("GT_Mod: Adding Tool Recipes.");
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{" h ", "PwP", "WPW", 'P', OrePrefixes.plate.get(Materials.AnyIron), 'W', ItemList.Component_Minecart_Wheels_Iron});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" h ", "PwP", "WPW", 'P', OrePrefixes.plate.get(Materials.Steel), 'W', ItemList.Component_Minecart_Wheels_Steel});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chest_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.furnace_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.hopper_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', new ItemStack(Blocks.hopper, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.tnt_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', new ItemStack(Blocks.tnt, 1, OreDictionary.WILDCARD_VALUE)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_helmet, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RRR", "RhR", 'R', OrePrefixes.ring.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_chestplate, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RhR", "RRR", "RRR", 'R', OrePrefixes.ring.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_leggings, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RRR", "RhR", "R R", 'R', OrePrefixes.ring.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_boots, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"R R", "RhR", 'R', OrePrefixes.ring.get(Materials.Steel)});

        GT_Log.out.println("GT_Mod: Adding Wool and Color releated Recipes.");
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeOrange});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeMagenta});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 3), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeLightBlue});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 4), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeYellow});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 5), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeLime});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyePink});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 7), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeGray});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 8), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeLightGray});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 9), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeCyan});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 10), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyePurple});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 11), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeBlue});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 12), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeBrown});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 13), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeGreen});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 14), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeRed});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.wool, 1, 15), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.wool, 1, 0), Dyes.dyeBlack});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stained_glass, 8, 0), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "GDG", "GGG", 'G', new ItemStack(Blocks.glass, 1), 'D', Dyes.dyeWhite});

        GT_Log.out.println("GT_Mod: Putting a Potato on a Stick.");
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_PotatoChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.foil.get(Materials.Aluminium), ItemList.Food_PotatoChips});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_ChiliChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.foil.get(Materials.Aluminium), ItemList.Food_ChiliChips});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_Fries.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.plateDouble.get(Materials.Paper), ItemList.Food_Fries});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Chum_On_Stick.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Wood), ItemList.Food_Chum});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Potato_On_Stick.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Wood), ItemList.Food_Raw_Potato});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Potato_On_Stick_Roasted.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Wood), ItemList.Food_Baked_Potato});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.bucket.get(Materials.Water), OrePrefixes.dust.get(Materials.Wheat)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Sugar.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, OrePrefixes.dust.get(Materials.Sugar)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Chocolate.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, OrePrefixes.dust.get(Materials.Cocoa)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Chocolate.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, OrePrefixes.dust.get(Materials.Chocolate)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Flat_Dough.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, ToolDictNames.craftingToolRollingPin});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Bun.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Bread.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, DOUGH});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Baguette.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, DOUGH, DOUGH});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Cake.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_ChiliChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_PotatoChips, OrePrefixes.dust.get(Materials.Chili)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Buns.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Breads.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Baguettes.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Bun.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Bread.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Baguette.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, OrePrefixes.dust.get(Materials.MeatCooked)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Chum.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Chum});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, OrePrefixes.dust.get(Materials.MeatCooked)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Chum.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Chum});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, new ItemStack(Items.cooked_beef, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, new ItemStack(Items.cooked_beef, 1)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, new ItemStack(Items.cooked_porkchop, 1), new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, new ItemStack(Items.cooked_beef, 1), new ItemStack(Items.cooked_beef, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, new ItemStack(Items.cooked_porkchop, 1), new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, new ItemStack(Items.cooked_beef, 1), new ItemStack(Items.cooked_beef, 1)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, OrePrefixes.dust.get(Materials.MeatCooked)});

        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Cheese.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "foodCheese"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Lemon.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropLemon"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Tomato.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropTomato"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Onion.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropOnion"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Cucumber.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropCucumber"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Bun.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Baked_Bun});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Bread.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Baked_Bread});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Baguette.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Baked_Baguette});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Raw_PotatoChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropPotato"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Raw_Cookie.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Dough_Chocolate});

        GT_ModHandler.addCraftingRecipe(ItemList.Food_Raw_Fries.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', "cropPotato"});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bowl, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', OrePrefixes.plank.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', OrePrefixes.plate.get(Materials.Rubber)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadArrow, Materials.Flint, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"f", "X", 'X', new ItemStack(Items.flint, 1, OreDictionary.WILDCARD_VALUE)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.arrow, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"  H", " S ", "F  ", 'H', new ItemStack(Items.flint, 1, OreDictionary.WILDCARD_VALUE), 'S', OrePrefixes.stick.get(Materials.Wood), 'F', OreDictNames.craftingFeather});

        GT_ModHandler.removeRecipe(new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks));
        GT_ModHandler.removeRecipeByOutput(ItemList.Food_Baked_Bread.get(1L));
        GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.cookie, 1));
        GT_ModHandler.removeRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L));
        if (null != GT_Utility.setStack(GT_ModHandler.getRecipeOutput(true, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), null, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L)), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "bronzeingotcrafting", true) ? 1L : 2L))) {
            GT_Log.out.println("GT_Mod: Changed Forestrys Bronze Recipe");
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "enchantmenttable", false)) {
            GT_Log.out.println("GT_Mod: Removing the Recipe of the Enchantment Table, to have more Fun at enchanting with the Anvil and Books from Dungeons.");
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.enchanting_table, 1));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "enderchest", false)) {
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.ender_chest, 1));
        }
        tStack = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L);
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getRecipeOutput(null, new ItemStack(Blocks.sand, 1, 0), null, null, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L), null, null, new ItemStack(Blocks.sand, 1, 0), null), new Object[]{"S", "A", "S", 'A', OrePrefixes.dust.get(Materials.Apatite), 'S', new ItemStack(Blocks.sand, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getRecipeOutput(tStack, tStack, tStack, tStack, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L), tStack, tStack, tStack, tStack), new Object[]{"SSS", "SAS", "SSS", 'A', OrePrefixes.dust.get(Materials.Apatite), 'S', OrePrefixes.dust.get(Materials.Ash)});

        GT_Log.out.println("GT_Mod: Adding Mixed Metal Ingot Recipes.");
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Mixed_Metal_Ingot.get(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.AnyIron), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_Log.out.println("GT_Mod: Adding Rolling Machine Recipes.");
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Standard.get(4L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(Materials.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Standard.get(32L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(Materials.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Standard.get(32L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(Materials.Tungsten).toString()});

        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Reinforced.get(32L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(Materials.TungstenSteel).toString()});

        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(2L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(Materials.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(16L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(Materials.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(16L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(Materials.Tungsten).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(48L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(Materials.TungstenSteel).toString()});

        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.light.blue", 8L), new Object[]{"XXX", " X ", "XXX", 'X', OrePrefixes.ingot.get(Materials.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.purple", 64L), new Object[]{"XXX", " X ", "XXX", 'X', OrePrefixes.ingot.get(Materials.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.black", 64L), new Object[]{"XXX", " X ", "XXX", 'X', OrePrefixes.ingot.get(Materials.Tungsten).toString()});

        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.light.blue", 8L), new Object[]{"X X", "XXX", "X X", 'X', OrePrefixes.ingot.get(Materials.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.purple", 64L), new Object[]{"X X", "XXX", "X X", 'X', OrePrefixes.ingot.get(Materials.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.black", 64L), new Object[]{"X X", "XXX", "X X", 'X', OrePrefixes.ingot.get(Materials.Tungsten).toString()});

        GT_Log.out.println("GT_Mod: Replacing Railcraft Recipes with slightly more OreDicted Variants");

        long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES_IF_SAME_NBT | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_NATIVE_RECIPES | GT_ModHandler.RecipeBits.ONLY_ADD_IF_THERE_IS_ANOTHER_RECIPE_FOR_IT;
        char tHammer = ' ';
        char tFile = ' ';
        char tWrench = ' ';
        OrePrefixes tIngot = OrePrefixes.ingot;
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "railcraft_stuff_use_tools", true)) {
            tHammer = 'h';
            tFile = 'f';
            tWrench = 'w';
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "railcraft_stuff_use_plates", true)) {
            tIngot = OrePrefixes.plate;
        }
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 2L, 3), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{tHammer + EMPTY_STRING + tFile, "XX", "XX", 'X', tIngot.get(Materials.Tin)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 0), tBitMask, new Object[]{tHammer + "X ", "XGX", " X" + tFile, 'X', OrePrefixes.nugget.get(Materials.Gold), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 1), tBitMask, new Object[]{tHammer + "X ", "XGX", " X" + tFile, 'X', tIngot.get(Materials.AnyIron), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2), tBitMask, new Object[]{tHammer + "X ", "XGX", " X" + tFile, 'X', tIngot.get(Materials.Steel), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 3)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 0), tBitMask, new Object[]{tWrench + "PP", tHammer + "PP", 'P', OrePrefixes.plate.get(Materials.AnyIron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 1), tBitMask, new Object[]{"GPG", "PGP", "GPG", 'P', OrePrefixes.plate.get(Materials.AnyIron), 'G', new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 2), tBitMask, new Object[]{"BPB", "PLP", "BPB", 'P', OrePrefixes.plate.get(Materials.AnyIron), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'L', new ItemStack(Blocks.lever, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 3), tBitMask, new Object[]{tWrench + "P", tHammer + "P", 'P', OrePrefixes.plate.get(Materials.AnyIron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), tBitMask, new Object[]{tWrench + "P", tHammer + "P", 'P', OrePrefixes.plate.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 5), tBitMask, new Object[]{"BBB", "BFB", "BOB", 'B', OrePrefixes.ingot.get(Materials.Brick), 'F', new ItemStack(Items.fire_charge, 1, OreDictionary.WILDCARD_VALUE), 'O', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 6), tBitMask, new Object[]{"PUP", "BFB", "POP", 'P', OrePrefixes.plate.get(Materials.Steel), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(Items.fire_charge, 1, OreDictionary.WILDCARD_VALUE), 'U', OrePrefixes.bucket.get(Materials.Empty), 'O', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 7), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"PPP", tHammer + "G" + tWrench, "OTO", 'P', OrePrefixes.nugget.get(Materials.Gold), 'O', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 0), 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'T', OreDictNames.craftingPiston});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 8), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"PPP", tHammer + "G" + tWrench, "OTO", 'P', OrePrefixes.plate.get(Materials.AnyIron), 'O', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 1), 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'T', OreDictNames.craftingPiston});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 9), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"PPP", tHammer + "G" + tWrench, "OTO", 'P', OrePrefixes.plate.get(Materials.Steel), 'O', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2), 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'T', OreDictNames.craftingPiston});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 10), tBitMask, new Object[]{" E ", " O ", "OIO", 'I', tIngot.get(Materials.Gold), 'E', OrePrefixes.gem.get(Materials.EnderPearl), 'O', OrePrefixes.stone.get(Materials.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 11), tBitMask, new Object[]{"OOO", "OEO", "OOO", 'E', OrePrefixes.gem.get(Materials.EnderPearl), 'O', OrePrefixes.stone.get(Materials.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 12), tBitMask, new Object[]{"GPG", "PAP", "GPG", 'P', OreDictNames.craftingPiston, 'A', OreDictNames.craftingAnvil, 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 13), tBitMask, new Object[]{tWrench + "PP", tHammer + "PP", 'P', OrePrefixes.plate.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 14), tBitMask, new Object[]{"GPG", "PGP", "GPG", 'P', OrePrefixes.plate.get(Materials.Steel), 'G', new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 15), tBitMask, new Object[]{"BPB", "PLP", "BPB", 'P', OrePrefixes.plate.get(Materials.Steel), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'L', new ItemStack(Blocks.lever, 1, OreDictionary.WILDCARD_VALUE)});

        GT_ModHandler.addCraftingRecipe(ItemList.RC_ShuntingWireFrame.get(6L), tBitMask, new Object[]{"PPP", "R" + tWrench + "R", "RRR", 'P', OrePrefixes.plate.get(Materials.AnyIron), 'R', ItemList.RC_Rebar.get(1L)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 0), tBitMask, new Object[]{"IOI", "GEG", "IOI", 'I', tIngot.get(Materials.Gold), 'G', OrePrefixes.gem.get(Materials.Diamond), 'E', OrePrefixes.gem.get(Materials.EnderPearl), 'O', OrePrefixes.stone.get(Materials.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 3L, 1), tBitMask, new Object[]{"BPB", "P" + tWrench + "P", "BPB", 'P', OrePrefixes.plate.get(Materials.Steel), 'B', OrePrefixes.block.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 2), tBitMask, new Object[]{"IOI", "GEG", "IOI", 'I', tIngot.get(Materials.Gold), 'G', OrePrefixes.gem.get(Materials.Emerald), 'E', OrePrefixes.gem.get(Materials.EnderPearl), 'O', OrePrefixes.stone.get(Materials.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 4L, 3), tBitMask, new Object[]{"PPP", "PFP", "PPP", 'P', OrePrefixes.plate.get(Materials.Steel), 'F', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 5), tBitMask, new Object[]{" N ", "RCR", 'R', OrePrefixes.dust.get(Materials.Redstone), 'N', OrePrefixes.stone.get(Materials.Netherrack), 'C', new ItemStack(Items.cauldron, 1, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 6), tBitMask, new Object[]{"SGS", "EDE", "SGS", 'E', OrePrefixes.gem.get(Materials.Emerald), 'S', OrePrefixes.plate.get(Materials.Steel), 'G', new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE), 'D', new ItemStack(Blocks.dispenser, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 8), tBitMask, new Object[]{"IPI", "PCP", "IPI", 'P', OreDictNames.craftingPiston, 'I', tIngot.get(Materials.AnyIron), 'C', new ItemStack(Blocks.crafting_table, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 9), tBitMask, new Object[]{" I ", " T ", " D ", 'I', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), 'D', new ItemStack(Blocks.dispenser, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 10), tBitMask, new Object[]{" I ", "RTR", " D ", 'I', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), 'D', new ItemStack(Blocks.dispenser, 1, OreDictionary.WILDCARD_VALUE), 'R', OrePrefixes.dust.get(Materials.Redstone)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 10), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RTR", 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 9), 'R', OrePrefixes.dust.get(Materials.Redstone)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 11), tBitMask, new Object[]{"PCP", "CSC", "PCP", 'P', OrePrefixes.plank.get(Materials.Wood), 'S', OrePrefixes.plate.get(Materials.Steel), 'C', new ItemStack(Items.golden_carrot, 1, 0)});
        if (GregTech_API.sMachineFile.get(ConfigCategories.machineconfig, "DisableRCBlastFurnace", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 4L, 12));
        }
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 13), tBitMask, new Object[]{"TSB", "SCS", "PSP", 'P', OreDictNames.craftingPiston, 'S', OrePrefixes.plate.get(Materials.Steel), 'B', OreDictNames.craftingBook, 'C', new ItemStack(Blocks.crafting_table, 1, OreDictionary.WILDCARD_VALUE), 'T', new ItemStack(Items.diamond_pickaxe, 1, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 6L, 14), tBitMask, new Object[]{"PPP", "ISI", "PPP", 'P', OrePrefixes.plank.get(Materials.Wood), 'I', tIngot.get(Materials.AnyIron), 'S', "slimeball"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 4L, 15), tBitMask, new Object[]{"PDP", "DBD", "PDP", 'P', OreDictNames.craftingPiston, 'B', OrePrefixes.block.get(Materials.Steel), 'D', OrePrefixes.gem.get(Materials.Diamond)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "machine.epsilon", 1L, 0), tBitMask, new Object[]{"PWP", "WWW", "PWP", 'P', OrePrefixes.plate.get(Materials.AnyIron), 'W', OrePrefixes.wireGt02.get(Materials.Copper)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "tool.crowbar", 1L, 0), tBitMask, new Object[]{tHammer + "DS", "DSD", "SD" + tFile, 'S', OrePrefixes.ingot.get(Materials.Iron), 'D', Dyes.dyeRed});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "tool.crowbar.reinforced", 1L, 0), tBitMask, new Object[]{tHammer + "DS", "DSD", "SD" + tFile, 'S', OrePrefixes.ingot.get(Materials.Steel), 'D', Dyes.dyeRed});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "tool.whistle.tuner", 1L, 0), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"S" + tHammer + "S", "SSS", " S" + tFile, 'S', OrePrefixes.nugget.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.blade", 1L, 0), tBitMask, new Object[]{"S" + tFile, "S ", "S" + tHammer, 'S', tIngot.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.disk", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(Materials.Steel), 'S', GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.blade", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.rotor", 1L, 0), tBitMask, new Object[]{"SSS", " " + tWrench + " ", 'S', GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.disk", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "borehead.iron", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(Materials.Iron), 'S', tIngot.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "borehead.steel", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(Materials.Steel), 'S', tIngot.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "borehead.diamond", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(Materials.Diamond), 'S', tIngot.get(Materials.Steel)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "cart.loco.steam.solid", 1L, 0), tBitMask, new Object[]{"TTF", "TTF", "BCC", 'C', new ItemStack(Items.minecart, 1), 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), 'F', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 5), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "cart.loco.electric", 1L, 0), tBitMask, new Object[]{"LP" + tWrench, "PEP", "GCG", 'C', new ItemStack(Items.minecart, 1), 'E', GT_ModHandler.getModItem(MOD_ID_RC, "machine.epsilon", 1L, 0), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2), 'L', new ItemStack(Blocks.redstone_lamp, 1, OreDictionary.WILDCARD_VALUE), 'P', OrePrefixes.plate.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "cart.bore", 1L, 0), tBitMask, new Object[]{"BCB", "FCF", tHammer + "A" + tWrench, 'C', new ItemStack(Items.minecart, 1), 'A', new ItemStack(Items.chest_minecart, 1), 'F', OreDictNames.craftingFurnace, 'B', OrePrefixes.block.get(Materials.Steel)});

        GT_Log.out.println("GT_Mod: Beginning to add regular Crafting Recipes.");
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("scaffold", 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", " S ", "S S", 'W', OrePrefixes.plank.get(Materials.Wood), 'S', OrePrefixes.stick.get(Materials.Wood)});

        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT", 'H', OrePrefixes.cell.get(Materials.Helium), 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT", 'H', OrePrefixes.cell.get(Materials.Helium), 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.VanadiumGallium)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT", 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.YttriumBariumCuprate)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT", 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.Naquadah)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.AnyIron), OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Redstone)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Gold.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Iron.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.AnyIron)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Bronze.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Copper.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.AnyCopper)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Tin.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Lead.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.Lead)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Steel.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(Materials.Steel)});

        GT_ModHandler.addCraftingRecipe(ItemList.PlatinumGroupSludge.get(1), new Object[]{"DDD","DDD","DDD", 'D', ItemList.PlatinumGroupSludgeTiny.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.PlatinumGroupSludgeTiny.get(9), new Object[]{ItemList.PlatinumGroupSludge.get(1)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(Materials.Sulfur), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(Materials.Phosphorus), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(Materials.Charcoal), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dustImpure.get(Materials.Coal), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.crushed.get(Materials.Coal), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 4), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.crushedPurified.get(Materials.Coal), 'S', OrePrefixes.stick.get(Materials.Wood)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(Materials.Redstone), 'B', OrePrefixes.ingot.get(Materials.AnyIron)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(Materials.Redstone), 'B', OrePrefixes.ingot.get(Materials.AnyBronze)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(Materials.Redstone), 'B', OrePrefixes.ingot.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(Materials.Redstone), 'B', OrePrefixes.ingot.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(Materials.Redstone), 'B', OrePrefixes.ingot.get(Materials.Titanium)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("reactorVent", 1L, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"AIA", "I I", "AIA", 'I', new ItemStack(Blocks.iron_bars, 1), 'A', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getIC2Item("reactorPlatingExplosive", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{GT_ModHandler.getIC2Item("reactorPlating", 1L), OrePrefixes.plate.get(Materials.Lead)});
        if (!Materials.Steel.mBlastFurnaceRequired) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Coal), OrePrefixes.dust.get(Materials.Coal)});
        }
        if (GT_Mod.gregtechproxy.mNerfDustCrafting) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Electrum, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Gold)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Invar, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Nickel)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Cupronickel, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.AnyCopper)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Nichrome, 15L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Chrome)});
        } else {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Gold)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Invar, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Nickel)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cupronickel, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.AnyCopper)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Chrome)});
        }
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackBronze, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BismuthBronze, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Bismuth), OrePrefixes.dust.get(Materials.Zinc), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.BlackBronze), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.SterlingSilver), OrePrefixes.dust.get(Materials.BismuthBronze), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.BlackSteel), OrePrefixes.dust.get(Materials.BlackSteel), OrePrefixes.dust.get(Materials.BlackSteel), OrePrefixes.dust.get(Materials.BlackSteel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.RoseGold), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.BlackSteel), OrePrefixes.dust.get(Materials.BlackSteel), OrePrefixes.dust.get(Materials.BlackSteel), OrePrefixes.dust.get(Materials.BlackSteel)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ultimet, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Cobalt), OrePrefixes.dust.get(Materials.Cobalt), OrePrefixes.dust.get(Materials.Cobalt), OrePrefixes.dust.get(Materials.Cobalt), OrePrefixes.dust.get(Materials.Cobalt), OrePrefixes.dust.get(Materials.Chrome), OrePrefixes.dust.get(Materials.Chrome), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Molybdenum)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CobaltBrass, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Cobalt)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Manganese), OrePrefixes.dust.get(Materials.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.YttriumBariumCuprate, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Yttrium), OrePrefixes.dust.get(Materials.Barium), OrePrefixes.dust.get(Materials.Barium), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper), OrePrefixes.dust.get(Materials.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Chrome)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Vanadium), OrePrefixes.dust.get(Materials.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.TungstenSteel), OrePrefixes.dust.get(Materials.TungstenSteel), OrePrefixes.dust.get(Materials.TungstenSteel), OrePrefixes.dust.get(Materials.TungstenSteel), OrePrefixes.dust.get(Materials.TungstenSteel), OrePrefixes.dust.get(Materials.Chrome), OrePrefixes.dust.get(Materials.Molybdenum), OrePrefixes.dust.get(Materials.Molybdenum), OrePrefixes.dust.get(Materials.Vanadium)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.Cobalt), OrePrefixes.dust.get(Materials.Manganese), OrePrefixes.dust.get(Materials.Silicon)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.HSSG), OrePrefixes.dust.get(Materials.Iridium), OrePrefixes.dust.get(Materials.Iridium), OrePrefixes.dust.get(Materials.Osmium)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Silicon), OrePrefixes.dust.get(Materials.Coal)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.RedstoneAlloy), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Titanium)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.ConductiveIron), OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.TungstenSteel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.EnergeticAlloy), OrePrefixes.dust.get(Materials.EnderEye), OrePrefixes.dust.get(Materials.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Coal), OrePrefixes.dust.get(Materials.Silicon)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.EnderPearl), OrePrefixes.dust.get(Materials.RedstoneAlloy)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.soul_sand, 1, OreDictionary.WILDCARD_VALUE), OrePrefixes.dust.get(Materials.Gold), OrePrefixes.dust.get(Materials.Ash)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.ElectricalSteel), OrePrefixes.dust.get(Materials.Coal), OrePrefixes.dust.get(Materials.Obsidian)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Tin), OrePrefixes.dust.get(Materials.Tin), OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Platinum)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.EnderiumBase), OrePrefixes.dust.get(Materials.EnderiumBase), OrePrefixes.dust.get(Materials.Thaumium), OrePrefixes.dust.get(Materials.EnderPearl)});
        
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ultimet, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(Materials.Cobalt), OrePrefixes.dustTiny.get(Materials.Cobalt), OrePrefixes.dustTiny.get(Materials.Cobalt), OrePrefixes.dustTiny.get(Materials.Cobalt), OrePrefixes.dustTiny.get(Materials.Cobalt), OrePrefixes.dustTiny.get(Materials.Chrome), OrePrefixes.dustTiny.get(Materials.Chrome), OrePrefixes.dustTiny.get(Materials.Nickel), OrePrefixes.dustTiny.get(Materials.Molybdenum)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CobaltBrass, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Aluminium), OrePrefixes.dustTiny.get(Materials.Cobalt)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Nickel), OrePrefixes.dustTiny.get(Materials.Manganese), OrePrefixes.dustTiny.get(Materials.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.YttriumBariumCuprate, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(Materials.Yttrium), OrePrefixes.dustTiny.get(Materials.Barium), OrePrefixes.dustTiny.get(Materials.Barium), OrePrefixes.dustTiny.get(Materials.AnyCopper), OrePrefixes.dustTiny.get(Materials.AnyCopper), OrePrefixes.dustTiny.get(Materials.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Kanthal, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(Materials.Iron), OrePrefixes.dustTiny.get(Materials.Aluminium), OrePrefixes.dustTiny.get(Materials.Chrome)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronWood, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.LiveRoot), OrePrefixes.dustTiny.get(Materials.Gold)});

        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 3), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Coal), OrePrefixes.dust.get(Materials.Sulfur), OrePrefixes.dust.get(Materials.Saltpeter), OrePrefixes.dust.get(Materials.Saltpeter)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Charcoal), OrePrefixes.dust.get(Materials.Sulfur), OrePrefixes.dust.get(Materials.Saltpeter), OrePrefixes.dust.get(Materials.Saltpeter)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Potassium), OrePrefixes.cell.get(Materials.Nitrogen), OrePrefixes.cell.get(Materials.Oxygen), OrePrefixes.cell.get(Materials.Oxygen), OrePrefixes.cell.get(Materials.Oxygen)});
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("carbonFiber", 1L));

        if (GT_Mod.gregtechproxy.mDisableIC2Cables) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("copperCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedCopperCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("goldCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedGoldCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedIronCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(GFIBER, 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("tinCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ironCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedTinCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("detectorCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("splitterCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electrolyzer", 1L));

            if (Loader.isModLoaded("NotEnoughItems")) {
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("copperCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedCopperCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("goldCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedGoldCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedIronCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item(GFIBER, 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("tinCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("ironCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedTinCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("detectorCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("splitterCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("electrolyzer", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("cutter", 1L));
            }
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("batBox", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("batBox", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PCP", "BBB", "PPP", 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'P', OrePrefixes.plank.get(Materials.Wood), 'B', OrePrefixes.battery.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("mfeUnit", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("mfeUnit", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CEC", "EME", "CEC", 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'E', OrePrefixes.battery.get(Materials.Elite), 'M', GT_ModHandler.getIC2Item(IC2M, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("lvTransformer", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("lvTransformer", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PCP", "POP", "PCP", 'C', OrePrefixes.cableGt01.get(Materials.Tin), 'O', GT_ModHandler.getIC2Item("coil", 1L), 'P', OrePrefixes.plank.get(Materials.Wood)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(MVT, 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(MVT, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CMC", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'M', GT_ModHandler.getIC2Item(IC2M, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(HVT, 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(HVT, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "IMB", " C ", 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'M', GT_ModHandler.getIC2Item(MVT, 1L), 'I', OrePrefixes.circuit.get(Materials.Basic), 'B', OrePrefixes.battery.get(Materials.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("evTransformer", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("evTransformer", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "IMB", " C ", 'C', OrePrefixes.cableGt01.get(Materials.Aluminium), 'M', GT_ModHandler.getIC2Item(HVT, 1L), 'I', OrePrefixes.circuit.get(Materials.Advanced), 'B', OrePrefixes.battery.get(Materials.Master)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cesuUnit", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("cesuUnit", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PCP", "BBB", "PPP", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'P', OrePrefixes.plate.get(Materials.Bronze), 'B', OrePrefixes.battery.get(Materials.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(LUM, 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("teleporter", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("teleporter", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GFG", "CMC", "GDG", 'C', OrePrefixes.cableGt01.get(Materials.Platinum), 'G', OrePrefixes.circuit.get(Materials.Advanced), 'D', OrePrefixes.gem.get(Materials.Diamond), 'M', GT_ModHandler.getIC2Item(IC2M, 1L), 'F', GT_ModHandler.getIC2Item(FREQT, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("energyOMat", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("energyOMat", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RBR", "CMC", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.dust.get(Materials.Redstone), 'B', OrePrefixes.battery.get(Materials.Basic), 'M', GT_ModHandler.getIC2Item(IC2M, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("advBattery", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("advBattery", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CTC", "TST", "TLT", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'S', OrePrefixes.dust.get(Materials.Sulfur), 'L', OrePrefixes.dust.get(Materials.Lead), 'T', GT_ModHandler.getIC2Item("casingbronze", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("boatElectric", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("boatElectric", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "XWX", "XXX", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'X', OrePrefixes.plate.get(Materials.Iron), 'W', GT_ModHandler.getIC2Item("waterMill", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cropnalyzer", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("cropnalyzer", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CC ", "RGR", "RIR", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'R', OrePrefixes.dust.get(Materials.Redstone), 'G', OrePrefixes.block.get(Materials.Glass), 'I', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("coil", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("coil", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "CXC", "CCC", 'C', OrePrefixes.wireGt01.get(Materials.Copper), 'X', OrePrefixes.ingot.get(Materials.AnyIron)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("powerunit", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("powerunit", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"BCA", "BIM", "BCA", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'B', OrePrefixes.battery.get(Materials.Basic), 'A', GT_ModHandler.getIC2Item("casingiron", 1L), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getIC2Item("elemotor", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("powerunitsmall", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("powerunitsmall", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" CA", "BIM", " CA", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'B', OrePrefixes.battery.get(Materials.Basic), 'A', GT_ModHandler.getIC2Item("casingiron", 1L), 'I', OrePrefixes.circuit.get(Materials.Basic), 'M', GT_ModHandler.getIC2Item("elemotor", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("remote", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("remote", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "TLT", " F ", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'L', OrePrefixes.dust.get(Materials.Lapis), 'T', GT_ModHandler.getIC2Item("casingtin", 1L), 'F', GT_ModHandler.getIC2Item(FREQT, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(ODS, 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(ODS, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PGP", "CBC", "WWW", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'G', OrePrefixes.dust.get(Materials.Glowstone), 'B', OrePrefixes.battery.get(Materials.Advanced), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'P', GT_ModHandler.getIC2Item("casinggold", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ovScanner", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ovScanner", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PDP", "GCG", "WSW", 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'G', OrePrefixes.dust.get(Materials.Glowstone), 'D', OrePrefixes.battery.get(Materials.Elite), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'P', GT_ModHandler.getIC2Item("casinggold", 1L), 'S', GT_ModHandler.getIC2Item(ODS, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("solarHelmet", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("staticBoots", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("staticBoots", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"I I", "IWI", "CCC", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'I', OrePrefixes.ingot.get(Materials.Iron), 'W', new ItemStack(Blocks.wool)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ecMeter", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ecMeter", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" G ", "CIC", "C C", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'G', OrePrefixes.dust.get(Materials.Glowstone), 'I', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("obscurator", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("obscurator", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RER", "CAC", "RRR", 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.dust.get(Materials.Redstone), 'E', OrePrefixes.battery.get(Materials.Advanced), 'A', OrePrefixes.circuit.get(Materials.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("overclockerUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("overclockerUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "WEW", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'C', GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1), 'E', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("transformerUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("transformerUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "WTW", "GEG", 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'T', GT_ModHandler.getIC2Item(MVT, 1L), 'E', OrePrefixes.circuit.get(Materials.Basic), 'G', OrePrefixes.block.get(Materials.Glass)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("energyStorageUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("energyStorageUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PPP", "WBW", "PEP", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'E', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.plank.get(Materials.Wood), 'B', OrePrefixes.battery.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ejectorUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ejectorUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PHP", "WEW", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'E', OrePrefixes.circuit.get(Materials.Basic), 'P', new ItemStack(Blocks.piston), 'H', new ItemStack(Blocks.hopper)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("suBattery", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("suBattery", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"W", "C", "R", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.HydratedCoal), 'R', OrePrefixes.dust.get(Materials.Redstone)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(FREQT, 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("pullingUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("pullingUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PHP", "WEW", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'P', new ItemStack(Blocks.sticky_piston), 'R', new ItemStack(Blocks.hopper), 'E', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cutter", 1L));
        } else {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(GFIBER, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "EDE", "GGG", 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'D', OrePrefixes.dust.get(Materials.Silver), 'E', ItemList.IC2_Energium_Dust.get(1L)});
        }

        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Energium_Dust.get(1L));
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.gregtechrecipes, "energycrystalruby", true)) {
            GT_ModHandler.addCraftingRecipe(ItemList.IC2_Energium_Dust.get(9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RDR", "DRD", "RDR", 'R', OrePrefixes.dust.get(Materials.Redstone), 'D', OrePrefixes.dust.get(Materials.Ruby)});
        } else {
            GT_ModHandler.addCraftingRecipe(ItemList.IC2_Energium_Dust.get(9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RDR", "DRD", "RDR", 'R', OrePrefixes.dust.get(Materials.Redstone), 'D', OrePrefixes.dust.get(Materials.Diamond)});
        }
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(LCRYST, 1L));
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'S', GT_ModHandler.getIC2Item("energyCrystal", 1L, OreDictionary.WILDCARD_VALUE), 'L', OrePrefixes.dust.get(Materials.Lazurite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'S', GT_ModHandler.getIC2Item("energyCrystal", 1L, OreDictionary.WILDCARD_VALUE), 'L', OrePrefixes.dust.get(Materials.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'S', OrePrefixes.gem.get(Materials.Sapphire), 'L', OrePrefixes.dust.get(Materials.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'S', OrePrefixes.gem.get(Materials.Sapphire), 'L', OrePrefixes.dust.get(Materials.Lazurite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Good), 'S', OrePrefixes.gemFlawless.get(Materials.Sapphire), 'L', OrePrefixes.dust.get(Materials.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Good), 'S', OrePrefixes.gemFlawless.get(Materials.Sapphire), 'L', OrePrefixes.dust.get(Materials.Lazurite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Basic), 'S', OrePrefixes.gemExquisite.get(Materials.Sapphire), 'L', OrePrefixes.dust.get(Materials.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(Materials.Basic), 'S', OrePrefixes.gemExquisite.get(Materials.Sapphire), 'L', OrePrefixes.dust.get(Materials.Lazurite)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LUM, 16L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RTR", "GHG", "GGG", 'H', OrePrefixes.cell.get(Materials.Helium), 'T', OrePrefixes.ingot.get(Materials.Tin), 'R', OrePrefixes.ingot.get(Materials.AnyIron), 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LUM, 16L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RTR", "GHG", "GGG", 'H', OrePrefixes.cell.get(Materials.Mercury), 'T', OrePrefixes.ingot.get(Materials.Tin), 'R', OrePrefixes.ingot.get(Materials.AnyIron), 'G', new ItemStack(Blocks.glass, 1)});

        if (Loader.isModLoaded(MOD_ID_GS)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1, 6));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1, 6), new Object[]{"GPG", "CUC", "PVP", 'G', OrePrefixes.dust.get(Materials.Glowstone), 'P', GT_ModHandler.getIC2Item("advancedAlloy", 1), 'C', OrePrefixes.circuit.get(Materials.Advanced),'U', OrePrefixes.plate.get(Materials.Titanium), 'V', OrePrefixes.plate.get(Materials.StainlessSteel)});
        }
        if (Loader.isModLoaded(MOD_ID_GS) && (GT_Mod.gregtechproxy.mDisableIC2Cables)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, ADVJET, 1));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, ADVJET, 1), new Object[]{"PJP", "BLB", "WCW", 'P', OrePrefixes.plateAlloy.get(Materials.Carbon), 'J', GT_ModHandler.getIC2Item("electricJetpack", 1), 'B', GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1, 6), 'L', GT_ModHandler.getModItem(MOD_ID_GS, "advLappack", 1), 'W', OrePrefixes.wireGt04.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Advanced)});

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 3, 1));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 3, 1), new Object[]{"CCC", "WWW", "CCC", 'C', GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1), 'W', OrePrefixes.wireGt01.get(Materials.Superconductor)});

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, "advNanoChestPlate", 1));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, "advNanoChestPlate", 1), new Object[]{"PJP", "PLP", "WCW", 'P', OrePrefixes.plateAlloy.get(Materials.Carbon), 'J', GT_ModHandler.getModItem(MOD_ID_GS, ADVJET, 1), 'L', GT_ModHandler.getIC2Item("nanoBodyarmor", 1), 'W', OrePrefixes.wireGt04.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Advanced)});
        }

        GT_ModHandler.removeRecipe(tStack = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), tStack, tStack, tStack, new ItemStack(Items.coal, 1, 0), tStack, tStack, tStack, tStack);
        GT_ModHandler.removeRecipe(tStack = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), tStack, tStack, tStack, new ItemStack(Items.coal, 1, 1), tStack, tStack, tStack, tStack);
        GT_ModHandler.removeRecipe(null, tStack = new ItemStack(Items.coal, 1), null, tStack, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L), tStack, null, tStack, null);

        GT_ModHandler.removeFurnaceSmelting(new ItemStack(Blocks.hopper));

        GT_Log.out.println("GT_Mod: Applying harder Recipes for several Blocks.");
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "blockbreaker", false)) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.removeRecipe(new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.iron_pickaxe, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.piston, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.redstone, 1), new ItemStack(Blocks.cobblestone, 1)), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RGR", "RPR", "RCR", 'G', OreDictNames.craftingGrinder, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'R', OrePrefixes.plate.get(Materials.Steel), 'P', OreDictNames.craftingPiston});
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "beryliumreflector", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorReflectorThick", 1L, 1)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("reactorReflectorThick", 1L, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" N ", "NBN", " N ", 'B', OrePrefixes.plate.get(Materials.Beryllium), 'N', GT_ModHandler.getIC2Item("reactorReflector", 1L, 1)});
        }
        if (GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Diamond, 1L) != null) {
            tStack = GT_ModHandler.getRecipeOutput(GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Iron, 1L), new ItemStack(Items.redstone, 1), GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Diamond, 1L), new ItemStack(Items.diamond_pickaxe, 1), GT_OreDictUnificator.get(OrePrefixes.gear, Materials.Diamond, 1L));
            if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "quarry", true)) {
                GT_ModHandler.removeRecipeByOutput(tStack);
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"ICI", "GIG", "DPD", 'C', OrePrefixes.circuit.get(Materials.Advanced), 'D', OrePrefixes.gear.get(Materials.Diamond), 'G', OrePrefixes.gear.get(Materials.Gold), 'I', OrePrefixes.gear.get(Materials.Steel), 'P', GT_ModHandler.getIC2Item(DRILL2, 1L, OreDictionary.WILDCARD_VALUE)});
            }
            if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "quarry", false)) {
                GT_ModHandler.removeRecipeByOutput(tStack);
            }
        }
        GT_Log.out.println("GT_Mod: Applying Recipes for Tools");
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "nanosaber", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoSaber", 1L)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("nanoSaber", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PI ", "PI ", "CLC", 'L', OrePrefixes.battery.get(Materials.Master), 'I', OrePrefixes.plateAlloy.get("Iridium"), 'P', OrePrefixes.plate.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Master)});
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "namefix", true)) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.flint_and_steel, 1)) ? new ItemStack(Items.flint_and_steel, 1) : null, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"S ", " F", 'F', new ItemStack(Items.flint, 1), 'S', "nuggetSteel"});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(DRILL2, 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(DRILL2, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" D ", "DMD", "TAT", 'M', GT_ModHandler.getIC2Item(DRILL1, 1L, OreDictionary.WILDCARD_VALUE), 'D', OreDictNames.craftingIndustrialDiamond, 'T', OrePrefixes.plate.get(Materials.Titanium), 'A', OrePrefixes.circuit.get(Materials.Advanced)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(DRILL1, 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(DRILL1, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" S ", "SCS", "SBS", 'C', OrePrefixes.circuit.get(Materials.Basic), 'B', OrePrefixes.battery.get(Materials.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(Materials.StainlessSteel) : OrePrefixes.plate.get(Materials.Iron)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("chainsaw", 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("chainsaw", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"BS ", "SCS", " SS", 'C', OrePrefixes.circuit.get(Materials.Basic), 'B', OrePrefixes.battery.get(Materials.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(Materials.StainlessSteel) : OrePrefixes.plate.get(Materials.Iron)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electricHoe", 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("electricHoe", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"SS ", " C ", " B ", 'C', OrePrefixes.circuit.get(Materials.Basic), 'B', OrePrefixes.battery.get(Materials.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(Materials.StainlessSteel) : OrePrefixes.plate.get(Materials.Iron)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electricTreetap", 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("electricTreetap", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" B ", "SCS", "S  ", 'C', OrePrefixes.circuit.get(Materials.Basic), 'B', OrePrefixes.battery.get(Materials.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(Materials.StainlessSteel) : OrePrefixes.plate.get(Materials.Iron)});
        }
        GT_Log.out.println("GT_Mod: Removing Q-Armor Recipes if configured.");
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QHelmet", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1L));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QPlate", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1L));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QLegs", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1L));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QBoots", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1L));
        }
    }
}
