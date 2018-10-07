package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingDustTiny implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingDustTiny() {
        OrePrefixes.dustTiny.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        RECIPE_ADDER_INSTANCE.addBoxingRecipe(GT_Utility.copyAmount(9L, aStack), ItemList.Schematic_Dust.get(0L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), 100, 4);
        if (!aMaterial.mBlastFurnaceRequired) {
            GT_RecipeRegistrator.registerReverseFluidSmelting(aStack, aMaterial, aPrefix.mMaterialAmount, null);
            if (aMaterial.mSmeltInto.mArcSmeltInto != aMaterial) {
                GT_RecipeRegistrator.registerReverseArcSmelting(GT_Utility.copyAmount(1L, aStack), aMaterial, aPrefix.mMaterialAmount, null, null, null);
            }
        }
        if (!aMaterial.contains(gregtech.api.enums.SubTag.NO_SMELTING)) {
            if (aMaterial.mBlastFurnaceRequired) {
                RECIPE_ADDER_INSTANCE.addBlastRecipe(GT_Utility.copyAmount(9L, aStack), null, null, null, aMaterial.mBlastFurnaceTemp > 1750 ? GT_OreDictUnificator.get(OrePrefixes.ingotHot, aMaterial.mSmeltInto, GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial.mSmeltInto, 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial.mSmeltInto, 1L), null, (int) Math.max(aMaterial.getMass() / 40L, 1L) * aMaterial.mBlastFurnaceTemp, 120, aMaterial.mBlastFurnaceTemp);
                GT_ModHandler.removeFurnaceSmelting(aStack);
            } else {
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial.mSmeltInto, 1L));
                GT_ModHandler.addAlloySmelterRecipe(GT_Utility.copyAmount(9L, aStack), ItemList.Shape_Mold_Ingot.get(0L), GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial.mSmeltInto, 1L), 130, 3, true);
            }
        }
    }
}
