package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingCellPlasma implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingCellPlasma() {
        OrePrefixes.cellPlasma.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial == Materials.Empty) {
            GT_ModHandler.removeRecipeByOutput(aStack);
        } else {
            RECIPE_ADDER_INSTANCE.addFuel(GT_Utility.copyAmount(1L, aStack), GT_Utility.getFluidForFilledItem(aStack, true) == null ? GT_Utility.getContainerItem(aStack, true) : null, (int) Math.max(1024L, 1024L * aMaterial.getMass()), 4);
            RECIPE_ADDER_INSTANCE.addVacuumFreezerRecipe(GT_Utility.copyAmount(1L, aStack), gregtech.api.util.GT_OreDictUnificator.get(OrePrefixes.cell, aMaterial, 1L), (int) Math.max(aMaterial.getMass() * 2L, 1L));
        }
    }
}
