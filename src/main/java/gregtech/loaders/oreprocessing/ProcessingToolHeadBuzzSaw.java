package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraft.item.ItemStack;

public class ProcessingToolHeadBuzzSaw implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingToolHeadBuzzSaw() {
        OrePrefixes.toolHeadBuzzSaw.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(140, 1, aMaterial, MaterialsOld.StainlessSteel, new long[]{100000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PBM", "dXG", "SGP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L), 'S', OrePrefixes.screw.get(MaterialsOld.StainlessSteel), 'P', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(MaterialsOld.StainlessSteel), 'B', ItemList.Battery_RE_LV_Lithium.get(1L)});
        GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(140, 1, aMaterial, MaterialsOld.StainlessSteel, new long[]{75000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PBM", "dXG", "SGP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L), 'S', OrePrefixes.screw.get(MaterialsOld.StainlessSteel), 'P', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(MaterialsOld.StainlessSteel), 'B', ItemList.Battery_RE_LV_Cadmium.get(1L)});
        GT_ModHandler.addCraftingRecipe(GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(140, 1, aMaterial, MaterialsOld.StainlessSteel, new long[]{50000L, 32L, 1L, -1L}), GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"PBM", "dXG", "SGP", 'X', aOreDictName, 'M', ItemList.Electric_Motor_LV.get(1L), 'S', OrePrefixes.screw.get(MaterialsOld.StainlessSteel), 'P', OrePrefixes.plate.get(MaterialsOld.StainlessSteel), 'G', OrePrefixes.gearGtSmall.get(MaterialsOld.StainlessSteel), 'B', ItemList.Battery_RE_LV_Sodium.get(1L)});
    }
}
