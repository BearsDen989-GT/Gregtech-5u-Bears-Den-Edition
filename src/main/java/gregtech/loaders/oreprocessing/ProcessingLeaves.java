package gregtech.loaders.oreprocessing;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import net.minecraft.item.ItemStack;

public class ProcessingLeaves implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingLeaves() {
        OrePrefixes.treeLeaves.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
    }
}
