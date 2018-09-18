package gregtech.loaders.postload;

import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Materials;
import gregtech.common.GT_Worldgen_GT_Ore_Layer;
import gregtech.common.GT_Worldgen_GT_Ore_SmallPieces;
import gregtech.common.GT_Worldgen_Stone;
import gregtech.common.GT_Worldgenerator;
import cpw.mods.fml.common.Loader;

import java.util.Locale;

public class GT_Worldgenloader
        implements Runnable {
    public void run() {
        GregTech_API.sWorldgenFile.setCathegoryComment("general", "General WorldGeneration settings");
        boolean tPFAA = (GregTech_API.sWorldgenFile.get(ConfigCategories.Main.general, "AutoDetectPFAA", true, "Detect PFAAGeologica")) && (Loader.isModLoaded("PFAAGeologica"));

        new GT_Worldgenerator();

        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.overworld", "Overworld blocks blobs");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.overworld.stone", "Overworld Stone blobs");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.overworld.stone.blackgranite", "Overworld Black Granite blobs generation sizes");
        new GT_Worldgen_Stone("overworld.stone.blackgranite.tiny", true, GregTech_API.sBlockGranites, 0, 0, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.small", true, GregTech_API.sBlockGranites, 0, 0, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.medium", true, GregTech_API.sBlockGranites, 0, 0, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.large", true, GregTech_API.sBlockGranites, 0, 0, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.huge", true, GregTech_API.sBlockGranites, 0, 0, 1, 400, 240, 0, 120, null, false);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.overworld.stone.redgranite", "Overworld Red Granite blobs generation sizes");
        new GT_Worldgen_Stone("overworld.stone.redgranite.tiny", true, GregTech_API.sBlockGranites, 8, 0, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.small", true, GregTech_API.sBlockGranites, 8, 0, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.medium", true, GregTech_API.sBlockGranites, 8, 0, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.large", true, GregTech_API.sBlockGranites, 8, 0, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.huge", true, GregTech_API.sBlockGranites, 8, 0, 1, 400, 240, 0, 120, null, false);

        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.nether", "Nether blocks blobs");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.nether.stone", "Nether Stone blobs");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.nether.stone.blackgranite", "Nether Black Granite blobs generation sizes");
        new GT_Worldgen_Stone("nether.stone.blackgranite.tiny", false, GregTech_API.sBlockGranites, 0, -1, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.small", false, GregTech_API.sBlockGranites, 0, -1, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.medium", false, GregTech_API.sBlockGranites, 0, -1, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.large", false, GregTech_API.sBlockGranites, 0, -1, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.huge", false, GregTech_API.sBlockGranites, 0, -1, 1, 400, 240, 0, 120, null, false);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.nether.stone.redgranite", "Nether Red Granite blobs generation sizes");
        new GT_Worldgen_Stone("nether.stone.redgranite.tiny", false, GregTech_API.sBlockGranites, 8, -1, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.small", false, GregTech_API.sBlockGranites, 8, -1, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.medium", false, GregTech_API.sBlockGranites, 8, -1, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.large", false, GregTech_API.sBlockGranites, 8, -1, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.huge", false, GregTech_API.sBlockGranites, 8, -1, 1, 400, 240, 0, 120, null, false);

        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore", "Overall Ore Generation settings");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small", "Small Ores distributions");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.copper", "Small Copper Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.copper", true, 60, 120, 32, !tPFAA, true, true, Materials.Copper);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.tin", "Small Tin Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tin", true, 60, 120, 32, !tPFAA, true, true, Materials.Tin);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.bismuth", "Small Bismuth Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bismuth", true, 80, 120, 8, !tPFAA, true, false, Materials.Bismuth);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.coal", "Small Coal Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.coal", true, 60, 100, 24, !tPFAA, false, false, Materials.Coal);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.iron", "Small Iron Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iron", true, 40, 80, 16, !tPFAA, true, true, Materials.Iron);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.lead", "Small Lead Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lead", true, 40, 80, 16, !tPFAA, true, true, Materials.Lead);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.zinc", "Small Zinc Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.zinc", true, 30, 60, 12, !tPFAA, true, true, Materials.Zinc);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.gold", "Small Gold Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.gold", true, 20, 40, 8, !tPFAA, true, true, Materials.Gold);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.silver", "Small Silver Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.silver", true, 20, 40, 8, !tPFAA, true, true, Materials.Silver);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.nickel", "Small Nickel Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.nickel", true, 20, 40, 8, !tPFAA, true, true, Materials.Nickel);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.lapis", "Small Lapis lazuli Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lapis", true, 20, 40, 4, !tPFAA, false, false, Materials.Lapis);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.diamond", "Small Diamond Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.diamond", true, 5, 10, 2, !tPFAA, true, false, Materials.Diamond);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.emerald", "Small Emerald Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.emerald", true, 5, 250, 1, !tPFAA, true, false, Materials.Emerald);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.ruby", "Small Ruby Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.ruby", true, 5, 250, 1, !tPFAA, true, false, Materials.Ruby);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.sapphire", "Small Sapphire Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sapphire", true, 5, 250, 1, !tPFAA, true, false, Materials.Sapphire);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.greensapphire", "Small Green Sapphire Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.greensapphire", true, 5, 250, 1, !tPFAA, true, false, Materials.GreenSapphire);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.olivine", "Small Olivine Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.olivine", true, 5, 250, 1, !tPFAA, true, false, Materials.Olivine);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.topaz", "Small Topaz Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.topaz", true, 5, 250, 1, !tPFAA, true, false, Materials.Topaz);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.tanzanite", "Small Tanzanite Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tanzanite", true, 5, 250, 1, !tPFAA, true, false, Materials.Tanzanite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.amethyst", "Small Amethyst Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amethyst", true, 5, 250, 1, !tPFAA, true, false, Materials.Amethyst);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.opal", "Small Opal Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.opal", true, 5, 250, 1, !tPFAA, true, false, Materials.Opal);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.jasper", "Small Jasper Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.jasper", true, 5, 250, 1, !tPFAA, true, false, Materials.Jasper);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.bluetopaz", "Small Blue Topaz Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bluetopaz", true, 5, 250, 1, !tPFAA, true, false, Materials.BlueTopaz);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.amber", "Small Amber Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amber", true, 5, 250, 1, !tPFAA, true, false, Materials.Amber);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.foolsruby", "Small Fool's Ruby Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.foolsruby", true, 5, 250, 1, !tPFAA, true, false, Materials.FoolsRuby);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.garnetred", "Small Red Garnet Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetred", true, 5, 250, 1, !tPFAA, true, false, Materials.GarnetRed);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.garnetyellow", "Small Yellow Garnet Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetyellow", true, 5, 250, 1, !tPFAA, true, false, Materials.GarnetYellow);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.redstone", "Small Redstone Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.redstone", true, 5, 20, 8, !tPFAA, true, false, Materials.Redstone);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.teslatite", "Small Teslatite Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.teslatite", true, 5, 20, 8, true, true, false, Materials.Teslatite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.platinum", "Small Platinum Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.platinum", true, 20, 40, 8, false, false, true, Materials.Platinum);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.iridium", "Small Iridium Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iridium", true, 20, 40, 8, false, false, true, Materials.Iridium);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.netherquartz", "Small Nether Quartz Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.netherquartz", true, 30, 120, 64, false, true, false, Materials.NetherQuartz);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.saltpeter", "Small Saltpeter Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.saltpeter", true, 10, 60, 8, false, true, false, Materials.Saltpeter);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.sulfur_n", "Small Nether Sulfur Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_n", true, 10, 60, 32, false, true, false, Materials.Sulfur);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.sulfur_o", "Small Overworld Sulfur Ore distribution");
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_o", true, 5, 15, 8, !tPFAA, false, false, Materials.Sulfur);

        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.small.custom", "Custom Small Ores distribution");
        int i = 0;
        for (int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomSmallOreSlots", 16, "Number of slots reserved for custom Small Ores"); i < j; i++) {
            new GT_Worldgen_GT_Ore_SmallPieces(String.format(Locale.US,"ore.small.custom.%02d", i), false, 0, 0, 0, false, false, false, Materials._NULL);
        }
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix", "Large Veins distributions\n" +
                "Cited from https://ftb.gamepedia.com/GregTech_5/Mining_and_Processing#Default_Ore_Mixes\n" +
                "Density:       How tightly packed the ores are in a vein.\n" +
                "               Lower values can cause small gaps between ore blocks.\n" +
                "Max Height:    The maximum height at which the vein can generate.\n" +
                "Min Height:    The minimum height at which the vein can generate.\n" +
                "OrePrimaryLayer:\n" +
                "               Metadata value of the Primary ore in the vein\n" +
                "OreSecondaryLayer:\n" +
                "               Metadata value of the Secondray ore in the vein\n" +
                "OreSporadiclyInbeween:\n" +
                "               Metadata value of the Inbeween ore in the vein\n" +
                "OreSporadiclyAround:\n" +
                "               Metadata value of the Around ore in the vein\n" +
                "RandomWeight:  How likely it is for this vein to spawn.\n" +
                "               The higher this value is, the better the chance.\n" +
                "               This value is relative to the total of the RandomWeight values\n" +
                "               of all the ore veins. The default configuration has a total weight of 1850,\n" +
                "               so for example,a vein with a RandomWeight of 160 has a 160/1850 (8,6%)\n" +
                "               chance to spawn per generation attempt.\n" +
                "Size:          The maximum area an ore vein can occupy.\n" +
                "               A vein with a Size of 0 will always occupy a 16x16 block area,\n" +
                "               while a vein with a Size of 32 can occupy an area up to 80x80 blocks.");
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.naquadah", "Large Naquadah Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.naquadah", false, 10, 60, 10, 5, 32, false, false, true, Materials.Naquadah, Materials.Naquadah, Materials.Naquadah, Materials.NaquadahEnriched);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.lignite", "Large Lignite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lignite", true, 50, 130, 160, 8, 32, !tPFAA, false, false, Materials.Lignite, Materials.Lignite, Materials.Lignite, Materials.Coal);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.coal", "Large Coal Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.coal", true, 50, 80, 80, 6, 32, !tPFAA, false, false, Materials.Coal, Materials.Coal, Materials.Coal, Materials.Lignite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.magnetite", "Large Magnetite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.magnetite", true, 50, 120, 160, 3, 32, !tPFAA, true, false, Materials.Magnetite, Materials.Magnetite, Materials.Iron, Materials.VanadiumMagnetite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.gold", "Large Gold Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.gold", true, 60, 80, 160, 3, 32, !tPFAA, false, false, Materials.Magnetite, Materials.Magnetite, Materials.VanadiumMagnetite, Materials.Gold);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.iron", "Large Iron Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.iron", true, 10, 40, 120, 4, 24, !tPFAA, true, false, Materials.BrownLimonite, Materials.YellowLimonite, Materials.BandedIron, Materials.Malachite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.cassiterite", "Large Cassiterite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.cassiterite", true, 40, 120, 50, 5, 24, !tPFAA, false, true, Materials.Tin, Materials.Tin, Materials.Cassiterite, Materials.Tin);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.tetrahedrite", "Large Tetrahedrite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tetrahedrite", true, 80, 120, 70, 4, 24, !tPFAA, true, false, Materials.Tetrahedrite, Materials.Tetrahedrite, Materials.Copper, Materials.Stibnite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.netherquartz", "Large Nether Quartz Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.netherquartz", true, 40, 80, 80, 5, 24, false, true, false, Materials.NetherQuartz, Materials.NetherQuartz, Materials.NetherQuartz, Materials.NetherQuartz);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.sulfur", "Large Sulfur Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sulfur", true, 5, 20, 100, 5, 24, false, true, false, Materials.Sulfur, Materials.Sulfur, Materials.Pyrite, Materials.Sphalerite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.copper", "Large Copper Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.copper", true, 10, 30, 80, 4, 24, !tPFAA, true, false, Materials.Chalcopyrite, Materials.Iron, Materials.Pyrite, Materials.Copper);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.bauxite", "Large Bauxite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.bauxite", true, 50, 90, 80, 4, 24, !tPFAA, tPFAA, false, Materials.Bauxite, Materials.Bauxite, Materials.Aluminium, Materials.Ilmenite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.salts", "Large Salts Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.salts", true, 50, 60, 50, 3, 24, !tPFAA, false, false, Materials.RockSalt, Materials.Salt, Materials.Lepidolite, Materials.Spodumene);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.redstone", "Large Redstone Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.redstone", true, 10, 40, 60, 3, 24, !tPFAA, true, false, Materials.Redstone, Materials.Redstone, Materials.Ruby, Materials.Cinnabar);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.soapstone", "Large Soapstone Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.soapstone", true, 10, 40, 40, 3, 16, !tPFAA, false, false, Materials.Soapstone, Materials.Talc, Materials.Glauconite, Materials.Pentlandite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.nickel", "Large Nickel Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.nickel", true, 10, 40, 40, 3, 16, !tPFAA, true, true, Materials.Garnierite, Materials.Nickel, Materials.Cobaltite, Materials.Pentlandite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.platinum", "Large Platinum Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.platinum", true, 40, 50, 5, 3, 16, !tPFAA, false, true, Materials.Cooperite, Materials.Palladium, Materials.Platinum, Materials.Iridium);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.pitchblende", "Large Pitchblende Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.pitchblende", true, 10, 40, 40, 3, 16, !tPFAA, false, false, Materials.Pitchblende, Materials.Pitchblende, Materials.Uranium, Materials.Uraninite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.plutonium", "Large Plutonium Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.plutonium", false, 20, 30, 10, 3, 16, !tPFAA, false, false, Materials.Uraninite, Materials.Uraninite, Materials.Plutonium, Materials.Uranium);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.monazite", "Large Monazite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.monazite", true, 20, 40, 30, 3, 16, !tPFAA, tPFAA, false, Materials.Bastnasite, Materials.Bastnasite, Materials.Monazite, Materials.Neodymium);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.molybdenum", "Large Molybdenum Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.molybdenum", true, 20, 50, 5, 3, 16, !tPFAA, false, true, Materials.Wulfenite, Materials.Molybdenite, Materials.Molybdenum, Materials.Powellite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.tungstate", "Large Tungstate Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tungstate", true, 20, 50, 10, 3, 16, !tPFAA, false, true, Materials.Scheelite, Materials.Scheelite, Materials.Tungstate, Materials.Lithium);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.sapphire", "Large Sapphire Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sapphire", true, 10, 40, 60, 3, 16, !tPFAA, tPFAA, tPFAA, Materials.Almandine, Materials.Pyrope, Materials.Sapphire, Materials.GreenSapphire);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.manganese", "Large Manganese Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.manganese", true, 20, 30, 20, 3, 16, !tPFAA, false, true, Materials.Grossular, Materials.Spessartine, Materials.Pyrolusite, Materials.Tantalite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.quartz", "Large Quartz Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.quartz", true, 40, 80, 60, 3, 16, !tPFAA, tPFAA, false, Materials.Quartzite, Materials.Barite, Materials.CertusQuartz, Materials.CertusQuartz);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.diamond", "Large Diamond Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.diamond", true, 5, 20, 40, 2, 16, !tPFAA, false, false, Materials.Graphite, Materials.Graphite, Materials.Diamond, Materials.Coal);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.olivine", "Large Olivine Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.olivine", true, 10, 40, 60, 3, 16, !tPFAA, false, true, Materials.Bentonite, Materials.Magnesite, Materials.Olivine, Materials.Glauconite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.apatite", "Large Apatite Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.apatite", true, 40, 60, 60, 3, 16, !tPFAA, false, false, Materials.Apatite, Materials.Apatite, Materials.Phosphorus, Materials.Phosphate);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.galena", "Large Galena Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.galena", true, 30, 60, 40, 5, 16, !tPFAA, false, false, Materials.Galena, Materials.Galena, Materials.Silver, Materials.Lead);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.lapis", "Large Lapis lazuli Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lapis", true, 20, 50, 40, 5, 16, !tPFAA, false, true, Materials.Lazurite, Materials.Sodalite, Materials.Lapis, Materials.Calcite);
        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.beryllium", "Large Beryllium Vein distribution");
        new GT_Worldgen_GT_Ore_Layer("ore.mix.beryllium", true, 5, 30, 30, 3, 16, !tPFAA, false, true, Materials.Beryllium, Materials.Beryllium, Materials.Emerald, Materials.Thorium);

        GregTech_API.sWorldgenFile.setCathegoryComment("worldgen.ore.mix.custom", "Large Custom Veins distribution");
        i = 0;
        for (int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomLargeVeinSlots", 16, "Number of slots reserved for custom Large Veins"); i < j; i++) {
            new GT_Worldgen_GT_Ore_Layer(String.format(Locale.US,"ore.mix.custom.%02d", i), false, 0, 0, 0, 0, 0, false, false, false, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        }
    }
}
