package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.NULL_FLUID_STACK;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingSlab implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingSlab() {
        OrePrefixes.slab.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.startsWith("slabWood")) {
            RECIPE_ADDER_INSTANCE.addChemicalBathRecipe(GT_Utility.copyAmount(3L, aStack), MaterialsOld.Creosote.getFluid(1000L), NULL_FLUID_STACK, ItemList.RC_Tie_Wood.get(1L), null, null, null, 200, 4);
        }
    }
}
