package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingBattery implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingBattery() {
        OrePrefixes.battery.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial == MaterialsOld.Lithium) {
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), GT_ModHandler.getIC2Item("cropnalyzer", 1L, OreDictionary.WILDCARD_VALUE), ItemList.Tool_Scanner.getAlmostBroken(1L), 12800, 16);
        }
    }
}
