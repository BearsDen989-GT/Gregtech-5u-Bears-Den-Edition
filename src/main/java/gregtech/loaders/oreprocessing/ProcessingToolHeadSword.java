package gregtech.loaders.oreprocessing;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.item.ItemStack;

public class ProcessingToolHeadSword implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingToolHeadSword() {
        OrePrefixes.toolHeadSword.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        GT_ModHandler.addShapelessCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(0, 1, aMaterial, aMaterial.mHandleMaterial, null), new Object[]{aOreDictName, OrePrefixes.stick.get(aMaterial.mHandleMaterial)});
        GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(180, 1, aMaterial, aMaterial, null ), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"SXO", "XMR", "OBP", 'X', aOreDictName, 'M', OrePrefixes.toolHeadFile.get(aMaterial), 'S', OrePrefixes.stickLong.get(aMaterial), 'P', OrePrefixes.plate.get(aMaterial),'R' , OrePrefixes.toolHeadSaw.get(aMaterial),'O', OrePrefixes.ring.get(aMaterial) , 'B', OrePrefixes.stickLong.get(aMaterial)});
    }
}
