package gregtech.loaders.postload;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
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
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bucket, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"XhX", " X ", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron)});
        if (!GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Bucket", true)) {
            GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bucket, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"X X", " X ", 'X', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
        }
        ItemStack tMat = new ItemStack(Items.iron_ingot);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.PressurePlate", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, null, null, null, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XXh", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Door", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, tMat, tMat, null, tMat, tMat, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XX ", "XXh", "XX ", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Cauldron", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, null, tMat, tMat, null, tMat, tMat, tMat, tMat))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"X X", "XhX", "XXX", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Hopper", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, null, tMat, tMat, new ItemStack(Blocks.chest, 1, 0), tMat, null, tMat, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XwX", "XCX", " X ", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.AnyIron), 'C', "craftingChest"});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Bars", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, tMat, tMat, tMat, tMat, null, null, null))) {
                tStack.stackSize /= 2;
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{" w ", "XXX", "XXX", 'X', OrePrefixes.stick.get(MaterialsOld.AnyIron), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
            }
        }
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ironFence", 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"XXX", "XXX", " w ", 'X', OrePrefixes.stick.get(MaterialsOld.AnyIron), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});

        tMat = new ItemStack(Items.gold_ingot);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Gold.PressurePlate", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, null, null, null, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XXh", 'X', OrePrefixes.plate.get(MaterialsOld.Gold), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'I', OrePrefixes.ingot.get(MaterialsOld.Gold)});
            }
        }
        tMat = GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Rubber, 1L);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Rubber.Sheet", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, tMat, tMat, tMat, tMat, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XXX", "XXX", 'X', OrePrefixes.plate.get(MaterialsOld.Rubber)});
            }
        }
        GT_ModHandler.removeRecipeByOutput(ItemList.Bottle_Empty.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Spray_WeedEx.get(1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reBattery", 1L));

        ItemStack tStack = GT_ModHandler.removeRecipe(new ItemStack(Blocks.planks, 1, 0), null, null, new ItemStack(Blocks.planks, 1, 0));
        if (tStack != null) {
            GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"s", "P", "P", 'P', OrePrefixes.plank.get(MaterialsOld.Wood)});
            GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize / 2 : tStack.stackSize, tStack), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"P", "P", 'P', OrePrefixes.plank.get(MaterialsOld.Wood)});
        }
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PP", 'P', OrePrefixes.plank.get(MaterialsOld.Wood)});
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
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{" h ", "PwP", "WPW", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'W', ItemList.Component_Minecart_Wheels_Iron});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" h ", "PwP", "WPW", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'W', ItemList.Component_Minecart_Wheels_Steel});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chest_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.furnace_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.hopper_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', new ItemStack(Blocks.hopper, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.tnt_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', new ItemStack(Blocks.tnt, 1, OreDictionary.WILDCARD_VALUE)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_helmet, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RRR", "RhR", 'R', OrePrefixes.ring.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_chestplate, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RhR", "RRR", "RRR", 'R', OrePrefixes.ring.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_leggings, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RRR", "RhR", "R R", 'R', OrePrefixes.ring.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_boots, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"R R", "RhR", 'R', OrePrefixes.ring.get(MaterialsOld.Steel)});

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
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_PotatoChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.foil.get(MaterialsOld.Aluminium), ItemList.Food_PotatoChips});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_ChiliChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.foil.get(MaterialsOld.Aluminium), ItemList.Food_ChiliChips});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_Fries.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.plateDouble.get(MaterialsOld.Paper), ItemList.Food_Fries});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Chum_On_Stick.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(MaterialsOld.Wood), ItemList.Food_Chum});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Potato_On_Stick.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(MaterialsOld.Wood), ItemList.Food_Raw_Potato});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Potato_On_Stick_Roasted.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(MaterialsOld.Wood), ItemList.Food_Baked_Potato});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.bucket.get(MaterialsOld.Water), OrePrefixes.dust.get(MaterialsOld.Wheat)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Sugar.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, OrePrefixes.dust.get(MaterialsOld.Sugar)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Chocolate.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, OrePrefixes.dust.get(MaterialsOld.Cocoa)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Chocolate.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, OrePrefixes.dust.get(MaterialsOld.Chocolate)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Flat_Dough.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, ToolDictNames.craftingToolRollingPin});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Bun.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Bread.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, DOUGH});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Baguette.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{DOUGH, DOUGH, DOUGH});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Cake.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_ChiliChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_PotatoChips, OrePrefixes.dust.get(MaterialsOld.Chili)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Buns.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Breads.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Baguettes.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Bun.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Bread.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Baguette.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, OrePrefixes.dust.get(MaterialsOld.MeatCooked)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Chum.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Chum});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, OrePrefixes.dust.get(MaterialsOld.MeatCooked)});
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
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, OrePrefixes.dust.get(MaterialsOld.MeatCooked)});

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
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bowl, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', OrePrefixes.plank.get(MaterialsOld.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, MaterialsOld.Rubber, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', OrePrefixes.plate.get(MaterialsOld.Rubber)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadArrow, MaterialsOld.Flint, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"f", "X", 'X', new ItemStack(Items.flint, 1, OreDictionary.WILDCARD_VALUE)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.arrow, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"  H", " S ", "F  ", 'H', new ItemStack(Items.flint, 1, OreDictionary.WILDCARD_VALUE), 'S', OrePrefixes.stick.get(MaterialsOld.Wood), 'F', OreDictNames.craftingFeather});

        GT_ModHandler.removeRecipe(new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks));
        GT_ModHandler.removeRecipeByOutput(ItemList.Food_Baked_Bread.get(1L));
        GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.cookie, 1));
        GT_ModHandler.removeRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Copper, 1L));
        if (null != GT_Utility.setStack(GT_ModHandler.getRecipeOutput(true, GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Copper, 1L), null, GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Tin, 1L)), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Bronze, GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "bronzeingotcrafting", true) ? 1L : 2L))) {
            GT_Log.out.println("GT_Mod: Changed Forestrys Bronze Recipe");
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "enchantmenttable", false)) {
            GT_Log.out.println("GT_Mod: Removing the Recipe of the Enchantment Table, to have more Fun at enchanting with the Anvil and Books from Dungeons.");
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.enchanting_table, 1));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "enderchest", false)) {
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.ender_chest, 1));
        }
        tStack = GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Ash, 1L);
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getRecipeOutput(null, new ItemStack(Blocks.sand, 1, 0), null, null, GT_OreDictUnificator.get(OrePrefixes.gem, MaterialsOld.Apatite, 1L), null, null, new ItemStack(Blocks.sand, 1, 0), null), new Object[]{"S", "A", "S", 'A', OrePrefixes.dust.get(MaterialsOld.Apatite), 'S', new ItemStack(Blocks.sand, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getRecipeOutput(tStack, tStack, tStack, tStack, GT_OreDictUnificator.get(OrePrefixes.gem, MaterialsOld.Apatite, 1L), tStack, tStack, tStack, tStack), new Object[]{"SSS", "SAS", "SSS", 'A', OrePrefixes.dust.get(MaterialsOld.Apatite), 'S', OrePrefixes.dust.get(MaterialsOld.Ash)});

        GT_Log.out.println("GT_Mod: Adding Mixed Metal Ingot Recipes.");
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Mixed_Metal_Ingot.get(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Nickel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Nickel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Nickel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Nickel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Nickel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Nickel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Invar), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Invar), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Invar), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Invar), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Invar), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Invar), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Steel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Steel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Steel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Steel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Steel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Steel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Titanium), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Titanium), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Titanium), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Titanium), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Titanium), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Titanium), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Tungsten), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Tungsten), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Tungsten), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Tungsten), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Tungsten), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.Tungsten), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.TungstenSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.TungstenSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.TungstenSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Bronze), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.TungstenSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.TungstenSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(MaterialsOld.TungstenSteel), 'Y', OrePrefixes.plate.get(MaterialsOld.Brass), 'Z', OrePrefixes.plate.get(MaterialsOld.Aluminium)});

        GT_Log.out.println("GT_Mod: Adding Rolling Machine Recipes.");
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Standard.get(4L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Standard.get(32L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Standard.get(32L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.Tungsten).toString()});

        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rail_Reinforced.get(32L), new Object[]{"X X", "X X", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.TungstenSteel).toString()});

        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(2L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(MaterialsOld.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(16L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(MaterialsOld.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(16L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(MaterialsOld.Tungsten).toString()});
        GT_ModHandler.addRollingMachineRecipe(ItemList.RC_Rebar.get(48L), new Object[]{"  X", " X ", "X  ", 'X', OrePrefixes.ingot.get(MaterialsOld.TungstenSteel).toString()});

        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.light.blue", 8L), new Object[]{"XXX", " X ", "XXX", 'X', OrePrefixes.ingot.get(MaterialsOld.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.purple", 64L), new Object[]{"XXX", " X ", "XXX", 'X', OrePrefixes.ingot.get(MaterialsOld.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.black", 64L), new Object[]{"XXX", " X ", "XXX", 'X', OrePrefixes.ingot.get(MaterialsOld.Tungsten).toString()});

        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.light.blue", 8L), new Object[]{"X X", "XXX", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.Aluminium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.purple", 64L), new Object[]{"X X", "XXX", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.Titanium).toString()});
        GT_ModHandler.addRollingMachineRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "post.metal.black", 64L), new Object[]{"X X", "XXX", "X X", 'X', OrePrefixes.ingot.get(MaterialsOld.Tungsten).toString()});

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
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 2L, 3), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{tHammer + EMPTY_STRING + tFile, "XX", "XX", 'X', tIngot.get(MaterialsOld.Tin)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 0), tBitMask, new Object[]{tHammer + "X ", "XGX", " X" + tFile, 'X', OrePrefixes.nugget.get(MaterialsOld.Gold), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 1), tBitMask, new Object[]{tHammer + "X ", "XGX", " X" + tFile, 'X', tIngot.get(MaterialsOld.AnyIron), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 3)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2), tBitMask, new Object[]{tHammer + "X ", "XGX", " X" + tFile, 'X', tIngot.get(MaterialsOld.Steel), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 3)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 0), tBitMask, new Object[]{tWrench + "PP", tHammer + "PP", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 1), tBitMask, new Object[]{"GPG", "PGP", "GPG", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'G', new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 2), tBitMask, new Object[]{"BPB", "PLP", "BPB", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'L', new ItemStack(Blocks.lever, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 3), tBitMask, new Object[]{tWrench + "P", tHammer + "P", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), tBitMask, new Object[]{tWrench + "P", tHammer + "P", 'P', OrePrefixes.plate.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 5), tBitMask, new Object[]{"BBB", "BFB", "BOB", 'B', OrePrefixes.ingot.get(MaterialsOld.Brick), 'F', new ItemStack(Items.fire_charge, 1, OreDictionary.WILDCARD_VALUE), 'O', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 6), tBitMask, new Object[]{"PUP", "BFB", "POP", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'F', new ItemStack(Items.fire_charge, 1, OreDictionary.WILDCARD_VALUE), 'U', OrePrefixes.bucket.get(MaterialsOld.Empty), 'O', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 7), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"PPP", tHammer + "G" + tWrench, "OTO", 'P', OrePrefixes.nugget.get(MaterialsOld.Gold), 'O', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 0), 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'T', OreDictNames.craftingPiston});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 8), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"PPP", tHammer + "G" + tWrench, "OTO", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'O', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 1), 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'T', OreDictNames.craftingPiston});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 9), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"PPP", tHammer + "G" + tWrench, "OTO", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'O', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2), 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'T', OreDictNames.craftingPiston});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 10), tBitMask, new Object[]{" E ", " O ", "OIO", 'I', tIngot.get(MaterialsOld.Gold), 'E', OrePrefixes.gem.get(MaterialsOld.EnderPearl), 'O', OrePrefixes.stone.get(MaterialsOld.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 11), tBitMask, new Object[]{"OOO", "OEO", "OOO", 'E', OrePrefixes.gem.get(MaterialsOld.EnderPearl), 'O', OrePrefixes.stone.get(MaterialsOld.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 12), tBitMask, new Object[]{"GPG", "PAP", "GPG", 'P', OreDictNames.craftingPiston, 'A', OreDictNames.craftingAnvil, 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 13), tBitMask, new Object[]{tWrench + "PP", tHammer + "PP", 'P', OrePrefixes.plate.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 14), tBitMask, new Object[]{"GPG", "PGP", "GPG", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'G', new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCB, 8L, 15), tBitMask, new Object[]{"BPB", "PLP", "BPB", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'L', new ItemStack(Blocks.lever, 1, OreDictionary.WILDCARD_VALUE)});

        GT_ModHandler.addCraftingRecipe(ItemList.RC_ShuntingWireFrame.get(6L), tBitMask, new Object[]{"PPP", "R" + tWrench + "R", "RRR", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'R', ItemList.RC_Rebar.get(1L)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 0), tBitMask, new Object[]{"IOI", "GEG", "IOI", 'I', tIngot.get(MaterialsOld.Gold), 'G', OrePrefixes.gem.get(MaterialsOld.Diamond), 'E', OrePrefixes.gem.get(MaterialsOld.EnderPearl), 'O', OrePrefixes.stone.get(MaterialsOld.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 3L, 1), tBitMask, new Object[]{"BPB", "P" + tWrench + "P", "BPB", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'B', OrePrefixes.block.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 2), tBitMask, new Object[]{"IOI", "GEG", "IOI", 'I', tIngot.get(MaterialsOld.Gold), 'G', OrePrefixes.gem.get(MaterialsOld.Emerald), 'E', OrePrefixes.gem.get(MaterialsOld.EnderPearl), 'O', OrePrefixes.stone.get(MaterialsOld.Obsidian)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 4L, 3), tBitMask, new Object[]{"PPP", "PFP", "PPP", 'P', OrePrefixes.plate.get(MaterialsOld.Steel), 'F', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 5), tBitMask, new Object[]{" N ", "RCR", 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'N', OrePrefixes.stone.get(MaterialsOld.Netherrack), 'C', new ItemStack(Items.cauldron, 1, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 6), tBitMask, new Object[]{"SGS", "EDE", "SGS", 'E', OrePrefixes.gem.get(MaterialsOld.Emerald), 'S', OrePrefixes.plate.get(MaterialsOld.Steel), 'G', new ItemStack(Blocks.glass_pane, 1, OreDictionary.WILDCARD_VALUE), 'D', new ItemStack(Blocks.dispenser, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 8), tBitMask, new Object[]{"IPI", "PCP", "IPI", 'P', OreDictNames.craftingPiston, 'I', tIngot.get(MaterialsOld.AnyIron), 'C', new ItemStack(Blocks.crafting_table, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 9), tBitMask, new Object[]{" I ", " T ", " D ", 'I', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), 'D', new ItemStack(Blocks.dispenser, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 10), tBitMask, new Object[]{" I ", "RTR", " D ", 'I', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE), 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), 'D', new ItemStack(Blocks.dispenser, 1, OreDictionary.WILDCARD_VALUE), 'R', OrePrefixes.dust.get(MaterialsOld.Redstone)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 10), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RTR", 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 9), 'R', OrePrefixes.dust.get(MaterialsOld.Redstone)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 11), tBitMask, new Object[]{"PCP", "CSC", "PCP", 'P', OrePrefixes.plank.get(MaterialsOld.Wood), 'S', OrePrefixes.plate.get(MaterialsOld.Steel), 'C', new ItemStack(Items.golden_carrot, 1, 0)});
        if (GregTech_API.sMachineFile.get(ConfigCategories.machineconfig, "DisableRCBlastFurnace", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 4L, 12));
        }
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 1L, 13), tBitMask, new Object[]{"TSB", "SCS", "PSP", 'P', OreDictNames.craftingPiston, 'S', OrePrefixes.plate.get(MaterialsOld.Steel), 'B', OreDictNames.craftingBook, 'C', new ItemStack(Blocks.crafting_table, 1, OreDictionary.WILDCARD_VALUE), 'T', new ItemStack(Items.diamond_pickaxe, 1, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 6L, 14), tBitMask, new Object[]{"PPP", "ISI", "PPP", 'P', OrePrefixes.plank.get(MaterialsOld.Wood), 'I', tIngot.get(MaterialsOld.AnyIron), 'S', "slimeball"});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, RCA, 4L, 15), tBitMask, new Object[]{"PDP", "DBD", "PDP", 'P', OreDictNames.craftingPiston, 'B', OrePrefixes.block.get(MaterialsOld.Steel), 'D', OrePrefixes.gem.get(MaterialsOld.Diamond)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "machine.epsilon", 1L, 0), tBitMask, new Object[]{"PWP", "WWW", "PWP", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron), 'W', OrePrefixes.wireGt02.get(MaterialsOld.Copper)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "tool.crowbar", 1L, 0), tBitMask, new Object[]{tHammer + "DS", "DSD", "SD" + tFile, 'S', OrePrefixes.ingot.get(MaterialsOld.Iron), 'D', Dyes.dyeRed});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "tool.crowbar.reinforced", 1L, 0), tBitMask, new Object[]{tHammer + "DS", "DSD", "SD" + tFile, 'S', OrePrefixes.ingot.get(MaterialsOld.Steel), 'D', Dyes.dyeRed});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "tool.whistle.tuner", 1L, 0), tBitMask | GT_ModHandler.RecipeBits.MIRRORED, new Object[]{"S" + tHammer + "S", "SSS", " S" + tFile, 'S', OrePrefixes.nugget.get(MaterialsOld.Iron)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.blade", 1L, 0), tBitMask, new Object[]{"S" + tFile, "S ", "S" + tHammer, 'S', tIngot.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.disk", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(MaterialsOld.Steel), 'S', GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.blade", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.rotor", 1L, 0), tBitMask, new Object[]{"SSS", " " + tWrench + " ", 'S', GT_ModHandler.getModItem(MOD_ID_RC, "part.turbine.disk", 1L, 0)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "borehead.iron", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(MaterialsOld.Iron), 'S', tIngot.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "borehead.steel", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(MaterialsOld.Steel), 'S', tIngot.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "borehead.diamond", 1L, 0), tBitMask, new Object[]{"SSS", "SBS", "SSS", 'B', OrePrefixes.block.get(MaterialsOld.Diamond), 'S', tIngot.get(MaterialsOld.Steel)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "cart.loco.steam.solid", 1L, 0), tBitMask, new Object[]{"TTF", "TTF", "BCC", 'C', new ItemStack(Items.minecart, 1), 'T', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 4), 'F', GT_ModHandler.getModItem(MOD_ID_RC, RCB, 1L, 5), 'B', new ItemStack(Blocks.iron_bars, 1, OreDictionary.WILDCARD_VALUE)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "cart.loco.electric", 1L, 0), tBitMask, new Object[]{"LP" + tWrench, "PEP", "GCG", 'C', new ItemStack(Items.minecart, 1), 'E', GT_ModHandler.getModItem(MOD_ID_RC, "machine.epsilon", 1L, 0), 'G', GT_ModHandler.getModItem(MOD_ID_RC, RCGEAR, 1L, 2), 'L', new ItemStack(Blocks.redstone_lamp, 1, OreDictionary.WILDCARD_VALUE), 'P', OrePrefixes.plate.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_RC, "cart.bore", 1L, 0), tBitMask, new Object[]{"BCB", "FCF", tHammer + "A" + tWrench, 'C', new ItemStack(Items.minecart, 1), 'A', new ItemStack(Items.chest_minecart, 1), 'F', OreDictNames.craftingFurnace, 'B', OrePrefixes.block.get(MaterialsOld.Steel)});

        GT_Log.out.println("GT_Mod: Beginning to add regular Crafting Recipes.");
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("scaffold", 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", " S ", "S S", 'W', OrePrefixes.plank.get(MaterialsOld.Wood), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});

        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsOld.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT", 'H', OrePrefixes.cell.get(MaterialsOld.Helium), 'N', OrePrefixes.cell.get(MaterialsOld.Nitrogen), 'T', OrePrefixes.pipeTiny.get(MaterialsOld.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(MaterialsOld.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsOld.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT", 'H', OrePrefixes.cell.get(MaterialsOld.Helium), 'N', OrePrefixes.cell.get(MaterialsOld.Nitrogen), 'T', OrePrefixes.pipeTiny.get(MaterialsOld.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(MaterialsOld.VanadiumGallium)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsOld.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT", 'N', OrePrefixes.cell.get(MaterialsOld.Nitrogen), 'T', OrePrefixes.pipeTiny.get(MaterialsOld.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(MaterialsOld.YttriumBariumCuprate)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, MaterialsOld.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT", 'N', OrePrefixes.cell.get(MaterialsOld.Nitrogen), 'T', OrePrefixes.pipeTiny.get(MaterialsOld.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(MaterialsOld.Naquadah)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, MaterialsOld.IronMagnetic, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(MaterialsOld.AnyIron), OrePrefixes.dust.get(MaterialsOld.Redstone), OrePrefixes.dust.get(MaterialsOld.Redstone), OrePrefixes.dust.get(MaterialsOld.Redstone), OrePrefixes.dust.get(MaterialsOld.Redstone)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Gold.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.Gold)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Iron.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.AnyIron)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Bronze.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.Bronze)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Copper.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Tin.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Lead.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.Lead)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Item_Casing_Steel.get(1L), new Object[]{"h P", 'P', OrePrefixes.plate.get(MaterialsOld.Steel)});

        GT_ModHandler.addCraftingRecipe(ItemList.PlatinumGroupSludge.get(1), new Object[]{"DDD","DDD","DDD", 'D', ItemList.PlatinumGroupSludgeTiny.get(1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.PlatinumGroupSludgeTiny.get(9), new Object[]{ItemList.PlatinumGroupSludge.get(1)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(MaterialsOld.Sulfur), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(MaterialsOld.Phosphorus), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(MaterialsOld.Charcoal), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dustImpure.get(MaterialsOld.Coal), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.crushed.get(MaterialsOld.Coal), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 4), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.crushedPurified.get(MaterialsOld.Coal), 'S', OrePrefixes.stick.get(MaterialsOld.Wood)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(MaterialsOld.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'B', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(MaterialsOld.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'B', OrePrefixes.ingot.get(MaterialsOld.AnyBronze)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(MaterialsOld.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'B', OrePrefixes.ingot.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(MaterialsOld.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'B', OrePrefixes.ingot.get(MaterialsOld.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "CBC", "CRC", 'W', OrePrefixes.plank.get(MaterialsOld.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'B', OrePrefixes.ingot.get(MaterialsOld.Titanium)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("reactorVent", 1L, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"AIA", "I I", "AIA", 'I', new ItemStack(Blocks.iron_bars, 1), 'A', OrePrefixes.plate.get(MaterialsOld.Aluminium)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getIC2Item("reactorPlatingExplosive", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{GT_ModHandler.getIC2Item("reactorPlating", 1L), OrePrefixes.plate.get(MaterialsOld.Lead)});
        if (!MaterialsOld.Steel.mBlastFurnaceRequired) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Steel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Coal), OrePrefixes.dust.get(MaterialsOld.Coal)});
        }
        if (GT_Mod.gregtechproxy.mNerfDustCrafting) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Electrum, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.Gold)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Brass, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Bronze, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Invar, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Nickel)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Cupronickel, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Nichrome, 15L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Chrome)});
        } else {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Electrum, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.Gold)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Brass, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Bronze, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Invar, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Nickel)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Cupronickel, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Nichrome, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Chrome)});
        }
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.RoseGold, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.SterlingSilver, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.BlackBronze, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.BismuthBronze, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Bismuth), OrePrefixes.dust.get(MaterialsOld.Zinc), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.BlackSteel, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.BlackBronze), OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.Steel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.RedSteel, 8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.SterlingSilver), OrePrefixes.dust.get(MaterialsOld.BismuthBronze), OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.BlackSteel), OrePrefixes.dust.get(MaterialsOld.BlackSteel), OrePrefixes.dust.get(MaterialsOld.BlackSteel), OrePrefixes.dust.get(MaterialsOld.BlackSteel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.BlueSteel, 8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.RoseGold), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.BlackSteel), OrePrefixes.dust.get(MaterialsOld.BlackSteel), OrePrefixes.dust.get(MaterialsOld.BlackSteel), OrePrefixes.dust.get(MaterialsOld.BlackSteel)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Ultimet, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Cobalt), OrePrefixes.dust.get(MaterialsOld.Cobalt), OrePrefixes.dust.get(MaterialsOld.Cobalt), OrePrefixes.dust.get(MaterialsOld.Cobalt), OrePrefixes.dust.get(MaterialsOld.Cobalt), OrePrefixes.dust.get(MaterialsOld.Chrome), OrePrefixes.dust.get(MaterialsOld.Chrome), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Molybdenum)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.CobaltBrass, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Brass), OrePrefixes.dust.get(MaterialsOld.Aluminium), OrePrefixes.dust.get(MaterialsOld.Cobalt)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.StainlessSteel, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Nickel), OrePrefixes.dust.get(MaterialsOld.Manganese), OrePrefixes.dust.get(MaterialsOld.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.YttriumBariumCuprate, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Yttrium), OrePrefixes.dust.get(MaterialsOld.Barium), OrePrefixes.dust.get(MaterialsOld.Barium), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper), OrePrefixes.dust.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Kanthal, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Aluminium), OrePrefixes.dust.get(MaterialsOld.Chrome)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.RedstoneAlloy, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Redstone), OrePrefixes.dust.get(MaterialsOld.Silicon), OrePrefixes.dust.get(MaterialsOld.Coal)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.ConductiveIron, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.RedstoneAlloy), OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.Titanium)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.EnergeticAlloy, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.ConductiveIron), OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.TungstenSteel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.VibrantAlloy, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.EnergeticAlloy), OrePrefixes.dust.get(MaterialsOld.EnderEye), OrePrefixes.dust.get(MaterialsOld.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.ElectricalSteel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Steel), OrePrefixes.dust.get(MaterialsOld.Coal), OrePrefixes.dust.get(MaterialsOld.Silicon)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.PulsatingIron, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.EnderPearl), OrePrefixes.dust.get(MaterialsOld.RedstoneAlloy)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Soularium, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.soul_sand, 1, OreDictionary.WILDCARD_VALUE), OrePrefixes.dust.get(MaterialsOld.Gold), OrePrefixes.dust.get(MaterialsOld.Ash)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.DarkSteel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.ElectricalSteel), OrePrefixes.dust.get(MaterialsOld.Coal), OrePrefixes.dust.get(MaterialsOld.Obsidian)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.EnderiumBase, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Tin), OrePrefixes.dust.get(MaterialsOld.Tin), OrePrefixes.dust.get(MaterialsOld.Silver), OrePrefixes.dust.get(MaterialsOld.Platinum)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Enderium, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.EnderiumBase), OrePrefixes.dust.get(MaterialsOld.EnderiumBase), OrePrefixes.dust.get(MaterialsOld.Thaumium), OrePrefixes.dust.get(MaterialsOld.EnderPearl)});
        
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Ultimet, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(MaterialsOld.Cobalt), OrePrefixes.dustTiny.get(MaterialsOld.Cobalt), OrePrefixes.dustTiny.get(MaterialsOld.Cobalt), OrePrefixes.dustTiny.get(MaterialsOld.Cobalt), OrePrefixes.dustTiny.get(MaterialsOld.Cobalt), OrePrefixes.dustTiny.get(MaterialsOld.Chrome), OrePrefixes.dustTiny.get(MaterialsOld.Chrome), OrePrefixes.dustTiny.get(MaterialsOld.Nickel), OrePrefixes.dustTiny.get(MaterialsOld.Molybdenum)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.CobaltBrass, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Brass), OrePrefixes.dustTiny.get(MaterialsOld.Aluminium), OrePrefixes.dustTiny.get(MaterialsOld.Cobalt)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.StainlessSteel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Nickel), OrePrefixes.dustTiny.get(MaterialsOld.Manganese), OrePrefixes.dustTiny.get(MaterialsOld.Chrome)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, MaterialsOld.YttriumBariumCuprate, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(MaterialsOld.Yttrium), OrePrefixes.dustTiny.get(MaterialsOld.Barium), OrePrefixes.dustTiny.get(MaterialsOld.Barium), OrePrefixes.dustTiny.get(MaterialsOld.AnyCopper), OrePrefixes.dustTiny.get(MaterialsOld.AnyCopper), OrePrefixes.dustTiny.get(MaterialsOld.AnyCopper)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, MaterialsOld.Kanthal, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(MaterialsOld.Iron), OrePrefixes.dustTiny.get(MaterialsOld.Aluminium), OrePrefixes.dustTiny.get(MaterialsOld.Chrome)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.IronWood, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Iron), OrePrefixes.dust.get(MaterialsOld.LiveRoot), OrePrefixes.dustTiny.get(MaterialsOld.Gold)});

        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 3), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Coal), OrePrefixes.dust.get(MaterialsOld.Sulfur), OrePrefixes.dust.get(MaterialsOld.Saltpeter), OrePrefixes.dust.get(MaterialsOld.Saltpeter)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Charcoal), OrePrefixes.dust.get(MaterialsOld.Sulfur), OrePrefixes.dust.get(MaterialsOld.Saltpeter), OrePrefixes.dust.get(MaterialsOld.Saltpeter)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Saltpeter, 5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(MaterialsOld.Potassium), OrePrefixes.cell.get(MaterialsOld.Nitrogen), OrePrefixes.cell.get(MaterialsOld.Oxygen), OrePrefixes.cell.get(MaterialsOld.Oxygen), OrePrefixes.cell.get(MaterialsOld.Oxygen)});
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
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("batBox", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PCP", "BBB", "PPP", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Tin), 'P', OrePrefixes.plank.get(MaterialsOld.Wood), 'B', OrePrefixes.battery.get(MaterialsOld.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("mfeUnit", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("mfeUnit", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CEC", "EME", "CEC", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Gold), 'E', OrePrefixes.battery.get(MaterialsOld.Elite), 'M', GT_ModHandler.getIC2Item(IC2M, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("lvTransformer", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("lvTransformer", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PCP", "POP", "PCP", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Tin), 'O', GT_ModHandler.getIC2Item("coil", 1L), 'P', OrePrefixes.plank.get(MaterialsOld.Wood)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(MVT, 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(MVT, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CMC", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'M', GT_ModHandler.getIC2Item(IC2M, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(HVT, 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(HVT, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "IMB", " C ", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Gold), 'M', GT_ModHandler.getIC2Item(MVT, 1L), 'I', OrePrefixes.circuit.get(MaterialsOld.Basic), 'B', OrePrefixes.battery.get(MaterialsOld.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("evTransformer", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("evTransformer", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "IMB", " C ", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Aluminium), 'M', GT_ModHandler.getIC2Item(HVT, 1L), 'I', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'B', OrePrefixes.battery.get(MaterialsOld.Master)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cesuUnit", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("cesuUnit", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PCP", "BBB", "PPP", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'P', OrePrefixes.plate.get(MaterialsOld.Bronze), 'B', OrePrefixes.battery.get(MaterialsOld.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(LUM, 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("teleporter", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("teleporter", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GFG", "CMC", "GDG", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Platinum), 'G', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'D', OrePrefixes.gem.get(MaterialsOld.Diamond), 'M', GT_ModHandler.getIC2Item(IC2M, 1L), 'F', GT_ModHandler.getIC2Item(FREQT, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("energyOMat", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("energyOMat", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RBR", "CMC", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'M', GT_ModHandler.getIC2Item(IC2M, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("advBattery", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("advBattery", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CTC", "TST", "TLT", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'S', OrePrefixes.dust.get(MaterialsOld.Sulfur), 'L', OrePrefixes.dust.get(MaterialsOld.Lead), 'T', GT_ModHandler.getIC2Item("casingbronze", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("boatElectric", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("boatElectric", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "XWX", "XXX", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'X', OrePrefixes.plate.get(MaterialsOld.Iron), 'W', GT_ModHandler.getIC2Item("waterMill", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cropnalyzer", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("cropnalyzer", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CC ", "RGR", "RIR", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'G', OrePrefixes.block.get(MaterialsOld.Glass), 'I', OrePrefixes.circuit.get(MaterialsOld.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("coil", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("coil", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "CXC", "CCC", 'C', OrePrefixes.wireGt01.get(MaterialsOld.Copper), 'X', OrePrefixes.ingot.get(MaterialsOld.AnyIron)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("powerunit", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("powerunit", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"BCA", "BIM", "BCA", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'A', GT_ModHandler.getIC2Item("casingiron", 1L), 'I', OrePrefixes.circuit.get(MaterialsOld.Basic), 'M', GT_ModHandler.getIC2Item("elemotor", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("powerunitsmall", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("powerunitsmall", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" CA", "BIM", " CA", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'A', GT_ModHandler.getIC2Item("casingiron", 1L), 'I', OrePrefixes.circuit.get(MaterialsOld.Basic), 'M', GT_ModHandler.getIC2Item("elemotor", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("remote", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("remote", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "TLT", " F ", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'L', OrePrefixes.dust.get(MaterialsOld.Lapis), 'T', GT_ModHandler.getIC2Item("casingtin", 1L), 'F', GT_ModHandler.getIC2Item(FREQT, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(ODS, 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(ODS, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PGP", "CBC", "WWW", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'G', OrePrefixes.dust.get(MaterialsOld.Glowstone), 'B', OrePrefixes.battery.get(MaterialsOld.Advanced), 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'P', GT_ModHandler.getIC2Item("casinggold", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ovScanner", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ovScanner", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PDP", "GCG", "WSW", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Gold), 'G', OrePrefixes.dust.get(MaterialsOld.Glowstone), 'D', OrePrefixes.battery.get(MaterialsOld.Elite), 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'P', GT_ModHandler.getIC2Item("casinggold", 1L), 'S', GT_ModHandler.getIC2Item(ODS, 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("solarHelmet", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("staticBoots", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("staticBoots", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"I I", "IWI", "CCC", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'I', OrePrefixes.ingot.get(MaterialsOld.Iron), 'W', new ItemStack(Blocks.wool)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ecMeter", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ecMeter", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" G ", "CIC", "C C", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'G', OrePrefixes.dust.get(MaterialsOld.Glowstone), 'I', OrePrefixes.circuit.get(MaterialsOld.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("obscurator", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("obscurator", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RER", "CAC", "RRR", 'C', OrePrefixes.cableGt01.get(MaterialsOld.Gold), 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'E', OrePrefixes.battery.get(MaterialsOld.Advanced), 'A', OrePrefixes.circuit.get(MaterialsOld.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("overclockerUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("overclockerUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "WEW", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'C', GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1), 'E', OrePrefixes.circuit.get(MaterialsOld.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("transformerUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("transformerUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "WTW", "GEG", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Gold), 'T', GT_ModHandler.getIC2Item(MVT, 1L), 'E', OrePrefixes.circuit.get(MaterialsOld.Basic), 'G', OrePrefixes.block.get(MaterialsOld.Glass)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("energyStorageUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("energyStorageUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PPP", "WBW", "PEP", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'E', OrePrefixes.circuit.get(MaterialsOld.Basic), 'P', OrePrefixes.plank.get(MaterialsOld.Wood), 'B', OrePrefixes.battery.get(MaterialsOld.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ejectorUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ejectorUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PHP", "WEW", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'E', OrePrefixes.circuit.get(MaterialsOld.Basic), 'P', new ItemStack(Blocks.piston), 'H', new ItemStack(Blocks.hopper)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("suBattery", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("suBattery", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"W", "C", "R", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'C', OrePrefixes.dust.get(MaterialsOld.HydratedCoal), 'R', OrePrefixes.dust.get(MaterialsOld.Redstone)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(FREQT, 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("pullingUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("pullingUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PHP", "WEW", 'W', OrePrefixes.cableGt01.get(MaterialsOld.Copper), 'P', new ItemStack(Blocks.sticky_piston), 'R', new ItemStack(Blocks.hopper), 'E', OrePrefixes.circuit.get(MaterialsOld.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cutter", 1L));
        } else {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(GFIBER, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "EDE", "GGG", 'G', new ItemStack(Blocks.glass, 1, OreDictionary.WILDCARD_VALUE), 'D', OrePrefixes.dust.get(MaterialsOld.Silver), 'E', ItemList.IC2_Energium_Dust.get(1L)});
        }

        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Energium_Dust.get(1L));
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.gregtechrecipes, "energycrystalruby", true)) {
            GT_ModHandler.addCraftingRecipe(ItemList.IC2_Energium_Dust.get(9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RDR", "DRD", "RDR", 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'D', OrePrefixes.dust.get(MaterialsOld.Ruby)});
        } else {
            GT_ModHandler.addCraftingRecipe(ItemList.IC2_Energium_Dust.get(9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RDR", "DRD", "RDR", 'R', OrePrefixes.dust.get(MaterialsOld.Redstone), 'D', OrePrefixes.dust.get(MaterialsOld.Diamond)});
        }
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(LCRYST, 1L));
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'S', GT_ModHandler.getIC2Item("energyCrystal", 1L, OreDictionary.WILDCARD_VALUE), 'L', OrePrefixes.dust.get(MaterialsOld.Lazurite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'S', GT_ModHandler.getIC2Item("energyCrystal", 1L, OreDictionary.WILDCARD_VALUE), 'L', OrePrefixes.dust.get(MaterialsOld.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'S', OrePrefixes.gem.get(MaterialsOld.Sapphire), 'L', OrePrefixes.dust.get(MaterialsOld.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'S', OrePrefixes.gem.get(MaterialsOld.Sapphire), 'L', OrePrefixes.dust.get(MaterialsOld.Lazurite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Good), 'S', OrePrefixes.gemFlawless.get(MaterialsOld.Sapphire), 'L', OrePrefixes.dust.get(MaterialsOld.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Good), 'S', OrePrefixes.gemFlawless.get(MaterialsOld.Sapphire), 'L', OrePrefixes.dust.get(MaterialsOld.Lazurite)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Basic), 'S', OrePrefixes.gemExquisite.get(MaterialsOld.Sapphire), 'L', OrePrefixes.dust.get(MaterialsOld.Lapis)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LCRYST, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"LCL", "LSL", "LCL", 'C', OrePrefixes.circuit.get(MaterialsOld.Basic), 'S', OrePrefixes.gemExquisite.get(MaterialsOld.Sapphire), 'L', OrePrefixes.dust.get(MaterialsOld.Lazurite)});

        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LUM, 16L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RTR", "GHG", "GGG", 'H', OrePrefixes.cell.get(MaterialsOld.Helium), 'T', OrePrefixes.ingot.get(MaterialsOld.Tin), 'R', OrePrefixes.ingot.get(MaterialsOld.AnyIron), 'G', new ItemStack(Blocks.glass, 1)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(LUM, 16L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RTR", "GHG", "GGG", 'H', OrePrefixes.cell.get(MaterialsOld.Mercury), 'T', OrePrefixes.ingot.get(MaterialsOld.Tin), 'R', OrePrefixes.ingot.get(MaterialsOld.AnyIron), 'G', new ItemStack(Blocks.glass, 1)});

        if (Loader.isModLoaded(MOD_ID_GS)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1, 6));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1, 6), new Object[]{"GPG", "CUC", "PVP", 'G', OrePrefixes.dust.get(MaterialsOld.Glowstone), 'P', GT_ModHandler.getIC2Item("advancedAlloy", 1), 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced),'U', OrePrefixes.plate.get(MaterialsOld.Titanium), 'V', OrePrefixes.plate.get(MaterialsOld.StainlessSteel)});
        }
        if (Loader.isModLoaded(MOD_ID_GS) && (GT_Mod.gregtechproxy.mDisableIC2Cables)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, ADVJET, 1));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, ADVJET, 1), new Object[]{"PJP", "BLB", "WCW", 'P', OrePrefixes.plateAlloy.get(MaterialsOld.Carbon), 'J', GT_ModHandler.getIC2Item("electricJetpack", 1), 'B', GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1, 6), 'L', GT_ModHandler.getModItem(MOD_ID_GS, "advLappack", 1), 'W', OrePrefixes.wireGt04.get(MaterialsOld.Platinum), 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced)});

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 3, 1));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 3, 1), new Object[]{"CCC", "WWW", "CCC", 'C', GT_ModHandler.getModItem(MOD_ID_GS, GSITEM, 1), 'W', OrePrefixes.wireGt01.get(MaterialsOld.Superconductor)});

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(MOD_ID_GS, "advNanoChestPlate", 1));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem(MOD_ID_GS, "advNanoChestPlate", 1), new Object[]{"PJP", "PLP", "WCW", 'P', OrePrefixes.plateAlloy.get(MaterialsOld.Carbon), 'J', GT_ModHandler.getModItem(MOD_ID_GS, ADVJET, 1), 'L', GT_ModHandler.getIC2Item("nanoBodyarmor", 1), 'W', OrePrefixes.wireGt04.get(MaterialsOld.Platinum), 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced)});
        }

        GT_ModHandler.removeRecipe(tStack = GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Sulfur, 1L), tStack, tStack, tStack, new ItemStack(Items.coal, 1, 0), tStack, tStack, tStack, tStack);
        GT_ModHandler.removeRecipe(tStack = GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Sulfur, 1L), tStack, tStack, tStack, new ItemStack(Items.coal, 1, 1), tStack, tStack, tStack, tStack);
        GT_ModHandler.removeRecipe(null, tStack = new ItemStack(Items.coal, 1), null, tStack, GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Iron, 1L), tStack, null, tStack, null);

        GT_ModHandler.removeFurnaceSmelting(new ItemStack(Blocks.hopper));

        GT_Log.out.println("GT_Mod: Applying harder Recipes for several Blocks.");
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "blockbreaker", false)) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.removeRecipe(new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.iron_pickaxe, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.piston, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.redstone, 1), new ItemStack(Blocks.cobblestone, 1)), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RGR", "RPR", "RCR", 'G', OreDictNames.craftingGrinder, 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'R', OrePrefixes.plate.get(MaterialsOld.Steel), 'P', OreDictNames.craftingPiston});
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "beryliumreflector", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorReflectorThick", 1L, 1)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("reactorReflectorThick", 1L, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" N ", "NBN", " N ", 'B', OrePrefixes.plate.get(MaterialsOld.Beryllium), 'N', GT_ModHandler.getIC2Item("reactorReflector", 1L, 1)});
        }
        if (GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Diamond, 1L) != null) {
            tStack = GT_ModHandler.getRecipeOutput(GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Iron, 1L), new ItemStack(Items.redstone, 1), GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Diamond, 1L), new ItemStack(Items.diamond_pickaxe, 1), GT_OreDictUnificator.get(OrePrefixes.gear, MaterialsOld.Diamond, 1L));
            if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "quarry", true)) {
                GT_ModHandler.removeRecipeByOutput(tStack);
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"ICI", "GIG", "DPD", 'C', OrePrefixes.circuit.get(MaterialsOld.Advanced), 'D', OrePrefixes.gear.get(MaterialsOld.Diamond), 'G', OrePrefixes.gear.get(MaterialsOld.Gold), 'I', OrePrefixes.gear.get(MaterialsOld.Steel), 'P', GT_ModHandler.getIC2Item(DRILL2, 1L, OreDictionary.WILDCARD_VALUE)});
            }
            if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "quarry", false)) {
                GT_ModHandler.removeRecipeByOutput(tStack);
            }
        }
        GT_Log.out.println("GT_Mod: Applying Recipes for Tools");
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "nanosaber", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoSaber", 1L)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("nanoSaber", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PI ", "PI ", "CLC", 'L', OrePrefixes.battery.get(MaterialsOld.Master), 'I', OrePrefixes.plateAlloy.get("Iridium"), 'P', OrePrefixes.plate.get(MaterialsOld.Platinum), 'C', OrePrefixes.circuit.get(MaterialsOld.Master)});
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "namefix", true)) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.flint_and_steel, 1)) ? new ItemStack(Items.flint_and_steel, 1) : null, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"S ", " F", 'F', new ItemStack(Items.flint, 1), 'S', "nuggetSteel"});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(DRILL2, 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(DRILL2, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" D ", "DMD", "TAT", 'M', GT_ModHandler.getIC2Item(DRILL1, 1L, OreDictionary.WILDCARD_VALUE), 'D', OreDictNames.craftingIndustrialDiamond, 'T', OrePrefixes.plate.get(MaterialsOld.Titanium), 'A', OrePrefixes.circuit.get(MaterialsOld.Advanced)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(DRILL1, 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item(DRILL1, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" S ", "SCS", "SBS", 'C', OrePrefixes.circuit.get(MaterialsOld.Basic), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(MaterialsOld.StainlessSteel) : OrePrefixes.plate.get(MaterialsOld.Iron)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("chainsaw", 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("chainsaw", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"BS ", "SCS", " SS", 'C', OrePrefixes.circuit.get(MaterialsOld.Basic), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(MaterialsOld.StainlessSteel) : OrePrefixes.plate.get(MaterialsOld.Iron)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electricHoe", 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("electricHoe", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"SS ", " C ", " B ", 'C', OrePrefixes.circuit.get(MaterialsOld.Basic), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(MaterialsOld.StainlessSteel) : OrePrefixes.plate.get(MaterialsOld.Iron)});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electricTreetap", 1L))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("electricTreetap", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" B ", "SCS", "S  ", 'C', OrePrefixes.circuit.get(MaterialsOld.Basic), 'B', OrePrefixes.battery.get(MaterialsOld.Basic), 'S', GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, ECTOOLS, true) ? OrePrefixes.plate.get(MaterialsOld.StainlessSteel) : OrePrefixes.plate.get(MaterialsOld.Iron)});
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
