package gregtech.api.enums;

import gregtech.api.GregTech_API;
import gregtech.api.objects.IColorModulationContainer;
import gregtech.api.interfaces.ISubTagContainer;
import gregtech.api.objects.GT_FluidStack;
import gregtech.api.objects.MaterialStack;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_Utility;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import gregtech.api.enums.TC_Aspects.TC_AspectStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static gregtech.api.enums.GT_Values.EMPTY_STRING;
import static gregtech.api.enums.GT_Values.MATERIAL_UNIT;
import static gregtech.api.enums.TextureSet.SET_DIAMOND;
import static gregtech.api.enums.TextureSet.SET_DULL;
import static gregtech.api.enums.TextureSet.SET_EMERALD;
import static gregtech.api.enums.TextureSet.SET_FIERY;
import static gregtech.api.enums.TextureSet.SET_FINE;
import static gregtech.api.enums.TextureSet.SET_FLINT;
import static gregtech.api.enums.TextureSet.SET_FLUID;
import static gregtech.api.enums.TextureSet.SET_GEM_HORIZONTAL;
import static gregtech.api.enums.TextureSet.SET_GEM_VERTICAL;
import static gregtech.api.enums.TextureSet.SET_GLASS;
import static gregtech.api.enums.TextureSet.SET_LAPIS;
import static gregtech.api.enums.TextureSet.SET_LEAF;
import static gregtech.api.enums.TextureSet.SET_LIGNITE;
import static gregtech.api.enums.TextureSet.SET_MAGNETIC;
import static gregtech.api.enums.TextureSet.SET_METALLIC;
import static gregtech.api.enums.TextureSet.SET_NETHERSTAR;
import static gregtech.api.enums.TextureSet.SET_NONE;
import static gregtech.api.enums.TextureSet.SET_OPAL;
import static gregtech.api.enums.TextureSet.SET_PAPER;
import static gregtech.api.enums.TextureSet.SET_POWDER;
import static gregtech.api.enums.TextureSet.SET_QUARTZ;
import static gregtech.api.enums.TextureSet.SET_ROUGH;
import static gregtech.api.enums.TextureSet.SET_RUBY;
import static gregtech.api.enums.TextureSet.SET_SAND;
import static gregtech.api.enums.TextureSet.SET_SHARDS;
import static gregtech.api.enums.TextureSet.SET_SHINY;
import static gregtech.api.enums.TextureSet.SET_WOOD;

@SuppressWarnings({"squid:S1845", // Some methods and field names differ only by capitalization
})

public class Materials implements ISubTagContainer {
    public static volatile int VERSION = 508;
    public static final Collection<Materials> VALUES = new HashSet<>();

    /*
     * This is the Default Material returned in case no Material has been found or a NullPointer has been inserted at a location where it shouldn't happen.
     */
    public static Materials _NULL           = new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"NULL"							,    0,       0,          0,    0, false, false,   1,   1,   1, Dyes._NULL			, Element._NULL		, Arrays.asList(new TC_AspectStack(TC_Aspects.VACUOS, 1)));

    /**
     * Direct Elements
     */
    public static Materials Aluminium		= new Materials(19, SET_DULL				, 10.0F,    128,  2, 1|2  |8   |32|64|128                  , 128, 200, 240,   0,	"Aluminium"						,    0,       0,        933, 1700, true, false,   3,   1,   1,Dyes.dyeLightBlue	, Element.Al		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.VOLATUS, 1)));
    public static Materials Americium		= new Materials(103, SET_METALLIC			, 1.0F,      0,  3, 1|2  |8   |32                         , 200, 200, 200,   0,	"Americium"						,    0,       0,       1449,    0, false, false,   3,   1,   1,Dyes.dyeLightGray	, Element.Am		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Antimony		= new Materials(58, SET_SHINY				, 1.0F,      0,  2, 1|2  |8   |32                         , 220, 220, 240,   0,	"Antimony"						,    0,       0,        903,    0, false, false,   2,   1,   1,Dyes.dyeLightGray	, Element.Sb		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.AQUA, 1)));
    public static Materials Argon			= new Materials(24, SET_FLUID				, 1.0F,      0,  2,         16|32                         ,   0, 255,   0, 240,	"Argon"							,    0,       0,         83,    0, false, true,   5,   1,   1,Dyes.dyeGreen		, Element.Ar		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AER, 2)));
    public static Materials Arsenic			= new Materials(39, SET_DULL				, 1.0F,      0,  2, 1|2  |8|16|32                         , 255, 255, 255,   0,	"Arsenic"						,    0,       0,       1090,    0, false, false,   3,   1,   1,Dyes.dyeOrange		, Element.As		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VENENUM, 3)));
    public static Materials Barium			= new Materials(63, SET_METALLIC			, 1.0F,      0,  2, 1    |8   |32                         , 255, 255, 255,   0,	"Barium"						,    0,       0,       1000,    0, false, false,   1,   1,   1,Dyes._NULL			, Element.Ba		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VINCULUM, 3)));
    public static Materials Beryllium		= new Materials(8, SET_METALLIC			, 14.0F,     64,  2, 1|2  |8   |32|64                      , 100, 180, 100,   0,	"Beryllium"						,    0,       0,       1560,    0, false, false,   6,   1,   1,Dyes.dyeGreen		, Element.Be		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.LUCRUM, 1)));
    public static Materials Bismuth			= new Materials(90, SET_METALLIC			, 6.0F,     64,  1, 1|2  |8   |32|64|128                  , 100, 160, 160,   0,	"Bismuth"						,    0,       0,        544,    0, false, false,   2,   1,   1,Dyes.dyeCyan		, Element.Bi		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials Boron			= new Materials(9, SET_DULL				, 1.0F,      0,  2, 1    |8   |32                         , 250, 250, 250,   0,	"Boron"							,    0,       0,       2349,    0, false, false,   1,   1,   1,Dyes.dyeWhite		, Element.B			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Caesium			= new Materials(62, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 200, 60,   0,	"Caesium"						,    0,       0,        301,    0, false, false,   4,   1,   1,Dyes._NULL			, Element.Cs		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Calcium			= new Materials(26, SET_METALLIC			, 1.0F,      0,  2, 1         |32                         , 255, 245, 245,   0,	"Calcium"						,    0,       0,       1115,    0, false, false,   4,   1,   1,Dyes.dyePink		, Element.Ca		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.SANO, 1), new TC_AspectStack(TC_Aspects.TUTAMEN, 1)));
    public static Materials Carbon			= new Materials(10, SET_DULL				, 1.0F,     64,  2, 1|2       |32|64|128                  ,  20,  20,  20,   0,	"Carbon"						,    0,       0,       3800,    0, false, false,   2,   1,   1,Dyes.dyeBlack		, Element.C			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials Cadmium			= new Materials(55, SET_SHINY				, 1.0F,      0,  2, 1    |8   |32                         ,  50,  50,  60,   0,	"Cadmium"						,    0,       0,        594,    0, false, false,   3,   1,   1,Dyes.dyeGray		, Element.Cd		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 1), new TC_AspectStack(TC_Aspects.POTENTIA, 1), new TC_AspectStack(TC_Aspects.VENENUM, 1)));
    public static Materials Cerium			= new Materials(65, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Cerium"						,    0,       0,       1068, 1068, true, false,   4,   1,   1,Dyes._NULL			, Element.Ce		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Chlorine		= new Materials(23, SET_FLUID				, 1.0F,      0,  2,         16|32                         , 255, 255, 255,   0,	"Chlorine"						,    0,       0,        171,    0, false, false,   2,   1,   1,Dyes.dyeCyan		, Element.Cl		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 2), new TC_AspectStack(TC_Aspects.PANNUS, 1)));
    public static Materials Chrome			= new Materials(30, SET_SHINY				, 11.0F,    256,  3, 1|2  |8   |32|64|128                  , 255, 230, 230,   0,	"Chrome"						,    0,       0,       2180, 1700, true, false,   5,   1,   1,Dyes.dyePink		, Element.Cr		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MACHINA, 1)));
    public static Materials Cobalt			= new Materials(33, SET_METALLIC			, 8.0F,    512,  3, 1|2  |8   |32|64                      ,  80,  80, 250,   0,	"Cobalt"						,    0,       0,       1768,    0, false, false,   3,   1,   1,Dyes.dyeBlue		, Element.Co		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials Copper			= new Materials(35, SET_SHINY				, 1.0F,      0,  1, 1|2  |8   |32   |128                  , 255, 100,   0,   0,	"Copper"						,    0,       0,       1357,    0, false, false,   3,   1,   1,Dyes.dyeOrange		, Element.Cu		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.PERMUTATIO, 1)));
    public static Materials Deuterium		= new Materials(2, SET_FLUID				, 1.0F,      0,  2,         16|32                         , 255, 255,   0, 240,	"Deuterium"						,    0,       0,         14,    0, false, true,  10,   1,   1,Dyes.dyeYellow		, Element.D			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 3)));
    public static Materials Dysprosium		= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Dysprosium"					,    0,       0,       1680, 1680, true, false,   4,   1,   1,Dyes._NULL			, Element.Dy		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3)));
    public static Materials Empty			= new Materials(0, SET_NONE				, 1.0F,      0,  2, 256/*Only for Prefixes which need it*/, 255, 255, 255, 255,	"Empty"							,    0,       0,         -1,    0, false, true,   1,   1,   1,Dyes._NULL			, Element._NULL		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 2)));
    public static Materials Erbium			= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Erbium"						,    0,       0,       1802, 1802, true, false,   4,   1,   1,Dyes._NULL			, Element.Er		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Europium		= new Materials(70, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Europium"						,    0,       0,       1099, 1099, true, false,   4,   1,   1,Dyes._NULL			, Element.Eu		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Fluorine		= new Materials(14, SET_FLUID				, 1.0F,      0,  2,         16|32                         , 255, 255, 255, 127,	"Fluorine"						,    0,       0,         53,    0, false, true,   2,   1,   1,Dyes.dyeGreen		, Element.F			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PERDITIO, 2)));
    public static Materials Gadolinium		= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Gadolinium"					,    0,       0,       1585, 1585, true, false,   4,   1,   1,Dyes._NULL			, Element.Gd		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Gallium			= new Materials(37, SET_SHINY				, 1.0F,     64,  2, 1|2  |8   |32                         , 220, 220, 255,   0,	"Gallium"						,    0,       0,        302,    0, false, false,   5,   1,   1,Dyes.dyeLightGray	, Element.Ga		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ELECTRUM, 1)));
    public static Materials Gold			= new Materials(86, SET_SHINY				, 12.0F,     64,  2, 1|2  |8   |32|64|128                  , 255, 255,  30,   0,	"Gold"							,    0,       0,       1337,    0, false, false,   4,   1,   1,Dyes.dyeYellow		, Element.Au		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.LUCRUM, 2)));
    public static Materials Holmium			= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Holmium"						,    0,       0,       1734, 1734, true, false,   4,   1,   1,Dyes._NULL			, Element.Ho		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Hydrogen		= new Materials(1, SET_FLUID				, 1.0F,      0,  2,         16|32                         ,   0,   0, 255, 240,	"Hydrogen"						,    1,      15,         14,    0, false, true,   2,   1,   1,Dyes.dyeBlue		, Element.H			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)));
    public static Materials Helium			= new Materials(4, SET_FLUID				, 1.0F,      0,  2,         16|32                         , 255, 255,   0, 240,	"Helium"						,    0,       0,          1,    0, false, true,   5,   1,   1,Dyes.dyeYellow		, Element.He		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AER, 2)));
    public static Materials Helium_3		= new Materials(5, SET_FLUID				, 1.0F,      0,  2,         16|32                         , 255, 255,   0, 240,	"Helium-3"						,    0,       0,          1,    0, false, true,  10,   1,   1,Dyes.dyeYellow		, Element.He_3		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AER, 3)));
    public static Materials Indium			= new Materials(56, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         ,  64,   0, 128,   0,	"Indium"						,    0,       0,        429,    0, false, false,   4,   1,   1,Dyes.dyeGray		, Element.In		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Iridium			= new Materials(84, SET_DULL				, 6.0F,   2560,  3, 1|2  |8   |32|64|128                  , 240, 240, 245,   0,	"Iridium"						,    0,       0,       2719, 2719, true, false,  10,   1,   1,Dyes.dyeWhite		, Element.Ir		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MACHINA, 1)));
    public static Materials Iron			= new Materials(32, SET_METALLIC			, 6.0F,    256,  2, 1|2  |8   |32|64|128                  , 200, 200, 200,   0,	"Iron"							,    0,       0,       1811,    0, false, false,   3,   1,   1,Dyes.dyeLightGray	, Element.Fe		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3)));
    public static Materials Lanthanum		= new Materials(64, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 216, 224, 255,   0,	"Lanthanum"						,    0,       0,       1193, 1193, true, false,   4,   1,   1,Dyes._NULL			, Element.La		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Lead			= new Materials(89, SET_DULL				, 8.0F,     64,  1, 1|2  |8   |32|64|128                  , 140, 100, 140,   0,	"Lead"							,    0,       0,        600,    0, false, false,   3,   1,   1,Dyes.dyePurple		, Element.Pb		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ORDO, 1)));
    public static Materials Lithium			= new Materials(6, SET_DULL				, 1.0F,      0,  2, 1|2  |8   |32                         , 225, 220, 255,   0,	"Lithium"						,    0,       0,        454,    0, false, false,   4,   1,   1,Dyes.dyeLightBlue	, Element.Li		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.POTENTIA, 2)));
    public static Materials Lutetium		= new Materials(78, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Lutetium"						,    0,       0,       1925, 1925, true, false,   4,   1,   1,Dyes._NULL			, Element.Lu		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Magic			= new Materials(-128, SET_SHINY				, 8.0F,   5120,  5, 1|2|4|8|16|32|64|128                  , 100,   0, 200,   0,	"Magic"							,    5,      32,       5000,    0, false, false,   7,   1,   1,Dyes.dyePurple		, Element.Ma		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 4)));
    public static Materials Magnesium		= new Materials(18, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 200, 200,   0,	"Magnesium"						,    0,       0,        923,    0, false, false,   3,   1,   1,Dyes.dyePink		, Element.Mg		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.SANO, 1)));
    public static Materials Manganese		= new Materials(31, SET_DULL				, 7.0F,    512,  2, 1|2  |8   |32|64                      , 250, 250, 250,   0,	"Manganese"						,    0,       0,       1519,    0, false, false,   3,   1,   1,Dyes.dyeWhite		, Element.Mn		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3)));
    public static Materials Mercury			= new Materials(87, SET_SHINY				, 1.0F,      0,  0,         16|32                         , 255, 220, 220,   0,	"Mercury"						,    5,      32,        234,    0, false, false,   3,   1,   1,Dyes.dyeLightGray	, Element.Hg		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 1), new TC_AspectStack(TC_Aspects.AQUA, 1), new TC_AspectStack(TC_Aspects.VENENUM, 1)));
    public static Materials Molybdenum		= new Materials(48, SET_SHINY				, 7.0F,    512,  2, 1|2  |8   |32|64                      , 180, 180, 220,   0,	"Molybdenum"					,    0,       0,       2896,    0, false, false,   1,   1,   1,Dyes.dyeBlue		, Element.Mo		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials Neodymium		= new Materials(67, SET_METALLIC			, 7.0F,    512,  2, 1|2  |8   |32|64|128                  , 100, 100, 100,   0,	"Neodymium"						,    0,       0,       1297, 1297, true, false,   4,   1,   1,Dyes._NULL			, Element.Nd		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 2)));
    public static Materials Neutronium		= new Materials(129, SET_DULL				, 24.0F, 655360,  6, 1|2  |8   |32|64|128                  , 250, 250, 250,   0,	"Neutronium"					,    0,       0,      10000,    0, false, false,  20,   1,   1,Dyes.dyeWhite		, Element.Nt		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4), new TC_AspectStack(TC_Aspects.VITREUS, 3), new TC_AspectStack(TC_Aspects.ALIENIS, 2)));
    public static Materials Nickel			= new Materials(34, SET_METALLIC			, 6.0F,     64,  2, 1|2  |8   |32|64|128                  , 200, 200, 250,   0,	"Nickel"						,    0,       0,       1728,    0, false, false,   4,   1,   1,Dyes.dyeLightBlue	, Element.Ni		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials Niobium			= new Materials(47, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 190, 180, 200,   0,	"Niobium"						,    0,       0,       2750, 2750, true, false,   5,   1,   1,Dyes._NULL			, Element.Nb		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ELECTRUM, 1)));
    public static Materials Nitrogen		= new Materials(12, SET_FLUID				, 1.0F,      0,  2,         16|32                         ,   0, 150, 200, 240,	"Nitrogen"						,    0,       0,         63,    0, false, true,   2,   1,   1,Dyes.dyeCyan		, Element.N			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AER, 2)));
    public static Materials Osmium			= new Materials(83, SET_METALLIC			, 16.0F,   1280,  4, 1|2  |8   |32|64|128                  ,  50,  50, 255,   0,	"Osmium"						,    0,       0,       3306, 3306, true, false,  10,   1,   1,Dyes.dyeBlue		, Element.Os		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MACHINA, 1), new TC_AspectStack(TC_Aspects.NEBRISUM, 1)));
    public static Materials Oxygen			= new Materials(13, SET_FLUID				, 1.0F,      0,  2,         16|32                         ,   0, 100, 200, 240,	"Oxygen"						,    0,       0,         54,    0, false, true,   1,   1,   1,Dyes.dyeWhite		, Element.O			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AER, 1)));
    public static Materials Palladium		= new Materials(52, SET_SHINY				, 8.0F,    512,  2, 1|2  |8   |32|64|128                  , 128, 128, 128,   0,	"Palladium"						,    0,       0,       1828, 1828, true, false,   4,   1,   1,Dyes.dyeGray		, Element.Pd		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3)));
    public static Materials Phosphor		= new Materials(21, SET_DULL				, 1.0F,      0,  2, 1    |8   |32                         , 255, 255,   0,   0,	"Phosphor"						,    0,       0,        317,    0, false, false,   2,   1,   1,Dyes.dyeYellow		, Element.P			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 2), new TC_AspectStack(TC_Aspects.POTENTIA, 1)));
    public static Materials Platinum		= new Materials(85, SET_SHINY				, 12.0F,     64,  2, 1|2  |8   |32|64|128                  , 255, 255, 200,   0,	"Platinum"						,    0,       0,       2041,    0, false, false,   6,   1,   1,Dyes.dyeOrange		, Element.Pt		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.NEBRISUM, 1)));
    public static Materials Plutonium		= new Materials(100, SET_METALLIC			, 6.0F,    512,  3, 1|2  |8   |32|64                      , 240,  50,  50,   0,	"Plutonium 244"					,    0,       0,        912,    0, false, false,   6,   1,   1,Dyes.dyeLime		, Element.Pu		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 2)));
    public static Materials Plutonium241	= new Materials(101, SET_SHINY				, 6.0F,    512,  3, 1|2  |8   |32|64                      , 250,  70,  70,   0,	"Plutonium 241"					,    0,       0,        912,    0, false, false,   6,   1,   1,Dyes.dyeLime		, Element.Pu_241	, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 3)));
    public static Materials Potassium		= new Materials(25, SET_METALLIC			, 1.0F,      0,  1, 1|2       |32                         , 250, 250, 250,   0,	"Potassium"						,    0,       0,        336,    0, false, false,   2,   1,   1,Dyes.dyeWhite		, Element.K			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.POTENTIA, 1)));
    public static Materials Praseodymium	= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Praseodymium"					,    0,       0,       1208, 1208, true, false,   4,   1,   1,Dyes._NULL			, Element.Pr		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Promethium		= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Promethium"					,    0,       0,       1315, 1315, true, false,   4,   1,   1,Dyes._NULL			, Element.Pm		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Radon			= new Materials(93, SET_FLUID				, 1.0F,      0,  2,         16|32                         , 255,   0, 255, 240,	"Radon"							,    0,       0,        202,    0, false, true,   5,   1,   1,Dyes.dyePurple		, Element.Rn		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AER, 1), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Rubidium		= new Materials(43, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 240,  30,  30,   0,	"Rubidium"						,    0,       0,        312,    0, false, false,   4,   1,   1,Dyes.dyeRed			, Element.Rb		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.VITREUS, 1)));
    public static Materials Samarium		= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Samarium"						,    0,       0,       1345, 1345, true, false,   4,   1,   1,Dyes._NULL			, Element.Sm		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Scandium		= new Materials(27, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Scandium"						,    0,       0,       1814, 1814, true, false,   2,   1,   1,Dyes.dyeYellow		, Element.Sc		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Silicon			= new Materials(20, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         ,  60,  60,  80,   0,	"Silicon"						,    0,       0,       1687, 1687, true, false,   1,   1,   1,Dyes.dyeBlack		, Element.Si		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.TENEBRAE, 1)));
    public static Materials Silver			= new Materials(54, SET_SHINY				, 10.0F,     64,  2, 1|2  |8   |32|64|128                  , 220, 220, 255,   0,	"Silver"						,    0,       0,       1234,    0, false, false,   3,   1,   1,Dyes.dyeLightGray	, Element.Ag		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.LUCRUM, 1)));
    public static Materials Sodium			= new Materials(17, SET_METALLIC			, 1.0F,      0,  2, 1         |32                         ,   0,   0, 150,   0,	"Sodium"						,    0,       0,        370,    0, false, false,   1,   1,   1,Dyes.dyeBlue		, Element.Na		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2), new TC_AspectStack(TC_Aspects.LUX, 1)));
    public static Materials Strontium		= new Materials(44, SET_METALLIC			, 1.0F,      0,  2, 1    |8   |32                         , 200, 200, 200,   0,	"Strontium"						,    0,       0,       1050,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Element.Sr		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.STRONTIO, 1)));
    public static Materials Sulfur			= new Materials(22, SET_DULL				, 1.0F,      0,  2, 1    |8   |32                         , 200, 200,   0,   0,	"Sulfur"						,    0,       0,        388,    0, false, false,   2,   1,   1,Dyes.dyeYellow		, Element.S			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials Tantalum		= new Materials(80, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Tantalum"						,    0,       0,       3290,    0, false, false,   4,   1,   1,Dyes._NULL			, Element.Ta		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.VINCULUM, 1)));
    public static Materials Tellurium		= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Tellurium"						,    0,       0,        722,    0, false, false,   4,   1,   1,Dyes.dyeGray		, Element.Te		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Terbium			= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Terbium"						,    0,       0,       1629, 1629, true, false,   4,   1,   1,Dyes._NULL			, Element.Tb		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Thorium			= new Materials(96, SET_SHINY				, 6.0F,    512,  2, 1|2  |8   |32|64                      ,   0,  30,   0,   0,	"Thorium"						,    0,       0,       2115,    0, false, false,   4,   1,   1,Dyes.dyeBlack		, Element.Th		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Thulium			= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Thulium"						,    0,       0,       1818, 1818, true, false,   4,   1,   1,Dyes._NULL			, Element.Tm		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Tin				= new Materials(57, SET_DULL				, 1.0F,      0,  1, 1|2  |8   |32   |128                  , 220, 220, 220,   0,	"Tin"							,    0,       0,        505,  505, false, false,   3,   1,   1,Dyes.dyeWhite		, Element.Sn		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.VITREUS, 1)));
    public static Materials Titanium		= new Materials(28, SET_METALLIC			, 7.0F,   1600,  3, 1|2  |8   |32|64|128                  , 220, 160, 240,   0,	"Titanium"						,    0,       0,       1941, 1940, true, false,   5,   1,   1,Dyes.dyePurple		, Element.Ti		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.TUTAMEN, 1)));
    public static Materials Tritium			= new Materials(3, SET_METALLIC			, 1.0F,      0,  2,         16|32                         , 255,   0,   0, 240,	"Tritium"						,    0,       0,         14,    0, false, true,  10,   1,   1,Dyes.dyeRed			, Element.T			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 4)));
    public static Materials Tungsten		= new Materials(81, SET_METALLIC			, 7.0F,   2560,  3, 1|2  |8   |32|64|128                  ,  50,  50,  50,   0,	"Tungsten"						,    0,       0,       3695, 3000, true, false,   4,   1,   1,Dyes.dyeBlack		, Element.W			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3), new TC_AspectStack(TC_Aspects.TUTAMEN, 1)));
    public static Materials Uranium			= new Materials(98, SET_METALLIC			, 6.0F,    512,  3, 1|2  |8   |32|64                      ,  50, 240,  50,   0,	"Uranium 238"					,    0,       0,       1405,    0, false, false,   4,   1,   1,Dyes.dyeGreen		, Element.U			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Uranium235		= new Materials(97, SET_SHINY				, 6.0F,    512,  3, 1|2  |8   |32|64                      ,  70, 250,  70,   0,	"Uranium 235"					,    0,       0,       1405,    0, false, false,   4,   1,   1,Dyes.dyeGreen		, Element.U_235		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 2)));
    public static Materials Vanadium		= new Materials(29, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         ,  50,  50,  50,   0,	"Vanadium"						,    0,       0,       2183, 2183, true, false,   2,   1,   1,Dyes.dyeBlack		, Element.V			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Ytterbium		= new Materials(-1, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 255, 255, 255,   0,	"Ytterbium"						,    0,       0,       1097, 1097, true, false,   4,   1,   1,Dyes._NULL			, Element.Yb		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Yttrium			= new Materials(45, SET_METALLIC			, 1.0F,      0,  2, 1|2  |8   |32                         , 220, 250, 220,   0,	"Yttrium"						,    0,       0,       1799, 1799, true, false,   4,   1,   1,Dyes._NULL			, Element.Y			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.RADIO, 1)));
    public static Materials Zinc			= new Materials(36, SET_METALLIC			, 1.0F,      0,  1, 1|2  |8   |32                         , 250, 240, 240,   0,	"Zinc"							,    0,       0,        692,    0, false, false,   2,   1,   1,Dyes.dyeWhite		, Element.Zn		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.SANO, 1)));

    /**
     * The "Random Material" ones.
     */
    public static Materials Organic			= new Materials(  -1, SET_LEAF				,   1.0F,      0,  1, false);
    public static Materials AnyCopper		= new Materials(  -1, SET_SHINY				,   1.0F,      0,  3, false);
    public static Materials AnyBronze		= new Materials(  -1, SET_SHINY				,   1.0F,      0,  3, false);
    public static Materials AnyIron			= new Materials(  -1, SET_SHINY				,   1.0F,      0,  3, false);
    public static Materials Crystal			= new Materials(  -1, SET_SHINY				,   1.0F,      0,  3, false);
    public static Materials Quartz			= new Materials(  -1, SET_QUARTZ			,   1.0F,      0,  2, false);
    public static Materials Metal			= new Materials(  -1, SET_METALLIC			,   1.0F,      0,  2, false);
    public static Materials Unknown			= new Materials(  -1, SET_DULL				,   1.0F,      0,  2, false);
    public static Materials Cobblestone		= new Materials(  -1, SET_DULL				,   1.0F,      0,  1, false);
    public static Materials Brick			= new Materials(  -1, SET_DULL				,   1.0F,      0,  1, false);
    public static Materials BrickNether		= new Materials(  -1, SET_DULL				,   1.0F,      0,  1, false);

    /**
     * The "I don't care" Section, everything I don't want to do anything with right now, is right here. Just to make the Material Finder shut up about them.
     * But I do see potential uses in some of these Materials.
     */
    public static Materials TarPitch		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Tar Pitch"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Serpentine		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2  |8                               , 255, 255, 255,   0,	"Serpentine"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Flux			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Flux"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials RedstoneAlloy	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Redstone Alloy"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials OsmiumTetroxide	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Osmium Tetroxide"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials NitricAcid		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Nitric Acid"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials RubberTreeSap	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Rubber Tree Sap"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials AquaRegia		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Aqua Regia"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials SolutionBlueVitriol = new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Blue Vitriol Solution"			,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials SolutionNickelSulfate = new Materials( -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Nickel Sulfate Solution"		,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Signalum		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Signalum"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Lumium			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Lumium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials PhasedIron		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Phased Iron"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials PhasedGold		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Phased Gold"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Soularium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Soularium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Endium			= new Materials( 770, SET_DULL				,   1.0F,      0,  2, 1|2  |8                               , 165, 220, 250,   0,	"Endium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow	);
    public static Materials Prismarine		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1  |4                                 , 255, 255, 255,   0,	"Prismarine"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials GraveyardDirt	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Graveyard Dirt"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials DarkSteel		= new Materials( 364, SET_DULL				,   8.0F,    512,  3, 1|2  |8      |64                      ,  80,  70,  80,   0,	"Dark Steel"					,    0,       0,       1811,    0, false, false,   5,   1,   1, Dyes.dyePurple	);
    public static Materials Terrasteel		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Terrasteel"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials ConductiveIron	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Conductive Iron"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials ElectricalSteel	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Electrical Steel"				,    0,       0,       1811, 1000, true, false,   3,   1,   1, Dyes._NULL		);
    public static Materials EnergeticAlloy	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Energetic Alloy"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials VibrantAlloy	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Vibrant Alloy"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials PulsatingIron	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Pulsating Iron"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);

    public static Materials Graphene        = new Materials(819, SET_DULL                 ,   6.0F, 32, 1,  1 | 2 | 8 | 16 | 32 | 64 | 128        , 128, 128, 128,   0,          "Graphene"                    ,    0,       0,         -1,    0, false, false, 3, 1, 1, Dyes.dyeGray, Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 2), new TC_AspectStack(TC_Aspects.ELECTRUM, 1)));
    public static Materials Bedrockium      = new Materials(-1, SET_FINE, 8.0F, 8196, 3, 1 | 2 | 16 | 32 | 64 | 128, 39, 39, 39, 0, "Bedrockium", 0, 0, -1, 0, false, false, 1, 5, 1, Dyes.dyeLightGray, 2, Arrays.asList(new MaterialStack(Carbon, 63), new MaterialStack(Carbon, 56)),   Arrays.asList(new TC_AspectStack(TC_Aspects.VACUOS, 8), new TC_AspectStack(TC_Aspects.TUTAMEN, 3)));


    public static Materials Fluix			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1  |4                                 , 255, 255, 255,   0,	"Fluix"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Manasteel		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Manasteel"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Tennantite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Tennantite"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials DarkThaumium	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Dark Thaumium"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Alfium			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Alfium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Ryu				= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Ryu"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Mutation		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Mutation"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Aquamarine		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1  |4                                 , 255, 255, 255,   0,	"Aquamarine"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Ender			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Ender"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials ElvenElementium	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Elven Elementium"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials EnrichedCopper	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Enriched Copper"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials DiamondCopper	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Diamond Copper"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials SodiumPeroxide	= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Sodium Peroxide"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials IridiumSodiumOxide= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Iridium Sodium Oxide"			,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    //public static Materials PlatinumGroupSludge= new Materials( 241, SET_POWDER			,   1.0F,      0,  2, 1                                     ,   0,  30,   0,   0,	"Platinum Group Sludge"			,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Fairy			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Fairy"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Ludicrite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Ludicrite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Pokefennium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Pokefennium"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Draconium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Draconium"					    ,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials DraconiumAwakened= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Awakened Draconium"			,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials InfusedTeslatite= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0	                                    , 100, 180, 255,   0,	"Infused Teslatite"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL);

    /**
     * Unknown Material Components. Dead End Section.
     */
    public static Materials Adamantium		= new Materials( 319, SET_SHINY				,  10.0F,   5120,  5, 1|2  |8      |64|128                  , 255, 255, 255,   0,	"Adamantium"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray);
    public static Materials Adamite			= new Materials(  -1, SET_NONE				,   1.0F,      0,  3, 1    |8                               , 255, 255, 255,   0,	"Adamite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray);
    public static Materials Adluorite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1    |8                               , 255, 255, 255,   0,	"Adluorite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Agate			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Agate"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Alduorite		= new Materials( 485, SET_SHINY  			    ,   1.0F,      0,  2, 1    |8|16                            , 159, 180, 180,   0,	"Alduorite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Amber			= new Materials(514, SET_RUBY				    ,   4.0F,128,  2, 1  |4|8      |64                      , 255, 128,   0, 127,	"Amber"							,    5,       3,         -1,    0, false, true,   1,   1,   1,Dyes.dyeOrange		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VINCULUM, 2), new TC_AspectStack(TC_Aspects.VITREUS, 1)));
    public static Materials Ammonium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Ammonium"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Amordrine		= new Materials(  -1, SET_NONE				,   6.0F,     64,  2, 1|2  |8|16      |64                   , 255, 255, 255,   0,	"Amordrine"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Andesite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1    |8                               , 255, 255, 255,   0,	"Andesite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Angmallen		= new Materials( 958, SET_METALLIC			,  10.0F,    128,  2, 1|2  |8|16   |64                      , 215, 225, 138,   0,	"Angmallen"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Ardite			= new Materials(  -1, SET_NONE				,   6.0F,     64,  2, 1|2  |8      |64                      , 255,   0,   0,   0,	"Ardite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Aredrite		= new Materials(  -1, SET_NONE				,   6.0F,     64,  2, 1|2  |8      |64                      , 255,   0,   0,   0,	"Aredrite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Atlarus			= new Materials( 965, SET_METALLIC			,   6.0F,     64,  2, 1|2  |8      |64                      , 255, 255, 255,   0,	"Atlarus"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Bitumen			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1    |8                               , 255, 255, 255,   0,	"Bitumen"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Black			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     ,   0,   0,   0,   0,	"Black"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlack	);
    public static Materials Blizz			= new Materials( 851, SET_SHINY				,   1.0F,      0,  2, 1                                     , 220, 233, 255,   0,	"Blizz"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Blueschist		= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Blue Schist"					,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeLightBlue);
    public static Materials Bluestone		= new Materials( 813, SET_DULL				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Bluestone"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue	);
    public static Materials Bloodstone		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Bloodstone"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeRed		);
    public static Materials Blutonium		= new Materials(  -1, SET_SHINY				,   1.0F,      0,  2, 1|2  |8                               ,   0,   0, 255,   0,	"Blutonium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlue	);
    public static Materials Carmot			= new Materials( 962, SET_METALLIC			,  16.0F,    128,  1, 1|2  |8      |64                      , 217, 205, 140,   0,	"Carmot"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Celenegil		= new Materials( 964, SET_METALLIC			,  10.0F,   4096,  2, 1|2  |8|16      |64                   , 148, 204,  72,   0,	"Celenegil"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials CertusQuartz	= new Materials(516, SET_QUARTZ			, 5.0F,     32,  1, 1  |4|8      |64                      , 210, 210, 230,   0,	"Certus Quartz"					,    0,       0,         -1,    0, false, false,   3,   1,   1,Dyes.dyeLightGray	, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 1), new TC_AspectStack(TC_Aspects.VITREUS, 1)));
    public static Materials Ceruclase		= new Materials( 952, SET_METALLIC			,   6.0F,   1280,  2, 1|2  |8                               , 140, 189, 208,   0,	"Ceruclase"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Citrine			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Citrine"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials CobaltHexahydrate= new Materials( -1, SET_METALLIC			,   1.0F,      0,  2, 1      |16                            ,  80,  80, 250,   0,	"Cobalt Hexahydrate"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue	);
    public static Materials ConstructionFoam= new Materials( 854, SET_DULL				,   1.0F,      0,  2, 1      |16                            , 128, 128, 128,   0,	"Construction Foam"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray	);
    public static Materials Chert			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Chert"							,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes._NULL		);
    public static Materials Chimerite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Chimerite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Coral			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 128, 255,   0,	"Coral"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials CrudeOil		= new Materials( 858, SET_DULL				,   1.0F,      0,  2, 1                                     ,  10,  10,  10,   0,	"Crude Oil"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    public static Materials Chrysocolla		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Chrysocolla"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials CrystalFlux		= new Materials(  -1, SET_QUARTZ			,   1.0F,      0,  3, 1  |4                                 , 100,  50, 100,   0,	"Flux Crystal"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Cyanite			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Cyanite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeCyan	);
    public static Materials Dacite			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Dacite"						,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeLightGray);
    public static Materials DarkIron		= new Materials( 342, SET_DULL				,   7.0F,    384,  3, 1|2  |8      |64                      ,  55,  40,  60,   0,	"Dark Iron"						,    0,       0,         -1,    0, false, false,   5,   1,   1, Dyes.dyePurple	);
    public static Materials DarkStone		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Dark Stone"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlack	);
    public static Materials Demonite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Demonite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeRed		);
    public static Materials Desh			= new Materials( 884, SET_DULL				,   1.0F,   1280,  3, 1|2  |8      |64|128                  ,  40,  40,  40,   0,	"Desh"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    public static Materials Desichalkos		= new Materials(  -1, SET_NONE				,   6.0F,   1280,  3, 1|2  |8|16      |64                   , 255, 255, 255,   0,	"Desichalkos"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Dilithium		= new Materials( 515, SET_DIAMOND			,   1.0F,      0,  1, 1  |4|8|16                            , 255, 250, 250, 127,	"Dilithium"						,    0,       0,         -1,    0, false, true,   1,   1,   1, Dyes.dyeWhite	);
    public static Materials Draconic		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Draconic"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed		);
    public static Materials Drulloy			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|16                                  , 255, 255, 255,   0,	"Drulloy"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed		);
    public static Materials Duranium		= new Materials( 328, SET_METALLIC			,   8.0F,   1280,  4, 1|2          |64                      , 255, 255, 255,   0,	"Duranium"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray);
    public static Materials Eclogite		= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Eclogite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials ElectrumFlux	= new Materials( 320, SET_SHINY				,  16.0F,    512,  3, 1|2          |64                      , 255, 255, 120,   0,	"Fluxed Electrum"				,    0,       0,       3000, 3000, true, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Emery			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 255, 255, 255,   0,	"Emery"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Enderium		= new Materials(321, SET_DULL				, 8.0F,    256,  3, 1|2          |64                      ,  89, 145, 135,   0,	"Enderium"						,    0,       0,       3000, 3000, true, false,   1,   1,   1,Dyes.dyeGreen		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ALIENIS, 1)));
    public static Materials EnderiumBase	= new Materials(-1, SET_DULL				, 8.0F,    256,  3, 1|2          |64                      ,  89, 145, 135,   0,	"Enderium Base"					,    0,       0,       3000, 3000, true, false,   1,   1,   1,Dyes.dyeGreen		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ALIENIS, 1)));
    public static Materials Energized		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Energized"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Epidote			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Epidote"						,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes._NULL		);
    public static Materials Eximite			= new Materials( 959, SET_METALLIC			,   5.0F,   2560,  3, 1|2  |8      |64                      , 124,  90, 150,   0,	"Eximite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials FierySteel		= new Materials(346, SET_FIERY				, 8.0F,    256,  3, 1|2    |16   |64|128                  ,  64,   0,   0,   0,	"Fiery Steel"					,    5,    2048,       1811, 1000, true, false,   1,   1,   1,Dyes.dyeRed			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 3), new TC_AspectStack(TC_Aspects.IGNIS, 3), new TC_AspectStack(TC_Aspects.CORPUS, 3)));
    public static Materials Firestone		= new Materials( 347, SET_QUARTZ			,   6.0F,   1280,  3, 1  |4|8      |64                      , 200,  20,   0,   0,	"Firestone"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeRed		);
    public static Materials Fluorite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1    |8                               , 255, 255, 255,   0,	"Fluorite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeGreen	);
    public static Materials FoolsRuby		= new Materials(512, SET_RUBY				, 1.0F,      0,  2, 1  |4|8                               , 255, 100, 100, 127,	"Ruby"							,    0,       0,         -1,    0, false, true,   3,   1,   1,Dyes.dyeRed			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 2), new TC_AspectStack(TC_Aspects.VITREUS, 2)));
    public static Materials Forcicium		= new Materials(518, SET_DIAMOND			, 1.0F,      0,  1, 1  |4|8|16                            ,  50,  50,  70,   0,	"Forcicium"						,    0,       0,         -1,    0, false, false,   3,   1,   1,Dyes.dyeGreen		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 2)));
    public static Materials Forcillium		= new Materials(519, SET_DIAMOND			, 1.0F,      0,  1, 1  |4|8|16                            ,  50,  50,  70,   0,	"Forcillium"					,    0,       0,         -1,    0, false, false,   3,   1,   1,Dyes.dyeGreen		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 2)));
    public static Materials Gabbro			= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Gabbro"						,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes._NULL		);
    public static Materials Glowstone		= new Materials(811, SET_SHINY				, 1.0F,      0,  1, 1      |16                            , 255, 255,   0,   0,	"Glowstone"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeYellow		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.LUX, 2), new TC_AspectStack(TC_Aspects.SENSUS, 1)));
    public static Materials Gneiss			= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Gneiss"						,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes._NULL		);
    public static Materials Graphite		= new Materials(865, SET_DULL				, 5.0F,     32,  2, 1    |8|16   |64                      , 128, 128, 128,   0,	"Graphite"						,    0,       0,         -1,    0, false, false,   3,   1,   1,Dyes.dyeGray		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 2), new TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials Greenschist		= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Green Schist"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGreen	);
    public static Materials Greenstone		= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Greenstone"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGreen	);
    public static Materials Greywacke		= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Greywacke"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray	);
    public static Materials Haderoth		= new Materials( 963, SET_METALLIC			,  10.0F,   3200,  3, 1|2  |8|16      |64                   , 119,  52,  30,   0,	"Haderoth"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Hematite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2  |8                               , 255, 255, 255,   0,	"Hematite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Hepatizon		= new Materials( 957, SET_METALLIC			,  12.0F,    128,  2, 1|2  |8|16      |64                   , 117,  94, 117,   0,	"Hepatizon"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials HSLA			= new Materials(322, SET_METALLIC			, 6.0F,    500,  2, 1|2          |64|128                  , 128, 128, 128,   0,	"HSLA Steel"					,    0,       0,       1811, 1000, true, false,   3,   1,   1,Dyes._NULL			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 1), new TC_AspectStack(TC_Aspects.ORDO, 1)));
    public static Materials Ignatius		= new Materials( -1, SET_METALLIC			,  12.0F,    512,  2, 1|2    |16                            , 255, 169,  83,   0,	"Ignatius"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Infernal		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 0                                     , 255, 255, 255,   0,	"Infernal"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Infuscolium		= new Materials( 490, SET_METALLIC			,   6.0F,     64,  2, 1|2  |8|16   |64                      , 146,  33,  86,   0,	"Infuscolium"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials InfusedGold		= new Materials( 323, SET_SHINY				,  12.0F,     64,  3, 1|2  |8      |64|128                  , 255, 200,  60,   0,	"Infused Gold"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow	);
    public static Materials InfusedAir		= new Materials(540, SET_SHARDS			, 8.0F,     64,  3, 1  |4|8      |64|128                  , 255, 255,   0,   0,	"Aer"							,    5,     160,         -1,    0, false, true,   3,   1,   1,Dyes.dyeYellow		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.AER, 2)));
    public static Materials InfusedFire		= new Materials(541, SET_SHARDS			, 8.0F,     64,  3, 1  |4|8      |64|128                  , 255,   0,   0,   0,	"Ignis"							,    5,     320,         -1,    0, false, true,   3,   1,   1,Dyes.dyeRed			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.IGNIS, 2)));
    public static Materials InfusedEarth	= new Materials(542, SET_SHARDS			, 8.0F,    256,  3, 1  |4|8      |64|128                  ,   0, 255,   0,   0,	"Terra"							,    5,     160,         -1,    0, false, true,   3,   1,   1,Dyes.dyeGreen		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.TERRA, 2)));
    public static Materials InfusedWater	= new Materials(543, SET_SHARDS			, 8.0F,     64,  3, 1  |4|8      |64|128                  ,   0,   0, 255,   0,	"Aqua"							,    5,     160,         -1,    0, false, true,   3,   1,   1,Dyes.dyeBlue		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.AQUA, 2)));
    public static Materials InfusedEntropy	= new Materials(544, SET_SHARDS			, 32.0F,     64,  4, 1  |4|8      |64|128                  ,  62,  62,  62,   0,	"Perditio"						,    5,     320,         -1,    0, false, true,   3,   1,   1,Dyes.dyeBlack		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.PERDITIO, 2)));
    public static Materials InfusedOrder	= new Materials(545, SET_SHARDS			, 8.0F,     64,  3, 1  |4|8      |64|128                  , 252, 252, 252,   0,	"Ordo"							,    5,     240,         -1,    0, false, true,   3,   1,   1,Dyes.dyeWhite		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.ORDO, 2)));
    public static Materials InfusedVis		= new Materials(-1, SET_SHARDS			, 8.0F,     64,  3, 1  |4|8      |64|128                  , 255,   0, 255,   0,	"Auram"							,    5,     240,         -1,    0, false, true,   3,   1,   1,Dyes.dyePurple		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.AURAM, 2)));
    public static Materials InfusedDull		= new Materials(-1, SET_SHARDS			, 32.0F,     64,  3, 1  |4|8      |64|128                  , 100, 100, 100,   0,	"Vacuus"						,    5,     160,         -1,    0, false, true,   3,   1,   1,Dyes.dyeLightGray	, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PRAECANTATIO, 1), new TC_AspectStack(TC_Aspects.VACUOS, 2)));
    public static Materials Inolashite		= new Materials( 954, SET_NONE				,   8.0F,   2304,  3, 1|2  |8|16      |64                   , 148, 216, 187,   0,	"Inolashite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Invisium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1                                     , 255, 255, 255,   0,	"Invisium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Jade			= new Materials(537, SET_SHINY				, 1.0F,      0,  2, 1    |8                               ,   0, 100,   0,   0,	"Jade"							,    0,       0,         -1,    0, false, false,   5,   1,   1,Dyes.dyeGreen		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 6), new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Jasper			= new Materials(511, SET_EMERALD			, 1.0F,      0,  2, 1  |4|8                               , 200,  80,  80, 100,	"Jasper"						,    0,       0,         -1,    0, false, true,   3,   1,   1,Dyes.dyeRed			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.LUCRUM, 4), new TC_AspectStack(TC_Aspects.VITREUS, 2)));
    public static Materials Kalendrite		= new Materials( -1, SET_METALLIC			,   5.0F,   2560,  3, 1|2    |16                            , 170,  91, 189,   0,	"Kalendrite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Komatiite		= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Komatiite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Lava			= new Materials( 700, SET_FLUID				,   1.0F,      0,  1,         16                            , 255,  64,   0,   0,	"Lava"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange	);
    public static Materials Lemurite		= new Materials( -1, SET_METALLIC			,   1.0F,      0,  2, 1    |16                              , 219, 219, 219,   0,	"Lemurite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Limestone		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Limestone"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Lodestone		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1    |8                               , 255, 255, 255,   0,	"Lodestone"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Luminite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1    |8                               , 250, 250, 250,   0,	"Luminite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeWhite	);
    public static Materials Magma			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255,  64,   0,   0,	"Magma"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange	);
    public static Materials Mawsitsit		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Mawsitsit"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Mercassium		= new Materials(  -1, SET_NONE				,   6.0F,     64,  1, 1|2  |8      |64                      , 255, 255, 255,   0,	"Mercassium"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials MeteoricIron	= new Materials(340, SET_METALLIC			, 6.0F,    384,  2, 1|2  |8      |64                      , 100,  50,  80,   0,	"Meteoric Iron"					,    0,       0,       1811,    0, false, false,   1,   1,   1,Dyes.dyeGray		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials MeteoricSteel	= new Materials(341, SET_METALLIC			, 6.0F,    768,  2, 1|2          |64                      ,  50,  25,  40,   0,	"Meteoric Steel"				,    0,       0,       1811, 1000, true, false,   1,   1,   1,Dyes.dyeGray		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1), new TC_AspectStack(TC_Aspects.ORDO, 1)));
    public static Materials Meteorite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1    |8                               ,  80,  35,  60,   0,	"Meteorite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePurple	);
    public static Materials Meutoite		= new Materials( -1, SET_METALLIC			,   1.0F,      0,  1, 1    |8|16                            ,  95,  82, 105,   0,	"Meutoite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Migmatite		= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Migmatite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Mimichite		= new Materials(  -1, SET_GEM_VERTICAL		,   1.0F,      0,  1, 1  |4|8                               , 255, 255, 255,   0,	"Mimichite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Moonstone		= new Materials(-1, SET_NONE				, 1.0F,      0,  1, 1    |8                               , 255, 255, 255,   0,	"Moonstone"						,    0,       0,         -1,    0, false, false,   3,   1,   1,Dyes.dyeWhite		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.ALIENIS, 1)));
    public static Materials Naquadah		= new Materials(324, SET_METALLIC			, 6.0F,   1280,  4, 1|2  |8|16   |64                      ,  50,  50,  50,   0,	"Naquadah"						,    0,       0,       5400, 5400, true, false,  10,   1,   1,Dyes.dyeBlack		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3), new TC_AspectStack(TC_Aspects.RADIO, 1), new TC_AspectStack(TC_Aspects.NEBRISUM, 1)));
    public static Materials NaquadahAlloy	= new Materials(325, SET_METALLIC			, 8.0F,   5120,  5, 1|2          |64|128                  ,  40,  40,  40,   0,	"Naquadah Alloy"				,    0,       0,       7200, 7200, true, false,  10,   1,   1,Dyes.dyeBlack		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4), new TC_AspectStack(TC_Aspects.NEBRISUM, 1)));
    public static Materials NaquadahEnriched= new Materials(326, SET_METALLIC			, 6.0F,   1280,  4, 1|2  |8|16   |64                      ,  50,  50,  50,   0,	"Enriched Naquadah"				,    0,       0,       4500, 4500, true, false,  15,   1,   1,Dyes.dyeBlack		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 3), new TC_AspectStack(TC_Aspects.RADIO, 2), new TC_AspectStack(TC_Aspects.NEBRISUM, 2)));
    public static Materials Naquadria		= new Materials(327, SET_SHINY				, 1.0F,    512,  4, 1|2  |8      |64                      ,  30,  30,  30,   0,	"Naquadria"						,    0,       0,       9000, 9000, true, false,  20,   1,   1,Dyes.dyeBlack		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4), new TC_AspectStack(TC_Aspects.RADIO, 3), new TC_AspectStack(TC_Aspects.NEBRISUM, 3)));
    public static Materials Nether			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Nether"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials NetherBrick		= new Materials(814, SET_DULL				, 1.0F,      0,  1, 1                                     , 100,   0,   0,   0,	"Nether Brick"					,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeRed			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials NetherQuartz	= new Materials(522, SET_QUARTZ			, 1.0F,     32,  1, 1  |4|8      |64                      , 230, 210, 210,   0,	"Nether Quartz"					,    0,       0,         -1,    0, false, false,   2,   1,   1,Dyes.dyeWhite		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 1), new TC_AspectStack(TC_Aspects.VITREUS, 1)));
    public static Materials NetherStar		= new Materials( 506, SET_NETHERSTAR		,   1.0F,   5120,  4, 1  |4        |64                      , 255, 255, 255,   0,	"Nether Star"					,    5,   50000,         -1,    0, false, false,  15,   1,   1, Dyes.dyeWhite	);

    public static Materials Teslatite       = new Materials(812, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 8, 60, 180, 200, 0, "Teslatite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeCyan, Arrays.asList(new TC_AspectStack(TC_Aspects.ELECTRUM, 2)));


    public static Materials ObsidianFlux	= new Materials(  -1, SET_DULL				,   1.0F,      0,  1, 1|2                                   ,  80,  50, 100,   0,	"Fluxed Obsidian"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePurple	);
    public static Materials Oilsands		= new Materials( 878, SET_NONE				,   1.0F,      0,  1, 1    |8                               ,  10,  10,  10,   0,	"Oilsands"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Onyx			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Onyx"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Orichalcum		= new Materials( -1, SET_METALLIC			,   4.5F,   3456,  3, 1|2  |8      |64                      ,  84, 122,  56,   0,	"Orichalcum"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Osmonium		= new Materials(  -1, SET_NONE				,   6.0F,     64,  1, 1|2  |8      |64                      , 255, 255, 255,   0,	"Osmonium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlue	);
    public static Materials Oureclase		= new Materials( -1, SET_METALLIC			,   6.0F,   1920,  3, 1|2  |8      |64                      , 183,  98,  21,   0,	"Oureclase"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Painite			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Painite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Peanutwood		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Peanut Wood"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Petroleum		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1    |8                               , 255, 255, 255,   0,	"Petroleum"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Pewter			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Pewter"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Phoenixite		= new Materials(  -1, SET_NONE				,   6.0F,     64,  1, 1|2  |8      |64                      , 255, 255, 255,   0,	"Phoenixite"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Potash			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Potash"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Prometheum		= new Materials( -1, SET_METALLIC			,   8.0F,    512,  1, 1|2  |8      |64                      ,  90, 129,  86,   0,	"Prometheum"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Quartzite		= new Materials( 523, SET_QUARTZ			,   1.0F,      0,  1, 1  |4|8                               , 210, 230, 210,   0,	"Quartzite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeWhite	);
    public static Materials Quicklime		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Quicklime"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Randomite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1    |8                               , 255, 255, 255,   0,	"Randomite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Rhyolite		= new Materials( 875, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Rhyolite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Rubracium		= new Materials( -1, SET_METALLIC			,   1.0F,      0,  1, 1    |8|16                            , 151,  45,  45,   0,	"Rubracium"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Sand			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Sand"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Sanguinite		= new Materials( -1, SET_METALLIC			,   3.0F,   4480,  4, 1|2  |8                               , 185,   0,   0,   0,	"Sanguinite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Siltstone		= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Siltstone"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Spinel			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     , 255, 255, 255,   0,	"Spinel"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Starconium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1|2  |8                               , 255, 255, 255,   0,	"Starconium"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Sugilite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Sugilite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Sunstone		= new Materials(-1, SET_NONE				, 1.0F,      0,  1, 1    |8                               , 255, 255, 255,   0,	"Sunstone"						,    0,       0,         -1,    0, false, false,   3,   1,   1,Dyes.dyeYellow		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.ALIENIS, 1)));
    public static Materials Tar				= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 0                                     ,  10,  10,  10,   0,	"Tar"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    public static Materials Tartarite		= new Materials( -1, SET_METALLIC			,  20.0F,   7680,  5, 1|2  |8|16                            , 255, 118,  60,   0,	"Tartarite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Tapazite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Tapazite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeGreen	);
    public static Materials Thyrium			= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1|2  |8                               , 255, 255, 255,   0,	"Thyrium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Tourmaline		= new Materials(  -1, SET_RUBY				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Tourmaline"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials Tritanium		= new Materials(329, SET_METALLIC			, 6.0F,   2560,  4, 1|2          |64                      , 255, 255, 255,   0,	"Tritanium"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeWhite		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ORDO, 2)));
    public static Materials Turquoise		= new Materials(  -1, SET_NONE				,   1.0F,      0,  1, 1                                     , 255, 255, 255,   0,	"Turquoise"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes._NULL		);
    public static Materials UUAmplifier		= new Materials( 721, SET_FLUID				,   1.0F,      0,  1,         16                            ,  96,   0, 128,   0,	"UU-Amplifier"					,    0,       0,         -1,    0, false, false,  10,   1,   1, Dyes.dyePink	);
    public static Materials UUMatter		= new Materials( 703, SET_FLUID				,   1.0F,      0,  1,         16                            , 128,   0, 196,   0,	"UU-Matter"						,    0,       0,         -1,    0, false, false,  10,   1,   1, Dyes.dyePink	);
    public static Materials Void			= new Materials(-1, SET_NONE				, 1.0F,      0,  1, 0                                     , 255, 255, 255, 200,	"Void"							,    0,       0,         -1,    0, false, true,   1,   1,   1,Dyes._NULL			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VACUOS, 1)));
    public static Materials Voidstone		= new Materials(-1, SET_NONE				, 1.0F,      0,  1, 0                                     , 255, 255, 255, 200,	"Voidstone"						,    0,       0,         -1,    0, false, true,   1,   1,   1,Dyes._NULL			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.VACUOS, 1)));
    public static Materials Vulcanite		= new Materials( 489, SET_METALLIC			,   6.0F,     64,  2, 1|2  |8|16   |64                      , 255, 132,  72,   0,	"Vulcanite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Vyroxeres		= new Materials( -1, SET_METALLIC			,   9.0F,    768,  3, 1|2  |8      |64                      ,  85, 224,   1,   0,	"Vyroxeres"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL		);
    public static Materials Wimalite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2,       8                               , 255, 255, 255,   0,	"Wimalite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow	);
    public static Materials Yellorite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2,       8                               , 255, 255, 255,   0,	"Yellorite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow	);
    public static Materials Yellorium		= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2                                   , 255, 255, 255,   0,	"Yellorium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow	);
    public static Materials Zectium			= new Materials(  -1, SET_NONE				,   1.0F,      0,  2, 1|2  |8                               , 255, 255, 255,   0,	"Zectium"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlack	);

    /**
     * Circuitry, Batteries and other Technical things
     */
    public static Materials Primitive		= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Primitive"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 1)));
    public static Materials Basic			= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Basic"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 2)));
    public static Materials Good			= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Good"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 3)));
    public static Materials Advanced		= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Advanced"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 4)));
    public static Materials Data			= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Data"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 5)));
    public static Materials Elite			= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Elite"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 6)));
    public static Materials Master			= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Master"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 7)));
    public static Materials Ultimate		= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Ultimate"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MACHINA, 8)));
    public static Materials Superconductor	= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Superconductor"				,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 8)));
    public static Materials Infinite		= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Infinite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray);

    /**
     * Not possible to determine exact Components
     */
    public static Materials Antimatter		= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Antimatter"					,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyePink		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 9), new TC_AspectStack(TC_Aspects.PERFODIO, 8)));
    public static Materials BioFuel			= new Materials( 705, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 128,   0,   0,	"Biofuel"						,    0,       6,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange	);
    public static Materials Biomass			= new Materials( 704, SET_FLUID				,   1.0F,      0,  0,         16                            ,   0, 255,   0,   0,	"Biomass"						,    3,       8,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGreen	);
    public static Materials Cheese			= new Materials( 894, SET_FINE				,   1.0F,      0,  0, 1    |8                               , 255, 255,   0,   0,	"Cheese"						,    0,       0,        320,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Chili			= new Materials( 895, SET_FINE				,   1.0F,      0,  0, 1                                     , 200,   0,   0,   0,	"Chili"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed		);
    public static Materials Chocolate		= new Materials( 886, SET_FINE				,   1.0F,      0,  0, 1                                     , 190,  95,   0,   0,	"Chocolate"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown	);
    public static Materials Cluster			= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255, 127,	"Cluster"						,    0,       0,         -1,    0, false, true,   1,   1,   1, Dyes.dyeWhite	);
    public static Materials CoalFuel		= new Materials( 710, SET_FLUID				,   1.0F,      0,  0,         16                            ,  50,  50,  70,   0,	"Coalfuel"						,    0,      16,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    public static Materials Cocoa			= new Materials( 887, SET_FINE				,   1.0F,      0,  0, 1                                     , 190,  95,   0,   0,	"Cocoa"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown	);
    public static Materials Coffee			= new Materials( 888, SET_FINE				,   1.0F,      0,  0, 1                                     , 150,  75,   0,   0,	"Coffee"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown	);
    public static Materials Creosote		= new Materials( 712, SET_FLUID				,   1.0F,      0,  0,         16                            , 128,  64,   0,   0,	"Creosote"						,    3,       8,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown	);
    public static Materials Ethanol			= new Materials( 706, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 128,   0,   0,	"Ethanol"						,    0,     128,         -1,    0, false, false,   1,   1,   1, Dyes.dyePurple	);
    public static Materials FishOil			= new Materials(711, SET_FLUID				, 1.0F,      0,  0,         16                            , 255, 196,   0,   0,	"Fish Oil"						,    3,       2,         -1,    0, false, false,   1,   1,   1,Dyes.dyeYellow		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.CORPUS, 2)));
    public static Materials Fuel			= new Materials( 708, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Diesel"						,    0,     128,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Glue			= new Materials(726, SET_FLUID				, 1.0F,      0,  0,         16                            , 200, 196,   0,   0,	"Glue"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeOrange		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.LIMUS, 2)));
    public static Materials Gunpowder		= new Materials(800, SET_DULL				, 1.0F,      0,  0, 1                                     , 128, 128, 128,   0,	"Gunpowder"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeGray		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PERDITIO, 3), new TC_AspectStack(TC_Aspects.IGNIS, 4)));
    public static Materials FryingOilHot	= new Materials(727, SET_FLUID				, 1.0F,      0,  0,         16                            , 200, 196,   0,   0,	"Hot Frying Oil"				,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeOrange		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1), new TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials Honey			= new Materials( 725, SET_FLUID				,   1.0F,      0,  0,         16                            , 210, 200,   0,   0,	"Honey"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Leather			= new Materials(  -1, SET_ROUGH				,   1.0F,      0,  0, 1                                     , 150, 150,  80, 127,	"Leather"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange	);
    public static Materials LimePure		= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Pure Lime"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLime	);
    public static Materials Lubricant		= new Materials(724, SET_FLUID				, 1.0F,      0,  0,         16                            , 255, 196,   0,   0,	"Lubricant"						,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeOrange		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 2), new TC_AspectStack(TC_Aspects.MACHINA, 1)));
    public static Materials McGuffium239	= new Materials(999, SET_FLUID				, 1.0F,      0,  0,         16                            , 200,  50, 150,   0,	"Mc Guffium 239"				,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyePink		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.ALIENIS, 8), new TC_AspectStack(TC_Aspects.PERMUTATIO, 8), new TC_AspectStack(TC_Aspects.SPIRITUS, 8), new TC_AspectStack(TC_Aspects.AURAM, 8), new TC_AspectStack(TC_Aspects.VITIUM, 8), new TC_AspectStack(TC_Aspects.RADIO, 8), new TC_AspectStack(TC_Aspects.MAGNETO, 8), new TC_AspectStack(TC_Aspects.ELECTRUM, 8), new TC_AspectStack(TC_Aspects.NEBRISUM, 8), new TC_AspectStack(TC_Aspects.STRONTIO, 8)));
    public static Materials MeatRaw			= new Materials( 892, SET_FINE				,   1.0F,      0,  0, 1                                     , 255, 100, 100,   0,	"Raw Meat"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePink	);
    public static Materials MeatCooked		= new Materials( 893, SET_FINE				,   1.0F,      0,  0, 1                                     , 150,  60,  20,   0,	"Cooked Meat"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePink	);
    public static Materials Milk			= new Materials(885, SET_FINE				, 1.0F,      0,  0, 1      |16                            , 254, 254, 254,   0,	"Milk"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeWhite		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.SANO, 2)));
    public static Materials Mud				= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Mud"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown	);
    public static Materials Oil				= new Materials( 707, SET_FLUID				,   1.0F,      0,  0,         16                            ,  10,  10,  10,   0,	"Oil"							,    3,      16,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    public static Materials Paper			= new Materials(879, SET_PAPER				, 1.0F,      0,  0, 1                                     , 250, 250, 250,   0,	"Paper"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeWhite		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO, 1)));
    public static Materials Peat			= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Peat"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeBrown		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.POTENTIA, 2), new TC_AspectStack(TC_Aspects.IGNIS, 2)));
    public static Materials Quantum			= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Quantum"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite	);
    public static Materials RareEarth		= new Materials(891, SET_FINE				, 1.0F,      0,  0, 1                                     , 128, 128, 100,   0,	"Rare Earth"					,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeGray		, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.VITREUS, 1), new TC_AspectStack(TC_Aspects.LUCRUM, 1)));
    public static Materials Red				= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255,   0,   0,   0,	"Red"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed		);
    public static Materials Reinforced		= new Materials(  -1, SET_NONE				,   1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"Reinforced"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray	);
    public static Materials SeedOil			= new Materials(713, SET_FLUID				, 1.0F,      0,  0,         16                            , 196, 255,   0,   0,	"Seed Oil"						,    3,       2,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLime		, Collections.singletonList(new TC_AspectStack(TC_Aspects.GRANUM, 2)));
    public static Materials SeedOilHemp		= new Materials(722, SET_FLUID				, 1.0F,      0,  0,         16                            , 196, 255,   0,   0,	"Hemp Seed Oil"					,    3,       2,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLime		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.GRANUM, 2)));
    public static Materials SeedOilLin		= new Materials(723, SET_FLUID				, 1.0F,      0,  0,         16                            , 196, 255,   0,   0,	"Lin Seed Oil"					,    3,       2,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLime		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.GRANUM, 2)));
    public static Materials Stone			= new Materials(299, SET_ROUGH				, 4.0F,     32,  1, 1            |64|128                  , 205, 205, 205,   0,	"Stone"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeLightGray	, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.TERRA, 1)));
    public static Materials TNT				= new Materials(-1, SET_NONE				, 1.0F,      0,  0, 0                                     , 255, 255, 255,   0,	"TNT"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeRed			, Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.PERDITIO, 7), new TC_AspectStack(TC_Aspects.IGNIS, 4)));
    public static Materials Unstable		= new Materials(-1, SET_NONE				, 1.0F,      0,  4, 0                                     , 255, 255, 255, 127,	"Unstable"						,    0,       0,         -1,    0, false, true,   1,   1,   1,Dyes.dyeWhite		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.PERDITIO, 4)));
    public static Materials Unstableingot	= new Materials(-1, SET_NONE				, 1.0F,      0,  4, 0                                     , 255, 255, 255, 127,	"Unstable"						,    0,       0,         -1,    0, false, true,   1,   1,   1,Dyes.dyeWhite		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.PERDITIO, 4)));
    public static Materials Wheat			= new Materials(881, SET_POWDER			, 1.0F,      0,  0, 1                                     , 255, 255, 196,   0,	"Wheat"							,    0,       0,         -1,    0, false, false,   1,   1,   1,Dyes.dyeYellow		, Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.MESSIS, 2)));

    /**
     * TODO: This
     */
    public static Materials AluminiumBrass	= new Materials(  -1, SET_METALLIC			,   6.0F,     64,  2, 1|2          |64                      , 255, 255, 255,   0,	"Aluminium Brass"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Osmiridium		= new Materials( 317, SET_METALLIC			,   7.0F,   1600,  3, 1|2          |64|128                  , 100, 100, 255,   0,	"Osmiridium"					,    0,       0,       3333, 2500, true,  false,   1,   1,   1, Dyes.dyeLightBlue	, 1, Arrays.asList(new MaterialStack(Iridium, 3), new MaterialStack(Osmium, 1)));
    public static Materials Sunnarium		= new Materials( 318, SET_SHINY				,   1.0F,      0,  1, 1|2                                   , 255, 255,   0,   0,	"Sunnarium"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    public static Materials Endstone		= new Materials( 808, SET_DULL				,   1.0F,      0,  1, 1                                     , 232, 232, 168,   0,	"Endstone"						,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeYellow	);
    public static Materials Netherrack		= new Materials( 807, SET_DULL				,   1.0F,      0,  0, 1                                     , 200,   0,   0,   0,	"Netherrack"					,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeRed		);
    public static Materials SoulSand		= new Materials(  -1, SET_DULL				,   1.0F,      0,  0, 1                                     , 255, 255, 255,   0,	"Soulsand"						,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeBrown	);

    /**
     * First Degree Compounds
     */
    public static Materials Methane			= new Materials( 715, SET_FLUID				,   1.0F,      0,  1,         16                            , 255, 255, 255,   0,	"Methane"						,    1,      45,         -1,    0, false, false,   3,   1,   1, Dyes.dyeMagenta		, 1, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 4)));
    public static Materials CarbonDioxide	= new Materials( 497, SET_FLUID				,   1.0F,      0,  2,         16|32                         , 169, 208, 245, 240,	"Carbon Dioxide"				,    0,       0,         25,    1, false, true,   1,   1,   1, Dyes.dyeLightBlue	, 1, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 2)));
    public static Materials NobleGases		= new Materials( 496, SET_FLUID				,   1.0F,      0,  2,         16|32                         , 169, 208, 245, 240,	"Noble Gases"					,    0,       0,          4,    0, false, true,   1,   1,   1, Dyes.dyeLightBlue	, 2, Arrays.asList(new MaterialStack(CarbonDioxide,21),new MaterialStack(Helium, 9), new MaterialStack(Methane, 3), new MaterialStack(Deuterium, 1)));
    public static Materials Air				= new Materials(  -1, SET_FLUID				,   1.0F,      0,  2,         16|32                         , 169, 208, 245, 240,	"Air"							,    0,       0,         -1,    0, false, true,   1,   1,   1, Dyes.dyeLightBlue	, 0, Arrays.asList(new MaterialStack(Nitrogen, 40), new MaterialStack(Oxygen, 11), new MaterialStack(Argon, 1),new MaterialStack(NobleGases,1)));
    public static Materials LiquidAir		= new Materials( -1, SET_FLUID				,   1.0F,      0,  2,         16|32                         , 169, 208, 245, 240,	"Liquid Air"					,    0,       0,          4,    0, false, true,   1,   1,   1, Dyes.dyeLightBlue	, 2, Arrays.asList(new MaterialStack(Nitrogen, 40), new MaterialStack(Oxygen, 11), new MaterialStack(Argon, 1),new MaterialStack(NobleGases,1)));
    public static Materials Almandine		= new Materials( 820, SET_ROUGH				,   1.0F,      0,  1, 1    |8                               , 255,   0,   0,   0,	"Almandine"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeRed			, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Iron, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
    public static Materials Andradite		= new Materials( 821, SET_ROUGH				,   1.0F,      0,  1, 1    |8                               , 150, 120,   0,   0,	"Andradite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow		, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Iron, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
    public static Materials AnnealedCopper	= new Materials( 345, SET_SHINY				,   1.0F,      0,  2, 1|2             |128                  , 255, 120,  20,   0,	"Annealed Copper"				,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Copper, 1)));
    public static Materials Asbestos		= new Materials( 946, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 230, 230, 230,   0,	"Asbestos"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 9))); // Mg3Si2O5(OH)4
    public static Materials Ash				= new Materials( 815, SET_DULL				,   1.0F,      0,  1, 1                                     , 150, 150, 150,   0,	"Ashes"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray	, 2, Arrays.asList(new MaterialStack(Carbon, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.PERDITIO, 1)));
    public static Materials BandedIron		= new Materials( 917, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 145,  90,  90,   0,	"Banded Iron"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown		, 1, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Oxygen, 3)));
    public static Materials BatteryAlloy	= new Materials( 315, SET_DULL				,   1.0F,      0,  1, 1|2                                   , 156, 124, 160,   0,	"Battery Alloy"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePurple		, 2, Arrays.asList(new MaterialStack(Lead, 4), new MaterialStack(Antimony, 1)));
    public static Materials BlueTopaz		= new Materials( 513, SET_GEM_HORIZONTAL	,   7.0F,    256,  3, 1  |4|8      |64                      ,   0,   0, 255, 127,	"Blue Topaz"					,    0,       0,         -1,    0, false, true,   3,   1,   1, Dyes.dyeBlue		, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Fluorine, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 6)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 6), new TC_AspectStack(TC_Aspects.VITREUS, 4)));
    public static Materials Bone			= new Materials( 806, SET_DULL				,   1.0F,      0,  1, 1                                     , 250, 250, 250,   0,	"Bone"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Calcium, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.MORTUUS, 2), new TC_AspectStack(TC_Aspects.CORPUS, 1)));
    public static Materials Brass			= new Materials( 301, SET_METALLIC			,   7.0F,     96,  1, 1|2          |64|128                  , 255, 180,   0,   0,	"Brass"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Zinc, 1), new MaterialStack(Copper, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials Bronze			= new Materials( 300, SET_METALLIC			,   6.0F,    192,  2, 1|2          |64|128                  , 255, 128,   0,   0,	"Bronze"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Copper, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials BrownLimonite	= new Materials( 930, SET_METALLIC			,   1.0F,      0,  1, 1    |8                               , 200, 100,   0,   0,	"Brown Limonite"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown		, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2))); // FeO(OH)
    public static Materials Calcite			= new Materials( 823, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 250, 230, 220,   0,	"Calcite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
    public static Materials Cassiterite		= new Materials( 824, SET_METALLIC			,   1.0F,      0,  1,       8                               , 220, 220, 220,   0,	"Cassiterite"					,    0,       0,         -1,    0, false, false,   4,   3,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Oxygen, 2)));
    public static Materials CassiteriteSand	= new Materials( 937, SET_SAND				,   1.0F,      0,  1,       8                               , 220, 220, 220,   0,	"Cassiterite Sand"				,    0,       0,         -1,    0, false, false,   4,   3,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Oxygen, 2)));
    public static Materials Chalcopyrite	= new Materials( 855, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 160, 120,  40,   0,	"Chalcopyrite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow		, 1, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Iron, 1), new MaterialStack(Sulfur, 2)));
    public static Materials Chalk			= new Materials( -1, SET_FINE				,   1.0F,      0,  2, 1                                     , 250, 250, 250,   0,	"Chalk"							,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
    public static Materials Charcoal		= new Materials( 536, SET_FINE				,   1.0F,      0,  1, 1  |4                                 , 100,  70,  70,   0,	"Charcoal"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 1, Arrays.asList(new MaterialStack(Carbon, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.POTENTIA, 2), new TC_AspectStack(TC_Aspects.IGNIS, 2)));
    public static Materials Chromite		= new Materials( 825, SET_METALLIC			,   1.0F,      0,  1, 1    |8                               ,  35,  20,  15,   0,	"Chromite"						,    0,       0,       1700, 1700, true, false,   6,   1,   1, Dyes.dyePink		, 1, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Chrome, 2), new MaterialStack(Oxygen, 4)));
    public static Materials ChromiumDioxide = new Materials( 361, SET_DULL				,  11.0F,    256,  3, 1|2                                   , 230, 200, 200,   0,	"Chromium Dioxide"   			,    0,       0,        650,  650, false, false,   5,   3,   1, Dyes.dyePink 		, 1, Arrays.asList(new MaterialStack(Chrome, 1), new MaterialStack(Oxygen, 2)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MACHINA, 1)));
    public static Materials Cinnabar		= new Materials( 826, SET_ROUGH				,   1.0F,      0,  1, 1    |8                               , 150,   0,   0,   0,	"Cinnabar"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBrown		, 2, Arrays.asList(new MaterialStack(Mercury, 1), new MaterialStack(Sulfur, 1)));
    public static Materials Water			= new Materials( 701, SET_FLUID				,   1.0F,      0,  0,         16                            ,   0,   0, 255,   0,	"Water"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.AQUA, 2)));
    public static Materials Clay			= new Materials( 805, SET_ROUGH				,   1.0F,      0,  1, 1                                     , 200, 200, 220,   0,	"Clay"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeLightBlue	, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 2),new MaterialStack(Water,6)));
    public static Materials Coal			= new Materials( 535, SET_ROUGH				,   1.0F,      0,  1, 1  |4|8	                            ,  70,  70,  70,   0,	"Coal"							,    0,       0,         -1,    0, false, false,   2,   2,   1, Dyes.dyeBlack		, 1, Arrays.asList(new MaterialStack(Carbon, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.POTENTIA, 2), new TC_AspectStack(TC_Aspects.IGNIS, 2)));
    public static Materials Cobaltite		= new Materials( 827, SET_METALLIC			,   1.0F,      0,  1, 1    |8                               ,  80,  80, 250,   0,	"Cobaltite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlue		, 1, Arrays.asList(new MaterialStack(Cobalt, 1), new MaterialStack(Arsenic, 1), new MaterialStack(Sulfur, 1)));
    public static Materials Cooperite		= new Materials( 828, SET_METALLIC			,   1.0F,      0,  1, 1    |8                               , 255, 255, 200,   0,	"Sheldonite"					,    0,       0,         -1,    0, false, false,   5,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Platinum, 3), new MaterialStack(Nickel, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Palladium, 1)));
    public static Materials Cupronickel		= new Materials( 310, SET_METALLIC			,   6.0F,     64,  1, 1|2          |64                      , 227, 150, 128,   0,	"Cupronickel"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Nickel, 1)));
    public static Materials DarkAsh			= new Materials( 816, SET_DULL				,   1.0F,      0,  1, 1                                     ,  50,  50,  50,   0,	"Dark Ashes"					,    0,       0,         -1,    0, false, false,   1,   2,   1, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Carbon, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.IGNIS, 1), new TC_AspectStack(TC_Aspects.PERDITIO, 1)));
    public static Materials DeepIron		= new Materials( 829, SET_METALLIC			,   6.0F,    384,  2, 1|2  |8      |64                      , 150, 140, 140,   0,	"Deep Iron"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyePink		, 2, Arrays.asList(new MaterialStack(Iron, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials Diamond			= new Materials( 500, SET_DIAMOND			,   8.0F,   1280,  3, 1  |4|8      |64|128                  , 200, 255, 255, 127,	"Diamond"						,    0,       0,         -1,    0, false, true,   5,  64,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Carbon, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 3), new TC_AspectStack(TC_Aspects.LUCRUM, 4)));
    public static Materials Electrum		= new Materials( 303, SET_SHINY				,  12.0F,     64,  2, 1|2  |8      |64|128                  , 255, 255, 100,   0,	"Electrum"						,    0,       0,         -1,    0, false, false,   4,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(Gold, 1)));
    public static Materials Emerald			= new Materials( 501, SET_EMERALD			,   7.0F,    256,  2, 1  |4|8      |64                      ,  80, 255,  80, 127,	"Emerald"						,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyeGreen		, 1, Arrays.asList(new MaterialStack(Beryllium, 3), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 6), new MaterialStack(Oxygen, 18)), Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 3), new TC_AspectStack(TC_Aspects.LUCRUM, 5)));
    public static Materials FreshWater		= new Materials(  -1, SET_FLUID				,   1.0F,      0,  0,         16                            ,   0,   0, 255,   0,	"Fresh Water"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.AQUA, 2)));
    public static Materials Galena			= new Materials( 830, SET_DULL				,   1.0F,      0,  3, 1    |8                               , 100,  60, 100,   0,	"Galena"						,    0,       0,         -1,    0, false, false,   4,   1,   1, Dyes.dyePurple		, 1, Arrays.asList(new MaterialStack(Lead, 3), new MaterialStack(Silver, 3), new MaterialStack(Sulfur, 2)));
    public static Materials Garnierite		= new Materials( 906, SET_METALLIC			,   1.0F,      0,  3, 1    |8                               ,  50, 200,  70,   0,	"Garnierite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightBlue	, 1, Arrays.asList(new MaterialStack(Nickel, 1), new MaterialStack(Oxygen, 1)));
    public static Materials Glyceryl		= new Materials( 714, SET_FLUID				,   1.0F,      0,  1,         16                            ,   0, 150, 150,   0,	"Glyceryl Trinitrate"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeCyan		, 1, Arrays.asList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 5), new MaterialStack(Nitrogen, 3), new MaterialStack(Oxygen, 9)));
    public static Materials GreenSapphire	= new Materials( 504, SET_GEM_HORIZONTAL	,   7.0F,    256,  2, 1  |4|8      |64                      , 100, 200, 130, 127,	"Green Sapphire"				,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyeCyan		, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 5), new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Grossular		= new Materials( 831, SET_ROUGH				,   1.0F,      0,  1, 1    |8                               , 200, 100,   0,   0,	"Grossular"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
    public static Materials HolyWater		= new Materials( 729, SET_FLUID				,   1.0F,      0,  0,         16                            ,   0,   0, 255,   0,	"Holy Water"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.AQUA, 2), new TC_AspectStack(TC_Aspects.AURAM, 1)));
    public static Materials Ice				= new Materials( 702, SET_SHINY				,   1.0F,      0,  0, 1|      16                            , 200, 200, 255,   0,	"Ice"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.GELUM, 2)));
    public static Materials Ilmenite		= new Materials( 918, SET_METALLIC			,   1.0F,      0,  3, 1    |8                               ,  70,  55,  50,   0,	"Ilmenite"						,    0,       0,         -1,    0, false, false,   1,   2,   1, Dyes.dyePurple		, 0, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 3)));
    public static Materials Rutile			= new Materials( 375, SET_GEM_HORIZONTAL	,   1.0F,      0,  2, 1    |8                               , 212,  13,  92,   0,	"Rutile"						,    0,       0,         -1,    0, false, false,   1,   2,   1, Dyes.dyeRed			, 0, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 2)));
    public static Materials Bauxite			= new Materials( 822, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 200, 100,   0,   0,	"Bauxite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBrown		, 1, Arrays.asList(new MaterialStack(Rutile, 2), new MaterialStack(Aluminium, 16), new MaterialStack(Hydrogen, 10), new MaterialStack(Oxygen, 11)));
    public static Materials Titaniumtetrachloride = new Materials( -1, SET_FLUID			,   1.0F,      0,  2, 16                                    , 212,  13,  92,   0,	"Titaniumtetrachloride"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed			, 0, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Carbon, 2), new MaterialStack(Chlorine, 2)));
    public static Materials Magnesiumchloride= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1|16                                    , 212,  13,  92,   0,	"Magnesiumchloride"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed			, 0, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Chlorine, 2)));
    public static Materials Invar			= new Materials( 302, SET_METALLIC			,   6.0F,    256,  2, 1|2          |64|128                  , 180, 180, 120,   0,	"Invar"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown		, 2, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Nickel, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.GELUM, 1)));
    public static Materials IronCompressed	= new Materials(  -1, SET_METALLIC			,   7.0F,     96,  1, 1|2          |64|128                  , 128, 128, 128,   0,	"Compressed Iron"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray		, 2, Arrays.asList(new MaterialStack(Iron, 1)));
    public static Materials Kanthal			= new Materials( 312, SET_METALLIC			,   6.0F,     64,  2, 1|2          |64                      , 194, 210, 223,   0,	"Kanthal"						,    0,       0,       1800, 1800, true, false,   1,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Chrome, 1)));
    public static Materials Lazurite		= new Materials( 524, SET_LAPIS				,   1.0F,      0,  1, 1  |4|8                               , 100, 120, 255,   0,	"Lazurite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeCyan		, 1, Arrays.asList(new MaterialStack(Aluminium, 6), new MaterialStack(Silicon, 6), new MaterialStack(Calcium, 8), new MaterialStack(Sodium, 8)));
    public static Materials Magnalium		= new Materials( 313, SET_DULL				,   6.0F,    256,  2, 1|2          |64|128                  , 200, 190, 255,   0,	"Magnalium"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightBlue	, 2, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Aluminium, 2)));
    public static Materials Magnesite		= new Materials( 908, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               , 250, 250, 180,   0,	"Magnesite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePink		, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
    public static Materials Magnetite		= new Materials( 870, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               ,  30,  30,  30,   0,	"Magnetite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Oxygen, 4)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials Molybdenite		= new Materials( 942, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               ,  25,  25,  25,   0,	"Molybdenite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue		, 1, Arrays.asList(new MaterialStack(Molybdenum, 1), new MaterialStack(Sulfur, 2))); // MoS2 (also source of Re)
    public static Materials Nichrome		= new Materials( 311, SET_METALLIC			,   6.0F,     64,  2, 1|2          |64                      , 205, 206, 246,   0,	"Nichrome"						,    0,       0,       2700, 2700, true, false,   1,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(Nickel, 4), new MaterialStack(Chrome, 1)));
    public static Materials NiobiumNitride	= new Materials( 359, SET_DULL				,   1.0F,      0,  2, 1|2                                   ,  29,  41,  29,   0,	"Niobium Nitride"				,    0,       0,       2573, 2573, true, false,   1,   1,   1, Dyes.dyeBlack		, 1, Arrays.asList(new MaterialStack(Niobium, 1), new MaterialStack(Nitrogen, 1))); // Anti-Reflective Material
    public static Materials NiobiumTitanium	= new Materials( 360, SET_DULL				,   1.0F,      0,  2, 1|2                                   ,  29,  29,  41,   0,	"Niobium-Titanium"				,    0,       0,       4500, 4500, true, false,   1,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Niobium, 1), new MaterialStack(Titanium, 1)));
    public static Materials NitroCarbon		= new Materials( 716, SET_FLUID				,   1.0F,      0,  1,         16                            ,   0,  75, 100,   0,	"Nitro-Carbon"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeCyan		, 1, Arrays.asList(new MaterialStack(Nitrogen, 1), new MaterialStack(Carbon, 1)));
    public static Materials NitrogenDioxide	= new Materials( 717, SET_FLUID				,   1.0F,      0,  1,         16                            , 100, 175, 255,   0,	"Nitrogen Dioxide"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeCyan		, 1, Arrays.asList(new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 2)));
    public static Materials Obsidian		= new Materials( 804, SET_DULL				,   1.0F,      0,  3, 1                                     ,  80,  50, 100,   0,	"Obsidian"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Iron, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 8)));
    public static Materials Phosphate		= new Materials( 833, SET_DULL				,   1.0F,      0,  1, 1    |8|16                            , 255, 255,   0,   0,	"Phosphate"						,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeYellow		, 1, Arrays.asList(new MaterialStack(Phosphor, 1), new MaterialStack(Oxygen, 4)));
    public static Materials PigIron			= new Materials( 307, SET_METALLIC			,   6.0F,    384,  2, 1|2  |8      |64                      , 200, 180, 180,   0,	"Pig Iron"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyePink		, 2, Arrays.asList(new MaterialStack(Iron, 1)));
    public static Materials Plastic			= new Materials( 874, SET_DULL				,   3.0F,     32,  1, 1|2          |64|128                  , 200, 200, 200,   0,	"Polyethylene"					,    0,       0,        400,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 2)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials Epoxid			= new Materials( -1, SET_DULL				,   3.0F,     32,  1, 1|2          |64|128                  , 200, 140,  20,   0,	"Epoxid"						,    0,       0,        400,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials Silicone		= new Materials( -1, SET_DULL				,   3.0F,    128,  1, 1|2          |64|128                  , 220, 220, 220,   0,	"Polysiloxane"					,    0,       0,        900,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials Polycaprolactam	= new Materials( -1, SET_DULL				,   3.0F,     32,  1, 1|2          |64|128                  ,  50,  50,  50,   0,	"Polycaprolactam"				,    0,       0,        500,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 11), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials Polytetrafluoroethylene = new Materials( -1, SET_DULL			,   3.0F,     32,  1, 1|2          |64|128                  , 100, 100, 100,   0,	"Polytetrafluoroethylene"		,    0,       0,       1400,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Fluorine, 4)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials Powellite		= new Materials( 883, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 255, 255,   0,   0,	"Powellite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Molybdenum, 1), new MaterialStack(Oxygen, 4)));
    public static Materials Pumice			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 230, 185, 185,   0,	"Pumice"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray		, 2, Arrays.asList(new MaterialStack(Stone, 1)));
    public static Materials Pyrite			= new Materials( 834, SET_ROUGH				,   1.0F,      0,  1, 1    |8                               , 150, 120,  40,   0,	"Pyrite"						,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Sulfur, 2)));
    public static Materials Pyrolusite		= new Materials( 943, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 150, 150, 170,   0,	"Pyrolusite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray	, 1, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Oxygen, 2)));
    public static Materials Pyrope			= new Materials( 835, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               , 120,  50, 100,   0,	"Pyrope"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyePurple		, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
    public static Materials RockSalt		= new Materials( 944, SET_FINE				,   1.0F,      0,  1, 1    |8                               , 240, 200, 200,   0,	"Rock Salt"						,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Chlorine, 1)));
    public static Materials Rubber			= new Materials( 880, SET_SHINY				,   1.5F,     16,  0, 1|2          |64|128                  ,   0,   0,   0,   0,	"Rubber"						,    0,       0,        400,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 0, Arrays.asList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials RawRubber		= new Materials( -1, SET_DULL				,   1.0F,      0,  0, 1                                     , 204, 199, 137,   0,	"Raw Rubber"					,    0,       0,        400,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)), Arrays.asList(new TC_AspectStack(TC_Aspects.MOTUS, 2)));
    public static Materials Ruby			= new Materials( 502, SET_RUBY				,   7.0F,    256,  2, 1  |4|8      |64                      , 255, 100, 100, 127,	"Ruby"							,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyeRed			, 1, Arrays.asList(new MaterialStack(Chrome, 1), new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 6), new TC_AspectStack(TC_Aspects.VITREUS, 4)));
    public static Materials Salt			= new Materials( 817, SET_FINE				,   1.0F,      0,  1, 1    |8                               , 250, 250, 250,   0,	"Salt"							,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Chlorine, 1)));
    public static Materials Saltpeter		= new Materials( 836, SET_FINE				,   1.0F,      0,  1, 1    |8                               , 230, 230, 230,   0,	"Saltpeter"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 3)));
    public static Materials SaltWater		= new Materials(  -1, SET_FLUID				,   1.0F,      0,  0,         16                            ,   0,   0, 255,   0,	"Salt Water"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlue		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.AQUA, 2)));
    public static Materials Sapphire		= new Materials( 503, SET_GEM_VERTICAL		,   7.0F,    256,  2, 1  |4|8      |64                      , 100, 100, 200, 127,	"Sapphire"						,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyeBlue		, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 5), new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Scheelite		= new Materials( 910, SET_DULL				,   1.0F,      0,  3, 1    |8                               , 200, 140,  20,   0,	"Scheelite"						,    0,       0,       2500, 2500, false, false,   4,   1,   1, Dyes.dyeBlack		, 0, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Calcium, 2), new MaterialStack(Oxygen, 4)));
    public static Materials SiliconDioxide	= new Materials( 837, SET_QUARTZ			,   1.0F,      0,  1, 1      |16                            , 200, 200, 200,   0,	"Silicon Dioxide"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLightGray	, 1, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 2)));
    public static Materials Snow			= new Materials( 728, SET_FINE				,   1.0F,      0,  0, 1|      16                            , 250, 250, 250,   0,	"Snow"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.GELUM, 1)));
    public static Materials Sodalite		= new Materials( 525, SET_LAPIS				,   1.0F,      0,  1, 1  |4|8                               ,  20,  20, 255,   0,	"Sodalite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlue		, 1, Arrays.asList(new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Sodium, 4), new MaterialStack(Chlorine, 1)));
    public static Materials SodiumPersulfate= new Materials( 718, SET_FLUID				,   1.0F,      0,  2,         16                            , 255, 255, 255,   0,	"Sodium Persulfate"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
    //public static Materials SodiumSulfide	= new Materials( -1, SET_FLUID				,   1.0F,      0,  2,         16                            , 255, 255, 255,   0,	"Sodium Sulfide"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 1)));
    //public static Materials HydricSulfide	= new Materials( -1 SET_FLUID				,   1.0F,      0,  2,         16                            , 255, 255, 255,   0,	"Hydrogen Sulfide"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Sulfur, 1)));

    //public static Materials OilHeavy		= new Materials( 730, SET_FLUID				,   1.0F,      0,  0,         16                            ,  10,  10,  10,   0,	"Heavy Oil"						,    3,      32,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    //public static Materials OilMedium		= new Materials( 731, SET_FLUID				,   1.0F,      0,  0,         16                            ,  10,  10,  10,   0,	"Raw Oil"						,    3,      24,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    //public static Materials OilLight		= new Materials( 732, SET_FLUID				,   1.0F,      0,  0,         16                            ,  10,  10,  10,   0,	"Light Oil"						,    3,      16,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);

    //public static Materials NatruralGas		= new Materials( 733, SET_FLUID				,   1.0F,      0,  1,         16                            , 255, 255, 255,   0,	"Natural Gas"					,    1,      15,         -1,    0, false, false,   3,   1,   1, Dyes.dyeWhite	);
    //public static Materials SulfuricGas		= new Materials( 734, SET_FLUID				,   1.0F,      0,  1,         16                            , 255, 255, 255,   0,	"Sulfuric Gas"					,    1,      20,         -1,    0, false, false,   3,   1,   1, Dyes.dyeWhite	);
    public static Materials Gas				= new Materials( 735, SET_FLUID				,   1.0F,      0,  1,         16                            , 255, 255, 255,   0,	"Refinery Gas"					,    1,     128,         -1,    0, false, false,   3,   1,   1, Dyes.dyeWhite	);
    //public static Materials SulfuricNaphtha	= new Materials( 736, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Sulfuric Naphtha"				,    1,      32,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    //public static Materials SulfuricLightFuel= new Materials( 737, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Sulfuric Light Fuel"			,    0,      32,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    //public static Materials SulfuricHeavyFuel= new Materials( 738, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Sulfuric Heavy Fuel"			,    3,      32,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    //public static Materials Naphtha			= new Materials( 739, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Naphtha"						,    1,     256,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    //public static Materials LightFuel		= new Materials( 740, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Light Fuel"					,    0,     256,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);
    //public static Materials HeavyFuel		= new Materials( 741, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"Heavy Fuel"					,    3,     192,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack	);
    //public static Materials LPG				= new Materials( 742, SET_FLUID				,   1.0F,      0,  0,         16                            , 255, 255,   0,   0,	"LPG"							,    1,     256,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow	);

    public static Materials SolderingAlloy	= new Materials( 314, SET_DULL				,   1.0F,      0,  1, 1|2                                   , 220, 220, 230,   0,	"Soldering Alloy"				,    0,       0,        400,  400, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Tin, 9), new MaterialStack(Antimony, 1)));
    public static Materials Spessartine		= new Materials( 838, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 255, 100, 100,   0,	"Spessartine"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeRed			, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Manganese, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
    public static Materials Sphalerite		= new Materials( 839, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 255, 255, 255,   0,	"Sphalerite"					,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeYellow		, 1, Arrays.asList(new MaterialStack(Zinc, 1), new MaterialStack(Sulfur, 1)));
    public static Materials StainlessSteel	= new Materials( 306, SET_SHINY				,   7.0F,    480,  2, 1|2          |64|128                  , 200, 200, 220,   0,	"Stainless Steel"				,    0,       0,         -1, 1700, true, false,   1,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Iron, 6), new MaterialStack(Chrome, 1), new MaterialStack(Manganese, 1), new MaterialStack(Nickel, 1)));
    public static Materials Steel			= new Materials( 305, SET_METALLIC			,   6.0F,    512,  2, 1|2          |64|128                  , 128, 128, 128,   0,	"Steel"							,    0,       0,       1811, 1000, true, false,   4,  51,  50, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Iron, 50), new MaterialStack(Carbon, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.ORDO, 1)));
    public static Materials Stibnite		= new Materials( 945, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               ,  70,  70,  70,   0,	"Stibnite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Antimony, 2), new MaterialStack(Sulfur, 3)));
    public static Materials SulfuricAcid	= new Materials( 720, SET_FLUID				,   1.0F,      0,  2,16                                     , 255, 128,   0,   0,	"Sulfuric Acid"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
    public static Materials SulfurDioxide   = new Materials( 795, SET_FLUID               ,   1.0F,      0,  2, 16                                        , 186, 155,  46,   0, "Sulfur Dioxide"               ,    0,       0,         -1,0, false, false, 1, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 2)));

    public static Materials Tanzanite		= new Materials( 508, SET_GEM_VERTICAL		,   7.0F,    256,  2, 1  |4|8      |64                      ,  64,   0, 200, 127,	"Tanzanite"						,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyePurple		, 1, Arrays.asList(new MaterialStack(Calcium, 2), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 13)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 5), new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Tetrahedrite	= new Materials( 840, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 200,  32,   0,   0,	"Tetrahedrite"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(Copper, 3), new MaterialStack(Antimony, 1), new MaterialStack(Sulfur, 3), new MaterialStack(Iron, 1))); //Cu3SbS3 + x(Fe,Zn)6Sb2S9
    public static Materials TinAlloy		= new Materials( 363, SET_METALLIC			,   6.5F,     96,  2, 1|2          |64|128                  , 200, 200, 200,   0,	"Tin Alloy"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Iron, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials Topaz			= new Materials( 507, SET_GEM_HORIZONTAL	,   7.0F,    256,  3, 1  |4|8      |64                      , 255, 128,   0, 127,	"Topaz"							,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyeOrange		, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Fluorine, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 6)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 6), new TC_AspectStack(TC_Aspects.VITREUS, 4)));
    public static Materials Tungstate		= new Materials( 841, SET_DULL				,   1.0F,      0,  3, 1    |8                               ,  55,  50,  35,   0,	"Tungstate"						,    0,       0,       2500, 2500, true, false,   4,   1,   1, Dyes.dyeBlack		, 0, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Lithium, 2), new MaterialStack(Oxygen, 4)));
    public static Materials Ultimet			= new Materials( 344, SET_SHINY				,   9.0F,   2048,  4, 1|2          |64|128                  , 180, 180, 230,   0,	"Ultimet"						,    0,       0,       2700, 2700, true, false,   1,   1,   1, Dyes.dyeLightBlue	, 1, Arrays.asList(new MaterialStack(Cobalt, 5), new MaterialStack(Chrome, 2), new MaterialStack(Nickel, 1), new MaterialStack(Molybdenum, 1))); // 54% Cobalt, 26% Chromium, 9% Nickel, 5% Molybdenum, 3% Iron, 2% Tungsten, 0.8% Manganese, 0.3% Silicon, 0.08% Nitrogen and 0.06% Carbon
    public static Materials Uraninite		= new Materials( 922, SET_METALLIC			,   1.0F,      0,  3, 1    |8                               ,  35,  35,  35,   0,	"Uraninite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLime		, 2, Arrays.asList(new MaterialStack(Uranium, 1), new MaterialStack(Oxygen, 2)));
    public static Materials Uvarovite		= new Materials( 842, SET_DIAMOND			,   1.0F,      0,  2, 1    |8                               , 180, 255, 180,   0,	"Uvarovite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeGreen		, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Chrome, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
    public static Materials VanadiumGallium	= new Materials( 357, SET_SHINY				,   1.0F,      0,  2, 1|2                                   , 128, 128, 140,   0,	"Vanadium-Gallium"				,    0,       0,       4500, 4500, true, false,   1,   1,   1, Dyes.dyeGray		, 2, Arrays.asList(new MaterialStack(Vanadium, 3), new MaterialStack(Gallium, 1)));
    public static Materials Wood			= new Materials( 809, SET_WOOD				,   2.0F,     16,  0, 1|2          |64|128                  , 100,  50,   0,   0,	"Wood"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown		, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 1), new MaterialStack(Hydrogen, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.ARBOR, 2)));
    public static Materials WroughtIron		= new Materials( 304, SET_METALLIC			,   6.0F,    384,  2, 1|2          |64|128                  , 200, 180, 180,   0,	"Wrought Iron"					,    0,       0,       1811,    0, false, false,   3,   1,   1, Dyes.dyeLightGray	, 2, Arrays.asList(new MaterialStack(Iron, 1)));
    public static Materials Wulfenite		= new Materials( 882, SET_DULL				,   1.0F,      0,  3, 1    |8                               , 255, 128,   0,   0,	"Wulfenite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Lead, 1), new MaterialStack(Molybdenum, 1), new MaterialStack(Oxygen, 4)));
    public static Materials YellowLimonite	= new Materials( 931, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               , 200, 200,   0,   0,	"Yellow Limonite"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2))); // FeO(OH) + a bit Ni and Co
    public static Materials YttriumBariumCuprate = new Materials( 358, SET_METALLIC			,   1.0F,      0,  2, 1|2                                   ,  80,  64,  70,   0,	"Yttrium Barium Cuprate"		,    0,       0,       4500, 4500, true, false,   1,   1,   1, Dyes.dyeGray		, 0, Arrays.asList(new MaterialStack(Yttrium, 1), new MaterialStack(Barium, 2), new MaterialStack(Copper, 3), new MaterialStack(Oxygen, 7)));

    /**
     * Second Degree Compounds
     */
    public static Materials WoodSealed		= new Materials( 889, SET_WOOD				,   3.0F,     24,  0, 1|2          |64|128                  ,  80,  40,   0,   0,	"Sealed Wood"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBrown		, 0, Arrays.asList(new MaterialStack(Wood, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.ARBOR, 2), new TC_AspectStack(TC_Aspects.FABRICO, 1)));
    public static Materials LiveRoot		= new Materials( 832, SET_WOOD				,   1.0F,      0,  1, 1                                     , 220, 200,   0,   0,	"Liveroot"						,    5,      16,         -1,    0, false, false,   2,   4,   3, Dyes.dyeBrown		, 2, Arrays.asList(new MaterialStack(Wood, 3), new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.ARBOR, 2), new TC_AspectStack(TC_Aspects.VICTUS, 2), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 1)));
    public static Materials IronWood		= new Materials( 338, SET_WOOD				,   6.0F,    384,  2, 1|2          |64|128                  , 150, 140, 110,   0,	"Ironwood"						,    5,       8,         -1,    0, false, false,   2,  19,  18, Dyes.dyeBrown		, 2, Arrays.asList(new MaterialStack(Iron, 9), new MaterialStack(LiveRoot, 9), new MaterialStack(Gold, 1)));
    public static Materials Glass			= new Materials( 890, SET_GLASS				,   1.0F,      4,  0, 1  |4                                 , 250, 250, 250, 220,	"Glass"							,    0,       0,       1500,    0, false, true,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 2)));
    public static Materials Perlite			= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1    |8                               ,  30,  20,  30,   0,	"Perlite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Obsidian, 2), new MaterialStack(Water, 1)));
    public static Materials Borax			= new Materials( -1, SET_FINE				,   1.0F,      0,  1, 1    |8                               , 250, 250, 250,   0,	"Borax"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Boron, 4), new MaterialStack(Water, 10), new MaterialStack(Oxygen, 7)));
    public static Materials Lignite			= new Materials( 538, SET_LIGNITE			,   1.0F,      0,  0, 1  |4|8                               , 100,  70,  70,   0,	"Lignite Coal"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 1, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Water, 4), new MaterialStack(DarkAsh, 1)));
    public static Materials Olivine			= new Materials( 505, SET_RUBY				,   7.0F,    256,  2, 1  |4|8      |64                      , 150, 255, 150, 127,	"Olivine"						,    0,       0,         -1,    0, false, true,   5,   1,   1, Dyes.dyeLime		, 1, Arrays.asList(new MaterialStack(Magnesium, 2), new MaterialStack(Iron, 1), new MaterialStack(SiliconDioxide, 2)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 4), new TC_AspectStack(TC_Aspects.VITREUS, 2)));
    public static Materials Opal			= new Materials( 510, SET_OPAL				,   7.0F,    256,  2, 1  |4|8      |64                      ,   0,   0, 255,   0,	"Opal"							,    0,       0,         -1,    0, false, true,   3,   1,   1, Dyes.dyeBlue		, 1, Arrays.asList(new MaterialStack(SiliconDioxide, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 5), new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Amethyst		= new Materials( 509, SET_FLINT				,   7.0F,    256,  3, 1  |4|8      |64                      , 210,  50, 210, 127,	"Amethyst"						,    0,       0,         -1,    0, false, true,   3,   1,   1, Dyes.dyePink		, 1, Arrays.asList(new MaterialStack(SiliconDioxide, 4), new MaterialStack(Iron, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 6), new TC_AspectStack(TC_Aspects.VITREUS, 4)));
    public static Materials Redstone		= new Materials( 810, SET_ROUGH				,   1.0F,      0,  2, 1    |8                               , 200,   0,   0,   0,	"Redstone"						,    0,       0,        500,    0, false, false,   3,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Pyrite, 5), new MaterialStack(Ruby, 1), new MaterialStack(Mercury, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.MACHINA, 1), new TC_AspectStack(TC_Aspects.POTENTIA, 2)));
    public static Materials Lapis			= new Materials( 526, SET_LAPIS				,   1.0F,      0,  1, 1  |4|8                               ,  70,  70, 220,   0,	"Lapis"							,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeBlue		, 2, Arrays.asList(new MaterialStack(Lazurite, 12), new MaterialStack(Sodalite, 2), new MaterialStack(Pyrite, 1), new MaterialStack(Calcite, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.SENSUS, 1)));
    public static Materials Blaze			= new Materials( 801, SET_POWDER			,   2.0F,     16,  1, 1            |64                      , 255, 200,   0,   0,	"Blaze"							,    0,       0,       6400,    0, false, false,   2,   3,   2, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(DarkAsh, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.PRAECANTATIO, 2), new TC_AspectStack(TC_Aspects.IGNIS, 4)));
    public static Materials EnderPearl		= new Materials( 532, SET_SHINY				,   1.0F,     16,  1, 1  |4                                 , 108, 220, 200,   0,	"Enderpearl"					,    0,       0,         -1,    0, false, false,   1,  16,  10, Dyes.dyeGreen		, 1, Arrays.asList(new MaterialStack(Beryllium, 1), new MaterialStack(Potassium, 4), new MaterialStack(Nitrogen, 5), new MaterialStack(Magic, 6)), Arrays.asList(new TC_AspectStack(TC_Aspects.ALIENIS, 4), new TC_AspectStack(TC_Aspects.ITER, 4), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 2)));
    public static Materials EnderEye		= new Materials( 533, SET_SHINY				,   1.0F,     16,  1, 1  |4                                 , 160, 250, 230,   0,	"Endereye"						,    5,      10,         -1,    0, false, false,   1,   2,   1, Dyes.dyeGreen		, 2, Arrays.asList(new MaterialStack(EnderPearl, 1), new MaterialStack(Blaze, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.SENSUS, 4), new TC_AspectStack(TC_Aspects.ALIENIS, 4), new TC_AspectStack(TC_Aspects.ITER, 4), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 3), new TC_AspectStack(TC_Aspects.IGNIS, 2)));
    public static Materials Flint			= new Materials( 802, SET_FLINT				,   2.5F,     64,  1, 1            |64                      ,   0,  32,  64,   0,	"Flint"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray		, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.TERRA, 1), new TC_AspectStack(TC_Aspects.INSTRUMENTUM, 1)));
    public static Materials Diatomite		= new Materials( 948, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 225, 225, 225,   0,	"Diatomite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray		, 2, Arrays.asList(new MaterialStack(Flint, 8), new MaterialStack(BandedIron, 1), new MaterialStack(Sapphire, 1)));
    public static Materials VolcanicAsh		= new Materials( -1, SET_FLINT				,   1.0F,      0,  0, 1                                     ,  60,  50,  50,   0,	"Volcanic Ashes"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Flint, 6), new MaterialStack(Iron, 1), new MaterialStack(Magnesium, 1)));
    public static Materials Niter			= new Materials( 531, SET_FLINT				,   1.0F,      0,  1, 1  |4|8                               , 255, 200, 200,   0,	"Niter"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePink		, 2, Arrays.asList(new MaterialStack(Saltpeter, 1)));
    public static Materials Pyrotheum		= new Materials( 843, SET_FIERY				,   1.0F,      0,  1, 1                                     , 255, 128,   0,   0,	"Pyrotheum"						,    2,      62,         -1,    0, false, false,   2,   3,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Coal, 1), new MaterialStack(Redstone, 1), new MaterialStack(Blaze, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.PRAECANTATIO, 2), new TC_AspectStack(TC_Aspects.IGNIS, 1)));
    public static Materials HydratedCoal	= new Materials( 818, SET_ROUGH				,   1.0F,      0,  1, 1                                     ,  70,  70, 100,   0,	"Hydrated Coal"					,    0,       0,         -1,    0, false, false,   1,   9,   8, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Coal, 8), new MaterialStack(Water, 1)));
    public static Materials Apatite			= new Materials( 530, SET_DIAMOND			,   1.0F,      0,  1, 1  |4|8                               , 200, 200, 255,   0,	"Apatite"						,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeCyan		, 1, Arrays.asList(new MaterialStack(Calcium, 5), new MaterialStack(Phosphate, 3), new MaterialStack(Chlorine, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.MESSIS, 2)));
    public static Materials Alumite			= new Materials(  -1, SET_METALLIC			,   1.5F,     64,  0, 1|2          |64                      , 255, 255, 255,   0,	"Alumite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePink		, 2, Arrays.asList(new MaterialStack(Aluminium, 5), new MaterialStack(Iron, 2), new MaterialStack(Obsidian, 2)), Arrays.asList(new TC_AspectStack(TC_Aspects.STRONTIO, 2)));
    public static Materials Manyullyn		= new Materials(  -1, SET_METALLIC			,   1.5F,     64,  0, 1|2          |64                      , 255, 255, 255,   0,	"Manyullyn"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePurple		, 2, Arrays.asList(new MaterialStack(Cobalt, 1), new MaterialStack(Aredrite, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.STRONTIO, 2)));
    public static Materials ShadowIron		= new Materials( 336, SET_METALLIC			,   6.0F,    384,  2, 1|2  |8      |64                      , 120, 120, 120,   0,	"Shadowiron"					,    0,       0,         -1,    0, false, false,   3,   4,   3, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Magic, 1)));
    public static Materials ShadowSteel		= new Materials( 337, SET_METALLIC			,   6.0F,    768,  2, 1|2          |64                      ,  90,  90,  90,   0,	"Shadowsteel"					,    0,       0,         -1, 1700, true, false,   4,   4,   3, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Steel, 3), new MaterialStack(Magic, 1)));
    public static Materials Steeleaf		= new Materials( 339, SET_LEAF				,   8.0F,    768,  3, 1|2          |64|128                  ,  50, 127,  50,   0,	"Steeleaf"						,    5,      24,         -1,    0, false, false,   4,   1,   1, Dyes.dyeGreen		, 2, Arrays.asList(new MaterialStack(Steel, 1), new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.HERBA, 2), new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 1)));
    public static Materials Knightmetal		= new Materials( 362, SET_METALLIC			,   8.0F,   1024,  3, 1|2          |64|128                  , 210, 240, 200,   0,	"Knightmetal"					,    5,      24,         -1,    0, false, false,   4,   1,   1, Dyes.dyeLime		, 2, Arrays.asList(new MaterialStack(Steel, 2), new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.LUCRUM, 1), new TC_AspectStack(TC_Aspects.METALLUM, 2)));
    public static Materials SterlingSilver	= new Materials( 350, SET_SHINY				,  13.0F,    128,  2, 1|2          |64|128                  , 250, 220, 225,   0,	"Sterling Silver"				,    0,       0,         -1, 1700, true, false,   4,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Silver, 4)));
    public static Materials RoseGold		= new Materials( 351, SET_SHINY				,  14.0F,    128,  2, 1|2          |64|128                  , 255, 230,  30,   0,	"Rose Gold"						,    0,       0,         -1, 1600, true, false,   4,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Gold, 4)));
    public static Materials BlackBronze		= new Materials( 352, SET_DULL				,  12.0F,    256,  2, 1|2          |64|128                  , 100,  50, 125,   0,	"Black Bronze"					,    0,       0,         -1, 2000, true, false,   4,   1,   1, Dyes.dyePurple		, 2, Arrays.asList(new MaterialStack(Gold, 1), new MaterialStack(Silver, 1), new MaterialStack(Copper, 3)));
    public static Materials BismuthBronze	= new Materials( 353, SET_DULL				,   8.0F,    256,  2, 1|2          |64|128                  , 100, 125, 125,   0,	"Bismuth Bronze"				,    0,       0,         -1, 1100, true, false,   4,   1,   1, Dyes.dyeCyan		, 2, Arrays.asList(new MaterialStack(Bismuth, 1), new MaterialStack(Zinc, 1), new MaterialStack(Copper, 3)));
    public static Materials BlackSteel		= new Materials( 334, SET_METALLIC			,   6.5F,    768,  2, 1|2          |64                      , 100, 100, 100,   0,	"Black Steel"					,    0,       0,         -1, 1200, true, false,   4,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Nickel, 1), new MaterialStack(BlackBronze, 1), new MaterialStack(Steel, 3)));
    public static Materials RedSteel		= new Materials( 348, SET_METALLIC			,   7.0F,    896,  2, 1|2          |64                      , 140, 100, 100,   0,	"Red Steel"						,    0,       0,         -1, 1300, true, false,   4,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(SterlingSilver, 1), new MaterialStack(BismuthBronze, 1), new MaterialStack(Steel, 2), new MaterialStack(BlackSteel, 4)));
    public static Materials BlueSteel		= new Materials( 349, SET_METALLIC			,   7.5F,   1024,  2, 1|2          |64                      , 100, 100, 140,   0,	"Blue Steel"					,    0,       0,         -1, 1400, true, false,   4,   1,   1, Dyes.dyeBlue		, 2, Arrays.asList(new MaterialStack(RoseGold, 1), new MaterialStack(Brass, 1), new MaterialStack(Steel, 2), new MaterialStack(BlackSteel, 4)));
    public static Materials DamascusSteel	= new Materials( 335, SET_METALLIC			,   8.0F,   1280,  2, 1|2          |64                      , 110, 110, 110,   0,	"Damascus Steel"				,    0,       0,       2000, 1500, true, false,   4,   1,   1, Dyes.dyeGray		, 2, Arrays.asList(new MaterialStack(Steel, 1)));
    public static Materials TungstenSteel	= new Materials( 316, SET_METALLIC			,   8.0F,   2560,  4, 1|2          |64|128                  , 100, 100, 160,   0,	"Tungstensteel"					,    0,       0,         -1, 3000, true, false,   4,   1,   1, Dyes.dyeBlue		, 2, Arrays.asList(new MaterialStack(Steel, 1), new MaterialStack(Tungsten, 1)));
    public static Materials NitroCoalFuel	= new Materials(  -1, SET_FLUID				,   1.0F,      0,  2,         16                            ,  50,  70,  50,   0,	"Nitro-Coalfuel"				,    0,      48,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 0, Arrays.asList(new MaterialStack(Glyceryl, 1), new MaterialStack(CoalFuel, 4)));
    public static Materials NitroFuel		= new Materials( 709, SET_FLUID				,   1.0F,      0,  2,         16                            , 200, 255,   0,   0,	"Nitro-Diesel"					,    0,     512,         -1,    0, false, false,   1,   1,   1, Dyes.dyeLime		, 0, Arrays.asList(new MaterialStack(Glyceryl, 1), new MaterialStack(Fuel, 4)));
    public static Materials AstralSilver	= new Materials( 333, SET_SHINY				,  10.0F,     64,  2, 1|2  |8      |64                      , 230, 230, 255,   0,	"Astral Silver"					,    0,       0,         -1,    0, false, false,   4,   3,   2, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Silver, 2), new MaterialStack(Magic, 1)));
    public static Materials Midasium		= new Materials( 332, SET_SHINY				,  12.0F,     64,  2, 1|2  |8      |64                      , 255, 200,  40,   0,	"Midasium"						,    0,       0,         -1,    0, false, false,   4,   3,   2, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Gold, 2), new MaterialStack(Magic, 1)));
    public static Materials Mithril			= new Materials( 331, SET_SHINY				,  14.0F,     64,  3, 1|2  |8      |64                      , 255, 255, 210,   0,	"Mithril"						,    0,       0,         -1,    0, false, false,   4,   3,   2, Dyes.dyeLightBlue	, 2, Arrays.asList(new MaterialStack(Platinum, 2), new MaterialStack(Magic, 1)));
    public static Materials BlueAlloy       = new Materials(309,TextureSet.SET_DULL, 1.0F, 0, 0, 1 | 2, 100, 180, 255, 0, "Blue Alloy", 0, 0, -1, 0, false, false, 3, 5, 1,Dyes.dyeLightBlue, 2,Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(Teslatite, 4)), Arrays.asList(new TC_AspectStack(TC_Aspects.ELECTRUM, 3)));
    public static Materials RedAlloy		= new Materials( 308, SET_DULL				,   1.0F,      0,  0, 1|2                                   , 200,   0,   0,   0,	"Red Alloy"						,    0,       0,         -1,    0, false, false,   3,   5,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(Metal, 1), new MaterialStack(Redstone, 4)), Arrays.asList(new TC_AspectStack(TC_Aspects.MACHINA, 3)));
    public static Materials CobaltBrass		= new Materials( 343, SET_METALLIC			,   8.0F,    256,  2, 1|2          |64|128                  , 180, 180, 160,   0,	"Cobalt Brass"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(Brass, 7), new MaterialStack(Aluminium, 1), new MaterialStack(Cobalt, 1)));
    public static Materials Phosphorus		= new Materials( 534, SET_FLINT				,   1.0F,      0,  2, 1  |4|8|16                            , 255, 255,   0,   0,	"Phosphorus"					,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Phosphate, 2)));
    public static Materials Basalt			= new Materials( 844, SET_ROUGH				,   1.0F,      0,  1, 1                                     ,  30,  20,  20,   0,	"Basalt"						,    0,       0,         -1,    0, false, false,   2,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Olivine, 1), new MaterialStack(Calcite, 3), new MaterialStack(Flint, 8), new MaterialStack(DarkAsh, 4)), Arrays.asList(new TC_AspectStack(TC_Aspects.TENEBRAE, 1)));
    public static Materials GarnetRed		= new Materials( 527, SET_RUBY				,   7.0F,    128,  2, 1  |4|8      |64                      , 200,  80,  80, 127,	"Red Garnet"					,    0,       0,         -1,    0, false, true,   4,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(Pyrope, 3), new MaterialStack(Almandine, 5), new MaterialStack(Spessartine, 8)), Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials GarnetYellow	= new Materials( 528, SET_RUBY				,   7.0F,    128,  2, 1  |4|8      |64                      , 200, 200,  80, 127,	"Yellow Garnet"					,    0,       0,         -1,    0, false, true,   4,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Andradite, 5), new MaterialStack(Grossular, 8), new MaterialStack(Uvarovite, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 3)));
    public static Materials Marble			= new Materials( 845, SET_FINE				,   1.0F,      0,  1, 1                                     , 200, 200, 200,   0,	"Marble"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Calcite, 7)), Arrays.asList(new TC_AspectStack(TC_Aspects.PERFODIO, 1)));
    public static Materials Sugar			= new Materials( 803, SET_FINE				,   1.0F,      0,  1, 1                                     , 250, 250, 250,   0,	"Sugar"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 1, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Water, 5), new MaterialStack(Oxygen, 25)), Arrays.asList(new TC_AspectStack(TC_Aspects.HERBA, 1), new TC_AspectStack(TC_Aspects.AQUA, 1), new TC_AspectStack(TC_Aspects.AER, 1)));
    public static Materials Thaumium		= new Materials( 330, SET_METALLIC			,  12.0F,    256,  3, 1|2          |64|128                  , 150, 100, 200,   0,	"Thaumium"						,    0,       0,         -1,    0, false, false,   5,   2,   1, Dyes.dyePurple		, 0, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 1)));
    public static Materials Vinteum			= new Materials( 529, SET_EMERALD			,  10.0F,    128,  3, 1  |4|8      |64                      , 100, 200, 255,   0,	"Vinteum"						,    5,      32,         -1,    0, false, false,   4,   1,   1, Dyes.dyeLightBlue	, 2, Arrays.asList(new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.VITREUS, 2), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 1)));
    public static Materials Vis				= new Materials(  -1, SET_SHINY				,   1.0F,      0,  3, 0                                     , 128,   0, 255,   0,	"Vis"							,    5,      32,         -1,    0, false, false,   1,   1,   1, Dyes.dyePurple		, 2, Arrays.asList(new MaterialStack(Magic, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.AURAM, 2), new TC_AspectStack(TC_Aspects.PRAECANTATIO, 1)));
    public static Materials Redrock			= new Materials( 846, SET_ROUGH				,   1.0F,      0,  1, 1                                     , 255,  80,  50,   0,	"Redrock"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(Calcite, 2), new MaterialStack(Flint, 1), new MaterialStack(Clay, 1)));
    public static Materials PotassiumFeldspar= new Materials( 847, SET_FINE				,   1.0F,      0,  1, 1                                     , 120,  40,  40,   0,	"Potassium Feldspar"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyePink		, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 8)));
    public static Materials Biotite			= new Materials( 848, SET_METALLIC			,   1.0F,      0,  1, 1                                     ,  20,  30,  20,   0,	"Biotite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 3), new MaterialStack(Aluminium, 3), new MaterialStack(Fluorine, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 10)));
    public static Materials GraniteBlack	= new Materials( 849, SET_ROUGH				,   4.0F,     64,  3, 1            |64|128                  ,  10,  10,  10,   0,	"Black Granite"					,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 4), new MaterialStack(Biotite, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.TUTAMEN, 1)));
    public static Materials GraniteRed		= new Materials( 850, SET_ROUGH				,   4.0F,     64,  3, 1            |64|128                  , 255,   0, 128,   0,	"Red Granite"					,    0,       0,         -1,    0, false, false,   0,   1,   1, Dyes.dyeMagenta		, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(PotassiumFeldspar, 1), new MaterialStack(Oxygen, 3)), Arrays.asList(new TC_AspectStack(TC_Aspects.TUTAMEN, 1)));
    public static Materials Chrysotile		= new Materials( 912, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 110, 140, 110,   0,	"Chrysotile"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Asbestos, 1)));
    public static Materials Realgar			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 140, 100, 100,   0,	"Realgar"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Arsenic, 4), new MaterialStack(Sulfur,4)));
    public static Materials VanadiumMagnetite= new Materials( 923, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               ,  35,  35,  60,   0,	"Vanadium Magnetite"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(Vanadium, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1))); // Mixture of Fe3O4 and V2O5
    public static Materials BasalticMineralSand= new Materials( 935, SET_SAND				,   1.0F,      0,  1, 1    |8                               ,  40,  50,  40,   0,	"Basaltic Mineral Sand"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(Basalt, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials GraniticMineralSand= new Materials( 936, SET_SAND				,   1.0F,      0,  1, 1    |8                               ,  40,  60,  60,   0,	"Granitic Mineral Sand"			,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeBlack		, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(GraniteBlack, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials GarnetSand		= new Materials( 938, SET_SAND				,   1.0F,      0,  1, 1    |8                               , 200, 100,   0,   0,	"Garnet Sand"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeOrange		, 2, Arrays.asList(new MaterialStack(GarnetRed, 1), new MaterialStack(GarnetYellow, 1)));
    public static Materials QuartzSand		= new Materials( 939, SET_SAND				,   1.0F,      0,  1, 1    |8                               , 200, 200, 200,   0,	"Quartz Sand"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(CertusQuartz, 1), new MaterialStack(Quartzite, 1)));
    public static Materials Bastnasite		= new Materials( 905, SET_FINE				,   1.0F,      0,  2, 1    |8                               , 200, 110,  45,   0,	"Bastnasite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Cerium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Fluorine, 1), new MaterialStack(Oxygen, 3))); // (Ce, La, Y)CO3F
    public static Materials Pentlandite		= new Materials( 909, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 165, 150,   5,   0,	"Pentlandite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Nickel, 9), new MaterialStack(Sulfur, 8))); // (Fe,Ni)9S8
    public static Materials Spodumene		= new Materials( 920, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 190, 170, 170,   0,	"Spodumene"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 6))); // LiAl(SiO3)2
    public static Materials Pollucite		= new Materials( 919, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 240, 210, 210,   0,	"Pollucite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Caesium, 2), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 4), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 12))); // (Cs,Na)2Al2Si4O12 2H2O (also a source of Rb)
    public static Materials Tantalite		= new Materials( 921, SET_METALLIC			,   1.0F,      0,  3, 1    |8                               , 145,  80,  40,   0,	"Tantalite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Tantalum, 2), new MaterialStack(Oxygen, 6))); // (Fe, Mn)Ta2O6 (also source of Nb)
    public static Materials Lepidolite		= new Materials( 907, SET_FINE				,   1.0F,      0,  2, 1    |8                               , 240,  50, 140,   0,	"Lepidolite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Lithium, 3), new MaterialStack(Aluminium, 4), new MaterialStack(Fluorine, 2), new MaterialStack(Oxygen, 10))); // K(Li,Al,Rb)3(Al,Si)4O10(F,OH)2
    public static Materials Glauconite		= new Materials( 933, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 130, 180,  60,   0,	"Glauconite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 2), new MaterialStack(Aluminium, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // (K,Na)(Fe3+,Al,Mg)2(Si,Al)4O10(OH)2
    public static Materials GlauconiteSand	= new Materials( 949, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 130, 180,  60,   0,	"Glauconite Sand"				,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 2), new MaterialStack(Aluminium, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // (K,Na)(Fe3+,Al,Mg)2(Si,Al)4O10(OH)2
    public static Materials Vermiculite		= new Materials( 932, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               , 200, 180,  15,   0,	"Vermiculite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Aluminium, 4), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Water, 4), new MaterialStack(Oxygen, 12))); // (Mg+2, Fe+2, Fe+3)3 [(AlSi)4O10] (OH)2 4H2O)
    public static Materials Bentonite		= new Materials( 927, SET_ROUGH				,   1.0F,      0,  2, 1    |8                               , 245, 215, 210,   0,	"Bentonite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Magnesium, 6), new MaterialStack(Silicon, 12), new MaterialStack(Hydrogen, 6), new MaterialStack(Water, 5), new MaterialStack(Oxygen, 36))); // (Na,Ca)0.33(Al,Mg)2(Si4O10)(OH)2 nH2O
    public static Materials FullersEarth	= new Materials( 928, SET_FINE				,   1.0F,      0,  2, 1    |8                               , 160, 160, 120,   0,	"Fullers Earth"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 1), new MaterialStack(Water, 4), new MaterialStack(Oxygen, 11))); // (Mg,Al)2Si4O10(OH) 4(H2O)
    public static Materials Pitchblende		= new Materials( 873, SET_DULL				,   1.0F,      0,  3, 1    |8                               , 200, 210,   0,   0,	"Pitchblende"					,    0,       0,         -1,    0, false, false,   5,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(Uraninite, 3), new MaterialStack(Thorium, 1), new MaterialStack(Lead, 1)));
    public static Materials Monazite		= new Materials( 520, SET_DIAMOND			,   1.0F,      0,  1, 1  |4|8                               ,  50,  70,  50,   0,	"Monazite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeGreen		, 1, Arrays.asList(new MaterialStack(RareEarth, 1), new MaterialStack(Phosphate, 1))); // Wikipedia: (Ce, La, Nd, Th, Sm, Gd)PO4 Monazite also smelt-extract to Helium, it is brown like the rare earth Item Monazite sand deposits are inevitably of the monazite-(Ce) composition. Typically, the lanthanides in such monazites contain about 45ִ8% cerium, about 24% lanthanum, about 17% neodymium, about 5% praseodymium, and minor quantities of samarium, gadolinium, and yttrium. Europium concentrations tend to be low, about 0.05% Thorium content of monazite is variable and sometimes can be up to 20ֳ0%
    public static Materials Malachite		= new Materials( 871, SET_DULL				,   1.0F,      0,  2, 1    |8                               ,   5,  95,   5,   0,	"Malachite"						,    0,       0,         -1,    0, false, false,   3,   1,   1, Dyes.dyeGreen		, 1, Arrays.asList(new MaterialStack(Copper, 2), new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 5))); // Cu2CO3(OH)2
    public static Materials Mirabilite		= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 240, 250, 210,   0,	"Mirabilite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Water, 10), new MaterialStack(Oxygen, 4))); // Na2SO4 10H2O
    public static Materials Mica			= new Materials( -1, SET_FINE				,   1.0F,      0,  1, 1    |8                               , 195, 195, 205,   0,	"Mica"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Fluorine, 2), new MaterialStack(Oxygen, 10))); // KAl2(AlSi3O10)(F,OH)2
    public static Materials Trona			= new Materials( -1, SET_METALLIC			,   1.0F,      0,  1, 1    |8                               , 135, 135,  95,   0,	"Trona"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Sodium, 3), new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 1), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 6))); // Na3(CO3)(HCO3) 2H2O
    public static Materials Barite			= new Materials( 904, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 230, 235, 255,   0,	"Barite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Barium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
    public static Materials Gypsum			= new Materials( -1, SET_DULL				,   1.0F,      0,  1, 1    |8                               , 230, 230, 250,   0,	"Gypsum"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 4))); // CaSO4 2H2O
    public static Materials Alunite			= new Materials( -1, SET_METALLIC			,   1.0F,      0,  2, 1    |8                               , 225, 180,  65,   0,	"Alunite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 14))); // KAl3(SO4)2(OH)6
    public static Materials Dolomite		= new Materials( -1, SET_FLINT				,   1.0F,      0,  1, 1    |8                               , 225, 205, 205,   0,	"Dolomite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Magnesium, 1), new MaterialStack(Carbon, 2), new MaterialStack(Oxygen, 6))); // CaMg(CO3)2
    public static Materials Wollastonite	= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 240, 240, 240,   0,	"Wollastonite"					,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 3))); // CaSiO3
    public static Materials Zeolite			= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 240, 230, 230,   0,	"Zeolite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Calcium, 4), new MaterialStack(Silicon, 27), new MaterialStack(Aluminium, 9), new MaterialStack(Water, 28), new MaterialStack(Oxygen, 72))); // NaCa4(Si27Al9)O72 28(H2O)
    public static Materials Kyanite			= new Materials( -1, SET_FLINT				,   1.0F,      0,  2, 1    |8                               , 110, 110, 250,   0,	"Kyanite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 5))); // Al2SiO5
    public static Materials Kaolinite		= new Materials( -1, SET_DULL				,   1.0F,      0,  2, 1    |8                               , 245, 235, 235,   0,	"Kaolinite"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 9))); // Al2Si2O5(OH)4
    public static Materials Talc			= new Materials( 902, SET_DULL				,   1.0F,      0,  2, 1    |8                               ,  90, 180,  90,   0,	"Talc"							,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // H2Mg3(SiO3)4
    public static Materials Soapstone		= new Materials( 877, SET_DULL				,   1.0F,      0,  1, 1    |8                               ,  95, 145,  95,   0,	"Soapstone"						,    0,       0,         -1,    0, false, false,   1,   1,   1, Dyes._NULL			, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // H2Mg3(SiO3)4
    public static Materials Concrete		= new Materials( 947, SET_ROUGH				,   1.0F,      0,  1, 1                                     , 100, 100, 100,   0,	"Concrete"						,    0,       0,        300,    0, false, false,   0,   1,   1, Dyes.dyeGray		, 0, Arrays.asList(new MaterialStack(Stone, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.TERRA, 1)));
    public static Materials IronMagnetic	= new Materials( 354, SET_MAGNETIC			,   6.0F,    256,  2, 1|2          |64|128                  , 200, 200, 200,   0,	"Magnetic Iron"					,    0,       0,         -1,    0, false, false,   4,  51,  50, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Iron, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 2), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials SteelMagnetic	= new Materials( 355, SET_MAGNETIC			,   6.0F,    512,  2, 1|2          |64|128                  , 128, 128, 128,   0,	"Magnetic Steel"				,    0,       0,       1000, 1000, true, false,   4,  51,  50, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Steel, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 1), new TC_AspectStack(TC_Aspects.ORDO, 1), new TC_AspectStack(TC_Aspects.MAGNETO, 1)));
    public static Materials NeodymiumMagnetic= new Materials( 356, SET_MAGNETIC			,   7.0F,    512,  2, 1|2          |64|128                  , 100, 100, 100,   0,	"Magnetic Neodymium"			,    0,       0,       1297, 1297, true, false,   4,  51,  50, Dyes.dyeGray		, 1, Arrays.asList(new MaterialStack(Neodymium, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.METALLUM, 1), new TC_AspectStack(TC_Aspects.MAGNETO, 3)));
    public static Materials TungstenCarbide	= new Materials( 370, SET_METALLIC           ,    12.0F,  5120, 4,  1|2 |        64|128                   , 24, 28, 48, 0,        "Tungsten Carbide"            ,  0,     0,           2460, 2460, true, false, 4, 1, 1, Dyes.dyeBlack             , 2, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Tungsten, 1)));
    public static Materials VanadiumSteel	= new Materials( 371, SET_METALLIC			,   8.0F,   2560,  3, 1|2          |64|128                  , 192, 192, 192,   0,	"Vanadium Steel"					,    0,       0,       1453, 1453, true, false,   4,   1,   1, Dyes.dyeWhite		, 2, Arrays.asList(new MaterialStack(Vanadium, 1), new MaterialStack(Chrome, 1), new MaterialStack(Steel, 7)));
    public static Materials HSSG			= new Materials( 372, SET_METALLIC			,  12.0F,   7680,  4, 1|2          |64|128                  , 153, 153,   0,   0,	"HSS-G"							,    0,       0,       4500, 4500, true, false,   4,   1,   1, Dyes.dyeYellow		, 2, Arrays.asList(new MaterialStack(TungstenSteel, 5), new MaterialStack(Chrome, 1), new MaterialStack(Molybdenum, 2), new MaterialStack(Vanadium, 1)));
    public static Materials HSSE			= new Materials( 373, SET_METALLIC			,  12.0F,   10240,  4, 1|2          |64|128                  ,  51, 102,   0,   0,	"HSS-E"							,    0,       0,       5400, 5400, true, false,   4,   1,   1, Dyes.dyeBlue		, 2, Arrays.asList(new MaterialStack(HSSG, 6), new MaterialStack(Cobalt, 1),new MaterialStack(Manganese, 1), new MaterialStack(Silicon, 1)));
    public static Materials HSSS			= new Materials( 374, SET_METALLIC			,  16.0F,   7680,  4, 1|2          |64|128                  , 102,   0,  51,   0,	"HSS-S"							,    0,       0,       5400, 5400, true, false,   4,   1,   1, Dyes.dyeRed			, 2, Arrays.asList(new MaterialStack(HSSG, 6), new MaterialStack(Iridium, 2), new MaterialStack(Osmium, 1)));
    public static Materials Vibranium	    = new Materials( 970, SET_EMERALD				,   100.0F,    512,  6, 1  |4|8      |64                      , 200, 128, 255, 127,	"Vibranium"							,    0,       0,         -1,    0, false, true,   20,   1,   1, Dyes.dyePurple			,  Arrays.asList(new TC_AspectStack(TC_Aspects.SENSUS, 10), new TC_AspectStack(TC_Aspects.VITREUS, 10)));
    public static Materials PurpleAlloy     = new Materials(521, SET_DULL                 , 1.0F,     0,     0, 1|2,                                  225,     80, 232, 0,    "Purple Alloy"                  ,0,           0,        -1,     0, false, false, 3,     5, 1, Dyes.dyePurple      ,2, Arrays.asList(new MaterialStack(BlueAlloy, 1), new MaterialStack(RedAlloy, 1)), Arrays.asList(new TC_AspectStack(TC_Aspects.ELECTRUM, 3)));


    /**
     * Materials which are renamed automatically
     */
    @Deprecated public static Materials IridiumAndSodiumOxide = new Materials(IridiumSodiumOxide, false);
    @Deprecated public static Materials Palygorskite = new Materials(FullersEarth, false);
    @Deprecated public static Materials Adamantine = new Materials(Adamantium, true);
    @Deprecated public static Materials Ashes = new Materials(Ash, false);
    @Deprecated public static Materials DarkAshes = new Materials(DarkAsh, false);
    @Deprecated public static Materials Abyssal = new Materials(Basalt, false);
    @Deprecated public static Materials Adamant = new Materials(Adamantium, true);
    @Deprecated public static Materials AluminumBrass = new Materials(AluminiumBrass, false);
    @Deprecated public static Materials Aluminum = new Materials(Aluminium, false);
    @Deprecated public static Materials NaturalAluminum = new Materials(Aluminium, false);
    @Deprecated public static Materials NaturalAluminium = new Materials(Aluminium, false);
    @Deprecated public static Materials Americum = new Materials(Americium, false);
    @Deprecated public static Materials Beryl = new Materials(Emerald, false);
    @Deprecated public static Materials BlackGranite = new Materials(GraniteBlack, false);
    @Deprecated public static Materials CalciumCarbonate = new Materials(Calcite, false);
    @Deprecated public static Materials CreosoteOil = new Materials(Creosote, false);
    @Deprecated public static Materials Chromium = new Materials(Chrome, false);
    @Deprecated public static Materials Diesel = new Materials(Fuel, false);
    @Deprecated public static Materials Enderpearl = new Materials(EnderPearl, false);
    @Deprecated public static Materials Endereye = new Materials(EnderEye, false);
    @Deprecated public static Materials EyeOfEnder = new Materials(EnderEye, false);
    @Deprecated public static Materials Eyeofender = new Materials(EnderEye, false);
    @Deprecated public static Materials Flour = new Materials(Wheat, false);
    @Deprecated public static Materials Meat = new Materials(MeatRaw, false);
    @Deprecated public static Materials Garnet = new Materials(GarnetRed, true);
    @Deprecated public static Materials Granite = new Materials(GraniteBlack, false);
    @Deprecated public static Materials Goethite = new Materials(BrownLimonite, false);
    @Deprecated public static Materials Kalium = new Materials(Potassium, false);
    @Deprecated public static Materials Lapislazuli = new Materials(Lapis, false);
    @Deprecated public static Materials LapisLazuli = new Materials(Lapis, false);
    @Deprecated public static Materials Monazit = new Materials(Monazite, false);
    @Deprecated public static Materials Natrium = new Materials(Sodium, false);
    @Deprecated public static Materials Mythril = new Materials(Mithril, false);
    @Deprecated public static Materials NitroDiesel = new Materials(NitroFuel, false);
    @Deprecated public static Materials Naquadriah = new Materials(Naquadria, false);
    @Deprecated public static Materials Obby = new Materials(Obsidian, false);
    @Deprecated public static Materials Peridot = new Materials(Olivine, true);
    @Deprecated public static Materials Phosphorite = new Materials(Phosphorus, true);
    @Deprecated public static Materials Quarried = new Materials(Marble, false);
    @Deprecated public static Materials Quicksilver = new Materials(Mercury, true);
    @Deprecated public static Materials QuickSilver = new Materials(Mercury, false);
    @Deprecated public static Materials RedRock = new Materials(Redrock, false);
    @Deprecated public static Materials RefinedIron = new Materials(Iron, false);
    @Deprecated public static Materials RedGranite = new Materials(GraniteRed, false);
    @Deprecated public static Materials Sheldonite = new Materials(Cooperite, false);
    @Deprecated public static Materials Soulsand = new Materials(SoulSand, false);
    @Deprecated public static Materials Titan = new Materials(Titanium, false);
    @Deprecated public static Materials Uran = new Materials(Uranium, false);
    @Deprecated public static Materials Wolframite = new Materials(Tungstate, false);
    @Deprecated public static Materials Wolframium = new Materials(Tungsten, false);
    @Deprecated public static Materials Wolfram = new Materials(Tungsten, false);

    private IColorModulationContainer mRGBa = new IColorModulationContainer(0x00ffffff);
    private IColorModulationContainer mMoltenRGBa = new IColorModulationContainer(0x00ffffff);
    private TextureSet mIconSet;
    private int mMetaItemSubID;
    private boolean mUnificatable;
    private Materials mMaterialInto;
    private List<MaterialStack> mMaterialList = new ArrayList<>();
    public List<Materials> mOreByProducts = new ArrayList<>();
    public List<Materials> mOreReRegistrations = new ArrayList<>();
    public List<TC_Aspects.TC_AspectStack> mAspects = new ArrayList<>();
    private List<ItemStack> mMaterialItems = new ArrayList<>();
    private Collection<SubTag> mSubTags = new HashSet<>();
    public Enchantment mEnchantmentTools = null;
    public Enchantment mEnchantmentArmors = null;
    public byte mEnchantmentToolsLevel = 0;
    public byte mEnchantmentArmorsLevel = 0;
    public boolean mBlastFurnaceRequired = false;
    public float mToolSpeed = 1.0F;
    public float mHeatDamage = 0.0F;
    public String mChemicalFormula = "?";
    private String mName = "null";
    public String mDefaultLocalName = "null";
    public Dyes mColor = Dyes._NULL;
    public short mMeltingPoint = 0;
    public short mBlastFurnaceTemp = 0;
    public int mTypes = 0;
    public int mDurability = 16;
    public int mFuelPower = 0;
    public int mFuelType = 0;
    public int mExtraData = 0;
    public int mOreValue = 0;
    public int mOreMultiplier = 1;
    public int mByProductMultiplier = 1;
    public int mSmeltingMultiplier = 1;
    private long mDensity = MATERIAL_UNIT;
    public Element mElement = null;
    public Materials mDirectSmelting = this;
    public Materials mOreReplacement = this;
    public Materials mMacerateInto = this;
    public Materials mSmeltInto = this;
    public Materials mArcSmeltInto = this;
    public Materials mHandleMaterial = this;
    public byte mToolQuality = 0;
    public Fluid mSolid = null;
    public Fluid mFluid = null;
    public Fluid mGas = null;
    public Fluid mPlasma = null;

    /**
     * This Fluid is used as standard Unit for Molten Materials. 1296 is a Molten Block, what means 144 is one Material Unit worth
     */
    public Fluid mStandardMoltenFluid = null;


    static {
        initSubTags();
        Iron			         .mOreReRegistrations.add(AnyIron	);
        PigIron					.mOreReRegistrations.add(AnyIron	);
        WroughtIron				.mOreReRegistrations.add(AnyIron	);

        Copper					.mOreReRegistrations.add(AnyCopper	);
        AnnealedCopper			.mOreReRegistrations.add(AnyCopper	);

        Bronze					.mOreReRegistrations.add(AnyBronze	);

        Peanutwood				.setMaceratingInto(Wood				);
        WoodSealed				.setMaceratingInto(Wood				);
        NetherBrick				.setMaceratingInto(Netherrack		);


        NeodymiumMagnetic		.setSmeltingInto(Neodymium			).setMaceratingInto(Neodymium		).setArcSmeltingInto(Neodymium			);
        SteelMagnetic			.setSmeltingInto(Steel				).setMaceratingInto(Steel			).setArcSmeltingInto(Steel				);
        Iron					.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        AnyIron					.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        PigIron					.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        WroughtIron				.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        IronMagnetic			.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        Copper					.setSmeltingInto(Copper				).setMaceratingInto(Copper			).setArcSmeltingInto(AnnealedCopper		);
        AnyCopper				.setSmeltingInto(Copper				).setMaceratingInto(Copper			).setArcSmeltingInto(AnnealedCopper		);
        AnnealedCopper			.setSmeltingInto(Copper				).setMaceratingInto(Copper			).setArcSmeltingInto(AnnealedCopper		);
        Netherrack				.setSmeltingInto(NetherBrick		);
        MeatRaw					.setSmeltingInto(MeatCooked			);
        Sand					.setSmeltingInto(Glass				);
        Ice						.setSmeltingInto(Water				);
        Snow					.setSmeltingInto(Water				);

        Mercury					.add(SubTag.SMELTING_TO_GEM);
        Cinnabar				.setDirectSmelting(Mercury		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT).add(SubTag.SMELTING_TO_GEM);
        /*Tetrahedrite			.setDirectSmelting(Copper		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Chalcopyrite			.setDirectSmelting(Copper		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Malachite				.setDirectSmelting(Copper		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Pentlandite				.setDirectSmelting(Nickel		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Sphalerite				.setDirectSmelting(Zinc			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Pyrite					.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        BasalticMineralSand		.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        GraniticMineralSand		.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        YellowLimonite			.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        BrownLimonite			.setDirectSmelting(Iron			);
        BandedIron				.setDirectSmelting(Iron			);
        Cassiterite				.setDirectSmelting(Tin			);
        CassiteriteSand			.setDirectSmelting(Tin			);
        Chromite				.setDirectSmelting(Chrome		);
        Garnierite				.setDirectSmelting(Nickel		);
        Cobaltite				.setDirectSmelting(Cobalt		);
        Stibnite				.setDirectSmelting(Antimony		);
        Cooperite				.setDirectSmelting(Platinum		);
        Pyrolusite				.setDirectSmelting(Manganese	);
        Magnesite				.setDirectSmelting(Magnesium	);
        Molybdenite				.setDirectSmelting(Molybdenum	);*/

        Amber					.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedAir				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedFire				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedEarth			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedWater			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedEntropy			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedOrder			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedVis				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        InfusedDull				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Salt					.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        RockSalt				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Scheelite				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Tungstate				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Cassiterite				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        CassiteriteSand			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        NetherQuartz			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        CertusQuartz			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Phosphorus				.setOreMultiplier( 3).setSmeltingMultiplier( 3);
        Saltpeter				.setOreMultiplier( 4).setSmeltingMultiplier( 4);
        Apatite					.setOreMultiplier( 4).setSmeltingMultiplier( 4).setByProductMultiplier(2);
        Teslatite				.setOreMultiplier( 5).setSmeltingMultiplier( 5);
        Redstone				.setOreMultiplier( 5).setSmeltingMultiplier( 5);
        Glowstone				.setOreMultiplier( 5).setSmeltingMultiplier( 5);
        Lapis					.setOreMultiplier( 6).setSmeltingMultiplier( 6).setByProductMultiplier(4);
        Sodalite				.setOreMultiplier( 6).setSmeltingMultiplier( 6).setByProductMultiplier(4);
        Lazurite				.setOreMultiplier( 6).setSmeltingMultiplier( 6).setByProductMultiplier(4);
        Monazite				.setOreMultiplier( 8).setSmeltingMultiplier( 8).setByProductMultiplier(2);

        Plastic					.setEnchantmentForTools(Enchantment.knockback, 1);
        Rubber					.setEnchantmentForTools(Enchantment.knockback, 2);
        InfusedAir				.setEnchantmentForTools(Enchantment.knockback, 2);

        IronWood				.setEnchantmentForTools(Enchantment.fortune, 1);
        Steeleaf				.setEnchantmentForTools(Enchantment.fortune, 2);
        Midasium				.setEnchantmentForTools(Enchantment.fortune, 2);
        Mithril					.setEnchantmentForTools(Enchantment.fortune, 3);
        Vinteum					.setEnchantmentForTools(Enchantment.fortune, 1);
        Thaumium				.setEnchantmentForTools(Enchantment.fortune, 2);
        InfusedWater			.setEnchantmentForTools(Enchantment.fortune, 3);
        Vibranium                .setEnchantmentForTools(Enchantment.fortune, 5);

        Flint					.setEnchantmentForTools(Enchantment.fireAspect, 1);
        DarkIron				.setEnchantmentForTools(Enchantment.fireAspect, 2);
        Firestone				.setEnchantmentForTools(Enchantment.fireAspect, 3);
        FierySteel				.setEnchantmentForTools(Enchantment.fireAspect, 3);
        Pyrotheum				.setEnchantmentForTools(Enchantment.fireAspect, 3);
        Blaze					.setEnchantmentForTools(Enchantment.fireAspect, 3);
        InfusedFire				.setEnchantmentForTools(Enchantment.fireAspect, 3);

        Amber					.setEnchantmentForTools(Enchantment.silkTouch, 1);
        EnderPearl				.setEnchantmentForTools(Enchantment.silkTouch, 1);
        Enderium				.setEnchantmentForTools(Enchantment.silkTouch, 1);
        NetherStar				.setEnchantmentForTools(Enchantment.silkTouch, 1);
        InfusedOrder			.setEnchantmentForTools(Enchantment.silkTouch, 1);

        BlackBronze				.setEnchantmentForTools(Enchantment.smite, 2);
        Gold					.setEnchantmentForTools(Enchantment.smite, 3);
        RoseGold				.setEnchantmentForTools(Enchantment.smite, 4);
        Platinum				.setEnchantmentForTools(Enchantment.smite, 5);
        InfusedVis				.setEnchantmentForTools(Enchantment.smite, 5);

        Lead					.setEnchantmentForTools(Enchantment.baneOfArthropods, 2);
        Nickel					.setEnchantmentForTools(Enchantment.baneOfArthropods, 2);
        Invar					.setEnchantmentForTools(Enchantment.baneOfArthropods, 3);
        Antimony				.setEnchantmentForTools(Enchantment.baneOfArthropods, 3);
        BatteryAlloy			.setEnchantmentForTools(Enchantment.baneOfArthropods, 4);
        Bismuth					.setEnchantmentForTools(Enchantment.baneOfArthropods, 4);
        BismuthBronze			.setEnchantmentForTools(Enchantment.baneOfArthropods, 5);
        InfusedEarth			.setEnchantmentForTools(Enchantment.baneOfArthropods, 5);

        Iron					.setEnchantmentForTools(Enchantment.sharpness, 1);
        Bronze					.setEnchantmentForTools(Enchantment.sharpness, 1);
        Brass					.setEnchantmentForTools(Enchantment.sharpness, 2);
        HSLA					.setEnchantmentForTools(Enchantment.sharpness, 2);
        Steel					.setEnchantmentForTools(Enchantment.sharpness, 2);
        WroughtIron				.setEnchantmentForTools(Enchantment.sharpness, 2);
        StainlessSteel			.setEnchantmentForTools(Enchantment.sharpness, 3);
        Knightmetal				.setEnchantmentForTools(Enchantment.sharpness, 3);
        ShadowIron				.setEnchantmentForTools(Enchantment.sharpness, 3);
        ShadowSteel				.setEnchantmentForTools(Enchantment.sharpness, 4);
        BlackSteel				.setEnchantmentForTools(Enchantment.sharpness, 4);
        RedSteel				.setEnchantmentForTools(Enchantment.sharpness, 4);
        BlueSteel				.setEnchantmentForTools(Enchantment.sharpness, 5);
        DamascusSteel			.setEnchantmentForTools(Enchantment.sharpness, 5);
        InfusedEntropy			.setEnchantmentForTools(Enchantment.sharpness, 5);
        TungstenCarbide			.setEnchantmentForTools(Enchantment.sharpness, 5);
        HSSE					.setEnchantmentForTools(Enchantment.sharpness, 5);
        HSSG					.setEnchantmentForTools(Enchantment.sharpness, 4);
        HSSS					.setEnchantmentForTools(Enchantment.sharpness, 5);

        InfusedAir				.setEnchantmentForArmors(Enchantment.respiration, 3);

        InfusedFire				.setEnchantmentForArmors(Enchantment.featherFalling, 4);

        Steeleaf				.setEnchantmentForArmors(Enchantment.protection, 2);
        Knightmetal				.setEnchantmentForArmors(Enchantment.protection, 1);
        InfusedEarth			.setEnchantmentForArmors(Enchantment.protection, 4);

        InfusedEntropy			.setEnchantmentForArmors(Enchantment.thorns, 3);

        InfusedWater			.setEnchantmentForArmors(Enchantment.aquaAffinity, 1);
        IronWood				.setEnchantmentForArmors(Enchantment.aquaAffinity, 1);

        InfusedOrder			.setEnchantmentForArmors(Enchantment.projectileProtection, 4);

        InfusedDull				.setEnchantmentForArmors(Enchantment.blastProtection, 4);

        InfusedVis				.setEnchantmentForArmors(Enchantment.protection, 4);

        Vibranium                .setEnchantmentForTools(Enchantment.looting, 5);

        FryingOilHot			.setHeatDamage(1.0F);
        Lava					.setHeatDamage(3.0F);
        Firestone				.setHeatDamage(5.0F);
        Pyrotheum				.setHeatDamage(5.0F);

        Chalcopyrite			.addOreByProducts(Pyrite				, Cobalt				, Cadmium				, Gold			);
        Sphalerite				.addOreByProducts(GarnetYellow			, Cadmium				, Gallium				, Zinc			);
        MeteoricIron			.addOreByProducts(Iron					, Nickel				, Iridium				, Platinum		);
        GlauconiteSand			.addOreByProducts(Sodium				, Aluminium				, Iron					);
        Glauconite				.addOreByProducts(Sodium				, Aluminium				, Iron					);
        Vermiculite				.addOreByProducts(Iron					, Aluminium				, Magnesium				);
        FullersEarth			.addOreByProducts(Aluminium				, Silicon				, Magnesium				);
        Bentonite				.addOreByProducts(Aluminium				, Calcium				, Magnesium				);
        Uraninite				.addOreByProducts(Uranium				, Thorium				, Uranium235			);
        Pitchblende				.addOreByProducts(Thorium				, Uranium				, Lead					);
        Galena					.addOreByProducts(Sulfur				, Silver				, Lead					);
        Lapis					.addOreByProducts(Lazurite				, Sodalite				, Pyrite				);
        Pyrite					.addOreByProducts(Sulfur				, Phosphorus			, Iron					);
        Copper					.addOreByProducts(Cobalt				, Gold					, Nickel				);
        Nickel					.addOreByProducts(Cobalt				, Platinum				, Iron					);
        GarnetRed				.addOreByProducts(Spessartine			, Pyrope				, Almandine				);
        GarnetYellow			.addOreByProducts(Andradite				, Grossular				, Uvarovite				);
        Cooperite				.addOreByProducts(Palladium				, Nickel				, Iridium				);
        Cinnabar				.addOreByProducts(Redstone				, Sulfur				, Glowstone				);
        Tantalite				.addOreByProducts(Manganese				, Niobium				, Tantalum				);
        Pollucite				.addOreByProducts(Caesium				, Aluminium				, Rubidium				);
        Chrysotile				.addOreByProducts(Asbestos				, Silicon				, Magnesium				);
        Asbestos				.addOreByProducts(Asbestos				, Silicon				, Magnesium				);
        Pentlandite				.addOreByProducts(Iron					, Sulfur				, Cobalt				);
        Uranium					.addOreByProducts(Lead					, Uranium235			, Thorium				);
        Scheelite				.addOreByProducts(Manganese				, Molybdenum			, Calcium				);
        Tungstate				.addOreByProducts(Manganese				, Silver				, Lithium				);
        Bauxite					.addOreByProducts(Grossular				, Rutile				, Gallium				);
        QuartzSand				.addOreByProducts(CertusQuartz			, Quartzite				, Barite				);
        Quartzite				.addOreByProducts(CertusQuartz			, Barite				);
        CertusQuartz			.addOreByProducts(Quartzite				, Barite				);
        Redstone				.addOreByProducts(Cinnabar				, RareEarth				, Glowstone				);
        Monazite				.addOreByProducts(Thorium				, Neodymium				, RareEarth				);
        Forcicium				.addOreByProducts(Thorium				, Neodymium				, RareEarth				);
        Forcillium				.addOreByProducts(Thorium				, Neodymium				, RareEarth				);
        Malachite				.addOreByProducts(Copper				, BrownLimonite			, Calcite				);
        YellowLimonite			.addOreByProducts(Nickel				, BrownLimonite			, Cobalt				);
        BrownLimonite			.addOreByProducts(Malachite				, YellowLimonite		);
        Neodymium				.addOreByProducts(Monazite				, RareEarth				);
        Bastnasite				.addOreByProducts(Neodymium				, RareEarth				);
        Glowstone				.addOreByProducts(Redstone				, Gold					);
        Zinc					.addOreByProducts(Tin					, Gallium				);
        Tungsten				.addOreByProducts(Manganese				, Molybdenum			);
        Diatomite				.addOreByProducts(BandedIron			, Sapphire				);
        Iron					.addOreByProducts(Nickel				, Tin					);
        Lepidolite				.addOreByProducts(Lithium				, Caesium				);
        Gold					.addOreByProducts(Copper				, Nickel				);
        Tin						.addOreByProducts(Iron					, Zinc					);
        Antimony				.addOreByProducts(Zinc					, Iron					);
        Silver					.addOreByProducts(Lead					, Sulfur				);
        Lead					.addOreByProducts(Silver				, Sulfur				);
        Thorium					.addOreByProducts(Uranium				, Lead					);
        Plutonium				.addOreByProducts(Uranium				, Lead					);
        Electrum				.addOreByProducts(Gold					, Silver				);
        Bronze					.addOreByProducts(Copper				, Tin					);
        Brass					.addOreByProducts(Copper				, Zinc					);
        Coal					.addOreByProducts(Lignite				, Thorium				);
        Ilmenite				.addOreByProducts(Iron					, Rutile				);
        Manganese				.addOreByProducts(Chrome				, Iron					);
        Sapphire				.addOreByProducts(Aluminium				, GreenSapphire			);
        GreenSapphire			.addOreByProducts(Aluminium				, Sapphire				);
        Platinum				.addOreByProducts(Nickel				, Iridium				);
        Emerald					.addOreByProducts(Beryllium				, Aluminium				);
        Olivine					.addOreByProducts(Pyrope				, Magnesium				);
        Chrome					.addOreByProducts(Iron					, Magnesium				);
        Chromite				.addOreByProducts(Iron					, Magnesium				);
        Tetrahedrite			.addOreByProducts(Antimony				, Zinc					);
        GarnetSand				.addOreByProducts(GarnetRed				, GarnetYellow			);
        Magnetite				.addOreByProducts(Iron					, Gold					);
        GraniticMineralSand		.addOreByProducts(GraniteBlack			, Magnetite				);
        BasalticMineralSand		.addOreByProducts(Basalt				, Magnetite				);
        Basalt					.addOreByProducts(Olivine				, DarkAsh				);
        VanadiumMagnetite		.addOreByProducts(Magnetite				, Vanadium				);
        Lazurite				.addOreByProducts(Sodalite				, Lapis					);
        Sodalite				.addOreByProducts(Lazurite				, Lapis					);
        Spodumene				.addOreByProducts(Aluminium				, Lithium				);
        Ruby					.addOreByProducts(Chrome				, GarnetRed				);
        Phosphorus				.addOreByProducts(Apatite				, Phosphate				);
        Iridium					.addOreByProducts(Platinum				, Osmium				);
        Pyrope					.addOreByProducts(GarnetRed				, Magnesium				);
        Almandine				.addOreByProducts(GarnetRed				, Aluminium				);
        Spessartine				.addOreByProducts(GarnetRed				, Manganese				);
        Andradite				.addOreByProducts(GarnetYellow			, Iron					);
        Grossular				.addOreByProducts(GarnetYellow			, Calcium				);
        Uvarovite				.addOreByProducts(GarnetYellow			, Chrome				);
        Calcite					.addOreByProducts(Andradite				, Malachite				);
        NaquadahEnriched		.addOreByProducts(Naquadah				, Naquadria				);
        Naquadah				.addOreByProducts(NaquadahEnriched		);
        Pyrolusite				.addOreByProducts(Manganese				);
        Molybdenite				.addOreByProducts(Molybdenum			);
        Stibnite				.addOreByProducts(Antimony				);
        Garnierite				.addOreByProducts(Nickel				);
        Lignite					.addOreByProducts(Coal					);
        Diamond					.addOreByProducts(Graphite				);
        Beryllium				.addOreByProducts(Emerald				);
        Apatite					.addOreByProducts(Phosphorus			);
        Teslatite				.addOreByProducts(Diamond				);
        Magnesite				.addOreByProducts(Magnesium				);
        NetherQuartz			.addOreByProducts(Netherrack			);
        PigIron					.addOreByProducts(Iron					);
        DeepIron				.addOreByProducts(Iron					);
        ShadowIron				.addOreByProducts(Iron					);
        DarkIron				.addOreByProducts(Iron					);
        MeteoricIron			.addOreByProducts(Iron					);
        Steel					.addOreByProducts(Iron					);
        HSLA					.addOreByProducts(Iron					);
        Mithril					.addOreByProducts(Platinum				);
        Midasium				.addOreByProducts(Gold					);
        AstralSilver			.addOreByProducts(Silver				);
        Graphite				.addOreByProducts(Carbon				);
        Netherrack				.addOreByProducts(Sulfur				);
        Flint					.addOreByProducts(Obsidian				);
        Cobaltite				.addOreByProducts(Cobalt				);
        Cobalt					.addOreByProducts(Cobaltite				);
        Sulfur					.addOreByProducts(Sulfur				);
        Saltpeter				.addOreByProducts(Saltpeter				);
        Endstone				.addOreByProducts(Helium_3				);
        Osmium					.addOreByProducts(Iridium				);
        Magnesium				.addOreByProducts(Olivine				);
        Aluminium				.addOreByProducts(Bauxite				);
        Titanium				.addOreByProducts(Almandine				);
        Obsidian				.addOreByProducts(Olivine				);
        Ash						.addOreByProducts(Carbon				);
        DarkAsh					.addOreByProducts(Carbon				);
        Redrock					.addOreByProducts(Clay					);
        Marble					.addOreByProducts(Calcite				);
        Clay					.addOreByProducts(Clay					);
        Cassiterite				.addOreByProducts(Tin					);
        CassiteriteSand			.addOreByProducts(Tin					);
        GraniteBlack			.addOreByProducts(Biotite				);
        GraniteRed				.addOreByProducts(PotassiumFeldspar		);
        Phosphate				.addOreByProducts(Phosphor				);
        Phosphor				.addOreByProducts(Phosphate				);
        Tanzanite				.addOreByProducts(Opal					);
        Opal					.addOreByProducts(Tanzanite				);
        Amethyst				.addOreByProducts(Amethyst				);
        FoolsRuby				.addOreByProducts(Jasper				);
        Amber					.addOreByProducts(Amber					);
        Topaz					.addOreByProducts(BlueTopaz				);
        BlueTopaz				.addOreByProducts(Topaz					);
        Niter					.addOreByProducts(Saltpeter				);
        Vinteum					.addOreByProducts(Vinteum				);
        Dilithium				.addOreByProducts(Dilithium				);
        Neutronium				.addOreByProducts(Neutronium			);
        Lithium					.addOreByProducts(Lithium				);
        Silicon					.addOreByProducts(SiliconDioxide		);
        Salt					.addOreByProducts(RockSalt				);
        RockSalt				.addOreByProducts(Salt					);

        Glue.mChemicalFormula = "No Horses were harmed for the Production";
        UUAmplifier.mChemicalFormula = "Accelerates the Mass Fabricator";
        LiveRoot.mChemicalFormula = "";
        WoodSealed.mChemicalFormula = "";
        Wood.mChemicalFormula = "";
        FoolsRuby.mChemicalFormula = Ruby.mChemicalFormula;

        Naquadah.mMoltenRGBa.setARGB(0x00ff00);
        NaquadahEnriched.mMoltenRGBa.setARGB(0x40ff40);
        Naquadria.mMoltenRGBa.setARGB(0x80ff80);

        NaquadahEnriched.mChemicalFormula = "Nq+";
        Naquadah.mChemicalFormula = "Nq";
        Naquadria.mChemicalFormula = "NqX";
    }

    private static void initSubTags() {
        SubTag.ELECTROMAGNETIC_SEPERATION_NEODYMIUM.addTo(Bastnasite, Monazite, Forcicium, Forcillium);
        SubTag.ELECTROMAGNETIC_SEPERATION_GOLD.addTo(Magnetite, VanadiumMagnetite, BasalticMineralSand, GraniticMineralSand);
        SubTag.ELECTROMAGNETIC_SEPERATION_IRON.addTo(YellowLimonite, BrownLimonite, Pyrite, BandedIron, Nickel, Vermiculite, Glauconite, GlauconiteSand, Pentlandite, Tin, Antimony, Ilmenite, Manganese, Chrome, Chromite, Andradite);
        SubTag.BLASTFURNACE_CALCITE_DOUBLE.addTo(Pyrite, YellowLimonite, BasalticMineralSand, GraniticMineralSand);
        SubTag.BLASTFURNACE_CALCITE_TRIPLE.addTo(Iron, PigIron, DeepIron, ShadowIron, WroughtIron, MeteoricIron, BrownLimonite);
        SubTag.WASHING_MERCURY.addTo(Gold, Silver, Osmium, Mithril, Platinum, Midasium, Cooperite, AstralSilver);
        SubTag.WASHING_SODIUMPERSULFATE.addTo(Zinc, Nickel, Copper, Cobalt, Cobaltite, Tetrahedrite);
        SubTag.WASHING_BLUEV.addTo(Copper, Tetrahedrite, Chalcopyrite, Teslatite, Gold, Malachite);
        SubTag.WASHING_GREENV.addTo(Chromite, Chrome, Ilmenite, Iron, Magnetite, Tungstate, Andradite, Pyrite);
        SubTag.WASHING_NICKELS.addTo(Nickel, Pentlandite);
        SubTag.METAL.addTo(AnyIron, AnyCopper, AnyBronze, Metal, Aluminium, Americium, Antimony, Beryllium, Bismuth, Caesium, Cerium, Chrome, Cobalt, Copper, Dysprosium, Erbium, Europium, Gadolinium, Gallium, Gold,
                Holmium, Indium, Iridium, Iron, Lanthanum, Lead, Lutetium, Magnesium, Manganese, Mercury, Niobium, Molybdenum, Neodymium, Neutronium, Nickel, Osmium, Palladium, Platinum, Plutonium, Plutonium241,
                Praseodymium, Promethium, Rubidium, Samarium, Scandium, Silicon, Silver, Tantalum, Terbium, Thorium, Thulium, Tin, Titanium, Tungsten, Uranium, Uranium235, Vanadium, Ytterbium, Yttrium,
                Zinc, Serpentine, Signalum, Lumium, PhasedIron, PhasedGold, DarkSteel, Terrasteel, TinAlloy, ConductiveIron, ElectricalSteel, EnergeticAlloy, VibrantAlloy,
                PulsatingIron, Manasteel, DarkThaumium, ElvenElementium, EnrichedCopper, DiamondCopper, Adamantium, Amordrine, Angmallen, Ardite, Aredrite, Atlarus, Blutonium, Carmot, Celenegil, Ceruclase, DarkIron,
                Desh, Desichalkos, Duranium, ElectrumFlux, Enderium, EnderiumBase, Eximite, FierySteel, Haderoth, Hematite, Hepatizon, HSLA, Infuscolium, InfusedGold, Inolashite, Mercassium, MeteoricIron,
                MeteoricSteel, Naquadah, NaquadahAlloy, NaquadahEnriched, Naquadria, ObsidianFlux, Orichalcum, Osmonium, Oureclase, Phoenixite, Prometheum, Sanguinite, Starconium,
                Tartarite, Thyrium, Tritanium, Vulcanite, Vyroxeres, Yellorium, Zectium, AluminiumBrass, Osmiridium, Sunnarium, AnnealedCopper, BatteryAlloy, Brass, Bronze, ChromiumDioxide, Cupronickel, DeepIron,
                Electrum, Invar, IronCompressed, Kanthal, Magnalium, Nichrome, NiobiumNitride, NiobiumTitanium, PigIron, SolderingAlloy, StainlessSteel, Steel, Ultimet, VanadiumGallium, WroughtIron,
                YttriumBariumCuprate, IronWood, Alumite, Manyullyn, ShadowIron, ShadowSteel, Steeleaf, SterlingSilver, RoseGold, BlackBronze, BismuthBronze, BlackSteel, RedSteel, BlueSteel, DamascusSteel,
                TungstenSteel, AstralSilver, Midasium, Mithril, BlueAlloy, RedAlloy, CobaltBrass, Thaumium, IronMagnetic, SteelMagnetic, NeodymiumMagnetic, Knightmetal,VanadiumSteel , HSSG, HSSE, HSSS);

        SubTag.FOOD.addTo(MeatRaw, MeatCooked, Ice, Water, Salt, Chili, Cocoa, Cheese, Coffee, Chocolate, Milk, Honey, FryingOilHot, FishOil, SeedOil, SeedOilLin, SeedOilHemp, Wheat, Sugar, FreshWater);

        Wood.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        WoodSealed.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.NO_WORKING);
        Peanutwood.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        LiveRoot.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MAGICAL, SubTag.MORTAR_GRINDABLE);
        IronWood.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.MAGICAL, SubTag.MORTAR_GRINDABLE);
        Steeleaf.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.MAGICAL, SubTag.MORTAR_GRINDABLE, SubTag.NO_SMELTING);

        MeatRaw.add(SubTag.NO_SMASHING);
        MeatCooked.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Snow.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.NO_RECYCLING);
        Ice.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.NO_RECYCLING);
        Water.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.NO_RECYCLING);
        Sulfur.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE);
        Saltpeter.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE);
        Graphite.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE, SubTag.NO_SMELTING);

        Wheat.add(SubTag.FLAMMABLE, SubTag.MORTAR_GRINDABLE);
        Paper.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE, SubTag.PAPER);
        Coal.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);
        Charcoal.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);
        Lignite.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);

        Rubber.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY, SubTag.STRETCHY);
        Plastic.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY);

        TNT.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        Gunpowder.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        Glyceryl.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        NitroCoalFuel.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        NitroFuel.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        NitroCarbon.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);

        Lead.add(SubTag.MORTAR_GRINDABLE, SubTag.SOLDERING_MATERIAL, SubTag.SOLDERING_MATERIAL_BAD);
        Tin.add(SubTag.MORTAR_GRINDABLE, SubTag.SOLDERING_MATERIAL);
        SolderingAlloy.add(SubTag.MORTAR_GRINDABLE, SubTag.SOLDERING_MATERIAL, SubTag.SOLDERING_MATERIAL_GOOD);

        Cheese.add(SubTag.SMELTING_TO_FLUID);
        Sugar.add(SubTag.SMELTING_TO_FLUID);

        Concrete.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.SMELTING_TO_FLUID);
        ConstructionFoam.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.EXPLOSIVE, SubTag.NO_SMELTING);
        Redstone.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.SMELTING_TO_FLUID, SubTag.PULVERIZING_CINNABAR);
        Glowstone.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.SMELTING_TO_FLUID);
        Teslatite.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.SMELTING_TO_FLUID);
        Netherrack.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.FLAMMABLE);
        Stone.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.NO_RECYCLING);
        Brick.add(SubTag.STONE, SubTag.NO_SMASHING);
        NetherBrick.add(SubTag.STONE, SubTag.NO_SMASHING);
        Endstone.add(SubTag.STONE, SubTag.NO_SMASHING);
        Marble.add(SubTag.STONE, SubTag.NO_SMASHING);
        Basalt.add(SubTag.STONE, SubTag.NO_SMASHING);
        Redrock.add(SubTag.STONE, SubTag.NO_SMASHING);
        Obsidian.add(SubTag.STONE, SubTag.NO_SMASHING);
        Flint.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);
        GraniteRed.add(SubTag.STONE, SubTag.NO_SMASHING);
        GraniteBlack.add(SubTag.STONE, SubTag.NO_SMASHING);
        Salt.add(SubTag.STONE, SubTag.NO_SMASHING);
        RockSalt.add(SubTag.STONE, SubTag.NO_SMASHING);

        Sand.add(SubTag.NO_RECYCLING);

        Gold.add(SubTag.MORTAR_GRINDABLE);
        Silver.add(SubTag.MORTAR_GRINDABLE);
        Iron.add(SubTag.MORTAR_GRINDABLE);
        IronMagnetic.add(SubTag.MORTAR_GRINDABLE);
        HSLA.add(SubTag.MORTAR_GRINDABLE);
        Steel.add(SubTag.MORTAR_GRINDABLE);
        SteelMagnetic.add(SubTag.MORTAR_GRINDABLE);
        Zinc.add(SubTag.MORTAR_GRINDABLE);
        Antimony.add(SubTag.MORTAR_GRINDABLE);
        Copper.add(SubTag.MORTAR_GRINDABLE);
        AnnealedCopper.add(SubTag.MORTAR_GRINDABLE);
        Bronze.add(SubTag.MORTAR_GRINDABLE);
        Nickel.add(SubTag.MORTAR_GRINDABLE);
        Invar.add(SubTag.MORTAR_GRINDABLE);
        Brass.add(SubTag.MORTAR_GRINDABLE);
        WroughtIron.add(SubTag.MORTAR_GRINDABLE);
        Electrum.add(SubTag.MORTAR_GRINDABLE);
        Clay.add(SubTag.MORTAR_GRINDABLE);

        Glass.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_RECYCLING, SubTag.SMELTING_TO_FLUID);
        Diamond.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE);
        Emerald.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Amethyst.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Tanzanite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Topaz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        BlueTopaz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Amber.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        GreenSapphire.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Sapphire.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Ruby.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        FoolsRuby.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Opal.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Olivine.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Jasper.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        GarnetRed.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        GarnetYellow.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Mimichite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        CrystalFlux.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Crystal.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Niter.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Apatite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Lapis.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Sodalite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Lazurite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Monazite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Quartzite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Quartz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        SiliconDioxide.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Dilithium.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        NetherQuartz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        CertusQuartz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Fluix.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Phosphorus.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE, SubTag.EXPLOSIVE);
        Phosphate.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE, SubTag.EXPLOSIVE);
        InfusedAir.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedFire.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedEarth.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedWater.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedEntropy.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedOrder.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedVis.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        InfusedDull.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        Vinteum.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        NetherStar.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        EnderPearl.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.PEARL);
        EnderEye.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.PEARL);
        Firestone.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.MAGICAL, SubTag.QUARTZ, SubTag.UNBURNABLE, SubTag.BURNING);
        Forcicium.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.MAGICAL);
        Forcillium.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.MAGICAL);
        Magic.add(SubTag.CRYSTAL, SubTag.MAGICAL, SubTag.UNBURNABLE);

        Primitive.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Basic.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Good.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Advanced.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Data.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Elite.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Master.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Ultimate.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Superconductor.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Infinite.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);

        Blaze.add(SubTag.MAGICAL, SubTag.NO_SMELTING, SubTag.SMELTING_TO_FLUID, SubTag.MORTAR_GRINDABLE, SubTag.UNBURNABLE, SubTag.BURNING);
        FierySteel.add(SubTag.MAGICAL, SubTag.UNBURNABLE, SubTag.BURNING);
        ElvenElementium.add(SubTag.MAGICAL);
        DarkThaumium.add(SubTag.MAGICAL);
        Thaumium.add(SubTag.MAGICAL);
        Enderium.add(SubTag.MAGICAL);
        AstralSilver.add(SubTag.MAGICAL);
        Midasium.add(SubTag.MAGICAL);
        Mithril.add(SubTag.MAGICAL);
    }

    public static void initCustomMats(String aCustomOreConfigLabel) {
        //TODO MAIN: increase sGeneratedMaterials limit from 1,000 to 10,000.
        //TODO good way to only get the rest of the data (Tool qual etc) one and not twice per for loop (one for default and custom).
        //TODO split this into a new method
        for (Materials tMaterial : Materials.VALUES) {
            if (tMaterial.mMetaItemSubID >= 0) {
                tMaterial.mMetaItemSubID = GregTech_API.sMaterialsFile.get("materials.default." + tMaterial.mDefaultLocalName, "MaterialID", tMaterial.mMetaItemSubID);
                tMaterial.mDurability = GregTech_API.sMaterialsFile.get("materials.default." + tMaterial.mDefaultLocalName, "Durability", tMaterial.mDurability);
            }
        }
        //TODO make this minetweaker friendly?
        //TODO register fluids
        int i = 0;
        StringBuilder aCustomMatNum = new StringBuilder();
        for (int j = GregTech_API.sMaterialsFile.get("general", "AmountOfCustomMaterialSlots", 16); i < j; i++) {
            aCustomMatNum.append("materials.").append(aCustomOreConfigLabel).append(".custommat").append(i < 10 ? "0" : "" ).append(i);
            int aMetaItemSubID = GregTech_API.sMaterialsFile.get(aCustomMatNum.toString(), "MaterialID", -1);
            String aDefaultLocalName = GregTech_API.sMaterialsFile.get(aCustomMatNum.toString(), "MaterialName", "NullMat");
            if (!aDefaultLocalName.equalsIgnoreCase("NullMat")) {
                new Materials(aMetaItemSubID, SET_METALLIC, 16.0F, 1280, 4, 1 | 2 | 8 | 32 | 64 | 128, 50, 50, 255, 0, aDefaultLocalName, 0, 0, 3306, 3306, true, false, 10, 1, 1, Dyes.dyeBlue);
            }
            aCustomMatNum.setLength(0);
        }
    }

    public static class Builder{
        private Materials rMaterials = new Materials();
        private IColorModulationContainer mSolidARGB = new IColorModulationContainer(0x00ffffff);
        private IColorModulationContainer mMoltenARGB = new IColorModulationContainer(0x00ffffff);
        private TextureSet mIconSet;
        private int mMetaItemSubID;
        private boolean mUnifiable;
        private Materials mMaterialInto;
        private List<MaterialStack> mMaterialList = new ArrayList<>();
        private List<Materials> mOreByProducts = new ArrayList<>();
        private List<Materials> mOreReRegistrations = new ArrayList<>();
        private List<TC_Aspects.TC_AspectStack> mAspects = new ArrayList<>();
        private List<ItemStack> mMaterialItems = new ArrayList<>();
        private Collection<SubTag> mSubTags = new HashSet<>();
        private Enchantment mEnchantmentTools = null;
        private byte mEnchantmentToolsLevel = 0;
        private Enchantment mEnchantmentArmors = null;
        private byte mEnchantmentArmorsLevel = 0;
        private boolean mBlastFurnaceRequired = false;
        private float mToolSpeed = 1.0F;
        private float mHeatDamage = 0.0F;
        private String mChemicalFormula = "?";
        private String mName = "null";
        private String mDefaultLocalName = "null";
        private Dyes mColor = Dyes._NULL;
        private short mMeltingPoint = 0;
        private short mBlastFurnaceTemp = 0;
        private int mTypes = 0;
        private int mDurability = 16;
        private int mFuelPower = 0;
        private int mFuelType = 0;
        private int mExtraData = 0;
        private int mOreValue = 0;
        private int mOreMultiplier = 1;
        private int mByProductMultiplier = 1;
        private int mSmeltingMultiplier = 1;
        private long mDensity = MATERIAL_UNIT;
        private Element mElement = null;
        private Materials mDirectSmelting = rMaterials;
        private Materials mOreReplacement = rMaterials;
        private Materials mMacerateInto = rMaterials;
        private Materials mSmeltInto = rMaterials;
        private Materials mArcSmeltInto = rMaterials;
        private Materials mHandleMaterial = rMaterials;
        private byte mToolQuality = 0;
        private Fluid mSolid = null;
        private Fluid mFluid = null;
        private Fluid mGas = null;
        private Fluid mPlasma = null;

        /**
         * Set the {@link Materials}'s ARGB color
         * @param aARGB integer packed ARGB.
         *              example: solidRGBa(0x00FF8020)
         *              Alpha = 0x00
         *              Red = 0xff
         *              Green = 0x80
         *              Blue = 0x20
         * @return Materials for builder
         */
        public Builder solidARGB(int aARGB) {
            this.mSolidARGB.setARGB(aARGB);
            return this;
        }

        public Builder moltenARGB(int aARGB) {
            this.mMoltenARGB.setARGB(aARGB);
            return this;
        }

        public Builder textureSet(TextureSet aTextureSet) {
            this.mIconSet = aTextureSet;
            return this;
        }

        public Builder subID(int aMetaItemSubID) {
            this.mMetaItemSubID = aMetaItemSubID;
            return this;
        }

        public Builder unifiable(boolean aUnifiable) {
            this.mUnifiable = aUnifiable;
            return this;
        }

        public Builder matInto(Materials aMaterialInto) {
            this.mMaterialInto = aMaterialInto;
            return this;
        }

        public Builder matList(MaterialStack... aMaterialList) {
            this.mMaterialList = Arrays.asList(aMaterialList);
            return this;
        }

        public Builder byProducts(Materials... aByProducts) {
            this.mOreByProducts = Arrays.asList(aByProducts);
            return this;
        }

        public Builder oreRegistrations(Materials... aOres) {
            this.mOreReRegistrations = Arrays.asList(aOres);
            return this;
        }

        public Builder aspects(TC_Aspects.TC_AspectStack... aAspects) {
            this.mAspects = Arrays.asList(aAspects);
            return this;
        }

        public Builder items(ItemStack... aItemsStacks) {
            this.mMaterialItems = Arrays.asList(aItemsStacks);
            return this;
        }

        public Builder subTags(SubTag... aSubTags) {
            this.mSubTags = Arrays.asList(aSubTags);
            return this;
        }

        public Builder toolsEnchant(Enchantment aEnchantment) {
            this.mEnchantmentTools = aEnchantment;
            return this;
        }

        public Builder toolsEnchantLvl(byte aEnchantmentLevel) {
            this.mEnchantmentToolsLevel = aEnchantmentLevel;
            return this;
        }

        public Builder armorEnchant(Enchantment aEnchantment) {
            this.mEnchantmentArmors = aEnchantment;
            return this;
        }

        public Builder armorEnchantLvl(byte aEnchantmentLevel) {
            this.mEnchantmentArmorsLevel = aEnchantmentLevel;
            return this;
        }

        public Builder needBlastFurnace(boolean aNeedBlastFurnace) {
            this.mBlastFurnaceRequired = aNeedBlastFurnace;
            return this;
        }

        public Builder toolSpeed(float aToolSpeed) {
            this.mToolSpeed = aToolSpeed;
            return this;
        }

        public Builder heatDamage(float aHeatDamage) {
            this.mHeatDamage = aHeatDamage;
            return this;
        }

        public Builder chemForm(String aChemicalFormula) {
            this.mChemicalFormula = aChemicalFormula;
            return this;
        }

        public Builder name(String aName) {
            this.mName = aName;
            return this;
        }

        public Builder defaultLocalName(String aDefaultLocalName) {
            this.mDefaultLocalName = aDefaultLocalName;
            return this;
        }

        //private Dyes mColor = Dyes._NULL;

        public Materials build() {
            this.rMaterials.mRGBa = mSolidARGB;
            this.rMaterials.mMoltenRGBa = mMoltenARGB;
            this.rMaterials.mIconSet = this.mIconSet;
            this.rMaterials.mMetaItemSubID = this.mMetaItemSubID;
            this.rMaterials.mUnificatable = this.mUnifiable;
            this.rMaterials.mMaterialInto = this.mMaterialInto;
            this.rMaterials.mMaterialList = this.mMaterialList;
            this.rMaterials.mOreByProducts = this.mOreByProducts;
            this.rMaterials.mOreReRegistrations = this.mOreReRegistrations;
            this.rMaterials.mAspects = this.mAspects;
            this.rMaterials.mMaterialItems = this.mMaterialItems;

            this.rMaterials.mSubTags = this.mSubTags;
            this.rMaterials.mEnchantmentTools = this.mEnchantmentTools;
            this.rMaterials.mEnchantmentToolsLevel = this.mEnchantmentToolsLevel;
            this.rMaterials.mEnchantmentArmors = this.mEnchantmentArmors;
            this.rMaterials.mEnchantmentArmorsLevel = this.mEnchantmentArmorsLevel;
            this.rMaterials.mBlastFurnaceRequired = this.mBlastFurnaceRequired;
            this.rMaterials.mToolSpeed = this.mToolSpeed;
            this.rMaterials.mHeatDamage = this.mHeatDamage;
            this.rMaterials.mChemicalFormula = this.mChemicalFormula;
            this.rMaterials.mName = this.mName;
            this.rMaterials.mDefaultLocalName = this.mDefaultLocalName;

            return this.rMaterials;
        }
    }

    private Materials() {}

    @Deprecated
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aToolDurability, int aToolQuality, boolean aUnificatable) {
        VALUES.add(this);
        mUnificatable = aUnificatable;
        mMaterialInto = this;
        mMetaItemSubID = aMetaItemSubID;
        mToolQuality = (byte) aToolQuality;
        mDurability = aToolDurability;
        mToolSpeed = aToolSpeed;
        mIconSet = aIconSet;
        if (aMetaItemSubID >= 0) {
            if (GregTech_API.sGeneratedMaterials[aMetaItemSubID] == null) {
                GregTech_API.sGeneratedMaterials[aMetaItemSubID] = this;
            } else {
                throw new IllegalArgumentException("The Index " + aMetaItemSubID + " is already used!");
            }
        }
    }

    public Materials(Materials aMaterialInto, boolean aReRegisterIntoThis) {
        mUnificatable = false;
        mDefaultLocalName = aMaterialInto.mDefaultLocalName;
        mMaterialInto = aMaterialInto.mMaterialInto;
        if (mMaterialInto != null && mMaterialInto.mOreReRegistrations != null && aReRegisterIntoThis) {
            mMaterialInto.mOreReRegistrations.add(this);
        }
        mChemicalFormula = aMaterialInto.mChemicalFormula;
        mMetaItemSubID = -1;
        mIconSet = SET_NONE;
    }

    /**
     *
     * @deprecated replaced by {@link Materials.Builder}
     * @param aMetaItemSubID The meta-sub identifier for items
     * @param aIconSet The {@link TextureSet} textures
     * @param aToolSpeed The tool speed multiplier
     * @param aDurability The durability
     * @param aToolQuality The tool quality
     * @param aTypes The flags to enable item types
     * @param aR The main color red component
     * @param aG The main color green component
     * @param aB The main color blue component
     * @param aA The main color alpha component
     * @param aDefaultLocalName The default localized name
     * @param aFuelType The fuel typ identifier
     * @param aFuelPower The fuel value
     * @param aMeltingPoint The melting point
     * @param aBlastFurnaceTemp The blast furnace temperature
     * @param aBlastFurnaceRequired If smelting requires a blast furnace
     * @param aTransparent If it is transparent
     * @param aOreValue The ore value
     * @param aDensityMultiplier The ore density multiplier
     * @param aDensityDivider The ore density divider
     * @param aColor The {@link Dyes} color
     */
    @SuppressWarnings({
            "squid:S00107", // 21 Parameters is the reason for deprecating
            "squid:S1133",  // Known deprecation, method to be removed
            })
    @Deprecated
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, true);
        mName = aDefaultLocalName.replaceAll(" ", "");
        mDefaultLocalName = aDefaultLocalName;
        mMeltingPoint = (short) aMeltingPoint;
        mBlastFurnaceTemp = (short) aBlastFurnaceTemp;
        mBlastFurnaceRequired = aBlastFurnaceRequired;
        if (aTransparent) add(SubTag.TRANSPARENT);
        mFuelPower = aFuelPower;
        mFuelType = aFuelType;
        mOreValue = aOreValue;
        mDensity = (MATERIAL_UNIT * aDensityMultiplier) / aDensityDivider;
        mColor = aColor == null ? Dyes._NULL : aColor;
        add(SubTag.HAS_COLOR);
        mRGBa.setRGBA(aR, aG, aB, aA);
        mTypes = aTypes;
        if ((mTypes & 2) != 0) add(SubTag.SMELTING_TO_FLUID);
    }

    @Deprecated
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aToolDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, List<TC_Aspects.TC_AspectStack> aAspects) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aToolDurability, aToolQuality, aTypes, aR, aG, aB, aA, aLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor);
        mAspects.addAll(aAspects);
    }

    @Deprecated
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aToolDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, Element aElement, List<TC_Aspects.TC_AspectStack> aAspects) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aToolDurability, aToolQuality, aTypes, aR, aG, aB, aA, aLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor);
        mElement = aElement;
        mElement.mLinkedMaterials.add(this);
        if (aElement == Element._NULL) {
            mChemicalFormula = "Empty";
        } else {
            mChemicalFormula = aElement.toString();
            mChemicalFormula = mChemicalFormula.replaceAll("_", "-");
        }
        mAspects.addAll(aAspects);
    }

    @Deprecated
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aToolDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aToolDurability, aToolQuality, aTypes, aR, aG, aB, aA, aLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor, aExtraData, aMaterialList, null);
    }

    @Deprecated
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aToolDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList, List<TC_Aspects.TC_AspectStack> aAspects) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aToolDurability, aToolQuality, aTypes, aR, aG, aB, aA, aLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor);
        mExtraData = aExtraData;
        mMaterialList.addAll(aMaterialList);
        mChemicalFormula = "";
        for (MaterialStack tMaterial : mMaterialList) mChemicalFormula += tMaterial.toString();
        mChemicalFormula = mChemicalFormula.replaceAll("_", "-");

        int tAmountOfComponents = 0, tMeltingPoint = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmountOfComponents += tMaterial.mAmount;
            if (tMaterial.mMaterial.mMeltingPoint > 0)
                tMeltingPoint += tMaterial.mMaterial.mMeltingPoint * tMaterial.mAmount;
            if (aAspects == null)
                for (TC_Aspects.TC_AspectStack tAspect : tMaterial.mMaterial.mAspects) tAspect.addToAspectList(mAspects);
        }

        if (mMeltingPoint < 0) mMeltingPoint = (short) (tMeltingPoint / tAmountOfComponents);

        tAmountOfComponents *= aDensityMultiplier;
        tAmountOfComponents /= aDensityDivider;
        if (aAspects == null) {
            for (TC_AspectStack tAspect : mAspects)
                tAspect.mAmount = Math.max(1, tAspect.mAmount / Math.max(1, tAmountOfComponents));
        } else mAspects.addAll(aAspects);
    }

    /**
     * Gets the Name of the {@link Materials}
     * @return the {@link Materials}'s Name
     */
    public String name() {
        return this.mName;
    }

    /**
     * Gets the {@link Materials} from its Name
     * @param aMaterialName The {@link Materials}'s Name
     * @return the {@link Materials} or null if none found
     */
    public static Materials get(String aMaterialName) {
        Object tObject = GT_Utility.getFieldContent(Materials.class, aMaterialName, false, false);
        if (tObject instanceof Materials) return (Materials) tObject;
        return _NULL;
    }

    /**
     * Gets the Aliased real {@link Materials} from an aliased {@link Materials}
     * @param aMaterialName The {@link Materials}'s Alias Name
     * @return the Aliased real {@link Materials} or null if none
     */
    public static Materials getRealMaterial(String aMaterialName) {
        return get(aMaterialName).mMaterialInto;
    }

    /**
     * Determines if this {@link Materials} is Radioactive
     * @return true if Radioactive
     */
    public boolean isRadioactive() {
        if (mElement != null) return mElement.mHalfLifeSeconds >= 0;
        for (MaterialStack tMaterial : mMaterialList) if (tMaterial.mMaterial.isRadioactive()) return true;
        return false;
    }

    /**
     * Gets this {@link Materials}'s Protons count
     * @return The Protons count
     */
    public long getProtons() {
        if (mElement != null) return mElement.getProtons();
        if (! (mMaterialList.isEmpty())) return Element.Tc.getProtons();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getProtons();
        }
        return (getDensity() * rAmount) / (tAmount * GT_Values.M);
    }

    /**
     * Gets this {@link Materials}'s Neutrons count
     * @return The Neutrons count
     */
    public long getNeutrons() {
        if (mElement != null) return mElement.getNeutrons();
        if (mMaterialList.isEmpty()) return Element.Tc.getNeutrons();
        long rAmount = 0;
        long tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getNeutrons();
        }
        if (tAmount == 0) tAmount = 1;
        return (getDensity() * rAmount) / (tAmount * MATERIAL_UNIT);
    }

    /**
     * Gets this {@link Materials}'s Mass
     * @return The Mass
     */
    public long getMass() {
        if (mElement != null) return mElement.getMass();
        if (mMaterialList.isEmpty()) return Element.Tc.getMass();
        long rAmount = 0;
        long tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getMass();
        }
        if (tAmount == 0) tAmount = 1;
        return (getDensity() * rAmount) / (tAmount * MATERIAL_UNIT);
    }

    /**
     * Gets this {@link Materials}'s Density
     * @return The Density
     */
    public long getDensity() {
        return mDensity;
    }

    /**
     * Gets the ToolTip of this {@link Materials}
     * @return The ToolTip String
     */
    public String getToolTip() {
        return getToolTip(1, false);
    }

    /**
     * Gets the ToolTip of this {@link Materials}
     * @param aShowQuestionMarks if Question Mark (unknown) is shown
     * @return The ToolTip String
     */
    public String getToolTip(boolean aShowQuestionMarks) {
        return getToolTip(1, aShowQuestionMarks);
    }

    /**
     * Gets the ToolTip of this {@link Materials} amount
     * @param aMultiplier The {@link Materials} amount
     * @return The ToolTip String
     */
    public String getToolTip(long aMultiplier) {
        return getToolTip(aMultiplier, false);
    }

    /**
     * Gets the ToolTip's chemical formula of this {@link Materials} amount
     * @param aMultiplier The {@link Materials} amount
     * @param aShowQuestionMarks if Question Mark (unknown formula) is shown
     * @return The ToolTip String
     */
    public String getToolTip(long aMultiplier, boolean aShowQuestionMarks) {
        if (!aShowQuestionMarks && mChemicalFormula.equals("?")) return EMPTY_STRING;
        if (aMultiplier >= MATERIAL_UNIT * 2 && !mMaterialList.isEmpty()) {
            return ((mElement != null || (mMaterialList.size() < 2 && mMaterialList.get(0).mAmount == 1)) ? mChemicalFormula : "(" + mChemicalFormula + ")") + aMultiplier;
        }
        return mChemicalFormula;
    }

    /**
     * Adds / Associates the {@link ItemStack} to this {@link Materials}.
     * @param aStack The {@link ItemStack} to add
     * @return the updated {@link Materials} with added  {@link ItemStack}
     */
    public Materials add(ItemStack aStack) {
        if (aStack != null && !contains(aStack)) mMaterialItems.add(aStack);
        return this;
    }

    /**
     * This is used to determine if any of the {@link ItemStack} belongs to this {@link Materials}.
     * @param aStacks The {@link ItemStack} to search
     * @return true if the {@link ItemStack} belongs to this {@link Materials}
     */
    public boolean contains(ItemStack... aStacks) {
        if (aStacks == null || aStacks.length <= 0) return false;
        for (ItemStack tStack : mMaterialItems)
            for (ItemStack aStack : aStacks)
                if (GT_Utility.areStacksEqual(aStack, tStack, !tStack.hasTagCompound())) return true;
        return false;
    }

    /**
     * Removes / dissociates {@link ItemStack} from the {@link Materials}
     * @param aStack the {@link ItemStack} to remove
     * @return the {@link Materials} with removed {@link ItemStack}
     * */
    public boolean remove(ItemStack aStack) {
        if (aStack == null) return false;
        boolean temp = false;

        int i = 0;
        while (i < mMaterialItems.size()) {
            if (GT_Utility.areStacksEqual(aStack, mMaterialItems.get(i))) {
                mMaterialItems.remove(i--);
                temp = true;
            }
            i++;
        }
        return temp;
    }

    /**
     * Adds SubTags to this {@link Materials}
     * @param aTags the {@link SubTag}s to be added
     * @return the {@link Materials} with the added {@link SubTag}s
     */
    @Override
    public ISubTagContainer add(SubTag... aTags) {
        if (aTags == null) return this;

        for (SubTag aTag : aTags) {
            if (aTag != null && !contains(aTag)) {
                aTag.addContainerToList(this);
                mSubTags.add(aTag);
            }
        }

        return this;
    }

    /**
     * Tests if this {@link Materials} has this exact {@link SubTag}
     * @param aTag the {@link SubTag} to test
     * @return true if the {@link Materials} contains the {@link SubTag}
     */
    @Override
    public boolean contains(SubTag aTag) {
        return mSubTags.contains(aTag);
    }

    /**
     * Removes a SubTag from this {@link Materials}
     * @param aTag the {@link SubTag} to be removed
     * @return the {@link Materials} with the removed {@link SubTag}
     */
    @Override
    public boolean remove(SubTag aTag) {
        return mSubTags.remove(aTag);
    }

    /**
     * Sets the Heat Damage for this {@link Materials} (negative = frost)
     * @param aHeatDamage The Heat Damage (negative = frost)
     * @return The updated {@link Materials} with the new Heat Damage
     */
    public Materials setHeatDamage(float aHeatDamage) {
        mHeatDamage = aHeatDamage;
        return this;
    }

    /**
     * Adds The {@link Materials} to the List of Byproducts when grinding this Ore.
     * Is used for more precise Ore grinding, so that it is possible to choose between certain kinds of Materials.
     * @param aMaterial The {@link Materials} to be added as byproducts
     * @return The updated {@link Materials} with added byproducts
     */
    public Materials addOreByProduct(Materials aMaterial) {
        if (!mOreByProducts.contains(aMaterial.mMaterialInto)) mOreByProducts.add(aMaterial.mMaterialInto);
        return this;
    }

    /**
     * Adds multiple {@link Materials} to the List of Byproducts when grinding this Ore.
     * Is used for more precise Ore grinding, so that it is possible to choose between certain kinds of Materials.
     * @param aMaterials The {@link Materials} to be added as byproducts
     * @return The updated {@link Materials} with the added byproducts
     */
    public Materials addOreByProducts(Materials... aMaterials) {
        for (Materials tMaterial : aMaterials) if (tMaterial != null) addOreByProduct(tMaterial);
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Main {@link Materials}.
     * Lapis Ore for example gives about 6 drops.
     * @param aOreMultiplier The Main Ore Multiplier
     * @return The updated {@link Materials} with the new Ore Multiplier
     */
    public Materials setOreMultiplier(int aOreMultiplier) {
        if (aOreMultiplier > 0) mOreMultiplier = aOreMultiplier;
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Byproduct Material.
     * @param aByProductMultiplier The Byproduct Multiplier
     * @return The updated {@link Materials} with the new Byproduct Multiplier
     */
    public Materials setByProductMultiplier(int aByProductMultiplier) {
        if (aByProductMultiplier > 0) mByProductMultiplier = aByProductMultiplier;
        return this;
    }

    /**
     * If this Ore smelts into multiple drops of its Main Material.
     * Lapis Ore for example smelts into about 3 drops.
     * @param aSmeltingMultiplier The Smelting Multiplier
     * @return The updated {@link Materials} with the new Smelt Multiplier
     */
    public Materials setSmeltingMultiplier(int aSmeltingMultiplier) {
        if (aSmeltingMultiplier > 0) mSmeltingMultiplier = aSmeltingMultiplier;
        return this;
    }

    /**
     * This Ore should be smelted directly into an Ingot of this {@link Materials} instead of an Ingot of itself.
     * @param aMaterial The Ingot's {@link Materials}
     * @return The updated {@link Materials} with the added Ingot's {@link Materials} direct smelt
     */
    public Materials setDirectSmelting(Materials aMaterial) {
        if (aMaterial != null) mDirectSmelting = aMaterial.mMaterialInto.mDirectSmelting;
        return this;
    }

    /**
     * This Material should be the Main Material this Ore gets ground into.
     * Example: {@link Materials#Chromite} giving {@link Materials#Chrome} or {@link Materials#Tungstate} giving {@link Materials#Tungsten}.
     * @param aMaterial The ground {@link Materials}
     * @return The updated {@link Materials} with the new ground {@link Materials}
    */
    public Materials setOreReplacement(Materials aMaterial) {
        if (aMaterial != null) mOreReplacement = aMaterial.mMaterialInto.mOreReplacement;
        return this;
    }

    /**
     * This Material smelts always into an instance of aMaterial. Used for Magnets.
     * @param aMaterial The always smelt-into {@link Materials}
     * @return The updated {@link Materials} with the new smelt-into {@link Materials}
     */
    public Materials setSmeltingInto(Materials aMaterial) {
        if (aMaterial != null) mSmeltInto = aMaterial.mMaterialInto.mSmeltInto;
        return this;
    }

    /**
     * In an Arc Furnace, this Material always into an instance of {@link Materials}.
     * Used for Wrought Iron.
     * @param aMaterial The Arc Furnace always smelt-into {@link Materials}
     * @return The updated {@link Materials} with the new Arc Furnace always smelt-into {@link Materials}
     */
    public Materials setArcSmeltingInto(Materials aMaterial) {
        if (aMaterial != null) mArcSmeltInto = aMaterial.mMaterialInto.mArcSmeltInto;
        return this;
    }

    /**
     * This Material macerates always into an instance of {@link Materials}.
     * @param aMaterial The maceration output {@link Materials}
     * @return The updated {@link Materials} with the new maceration output {@link Materials}
     */
    public Materials setMaceratingInto(Materials aMaterial) {
        if (aMaterial != null) mMacerateInto = aMaterial.mMaterialInto.mMacerateInto;
        return this;
    }

    /**
     * Sets the {@link Enchantment} for Tools made of this {@link Materials}
     * @param aEnchantment the {@link Enchantment}
     * @param aEnchantmentLevel the {@link Enchantment}'s Level
     * @return @return The updated {@link Materials} with the new {@link Enchantment} for Tools
     */
    public Materials setEnchantmentForTools(Enchantment aEnchantment, int aEnchantmentLevel) {
        mEnchantmentTools = aEnchantment;
        mEnchantmentToolsLevel = (byte) aEnchantmentLevel;
        return this;
    }

    /**
     * Sets the {@link Enchantment} for Armors made of this {@link Materials}
     * @param aEnchantment the {@link Enchantment}
     * @param aEnchantmentLevel the {@link Enchantment}'s Level
     * @return @return The updated {@link Materials} with the new {@link Enchantment} for Armors
     */
    public Materials setEnchantmentForArmors(Enchantment aEnchantment, int aEnchantmentLevel) {
        mEnchantmentArmors = aEnchantment;
        mEnchantmentArmorsLevel = (byte) aEnchantmentLevel;
        return this;
    }

    /**
     * Gets {@link GT_FluidStack} Fluid state amount from the Solid state of this {@link Materials}
     * @param aAmount The amount of Fluid in Liters
     * @return The {@link GT_FluidStack} Fluid state amount from the Solid state of this {@link Materials}
     */
    public FluidStack getSolid(long aAmount) {
        if (mSolid == null) return null;
        return new GT_FluidStack(mSolid, (int) aAmount);
    }

    /**
     * Gets {@link GT_FluidStack} Fluid state amount of this {@link Materials}
     * @param aAmount The amount of Fluid in Liters
     * @return The {@link GT_FluidStack} Fluid state amount of this {@link Materials}
     */
    public FluidStack getFluid(long aAmount) {
        if (mFluid == null) return null;
        return new GT_FluidStack(mFluid, (int) aAmount);
    }

    /**
     * Get {@link GT_FluidStack} Gaseous state amount of this {@link Materials}
     * @param aAmount The amount Gas in Liters
     * @return The {@link GT_FluidStack} Gaseous state amount of this {@link Materials}
     */
    public FluidStack getGas(long aAmount) {
        if (mGas == null) return null;
        return new GT_FluidStack(mGas, (int) aAmount);
    }

    /**
     * Gets {@link GT_FluidStack} Plasma state amount of this {@link Materials}
     * @param aAmount The amount Plasma in Liters
     * @return The {@link GT_FluidStack} Plasma state amount of this {@link Materials}
     */
    public FluidStack getPlasma(long aAmount) {
        if (mPlasma == null) return null;
        return new GT_FluidStack(mPlasma, (int) aAmount);
    }

    /**
     * Gets {@link GT_FluidStack} Molten state amount of this {@link Materials}
     * @param aAmount The amount Molten in Liters
     * @return The {@link GT_FluidStack} Molten state amount of this {@link Materials}
     */
    public FluidStack getMolten(long aAmount) {
        if (mStandardMoltenFluid == null) return null;
        return new GT_FluidStack(mStandardMoltenFluid, (int) aAmount);
    }

    /**
     * Gets {@link Materials}'s color components as a short array
     * @return the short RGBA color components array
     */
    public short[] getRGBa() {
        return mRGBa.getRGBA();
    }

    /**
     * Gets the {@link Materials}'s Molten color components as short array
     * @return the short RGBA color components array
     */
    public short[] getMoltenRGBa() {
        return mMoltenRGBa.getRGBA();
    }

    /**
     * Gets the {@link Materials}'s color as an {@link IColorModulationContainer}
     * @return the {@link IColorModulationContainer}
     */
    public IColorModulationContainer getColor() {
        return mRGBa;
    }

    /**
     * Gets the {@link Materials}'s Molten color as an {@link IColorModulationContainer}
     * @return the {@link IColorModulationContainer}
     */
    public IColorModulationContainer getMoltenColor() {
        return mMoltenRGBa;
    }

    /**
     * Gets the {@link Materials}'s name
     * @return The {@link Materials}'s name
     */
    public String getName() {
        return mName;
    }

    /**
     * Gets the {@link Materials}'s {@link TextureSet}
     * @return The {@link Materials}'s {@link TextureSet}
     */
    public TextureSet getTextureSet() {
        return mIconSet;
    }

    /**
     * Gets the {@link Materials}'s Meta SubID
     * @return The {@link Materials}'s Meta SubID
     */
    public int getSubID() {
        return mMetaItemSubID;
    }

    /**
     * Tells if {@link Materials} is unifiable
     * @return The unifiable status
     */
    public boolean isUnifiable() {
        return mUnificatable;
    }

    /**
     * Gets the {@link Materials} this {@link Materials} is unifiable into
     * @return The {@link Materials} this is unifiable into
     */
    public Materials getMaterialInto() {
        return mMaterialInto;
    }

    /**
     * Gets the {@link MaterialStack} list
     * @return The {@link MaterialStack} list
     */
    public List<MaterialStack> getMaterialList() {
        return mMaterialList;
    }
}
