package gregtech.loaders.oreprocessing;

import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingBlock implements gregtech.api.interfaces.IOreRecipeRegistrator {

	private boolean isGem = false;

	public ProcessingBlock() {
		OrePrefixes.block.add(this);
	}

	public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
		RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L), null, (int) Math.max(aMaterial.getMass() * 10L, 1L), 30);

		ItemStack tStack1 = GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L);
		ItemStack tStack2 = GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L);
		ItemStack tStack3 = GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L);

		GT_ModHandler.removeRecipe(GT_Utility.copyAmount(1L, aStack));

		if (tStack1 != null) {
			GT_ModHandler.removeRecipe(tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1);
		}
		if (tStack2 != null) {
			GT_ModHandler.removeRecipe(tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2);
		}
		if (tStack3 != null) {
			GT_ModHandler.removeRecipe(tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3);
		}
		if (aMaterial.mStandardMoltenFluid != null) {
			RECIPE_ADDER_INSTANCE.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), aMaterial.getMolten(1296L), GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), 288, 8);
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockcrafting, OrePrefixes.block.get(aMaterial).toString(), false)) {
			if ((tStack1 == null) && (tStack2 == null) && (tStack3 != null)){
				GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[]{"XXX", "XXX", "XXX", 'X', OrePrefixes.dust.get(aMaterial)});
			}
			if (tStack2 != null){ 
				GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[]{"XXX", "XXX", "XXX", 'X', OrePrefixes.gem.get(aMaterial)});
			}
			if (tStack1 != null) {
				GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[]{"XXX", "XXX", "XXX", 'X', OrePrefixes.ingot.get(aMaterial)});
			}
		}

        isGem = aMaterial.contains(SubTag.CRYSTAL) && !aMaterial.contains(SubTag.METAL);
		//Ingot
		if (tStack1 != null) {
			tStack1.stackSize = 9;
		}
		//Gem
		if (tStack2 != null && !isGem) {
			tStack2.stackSize = 9;
		}
		else if (tStack2 != null && isGem) {
			tStack2.stackSize = 0;
		}
		//Dust
		if (tStack3 != null && !isGem) {
			tStack3.stackSize = 9;
		}
		else if (tStack3 != null && isGem) {
			tStack3.stackSize = 0;
		}

		//Gems in FORGE HAMMER
		if (tStack2 != null && !isGem) {
			tStack2.stackSize = 9;
			RECIPE_ADDER_INSTANCE.addForgeHammerRecipe(aStack, tStack2, 100, 24);
		}
		else if (tStack2 != null && isGem) {
			tStack2.stackSize = 9;
			RECIPE_ADDER_INSTANCE.addForgeHammerRecipe(aStack, tStack2, 100, 24);
			tStack2.stackSize = 0;
		}


		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockdecrafting, OrePrefixes.block.get(aMaterial).toString(), tStack2 != null)) {
			if (tStack3 != null)
				GT_ModHandler.addShapelessCraftingRecipe(tStack3, new Object[]{OrePrefixes.block.get(aMaterial)});
			if (tStack2 != null)
				GT_ModHandler.addShapelessCraftingRecipe(tStack2, new Object[]{OrePrefixes.block.get(aMaterial)});
			if (tStack1 != null) {
				GT_ModHandler.addShapelessCraftingRecipe(tStack1, new Object[]{OrePrefixes.block.get(aMaterial)});
			}
		}
		switch (aMaterial.name()) {
		case "Mercury":
			System.err.println("'blockQuickSilver'?, In which Ice Desert can you actually place this as a solid Block?");
			break;
		case "Iron":
		case "WroughtIron":
			RECIPE_ADDER_INSTANCE.addExtruderRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Shape_Extruder_Rod.get(0L), ItemList.IC2_ShaftIron.get(1L), 640, 120);
			RECIPE_ADDER_INSTANCE.addAssemblerRecipe(ItemList.IC2_Compressed_Coal_Ball.get(8L), GT_Utility.copyAmount(1L, aStack), ItemList.IC2_Compressed_Coal_Chunk.get(1L), 400, 4);
			break;
		case "Steel":
			RECIPE_ADDER_INSTANCE.addExtruderRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Shape_Extruder_Rod.get(0L), ItemList.IC2_ShaftSteel.get(1L), 1280, 120);
			RECIPE_ADDER_INSTANCE.addAssemblerRecipe(ItemList.IC2_Compressed_Coal_Ball.get(8L), GT_Utility.copyAmount(1L, aStack), ItemList.IC2_Compressed_Coal_Chunk.get(1L), 400, 4);
		}
	}
}
