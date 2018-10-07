package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingGear implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingGear() {
        OrePrefixes.gearGt.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        GT_ModHandler.removeRecipeByOutput(aStack);
        if (aMaterial.mStandardMoltenFluid != null)
            RECIPE_ADDER_INSTANCE.addFluidSolidifierRecipe(ItemList.Shape_Mold_Gear.get(0L), aMaterial.getMolten(576L), GT_OreDictUnificator.get(aPrefix, aMaterial, 1L), 128, 8);
    }
}
