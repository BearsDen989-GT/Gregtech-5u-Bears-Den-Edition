package gregtech.loaders.postload;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_DummyWorld;

import java.util.Arrays;

import mods.railcraft.common.blocks.aesthetics.cube.EnumCube;
import mods.railcraft.common.items.RailcraftToolItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Loader;

//import gregtech.api.enums.TC_Aspects.TC_AspectStack;

public class GT_MachineRecipeLoader
implements Runnable {
	private final MaterialStack[][] mAlloySmelterList = {{new MaterialStack(Materials.Copper, 3L), new MaterialStack(Materials.Tin, 1L), new MaterialStack(Materials.Bronze, 4L)}, {new MaterialStack(Materials.Copper, 3L), new MaterialStack(Materials.Zinc, 1L), new MaterialStack(Materials.Brass, 4L)}, {new MaterialStack(Materials.Copper, 1L), new MaterialStack(Materials.Nickel, 1L), new MaterialStack(Materials.Cupronickel, 2L)}, {new MaterialStack(Materials.Copper, 1L), new MaterialStack(Materials.Redstone, 4L), new MaterialStack(Materials.RedAlloy, 1L)}, {new MaterialStack(Materials.AnnealedCopper, 3L), new MaterialStack(Materials.Tin, 1L), new MaterialStack(Materials.Bronze, 4L)}, {new MaterialStack(Materials.AnnealedCopper, 3L), new MaterialStack(Materials.Zinc, 1L), new MaterialStack(Materials.Brass, 4L)}, {new MaterialStack(Materials.AnnealedCopper, 1L), new MaterialStack(Materials.Nickel, 1L), new MaterialStack(Materials.Cupronickel, 2L)}, {new MaterialStack(Materials.AnnealedCopper, 1L), new MaterialStack(Materials.Redstone, 4L), new MaterialStack(Materials.RedAlloy, 1L)}, {new MaterialStack(Materials.Iron, 1L), new MaterialStack(Materials.Tin, 1L), new MaterialStack(Materials.TinAlloy, 2L)}, {new MaterialStack(Materials.WroughtIron, 1L), new MaterialStack(Materials.Tin, 1L), new MaterialStack(Materials.TinAlloy, 2L)}, {new MaterialStack(Materials.Iron, 2L), new MaterialStack(Materials.Nickel, 1L), new MaterialStack(Materials.Invar, 3L)}, {new MaterialStack(Materials.WroughtIron, 2L), new MaterialStack(Materials.Nickel, 1L), new MaterialStack(Materials.Invar, 3L)}, {new MaterialStack(Materials.Tin, 9L), new MaterialStack(Materials.Antimony, 1L), new MaterialStack(Materials.SolderingAlloy, 10L)}, {new MaterialStack(Materials.Lead, 4L), new MaterialStack(Materials.Antimony, 1L), new MaterialStack(Materials.BatteryAlloy, 5L)}, {new MaterialStack(Materials.Gold, 1L), new MaterialStack(Materials.Silver, 1L), new MaterialStack(Materials.Electrum, 2L)}, {new MaterialStack(Materials.Magnesium, 1L), new MaterialStack(Materials.Aluminium, 2L), new MaterialStack(Materials.Magnalium, 3L)}, {new MaterialStack(Materials.Silver, 1L), new MaterialStack(Materials.Teslatite, 4L), new MaterialStack(Materials.BlueAlloy, 1L)}, {new MaterialStack(Materials.RedAlloy, 1L), new MaterialStack(Materials.BlueAlloy, 1L), new MaterialStack(Materials.PurpleAlloy, 2L)}};

	public void run() {
		GT_Log.out.println("GT_Mod: Adding non-OreDict Machine Recipes.");
		try {
			GT_Utility.removeSimpleIC2MachineRecipe(GT_Values.NI, ic2.api.recipe.Recipes.metalformerExtruding.getRecipes(), ItemList.Cell_Empty.get(3L));
			GT_Utility.removeSimpleIC2MachineRecipe(ItemList.IC2_Energium_Dust.get(1L), ic2.api.recipe.Recipes.compressor.getRecipes(), GT_Values.NI);
			GT_Utility.removeSimpleIC2MachineRecipe(new ItemStack(Items.gunpowder), ic2.api.recipe.Recipes.extractor.getRecipes(), GT_Values.NI);
			GT_Utility.removeSimpleIC2MachineRecipe(new ItemStack(Blocks.wool, 1, GT_Values.W), ic2.api.recipe.Recipes.extractor.getRecipes(), GT_Values.NI);
		} catch (Throwable e) {
		}
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.wheat_seeds, 1, GT_Values.W), GT_Values.NI, Materials.SeedOil.getFluid(5L), 10000, 32, 2);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.melon_seeds, 1, GT_Values.W), GT_Values.NI, Materials.SeedOil.getFluid(3L), 10000, 32, 2);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.pumpkin_seeds, 1, GT_Values.W), GT_Values.NI, Materials.SeedOil.getFluid(6L), 10000, 32, 2);
		try {
			GT_DummyWorld tWorld = (GT_DummyWorld) GT_Values.DW;
			while (tWorld.mRandom.mIterationStep > 0) {
				GT_Values.RA.addFluidExtractionRecipe(GT_Utility.copyAmount(1L, ForgeHooks.getGrassSeed(tWorld)), GT_Values.NI, Materials.SeedOil.getFluid(5L), 10000, 64, 2);
			}
		} catch (Throwable e) {
			GT_Log.out.println("GT_Mod: failed to iterate somehow, maybe it's your Forge Version causing it. But it's not that important\n");
			e.printStackTrace(GT_Log.err);
		}
		GT_Values.RA.addPrinterRecipe(GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Paper, 1L), FluidRegistry.getFluidStack("squidink", 36), GT_Values.NI, ItemList.Paper_Punch_Card_Empty.get(1L), 100, 2);
		GT_Values.RA.addPrinterRecipe(ItemList.Paper_Punch_Card_Empty.get(1L), FluidRegistry.getFluidStack("squidink", 36), ItemList.Tool_DataStick.getWithName(0L, "With Punch Card Data"), ItemList.Paper_Punch_Card_Encoded.get(1L), 100, 2);
		GT_Values.RA.addPrinterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 3L), FluidRegistry.getFluidStack("squidink", 144), ItemList.Tool_DataStick.getWithName(0L, "With Scanned Book Data"), ItemList.Paper_Printed_Pages.get(1L), 400, 2);
		GT_Values.RA.addPrinterRecipe(new ItemStack(Items.map, 1, GT_Values.W), FluidRegistry.getFluidStack("squidink", 144), ItemList.Tool_DataStick.getWithName(0L, "With Scanned Map Data"), new ItemStack(Items.filled_map, 1, 0), 400, 2);
		GT_Values.RA.addPrinterRecipe(new ItemStack(Items.book, 1, GT_Values.W), FluidRegistry.getFluidStack("squidink", 144), GT_Values.NI, GT_Utility.getWrittenBook("Manual_Printer", ItemList.Book_Written_01.get(1L)), 400, 2);
		for (OrePrefixes tPrefix : Arrays.asList(OrePrefixes.dust, OrePrefixes.dustSmall, OrePrefixes.dustTiny)) {
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.EnderPearl, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Blaze, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.EnderEye, 1L * tPrefix.mMaterialAmount), (int) (100L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Gold, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Silver, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Electrum, 2L * tPrefix.mMaterialAmount), (int) (200L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Iron, 2L), GT_OreDictUnificator.get(tPrefix, Materials.Nickel, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Invar, 3L * tPrefix.mMaterialAmount), (int) (300L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Iron, 4L), GT_OreDictUnificator.get(tPrefix, Materials.Invar, 3L), GT_OreDictUnificator.get(tPrefix, Materials.Manganese, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Chrome, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.StainlessSteel, 9L * tPrefix.mMaterialAmount), (int) (900L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Iron, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Aluminium, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Chrome, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Kanthal, 3L * tPrefix.mMaterialAmount), (int) (300L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 3L), GT_OreDictUnificator.get(tPrefix, Materials.Barium, 2L), GT_OreDictUnificator.get(tPrefix, Materials.Yttrium, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.YttriumBariumCuprate, 6L * tPrefix.mMaterialAmount), (int) (600L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 3L), GT_OreDictUnificator.get(tPrefix, Materials.Zinc, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Brass, 4L * tPrefix.mMaterialAmount), (int) (400L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 3L), GT_OreDictUnificator.get(tPrefix, Materials.Tin, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Bronze, 4L * tPrefix.mMaterialAmount), (int) (400L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Nickel, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Cupronickel, 2L * tPrefix.mMaterialAmount), (int) (200L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Gold, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.RoseGold, 5L * tPrefix.mMaterialAmount), (int) (500L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Silver, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.SterlingSilver, 5L * tPrefix.mMaterialAmount), (int) (500L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Copper, 3L), GT_OreDictUnificator.get(tPrefix, Materials.Electrum, 2L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.BlackBronze, 5L * tPrefix.mMaterialAmount), (int) (500L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Bismuth, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Brass, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.BismuthBronze, 5L * tPrefix.mMaterialAmount), (int) (500L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.BlackBronze, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Nickel, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Steel, 3L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.BlackSteel, 5L * tPrefix.mMaterialAmount), (int) (500L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.SterlingSilver, 1L), GT_OreDictUnificator.get(tPrefix, Materials.BismuthBronze, 1L), GT_OreDictUnificator.get(tPrefix, Materials.BlackSteel, 4L), GT_OreDictUnificator.get(tPrefix, Materials.Steel, 2L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.RedSteel, 8L * tPrefix.mMaterialAmount), (int) (800L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.RoseGold, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Brass, 1L), GT_OreDictUnificator.get(tPrefix, Materials.BlackSteel, 4L), GT_OreDictUnificator.get(tPrefix, Materials.Steel, 2L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.BlueSteel, 8L * tPrefix.mMaterialAmount), (int) (800L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Cobalt, 5L), GT_OreDictUnificator.get(tPrefix, Materials.Chrome, 2L), GT_OreDictUnificator.get(tPrefix, Materials.Nickel, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Molybdenum, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Ultimet, 9L * tPrefix.mMaterialAmount), (int) (900L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Brass, 7L), GT_OreDictUnificator.get(tPrefix, Materials.Aluminium, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Cobalt, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.CobaltBrass, 9L * tPrefix.mMaterialAmount), (int) (900L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Saltpeter, 2L), GT_OreDictUnificator.get(tPrefix, Materials.Sulfur, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Coal, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Gunpowder, 4L * tPrefix.mMaterialAmount), (int) (400L * tPrefix.mMaterialAmount / GT_Values.M), 8);
			GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(tPrefix, Materials.Saltpeter, 2L), GT_OreDictUnificator.get(tPrefix, Materials.Sulfur, 1L), GT_OreDictUnificator.get(tPrefix, Materials.Charcoal, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.getDust(Materials.Gunpowder, 3L * tPrefix.mMaterialAmount), (int) (300L * tPrefix.mMaterialAmount / GT_Values.M), 8);
		}
		GT_Values.RA.addMixerRecipe(new ItemStack(Items.rotten_flesh, 1, 0), new ItemStack(Items.fermented_spider_eye, 1, 0), ItemList.IC2_Scrap.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L), FluidRegistry.getFluidStack("potion.purpledrink", 750), FluidRegistry.getFluidStack("sludge", 1000), ItemList.Food_Chum.get(4L), 128, 24);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(1000L), GT_Values.NF, ItemList.Food_Dough.get(2L), 32, 8);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chili, 1L), ItemList.Food_PotatoChips.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, ItemList.Food_ChiliChips.get(1L), 32, 8);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 3L), GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(500L), Materials.Concrete.getMolten(576L), GT_Values.NI, 20, 16);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Redstone, 5L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ruby, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, ItemList.IC2_Energium_Dust.get(1L), 100, 8);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 5L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NF, GT_Values.NF, ItemList.IC2_Energium_Dust.get(9L), 900, 8);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), new ItemStack(Blocks.brown_mushroom, 1), new ItemStack(Items.spider_eye, 1), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Items.fermented_spider_eye, 1), 100, 8);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.LiveRoot, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronWood, 2L), 100, 8);
		GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 9L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.LiveRoot, 9L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IronWood, 18L), 900, 8);
		GT_Values.RA.addMixerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1L), GT_Values.NI, Materials.Water.getFluid(500L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Fluix, 2L), 20, 16);
		GT_Values.RA.addMixerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1L), GT_Values.NI, GT_ModHandler.getDistilledWater(500L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Fluix, 2L), 20, 16);
		GT_Values.RA.addMixerRecipe(ItemList.IC2_Fertilizer.get(1L), new ItemStack(Blocks.dirt, 8, GT_Values.W), GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "soil", 8L, 0), 64, 16);
		GT_Values.RA.addMixerRecipe(ItemList.FR_Fertilizer.get(1L), new ItemStack(Blocks.dirt, 8, GT_Values.W), GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "soil", 8L, 0), 64, 16);
		GT_Values.RA.addMixerRecipe(ItemList.FR_Compost.get(1L), new ItemStack(Blocks.dirt, 8, GT_Values.W), GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "soil", 8L, 0), 64, 16);
		GT_Values.RA.addMixerRecipe(ItemList.FR_Mulch.get(1L), new ItemStack(Blocks.dirt, 8, GT_Values.W), GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(1000L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "soil", 9L, 0), 64, 16);
		GT_Values.RA.addMixerRecipe(new ItemStack(Blocks.sand, 1, GT_Values.W), new ItemStack(Blocks.dirt, 1, GT_Values.W), GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(250L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "soil", 2L, 1), 16, 16);

		 GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L), null, null, null, Materials.Water.getFluid(125), FluidRegistry.getFluidStack("ic2coolant", 125), null, 256, 48);	         
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L), null, null, null, GT_ModHandler.getDistilledWater(1000), FluidRegistry.getFluidStack("ic2coolant", 1000), null, 256, 48);
		 GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(new ItemStack(Blocks.soul_sand, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L), 100, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L), 400, 8);
         GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L), null, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 2L), 200, 8);
		
		GT_Values.RA.addExtruderRecipe(ItemList.FR_Wax.get(1L), ItemList.Shape_Extruder_Cell.get(0L), ItemList.FR_WaxCapsule.get(1L), 64, 16);
		GT_Values.RA.addExtruderRecipe(ItemList.FR_RefractoryWax.get(1L), ItemList.Shape_Extruder_Cell.get(0L), ItemList.FR_RefractoryCapsule.get(1L), 128, 16);

		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_LV.get(1L), ItemList.IC2_ReBattery.get(1L), Materials.Redstone.getMolten(288L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_LV.get(1L), ItemList.Battery_SU_LV_Mercury.getWithCharge(1L, Integer.MAX_VALUE), Materials.Mercury.getFluid(1000L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_MV.get(1L), ItemList.Battery_SU_MV_Mercury.getWithCharge(1L, Integer.MAX_VALUE), Materials.Mercury.getFluid(4000L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_HV.get(1L), ItemList.Battery_SU_HV_Mercury.getWithCharge(1L, Integer.MAX_VALUE), Materials.Mercury.getFluid(16000L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_LV.get(1L), ItemList.Battery_SU_LV_SulfuricAcid.getWithCharge(1L, Integer.MAX_VALUE), Materials.SulfuricAcid.getFluid(1000L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_MV.get(1L), ItemList.Battery_SU_MV_SulfuricAcid.getWithCharge(1L, Integer.MAX_VALUE), Materials.SulfuricAcid.getFluid(4000L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.Battery_Hull_HV.get(1L), ItemList.Battery_SU_HV_SulfuricAcid.getWithCharge(1L, Integer.MAX_VALUE), Materials.SulfuricAcid.getFluid(16000L), GT_Values.NF);
		GT_Values.RA.addFluidCannerRecipe(ItemList.TF_Vial_FieryTears.get(1L), ItemList.Bottle_Empty.get(1L), GT_Values.NF, Materials.FierySteel.getFluid(250L));

		Materials tMaterial = Materials.Iron;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Iron.get(1L), 16, 8);
		}
		tMaterial = Materials.WroughtIron;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Iron.get(1L), 16, 8);
		}
		tMaterial = Materials.Gold;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Gold.get(1L), 16, 8);
		}
		tMaterial = Materials.Bronze;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Bronze.get(1L), 16, 8);
		}
		tMaterial = Materials.Copper;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Copper.get(1L), 16, 8);
		}
		tMaterial = Materials.AnnealedCopper;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Copper.get(1L), 16, 8);
		}
		tMaterial = Materials.Tin;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Tin.get(1L), 16, 8);
		}
		tMaterial = Materials.Lead;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Lead.get(1L), 16, 8);
		}
		tMaterial = Materials.Steel;
		if (tMaterial.mStandardMoltenFluid != null) {
			GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), tMaterial.getMolten(72L), ItemList.IC2_Item_Casing_Steel.get(1L), 16, 8);
		}
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), Materials.Mercury.getFluid(1000L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Mercury, 1L), 128, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), Materials.Water.getFluid(250L), new ItemStack(Items.snowball, 1, 0), 128, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0L), GT_ModHandler.getDistilledWater(250L), new ItemStack(Items.snowball, 1, 0), 128, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), Materials.Water.getFluid(1000L), new ItemStack(Blocks.snow, 1, 0), 512, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), GT_ModHandler.getDistilledWater(1000L), new ItemStack(Blocks.snow, 1, 0), 512, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), Materials.Lava.getFluid(1000L), new ItemStack(Blocks.obsidian, 1, 0), 1024, 16);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), Materials.Concrete.getMolten(144L), new ItemStack(GregTech_API.sBlockConcretes, 1, 8), 12, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), Materials.Glowstone.getMolten(576L), new ItemStack(Blocks.glowstone, 1, 0), 12, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), Materials.Glass.getMolten(144L), new ItemStack(Blocks.glass, 1, 0), 12, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Plate.get(0L), Materials.Glass.getMolten(144L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L), 12, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Bottle.get(0L), Materials.Glass.getMolten(144L), ItemList.Bottle_Empty.get(1L), 12, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Cylinder.get(0L), Materials.Milk.getFluid(250L), ItemList.Food_Cheese.get(1L), 1024, 4);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Cylinder.get(0L), Materials.Cheese.getMolten(144L), ItemList.Food_Cheese.get(1L), 64, 8);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Anvil.get(0L), Materials.Iron.getMolten(4464L), new ItemStack(Blocks.anvil, 1, 0), 128, 16);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Anvil.get(0L), Materials.WroughtIron.getMolten(4464L), new ItemStack(Blocks.anvil, 1, 0), 128, 16);
		GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Anvil.get(0L), Materials.Steel.getMolten(4464L), GT_ModHandler.getModItem(GT_Values.MOD_ID_RC, "tile.railcraft.anvil", 1L, 0), 128, 16);

		GT_Values.RA.addChemicalBathRecipe(ItemList.Food_Raw_Fries.get(1L), Materials.FryingOilHot.getFluid(10L), GT_Values.NF, ItemList.Food_Fries.get(1L), GT_Values.NI, GT_Values.NI, null, 16, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_ModHandler.getIC2Item("dynamite", 1L), Materials.Glue.getFluid(10L), GT_Values.NF, GT_ModHandler.getIC2Item("stickyDynamite", 1L), GT_Values.NI, GT_Values.NI, null, 16, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L), Materials.Concrete.getMolten(144L), GT_Values.NF, GT_ModHandler.getIC2Item("reinforcedStone", 1L), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), Materials.Water.getFluid(125L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HydratedCoal, 1L), GT_Values.NI, GT_Values.NI, null, 12, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), Materials.Water.getFluid(100L), GT_Values.NF, new ItemStack(Items.paper, 1, 0), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L), Materials.Water.getFluid(100L), GT_Values.NF, new ItemStack(Items.paper, 1, 0), GT_Values.NI, GT_Values.NI, null, 100, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Items.reeds, 1, GT_Values.W), Materials.Water.getFluid(100L), GT_Values.NF, new ItemStack(Items.paper, 1, 0), GT_Values.NI, GT_Values.NI, null, 100, 8);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_ModHandler.getDistilledWater(125L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HydratedCoal, 1L), GT_Values.NI, GT_Values.NI, null, 12, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), GT_ModHandler.getDistilledWater(100L), GT_Values.NF, new ItemStack(Items.paper, 1, 0), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L), GT_ModHandler.getDistilledWater(100L), GT_Values.NF, new ItemStack(Items.paper, 1, 0), GT_Values.NI, GT_Values.NI, null, 100, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Items.reeds, 1, GT_Values.W), GT_ModHandler.getDistilledWater(100L), GT_Values.NF, new ItemStack(Items.paper, 1, 0), GT_Values.NI, GT_Values.NI, null, 100, 8);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 1), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 2), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 3), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 4), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 5), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 6), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 7), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 8), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 9), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 10), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 11), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 12), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 13), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 14), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 15), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 1), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 2), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 3), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 4), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 5), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 6), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 7), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 8), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 9), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 10), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 11), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 12), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 13), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 14), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.carpet, 1, 15), Materials.Chlorine.getFluid(25L), GT_Values.NF, new ItemStack(Blocks.carpet, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, GT_Values.W), Materials.Chlorine.getFluid(50L),GT_Values.NF, new ItemStack(Blocks.hardened_clay, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.stained_glass, 1, GT_Values.W), Materials.Chlorine.getFluid(50L), GT_Values.NF, new ItemStack(Blocks.glass, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.stained_glass_pane, 1, GT_Values.W), Materials.Chlorine.getFluid(20L), GT_Values.NF, new ItemStack(Blocks.glass_pane, 1, 0), GT_Values.NI, GT_Values.NI, null, 400, 2);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 8), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 0), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 9), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 1), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 10), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 2), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 11), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 3), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 12), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 4), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 13), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 5), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 14), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 6), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 15), Materials.Water.getFluid(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 7), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 8), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 0), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 9), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 1), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 10), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 2), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 11), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 3), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 12), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 4), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 13), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 5), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 14), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 6), GT_Values.NI, GT_Values.NI, null, 200, 4);
		GT_Values.RA.addChemicalBathRecipe(new ItemStack(GregTech_API.sBlockConcretes, 1, 15), GT_ModHandler.getDistilledWater(250L), GT_Values.NF, new ItemStack(GregTech_API.sBlockConcretes, 1, 7), GT_Values.NI, GT_Values.NI, null, 200, 4);
		for (int j = 0; j < Dyes.dyeRed.getSizeOfFluidList(); j++) {
			GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L), Dyes.dyeRed.getFluidDye(j, 72L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_TRANSPORT, "pipeWire", 4L, 0), GT_Values.NI, GT_Values.NI, null, 32, 16);
		}
		for (int j = 0; j < Dyes.dyeBlue.getSizeOfFluidList(); j++) {
			GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L), Dyes.dyeBlue.getFluidDye(j, 72L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_TRANSPORT, "pipeWire", 4L, 1), GT_Values.NI, GT_Values.NI, null, 32, 16);
		}
		for (int j = 0; j < Dyes.dyeGreen.getSizeOfFluidList(); j++) {
			GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L), Dyes.dyeGreen.getFluidDye(j, 72L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_TRANSPORT, "pipeWire", 4L, 2), GT_Values.NI, GT_Values.NI, null, 32, 16);
		}
		for (int j = 0; j < Dyes.dyeYellow.getSizeOfFluidList(); j++) {
			GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L), Dyes.dyeYellow.getFluidDye(j, 72L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_TRANSPORT, "pipeWire", 4L, 3), GT_Values.NI, GT_Values.NI, null, 32, 16);
		}
		for (byte i = 0; i < 16; i = (byte) (i + 1)) {
			for (int j = 0; j < Dyes.VALUES[i].getSizeOfFluidList(); j++) {
				if (i != 15) {
					GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.wool, 1, 0), Dyes.VALUES[i].getFluidDye(j, 144L), GT_Values.NF, new ItemStack(Blocks.wool, 1, 15 - i), GT_Values.NI, GT_Values.NI, null, 64, 2);
				}
				GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.glass, 1, 0), Dyes.VALUES[i].getFluidDye(j, 18L), GT_Values.NF, new ItemStack(Blocks.stained_glass, 1, 15 - i), GT_Values.NI, GT_Values.NI, null, 64, 2);
				GT_Values.RA.addChemicalBathRecipe(new ItemStack(Blocks.hardened_clay, 1, 0), Dyes.VALUES[i].getFluidDye(j, 18L), GT_Values.NF, new ItemStack(Blocks.stained_hardened_clay, 1, 15 - i), GT_Values.NI, GT_Values.NI, null, 64, 2);
			}
		}
		GT_Values.RA.addFluidExtractionRecipe(ItemList.Dye_SquidInk.get(1L), GT_Values.NI, FluidRegistry.getFluidStack("squidink", 144), 10000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(ItemList.Dye_Indigo.get(1L), GT_Values.NI, FluidRegistry.getFluidStack("indigo", 144), 10000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(ItemList.Crop_Drop_Indigo.get(1L), GT_Values.NI, FluidRegistry.getFluidStack("indigo", 144), 10000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(ItemList.Crop_Drop_MilkWart.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Milk, 1L), GT_ModHandler.getMilk(150L), 1000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(ItemList.Crop_Drop_OilBerry.get(1L), GT_Values.NI, Materials.Oil.getFluid(100L), 10000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.fish, 1, 0), GT_Values.NI, Materials.FishOil.getFluid(4L), 10000, 16, 4);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.fish, 1, 1), GT_Values.NI, Materials.FishOil.getFluid(6L), 10000, 16, 4);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.fish, 1, 2), GT_Values.NI, Materials.FishOil.getFluid(7L), 10000, 16, 4);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.fish, 1, 3), GT_Values.NI, Materials.FishOil.getFluid(3L), 10000, 16, 4);
		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(Items.coal, 1, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), Materials.Creosote.getFluid(100L), 1000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L), ItemList.IC2_Plantball.get(1L), Materials.Creosote.getFluid(5L), 100, 16, 4);
		GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HydratedCoal, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), Materials.Water.getFluid(100L), 10000, 32, 4);
		GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Mercury, 1L), GT_Values.NI, Materials.Mercury.getFluid(1000L), 10000, 128, 4);
		GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Monazite, 1L), GT_Values.NI, Materials.Helium.getFluid(200L), 10000, 64, 64);

		GT_Values.RA.addFluidSmelterRecipe(new ItemStack(Items.snowball, 1, 0), GT_Values.NI, Materials.Water.getFluid(250L), 10000, 32, 4);
		GT_Values.RA.addFluidSmelterRecipe(new ItemStack(Blocks.snow, 1, 0), GT_Values.NI, Materials.Water.getFluid(1000L), 10000, 128, 4);
		GT_Values.RA.addFluidSmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L), GT_Values.NI, Materials.Ice.getSolid(1000L), 10000, 128, 4);
		GT_Values.RA.addFluidSmelterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "phosphor", 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphor, 1L), Materials.Lava.getFluid(800L), 1000, 256, 128);

		GT_Values.RA.addAutoclaveRecipe(ItemList.IC2_Energium_Dust.get(9L), Materials.Water.getFluid(1000L), ItemList.IC2_EnergyCrystal.get(1L), 10000, 500, 256);
		GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 1L, 0), Materials.Water.getFluid(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 10), 10000, 2000, 24);
		GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 1L, 600), Materials.Water.getFluid(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 11), 10000, 2000, 24);
		GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 1L, 1200), Materials.Water.getFluid(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 12), 10000, 2000, 24);
		GT_Values.RA.addAutoclaveRecipe(ItemList.IC2_Energium_Dust.get(9L), GT_ModHandler.getDistilledWater(1000L), ItemList.IC2_EnergyCrystal.get(1L), 10000, 250, 256);
		GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 1L, 0), GT_ModHandler.getDistilledWater(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 10), 10000, 1000, 24);
		GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 1L, 600), GT_ModHandler.getDistilledWater(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 11), 10000, 1000, 24);
		GT_Values.RA.addAutoclaveRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 1L, 1200), GT_ModHandler.getDistilledWater(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 12), 10000, 1000, 24);

		GT_Values.RA.addSlicerRecipe(ItemList.Food_Dough_Chocolate.get(1L), ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Raw_Cookie.get(4L), 128, 4);
		GT_Values.RA.addSlicerRecipe(ItemList.Food_Baked_Bun.get(1L), ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Bun.get(2L), 128, 4);
		GT_Values.RA.addSlicerRecipe(ItemList.Food_Baked_Bread.get(1L), ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Bread.get(2L), 128, 4);
		GT_Values.RA.addSlicerRecipe(ItemList.Food_Baked_Baguette.get(1L), ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Baguette.get(2L), 128, 4);

		GT_Values.RA.addCentrifugeRecipe(ItemList.Cell_Empty.get(1), null, Materials.Air.getGas(10000), Materials.Nitrogen.getGas(3900), GT_OreDictUnificator.get(OrePrefixes.cell,Materials.Oxygen,1), null, null, null, null, null, null, 1600, 8);

		/*fix the recipes that are borked below*/

		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell,Materials.NitrogenDioxide,4), GT_OreDictUnificator.get(OrePrefixes.cell,Materials.Oxygen,1), Materials.Water.getFluid(2000), new FluidStack(ItemList.sNitricAcid,4000), ItemList.Cell_Empty.get(5), 30);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified,Materials.Pentlandite,1), null, new FluidStack(ItemList.sNitricAcid,8000), new FluidStack(ItemList.sNickelSulfate,9000), ItemList.PlatinumGroupSludgeTiny.get(1) ,30);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.crushedPurified,Materials.Chalcopyrite,1), null, new FluidStack(ItemList.sNitricAcid,8000), new FluidStack(ItemList.sBlueVitriol,9000), ItemList.PlatinumGroupSludgeTiny.get(1), 30);
		GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), null, new FluidStack(ItemList.sBlueVitriol,9000), Materials.SulfuricAcid.getFluid(8000), GT_OreDictUnificator.get(OrePrefixes.dust,Materials.Copper,1), GT_OreDictUnificator.get(OrePrefixes.cell,Materials.Oxygen,1), null, null, null, null, null, 900, 30);
		GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), null, new FluidStack(ItemList.sGreenVitriol,9000), Materials.SulfuricAcid.getFluid(8000), GT_OreDictUnificator.get(OrePrefixes.dust,Materials.Iron,1), GT_OreDictUnificator.get(OrePrefixes.cell,Materials.Oxygen,1), null, null, null, null, null, 900, 30);
		GT_Values.RA.addElectrolyzerRecipe(ItemList.Cell_Empty.get(1), null, new FluidStack(ItemList.sNickelSulfate,9000), Materials.SulfuricAcid.getFluid(8000), GT_OreDictUnificator.get(OrePrefixes.dust,Materials.Nickel,1), GT_OreDictUnificator.get(OrePrefixes.cell,Materials.Oxygen,1), null, null, null, null, null, 900, 30);
		GT_Values.RA.addCentrifugeRecipe(ItemList.PlatinumGroupSludge.get(1), null, null, null, GT_OreDictUnificator.get(OrePrefixes.dust,Materials.SiliconDioxide,1), GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.Gold,1), GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.Platinum,1), GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.Palladium,1), GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.Iridium,1), GT_OreDictUnificator.get(OrePrefixes.dustTiny,Materials.Osmium,1), new int[]{10000,10000,10000,8000,6000,6000}, 900, 30);

		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 1), 100, 120);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 1), 100, 120);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 2), 200, 120);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 3), 100, 480);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 2L, 4), 200, 120);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 5), 300, 120);
		GT_Values.RA.addFormingPressRecipe(new ItemStack(Items.comparator, 1, GT_Values.W), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_SILICON, "redstoneChipset", 1L, 6), 300, 120);
		GT_Values.RA.addFormingPressRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 10), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 0L, 13), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 16), 200, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 0L, 13), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 16), 200, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 0L, 14), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 17), 200, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 0L, 15), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 18), 200, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 1L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 0L, 19), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 20), 200, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 1L), ItemList.Circuit_Parts_Wiring_Basic.get(4L), ItemList.Circuit_Board_Basic.get(1L), 32, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 1L), ItemList.Circuit_Parts_Wiring_Advanced.get(4L), ItemList.Circuit_Board_Advanced.get(1L), 32, 64);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicon, 2L), ItemList.Circuit_Parts_Wiring_Elite.get(4L), ItemList.Circuit_Board_Elite.get(1L), 32, 256);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L), ItemList.Circuit_Parts_Advanced.get(2L), 32, 64);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lazurite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L), ItemList.Circuit_Parts_Advanced.get(2L), 32, 64);
		GT_Values.RA.addFormingPressRecipe(ItemList.Food_Dough_Sugar.get(4L), ItemList.Shape_Mold_Cylinder.get(0L), ItemList.Food_Raw_Cake.get(1L), 384, 4);
		GT_Values.RA.addFormingPressRecipe(new ItemStack(Blocks.glass, 1, GT_Values.W), ItemList.Shape_Mold_Arrow.get(0L), ItemList.Arrow_Head_Glass_Emtpy.get(1L), 64, 4);
		for (Materials tMat : Materials.VALUES) {
			if ((tMat.mStandardMoltenFluid != null) && (tMat.contains(SubTag.SOLDERING_MATERIAL))) {
				int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1 : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

				GT_Values.RA.addAssemblerRecipe(ItemList.IC2_Item_Casing_Steel.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L), tMat.getMolten(144L * tMultiplier / 8L), ItemList.Circuit_Primitive.get(1L), 16, 8);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Basic.get(1L), ItemList.Circuit_Primitive.get(2L), tMat.getMolten(144L * tMultiplier / 4L), ItemList.Circuit_Basic.get(1L), 32, 16);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Basic.get(1L), ItemList.Circuit_Primitive.get(2L), tMat.getMolten(144L * tMultiplier / 4L), ItemList.Circuit_Good.get(1L), 32, 16);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Advanced.get(1L), ItemList.Circuit_Parts_Advanced.get(2L), tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Advanced.get(1L), 32, 64);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Advanced.get(1L), ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), tMat.getMolten(144L * tMultiplier / 2L), ItemList.Circuit_Data.get(1L), 32, 64);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Elite.get(1L), ItemList.Circuit_Data.get(3L), tMat.getMolten(144L * tMultiplier / 1L), ItemList.Circuit_Elite.get(1L), 32, 256);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Board_Elite.get(1L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(3L), tMat.getMolten(144L * tMultiplier / 1L), ItemList.Circuit_Master.get(1L), 32, 256);
				GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Data.get(1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 2L), tMat.getMolten(144L * tMultiplier / 2L), ItemList.Tool_DataStick.get(1L), 128, 64);
				for (ItemStack tPlate : new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L)}) {
					GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.lever, 1, GT_Values.W), tPlate, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Cover_Controller.get(1L), 800, 16);
					GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.redstone_torch, 1, GT_Values.W), tPlate, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Cover_ActivityDetector.get(1L), 800, 16);
					GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate, 1, GT_Values.W), tPlate, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Cover_FluidDetector.get(1L), 800, 16);
					GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.light_weighted_pressure_plate, 1, GT_Values.W), tPlate, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Cover_ItemDetector.get(1L), 800, 16);
					GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("ecMeter", 1L), tPlate, tMat.getMolten(144L * tMultiplier / 2L), ItemList.Cover_EnergyDetector.get(1L), 800, 16);
				}
			}
		}
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 8), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicon, 1), Materials.Glue.getFluid(250L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Graphene, 1), 480, 240);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.redstone_torch, 2, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), Materials.Concrete.getMolten(144L), new ItemStack(Items.repeater, 1, 0), 800, 1);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.leather, 1, GT_Values.W), new ItemStack(Items.lead, 1, GT_Values.W), Materials.Glue.getFluid(50L), new ItemStack(Items.name_tag, 1, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 8L), new ItemStack(Items.compass, 1, GT_Values.W), GT_Values.NF, new ItemStack(Items.map, 1, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manganese, 1L), Materials.Plastic.getMolten(144L), ItemList.Battery_RE_ULV_Tantalum.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Elite.get(2L), ItemList.Circuit_Parts_Crystal_Chip_Elite.get(18L), GT_Values.NF, ItemList.Tool_DataOrb.get(1L), 512, 256);
		GT_Values.RA.addAssemblerRecipe(ItemList.Circuit_Master.get(2L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(18L), GT_Values.NF, ItemList.Energy_LapotronicOrb.get(1L), 512, 1024);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Europium, 4L), ItemList.Energy_LapotronicOrb.get(8L), GT_Values.NF, ItemList.Energy_LapotronicOrb2.get(1L), 2048, 4096);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 16L), ItemList.Energy_LapotronicOrb2.get(8L), GT_Values.NF, ItemList.ZPM2.get(1L), 32768, 4096);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfLife1", 4L, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfLife2", 1L, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping1", 4L, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping2", 1L, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping2", 4L, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping3", 1L, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfLife2", 1L, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfLife1", 4L, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping2", 1L, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping1", 4L, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping3", 1L, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.charmOfKeeping2", 4L, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 16), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 20), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 23), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 17), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 20), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 24), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 18), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 20), Materials.Redstone.getMolten(144L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 22), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), new ItemStack(Blocks.sand, 1, GT_Values.W), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 2L, 0), 64, 8);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L), new ItemStack(Blocks.sand, 1, GT_Values.W), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 2L, 600), 64, 8);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fluix, 1L), new ItemStack(Blocks.sand, 1, GT_Values.W), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemCrystalSeed", 2L, 1200), 64, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.FR_Wax.get(6L), new ItemStack(Items.string, 1, GT_Values.W), Materials.Water.getFluid(600L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "candle", 24L, 0), 64, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.FR_Wax.get(2L), ItemList.FR_Silk.get(1L), Materials.Water.getFluid(200L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "candle", 8L, 0), 16, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.FR_Silk.get(9L), ItemList.Circuit_Integrated.getWithDamage(0L, 9L), Materials.Water.getFluid(500L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "craftingMaterial", 1L, 3), 64, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "propolis", 5L, 2), ItemList.Circuit_Integrated.getWithDamage(0L, 5L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "craftingMaterial", 1L, 1), 16, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "sturdyMachine", 1L, 0), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 4L), Materials.Water.getFluid(5000L), ItemList.FR_Casing_Hardened.get(1L), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), GT_Values.NF, ItemList.FR_Casing_Sturdy.get(1L), 32, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 6L), Materials.Water.getFluid(1000L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "chipsets", 1L, 0), 16, 8);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 6L), Materials.Water.getFluid(1000L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "chipsets", 1L, 1), 32, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 6L), Materials.Water.getFluid(1000L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "chipsets", 1L, 2), 48, 24);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 6L), Materials.Water.getFluid(1000L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "chipsets", 1L, 2), 48, 24);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 6L), Materials.Water.getFluid(1000L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "chipsets", 1L, 3), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Blocks.wool, 1, GT_Values.W), Materials.Creosote.getFluid(1000L), new ItemStack(Blocks.torch, 6, 0), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "craftingMaterial", 5L, 1), ItemList.Circuit_Integrated.getWithDamage(0L, 5L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1L), 64, 8);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.piston, 1, GT_Values.W), new ItemStack(Items.slime_ball, 1, GT_Values.W), GT_Values.NF, new ItemStack(Blocks.sticky_piston, 1, 0), 100, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.piston, 1, GT_Values.W), ItemList.IC2_Resin.get(1L), GT_Values.NF, new ItemStack(Blocks.sticky_piston, 1, 0), 100, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.piston, 1, GT_Values.W), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.Glue.getFluid(100L), new ItemStack(Blocks.sticky_piston, 1, 0), 100, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 3L), GT_ModHandler.getIC2Item("carbonMesh", 3L), Materials.Glue.getFluid(300L), ItemList.Duct_Tape.get(1L), 100, 64);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Paper, 3L), new ItemStack(Items.leather, 1, GT_Values.W), Materials.Glue.getFluid(20L), new ItemStack(Items.book, 1, 0), 32, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.Paper_Printed_Pages.get(1L), new ItemStack(Items.leather, 1, GT_Values.W), Materials.Glue.getFluid(20L), new ItemStack(Items.written_book, 1, 0), 32, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.IC2_Item_Casing_Tin.get(4L), new ItemStack(Blocks.glass_pane, 1, GT_Values.W), GT_Values.NF, ItemList.Cell_Universal_Fluid.get(1L), 128, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Baked_Cake.get(1L), new ItemStack(Items.egg, 1, 0), Materials.Milk.getFluid(3000L), new ItemStack(Items.cake, 1, 0), 100, 8);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Bun.get(2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), GT_Values.NF, ItemList.Food_Sliced_Buns.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Bread.get(2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), GT_Values.NF, ItemList.Food_Sliced_Breads.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Baguette.get(2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), GT_Values.NF, ItemList.Food_Sliced_Baguettes.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Buns.get(1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_Values.NF, ItemList.Food_Sliced_Bun.get(2L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Breads.get(1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_Values.NF, ItemList.Food_Sliced_Bread.get(2L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Baguettes.get(1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_Values.NF, ItemList.Food_Sliced_Baguette.get(2L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Bun.get(2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L), GT_Values.NF, ItemList.Food_Burger_Meat.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Buns.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L), GT_Values.NF, ItemList.Food_Burger_Meat.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Bun.get(2L), ItemList.Food_Chum.get(1L), GT_Values.NF, ItemList.Food_Burger_Chum.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Buns.get(1L), ItemList.Food_Chum.get(1L), GT_Values.NF, ItemList.Food_Burger_Chum.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Bun.get(2L), ItemList.Food_Sliced_Cheese.get(3L), GT_Values.NF, ItemList.Food_Burger_Cheese.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Sliced_Buns.get(1L), ItemList.Food_Sliced_Cheese.get(3L), GT_Values.NF, ItemList.Food_Burger_Cheese.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Flat_Dough.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L), GT_Values.NF, ItemList.Food_Raw_Pizza_Meat.get(1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.Food_Flat_Dough.get(1L), ItemList.Food_Sliced_Cheese.get(3L), GT_Values.NF, ItemList.Food_Raw_Pizza_Cheese.get(1L), 100, 4);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 0), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 0), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 1), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 2), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 3), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 3), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 4), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 5), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 7), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 8), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Emerald, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 9), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 10), 64, 32);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Lapis, 5L), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "thermionicTubes", 4L, 11), 64, 32);

		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.Oil.getFluid(16L), Materials.Fuel.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), Materials.Oil.getFluid(16L), Materials.Glyceryl.getFluid(1L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), Materials.Oil.getFluid(16L), Materials.Methane.getGas(15L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), Materials.Oil.getFluid(16L), Materials.Lubricant.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 6L), Materials.Oil.getFluid(16L), Materials.SulfuricAcid.getFluid(16L), 32, 16, false);
		if (FluidRegistry.getFluid("oilgc") != null) {
			GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new FluidStack(FluidRegistry.getFluid("oilgc"), 16), Materials.Fuel.getFluid(16L), 32, 16, false);
			GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new FluidStack(FluidRegistry.getFluid("oilgc"), 16), Materials.Glyceryl.getFluid(1L), 32, 16, false);
			GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new FluidStack(FluidRegistry.getFluid("oilgc"), 16), Materials.Methane.getGas(15L), 32, 16, false);
			GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new FluidStack(FluidRegistry.getFluid("oilgc"), 16), Materials.Lubricant.getFluid(16L), 32, 16, false);
			GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new FluidStack(FluidRegistry.getFluid("oilgc"), 16), Materials.SulfuricAcid.getFluid(16L), 32, 16, false);
			GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("oilgc"), 64), new FluidStack[]{Materials.Lubricant.getFluid(16L), Materials.Fuel.getFluid(64L), Materials.SulfuricAcid.getFluid(64L), Materials.Glyceryl.getFluid(4L), Materials.Methane.getGas(60L)}, null, 16, 64);
		}

		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new FluidStack(ItemList.sOilLight, 32), Materials.Fuel.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new FluidStack(ItemList.sOilLight, 32), Materials.Glyceryl.getFluid(1L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new FluidStack(ItemList.sOilLight, 32), Materials.Methane.getGas(15L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new FluidStack(ItemList.sOilLight, 32), Materials.Lubricant.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new FluidStack(ItemList.sOilLight, 32), Materials.SulfuricAcid.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new FluidStack(ItemList.sOilMedium, 16), Materials.Fuel.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new FluidStack(ItemList.sOilMedium, 16), Materials.Glyceryl.getFluid(1L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new FluidStack(ItemList.sOilMedium, 16), Materials.Methane.getGas(15L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new FluidStack(ItemList.sOilMedium, 16), Materials.Lubricant.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new FluidStack(ItemList.sOilMedium, 16), Materials.SulfuricAcid.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new FluidStack(ItemList.sOilHeavy, 8), Materials.Fuel.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new FluidStack(ItemList.sOilHeavy, 8), Materials.Glyceryl.getFluid(1L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new FluidStack(ItemList.sOilHeavy, 8), Materials.Methane.getGas(15L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new FluidStack(ItemList.sOilHeavy, 8), Materials.Lubricant.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new FluidStack(ItemList.sOilHeavy, 8), Materials.SulfuricAcid.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new FluidStack(ItemList.sOilExtraHeavy, 4), Materials.Fuel.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new FluidStack(ItemList.sOilExtraHeavy, 4), Materials.Glyceryl.getFluid(1L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new FluidStack(ItemList.sOilExtraHeavy, 4), Materials.Methane.getGas(15L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new FluidStack(ItemList.sOilExtraHeavy, 4), Materials.Lubricant.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new FluidStack(ItemList.sOilExtraHeavy, 4), Materials.SulfuricAcid.getFluid(16L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new FluidStack(ItemList.sNaturalGas, 16), Materials.Methane.getGas(30L), 32, 16, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), Materials.Creosote.getFluid(3L), Materials.Lubricant.getFluid(1L), 16, 24, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), Materials.SeedOil.getFluid(4L), Materials.Lubricant.getFluid(1L), 16, 24, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 4L), Materials.FishOil.getFluid(3L), Materials.Lubricant.getFluid(1L), 16, 24, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.Biomass.getFluid(40L), Materials.Ethanol.getFluid(12L), 16, 24, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 5L), Materials.Biomass.getFluid(40L), Materials.Water.getFluid(12L), 16, 24, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 5L), Materials.Water.getFluid(5L), GT_ModHandler.getDistilledWater(4L), 16, 8, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), FluidRegistry.getFluidStack("potion.potatojuice", 2), FluidRegistry.getFluidStack("potion.vodka", 1), 16, 16, true);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), FluidRegistry.getFluidStack("potion.lemonade", 2), FluidRegistry.getFluidStack("potion.alcopops", 1), 16, 16, true);

		GT_Values.RA.addFluidHeaterRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.Water.getFluid(6L), Materials.Water.getGas(960L), 30, 32);
		GT_Values.RA.addFluidHeaterRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_ModHandler.getDistilledWater(6L), Materials.Water.getGas(960L), 30, 32);
		GT_Values.RA.addFluidHeaterRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.SeedOil.getFluid(16L), Materials.FryingOilHot.getFluid(16L), 16, 32);
		GT_Values.RA.addFluidHeaterRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.FishOil.getFluid(16L), Materials.FryingOilHot.getFluid(16L), 16, 32);

		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Talc, 1L), FluidRegistry.getFluid("oil"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L), FluidRegistry.getFluid("oil"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), FluidRegistry.getFluid("oil"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Talc, 1L), FluidRegistry.getFluid("creosote"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L), FluidRegistry.getFluid("creosote"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), FluidRegistry.getFluid("creosote"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Talc, 1L), FluidRegistry.getFluid("seedoil"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soapstone, 1L), FluidRegistry.getFluid("seedoil"), FluidRegistry.getFluid("lubricant"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), FluidRegistry.getFluid("seedoil"), FluidRegistry.getFluid("lubricant"), false);
		for (Fluid tFluid : new Fluid[]{FluidRegistry.WATER, GT_ModHandler.getDistilledWater(1L).getFluid()}) {
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Milk, 1L), tFluid, FluidRegistry.getFluid("milk"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L), tFluid, FluidRegistry.getFluid("potion.wheatyjuice"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L), tFluid, FluidRegistry.getFluid("potion.mineralwater"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), tFluid, FluidRegistry.getFluid("potion.mineralwater"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), tFluid, FluidRegistry.getFluid("potion.mineralwater"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L), tFluid, FluidRegistry.getFluid("potion.mineralwater"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L), tFluid, FluidRegistry.getFluid("potion.saltywater"), true);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RockSalt, 1L), tFluid, FluidRegistry.getFluid("potion.saltywater"), true);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L), tFluid, FluidRegistry.getFluid("potion.thick"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 1L), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.magma_cream, 1, 0), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.fermented_spider_eye, 1, 0), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.spider_eye, 1, 0), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.speckled_melon, 1, 0), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.ghast_tear, 1, 0), tFluid, FluidRegistry.getFluid("potion.mundane"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.nether_wart, 1, 0), tFluid, FluidRegistry.getFluid("potion.awkward"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Blocks.red_mushroom, 1, 0), tFluid, FluidRegistry.getFluid("potion.poison"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.fish, 1, 3), tFluid, FluidRegistry.getFluid("potion.poison.strong"), true);
			GT_Values.RA.addBrewingRecipe(ItemList.IC2_Grin_Powder.get(1L), tFluid, FluidRegistry.getFluid("potion.poison.strong"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.reeds, 1, 0), tFluid, FluidRegistry.getFluid("potion.reedwater"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.apple, 1, 0), tFluid, FluidRegistry.getFluid("potion.applejuice"), false);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.golden_apple, 1, 0), tFluid, FluidRegistry.getFluid("potion.goldenapplejuice"), true);
			GT_Values.RA.addBrewingRecipe(new ItemStack(Items.golden_apple, 1, 1), tFluid, FluidRegistry.getFluid("potion.idunsapplejuice"), true);
			GT_Values.RA.addBrewingRecipe(ItemList.IC2_Hops.get(1L), tFluid, FluidRegistry.getFluid("potion.hopsjuice"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coffee, 1L), tFluid, FluidRegistry.getFluid("potion.darkcoffee"), false);
			GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chili, 1L), tFluid, FluidRegistry.getFluid("potion.chillysauce"), false);

			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphate, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 3L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(1L), 100);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(1L), 100);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(4L), 400);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphate, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 3L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(4L), 400);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphate, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 3L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(4L), 400);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphate, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 3L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(4L), 400);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphate, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(3L), 300);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 3L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
			GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), new FluidStack(tFluid, 1000), GT_Values.NF, ItemList.IC2_Fertilizer.get(2L), 200);
		}
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chili, 1L), FluidRegistry.getFluid("potion.chillysauce"), FluidRegistry.getFluid("potion.hotsauce"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chili, 1L), FluidRegistry.getFluid("potion.hotsauce"), FluidRegistry.getFluid("potion.diabolosauce"), true);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chili, 1L), FluidRegistry.getFluid("potion.diabolosauce"), FluidRegistry.getFluid("potion.diablosauce"), true);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coffee, 1L), FluidRegistry.getFluid("milk"), FluidRegistry.getFluid("potion.coffee"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cocoa, 1L), FluidRegistry.getFluid("milk"), FluidRegistry.getFluid("potion.darkchocolatemilk"), false);
		GT_Values.RA.addBrewingRecipe(ItemList.IC2_Hops.get(1L), FluidRegistry.getFluid("potion.wheatyjuice"), FluidRegistry.getFluid("potion.wheatyhopsjuice"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L), FluidRegistry.getFluid("potion.hopsjuice"), FluidRegistry.getFluid("potion.wheatyhopsjuice"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.tea"), FluidRegistry.getFluid("potion.sweettea"), true);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.coffee"), FluidRegistry.getFluid("potion.cafeaulait"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.cafeaulait"), FluidRegistry.getFluid("potion.laitaucafe"), true);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.lemonjuice"), FluidRegistry.getFluid("potion.lemonade"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.darkcoffee"), FluidRegistry.getFluid("potion.darkcafeaulait"), true);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.darkchocolatemilk"), FluidRegistry.getFluid("potion.chocolatemilk"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L), FluidRegistry.getFluid("potion.tea"), FluidRegistry.getFluid("potion.icetea"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 1L), FluidRegistry.getFluid("potion.lemonade"), FluidRegistry.getFluid("potion.cavejohnsonsgrenadejuice"), true);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.fish, 1, 3), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.waterbreathing"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.magma_cream, 1, 0), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.fireresistance"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.golden_carrot, 1, 0), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.nightvision"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.fermented_spider_eye, 1, 0), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.weakness"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.spider_eye, 1, 0), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.poison"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.speckled_melon, 1, 0), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.health"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.ghast_tear, 1, 0), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.regen"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.speed"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 1L), FluidRegistry.getFluid("potion.awkward"), FluidRegistry.getFluid("potion.strength"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.mundane"), FluidRegistry.getFluid("potion.purpledrink"), true);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.fermented_spider_eye, 1, 0), FluidRegistry.getFluid("potion.mundane"), FluidRegistry.getFluid("potion.weakness"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.fermented_spider_eye, 1, 0), FluidRegistry.getFluid("potion.thick"), FluidRegistry.getFluid("potion.weakness"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.spider_eye, 1, 0), FluidRegistry.getFluid("potion.thick"), FluidRegistry.getFluid("potion.poison.strong"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.speckled_melon, 1, 0), FluidRegistry.getFluid("potion.thick"), FluidRegistry.getFluid("potion.health.strong"), false);
		GT_Values.RA.addBrewingRecipe(new ItemStack(Items.ghast_tear, 1, 0), FluidRegistry.getFluid("potion.thick"), FluidRegistry.getFluid("potion.regen.strong"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L), FluidRegistry.getFluid("potion.thick"), FluidRegistry.getFluid("potion.speed.strong"), false);
		GT_Values.RA.addBrewingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 1L), FluidRegistry.getFluid("potion.thick"), FluidRegistry.getFluid("potion.strength.strong"), false);

		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("milk", 50), FluidRegistry.getFluidStack("potion.mundane", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.lemonjuice", 50), FluidRegistry.getFluidStack("potion.limoncello", 25), 1024, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.applejuice", 50), FluidRegistry.getFluidStack("potion.cider", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.goldenapplejuice", 50), FluidRegistry.getFluidStack("potion.goldencider", 25), 1024, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.idunsapplejuice", 50), FluidRegistry.getFluidStack("potion.notchesbrew", 25), 1024, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.reedwater", 50), FluidRegistry.getFluidStack("potion.rum", 25), 1024, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.rum", 50), FluidRegistry.getFluidStack("potion.piratebrew", 10), 2048, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.grapejuice", 50), FluidRegistry.getFluidStack("potion.wine", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.wine", 50), FluidRegistry.getFluidStack("potion.vinegar", 10), 2048, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.wheatyjuice", 50), FluidRegistry.getFluidStack("potion.scotch", 25), 1024, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.scotch", 50), FluidRegistry.getFluidStack("potion.glenmckenner", 10), 2048, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.wheatyhopsjuice", 50), FluidRegistry.getFluidStack("potion.beer", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.hopsjuice", 50), FluidRegistry.getFluidStack("potion.darkbeer", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.darkbeer", 50), FluidRegistry.getFluidStack("potion.dragonblood", 10), 2048, true);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.awkward", 50), FluidRegistry.getFluidStack("potion.weakness", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.mundane", 50), FluidRegistry.getFluidStack("potion.weakness", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.thick", 50), FluidRegistry.getFluidStack("potion.weakness", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.poison", 50), FluidRegistry.getFluidStack("potion.damage", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.health", 50), FluidRegistry.getFluidStack("potion.damage", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.waterbreathing", 50), FluidRegistry.getFluidStack("potion.damage", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.nightvision", 50), FluidRegistry.getFluidStack("potion.invisibility", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.fireresistance", 50), FluidRegistry.getFluidStack("potion.slowness", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.speed", 50), FluidRegistry.getFluidStack("potion.slowness", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.strength", 50), FluidRegistry.getFluidStack("potion.weakness", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.regen", 50), FluidRegistry.getFluidStack("potion.poison", 25), 1024, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.poison.strong", 50), FluidRegistry.getFluidStack("potion.damage.strong", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.health.strong", 50), FluidRegistry.getFluidStack("potion.damage.strong", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.speed.strong", 50), FluidRegistry.getFluidStack("potion.slowness.strong", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.strength.strong", 50), FluidRegistry.getFluidStack("potion.weakness.strong", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.regen.strong", 50), FluidRegistry.getFluidStack("potion.poison.strong", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.poison.long", 50), FluidRegistry.getFluidStack("potion.damage.long", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.waterbreathing.long", 50), FluidRegistry.getFluidStack("potion.damage.long", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.nightvision.long", 50), FluidRegistry.getFluidStack("potion.invisibility.long", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.fireresistance.long", 50), FluidRegistry.getFluidStack("potion.slowness.long", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.speed.long", 50), FluidRegistry.getFluidStack("potion.slowness.long", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.strength.long", 50), FluidRegistry.getFluidStack("potion.weakness.long", 10), 2048, false);
		GT_Values.RA.addFermentingRecipe(FluidRegistry.getFluidStack("potion.regen.long", 50), FluidRegistry.getFluidStack("potion.poison.long", 10), 2048, false);

		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_PotatoChips.get(1L), ItemList.Food_PotatoChips.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Potato_On_Stick.get(1L), ItemList.Food_Potato_On_Stick_Roasted.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Bun.get(1L), ItemList.Food_Baked_Bun.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Bread.get(1L), ItemList.Food_Baked_Bread.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Baguette.get(1L), ItemList.Food_Baked_Baguette.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Pizza_Veggie.get(1L), ItemList.Food_Baked_Pizza_Veggie.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Pizza_Cheese.get(1L), ItemList.Food_Baked_Pizza_Cheese.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Pizza_Meat.get(1L), ItemList.Food_Baked_Pizza_Meat.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Baguette.get(1L), ItemList.Food_Baked_Baguette.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Cake.get(1L), ItemList.Food_Baked_Cake.get(1L));
		GT_ModHandler.addSmeltingRecipe(ItemList.Food_Raw_Cookie.get(1L), new ItemStack(Items.cookie, 1));
		GT_ModHandler.addSmeltingRecipe(new ItemStack(Items.slime_ball, 1), ItemList.IC2_Resin.get(1L));

		GT_ModHandler.addExtractionRecipe(new ItemStack(Blocks.bookshelf, 1, GT_Values.W), new ItemStack(Items.book, 3, 0));
		GT_ModHandler.addExtractionRecipe(new ItemStack(Items.slime_ball, 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 2L));
		GT_ModHandler.addExtractionRecipe(ItemList.IC2_Resin.get(1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 3L));
		GT_ModHandler.addExtractionRecipe(GT_ModHandler.getIC2Item("rubberSapling", 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 1L));
		GT_ModHandler.addExtractionRecipe(GT_ModHandler.getIC2Item("rubberLeaves", 16L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 1L));
		GT_ModHandler.addExtractionRecipe(ItemList.Cell_Air.get(1L), ItemList.Cell_Empty.get(1L));
		if (Loader.isModLoaded("ExtrabiomesXL")) {
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "waterplant1", 1, 0), new ItemStack(Items.dye, 4, 2));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "vines", 1, 0), new ItemStack(Items.dye, 4, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 11), new ItemStack(Items.dye, 4, 11));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 10), new ItemStack(Items.dye, 4, 5));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 9), new ItemStack(Items.dye, 4, 14));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 8), new ItemStack(Items.dye, 4, 14));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 7), new ItemStack(Items.dye, 4, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 6), new ItemStack(Items.dye, 4, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 5), new ItemStack(Items.dye, 4, 11));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 0), new ItemStack(Items.dye, 4, 9));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 4), new ItemStack(Items.dye, 4, 11));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 3), new ItemStack(Items.dye, 4, 13));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower1", 1, 3), new ItemStack(Items.dye, 4, 5));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 2), new ItemStack(Items.dye, 4, 5));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower1", 1, 1), new ItemStack(Items.dye, 4, 12));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 15), new ItemStack(Items.dye, 4, 11));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 14), new ItemStack(Items.dye, 4, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 13), new ItemStack(Items.dye, 4, 9));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 12), new ItemStack(Items.dye, 4, 14));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 11), new ItemStack(Items.dye, 4, 7));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower1", 1, 7), new ItemStack(Items.dye, 4, 7));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower1", 1, 2), new ItemStack(Items.dye, 4, 11));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 13), new ItemStack(Items.dye, 4, 6));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 6), new ItemStack(Items.dye, 4, 12));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 5), new ItemStack(Items.dye, 4, 10));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 2), new ItemStack(Items.dye, 4, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 1), new ItemStack(Items.dye, 4, 9));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 0), new ItemStack(Items.dye, 4, 13));


			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 7), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 0));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1, 1), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower3", 1,12), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 4), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 1));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower1", 1, 6), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 2));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 8), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 3));
			GT_ModHandler.addExtractionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "flower2", 1, 3), GT_ModHandler.getModItem("ExtrabiomesXL", "extrabiomes.dye", 1, 3));

			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 0), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 1), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 2), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 3), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 4), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 5), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 6), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_1", 4, 7), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_2", 4, 0), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_2", 4, 1), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_2", 4, 2), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_2", 4, 3), ItemList.IC2_Plantball.get(1));
			GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("ExtrabiomesXL", "saplings_2", 4, 4), ItemList.IC2_Plantball.get(1));

		}

		GT_ModHandler.addCompressionRecipe(ItemList.IC2_Compressed_Coal_Chunk.get(1L), ItemList.IC2_Industrial_Diamond.get(1L));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), GT_ModHandler.getIC2Item("Uran238", 1L));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1L), GT_ModHandler.getIC2Item("Uran235", 1L));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L), GT_ModHandler.getIC2Item("Plutonium", 1L));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L), GT_ModHandler.getIC2Item("smallUran235", 1L));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium, 1L), GT_ModHandler.getIC2Item("smallPlutonium", 1L));
		GT_ModHandler.addCompressionRecipe(new ItemStack(Blocks.ice, 2, GT_Values.W), new ItemStack(Blocks.packed_ice, 1, 0));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L), new ItemStack(Blocks.ice, 1, 0));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 4L), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "tile.BlockQuartz", 1L));
		GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 8L, 10), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "tile.BlockQuartz", 1L));
		GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 8L, 11), new ItemStack(Blocks.quartz_block, 1, 0));
		GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 8L, 12), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "tile.BlockFluix", 1L));
		GT_ModHandler.addCompressionRecipe(new ItemStack(Items.quartz, 4, 0), new ItemStack(Blocks.quartz_block, 1, 0));
		GT_ModHandler.addCompressionRecipe(new ItemStack(Items.wheat, 9, 0), new ItemStack(Blocks.hay_block, 1, 0));
		GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4L), new ItemStack(Blocks.glowstone, 1));
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Graphite, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Graphite, 9L), GT_Values.NI, 500, 48);
		GT_ModHandler.removeFurnaceSmelting(GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Graphite, 1L));
		GT_ModHandler.addSmeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Graphite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L));
		GT_ModHandler.removeFurnaceSmelting(GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Graphite, 1L));
		GT_ModHandler.addSmeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Graphite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L));
		GT_ModHandler.removeFurnaceSmelting(GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Graphite, 1L));
		GT_ModHandler.addSmeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Graphite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L));
		GT_ModHandler.removeFurnaceSmelting(GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Graphite, 1L));
		GT_ModHandler.addSmeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Graphite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L));
		GT_ModHandler.removeFurnaceSmelting(GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Graphite, 1L));
		GT_ModHandler.addSmeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Graphite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L));

		GT_ModHandler.addPulverisationRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "tile.BlockSkyStone", 1L, GT_Values.W), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 45), GT_Values.NI, 0, false);
		GT_ModHandler.addPulverisationRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "tile.BlockSkyChest", 1L, GT_Values.W), GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 8L, 45), GT_Values.NI, 0, false);
		GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.blaze_powder, 3), new ItemStack(Items.blaze_powder, 1), 50, false);
		GT_ModHandler.addPulverisationRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_RC, "cube.crushed.obsidian", 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), GT_Values.NI, 0, true);
		GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.flint, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Flint, 4L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Flint, 1L), 40, true);
		GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.red_mushroom, 1, GT_Values.W), ItemList.IC2_Grin_Powder.get(1L));
		GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.item_frame, 1, GT_Values.W), new ItemStack(Items.leather, 1), GT_OreDictUnificator.getDust(Materials.Wood, OrePrefixes.stick.mMaterialAmount * 4L), 95, false);
		GT_ModHandler.addPulverisationRecipe(new ItemStack(Items.bow, 1, 0), new ItemStack(Items.string, 3), GT_OreDictUnificator.getDust(Materials.Wood, OrePrefixes.stick.mMaterialAmount * 3L), 95, false);

		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stonebrick, 1, 2), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.cobblestone, 1, 0), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.cobblestone, 1, 0), new ItemStack(Blocks.gravel, 1, 0), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.sandstone, 1, GT_Values.W), new ItemStack(Blocks.sand, 1, 0), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.ice, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.packed_ice, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 2L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.hardened_clay, 1, 0), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.brick_block, 1, 0), new ItemStack(Items.brick, 3, 0), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.nether_brick, 1, 0), new ItemStack(Items.netherbrick, 3, 0), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.stained_glass, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.glass, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.stained_glass_pane, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 3L), 16, 10);
		GT_Values.RA.addForgeHammerRecipe(new ItemStack(Blocks.glass_pane, 1, GT_Values.W), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 3L), 16, 10);

		GT_Values.RA.addForgeHammerRecipe(GT_ModHandler.getModItem("HardcoreEnderExpansion", "endium_ore", 1), GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Endium, 1), 16, 10);
		GT_ModHandler.addPulverisationRecipe(GT_ModHandler.getModItem("HardcoreEnderExpansion", "endium_ore", 1), GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Endium, 2), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1), 50, GT_Values.NI, 0, true);
		GT_OreDictUnificator.set(OrePrefixes.ingot, Materials.Endium, GT_ModHandler.getModItem("HardcoreEnderExpansion", "endium_ingot", 1), true, true);

		GT_Values.RA.addAmplifier(ItemList.IC2_Scrap.get(9L), 180, 1);
		GT_Values.RA.addAmplifier(ItemList.IC2_Scrapbox.get(1L), 180, 1);

		GT_Values.RA.addBoxingRecipe(ItemList.IC2_Scrap.get(9L), ItemList.Schematic_3by3.get(0L), ItemList.IC2_Scrapbox.get(1L), 16, 1);
		GT_Values.RA.addBoxingRecipe(ItemList.Food_Fries.get(1L), GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Paper, 1L), ItemList.Food_Packaged_Fries.get(1L), 64, 16);
		GT_Values.RA.addBoxingRecipe(ItemList.Food_PotatoChips.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 1L), ItemList.Food_Packaged_PotatoChips.get(1L), 64, 16);
		GT_Values.RA.addBoxingRecipe(ItemList.Food_ChiliChips.get(1L), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 1L), ItemList.Food_Packaged_ChiliChips.get(1L), 64, 16);

		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), (int) Math.max(Materials.TungstenSteel.getMass() / 80L, 1L) * Materials.TungstenSteel.mBlastFurnaceTemp, 480, Materials.TungstenSteel.mBlastFurnaceTemp);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 2L), GT_Values.NI, (int) Math.max(Materials.TungstenCarbide.getMass() / 40L, 1L) * Materials.TungstenCarbide.mBlastFurnaceTemp, 480, Materials.TungstenCarbide.mBlastFurnaceTemp);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Vanadium, 3L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gallium, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 4L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 2L), (int) Math.max(Materials.VanadiumGallium.getMass() / 40L, 1L) * Materials.VanadiumGallium.mBlastFurnaceTemp, 480, Materials.VanadiumGallium.mBlastFurnaceTemp);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Niobium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Titanium, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), (int) Math.max(Materials.NiobiumTitanium.getMass() / 80L, 1L) * Materials.NiobiumTitanium.mBlastFurnaceTemp, 480, Materials.NiobiumTitanium.mBlastFurnaceTemp);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 4L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Chrome, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 5L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 2L), (int) Math.max(Materials.Nichrome.getMass() / 32L, 1L) * Materials.Nichrome.mBlastFurnaceTemp, 480, Materials.Nichrome.mBlastFurnaceTemp);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L), 400, 100, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Ruby, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L), 320, 100, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L), 400, 100, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.GreenSapphire, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 1L), 320, 100, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_Values.NI, 400, 100, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Sapphire, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), GT_Values.NI, 320, 100, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 4L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Titanium, 4L), 800, 480, 1700);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Ilmenite, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 5L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Titanium, 5L), 640, 480, 1700);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Silver, 4L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Lead, 4L), 400, 480, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Galena, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Silver, 5L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Lead, 5L), 320, 480, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 4L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), 400, 480, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Magnetite, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 5L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Ash, 1L), 320, 480, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), 480, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PigIron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), 100, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), 100, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ShadowIron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ShadowSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), 480, 120, 1100);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricIron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 1L), 480, 120, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L), GT_Values.NI, 480, 120, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L), GT_Values.NI, 480, 120, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L),  GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 5L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 3L),  GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silicon, 1L), 100, 120, 1200);
		//GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 4000, 360, 2000);
		//GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 3L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silicon, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 4L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkAsh, 2L), (int) Math.max(Materials.ElectricalSteel.getMass() / 40L, 1L) * Materials.ElectricalSteel.mBlastFurnaceTemp, 480, Materials.ElectricalSteel.mBlastFurnaceTemp);
		
		//EnderIO Compat.
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI, 800, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.RedstoneAlloy, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI, 800, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.RedstoneAlloy, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L), GT_Values.NI, 800, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI, 1200, 120, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.ConductiveIron, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI, 1200, 120, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.ConductiveIron, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L), GT_Values.NI, 1200, 120, 1200);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI, 1600, 120, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.EnergeticAlloy, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI, 1600, 120, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.EnergeticAlloy, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L), GT_Values.NI, 1600, 120, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L), GT_Values.NI, 3000, 120, 3000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.VibrantAlloy, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L), GT_Values.NI, 3000, 120, 3000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.VibrantAlloy, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L), GT_Values.NI, 3000, 120, 3000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), GT_Values.NI, 1200, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.ElectricalSteel, 9L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), GT_Values.NI, 1200, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.ElectricalSteel, 4L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), GT_Values.NI, 1200, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI, 1600, 120, 1600);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.PulsatingIron, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI, 1600, 120, 1600);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.PulsatingIron, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L), GT_Values.NI, 1600, 120, 1600);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 1000, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Soularium, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 1000, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Soularium, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L), GT_Values.NI, 1000, 120, 1000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 1000, 120, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkSteel, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 1000, 120, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.DarkSteel, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L), GT_Values.NI, 1000, 120, 1500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L), GT_Values.NI, 3000, 120, 3000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.EnderiumBase, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L), GT_Values.NI, 3000, 120, 3000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.EnderiumBase, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L), GT_Values.NI, 3000, 120, 3000);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 3500, 120, 3500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Enderium, 9L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 3500, 120, 3500);
		GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Enderium, 4L), GT_Values.NI, Materials.Oxygen.getGas(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L), GT_Values.NI, 3500, 120, 3500);
		
		GT_Values.RA.addCannerRecipe(GT_ModHandler.getIC2Item("fuelRod", 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lithium, 1L), GT_ModHandler.getIC2Item("reactorLithiumCell", 1, 1), null, 16, 64);
		GT_Values.RA.addFluidExtractionRecipe(GT_ModHandler.getIC2Item("TritiumCell", 1), GT_ModHandler.getIC2Item("fuelRod", 1), Materials.Tritium.getGas(32), 10000, 16, 64);
		GT_Values.RA.addCannerRecipe(GT_ModHandler.getIC2Item("fuelRod", 1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 3), ItemList.ThoriumCell_1.get(1L), null, 30, 16);
		GT_Values.RA.addCannerRecipe(GT_ModHandler.getIC2Item("fuelRod", 1), GT_ModHandler.getIC2Item("UranFuel", 1), GT_ModHandler.getIC2Item("reactorUraniumSimple", 1, 1), null, 30, 16);
		GT_Values.RA.addCannerRecipe(GT_ModHandler.getIC2Item("fuelRod", 1), GT_ModHandler.getIC2Item("MOXFuel", 1), GT_ModHandler.getIC2Item("reactorMOXSimple", 1, 1), null, 30, 16);

		GT_Values.RA.addFusionReactorRecipe(Materials.Lithium.getMolten(16), Materials.Tungsten.getMolten(16), Materials.Iridium.getMolten(16), 32, 32768, 300000000);
		GT_Values.RA.addFusionReactorRecipe(Materials.Deuterium.getGas(125), Materials.Tritium.getGas(125), Materials.Helium.getPlasma(125), 16, 4096, 40000000);  //Mark 1 Cheap //
		GT_Values.RA.addFusionReactorRecipe(Materials.Deuterium.getGas(125), Materials.Helium_3.getGas(125), Materials.Helium.getPlasma(125), 16, 2048, 60000000); //Mark 1 Expensive //
		GT_Values.RA.addFusionReactorRecipe(Materials.Carbon.getMolten(125), Materials.Helium_3.getGas(125), Materials.Oxygen.getPlasma(125), 32, 4096, 80000000); //Mark 1 Expensive //
		GT_Values.RA.addFusionReactorRecipe(Materials.Aluminium.getMolten(16), Materials.Lithium.getMolten(16), Materials.Sulfur.getPlasma(125), 32, 10240, 240000000); //Mark 2 Cheap
		GT_Values.RA.addFusionReactorRecipe(Materials.Beryllium.getMolten(16), Materials.Deuterium.getGas(375), Materials.Nitrogen.getPlasma(175), 16, 16384, 180000000); //Mark 2 Expensive //
		GT_Values.RA.addFusionReactorRecipe(Materials.Silicon.getMolten(16), Materials.Magnesium.getMolten(16), Materials.Iron.getPlasma(125), 32, 8192, 360000000); //Mark 3 Cheap //
		GT_Values.RA.addFusionReactorRecipe(Materials.Potassium.getMolten(16), Materials.Fluorine.getGas(125), Materials.Nickel.getPlasma(125), 16, 32768, 480000000); //Mark 3 Expensive //
		GT_Values.RA.addFusionReactorRecipe(Materials.Beryllium.getMolten(16), Materials.Tungsten.getMolten(16), Materials.Platinum.getMolten(16), 32, 32768, 150000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Neodymium.getMolten(16), Materials.Hydrogen.getGas(48), Materials.Europium.getMolten(16), 64, 24576, 150000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Lutetium.getMolten(16), Materials.Chrome.getMolten(16), Materials.Americium.getMolten(16), 96, 49152, 200000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Plutonium.getMolten(16), Materials.Thorium.getMolten(16), Materials.Naquadah.getMolten(16), 64, 32768, 300000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Americium.getMolten(16), Materials.Naquadria.getMolten(16), Materials.Neutronium.getMolten(1), 1200, 98304, 600000000); //

		GT_Values.RA.addFusionReactorRecipe(Materials.Tungsten.getMolten(16), Materials.Helium.getGas(16), Materials.Osmium.getMolten(16), 64, 24578, 150000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Manganese.getMolten(16), Materials.Hydrogen.getGas(16), Materials.Iron.getMolten(16), 64, 8192, 120000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Mercury.getFluid(16), Materials.Magnesium.getMolten(16), Materials.Uranium.getMolten(16), 64, 49152, 240000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Gold.getMolten(16), Materials.Aluminium.getMolten(16), Materials.Uranium.getMolten(16), 64, 49152, 240000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Uranium.getMolten(16), Materials.Helium.getGas(16), Materials.Plutonium.getMolten(16), 128, 49152, 480000000); //
		GT_Values.RA.addFusionReactorRecipe(Materials.Vanadium.getMolten(16), Materials.Hydrogen.getGas(125), Materials.Chrome.getMolten(16), 64, 24576, 140000000); //

		GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Fertilizer.get(1L));
		GT_Values.RA.addImplosionRecipe(ItemList.IC2_Compressed_Coal_Chunk.get(1L), 8, ItemList.IC2_Industrial_Diamond.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.DarkAsh, 4L));
		GT_Values.RA.addFluidExtractionRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L), null, Materials.Glass.getMolten(250), 10000, 600, 28);//(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SiliconDioxide,1L), GT_OreDictUnificator.get(OrePrefixes.dust,Materials.SiliconDioxide,2L),GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Glass,1L)/** GT_Utility.fillFluidContainer(Materials.Glass.getMolten(1000), ItemList.Cell_Empty.get(1, new Object[0]), true, true)**/, 600, 16);

        GT_Values.RA.addPyrolyseRecipe(GT_ModHandler.getIC2Item("biochaff", 1), Materials.Water.getFluid(1000), 1, null, new FluidStack(FluidRegistry.getFluid("ic2biomass"), 1500), 100, 10);
        GT_Values.RA.addPyrolyseRecipe(new ItemStack(Items.reeds, 24, 0), null, 1, (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 12)),   Materials.Water.getFluid(11000), 320, 32);

        if (Loader.isModLoaded(GT_Values.MOD_ID_RC)) {
			GT_Values.RA.addPyrolyseRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Coal, 16), null, 1, RailcraftToolItems.getCoalCoke(16), Materials.Creosote.getFluid(8000), 640, 32);
			GT_Values.RA.addPyrolyseRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 8), null, 1, EnumCube.COKE_BLOCK.getItem(8), Materials.Creosote.getFluid(32000), 2560, 32);
		}

		GT_Values.RA.addHydroFarmRecipe(new ItemStack(Items.melon_seeds, 9, 0), ItemList.IC2_Fertilizer.get(1L), Materials.Water.getFluid(1000), new ItemStack(Blocks.melon_block, 9, 0),   GT_Values.NF, 1000, 40);

		GT_Values.RA.addDistillationTowerRecipe(Materials.Oil.getFluid(64L), new FluidStack[]{Materials.Lubricant.getFluid(16L), Materials.Fuel.getFluid(64L), Materials.SulfuricAcid.getFluid(64L), Materials.Glyceryl.getFluid(4L), Materials.Methane.getGas(60L)}, null, 16, 64);
		GT_Values.RA.addDistillationTowerRecipe(new FluidStack(ItemList.sOilLight, 128), new FluidStack[]{Materials.Lubricant.getFluid(16L), Materials.Fuel.getFluid(64L), Materials.SulfuricAcid.getFluid(64L), Materials.Glyceryl.getFluid(4L), Materials.Methane.getGas(60L)}, null, 16, 64);
		GT_Values.RA.addDistillationTowerRecipe(new FluidStack(ItemList.sOilMedium, 64), new FluidStack[]{Materials.Lubricant.getFluid(16L), Materials.Fuel.getFluid(64L), Materials.SulfuricAcid.getFluid(64L), Materials.Glyceryl.getFluid(4L), Materials.Methane.getGas(60L)}, null, 16, 64);
		GT_Values.RA.addDistillationTowerRecipe(new FluidStack(ItemList.sOilHeavy, 32), new FluidStack[]{Materials.Lubricant.getFluid(16L), Materials.Fuel.getFluid(64L), Materials.SulfuricAcid.getFluid(64L), Materials.Glyceryl.getFluid(4L), Materials.Methane.getGas(60L)}, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.HydratedCoal, 1L), 24, 64);
		GT_Values.RA.addDistillationTowerRecipe(new FluidStack(ItemList.sOilExtraHeavy, 16), new FluidStack[]{Materials.Lubricant.getFluid(16L), Materials.Fuel.getFluid(64L), Materials.SulfuricAcid.getFluid(64L), Materials.Glyceryl.getFluid(4L), Materials.Methane.getGas(60L)}, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.HydratedCoal, 1L), 24, 64);
		GT_Values.RA.addDistillationTowerRecipe(new FluidStack(ItemList.sNaturalGas, 64), new FluidStack[]{Materials.Methane.getGas(120L)}, null, 16, 64);
		GT_Values.RA.addDistillationTowerRecipe(Materials.Creosote.getFluid(24L), new FluidStack[]{Materials.Lubricant.getFluid(12L)}, null, 16, 96);
		GT_Values.RA.addDistillationTowerRecipe(Materials.SeedOil.getFluid(32L), new FluidStack[]{Materials.Lubricant.getFluid(12L)}, null, 16, 96);
		GT_Values.RA.addDistillationTowerRecipe(Materials.FishOil.getFluid(24L), new FluidStack[]{Materials.Lubricant.getFluid(12L)}, null, 16, 96);
		GT_Values.RA.addDistillationTowerRecipe(Materials.Biomass.getFluid(150L), new FluidStack[]{Materials.Ethanol.getFluid(60L), Materials.Water.getFluid(60L)}, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1L), 25, 64);
		GT_Values.RA.addDistillationTowerRecipe(Materials.Water.getFluid(288L), new FluidStack[]{GT_ModHandler.getDistilledWater(260L)}, null, 16, 64);
		GT_Values.RA.addDistillationTowerRecipe(new FluidStack(FluidRegistry.getFluid("ic2biomass"), 250), new FluidStack[]{new FluidStack(FluidRegistry.getFluid("ic2biogas"), 8000), Materials.Water.getFluid(125L)}, ItemList.IC2_Fertilizer.get(1), 150, 512);
		GT_Values.RA.addFuel(GT_ModHandler.getIC2Item("biogasCell", 1L), null, 32, 1);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new FluidStack(FluidRegistry.getFluid("ic2biomass"), 1), new FluidStack(FluidRegistry.getFluid("ic2biogas"), 32), 20, 30, false);
		GT_Values.RA.addDistilleryRecipe(ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new FluidStack(FluidRegistry.getFluid("ic2biomass"), 4), Materials.Water.getFluid(2), 80, 30, false);


		GT_Values.RA.addFuel(GT_ModHandler.getModItem(GT_Values.MOD_ID_TC, "ItemShard", 1L, 6), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "GluttonyShard", 1L), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "FMResource", 1L, 3), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L, 1), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L, 2), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L, 3), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L, 4), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L, 5), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ForbiddenMagic", "NetherShard", 1L, 6), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("TaintedMagic", "WarpedShard", 1L), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("TaintedMagic", "FluxShard", 1L), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("TaintedMagic", "EldritchShard", 1L), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ThaumicTinkerer", "kamiResource", 1L, 6), null, 720, 5);
		GT_Values.RA.addFuel(GT_ModHandler.getModItem("ThaumicTinkerer", "kamiResource", 1L, 7), null, 720, 5);
		GT_Values.RA.addFuel(new ItemStack(Items.golden_apple,1,1), new ItemStack(Items.apple,1), 640000, 5);

		GT_Values.RA.addElectrolyzerRecipe(GT_Values.NI, ItemList.Cell_Empty.get(1L), Materials.Water.getFluid(3000L), Materials.Hydrogen.getGas(2000L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 1500, 30);
		GT_Values.RA.addElectrolyzerRecipe(GT_Values.NI, ItemList.Cell_Empty.get(1L), GT_ModHandler.getDistilledWater(3000L), Materials.Hydrogen.getGas(2000L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 1500, 30);
		GT_Values.RA.addElectrolyzerRecipe(GT_ModHandler.getIC2Item("electrolyzedWaterCell", 3L), 0, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 30, 30);
		GT_Values.RA.addElectrolyzerRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L), 0, GT_ModHandler.getIC2Item("electrolyzedWaterCell", 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, 490, 30);
		GT_Values.RA.addElectrolyzerRecipe(ItemList.Dye_Bonemeal.get(3L), 0, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, 98, 26);
		GT_Values.RA.addElectrolyzerRecipe(new ItemStack(Blocks.sand, 8), 0, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, 500, 25);

		GT_Values.RA.addElectrolyzerRecipe(GT_Values.NI, ItemList.Cell_Empty.get(6L), Materials.SulfuricAcid.getFluid(7000L), null , GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L), GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 380, 90);

		GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chalcopyrite, 1L), Materials.Oxygen.getGas(4000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Copper, 1L)), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1L)), GT_Values.NI ,Materials.SulfurDioxide.getGas(1000L),null, 512, 16);
		GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenite, 1L), Materials.Oxygen.getGas(6000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Molybdenum, 1L)), GT_Values.NI, GT_Values.NI ,Materials.SulfurDioxide.getGas(200L),null, 512, 16);
		GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobaltite, 1L), Materials.Oxygen.getGas(3000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Cobalt, 1L)), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Arsenic, 1L)), GT_Values.NI ,Materials.SulfurDioxide.getGas(1000L),null, 512, 16);
		GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentlandite, 1L), Materials.Oxygen.getGas(8000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Nickel, 2L)), GT_Values.NI , GT_Values.NI ,Materials.SulfurDioxide.getGas(1000L),null, 512, 16);
        GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stibnite, 1L), Materials.Oxygen.getGas(5000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Antimony, 1L)), GT_Values.NI , GT_Values.NI ,Materials.SulfurDioxide.getGas(1000L),null, 512, 16);
        GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sphalerite, 1L), Materials.Oxygen.getGas(4000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Zinc, 2L)), GT_Values.NI , GT_Values.NI ,Materials.SulfurDioxide.getGas(1000L),null, 512, 16);
        GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1L), Materials.Oxygen.getGas(2000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Silver, 1L)), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lead, 1L)) , GT_Values.NI ,Materials.SulfurDioxide.getGas(500L),null, 512, 16);
        GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pyrite, 1L), Materials.Oxygen.getGas(3000L), (GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 1L)), GT_Values.NI , GT_Values.NI ,Materials.SulfurDioxide.getGas(1000L),null, 512, 16);
        GT_Values.RA.addRoasterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), Materials.Oxygen.getGas(8000L), (GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sulfur, 1L)), GT_Values.NI, GT_Values.NI , Materials.SulfurDioxide.getGas(3000L), new int[]{1000} , 512, 16);

        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfurDioxide, 1L), GT_Values.NI , GT_Values.NI, GT_Values.NI, Materials.Water.getFluid(2000L), Materials.SulfuricAcid.getFluid(3000L),ItemList.Cell_Empty.get(1L), 1150, 30);
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 2L), GT_Values.NI , GT_Values.NI, GT_Values.NI, Materials.SulfurDioxide.getGas(1000L), Materials.SulfuricAcid.getFluid(3000L),ItemList.Cell_Empty.get(2L), 1150, 30);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 3L), 500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 3L), 500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), Materials.Water.getFluid(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Quartzite, 3L), 500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), GT_ModHandler.getDistilledWater(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 3L), 500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), GT_ModHandler.getDistilledWater(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 3L), 500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 3L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), GT_ModHandler.getDistilledWater(1000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Quartzite, 3L), 500);

		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), 1000);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L), GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), 1000);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), Materials.Oxygen.getGas(3000L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 5L), 500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), GT_Values.NI, Materials.Hydrogen.getGas(4000L), Materials.Methane.getGas(5000L), GT_Values.NI, 3500);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), Materials.Water.getFluid(2000L), Materials.SulfuricAcid.getFluid(3000L), GT_Values.NI, 1150);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L), Materials.Oxygen.getGas(4000L), Materials.SodiumPersulfate.getFluid(6000L), GT_Values.NI, 8000);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Nitrogen, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), Materials.Water.getFluid(2000L), Materials.Glyceryl.getFluid(4000L), ItemList.Cell_Empty.get(1L), 2700);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 1L), GT_Values.NI, Materials.Glyceryl.getFluid(250L), Materials.NitroFuel.getFluid(1250L), ItemList.Cell_Empty.get(1L), 250);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Glyceryl, 1L), GT_Values.NI, Materials.Fuel.getFluid(4000L), Materials.NitroFuel.getFluid(5000L), ItemList.Cell_Empty.get(1L), 1000);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Nitrogen, 1L), GT_Values.NI, Materials.Oxygen.getGas(2000L), Materials.NitrogenDioxide.getGas(3000L), ItemList.Cell_Empty.get(1L), 1250);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 2L), GT_Values.NI, Materials.Nitrogen.getGas(1000L), Materials.NitrogenDioxide.getGas(3000L), ItemList.Cell_Empty.get(2L), 1250);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L), GT_Values.NI, Materials.Hydrogen.getGas(2000L), GT_ModHandler.getDistilledWater(3000L), ItemList.Cell_Empty.get(1L), 10);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 1L), GT_Values.NI, Materials.Oxygen.getGas(500L), GT_ModHandler.getDistilledWater(1500L), ItemList.Cell_Empty.get(1L), 5);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 1L), Materials.Glass.getMolten(864L), GT_Values.NF, GT_ModHandler.getModItem(GT_Values.MOD_ID_RC, "tile.railcraft.glass", 6L), 50);

		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Gold, 8L), new ItemStack(Items.melon, 1, GT_Values.W), new ItemStack(Items.speckled_melon, 1, 0), 50);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Gold, 8L), new ItemStack(Items.carrot, 1, GT_Values.W), new ItemStack(Items.golden_carrot, 1, 0), 50);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 8L), new ItemStack(Items.apple, 1, GT_Values.W), new ItemStack(Items.golden_apple, 1, 0), 50);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Gold, 8L), new ItemStack(Items.apple, 1, GT_Values.W), new ItemStack(Items.golden_apple, 1, 1), 50);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1L), 50);
		GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 1L), new ItemStack(Items.slime_ball, 1, GT_Values.W), new ItemStack(Items.magma_cream, 1, 0), 50);

		GT_Values.RA.addBenderRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Advanced, 1L), 100, 8);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 6L), ItemList.RC_Rail_Standard.get(2L), 200, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 6L), ItemList.RC_Rail_Standard.get(4L), 400, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 6L), ItemList.RC_Rail_Standard.get(5L), 400, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 6L), ItemList.RC_Rail_Standard.get(3L), 300, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 6L), ItemList.RC_Rail_Standard.get(8L), 800, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 6L), ItemList.RC_Rail_Standard.get(12L), 1200, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 6L), ItemList.RC_Rail_Standard.get(16L), 1600, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 6L), ItemList.RC_Rail_Reinforced.get(24L), 2400, 30);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 12L), ItemList.RC_Rebar.get(4L), 200, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 12L), ItemList.RC_Rebar.get(8L), 400, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 12L), ItemList.RC_Rebar.get(10L), 400, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 12L), ItemList.RC_Rebar.get(8L), 400, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 12L), ItemList.RC_Rebar.get(16L), 800, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 12L), ItemList.RC_Rebar.get(24L), 1200, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 12L), ItemList.RC_Rebar.get(32L), 1600, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 12L), ItemList.RC_Rebar.get(48L), 2400, 15);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 12L), ItemList.Cell_Empty.get(6L), 1200, 8);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 12L), new ItemStack(Items.bucket, 4, 0), 800, 4);
		GT_Values.RA.addBenderRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 12L), new ItemStack(Items.bucket, 4, 0), 800, 4);
		GT_Values.RA.addBenderRecipe(ItemList.IC2_Item_Casing_Iron.get(2L), GT_ModHandler.getIC2Item("fuelRod", 1L), 100, 8);
		GT_Values.RA.addBenderRecipe(ItemList.IC2_Item_Casing_Tin.get(1L), ItemList.IC2_Food_Can_Empty.get(1L), 100, 8);

		GT_Values.RA.addPulveriserRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Marble, 1L), new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Marble, 1L)}, null, 160, 4);

		GT_Values.RA.addVacuumFreezerRecipe(GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, GT_Values.W), GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1), 100);
		GT_Values.RA.addVacuumFreezerRecipe(GT_ModHandler.getIC2Item("reactorCoolantTriple", 1L, GT_Values.W), GT_ModHandler.getIC2Item("reactorCoolantTriple", 1L, 1), 300);
		GT_Values.RA.addVacuumFreezerRecipe(GT_ModHandler.getIC2Item("reactorCoolantSix", 1L, GT_Values.W), GT_ModHandler.getIC2Item("reactorCoolantSix", 1L, 1), 600);
		GT_Values.RA.addVacuumFreezerRecipe(ItemList.Reactor_Coolant_He_1.getWildcard(1L), ItemList.Reactor_Coolant_He_1.get(1L), 600);
		GT_Values.RA.addVacuumFreezerRecipe(ItemList.Reactor_Coolant_He_3.getWildcard(1L), ItemList.Reactor_Coolant_He_3.get(1L), 1800);
		GT_Values.RA.addVacuumFreezerRecipe(ItemList.Reactor_Coolant_He_6.getWildcard(1L), ItemList.Reactor_Coolant_He_6.get(1L), 3600);
		GT_Values.RA.addVacuumFreezerRecipe(ItemList.Reactor_Coolant_NaK_1.getWildcard(1L), ItemList.Reactor_Coolant_NaK_1.get(1L), 600);
		GT_Values.RA.addVacuumFreezerRecipe(ItemList.Reactor_Coolant_NaK_3.getWildcard(1L), ItemList.Reactor_Coolant_NaK_3.get(1L), 1800);
		GT_Values.RA.addVacuumFreezerRecipe(ItemList.Reactor_Coolant_NaK_6.getWildcard(1L), ItemList.Reactor_Coolant_NaK_6.get(1L), 3600);
		GT_Values.RA.addVacuumFreezerRecipe(GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Ice, 1L), 50);

		GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L), ItemList.TE_Hardened_Glass.get(2L), 200, 16);
		GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Lead, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L), ItemList.TE_Hardened_Glass.get(2L), 200, 16);

		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_TRANSPORT, "item.buildcraftPipe.pipestructurecobblestone", 1L, 0), GT_ModHandler.getModItem(GT_Values.MOD_ID_BC_TRANSPORT, "pipePlug", 8L, 0), GT_Values.NI, 32, 16);
		for (int i = 0; i < 16; i++) {
			GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.stained_glass, 3, i), new ItemStack(Blocks.stained_glass_pane, 8, i), GT_Values.NI, 50, 8);
		}
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.glass, 3, 0), new ItemStack(Blocks.glass_pane, 8, 0), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.stone_slab, 2, 0), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.sandstone, 1, 0), new ItemStack(Blocks.stone_slab, 2, 1), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.cobblestone, 1, 0), new ItemStack(Blocks.stone_slab, 2, 3), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.brick_block, 1, 0), new ItemStack(Blocks.stone_slab, 2, 4), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(Blocks.stone_slab, 2, 5), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.nether_brick, 1, 0), new ItemStack(Blocks.stone_slab, 2, 6), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.quartz_block, 1, GT_Values.W), new ItemStack(Blocks.stone_slab, 2, 7), GT_Values.NI, 25, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.glowstone, 1, 0), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 4L), GT_Values.NI, 100, 16);

		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), ItemList.IC2_Item_Casing_Iron.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L), ItemList.IC2_Item_Casing_Iron.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L), ItemList.IC2_Item_Casing_Gold.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1L), ItemList.IC2_Item_Casing_Bronze.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L), ItemList.IC2_Item_Casing_Copper.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1L), ItemList.IC2_Item_Casing_Copper.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1L), ItemList.IC2_Item_Casing_Tin.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 1L), ItemList.IC2_Item_Casing_Lead.get(2L), GT_Values.NI, 50, 16);
		GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L), ItemList.IC2_Item_Casing_Steel.get(2L), GT_Values.NI, 50, 16);
		for (byte i = 0; i < 16; i = (byte) (i + 1)) {
			GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wool, 2, i), new ItemStack(Blocks.carpet, 3, i), GT_Values.NI, 50, 8);
		}
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wooden_slab, 1, 0), ItemList.Plank_Oak.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wooden_slab, 1, 1), ItemList.Plank_Spruce.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wooden_slab, 1, 2), ItemList.Plank_Birch.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wooden_slab, 1, 3), ItemList.Plank_Jungle.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wooden_slab, 1, 4), ItemList.Plank_Acacia.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(new ItemStack(Blocks.wooden_slab, 1, 5), ItemList.Plank_DarkOak.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 0), ItemList.Plank_Larch.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 1), ItemList.Plank_Teak.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 2), ItemList.Plank_Acacia_Green.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 3), ItemList.Plank_Lime.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 4), ItemList.Plank_Chestnut.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 5), ItemList.Plank_Wenge.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 6), ItemList.Plank_Baobab.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs1", 1L, 7), ItemList.Plank_Sequoia.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 0), ItemList.Plank_Kapok.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 1), ItemList.Plank_Ebony.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 2), ItemList.Plank_Mahagony.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 3), ItemList.Plank_Balsa.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 4), ItemList.Plank_Willow.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 5), ItemList.Plank_Walnut.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 6), ItemList.Plank_Greenheart.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs2", 1L, 7), ItemList.Plank_Cherry.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 0), ItemList.Plank_Mahoe.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 1), ItemList.Plank_Poplar.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 2), ItemList.Plank_Palm.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 3), ItemList.Plank_Papaya.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 4), ItemList.Plank_Pine.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 5), ItemList.Plank_Plum.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 6), ItemList.Plank_Maple.get(2L), GT_Values.NI, 50, 8);
		GT_Values.RA.addCutterRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_FR, "slabs3", 1L, 7), ItemList.Plank_Citrus.get(2L), GT_Values.NI, 50, 8);

		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Cupronickel, 1L), ItemList.Shape_Mold_Credit.get(0L), ItemList.Credit_Greg_Cupronickel.get(4L), 100, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1L), ItemList.Shape_Mold_Credit.get(0L), ItemList.Coin_Doge.get(4L), 100, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), ItemList.Shape_Mold_Credit.get(0L), ItemList.Credit_Iron.get(4L), 100, 16);
		GT_Values.RA.addFormingPressRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L), ItemList.Shape_Mold_Credit.get(0L), ItemList.Credit_Iron.get(4L), 100, 16);

		if (!GT_Mod.gregtechproxy.mDisableIC2Cables) {
			GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L), GT_ModHandler.getIC2Item("copperCableItem", 3L), 100, 2);
			GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1L), GT_ModHandler.getIC2Item("copperCableItem", 3L), 100, 2);
			GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1L), GT_ModHandler.getIC2Item("tinCableItem", 4L), 150, 1);
			GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), GT_ModHandler.getIC2Item("ironCableItem", 6L), 200, 2);
			GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L), GT_ModHandler.getIC2Item("ironCableItem", 6L), 200, 2);
			GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L), GT_ModHandler.getIC2Item("goldCableItem", 6L), 200, 1);
		}
		GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 8L), GT_ModHandler.getIC2Item("carbonFiber", 1L), 400, 2);
		GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphene, 1L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Graphene, 1L), 400, 2);
		if (!GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "torchesFromCoal", false)) {
			GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Items.coal, 1, GT_Values.W), new ItemStack(Blocks.torch, 4), 400, 1);
		}
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new ItemStack(Blocks.light_weighted_pressure_plate, 1), 200, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new ItemStack(Blocks.heavy_weighted_pressure_plate, 1), 200, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 6L), ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new ItemStack(Items.iron_door, 1), 600, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 7L), ItemList.Circuit_Integrated.getWithDamage(0L, 7L), new ItemStack(Items.cauldron, 1), 700, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_ModHandler.getIC2Item("ironFence", 1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 3L), ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new ItemStack(Blocks.iron_bars, 4), 300, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), new ItemStack(Blocks.heavy_weighted_pressure_plate, 1), 200, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 6L), ItemList.Circuit_Integrated.getWithDamage(0L, 6L), new ItemStack(Items.iron_door, 1), 600, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 7L), ItemList.Circuit_Integrated.getWithDamage(0L, 7L), new ItemStack(Items.cauldron, 1), 700, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), GT_ModHandler.getIC2Item("ironFence", 1L), 100, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 3L), ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new ItemStack(Blocks.iron_bars, 4), 300, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 3L), ItemList.Circuit_Integrated.getWithDamage(0L, 3L), new ItemStack(Blocks.fence, 1), 300, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L), new ItemStack(Blocks.tripwire_hook, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.WroughtIron, 2L), new ItemStack(Blocks.tripwire_hook, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 3L), new ItemStack(Items.string, 3, GT_Values.W), new ItemStack(Items.bow, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 3L), ItemList.Component_Minecart_Wheels_Iron.get(2L), new ItemStack(Items.minecart, 1), 500, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 3L), ItemList.Component_Minecart_Wheels_Iron.get(2L), new ItemStack(Items.minecart, 1), 400, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3L), ItemList.Component_Minecart_Wheels_Steel.get(2L), new ItemStack(Items.minecart, 1), 300, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L), ItemList.Component_Minecart_Wheels_Iron.get(1L), 500, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.WroughtIron, 2L), ItemList.Component_Minecart_Wheels_Iron.get(1L), 400, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 2L), ItemList.Component_Minecart_Wheels_Steel.get(1L), 300, 2);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.minecart, 1), new ItemStack(Blocks.hopper, 1, GT_Values.W), new ItemStack(Items.hopper_minecart, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.minecart, 1), new ItemStack(Blocks.tnt, 1, GT_Values.W), new ItemStack(Items.tnt_minecart, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.minecart, 1), new ItemStack(Blocks.chest, 1, GT_Values.W), new ItemStack(Items.chest_minecart, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.minecart, 1), new ItemStack(Blocks.trapped_chest, 1, GT_Values.W), new ItemStack(Items.chest_minecart, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.minecart, 1), new ItemStack(Blocks.furnace, 1, GT_Values.W), new ItemStack(Items.furnace_minecart, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.tripwire_hook, 1), new ItemStack(Blocks.chest, 1, GT_Values.W), new ItemStack(Blocks.trapped_chest, 1), 200, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.stone, 1, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new ItemStack(Blocks.stonebrick, 1, 0), 50, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.sandstone, 1, 0), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new ItemStack(Blocks.sandstone, 1, 2), 50, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.sandstone, 1, 1), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new ItemStack(Blocks.sandstone, 1, 0), 50, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.sandstone, 1, 2), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new ItemStack(Blocks.sandstone, 1, 0), 50, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_ULV.get(1L), 25, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_LV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_MV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_HV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_EV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_IV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_LuV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_ZPM.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_UV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_MAX.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 1L), Materials.Plastic.getMolten(144), ItemList.Battery_Hull_LV.get(1L), 800, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 3L), Materials.Plastic.getMolten(432), ItemList.Battery_Hull_MV.get(1L), 1600, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnnealedCopper, 2L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 3L), Materials.Plastic.getMolten(432), ItemList.Battery_Hull_MV.get(1L), 1600, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 4L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 9L), Materials.Plastic.getMolten(1296), ItemList.Battery_Hull_HV.get(1L), 3200, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Lead, 2L), ItemList.Casing_ULV.get(1L), ItemList.Hull_ULV.get(1L), 25, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L), ItemList.Casing_LV.get(1L), ItemList.Hull_LV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L), ItemList.Casing_MV.get(1L), ItemList.Hull_MV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnnealedCopper, 2L), ItemList.Casing_MV.get(1L), ItemList.Hull_MV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2L), ItemList.Casing_HV.get(1L), ItemList.Hull_HV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L), ItemList.Casing_EV.get(1L), ItemList.Hull_EV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L), ItemList.Casing_IV.get(1L), ItemList.Hull_IV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Tungsten, 2L), ItemList.Casing_LuV.get(1L), ItemList.Hull_LuV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Osmium, 2L), ItemList.Casing_ZPM.get(1L), ItemList.Hull_ZPM.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.Osmium, 2L), ItemList.Casing_UV.get(1L), ItemList.Hull_UV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 2L), ItemList.Casing_MAX.get(1L), ItemList.Hull_MAX.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 2L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L), ItemList.Battery_Hull_LV.get(1L), 1600, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 6L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L), ItemList.Battery_Hull_MV.get(1L), 2400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 6L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnnealedCopper, 2L), ItemList.Battery_Hull_MV.get(1L), 2400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BatteryAlloy, 18L), GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 4L), ItemList.Battery_Hull_HV.get(1L), 3200, 8);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Items.string, 4, GT_Values.W), new ItemStack(Items.slime_ball, 1, GT_Values.W), new ItemStack(Items.lead, 2), 200, 2);
		GT_Values.RA.addAssemblerRecipe(ItemList.IC2_Compressed_Coal_Ball.get(8L), new ItemStack(Blocks.brick_block, 1), ItemList.IC2_Compressed_Coal_Chunk.get(1L), 400, 4);

		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("waterMill", 2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), GT_ModHandler.getIC2Item("generator", 1L), 6400, 8);
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("batPack", 1L, GT_Values.W), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), ItemList.IC2_ReBattery.get(6L), 800, 4);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.stone_slab, 3, 0), ItemList.RC_Rebar.get(1L), ItemList.RC_Tie_Stone.get(1L), 128, 8);
		GT_Values.RA.addAssemblerRecipe(new ItemStack(Blocks.stone_slab, 3, 7), ItemList.RC_Rebar.get(1L), ItemList.RC_Tie_Stone.get(1L), 128, 8);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 9L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 2L), GT_Values.NF, ItemList.RC_ShuntingWire.get(4L), 1600, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 9L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 2L), GT_Values.NF, ItemList.RC_ShuntingWire.get(4L), 1600, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 3L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 3L), Materials.Blaze.getMolten(432L), ItemList.RC_Rail_HS.get(8L), 400, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Rail_Standard.get(3L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 3L), Materials.Redstone.getMolten(432L), ItemList.RC_Rail_Adv.get(8L), 400, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Rail_Standard.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1L), ItemList.RC_Rail_Electric.get(1L), 50, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Rail_Standard.get(1L), GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 1L), ItemList.RC_Rail_Electric.get(1L), 50, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Tie_Wood.get(6L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L), ItemList.RC_Rail_Wooden.get(6L), 400, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Tie_Wood.get(6L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 1L), ItemList.RC_Rail_Wooden.get(6L), 400, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Tie_Wood.get(4L), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), ItemList.RC_Bed_Wood.get(1L), 200, 4);
		GT_Values.RA.addAssemblerRecipe(ItemList.RC_Tie_Stone.get(4L), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), ItemList.RC_Bed_Stone.get(1L), 200, 4);
		for (ItemStack tRail : new ItemStack[]{ItemList.RC_Rail_Standard.get(6L), ItemList.RC_Rail_Adv.get(6L), ItemList.RC_Rail_Reinforced.get(6L), ItemList.RC_Rail_Electric.get(6L), ItemList.RC_Rail_HS.get(6L), ItemList.RC_Rail_Wooden.get(6L)}) {
			for (ItemStack tBed : new ItemStack[]{ItemList.RC_Bed_Wood.get(1L), ItemList.RC_Bed_Stone.get(1L)}) {
				GT_Values.RA.addAssemblerRecipe(tBed, tRail, GT_ModHandler.getRecipeOutput(tRail, GT_Values.NI, tRail, tRail, tBed, tRail, tRail, GT_Values.NI, tRail), 400, 4);
				GT_Values.RA.addAssemblerRecipe(tBed, tRail, Materials.Redstone.getMolten(144L), GT_ModHandler.getRecipeOutput(tRail, GT_Values.NI, tRail, tRail, tBed, tRail, tRail, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), tRail), 400, 4);
				GT_Values.RA.addAssemblerRecipe(tBed, tRail, Materials.Redstone.getMolten(288L), GT_ModHandler.getRecipeOutput(tRail, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), tRail, tRail, tBed, tRail, tRail, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), tRail), 400, 4);
			}
		}
		GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("carbonFiber", 2L), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), GT_ModHandler.getIC2Item("carbonMesh", 1L), 800, 2);

		GT_Values.RA.addAssemblerRecipe(ItemList.NC_SensorCard.getWildcard(1L), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), ItemList.Circuit_Basic.get(3L), 1600, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L), GT_ModHandler.getIC2Item("generator", 1L), GT_ModHandler.getIC2Item("waterMill", 2L), 6400, 8);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), GT_ModHandler.getIC2Item("machine", 1L), 25, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_UV.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Invar, 1L), ItemList.Casing_HeatProof.get(1L), 50, 16); GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_Coil_Cupronickel.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Kanthal, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_Coil_Kanthal.get(1L), 50, 16);GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Nichrome, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_Coil_Nichrome.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Superconductor, 8L), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), ItemList.Casing_Coil_Superconductor.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1L), ItemList.Casing_SolidSteel.get(1L), 50, 16);GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1L), ItemList.Casing_FrostProof.get(1L), 50, 16);GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 1L), ItemList.Casing_RobustTungstenSteel.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L), ItemList.Casing_CleanStainlessSteel.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1L), ItemList.Casing_StableTitanium.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L), ItemList.Casing_LuV.get(1L), ItemList.Casing_Fusion.get(1L), 50, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Magnalium, 6L), GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.BlueSteel, 1L), ItemList.Casing_Turbine.get(1L), 50, 16);GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 6L), ItemList.Casing_Turbine.get(1L), ItemList.Casing_Turbine.get(1L), 50, 16);
		
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 5L), new ItemStack(Blocks.chest, 1, GT_Values.W), new ItemStack(Blocks.hopper), 800, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 5L), new ItemStack(Blocks.trapped_chest, 1, GT_Values.W), new ItemStack(Blocks.hopper), 800, 2);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 5L), new ItemStack(Blocks.chest, 1, GT_Values.W), new ItemStack(Blocks.hopper), 800, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 5L), new ItemStack(Blocks.trapped_chest, 1, GT_Values.W), new ItemStack(Blocks.hopper), 800, 2);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Magnalium, 2L), GT_ModHandler.getIC2Item("generator", 1L), GT_ModHandler.getIC2Item("windMill", 1L), 6400, 8);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1L), new ItemStack(Items.blaze_powder, 1, 0), new ItemStack(Items.ender_eye, 1, 0), 400, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 6L), new ItemStack(Items.blaze_rod, 1, 0), new ItemStack(Items.ender_eye, 6, 0), 2500, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.gear, Materials.CobaltBrass, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L), ItemList.Component_Sawblade_Diamond.get(1L), 1600, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 5L), new ItemStack(Blocks.tnt, 3, GT_Values.W), GT_ModHandler.getIC2Item("industrialTnt", 5L), 800, 2);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gunpowder, 4L), new ItemStack(Blocks.sand, 4, GT_Values.W), new ItemStack(Blocks.tnt, 1), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4L), new ItemStack(Blocks.redstone_lamp, 1), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Blocks.redstone_torch, 1), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L), new ItemStack(Items.compass, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.WroughtIron, 4L), new ItemStack(Items.compass, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 4L), new ItemStack(Items.clock, 1), 400, 4);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), new ItemStack(Blocks.torch, 2), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L), new ItemStack(Blocks.torch, 6), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.IC2_Resin.get(1L), new ItemStack(Blocks.torch, 6), 400, 1);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 8L), new ItemStack(Items.flint, 1), ItemList.IC2_Compressed_Coal_Ball.get(1L), 400, 4);
		if (!GT_Mod.gregtechproxy.mDisableIC2Cables) {
			GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("tinCableItem", 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L), GT_ModHandler.getIC2Item("insulatedTinCableItem", 1L), 100, 2);
			GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("copperCableItem", 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L), GT_ModHandler.getIC2Item("insulatedCopperCableItem", 1L), 100, 2);
			GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("goldCableItem", 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 2L), GT_ModHandler.getIC2Item("insulatedGoldCableItem", 1L), 200, 2);
			GT_Values.RA.addAssemblerRecipe(GT_ModHandler.getIC2Item("ironCableItem", 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 3L), GT_ModHandler.getIC2Item("insulatedIronCableItem", 1L), 300, 2);
		}
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Items.wooden_sword, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Items.stone_sword, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Items.iron_sword, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Items.golden_sword, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), new ItemStack(Items.diamond_sword, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Bronze, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.Tool_Sword_Bronze.getUndamaged(1L), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.Tool_Sword_Steel.getUndamaged(1L), 100, 16);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.wooden_pickaxe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.stone_pickaxe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.iron_pickaxe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.golden_pickaxe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.diamond_pickaxe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Bronze, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Pickaxe_Bronze.getUndamaged(1L), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Pickaxe_Steel.getUndamaged(1L), 100, 16);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.wooden_shovel, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.stone_shovel, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.iron_shovel, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.golden_shovel, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.diamond_shovel, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Bronze, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Shovel_Bronze.getUndamaged(1L), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Shovel_Steel.getUndamaged(1L), 100, 16);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.wooden_axe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.stone_axe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.iron_axe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.golden_axe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.diamond_axe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Bronze, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Axe_Bronze.getUndamaged(1L), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Axe_Steel.getUndamaged(1L), 100, 16);

		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Wood, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.wooden_hoe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Stone, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.stone_hoe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.iron_hoe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.golden_hoe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Diamond, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), new ItemStack(Items.diamond_hoe, 1), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Bronze, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Hoe_Bronze.getUndamaged(1L), 100, 16);
		GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Steel, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), ItemList.Tool_Hoe_Steel.getUndamaged(1L), 100, 16);

        /* Part Factory */

		/* Electric Motors*/
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 3L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)) , GT_Values.NI, GT_Values.NI, (ItemList.Electric_Motor_LV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 3L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)), GT_Values.NI, GT_Values.NI, (ItemList.Electric_Motor_LV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 6L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2L)), GT_Values.NI, GT_Values.NI, (ItemList.Electric_Motor_MV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnyCopper, 12L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2L)), GT_Values.NI, GT_Values.NI, (ItemList.Electric_Motor_HV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L)), GT_Values.NI, GT_Values.NI, (ItemList.Electric_Motor_EV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L)), GT_Values.NI, GT_Values.NI, (ItemList.Electric_Motor_IV.get(1L)), 100, 16);

        /* Electric Pumps*/
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Tin, 1L), (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1L)) , (ItemList.Electric_Motor_LV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L)), (ItemList.Electric_Pump_LV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Bronze, 1L), (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L)) , (ItemList.Electric_Motor_MV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1L)), (ItemList.Electric_Pump_MV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1L), (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L)) , (ItemList.Electric_Motor_HV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L)), (ItemList.Electric_Pump_HV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StainlessSteel, 1L), (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1L)) , (ItemList.Electric_Motor_EV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1L)), (ItemList.Electric_Pump_EV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.TungstenSteel, 1L), (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1L)) , (ItemList.Electric_Motor_IV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1L)), (ItemList.Electric_Pump_IV.get(1L)), 200, 16);

        /* Conveyors */
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 4L) , (ItemList.Electric_Motor_LV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Conveyor_Module_LV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 4L) , (ItemList.Electric_Motor_MV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Conveyor_Module_MV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 4L) , (ItemList.Electric_Motor_HV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Conveyor_Module_HV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 4L) , (ItemList.Electric_Motor_EV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Conveyor_Module_EV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 4L) , (ItemList.Electric_Motor_IV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Conveyor_Module_IV.get(1L)), 100, 16);

        /* Electric Pistons */
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L) , (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L)) , (ItemList.Electric_Motor_LV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)) , GT_Values.NI, GT_Values.NI, (ItemList.Electric_Piston_LV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L) , (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L)) , (ItemList.Electric_Motor_MV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2L)) , GT_Values.NI, GT_Values.NI, (ItemList.Electric_Piston_MV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L) , (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L)) , (ItemList.Electric_Motor_HV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2L)) , GT_Values.NI, GT_Values.NI, (ItemList.Electric_Piston_HV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L) , (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L)) , (ItemList.Electric_Motor_EV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L)) , GT_Values.NI, GT_Values.NI, (ItemList.Electric_Piston_EV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L) , (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L)) , (ItemList.Electric_Motor_IV.get(1L)), (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L)) , GT_Values.NI, GT_Values.NI, (ItemList.Electric_Piston_IV.get(1L)), 200, 16);

        /* Robot Arms */
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L) , (ItemList.Electric_Piston_LV.get(1L)) , (ItemList.Electric_Motor_LV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)), GT_Values.NI, (ItemList.Robot_Arm_LV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L) , (ItemList.Electric_Piston_MV.get(1L)) , (ItemList.Electric_Motor_MV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2L)), GT_Values.NI, (ItemList.Robot_Arm_MV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L) , (ItemList.Electric_Piston_HV.get(1L)) , (ItemList.Electric_Motor_HV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2L)), GT_Values.NI, (ItemList.Robot_Arm_HV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L) , (ItemList.Electric_Piston_EV.get(1L)) , (ItemList.Electric_Motor_EV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L)), GT_Values.NI, (ItemList.Robot_Arm_EV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1L) , (ItemList.Electric_Piston_IV.get(1L)) , (ItemList.Electric_Motor_IV.get(2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L)), GT_Values.NI, (ItemList.Robot_Arm_IV.get(1L)), 200, 16);

        /* Feild Generators */
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4L) , (new ItemStack(Items.ender_pearl, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 4L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Field_Generator_LV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4L) , (new ItemStack(Items.ender_eye, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 8L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Field_Generator_MV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L) , (new ItemStack(Items.nether_star, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 16L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Field_Generator_HV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L) , (new ItemStack(Items.nether_star, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 32L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Field_Generator_EV.get(1L)), 100, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L) , (new ItemStack(Items.nether_star, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Osmium, 64L)), GT_Values.NI , GT_Values.NI, GT_Values.NI, (ItemList.Field_Generator_IV.get(1L)), 100, 16);

        /* Emitters */
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L) , (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4L)) , GT_Values.NI , GT_Values.NI, (ItemList.Emitter_LV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L) , (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4L)) , GT_Values.NI , GT_Values.NI, (ItemList.Emitter_MV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L) , (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4L)) , GT_Values.NI , GT_Values.NI, (ItemList.Emitter_HV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L) , (new ItemStack(Items.ender_pearl, 1, 1)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4L)) , GT_Values.NI , GT_Values.NI, (ItemList.Emitter_EV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2L) , (new ItemStack(Items.ender_eye, 1, 1)) , (GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 4L)) , GT_Values.NI , GT_Values.NI, (ItemList.Emitter_IV.get(1L)), 200, 16);

        /* Sensors */
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L) , (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1L)) , GT_Values.NI , GT_Values.NI, (ItemList.Sensor_LV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L) , (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1L)) , GT_Values.NI , GT_Values.NI, (ItemList.Sensor_MV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L) , (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L)) , (GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1L)) , GT_Values.NI , GT_Values.NI, (ItemList.Sensor_HV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L) , (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L)) , (new ItemStack(Items.ender_pearl, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1L)) , GT_Values.NI , GT_Values.NI, (ItemList.Sensor_EV.get(1L)), 200, 16);
        GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1L) , (GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4L)) , (new ItemStack(Items.ender_eye, 1, 1)), (GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 1L)) , GT_Values.NI , GT_Values.NI, (ItemList.Sensor_IV.get(1L)), 200, 16);


        /* Better Jetpack recipe using Dragon Egg */
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electricJetpack", 1L));
        if (GT_Mod.gregtechproxy.mDisableIC2Cables) {
            GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), GT_ModHandler.getIC2Item("casingiron", 4L), (ItemList.Battery_Buffer_1by1_LV.get(1L)), (new ItemStack(Items.glowstone_dust, 2, 0)), (new ItemStack(Blocks.dragon_egg, 0, 0)), GT_Values.NI, (GT_ModHandler.getIC2Item("electricJetpack", 1L)), 200, 16);
        } else {
            GT_Values.RA.addPartFactoryRecipe(GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), GT_ModHandler.getIC2Item("casingiron", 4L), (GT_ModHandler.getIC2Item("batBox", 1L)), (new ItemStack(Items.glowstone_dust, 2, 0)), (new ItemStack(Blocks.dragon_egg, 0, 0)), GT_Values.NI, (GT_ModHandler.getIC2Item("electricJetpack", 1L)), 200, 16);
        }

        GT_ModHandler.removeRecipe(new ItemStack(Items.lava_bucket), ItemList.Cell_Empty.get(1L));
		GT_ModHandler.removeRecipe(new ItemStack(Items.water_bucket), ItemList.Cell_Empty.get(1L));

		GT_ModHandler.removeFurnaceSmelting(ItemList.IC2_Resin.get(1L));

		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.golden_apple, 1, 1), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(9216L), new ItemStack(Items.gold_ingot, 64), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 9216, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.golden_apple, 1, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), new ItemStack(Items.gold_ingot, 7), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 9216, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.golden_carrot, 1, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), new ItemStack(Items.gold_nugget, 6), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 9216, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.speckled_melon, 1, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), new ItemStack(Items.gold_nugget, 6), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 9216, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.mushroom_stew, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), new ItemStack(Items.bowl, 16, 0), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.apple, 32, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.bread, 64, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.porkchop, 12, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.cooked_porkchop, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.beef, 12, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.cooked_beef, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.fish, 12, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.cooked_fished, 16, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.chicken, 12, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.cooked_chicken, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.melon, 64, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.pumpkin, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.rotten_flesh, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.spider_eye, 32, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.carrot, 16, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(ItemList.Food_Raw_Potato.get(16L), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(ItemList.Food_Poisonous_Potato.get(12L), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(ItemList.Food_Baked_Potato.get(24L), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.cookie, 64, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.cake, 8, 0), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.brown_mushroom_block, 12, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.red_mushroom_block, 12, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.brown_mushroom, 32, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.red_mushroom, 32, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.nether_wart, 32, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getIC2Item("terraWart", 16L), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.meefRaw", 12L, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.meefSteak", 16L, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.venisonRaw", 12L, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);
		GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_TF, "item.venisonCooked", 16L, GT_Values.W), GT_Values.NI, GT_Values.NF, Materials.Methane.getGas(1152L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 4608, 5);

		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.sand, 1, 1), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Diamond, 1L), new ItemStack(Blocks.sand, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{5000, 100, 5000}, 50, 30);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.dirt, 1, GT_Values.W), GT_Values.NI, GT_Values.NF, GT_Values.NF, ItemList.IC2_Plantball.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Clay, 1L), new ItemStack(Blocks.sand, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{1250, 5000, 5000}, 250, 30);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.grass, 1, GT_Values.W), GT_Values.NI, GT_Values.NF, GT_Values.NF, ItemList.IC2_Plantball.get(1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Clay, 1L), new ItemStack(Blocks.sand, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{2500, 5000, 5000}, 250, 30);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.mycelium, 1, GT_Values.W), GT_Values.NI, GT_Values.NF, GT_Values.NF, new ItemStack(Blocks.brown_mushroom, 1), new ItemStack(Blocks.red_mushroom, 1), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Clay, 1L), new ItemStack(Blocks.sand, 1), GT_Values.NI, GT_Values.NI, new int[]{2500, 2500, 5000, 5000}, 650, 30);
		GT_Values.RA.addCentrifugeRecipe(ItemList.IC2_Resin.get(1L), GT_Values.NI, GT_Values.NF, Materials.Glue.getFluid(100L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 2L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plastic, 1L), ItemList.IC2_Plantball.get(1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{10000, 5000, 5000}, 300, 5);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 2L), 0, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L), ItemList.TE_Slag.get(1L, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L)), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, 250);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Items.magma_cream, 1), 0, new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.slime_ball, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, 500);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{2000, 200}, 800, 320);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Plutonium241, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Technetium, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{2000, 3000, 1000}, 1600, 320);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.NaquadahEnriched, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Naquadria, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{5000, 1000}, 3200, 320);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadria, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Naquadah, 1L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{2000, 3000}, 6400, 640);
		GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, Materials.Hydrogen.getGas(160L), Materials.Deuterium.getGas(40L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 160, 20);
		GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, Materials.Deuterium.getGas(160L), Materials.Tritium.getGas(40L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 160, 80);
		GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, Materials.Helium.getGas(80L), Materials.Helium_3.getGas(5L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 160, 80);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Redstone, 2L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gold, 2L), GT_Values.NI, GT_Values.NI, GT_Values.NI, GT_Values.NI, null, 488, 80);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1L), GT_Values.NI, GT_Values.NF, Materials.Helium.getGas(120L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Platinum, 1L), new ItemStack(Blocks.sand, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{625, 625, 9000, 0, 0, 0}, 320, 20);
		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Netherrack, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Redstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Sulfur, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L), GT_Values.NI, GT_Values.NI, new int[]{5625, 9900, 5625, 625, 0, 0}, 160, 20);
		GT_Values.RA.addCentrifugeRecipe(new ItemStack(Blocks.soul_sand, 1), GT_Values.NI, GT_Values.NF, Materials.Oil.getFluid(80L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Saltpeter, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Coal, 1L), new ItemStack(Blocks.sand, 1), GT_Values.NI, GT_Values.NI, GT_Values.NI, new int[]{8000, 2000, 9000, 0, 0, 0}, 200, 80);
		GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, Materials.Lava.getFluid(100L), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Silver, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tantalum, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), new int[]{2000, 1000, 250, 250, 250, 125}, 80, 80);
		GT_Values.RA.addCentrifugeRecipe(GT_Values.NI, GT_Values.NI, FluidRegistry.getFluidStack("ic2pahoehoelava", 100), GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Silver, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tantalum, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), new int[]{2000, 1000, 250, 250, 250, 125}, 40, 80);

		GT_Values.RA.addCentrifugeRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1L), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neodymium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Yttrium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Lanthanum, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Cerium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Cadmium, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Caesium, 1L), new int[]{2500, 2500, 2500, 2500, 2500, 2500}, 64, 20);
		GT_Values.RA.addCentrifugeRecipe(GT_ModHandler.getModItem(GT_Values.MOD_ID_AE, "item.ItemMultiMaterial", 1L, 45), GT_Values.NI, GT_Values.NF, GT_Values.NF, GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.BasalticMineralSand, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Olivine, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Obsidian, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Basalt, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.RareEarth, 1L), new int[]{2000, 2000, 2000, 2000, 2000, 2000}, 64, 20);

		GT_Utility.removeSimpleIC2MachineRecipe(new ItemStack(Blocks.cobblestone), GT_ModHandler.getMaceratorRecipeList(), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L));
		GT_Utility.removeSimpleIC2MachineRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Lapis, 1L), GT_ModHandler.getMaceratorRecipeList(), ItemList.IC2_Plantball.get(1L));
		GT_Utility.removeSimpleIC2MachineRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L), GT_ModHandler.getMaceratorRecipeList(), ItemList.IC2_Plantball.get(1L));
		GT_Utility.removeSimpleIC2MachineRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L), GT_ModHandler.getMaceratorRecipeList(), ItemList.IC2_Plantball.get(1L));

		if (GregTech_API.sThaumcraftCompat != null) {
			String tKey = "GT_WOOD_TO_CHARCOAL";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way of making charcoal magically instead of using regular ovens for this purpose.<BR><BR>To create charcoal from wood you first need an air-free environment, some vacuus essentia is needed for that, then you need to incinerate the wood using ignis essentia and wait until all the water inside the wood is burned away.<BR><BR>This method however doesn't create creosote oil as byproduct.");

			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Charcoal Transmutation", "Turning wood into charcoal", new String[]{"ALUMENTUM"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Charcoal, 1L), 2, 0, 13, 5, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.ARBOR, 10L), new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 8L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 8L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.log.get(Materials.Wood), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Charcoal, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1L)))});

			tKey = "GT_FILL_WATER_BUCKET";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way of filling a bucket with aqua essentia in order to simply get water.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Water Transmutation", "Filling buckets with water", null, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.bucket, Materials.Water, 1L), 2, 0, 16, 5, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 4L), new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 4L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, GT_OreDictUnificator.get(OrePrefixes.bucket, Materials.Empty, 1L), GT_OreDictUnificator.get(OrePrefixes.bucket, Materials.Water, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, GT_OreDictUnificator.get(OrePrefixes.capsule, Materials.Empty, 1L), GT_OreDictUnificator.get(OrePrefixes.capsule, Materials.Water, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Empty, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 4L)))});

			tKey = "GT_TRANSZINC";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way to multiply zinc by steeping zinc nuggets in metallum harvested from other metals.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Zinc Transmutation", "Transformation of metals into zinc", new String[]{"TRANSTIN"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Zinc, 1L), 2, 1, 9, 13, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.SANO, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Zinc), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Zinc, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.SANO, 1L)))});

			tKey = "GT_TRANSANTIMONY";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way to multiply antimony by steeping antimony nuggets in metallum harvested from other metals.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Antimony Transmutation", "Transformation of metals into antimony", new String[]{"GT_TRANSZINC", "TRANSLEAD"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Antimony, 1L), 2, 1, 9, 14, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Antimony), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Antimony, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1L)))});

			tKey = "GT_TRANSNICKEL";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way to multiply nickel by steeping nickel nuggets in metallum harvested from other metals.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Nickel Transmutation", "Transformation of metals into nickel", new String[]{"TRANSLEAD"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Nickel, 1L), 2, 1, 9, 15, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Nickel), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Nickel, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1L)))});

			tKey = "GT_TRANSCOBALT";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way to multiply cobalt by steeping cobalt nuggets in metallum harvested from other metals.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Cobalt Transmutation", "Transformation of metals into cobalt", new String[]{"GT_TRANSNICKEL"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Cobalt, 1L), 2, 1, 9, 16, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Cobalt), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Cobalt, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1L)))});

			tKey = "GT_TRANSBISMUTH";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way to multiply bismuth by steeping bismuth nuggets in metallum harvested from other metals.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Bismuth Transmutation", "Transformation of metals into bismuth", new String[]{"GT_TRANSCOBALT"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Bismuth, 1L), 2, 1, 11, 17, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Bismuth), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Bismuth, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1L)))});

			tKey = "GT_IRON_TO_STEEL";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way of making Iron harder by just re-ordering its components.<BR><BR>This Method can be used to create a Material called Steel, which is used in many non-Thaumaturgic applications.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Steel Transmutation", "Transforming iron to steel", new String[]{"TRANSIRON", "GT_WOOD_TO_CHARCOAL"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 1L), 3, 0, 13, 8, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.ORDO, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Iron), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.ORDO, 1L)))});

			tKey = "GT_TRANSBRONZE";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way of creating Alloys using the already known transmutations of Copper and Tin.<BR><BR>This Method can be used to create a Bronze directly without having to go through an alloying process.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Bronze Transmutation", "Transformation of metals into bronze", new String[]{"TRANSTIN", "TRANSCOPPER"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Bronze, 1L), 2, 0, 13, 11, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Bronze), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Bronze, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1L)))});

			tKey = "GT_TRANSELECTRUM";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Your discovery of Bronze Transmutation has lead you to the conclusion it works with other Alloys such as Electrum as well.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Electrum Transmutation", "Transformation of metals into electrum", new String[]{"GT_TRANSBRONZE", "TRANSGOLD", "TRANSSILVER"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Electrum, 1L), 2, 1, 11, 11, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Electrum), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Electrum, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 1L)))});

			tKey = "GT_TRANSBRASS";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Your discovery of Bronze Transmutation has lead you to the conclusion it works with other Alloys such as Brass as well.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Brass Transmutation", "Transformation of metals into brass", new String[]{"GT_TRANSBRONZE", "GT_TRANSZINC"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Brass, 1L), 2, 1, 11, 12, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Brass), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Brass, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1L)))});

			tKey = "GT_TRANSINVAR";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Your discovery of Bronze Transmutation has lead you to the conclusion it works with other Alloys such as Invar as well.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Invar Transmutation", "Transformation of metals into invar", new String[]{"GT_TRANSBRONZE", "GT_TRANSNICKEL"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Invar, 1L), 2, 1, 11, 15, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.GELUM, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Invar), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Invar, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.GELUM, 1L)))});

			tKey = "GT_TRANSCUPRONICKEL";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Your discovery of Bronze Transmutation has lead you to the conclusion it works with other Alloys such as Cupronickel as well.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Cupronickel Transmutation", "Transformation of metals into cupronickel", new String[]{"GT_TRANSBRONZE", "GT_TRANSNICKEL"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Cupronickel, 1L), 2, 1, 11, 16, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Cupronickel), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Cupronickel, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 1L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1L)))});

			tKey = "GT_TRANSBATTERYALLOY";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Your discovery of Bronze Transmutation has lead you to the conclusion it works with other Alloys such as Battery Alloy as well.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Battery Alloy Transmutation", "Transformation of metals into battery alloy", new String[]{"GT_TRANSBRONZE", "GT_TRANSANTIMONY"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.BatteryAlloy, 1L), 2, 1, 11, 13, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.BatteryAlloy), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.BatteryAlloy, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1L), new TC_Aspects.TC_AspectStack(TC_Aspects.ORDO, 1L)))});

			tKey = "GT_TRANSSOLDERINGALLOY";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Your discovery of Bronze Transmutation has lead you to the conclusion it works with other Alloys such as Soldering Alloy as well.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Soldering Alloy Transmutation", "Transformation of metals into soldering alloy", new String[]{"GT_TRANSBRONZE", "GT_TRANSANTIMONY"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.SolderingAlloy, 1L), 2, 1, 11, 14, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.SolderingAlloy), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.SolderingAlloy, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1L), new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1L)))});

			tKey = "GT_ADVANCEDMETALLURGY";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Now that you have discovered all the basic metals, you can finally move on to the next Level of magic metallurgy and create more advanced metals");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Advanced Metallurgic Transmutation", "Mastering the basic metals", new String[]{"GT_TRANSBISMUTH", "GT_IRON_TO_STEEL", "GT_TRANSSOLDERINGALLOY", "GT_TRANSBATTERYALLOY", "GT_TRANSBRASS", "GT_TRANSELECTRUM", "GT_TRANSCUPRONICKEL", "GT_TRANSINVAR"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L), 3, 0, 16, 14, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 50L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 20L), new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 20L), new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 20L), new TC_Aspects.TC_AspectStack(TC_Aspects.NEBRISUM, 20L), new TC_Aspects.TC_AspectStack(TC_Aspects.MAGNETO, 20L)), null, new Object[]{"gt.research.page.1." + tKey});

			tKey = "GT_TRANSALUMINIUM";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "You have discovered a way to multiply aluminium by steeping aluminium nuggets in metallum harvested from other metals.<BR><BR>This transmutation is slightly harder to achieve, because aluminium has special properties, which require more order to achieve the desired result.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Aluminium Transmutation", "Transformation of metals into aluminium", new String[]{"GT_ADVANCEDMETALLURGY"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 1L), 4, 0, 19, 14, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.VOLATUS, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.ORDO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.nugget.get(Materials.Aluminium), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Aluminium, 3L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.VOLATUS, 1L), new TC_Aspects.TC_AspectStack(TC_Aspects.ORDO, 1L), new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1L)))});

			tKey = "GT_CRYSTALLISATION";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey, "Sometimes when processing your Crystal Shards they become a pile of Dust instead of the mostly required Shard.<BR><BR>You have finally found a way to reverse this Process by using Vitreus Essentia for recrystallising the Shards.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey, "Shard Recrystallisation", "Fixing your precious crystals", new String[]{"ALCHEMICALMANUFACTURE"}, "ALCHEMY", GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedOrder, 1L), 3, 0, -11, -3, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 5L), new TC_Aspects.TC_AspectStack(TC_Aspects.PERMUTATIO, 3L), new TC_Aspects.TC_AspectStack(TC_Aspects.ORDO, 3L)), null, new Object[]{"gt.research.page.1." + tKey, GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.Amber), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Amber, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.InfusedOrder), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedOrder, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.InfusedEntropy), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedEntropy, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.InfusedAir), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedAir, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.InfusedEarth), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedEarth, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.InfusedFire), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedFire, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L))), GregTech_API.sThaumcraftCompat.addCrucibleRecipe(tKey, OrePrefixes.dust.get(Materials.InfusedWater), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.InfusedWater, 1L), Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 4L)))});

			tKey = "GT_MAGICENERGY";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey,
					"While trying to find new ways to integrate magic into your industrial factories, you have discovered a way to convert magical energy into electrical power.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey,
					"Magic Energy Conversion",
					"Magic to Power",
					new String[]{"ARCANEBORE"},
					"ARTIFICE",
					ItemList.MagicEnergyConverter_LV.get(1L),
					3, 0, -3, 10,
					Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 20L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 10L)),
							null, new Object[]{"gt.research.page.1." + tKey,
				GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
						ItemList.Hull_LV.get(1L),
						new ItemStack[]{
					new ItemStack(Blocks.beacon),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
					ItemList.Sensor_MV.get(2L),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
					ItemList.Sensor_MV.get(2L)
				},
				ItemList.MagicEnergyConverter_LV.get(1L),
				5,
				Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 32L)))});

			tKey = "GT_MAGICENERGY2";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey,
					"Attempts to increase the output of your Magic Energy generators have resulted in significant improvements.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey,
					"Adept Magic Energy Conversion",
					"Magic to Power",
					new String[]{"GT_MAGICENERGY"},
					"ARTIFICE",
					ItemList.MagicEnergyConverter_MV.get(1L),
					1, 1, -4, 12,
					Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 20L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 10L)),
							null, new Object[]{"gt.research.page.1." + tKey,
				GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
						ItemList.Hull_MV.get(1L),
						new ItemStack[]{
					new ItemStack(Blocks.beacon),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
					ItemList.Sensor_HV.get(2L),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1L),
					ItemList.Sensor_HV.get(2L)
				},
				ItemList.MagicEnergyConverter_MV.get(1L),
				6,
				Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 64L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 64L)))});

			tKey = "GT_MAGICENERGY3";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey,
					"Attempts to further increase the output of your Magic Energy generators have resulted in great improvements.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey,
					"Master Magic Energy Conversion",
					"Magic to Power",
					new String[]{"GT_MAGICENERGY2"},
					"ARTIFICE",
					ItemList.MagicEnergyConverter_HV.get(1L),
					1, 1, -4, 14,
					Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 20L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 20L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 40L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 20L)),
							null, new Object[]{"gt.research.page.1." + tKey,
				GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
						ItemList.Hull_HV.get(1L),
						new ItemStack[]{
					new ItemStack(Blocks.beacon),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Thaumium, 1L),
					ItemList.Field_Generator_MV.get(1L),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Europium, 1L),
					ItemList.Field_Generator_MV.get(1L)
				},
				ItemList.MagicEnergyConverter_HV.get(1L),
				8,
				Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 128L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 64L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 128L)))});


			tKey = "GT_MAGICABSORB";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey,
					"Research into magical energy conversion methods has identified a way to convert surrounding energies into electrical power.");
			GregTech_API.sThaumcraftCompat.addResearch(tKey,
					"Magic Energy Absorption",
					"Harvesting Magic",
					new String[]{"GT_MAGICENERGY"},
					"ARTIFICE",
					ItemList.MagicEnergyAbsorber_LV.get(1L),
					3, 0, -2, 12,
					Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 20L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 10L)),
							null, new Object[]{"gt.research.page.1." + tKey,
				GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
						ItemList.Hull_LV.get(1L),
						new ItemStack[]{
					ItemList.MagicEnergyConverter_LV.get(1L),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
					ItemList.Sensor_MV.get(2L)
				},
				ItemList.MagicEnergyAbsorber_LV.get(1L),
				6,
				Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 16L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 16L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.STRONTIO, 4L)))});

			tKey = "GT_MAGICABSORB2";
			GT_LanguageManager.addStringLocalization("gt.research.page.1." + tKey,
					"Moar output! Drain all the Magic!");
			GregTech_API.sThaumcraftCompat.addResearch(tKey,
					"Improved Magic Energy Absorption",
					"Harvesting Magic",
					new String[]{"GT_MAGICABSORB"},
					"ARTIFICE",
					ItemList.MagicEnergyAbsorber_EV.get(1L),
					3, 1, -2, 14,
					Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 10L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 20L),
							new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 10L)),
							null, new Object[]{"gt.research.page.1." + tKey,
				GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
						ItemList.Hull_MV.get(1L),
						new ItemStack[]{
					ItemList.MagicEnergyConverter_MV.get(1L),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
					ItemList.Sensor_HV.get(2L),
					GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
					GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L)
				},
				ItemList.MagicEnergyAbsorber_MV.get(1L),
				6,
				Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 64L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 64L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 32L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 64L),
						new TC_Aspects.TC_AspectStack(TC_Aspects.STRONTIO, 8L)))


						, GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
								ItemList.Hull_HV.get(1L),
								new ItemStack[]{
							ItemList.MagicEnergyConverter_MV.get(1L),
							GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
							GT_ModHandler.getModItem(GT_Values.MOD_ID_TC, "ItemResource", 1, 16),
							ItemList.Field_Generator_MV.get(1L),
							GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
							GT_ModHandler.getModItem(GT_Values.MOD_ID_TC, "ItemResource", 1, 16)
						},
						ItemList.MagicEnergyAbsorber_HV.get(1L),
						8,
						Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 128L),
								new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 64L),
								new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 128L),
								new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 64L),
								new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 128L),
								new TC_Aspects.TC_AspectStack(TC_Aspects.STRONTIO, 16L)))


								, GregTech_API.sThaumcraftCompat.addInfusionRecipe(tKey,
										ItemList.Hull_EV.get(1L),
										new ItemStack[]{
									ItemList.MagicEnergyConverter_HV.get(1L),
									GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1L),
									GT_ModHandler.getModItem(GT_Values.MOD_ID_TC, "ItemResource", 1, 16),
									ItemList.Field_Generator_HV.get(1L),
									GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 1L),
									GT_ModHandler.getModItem(GT_Values.MOD_ID_TC, "ItemResource", 1, 16)
								},
								ItemList.MagicEnergyAbsorber_EV.get(1L),
								10,
								Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 256L),
										new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 128L),
										new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 256L),
										new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 128L),
										new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 256L),
										new TC_Aspects.TC_AspectStack(TC_Aspects.STRONTIO, 64L)))
			});

		}
		for (MaterialStack[] tMats : this.mAlloySmelterList) {
			ItemStack tDust1 = GT_OreDictUnificator.get(OrePrefixes.dust, tMats[0].mMaterial, tMats[0].mAmount);
			ItemStack tDust2 = GT_OreDictUnificator.get(OrePrefixes.dust, tMats[1].mMaterial, tMats[1].mAmount);
			ItemStack tIngot1 = GT_OreDictUnificator.get(OrePrefixes.ingot, tMats[0].mMaterial, tMats[0].mAmount);
			ItemStack tIngot2 = GT_OreDictUnificator.get(OrePrefixes.ingot, tMats[1].mMaterial, tMats[1].mAmount);
			ItemStack tOutputIngot = GT_OreDictUnificator.get(OrePrefixes.ingot, tMats[2].mMaterial, tMats[2].mAmount);
			if (tOutputIngot != GT_Values.NI) {
				GT_ModHandler.addAlloySmelterRecipe(tIngot1, tDust2, tOutputIngot, (int) tMats[2].mAmount * 50, 16, false);
				GT_ModHandler.addAlloySmelterRecipe(tIngot1, tIngot2, tOutputIngot, (int) tMats[2].mAmount * 50, 16, false);
				GT_ModHandler.addAlloySmelterRecipe(tDust1, tIngot2, tOutputIngot, (int) tMats[2].mAmount * 50, 16, false);
				GT_ModHandler.addAlloySmelterRecipe(tDust1, tDust2, tOutputIngot, (int) tMats[2].mAmount * 50, 16, false);
			}
		}

		//Nope - Gotta refine
		/*try {
			Map<String, BurnProperty> tLiqExchange = ic2.api.recipe.Recipes.FluidHeatGenerator.getBurnProperties();
			Iterator<Map.Entry<String, BurnProperty>> tIterator = tLiqExchange.entrySet().iterator();
			while (tIterator.hasNext()) {
				Map.Entry<String, BurnProperty> tEntry = tIterator.next();
				if(tEntry.getKey().equals("ic2hotcoolant")){
					tIterator.remove();
					Recipes.FluidHeatGenerator.addFluid("ic2hotcoolant", 80, 80);
				}
			}
		} catch (Throwable e) {Do nothing}

		try {
			Map<String, BurnProperty> tLiqExchange = ic2.api.recipe.Recipes.FluidHeatGenerator.getBurnProperties();
			Iterator<Map.Entry<String, BurnProperty>> tIterator = tLiqExchange.entrySet().iterator();
			while (tIterator.hasNext()) {
				Map.Entry<String, BurnProperty> tEntry = tIterator.next();
				if(tEntry.getKey().equals("ic2coolant")){
					tIterator.remove();
					Recipes.FluidHeatGenerator.addFluid("ic2coolant", 80, 80);
				}
			}
		} catch (Throwable e) {Do nothing}*/

	}
}
