package gregtech.loaders.oreprocessing;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.MATERIAL_UNIT;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingRecycling implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingRecycling() {
        for (OrePrefixes tPrefix : OrePrefixes.values())
            if ((tPrefix.mIsMaterialBased) && (tPrefix.mMaterialAmount > 0L) && (tPrefix.mIsContainer))
                tPrefix.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if ((aMaterial != MaterialsOld.Empty) && (GT_Utility.getFluidForFilledItem(aStack, true) == null))
            RECIPE_ADDER_INSTANCE.addCannerRecipe(aStack, null, GT_Utility.getContainerItem(aStack, true), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, aPrefix.mMaterialAmount / MATERIAL_UNIT), (int) Math.max(aMaterial.getMass() / 2L, 1L), 2);
    }
}
