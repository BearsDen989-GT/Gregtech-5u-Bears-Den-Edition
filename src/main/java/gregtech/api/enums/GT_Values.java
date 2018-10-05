package gregtech.api.enums;

import gregtech.api.interfaces.internal.IGT_Mod;
import gregtech.api.interfaces.internal.IGT_RecipeAdder;
import gregtech.api.net.IGT_NetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Made for static imports, this Class is just a Helper.
 * <p/>
 * I am doing this to have a better Table alike view on my Code, so I can change things faster using the Block Selection Mode of eclipse.
 * <p/>
 * Go to "Window > Preferences > Java > Editor > Content Assist > Favorites" to set static importable Constant Classes such as this one as AutoCompleteable.
 */
public class GT_Values {

    /** Because "true" and "false" are too long. Some Programmers might wanna kill me for that, but this looks much better than true and false, and also it is better to have something that is not 4 and 5 Characters long, because of symmetry
     *  @deprecated by {@literal true}
     */
    @Deprecated public static final boolean T = true;
    /** @deprecated by {@literal false} */
    @Deprecated public static final boolean F = false;

    /**
     * Empty String for an easier Call Hierarchy
     */
    public static final String EMPTY_STRING = "";
    /** @deprecated by {@link #EMPTY_STRING} */
    @Deprecated public static final String E = EMPTY_STRING;

    /**
     * The first 32 Bits
     */
    public static final int[] BITS_32 = new int[]{1, 1 << 1, 1 << 2, 1 << 3, 1 << 4, 1 << 5, 1 << 6, 1 << 7, 1 << 8, 1 << 9, 1 << 10, 1 << 11, 1 << 12, 1 << 13, 1 << 14, 1 << 15, 1 << 16, 1 << 17, 1 << 18, 1 << 19, 1 << 20, 1 << 21, 1 << 22, 1 << 23, 1 << 24, 1 << 25, 1 << 26, 1 << 27, 1 << 28, 1 << 29, 1 << 30, 1 << 31};
    /** @deprecated by {@link #BITS_32} */
    @Deprecated public static final int[] B = BITS_32;

    /**
     * This is worth exactly one normal Item.
     * This Constant can be divided by many commonly used Numbers such as
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, ... 64 or 81
     * without loosing precision and is for that reason used as Unit of Amount.
     * But it is also small enough to be multiplied with larger Numbers.
     * <p/>
     * This is used to determine the amount of Material contained inside a prefixed Ore.
     * For example Nugget = M / 9 as it contains out of 1/9 of an Ingot.
     */
    public static final long MATERIAL_UNIT = 3628800;
    /** @deprecated by {@link #MATERIAL_UNIT} */
    @Deprecated public static final long M = MATERIAL_UNIT;

    /**
     * Fluid per Material Unit (Prime Factors: 3 * 3 * 2 * 2 * 2 * 2)
     */
    public static final long FLUID_MATERIAL_UNIT = 144;
    /** @deprecated by {@link #FLUID_MATERIAL_UNIT} */
    @Deprecated public static final long L = 144;

    /**
     * The Item WildCard Tag.
     * @deprecated by {@link net.minecraftforge.oredict.OreDictionary#WILDCARD_VALUE}
     */
    @Deprecated public static final short W = OreDictionary.WILDCARD_VALUE;

    /**
     * The Voltage Tiers. Use this Array instead of the old named Voltage Variables
     */
    public static final long[] TIERED_VOLTAGES = new long[]{8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    /** @deprecated by {@link #TIERED_VOLTAGES} */
    @Deprecated public static final long[] V = TIERED_VOLTAGES;

    /**
     * The short Names for the Voltages
     */
    public static final String[] VOLTAGE_ABBRS = new String[]{"ULV", "LV", "MV", "HV", "EV", "IV", "LuV", "ZPM", "UV", "MAX", "MAX", "MAX", "MAX", "MAX", "MAX", "MAX"};
    /** @deprecated by {@link #VOLTAGE_ABBRS} */
    @Deprecated public static final String[] VN = VOLTAGE_ABBRS;

    /**
     * The long Names for the Voltages
     */
    public static final String[] VOLTAGE_NAMES = new String[]{"Ultra Low Voltage", "Low Voltage", "Medium Voltage", "High Voltage", "Extreme Voltage", "Insane Voltage", "Ludicrous Voltage", "ZPM Voltage", "Ultimate Voltage", "Maximum Voltage", "Maximum Voltage", "Maximum Voltage", "Maximum Voltage", "Maximum Voltage", "Maximum Voltage", "Maximum Voltage"};

    /**
     * This way it is possible to have a Call Hierarchy of NullPointers in ItemStack based Functions, and also because most of the time I don't know what kind of Data Type the "null" stands for
     */
    public static final ItemStack NULL_ITEM_STACK = null;
    /** @deprecated by {@link #NULL_ITEM_STACK} */
    @Deprecated public static final ItemStack NI = NULL_ITEM_STACK;

    /**
     * This way it is possible to have a Call Hierarchy of NullPointers in FluidStack based Functions, and also because most of the time I don't know what kind of Data Type the "null" stands for
     */
    public static final FluidStack NULL_FLUID_STACK = null;
    /** @deprecated by {@link #NULL_FLUID_STACK} */
    @Deprecated public static final FluidStack NF = NULL_FLUID_STACK;

    /**
     * MOD ID Strings, since they are very common Parameters.
     */
    public static final String MOD_ID_APC = "AppleCore";
    public static final String MOD_ID_AE = "appliedenergistics2";
    public static final String MOD_ID_BC_SILICON = "BuildCraft|Silicon";
    public static final String MOD_ID_BC_TRANSPORT = "BuildCraft|Transport";
    public static final String MOD_ID_BC = "BuildCraft";
    public static final String MOD_ID_BC_FACTORY = "BuildCraft|Factory";
    public static final String MOD_ID_BC_ENERGY = "BuildCraft|Energy";
    public static final String MOD_ID_BC_BUILDERS = "BuildCraft|Builders";
    public static final String MOD_ID_BC_CORE = "BuildCraft|Core";
    public static final String MOD_ID_EBXL = "ExtrabiomesXL";
    public static final String MOD_ID_EIO = "EnderIO";
    public static final String MOD_ID_FR = "Forestry";
    public static final String MOD_ID_FM = "ForbiddenMagic";
    public static final String MOD_ID_GaEn = "ganysend";
    public static final String MOD_ID_GaNe = "ganysnether";
    public static final String MOD_ID_GaSu = "ganyssurface";
    public static final String MOD_ID_GC_CORE = "GalacticraftCore";
    public static final String MOD_ID_GC_MARS = "GalacticraftMars";
    public static final String MOD_ID_GC_PLANETS = "GalacticraftPlanets";
    public static final String MOD_ID = "gregtech";
    public static final String MOD_ID_GS = "GraviSuite";
    public static final String MOD_ID_HaC = "harvestcraft";
    public static final String MOD_ID_IC2 = "IC2";
    public static final String MOD_ID_NC = "IC2NuclearControl";
    public static final String MOD_ID_MaCr = "magicalcrops";
    public static final String MOD_ID_NAT = "natura";
    public static final String MOD_ID_PFAA = "PFAAGeologica";
    public static final String MOD_ID_RC = "Railcraft";
    public static final String MOD_ID_TCON = "tconstruct";
    public static final String MOD_ID_TFC = "terrafirmacraft";
    public static final String MOD_ID_TC = "Thaumcraft";
    public static final String MOD_ID_TE = "ThermalExpansion";
    public static final String MOD_ID_TF = "TwilightForest";
    public static final String MOD_ID_UKN = "UNKNOWN";
    public static final String MOD_ID_XyC = "xycraft";

    /**
     * File Paths and Resource Paths
     */
    public static final String TEX_DIR = "textures/";
    public static final String DIR_BASICMACHINES = "basicmachines/";
    public static final String DIR_ASPECTS = "aspects/";
    public static final String DIR_BLOCKS = "blocks/";
    public static final String DIR_ENTITY = "entity/";
    public static final String DIR_GUI = "gui/";
    public static final String DIR_ICONSETS = "iconsets/";
    public static final String DIR_ITEMS = "items/";
    public static final String DIR_MATERIALICONS = "materialicons/";
    public static final String DIR_MULTIMACHINES = "multimachines/";
    public static final String TEX_DIR_GUI = TEX_DIR + DIR_GUI;
    public static final String TEX_DIR_GUI_BASICMACHINES = TEX_DIR_GUI + DIR_BASICMACHINES;
    public static final String TEX_DIR_GUI_MULTIMACHINES = TEX_DIR_GUI + DIR_MULTIMACHINES;
    public static final String TEX_DIR_ASPECTS = TEX_DIR + DIR_ASPECTS;
    public static final String TEX_DIR_BLOCK = TEX_DIR + DIR_BLOCKS;
    public static final String TEX_DIR_ENTITY = TEX_DIR + DIR_ENTITY;
    public static final String TEX_DIR_ITEM = TEX_DIR + DIR_ITEMS;
    public static final String TEX_DIR_VOID = "/void";
    public static final String RES_PATH = MOD_ID + ":" + TEX_DIR;
    public static final String RES_PATH_ASPECTS = MOD_ID + ":" + TEX_DIR_ASPECTS;
    public static final String RES_PATH_BLOCK = MOD_ID + ":";
    public static final String RES_PATH_BLOCK_ICONSETS = RES_PATH_BLOCK + DIR_ICONSETS;
    public static final String RES_PATH_ENTITY = MOD_ID + ":" + TEX_DIR_ENTITY;
    public static final String RES_PATH_GUI = MOD_ID + ":" + TEX_DIR_GUI;
    public static final String RES_PATH_GUI_BASICMACHINES = MOD_ID + ":" + TEX_DIR_GUI_BASICMACHINES;
    public static final String RES_PATH_GUI_MULTIMACHINES = MOD_ID + ":" + TEX_DIR_GUI_MULTIMACHINES;
    public static final String RES_PATH_IC2 = MOD_ID_IC2.toLowerCase() + ":";
    public static final String RES_PATH_ITEM = MOD_ID + ":";
    public static final String RES_PATH_ITEM_ICONSETS = RES_PATH_ITEM + DIR_ICONSETS;

    /**
     * The Mod Object itself. That is the GT_Mod-Object. It's needed to open GUI's and similar.
     */
    public static IGT_Mod GT_MOD_INSTANCE;
    /** @deprecated by {@link #GT_MOD_INSTANCE} */
    @Deprecated public static IGT_Mod GT;

    /**
     * Use this Object to add Recipes. (Recipe Adder)
     */
    public static IGT_RecipeAdder RECIPE_ADDER_INSTANCE;
    /** @deprecated by {@link #RECIPE_ADDER_INSTANCE} */
    @Deprecated public static IGT_RecipeAdder RA;

    /**
     * For Internal Usage (Network)
     */
    public static IGT_NetworkHandler NETWORK_HANDLER;
    /** @deprecated by {@link #NETWORK_HANDLER} */
    @Deprecated public static IGT_NetworkHandler NW;

    /**
     * Not really Constants, but they set using the Config and therefore should be constant (those are for the Debug Mode)
     */
    public static boolean DEBUG_LEVEL_1 = false;
    public static boolean DEBUG_LEVEL_2 = false;
    /** @deprecated by {@link #DEBUG_LEVEL_1} */
    @Deprecated public static boolean D1 = false;
    /** @deprecated by {@link #DEBUG_LEVEL_2} */
    @Deprecated public static boolean D2 = false;

    /**
     * If you have to give something a World Parameter but there is no World... (Dummy World)
     */
    public static World DUMMY_WORLD;
    /** @deprecated by {@link #DUMMY_WORLD} */
    @Deprecated public static World DW;
}