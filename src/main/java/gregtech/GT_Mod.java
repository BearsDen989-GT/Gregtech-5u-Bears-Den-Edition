package gregtech;

import forestry.api.recipes.ICentrifugeRecipe;
import forestry.api.recipes.ISqueezerRecipe;
import forestry.api.recipes.RecipeManagers;
import gregtech.api.GregTech_API;
import gregtech.api.enchants.Enchantment_EnderDamage;
import gregtech.api.enchants.Enchantment_Radioactivity;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.Element;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.internal.IGT_Mod;
import gregtech.api.objects.GT_ItemStack;
import gregtech.api.objects.ItemData;
import gregtech.api.util.EX_MaterialUtils;
import gregtech.api.util.GT_Config;
import gregtech.api.util.GT_ItsNotMyFaultException;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_SpawnEventHandler;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_DummyWorld;
import gregtech.common.GT_Network;
import gregtech.common.GT_Proxy;
import gregtech.common.GT_RecipeAdder;
import gregtech.common.entities.GT_Entity_Arrow;
import gregtech.common.entities.GT_Entity_Arrow_Potion;
import gregtech.common.items.behaviors.Behaviour_DataOrb;
import gregtech.loaders.load.GT_CoverBehaviorLoader;
import gregtech.loaders.load.GT_FuelLoader;
import gregtech.loaders.load.GT_ItemIterator;
import gregtech.loaders.load.GT_SonictronLoader;
import gregtech.loaders.misc.GT_Achievements;
import gregtech.loaders.misc.GT_CoverLoader;
import gregtech.loaders.postload.EX_MachineRecipeLoader;
import gregtech.loaders.postload.GT_BlockResistanceLoader;
import gregtech.loaders.postload.GT_BookAndLootLoader;
import gregtech.loaders.postload.GT_CraftingRecipeLoader;
import gregtech.loaders.postload.GT_CropLoader;
import gregtech.loaders.postload.GT_ItemMaxStacksizeLoader;
import gregtech.loaders.postload.GT_MachineRecipeLoader;
import gregtech.loaders.postload.GT_MinableRegistrator;
import gregtech.loaders.postload.GT_RecyclerBlacklistLoader;
import gregtech.loaders.postload.GT_ScrapboxDropLoader;
import gregtech.loaders.postload.GT_Worldgenloader;
import gregtech.loaders.preload.GT_Loader_CircuitBehaviors;
import gregtech.loaders.preload.GT_Loader_ItemData;
import gregtech.loaders.preload.GT_Loader_Item_Block_And_Fluid;
import gregtech.loaders.preload.GT_Loader_MetaTileEntities;
import gregtech.loaders.preload.GT_Loader_OreDictionary;
import gregtech.loaders.preload.GT_Loader_OreProcessing;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.Map.Entry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLModIdMappingEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = "gregtech", name = "GregTech", version = "MC1710", useMetadata = false, dependencies = "required-after:IC2; after:Forestry; after:PFAAGeologica; after:Thaumcraft; after:Railcraft; after:appliedenergistics2; after:ThermalExpansion; after:TwilightForest; after:harvestcraft; after:magicalcrops; after:BuildCraft|Transport; after:BuildCraft|Silicon; after:BuildCraft|Factory; after:BuildCraft|Energy; after:BuildCraft|Core; after:BuildCraft|Builders; after:GalacticraftCore; after:GalacticraftMars; after:GalacticraftPlanets; after:ThermalExpansion|Transport; after:ThermalExpansion|Energy; after:ThermalExpansion|Factory; after:RedPowerCore; after:RedPowerBase; after:RedPowerMachine; after:RedPowerCompat; after:RedPowerWiring; after:RedPowerLogic; after:RedPowerLighting; after:RedPowerWorld; after:RedPowerControl;")
public class GT_Mod
implements IGT_Mod {
	public static final int VERSION = 558;
	public static final int REQUIRED_IC2 = 624;
	@Mod.Instance("gregtech")
	public static GT_Mod instance;
	@SidedProxy(modId = "gregtech", clientSide = "gregtech.common.GT_Client", serverSide = "gregtech.common.GT_Server")
	public static GT_Proxy gregtechproxy;
	public static int MAX_IC2 = 2147483647;
	public static GT_Achievements achievements;

	static {
		if ((508 != GregTech_API.VERSION) || (508 != GT_ModHandler.VERSION) || (508 != GT_OreDictUnificator.VERSION) || (508 != GT_Recipe.VERSION) || (508 != GT_Utility.VERSION) || (508 != GT_RecipeRegistrator.VERSION) || (508 != Element.VERSION) || (508 != Materials.VERSION) || (508 != OrePrefixes.VERSION)) {
			throw new GT_ItsNotMyFaultException("One of your Mods included GregTech-API Files inside it's download, mention this to the Mod Author, who does this bad thing, and tell him/her to use reflection. I have added a Version check, to prevent Authors from breaking my Mod that way.");
		}
	}

	public GT_Mod() {
		try {
			Class.forName("ic2.core.IC2").getField("enableOreDictCircuit").set(null, Boolean.TRUE);
		} catch (Throwable e) {
		}
		try {
			Class.forName("ic2.core.IC2").getField("enableCraftingBucket").set(null, Boolean.FALSE);
		} catch (Throwable e) {
		}
		try {
			Class.forName("ic2.core.IC2").getField("enableEnergyInStorageBlockItems").set(null, Boolean.FALSE);
		} catch (Throwable e) {
		}
		GT_Values.GT = this;
		GT_Values.DW = new GT_DummyWorld();
		GT_Values.NW = new GT_Network();
		GregTech_API.sRecipeAdder = GT_Values.RA = new GT_RecipeAdder();

		Textures.BlockIcons.VOID.name();
		Textures.ItemIcons.VOID.name();
	}

	@Mod.EventHandler
	public void onPreLoad(FMLPreInitializationEvent aEvent) {
		EX_MaterialUtils.checkFreeIDs();
		if (GregTech_API.sPreloadStarted) {
			return;
		}
		for (Runnable tRunnable : GregTech_API.sBeforeGTPreload) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}

        GregTech_API.sConfigFileIDs = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "IDs.cfg")));
        for (ConfigCategories.IDs tCategory : ConfigCategories.IDs.values()) {
            GregTech_API.sConfigFileIDs.setCathegoryComment(tCategory.toString(), tCategory.getComment());
        }

		GregTech_API.sMainConfig = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "GregTech.cfg")));
        for (ConfigCategories.Main tCategory : ConfigCategories.Main.values()) {
            GregTech_API.sMainConfig.setCathegoryComment(tCategory.toString(), tCategory.getComment());
        }

        GregTech_API.sRecipeFile = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "Recipes.cfg")));
        for (ConfigCategories.Recipes tCategory : ConfigCategories.Recipes.values()) {
            GregTech_API.sRecipeFile.setCathegoryComment(tCategory.toString(), tCategory.getComment());
        }

		GregTech_API.sMachineFile = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "MachineStats.cfg")));
        GregTech_API.sMachineFile.setCathegoryComment(ConfigCategories.machineconfig.toString(), ConfigCategories.machineconfig.getComment());

		GregTech_API.sWorldgenFile = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "WorldGeneration.cfg")));
		GregTech_API.sMaterialProperties = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "MaterialProperties.cfg")));
		GregTech_API.sUnification = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "Unification.cfg")));
		GregTech_API.sSpecialFile = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "Other.cfg")));
		GregTech_API.sOPStuff = new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "OverpoweredStuff.cfg")));

		GregTech_API.sClientDataFile =  new GT_Config(new Configuration(new File(new File(aEvent.getModConfigurationDirectory(), "GregTech"), "Client.cfg")));
        for (ConfigCategories.Client tCategory : ConfigCategories.Client.values()) {
            GregTech_API.sClientDataFile.setCathegoryComment(tCategory.toString(), tCategory.getComment());
        }

        GregTech_API.mGalacticraft = Loader.isModLoaded("GalacticraftCore");

		GT_Log.mLogFile = new File(aEvent.getModConfigurationDirectory().getParentFile(), "logs/GregTech.log");
		if (!GT_Log.mLogFile.exists()) {
            try {
                if (!GT_Log.mLogFile.createNewFile()) throw new IOException("Cannot create GregTech.log");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            GT_Log.out = GT_Log.err = new PrintStream(GT_Log.mLogFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GT_Log.mOreDictLogFile = new File(aEvent.getModConfigurationDirectory().getParentFile(), "logs/OreDict.log");
		if (!GT_Log.mOreDictLogFile.exists()) {
            try {
                if (!GT_Log.mOreDictLogFile.createNewFile()) throw new IOException("Cannot create OreDict.log");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		if (GregTech_API.sMainConfig.get("general", "LoggingPlayerActivity", true)) {
			GT_Log.mPlayerActivityLogFile = new File(aEvent.getModConfigurationDirectory().getParentFile(), "logs/PlayerActivity.log");
			if (!GT_Log.mPlayerActivityLogFile.exists()) {
                try {
                    if (!GT_Log.mPlayerActivityLogFile.createNewFile()) throw new IOException("Cannot create PlayerActivity.log");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                GT_Log.pal = new PrintStream(GT_Log.mPlayerActivityLogFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            List<String> tList = ((GT_Log.LogBuffer) GT_Log.ore).mBufferedOreDictLog;
            GT_Log.ore.println("******************************************************************************");
            GT_Log.ore.println("* This is the complete log of the GT5-Unofficial OreDictionary Handler. It   *");
            GT_Log.ore.println("* processes all OreDictionary entries and can sometimes cause errors. All    *");
            GT_Log.ore.println("* entries and errors are being logged. If you see an error please raise an   *");
            GT_Log.ore.println("* issue at https://github.com/Blood-Asp/GT5-Unofficial.                      *");
            GT_Log.ore.println("******************************************************************************");
            for (String tString : tList) {
                GT_Log.ore.println(tString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        gregtechproxy.onPreLoad();

		GT_Log.out.println("GT_Mod: Setting Configs");
		GT_Values.D1 = GregTech_API.sMainConfig.get("general", "Debug", false);
		GT_Values.D2 = GregTech_API.sMainConfig.get("general", "Debug2", false);

		GregTech_API.TICKS_FOR_LAG_AVERAGING = GregTech_API.sMainConfig.get("general", "TicksForLagAveragingWithScanner", 25);
		GregTech_API.MILLISECOND_THRESHOLD_UNTIL_LAG_WARNING = GregTech_API.sMainConfig.get("general", "MillisecondsPassedInGTTileEntityUntilLagWarning", 100);
		if (GregTech_API.sMainConfig.get("general", "disable_STDOUT", false)) {
			System.out.close();
		}
		if (GregTech_API.sMainConfig.get("general", "disable_STDERR", false)) {
			System.err.close();
		}
		GregTech_API.sMachineExplosions = GregTech_API.sMainConfig.get("machines", "machines_explosion_damage", true, "Shall machines causes damages on explosion?");
		GregTech_API.sMachineFlammable = GregTech_API.sMainConfig.get("machines", "machines_flammable", true, "Shall machines be flammable?");
		GregTech_API.sMachineNonWrenchExplosions = GregTech_API.sMainConfig.get("machines", "explosions_on_nonwrenching", true, "Shall machines explode if not properly removed with a Wrench?");
		GregTech_API.sMachineWireFire = GregTech_API.sMainConfig.get("machines", "wirefire_on_explosion", true, "Shall machines explosions ignite connected Cables/Wires?");
		GregTech_API.sMachineFireExplosions = GregTech_API.sMainConfig.get("machines", "fire_causes_explosions", true, "Shall fire cause machines to explode?");
		GregTech_API.sMachineRainExplosions = GregTech_API.sMainConfig.get("machines", "rain_causes_explosions", true, "Shall machines explode when exposed to rain/storms?");
		GregTech_API.sMachineThunderExplosions = GregTech_API.sMainConfig.get("machines", "lightning_causes_explosions", true, "Shall machines explode when exposed to lightning-strikes?");
		GregTech_API.sConstantEnergy = GregTech_API.sMainConfig.get("machines", "constant_need_of_energy", true, "Shall machines discard processed input when not enough energy?");
		GregTech_API.sColoredGUI = GregTech_API.sMainConfig.get("machines", "colored_guis_when_painted", true, "Shall GUI be colored when machine is painted?");

		GregTech_API.sTimber = GregTech_API.sMainConfig.get("general", "timber_axe", true, "Enable chopping of whole connected logs column");
		GregTech_API.sDrinksAlwaysDrinkable = GregTech_API.sMainConfig.get("general", "drinks_always_drinkable", false, "Shall all drinks be drinkable?");
		GregTech_API.sDoShowAllItemsInCreative = GregTech_API.sMainConfig.get("general", "show_all_metaitems_in_creative_and_NEI", false, "Make all meta-items visible in NEI");
		GregTech_API.sMultiThreadedSounds = false; // Need Fix: GregTech_API.sMainConfig.get("general", "sound_multi_threading", false, "Enable multi-threading sounds");
		for (Dyes tDye : Dyes.values()) {
			if ((tDye != Dyes._NULL) && (tDye.mIndex < 0)) {
                GregTech_API.sClientDataFile.setCathegoryComment(String.format("ColorModulation.%s", tDye), ConfigCategories.Client.ColorModulation.valueOf(tDye.toString()).getComment());
                tDye.mRGBa[0] = ((short) Math.min(255, Math.max(0, GregTech_API.sClientDataFile.get(String.format("ColorModulation.%s", tDye), "R", tDye.mRGBa[0], "Red Byte (0-255)"))));
                tDye.mRGBa[1] = ((short) Math.min(255, Math.max(0, GregTech_API.sClientDataFile.get(String.format("ColorModulation.%s", tDye), "G", tDye.mRGBa[0], "Green Byte (0-255)"))));
                tDye.mRGBa[2] = ((short) Math.min(255, Math.max(0, GregTech_API.sClientDataFile.get(String.format("ColorModulation.%s", tDye), "B", tDye.mRGBa[0], "Blue Byte (0-255)"))));
			}
		}
		gregtechproxy.mMaxEqualEntitiesAtOneSpot = GregTech_API.sMainConfig.get("general", "MaxEqualEntitiesAtOneSpot", 3, "Max number of allowed Living Entities in one block location");
		gregtechproxy.mSkeletonsShootGTArrows = GregTech_API.sMainConfig.get("general", "SkeletonsShootGTArrows", 16, "Percent chance a Skeleton shoots a GregTech Arrow?");
		gregtechproxy.mFlintChance = GregTech_API.sMainConfig.get("general", "FlintAndSteelChance", 30, "Percent chance for a Flint-and-steel to ignite");
		gregtechproxy.mItemDespawnTime = GregTech_API.sMainConfig.get("general", "ItemDespawnTime", 6000, "Ticks before an item despawns");
		gregtechproxy.mDisableVanillaOres = GregTech_API.sMainConfig.get("general", "DisableVanillaOres", true, "Disable Vanilla ores generation");
		gregtechproxy.mNerfDustCrafting = GregTech_API.sMainConfig.get("general", "NerfDustCrafting", true, "Disable dust alloying/merging in workbench");
		gregtechproxy.mIncreaseDungeonLoot = GregTech_API.sMainConfig.get("general", "IncreaseDungeonLoot", true, "Increase Dungeon loot");
		gregtechproxy.mAxeWhenAdventure = GregTech_API.sMainConfig.get("general", "AdventureModeStartingAxe", true, "Give player a starting axe in Adventure mode");
		gregtechproxy.mHardcoreCables = GregTech_API.sMainConfig.get("general", "HardCoreCableLoss", false, "Doubles EU Loss in cables/wires/machines connections");
		gregtechproxy.mSurvivalIntoAdventure = GregTech_API.sMainConfig.get("general", "forceAdventureMode", false, "Force Adventure mode");
		gregtechproxy.mHungerEffect = GregTech_API.sMainConfig.get("general", "AFK_Hunger", false, "Shall players consumes food when AFK?");
		gregtechproxy.mHardRock = GregTech_API.sMainConfig.get("general", "harderstone", false, "Shall Stone be harder to mine?");
		gregtechproxy.mInventoryUnification = GregTech_API.sMainConfig.get("general", "InventoryUnification", true, "Shall items be unified within player inventory?");
		gregtechproxy.mCraftingUnification = GregTech_API.sMainConfig.get("general", "CraftingUnification", true, "Shall items be unified upon crafting?");
		gregtechproxy.mNerfedWoodPlank = GregTech_API.sMainConfig.get("general", "WoodNeedsSawForCrafting", true, "Shall crafting wood requires a saw?");
		gregtechproxy.mNerfedVanillaTools = GregTech_API.sMainConfig.get("general", "smallerVanillaToolDurability", true, "Reduce Vanilla tools durability");
		gregtechproxy.mSortToTheEnd = GregTech_API.sMainConfig.get("general", "EnsureToBeLoadedLast", true, "Force GregTech mod to be loaded last (avoid some initialization bugs)");
		gregtechproxy.mDisableIC2Cables = GregTech_API.sMainConfig.get("general", "DisableIC2Cables", false, "Disable Industrial Craft2 cables");
		gregtechproxy.mAchievements = GregTech_API.sMainConfig.get("general", "EnableAchievements", true, "Enable GregTech achievements");
		gregtechproxy.mAE2Integration = GregTech_API.sMainConfig.get("general", "EnableAE2Integration", Loader.isModLoaded("appliedenergistics2"), "Enable integration with Applied Energistics 2");
		gregtechproxy.gt6Pipe = GregTech_API.sMainConfig.get("general", "GT6StyledPipesConnection", true, "Enable GregTech6's way of connecting pipes");
		gregtechproxy.gt6Cable = GregTech_API.sMainConfig.get("general", "GT6StyledWiresConnection", true, "Enable GregTech6's way of connecting cables/wires");
		gregtechproxy.ic2EnergySourceCompat = GregTech_API.sMainConfig.get("general", "Ic2EnergySourceCompat", true, "Enable compatibility with Industrial Craft 2 EU sources");

		GregTech_API.mOutputRF = GregTech_API.sOPStuff.get(ConfigCategories.Main.general, "OutputRF", true, "Allow GregTech to power RF machines");
		GregTech_API.mInputRF = GregTech_API.sOPStuff.get(ConfigCategories.Main.general, "InputRF", false, "Allow RF to power GregTech machines");
		GregTech_API.mEUtoRF = GregTech_API.sOPStuff.get(ConfigCategories.Main.general, "100EUtoRF", 360, "How much RF is produced from 100 EU");
		GregTech_API.mRFtoEU = GregTech_API.sOPStuff.get(ConfigCategories.Main.general, "100RFtoEU", 20, "How much EU is produced from 100 RF");
		GregTech_API.mRFExplosions = GregTech_API.sOPStuff.get(ConfigCategories.Main.general, "RFExplosions", true, "Shall machines explode on receiving too much RF?");
		GregTech_API.meIOLoaded = Loader.isModLoaded("EnderIO");


		if (GregTech_API.sMainConfig.get("general", "hardermobspawners", true, "Make Mob Spawners much harder to break (Hardness 6M Vs. 500)")) {
			Blocks.mob_spawner.setHardness(500.0F).setResistance(6000000.0F);
		}
		gregtechproxy.mOnline = GregTech_API.sMainConfig.get("general", "online", true);

		gregtechproxy.mUpgradeCount = Math.min(64, Math.max(1, GregTech_API.sMainConfig.get("features", "UpgradeStacksize", 4)));
		for (OrePrefixes tPrefix : OrePrefixes.values()) {
			if (tPrefix.mIsUsedForOreProcessing) {
				tPrefix.mDefaultStackSize = ((byte) Math.min(64, Math.max(1, GregTech_API.sMainConfig.get("features", "MaxOreStackSize", 64))));
			} else if (tPrefix == OrePrefixes.plank) {
				tPrefix.mDefaultStackSize = ((byte) Math.min(64, Math.max(16, GregTech_API.sMainConfig.get("features", "MaxPlankStackSize", 64))));
			} else if ((tPrefix == OrePrefixes.wood) || (tPrefix == OrePrefixes.treeLeaves) || (tPrefix == OrePrefixes.treeSapling) || (tPrefix == OrePrefixes.log)) {
				tPrefix.mDefaultStackSize = ((byte) Math.min(64, Math.max(16, GregTech_API.sMainConfig.get("features", "MaxLogStackSize", 64))));
			} else if (tPrefix.mIsUsedForBlocks) {
				tPrefix.mDefaultStackSize = ((byte) Math.min(64, Math.max(16, GregTech_API.sMainConfig.get("features", "MaxOtherBlockStackSize", 64))));
			}
		}
		//GT_Config.troll = (Calendar.getInstance().get(2) + 1 == 4) && (Calendar.getInstance().get(5) >= 1) && (Calendar.getInstance().get(5) <= 2);

		Materials.init(GregTech_API.sMaterialProperties);

		GT_Log.out.println("GT_Mod: Generating Lang-File");
		GT_LanguageManager.sEnglishFile = new Configuration(new File(aEvent.getModConfigurationDirectory().getParentFile(), "GregTech.lang"));
		GT_LanguageManager.sEnglishFile.load();

		GT_Log.out.println("GT_Mod: Removing all original Scrapbox Drops.");
		try {
			Objects.requireNonNull(GT_Utility.getField("ic2.core.item.ItemScrapbox$Drop", "topChance", true, true)).set(null, 0);
			((List) Objects.requireNonNull(GT_Utility.getFieldContent(GT_Utility.getFieldContent("ic2.api.recipe.Recipes", "scrapboxDrops", true, true), "drops", true, true))).clear();
		} catch (Throwable e) {
			if (GT_Values.D1) {
				e.printStackTrace(GT_Log.err);
			}
		}
		GT_Log.out.println("GT_Mod: Adding Scrap with a Weight of 200.0F to the Scrapbox Drops.");
		GT_ModHandler.addScrapboxDrop(200.0F, GT_ModHandler.getIC2Item("scrap", 1L));

		EntityRegistry.registerModEntity(GT_Entity_Arrow.class, "GT_Entity_Arrow", 1, GT_Values.GT, 160, 1, true);
		EntityRegistry.registerModEntity(GT_Entity_Arrow_Potion.class, "GT_Entity_Arrow_Potion", 2, GT_Values.GT, 160, 1, true);

		new Enchantment_EnderDamage();
		new Enchantment_Radioactivity();

		new GT_Loader_OreProcessing().run();
		new GT_Loader_OreDictionary().run();
		new GT_Loader_ItemData().run();
		new GT_Loader_Item_Block_And_Fluid().run();
		new GT_Loader_MetaTileEntities().run();

		new GT_Loader_CircuitBehaviors().run();
		new GT_CoverBehaviorLoader().run();
		new GT_SonictronLoader().run();
		new GT_SpawnEventHandler();
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanel", true, "Enable GregTech's Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SGS", "CPC", 'C', OrePrefixes.circuit.get(Materials.Basic), 'G', new ItemStack(Blocks.glass_pane, 1), 'P', OrePrefixes.plateAlloy.get(Materials.Carbon), 'S', OrePrefixes.plate.get(Materials.Silicon)});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanel8V", false, "Enable ULV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_8V.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"SSS", "STS", "SSS", 'S', ItemList.Cover_SolarPanel, 'T', OrePrefixes.circuit.get(Materials.Advanced)});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelLV", false, "Enable LV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_LV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_8V, 'T', ItemList.Transformer_LV_ULV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelMV", false, "Enable MV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_MV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_LV, 'T', ItemList.Transformer_MV_LV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelHV", false, "Enable HV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_HV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_MV, 'T', ItemList.Transformer_HV_MV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelEV", false, "Enable EV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_EV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_HV, 'T', ItemList.Transformer_EV_HV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelIV", false, "Enable IV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_IV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_EV, 'T', ItemList.Transformer_IV_EV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelLuV", false, "Enable LuV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_LuV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_IV, 'T', ItemList.Transformer_LuV_IV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelZPM", false, "Enable ZPM Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_ZPM.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_LuV, 'T', ItemList.Transformer_ZPM_LuV});
		}
		if (GregTech_API.sOPStuff.get(ConfigCategories.Recipes.gregtechrecipes, "SolarPanelUV", false, "Enable lUV Solar Panels")) {
			GT_ModHandler.addCraftingRecipe(ItemList.Cover_SolarPanel_UV.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{" S ", "STS", " S ", 'S', ItemList.Cover_SolarPanel_ZPM, 'T', ItemList.Transformer_UV_ZPM});
		}
		if (gregtechproxy.mSortToTheEnd) {
			try {
				GT_Log.out.println("GT_Mod: Sorting GregTech to the end of the Mod List for further processing.");
				LoadController tLoadController = (LoadController) GT_Utility.getFieldContent(Loader.instance(), "modController", true, true);
                assert tLoadController != null;
                List<ModContainer> tModList = tLoadController.getActiveModList();
				List<ModContainer> tNewModsList = new ArrayList<>();
				ModContainer tGregTech = null;
				for (short i = 0; i < tModList.size(); i = (short) (i + 1)) {
					ModContainer tMod = tModList.get(i);
					if (tMod.getModId().equalsIgnoreCase("gregtech")) {
						tGregTech = tMod;
					} else {
						tNewModsList.add(tMod);
					}
				}
				if (tGregTech != null) {
					tNewModsList.add(tGregTech);
				}
				Objects.requireNonNull(GT_Utility.getField(tLoadController, "activeModList", true, true)).set(tLoadController, tNewModsList);
			} catch (Throwable e) {
				if (GT_Values.D1) {
					e.printStackTrace(GT_Log.err);
				}
			}
		}
		GregTech_API.sPreloadFinished = true;
		GT_Log.out.println("GT_Mod: Preload-Phase finished!");
		GT_Log.ore.println("GT_Mod: Preload-Phase finished!");
		for (Runnable tRunnable : GregTech_API.sAfterGTPreload) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
	}

	@Mod.EventHandler
	public void onLoad(FMLInitializationEvent aEvent) {
		if (GregTech_API.sLoadStarted) {
			return;
		}
		for (Runnable tRunnable : GregTech_API.sBeforeGTLoad) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
		gregtechproxy.onLoad();
		if (gregtechproxy.mSortToTheEnd) {
			new GT_ItemIterator().run();
			gregtechproxy.registerUnificationEntries();
			new GT_FuelLoader().run();
		}
		GregTech_API.sLoadFinished = true;
		GT_Log.out.println("GT_Mod: Load-Phase finished!");
		GT_Log.ore.println("GT_Mod: Load-Phase finished!");
		for (Runnable tRunnable : GregTech_API.sAfterGTLoad) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
	}

	@Mod.EventHandler
	public void onPostLoad(FMLPostInitializationEvent aEvent) {
		if (GregTech_API.sPostloadStarted) {
			return;
		}
		for (Runnable tRunnable : GregTech_API.sBeforeGTPostload) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
		gregtechproxy.onPostLoad();
		if (gregtechproxy.mSortToTheEnd) {
			gregtechproxy.registerUnificationEntries();
		} else {
			new GT_ItemIterator().run();
			gregtechproxy.registerUnificationEntries();
			new GT_FuelLoader().run();
		}
		new GT_BookAndLootLoader().run();
		new GT_ItemMaxStacksizeLoader().run();
		new GT_BlockResistanceLoader().run();
		new GT_RecyclerBlacklistLoader().run();
		new GT_MinableRegistrator().run();
		new GT_MachineRecipeLoader().run();
		new EX_MachineRecipeLoader().LOAD_RECIPES();
		new GT_ScrapboxDropLoader().run();
		new GT_CropLoader().run();
		new GT_Worldgenloader().run();
		new GT_CoverLoader().run();

		GT_RecipeRegistrator.registerUsagesForMaterials(new ItemStack(Blocks.planks, 1), null, false);
		GT_RecipeRegistrator.registerUsagesForMaterials(new ItemStack(Blocks.cobblestone, 1), null, false);
		GT_RecipeRegistrator.registerUsagesForMaterials(new ItemStack(Blocks.stone, 1), null, false);
		GT_RecipeRegistrator.registerUsagesForMaterials(new ItemStack(Items.leather, 1), null, false);

		GT_OreDictUnificator.addItemData(GT_ModHandler.getRecipeOutput(null, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), null, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), null, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), null, null, null), new ItemData(Materials.Tin, 10886400L));
		if (!GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockcrafting, "tile.glowstone", false, "Enable Workbench crafting of Storage Blocks")) {
			GT_ModHandler.removeRecipe(new ItemStack(Items.glowstone_dust, 1), new ItemStack(Items.glowstone_dust, 1), null, new ItemStack(Items.glowstone_dust, 1), new ItemStack(Items.glowstone_dust, 1));
		}
		GT_ModHandler.removeRecipe(new ItemStack(Blocks.wooden_slab, 1, 0), new ItemStack(Blocks.wooden_slab, 1, 1), new ItemStack(Blocks.wooden_slab, 1, 2));
		GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", 'W', new ItemStack(Blocks.planks, 1, 0)});

		GT_Log.out.println("GT_Mod: Activating OreDictionary Handler, this can take some time, as it scans the whole OreDictionary");
		FMLLog.info("If your Log stops here, you were too impatient. Wait a bit more next time, before killing Minecraft with the Task Manager.");
		gregtechproxy.activateOreDictHandler();
		FMLLog.info("Congratulations, you have been waiting long enough. Have a Cake.");
		GT_Log.out.println("GT_Mod: " + GT_ModHandler.sSingleNonBlockDamagableRecipeList.size() + " Recipes were left unused.");
		if (GT_Values.D1) {
			IRecipe tRecipe;
			for (Iterator<IRecipe> i$ = GT_ModHandler.sSingleNonBlockDamagableRecipeList.iterator(); i$.hasNext(); GT_Log.out.println("=> " + tRecipe.getRecipeOutput().getDisplayName())) {
				tRecipe = i$.next();
			}
		}
		new GT_CraftingRecipeLoader().run();
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2forgehammer", true, "Disable Industrial Craft 2's Forge Hammer")) {
			GT_ModHandler.removeRecipeByOutput(ItemList.IC2_ForgeHammer.getWildcard(1L));
		}
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("machine", 1L));
		GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("machine", 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{"RRR", "RwR", "RRR", 'R', OrePrefixes.plate.get(Materials.Iron)});
		for (FluidContainerRegistry.FluidContainerData tData : FluidContainerRegistry.getRegisteredFluidContainerData()) {
			if ((tData.filledContainer.getItem() == Items.potionitem) && (tData.filledContainer.getItemDamage() == 0)) {
				GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes.addRecipe(true, new ItemStack[]{ItemList.Bottle_Empty.get(1L)}, new ItemStack[]{new ItemStack(Items.potionitem, 1, 0)}, null, new FluidStack[]{Materials.Water.getFluid(250L)}, null, 4, 1, 0);
				GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes.addRecipe(true, new ItemStack[]{new ItemStack(Items.potionitem, 1, 0)}, new ItemStack[]{ItemList.Bottle_Empty.get(1L)}, null, null, null, 4, 1, 0);
			} else {
				GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes.addRecipe(true, new ItemStack[]{tData.emptyContainer}, new ItemStack[]{tData.filledContainer}, null, new FluidStack[]{tData.fluid}, null, tData.fluid.amount / 62, 1, 0);
				GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes.addRecipe(true, new ItemStack[]{tData.filledContainer}, new ItemStack[]{GT_Utility.getContainerItem(tData.filledContainer, true)}, null, null, new FluidStack[]{tData.fluid}, tData.fluid.amount / 62, 1, 0);
			}
		}
		try {
			Collection<ICentrifugeRecipe> iRecipe = RecipeManagers.centrifugeManager.recipes();			
			for (ICentrifugeRecipe tRecipe : iRecipe) {
			Map<ItemStack, Float> outputs = tRecipe.getAllProducts();
			ItemStack[] tOutputs = new ItemStack[outputs.size()];
			int[] tChances = new int[outputs.size()];
			int i = 0;
			for (Map.Entry<ItemStack, Float> entry : outputs.entrySet()) {
			tChances[i] = (int) (entry.getValue() * 10000);
			tOutputs[i] = entry.getKey().copy();
			i++;
			}
			GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(true, new ItemStack[]{tRecipe.getInput()}, tOutputs, null, tChances, null, null, 128, 5, 0);
			}
			} catch (Throwable e) {
			if (GT_Values.D1) {
			e.printStackTrace(GT_Log.err);
			}
			}
			try {
				Collection<ISqueezerRecipe> iRecipe = RecipeManagers.squeezerManager.recipes();			    
			for (ISqueezerRecipe tRecipe : iRecipe) {
			if ((tRecipe.getResources().length == 1) && (tRecipe.getFluidOutput() != null)) {
			GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes.addRecipe(true, new ItemStack[]{tRecipe.getResources()[0]}, new ItemStack[]{tRecipe.getRemnants()}, null, new int[]{(int) (tRecipe.getRemnantsChance() * 10000)}, null, new FluidStack[]{tRecipe.getFluidOutput()}, 400, 2, 0);
			}
			}
			} catch (Throwable e) {
			if (GT_Values.D1) {
			e.printStackTrace(GT_Log.err);
			}
			}
	
		String tName;
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "blastfurnace"), true, "Disable Industrial Craft 2's Blast Furnace")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "blockcutter"), true, "Disable Industrial Craft 2's Block Cutter")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "inductionFurnace"), true, "Disable Industrial Craft 2's Induction Furnace")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "generator"), false, "Disable Industrial Craft 2's Generator")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "windMill"), true, "Disable Industrial Craft 2's Windmill")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "waterMill"), true, "Disable Industrial Craft 2's Watermill")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "solarPanel"), true, "Disable Industrial Craft 2's Solar Panel")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "centrifuge"), true, "Disable Industrial Craft 2's Centrifuge")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "electrolyzer"), false, "Disable Industrial Craft 2's Electrolyzer")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "compressor"), true, "Disable Industrial Craft 2's Compressor")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "electroFurnace"), true, "Disable Industrial Craft 2's Electric Furnace")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "extractor"), true, "Disable Industrial Craft 2's Extractor")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "macerator"), true, "Disable Industrial Craft 2's Macerator")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "recycler"), true, "Disable Industrial Craft 2's Recycler")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "metalformer"), true, "Disable Industrial Craft 2's Metal Former")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "orewashingplant"), true, "Disable Industrial Craft 2's Ore Washing Plant")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "massFabricator"), true, "Disable Industrial Craft 2's Mass-Fabricator")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "ic2_" + (tName = "replicator"), true, "Disable Industrial Craft 2's Replicator")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item(tName, 1L));
		}
		if (gregtechproxy.mNerfedVanillaTools) {
			GT_Log.out.println("GT_Mod: Nerfing Vanilla Tool Durability");
			Items.wooden_sword.setMaxDamage(12);
			Items.wooden_pickaxe.setMaxDamage(12);
			Items.wooden_shovel.setMaxDamage(12);
			Items.wooden_axe.setMaxDamage(12);
			Items.wooden_hoe.setMaxDamage(12);

			Items.stone_sword.setMaxDamage(48);
			Items.stone_pickaxe.setMaxDamage(48);
			Items.stone_shovel.setMaxDamage(48);
			Items.stone_axe.setMaxDamage(48);
			Items.stone_hoe.setMaxDamage(48);

			Items.iron_sword.setMaxDamage(256);
			Items.iron_pickaxe.setMaxDamage(256);
			Items.iron_shovel.setMaxDamage(256);
			Items.iron_axe.setMaxDamage(256);
			Items.iron_hoe.setMaxDamage(256);

			Items.golden_sword.setMaxDamage(24);
			Items.golden_pickaxe.setMaxDamage(24);
			Items.golden_shovel.setMaxDamage(24);
			Items.golden_axe.setMaxDamage(24);
			Items.golden_hoe.setMaxDamage(24);

			Items.diamond_sword.setMaxDamage(768);
			Items.diamond_pickaxe.setMaxDamage(768);
			Items.diamond_shovel.setMaxDamage(768);
			Items.diamond_axe.setMaxDamage(768);
			Items.diamond_hoe.setMaxDamage(768);
		}
		GT_Log.out.println("GT_Mod: Adding buffered Recipes.");
		GT_ModHandler.stopBufferingCraftingRecipes();

		GT_Log.out.println("GT_Mod: Saving Lang File.");
		GT_LanguageManager.sEnglishFile.save();
		GregTech_API.sPostloadFinished = true;
		GT_Log.out.println("GT_Mod: PostLoad-Phase finished!");
		GT_Log.ore.println("GT_Mod: PostLoad-Phase finished!");
		for (Runnable tRunnable : GregTech_API.sAfterGTPostload) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
		GT_Log.out.println("GT_Mod: Adding Fake Recipes for NEI");
				if (ItemList.FR_Bee_Drone.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Bee_Drone.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Bee_Drone.getWithName(1L, "Scanned Drone")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Bee_Princess.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Bee_Princess.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Bee_Princess.getWithName(1L, "Scanned Princess")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Bee_Queen.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Bee_Queen.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Bee_Queen.getWithName(1L, "Scanned Queen")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Tree_Sapling.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Tree_Sapling.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Tree_Sapling.getWithName(1L, "Scanned Sapling")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Butterfly.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Butterfly.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Butterfly.getWithName(1L, "Scanned Butterfly")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Larvae.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Larvae.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Larvae.getWithName(1L, "Scanned Larvae")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Serum.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Serum.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Serum.getWithName(1L, "Scanned Serum")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_Caterpillar.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_Caterpillar.getWildcard(1L)}, new ItemStack[]{ItemList.FR_Caterpillar.getWithName(1L, "Scanned Caterpillar")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.FR_PollenFertile.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.FR_PollenFertile.getWildcard(1L)}, new ItemStack[]{ItemList.FR_PollenFertile.getWithName(1L, "Scanned Pollen")}, null, new FluidStack[]{Materials.Honey.getFluid(50L)}, null, 500, 2, 0);
				}
				if (ItemList.IC2_Crop_Seeds.get(1L) != null) {
					GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.IC2_Crop_Seeds.getWildcard(1L)}, new ItemStack[]{ItemList.IC2_Crop_Seeds.getWithName(1L, "Scanned Seeds")}, null, null, null, 160, 8, 0);
				}
				GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{new ItemStack(Items.written_book, 1, 32767)}, new ItemStack[]{ItemList.Tool_DataStick.getWithName(1L, "Scanned Book Data")}, ItemList.Tool_DataStick.getWithName(1L, "Stick to save it to"), null, null, 128, 32, 0);
				GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{new ItemStack(Items.filled_map, 1, 32767)}, new ItemStack[]{ItemList.Tool_DataStick.getWithName(1L, "Scanned Map Data")}, ItemList.Tool_DataStick.getWithName(1L, "Stick to save it to"), null, null, 128, 32, 0);
				GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.Tool_DataOrb.getWithName(1L, "Orb to overwrite")}, new ItemStack[]{ItemList.Tool_DataOrb.getWithName(1L, "Copy of the Orb")}, ItemList.Tool_DataOrb.getWithName(0L, "Orb to copy"), null, null, 512, 32, 0);
				GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.Tool_DataStick.getWithName(1L, "Stick to overwrite")}, new ItemStack[]{ItemList.Tool_DataStick.getWithName(1L, "Copy of the Stick")}, ItemList.Tool_DataStick.getWithName(0L, "Stick to copy"), null, null, 128, 32, 0);
				for (Materials tMaterial : Materials.VALUES) {
					if ((tMaterial.mElement != null) && (!tMaterial.mElement.mIsIsotope) && (tMaterial != Materials.Magic) && (tMaterial.getMass() > 0L)) {
						ItemStack tOutput = ItemList.Tool_DataOrb.get(1L);
						Behaviour_DataOrb.setDataTitle(tOutput, "Elemental-Scan");
						Behaviour_DataOrb.setDataName(tOutput, tMaterial.mElement.name());
						ItemStack tInput = GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial, 1L);
						if (tInput != null) {
							GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{tInput}, new ItemStack[]{tOutput}, ItemList.Tool_DataOrb.get(1L), null, null, (int) (tMaterial.getMass() * 8192L), 32, 0);
							GT_Recipe.GT_Recipe_Map.sRepicatorFakeRecipes.addFakeRecipe(false, null, new ItemStack[]{tInput}, new ItemStack[]{tOutput}, new FluidStack[]{Materials.UUMatter.getFluid(tMaterial.getMass())}, null, (int) (tMaterial.getMass() * 512L), 32, 0);
						}
						tInput = GT_OreDictUnificator.get(OrePrefixes.cell, tMaterial, 1L);
						if (tInput != null) {
							GT_Recipe.GT_Recipe_Map.sScannerFakeRecipes.addFakeRecipe(false, new ItemStack[]{tInput}, new ItemStack[]{tOutput}, ItemList.Tool_DataOrb.get(1L), null, null, (int) (tMaterial.getMass() * 8192L), 32, 0);
							GT_Recipe.GT_Recipe_Map.sRepicatorFakeRecipes.addFakeRecipe(false, null, new ItemStack[]{tInput}, new ItemStack[]{tOutput}, new FluidStack[]{Materials.UUMatter.getFluid(tMaterial.getMass())}, null, (int) (tMaterial.getMass() * 512L), 32, 0);
						}
					}
				}
				GT_Recipe.GT_Recipe_Map.sRockBreakerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.Display_ITS_FREE.getWithName(0L, "Place Lava on Side")}, new ItemStack[]{new ItemStack(Blocks.cobblestone, 1)}, null, null, null, 16, 32, 0);
				GT_Recipe.GT_Recipe_Map.sRockBreakerFakeRecipes.addFakeRecipe(false, new ItemStack[]{ItemList.Display_ITS_FREE.getWithName(0L, "Place Lava on Top")}, new ItemStack[]{new ItemStack(Blocks.stone, 1)}, null, null, null, 16, 32, 0);
				GT_Recipe.GT_Recipe_Map.sRockBreakerFakeRecipes.addFakeRecipe(false, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L)}, new ItemStack[]{new ItemStack(Blocks.obsidian, 1)}, null, null, null, 128, 32, 0);
				for (Entry<IRecipeInput, RecipeOutput> iRecipeInputRecipeOutputEntry : GT_ModHandler.getMaceratorRecipeList().entrySet()) {
					if (((RecipeOutput) ((Entry) iRecipeInputRecipeOutputEntry).getValue()).items.size() > 0) {
						for (ItemStack tStack : ((IRecipeInput) ((Entry) iRecipeInputRecipeOutputEntry).getKey()).getInputs()) {
							if (GT_Utility.isStackValid(tStack)) {
								GT_Recipe.GT_Recipe_Map.sMaceratorRecipes.addFakeRecipe(true, new ItemStack[]{GT_Utility.copyAmount(((IRecipeInput) ((Entry) iRecipeInputRecipeOutputEntry).getKey()).getAmount(), tStack)}, new ItemStack[]{(ItemStack) ((RecipeOutput) ((Entry) iRecipeInputRecipeOutputEntry).getValue()).items.get(0)}, null, null, null, null, 400, 2, 0);
							}
						}
					}
				}
				achievements = new GT_Achievements();
				Map.Entry<IRecipeInput, RecipeOutput> tRecipe;
				GT_Log.out.println("GT_Mod: Loading finished, deallocating temporary Init Variables.");
				GregTech_API.sBeforeGTPreload = null;
				GregTech_API.sAfterGTPreload = null;
				GregTech_API.sBeforeGTLoad = null;
				GregTech_API.sAfterGTLoad = null;
				GregTech_API.sBeforeGTPostload = null;
				GregTech_API.sAfterGTPostload = null;			
				
				
	}

	@Mod.EventHandler
	public void onServerStarting(FMLServerStartingEvent aEvent) {
		for (Runnable tRunnable : GregTech_API.sBeforeGTServerstart) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
		gregtechproxy.onServerStarting();
		GT_Log.out.println("GT_Mod: Unificating outputs of all known Recipe Types.");
		ArrayList<ItemStack> tStacks = new ArrayList<>(10000);
		GT_Log.out.println("GT_Mod: IC2 Machines");
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.cannerBottle.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.centrifuge.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.compressor.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.extractor.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.macerator.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.metalformerCutting.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.metalformerExtruding.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.metalformerRolling.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.matterAmplifier.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		for (RecipeOutput tRecipe : ic2.api.recipe.Recipes.oreWashing.getRecipes().values()) {
			ItemStack tStack;
			for (Iterator<ItemStack> i$ = tRecipe.items.iterator(); i$.hasNext(); tStacks.add(tStack)) {
				tStack = i$.next();
			}
		}
		GT_Log.out.println("GT_Mod: Dungeon Loot");
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("dungeonChest").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("bonusChest").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("villageBlacksmith").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("strongholdCrossing").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("strongholdLibrary").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("strongholdCorridor").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("pyramidJungleDispenser").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("pyramidJungleChest").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("pyramidDesertyChest").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		for (WeightedRandomChestContent tContent : ChestGenHooks.getInfo("mineshaftCorridor").getItems(new Random())) {
			tStacks.add(tContent.theItemId);
		}
		GT_Log.out.println("GT_Mod: Smelting");
		Object tStack;
		for (Iterator i$ = FurnaceRecipes.smelting().getSmeltingList().values().iterator(); i$.hasNext(); tStacks.add((ItemStack) tStack)) {
			tStack = i$.next();
		}
		if (gregtechproxy.mCraftingUnification) {
			GT_Log.out.println("GT_Mod: Crafting Recipes");
			for (Object tRecipe : CraftingManager.getInstance().getRecipeList()) {
				if ((tRecipe instanceof IRecipe)) {
					tStacks.add(((IRecipe) tRecipe).getRecipeOutput());
				}
			}
		}
		for (ItemStack tOutput : tStacks) {
			if (gregtechproxy.mRegisteredOres.contains(tOutput)) {
				FMLLog.severe("GT-ERR-01: @ " + tOutput.getUnlocalizedName() + "   " + tOutput.getDisplayName());
				FMLLog.severe("A Recipe used an OreDict Item as Output directly, without copying it before!!! This is a typical CallByReference/CallByValue Error");
				FMLLog.severe("Said Item will be renamed to make the invalid Recipe visible, so that you can report it properly.");
				FMLLog.severe("Please check all Recipes outputting this Item, and report the Recipes to their Owner.");
				FMLLog.severe("The Owner of the ==>RECIPE<==, NOT the Owner of the Item, which has been mentioned above!!!");
				FMLLog.severe("And ONLY Recipes which are ==>OUTPUTTING<== the Item, sorry but I don't want failed Bug Reports.");
				FMLLog.severe("GregTech just reports this Error to you, so you can report it to the Mod causing the Problem.");
				FMLLog.severe("Even though I make that Bug visible, I can not and will not fix that for you, that's for the causing Mod to fix.");
				FMLLog.severe("And speaking of failed Reports:");
				FMLLog.severe("Both IC2 and GregTech CANNOT be the CAUSE of this Problem, so don't report it to either of them.");
				FMLLog.severe("I REPEAT, BOTH, IC2 and GregTech CANNOT be the source of THIS BUG. NO MATTER WHAT.");
				FMLLog.severe("Asking in the IC2 Forums, which Mod is causing that, won't help anyone, since it is not possible to determine, which Mod it is.");
				FMLLog.severe("If it would be possible, then I would have had added the Mod which is causing it to the Message already. But it is not possible.");
				FMLLog.severe("Sorry, but this Error is serious enough to justify this Wall-O-Text and the partially allcapsed Language.");
				FMLLog.severe("Also it is a Ban Reason on the IC2-Forums to post this seriously.");
				tOutput.setStackDisplayName("ERROR! PLEASE CHECK YOUR LOG FOR 'GT-ERR-01'!");
			} else {
				GT_OreDictUnificator.setStack(tOutput);
			}
		}
		GregTech_API.mServerStarted = true;
		GT_Log.out.println("GT_Mod: ServerStarting-Phase finished!");
		GT_Log.ore.println("GT_Mod: ServerStarting-Phase finished!");
		for (Runnable tRunnable : GregTech_API.sAfterGTServerstart) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
	}

	@Mod.EventHandler
	public void onServerStarted(FMLServerStartedEvent aEvent) {
		gregtechproxy.onServerStarted();
	}

	@Mod.EventHandler
	public void onIDChangingEvent(FMLModIdMappingEvent aEvent) {
		GT_Utility.reInit();
		GT_Recipe.reInit();
		for (Map<GT_ItemStack, ?> sItemStackMapping : GregTech_API.sItemStackMappings) {
			try {
				GT_Utility.reMap((Map<GT_ItemStack, ?>) sItemStackMapping);
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}

	}
	//  public void onIDChangingEvent(FMLModIdMappingEvent aEvent)
	//  {
		//    GT_Utility.reInit();
	//    GT_Recipe.reInit();
	//    Map<GT_ItemStack, ?> tMap;
	//    for (Iterator i$ = GregTech_API.sItemStackMappings.iterator(); i$.hasNext(); ) {
	//      tMap = (Map)i$.next();
	//    }
	//  }

	@Mod.EventHandler
	public void onServerStopping(FMLServerStoppingEvent aEvent) {
		for (Runnable tRunnable : GregTech_API.sBeforeGTServerstop) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
		gregtechproxy.onServerStopping();
		try {
			if ((GT_Values.D1) || (GT_Log.out != System.out)) {
				GT_Log.out.println("*");
				GT_Log.out.println("Printing List of all registered Objects inside the OreDictionary, now with free extra Sorting:");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");

				String[] tList = OreDictionary.getOreNames();
				Arrays.sort(tList);
				for (String tOreName : tList) {
					int tAmount = OreDictionary.getOres(tOreName).size();
					if (tAmount > 0) {
						GT_Log.out.println((tAmount < 10 ? " " : "") + tAmount + "x " + tOreName);
					}
				}
				GT_Log.out.println("*");
				GT_Log.out.println("Printing List of all registered Objects inside the Fluid Registry, now with free extra Sorting:");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");

				tList = FluidRegistry.getRegisteredFluids().keySet().toArray(new String[0]);
				Arrays.sort(tList);
				for (String tFluidName : tList) {
					GT_Log.out.println(tFluidName);
				}
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("Outputting all the Names inside the Biomeslist");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
					if (BiomeGenBase.getBiomeGenArray()[i] != null) {
						GT_Log.out.println(BiomeGenBase.getBiomeGenArray()[i].biomeID + " = " + BiomeGenBase.getBiomeGenArray()[i].biomeName);
					}
				}
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("Printing List of generatable Materials");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				for (int i = 0; i < GregTech_API.sGeneratedMaterials.length; i++) {
					if (GregTech_API.sGeneratedMaterials[i] == null) {
						GT_Log.out.println("Index " + i + ":" + null);
					} else {
						GT_Log.out.println("Index " + i + ":" + GregTech_API.sGeneratedMaterials[i]);
					}
				}
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("END GregTech-Debug");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
				GT_Log.out.println("*");
			}
		} catch (Throwable e) {
			if (GT_Values.D1) {
				e.printStackTrace(GT_Log.err);
			}
		}
		for (Runnable tRunnable : GregTech_API.sAfterGTServerstop) {
			try {
				tRunnable.run();
			} catch (Throwable e) {
				e.printStackTrace(GT_Log.err);
			}
		}
	}

	public boolean isServerSide() {
		return gregtechproxy.isServerSide();
	}

	public boolean isClientSide() {
		return gregtechproxy.isClientSide();
	}

	public boolean isBukkitSide() {
		return gregtechproxy.isBukkitSide();
	}

	public EntityPlayer getThePlayer() {
		return gregtechproxy.getThePlayer();
	}

	public int addArmor(String aArmorPrefix) {
		return gregtechproxy.addArmor(aArmorPrefix);
	}

	public void doSonictronSound(ItemStack aStack, World aWorld, double aX, double aY, double aZ) {
		gregtechproxy.doSonictronSound(aStack, aWorld, aX, aY, aZ);
	}
}
