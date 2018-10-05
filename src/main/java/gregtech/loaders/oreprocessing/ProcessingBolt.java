package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingBolt implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingBolt() {
        OrePrefixes.bolt.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (!aMaterial.contains(SubTag.NO_WORKING))
            RECIPE_ADDER_INSTANCE.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.screw, aMaterial, 1L), null, (int) Math.max(aMaterial.getMass() / 8L, 1L), 4);
    }
}
