package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingPlank implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingPlank() {
        OrePrefixes.plank.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.startsWith("plankWood")) {
            RECIPE_ADDER_INSTANCE.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), null, 10, 8);
            RECIPE_ADDER_INSTANCE.addCNCRecipe(GT_Utility.copyAmount(4L, aStack), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Wood, 1L), 800, 1);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(8L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), new ItemStack(Blocks.noteblock, 1), 200, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(8L, aStack), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1L), new ItemStack(Blocks.jukebox, 1), 400, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L), ItemList.Crate_Empty.get(1L), 200, 1);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.WroughtIron, 1L), ItemList.Crate_Empty.get(1L), 200, 1);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L), ItemList.Crate_Empty.get(1L), 200, 1);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new ItemStack(Blocks.wooden_button, 1), 100, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(2L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new ItemStack(Blocks.wooden_pressure_plate, 1), 200, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(3L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new ItemStack(Blocks.trapdoor, 1), 300, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(4L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new ItemStack(Blocks.crafting_table, 1), 400, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(6L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new ItemStack(Items.wooden_door, 1), 600, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(8L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), new ItemStack(Blocks.chest, 1), 800, 4);
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(6L, aStack), new ItemStack(Items.book, 3), new ItemStack(Blocks.bookshelf, 1), 400, 4);

            if (aStack.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
                for (byte i = 0; i < 64; i = (byte) (i + 1)) {
                    ItemStack tStack = GT_Utility.copyMetaData(i, aStack);
                    ItemStack tOutput = GT_ModHandler.getRecipeOutput(tStack, tStack, tStack);
                    if ((tOutput != null) && (tOutput.stackSize >= 3)) {
                        RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, tStack), GT_Utility.copyAmount(tOutput.stackSize / 3, tOutput), null, 25, 4);
                        GT_ModHandler.removeRecipe(tStack, tStack, tStack);
                        GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(tOutput.stackSize / 3, tOutput), new Object[]{"sP", 'P', tStack});
                    }
                                        if(tStack==null){
                                        	if(i>=16){
                                        		break;
                                  	}
                    }
                }
            } else {
                ItemStack tOutput = GT_ModHandler.getRecipeOutput(aStack, aStack, aStack);
                if ((tOutput != null) && (tOutput.stackSize >= 3)) {
                    RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_Utility.copyAmount(tOutput.stackSize / 3, tOutput), null, 25, 4);
                    GT_ModHandler.removeRecipe(aStack, aStack, aStack);
                    GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(tOutput.stackSize / 3, tOutput), new Object[]{"sP", 'P', aStack});
                }
            }
        }
    }
}