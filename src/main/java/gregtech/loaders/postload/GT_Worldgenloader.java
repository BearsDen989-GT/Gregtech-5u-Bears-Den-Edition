package gregtech.loaders.postload;

import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.MaterialsOld;
import gregtech.common.GT_Worldgen_GT_Ore_Layer;
import gregtech.common.GT_Worldgen_GT_Ore_SmallPieces;
import gregtech.common.GT_Worldgen_Stone;
import gregtech.common.GT_Worldgenerator;

import static gregtech.api.enums.GT_Values.EMPTY_STRING;
import static gregtech.api.enums.GT_Values.MOD_ID_PFAA;

public class GT_Worldgenloader
        implements Runnable {
    public void run() {
        boolean tPFAA = (GregTech_API.sWorldgenFile.get(ConfigCategories.general, "AutoDetectPFAA", true)) && (Loader.isModLoaded(MOD_ID_PFAA));

        new GT_Worldgenerator();

        new GT_Worldgen_Stone("overworld.stone.blackgranite.tiny", true, GregTech_API.sBlockGranites, 0, 0, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.small", true, GregTech_API.sBlockGranites, 0, 0, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.medium", true, GregTech_API.sBlockGranites, 0, 0, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.large", true, GregTech_API.sBlockGranites, 0, 0, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.huge", true, GregTech_API.sBlockGranites, 0, 0, 1, 400, 240, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.tiny", true, GregTech_API.sBlockGranites, 8, 0, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.small", true, GregTech_API.sBlockGranites, 8, 0, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.medium", true, GregTech_API.sBlockGranites, 8, 0, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.large", true, GregTech_API.sBlockGranites, 8, 0, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.huge", true, GregTech_API.sBlockGranites, 8, 0, 1, 400, 240, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 240, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.tiny", true, GregTech_API.sBlockStones, 8, 0, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.small", true, GregTech_API.sBlockStones, 8, 0, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.medium", true, GregTech_API.sBlockStones, 8, 0, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.large", true, GregTech_API.sBlockStones, 8, 0, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.huge", true, GregTech_API.sBlockStones, 8, 0, 1, 400, 240, 0, 120, null, false);

        new GT_Worldgen_Stone("nether.stone.marble.tiny", false, GregTech_API.sBlockStones, 0, -1, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.small", false, GregTech_API.sBlockStones, 0, -1, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.medium", false, GregTech_API.sBlockStones, 0, -1, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.large", false, GregTech_API.sBlockStones, 0, -1, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.huge", false, GregTech_API.sBlockStones, 0, -1, 1, 400, 240, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.tiny", false, GregTech_API.sBlockStones, 8, -1, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.small", false, GregTech_API.sBlockStones, 8, -1, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.medium", false, GregTech_API.sBlockStones, 8, -1, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.large", false, GregTech_API.sBlockStones, 8, -1, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.huge", false, GregTech_API.sBlockStones, 8, -1, 1, 400, 240, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.tiny", false, GregTech_API.sBlockGranites, 0, -1, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.small", false, GregTech_API.sBlockGranites, 0, -1, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.medium", false, GregTech_API.sBlockGranites, 0, -1, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.large", false, GregTech_API.sBlockGranites, 0, -1, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.huge", false, GregTech_API.sBlockGranites, 0, -1, 1, 400, 240, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.tiny", false, GregTech_API.sBlockGranites, 8, -1, 1, 50, 48, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.small", false, GregTech_API.sBlockGranites, 8, -1, 1, 100, 96, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.medium", false, GregTech_API.sBlockGranites, 8, -1, 1, 200, 144, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.large", false, GregTech_API.sBlockGranites, 8, -1, 1, 300, 192, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.huge", false, GregTech_API.sBlockGranites, 8, -1, 1, 400, 240, 0, 120, null, false);

        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.copper", true, 60, 120, 32, !tPFAA, true, true, MaterialsOld.Copper);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tin", true, 60, 120, 32, !tPFAA, true, true, MaterialsOld.Tin);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bismuth", true, 80, 120, 8, !tPFAA, true, false, MaterialsOld.Bismuth);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.coal", true, 60, 100, 24, !tPFAA, false, false, MaterialsOld.Coal);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iron", true, 40, 80, 16, !tPFAA, true, true, MaterialsOld.Iron);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lead", true, 40, 80, 16, !tPFAA, true, true, MaterialsOld.Lead);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.zinc", true, 30, 60, 12, !tPFAA, true, true, MaterialsOld.Zinc);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.gold", true, 20, 40, 8, !tPFAA, true, true, MaterialsOld.Gold);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.silver", true, 20, 40, 8, !tPFAA, true, true, MaterialsOld.Silver);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.nickel", true, 20, 40, 8, !tPFAA, true, true, MaterialsOld.Nickel);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lapis", true, 20, 40, 4, !tPFAA, false, false, MaterialsOld.Lapis);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.diamond", true, 5, 10, 2, !tPFAA, true, false, MaterialsOld.Diamond);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.emerald", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Emerald);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.ruby", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Ruby);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sapphire", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Sapphire);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.greensapphire", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.GreenSapphire);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.olivine", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Olivine);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.topaz", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Topaz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tanzanite", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Tanzanite);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amethyst", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Amethyst);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.opal", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Opal);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.jasper", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Jasper);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bluetopaz", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.BlueTopaz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amber", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.Amber);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.foolsruby", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.FoolsRuby);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetred", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.GarnetRed);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetyellow", true, 5, 250, 1, !tPFAA, true, false, MaterialsOld.GarnetYellow);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.redstone", true, 5, 20, 8, !tPFAA, true, false, MaterialsOld.Redstone);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.teslatite", true, 5, 20, 8, true, true, false, MaterialsOld.Teslatite);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.platinum", true, 20, 40, 8, false, false, true, MaterialsOld.Platinum);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iridium", true, 20, 40, 8, false, false, true, MaterialsOld.Iridium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.netherquartz", true, 30, 120, 64, false, true, false, MaterialsOld.NetherQuartz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.saltpeter", true, 10, 60, 8, false, true, false, MaterialsOld.Saltpeter);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_n", true, 10, 60, 32, false, true, false, MaterialsOld.Sulfur);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_o", true, 5, 15, 8, !tPFAA, false, false, MaterialsOld.Sulfur);

        int i = 0;
        for (int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomSmallOreSlots", 16); i < j; i++) {
            new GT_Worldgen_GT_Ore_SmallPieces("ore.small.custom." + (i < 10 ? "0" : EMPTY_STRING) + i, false, 0, 0, 0, false, false, false, MaterialsOld._NULL);
        }
        new GT_Worldgen_GT_Ore_Layer("ore.mix.naquadah", false, 10, 60, 10, 5, 32, false, false, true, MaterialsOld.Naquadah, MaterialsOld.Naquadah, MaterialsOld.Naquadah, MaterialsOld.NaquadahEnriched);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lignite", true, 50, 130, 160, 8, 32, !tPFAA, false, false, MaterialsOld.Lignite, MaterialsOld.Lignite, MaterialsOld.Lignite, MaterialsOld.Coal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.coal", true, 50, 80, 80, 6, 32, !tPFAA, false, false, MaterialsOld.Coal, MaterialsOld.Coal, MaterialsOld.Coal, MaterialsOld.Lignite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.magnetite", true, 50, 120, 160, 3, 32, !tPFAA, true, false, MaterialsOld.Magnetite, MaterialsOld.Magnetite, MaterialsOld.Iron, MaterialsOld.VanadiumMagnetite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.gold", true, 60, 80, 160, 3, 32, !tPFAA, false, false, MaterialsOld.Magnetite, MaterialsOld.Magnetite, MaterialsOld.VanadiumMagnetite, MaterialsOld.Gold);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.iron", true, 10, 40, 120, 4, 24, !tPFAA, true, false, MaterialsOld.BrownLimonite, MaterialsOld.YellowLimonite, MaterialsOld.BandedIron, MaterialsOld.Malachite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.cassiterite", true, 40, 120, 50, 5, 24, !tPFAA, false, true, MaterialsOld.Tin, MaterialsOld.Tin, MaterialsOld.Cassiterite, MaterialsOld.Tin);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tetrahedrite", true, 80, 120, 70, 4, 24, !tPFAA, true, false, MaterialsOld.Tetrahedrite, MaterialsOld.Tetrahedrite, MaterialsOld.Copper, MaterialsOld.Stibnite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.netherquartz", true, 40, 80, 80, 5, 24, false, true, false, MaterialsOld.NetherQuartz, MaterialsOld.NetherQuartz, MaterialsOld.NetherQuartz, MaterialsOld.NetherQuartz);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sulfur", true, 5, 20, 100, 5, 24, false, true, false, MaterialsOld.Sulfur, MaterialsOld.Sulfur, MaterialsOld.Pyrite, MaterialsOld.Sphalerite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.copper", true, 10, 30, 80, 4, 24, !tPFAA, true, false, MaterialsOld.Chalcopyrite, MaterialsOld.Iron, MaterialsOld.Pyrite, MaterialsOld.Copper);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.bauxite", true, 50, 90, 80, 4, 24, !tPFAA, tPFAA, false, MaterialsOld.Bauxite, MaterialsOld.Bauxite, MaterialsOld.Aluminium, MaterialsOld.Ilmenite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.salts", true, 50, 60, 50, 3, 24, !tPFAA, false, false, MaterialsOld.RockSalt, MaterialsOld.Salt, MaterialsOld.Lepidolite, MaterialsOld.Spodumene);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.redstone", true, 10, 40, 60, 3, 24, !tPFAA, true, false, MaterialsOld.Redstone, MaterialsOld.Redstone, MaterialsOld.Ruby, MaterialsOld.Cinnabar);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.soapstone", true, 10, 40, 40, 3, 16, !tPFAA, false, false, MaterialsOld.Soapstone, MaterialsOld.Talc, MaterialsOld.Glauconite, MaterialsOld.Pentlandite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.nickel", true, 10, 40, 40, 3, 16, !tPFAA, true, true, MaterialsOld.Garnierite, MaterialsOld.Nickel, MaterialsOld.Cobaltite, MaterialsOld.Pentlandite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.platinum", true, 40, 50, 5, 3, 16, !tPFAA, false, true, MaterialsOld.Cooperite, MaterialsOld.Palladium, MaterialsOld.Platinum, MaterialsOld.Iridium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.pitchblende", true, 10, 40, 40, 3, 16, !tPFAA, false, false, MaterialsOld.Pitchblende, MaterialsOld.Pitchblende, MaterialsOld.Uranium, MaterialsOld.Uraninite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.plutonium", false, 20, 30, 10, 3, 16, !tPFAA, false, false, MaterialsOld.Uraninite, MaterialsOld.Uraninite, MaterialsOld.Plutonium, MaterialsOld.Uranium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.monazite", true, 20, 40, 30, 3, 16, !tPFAA, tPFAA, false, MaterialsOld.Bastnasite, MaterialsOld.Bastnasite, MaterialsOld.Monazite, MaterialsOld.Neodymium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.molybdenum", true, 20, 50, 5, 3, 16, !tPFAA, false, true, MaterialsOld.Wulfenite, MaterialsOld.Molybdenite, MaterialsOld.Molybdenum, MaterialsOld.Powellite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tungstate", true, 20, 50, 10, 3, 16, !tPFAA, false, true, MaterialsOld.Scheelite, MaterialsOld.Scheelite, MaterialsOld.Tungstate, MaterialsOld.Lithium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sapphire", true, 10, 40, 60, 3, 16, !tPFAA, tPFAA, tPFAA, MaterialsOld.Almandine, MaterialsOld.Pyrope, MaterialsOld.Sapphire, MaterialsOld.GreenSapphire);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.manganese", true, 20, 30, 20, 3, 16, !tPFAA, false, true, MaterialsOld.Grossular, MaterialsOld.Spessartine, MaterialsOld.Pyrolusite, MaterialsOld.Tantalite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.quartz", true, 40, 80, 60, 3, 16, !tPFAA, tPFAA, false, MaterialsOld.Quartzite, MaterialsOld.Barite, MaterialsOld.CertusQuartz, MaterialsOld.CertusQuartz);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.diamond", true, 5, 20, 40, 2, 16, !tPFAA, false, false, MaterialsOld.Graphite, MaterialsOld.Graphite, MaterialsOld.Diamond, MaterialsOld.Coal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.olivine", true, 10, 40, 60, 3, 16, !tPFAA, false, true, MaterialsOld.Bentonite, MaterialsOld.Magnesite, MaterialsOld.Olivine, MaterialsOld.Glauconite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.apatite", true, 40, 60, 60, 3, 16, !tPFAA, false, false, MaterialsOld.Apatite, MaterialsOld.Apatite, MaterialsOld.Phosphorus, MaterialsOld.Phosphate);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.galena", true, 30, 60, 40, 5, 16, !tPFAA, false, false, MaterialsOld.Galena, MaterialsOld.Galena, MaterialsOld.Silver, MaterialsOld.Lead);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lapis", true, 20, 50, 40, 5, 16, !tPFAA, false, true, MaterialsOld.Lazurite, MaterialsOld.Sodalite, MaterialsOld.Lapis, MaterialsOld.Calcite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.beryllium", true, 5, 30, 30, 3, 16, !tPFAA, false, true, MaterialsOld.Beryllium, MaterialsOld.Beryllium, MaterialsOld.Emerald, MaterialsOld.Thorium);

        i = 0;
        for (int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomLargeVeinSlots", 16); i < j; i++) {
            new GT_Worldgen_GT_Ore_Layer("ore.mix.custom." + (i < 10 ? "0" : EMPTY_STRING) + i, false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        }
        new GT_Worldgen_GT_Ore_Layer("ore.mix.garnettin", true, 50, 60, 80, 4, 24, true, false, false, MaterialsOld.CassiteriteSand, MaterialsOld.GarnetSand, MaterialsOld.Asbestos, MaterialsOld.Diatomite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.01", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.02", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.03", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.04", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.05", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.06", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.07", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.08", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.09", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.10", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.11", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.12", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.13", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.14", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.15", false, 0, 0, 0, 0, 0, false, false, false, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL, MaterialsOld._NULL);
    }
}
