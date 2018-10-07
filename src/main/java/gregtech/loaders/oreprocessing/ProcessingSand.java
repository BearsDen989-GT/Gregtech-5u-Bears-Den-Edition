package gregtech.loaders.oreprocessing;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingSand implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingSand() {
        OrePrefixes.sand.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.equals("sandCracked")) {
            RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(16L, aStack), -1, gregtech.api.util.GT_ModHandler.getFuelCan(25000), GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Saltpeter, 8L), null, null, null, new ItemStack(Blocks.sand, 10), 2500);
        } else if (aOreDictName.equals("sandOil")) {
            RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(2L, aStack), 1, GT_OreDictUnificator.get(OrePrefixes.cell, MaterialsOld.Oil, 1L), new ItemStack(Blocks.sand, 1, 0), null, null, null, null, 1000);
        }
    }
}
