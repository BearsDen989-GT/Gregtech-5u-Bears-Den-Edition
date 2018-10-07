package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingGearSmall implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingGearSmall() {
        OrePrefixes.gearGtSmall.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial.mStandardMoltenFluid != null)
            RECIPE_ADDER_INSTANCE.addFluidSolidifierRecipe(ItemList.Shape_Mold_Gear_Small.get(0L), aMaterial.getMolten(144L), GT_Utility.copyAmount(1L, aStack), 16, 8);
    }
}
