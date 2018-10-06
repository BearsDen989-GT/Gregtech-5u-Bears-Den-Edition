package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Dyes;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingToolHeadHammer implements IOreRecipeRegistrator {
    public ProcessingToolHeadHammer() {
        OrePrefixes.toolHeadHammer.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if ((aMaterial != Materials.Stone) && (aMaterial != Materials.Flint)) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats((aMaterial.contains(SubTag.BOUNCY)) || (aMaterial.contains(SubTag.WOOD)) ? 14 : 12, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
            GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats((aMaterial.contains(SubTag.BOUNCY)) || (aMaterial.contains(SubTag.WOOD)) ? 14 : 12, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"XX ", "XXS", "XX ", 'X', aMaterial == Materials.Wood ? OrePrefixes.plank.get(Materials.Wood) : OrePrefixes.ingot.get(aMaterial), 'S', OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
            GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats((aMaterial.contains(SubTag.BOUNCY)) || (aMaterial.contains(SubTag.WOOD)) ? 14 : 12, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"XX ", "XXS", "XX ", 'X', aMaterial == Materials.Wood ? OrePrefixes.plank.get(Materials.Wood) : OrePrefixes.gem.get(aMaterial), 'S', OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
            if (aMaterial != Materials.Rubber)
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(44, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"xRR", " SR", "S f", 'S', OrePrefixes.stick.get(aMaterial), 'R', OrePrefixes.plate.get(Materials.Rubber)});
            if ((!aMaterial.contains(SubTag.WOOD)) && (!aMaterial.contains(SubTag.BOUNCY)) && (!aMaterial.contains(SubTag.NO_SMASHING))) {
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(16, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"IhI", "III", " I ", 'I', OrePrefixes.ingot.get(aMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(20, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"hDS", "DSD", "SDf", 'S', OrePrefixes.stick.get(aMaterial), 'D', Dyes.dyeBlue});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(22, 1, aMaterial, aMaterial.mHandleMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{" fS", " Sh", "W  ", 'S', OrePrefixes.stick.get(aMaterial), 'W', OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(26, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PfP", "hPd", "STS", 'S', OrePrefixes.stick.get(aMaterial), 'P', OrePrefixes.plate.get(aMaterial), 'T', OrePrefixes.screw.get(aMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(28, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SWS", "SSS", "xSh", 'S', OrePrefixes.stick.get(aMaterial), 'W', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(30, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PfP", "PdP", "STS", 'S', OrePrefixes.stick.get(aMaterial), 'P', OrePrefixes.plate.get(aMaterial), 'T', OrePrefixes.screw.get(aMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(34, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"fPh", " S ", 'S', OrePrefixes.stick.get(aMaterial), 'P', OrePrefixes.plate.get(aMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(36, 1, aMaterial, aMaterial, null), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PPf", "PP ", "Sh ", 'S', OrePrefixes.stick.get(aMaterial), 'P', OrePrefixes.plate.get(aMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(160, 1, aMaterial, Materials.Rubber, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"LBf", "Sd ", "P  ", 'B', OrePrefixes.bolt.get(aMaterial), 'P', OrePrefixes.plate.get(Materials.Rubber), 'S', OrePrefixes.stick.get(Materials.Iron), 'L', ItemList.Battery_RE_LV_Lithium.get(1L)});

//				GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(1L,OrePrefixes.turbineBlade.get(aMaterial)), gregtech.api.util.GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | gregtech.api.util.GT_ModHandler.RecipeBits.BUFFERED, new Object[] { "B", "B", "B", 'S', OrePrefixes.screw.get(aMaterial), 'B', OrePrefixes.plate.get(aMaterial) });     


                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 4L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Magnalium, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(170, 1, aMaterial, aMaterial, null), 160, 100);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 8L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Titanium, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(172, 1, aMaterial, aMaterial, null), 320, 400);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 12L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(174, 1, aMaterial, aMaterial, null), 640, 1600);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.turbineBlade, aMaterial, 16L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Americium, 1L), GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(176, 1, aMaterial, aMaterial, null), 1280, 6400);
            }
        }
    }
}