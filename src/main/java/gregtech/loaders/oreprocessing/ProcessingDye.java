package gregtech.loaders.oreprocessing;

import gregtech.api.enums.Dyes;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingDye implements IOreRecipeRegistrator {
    public ProcessingDye() {
        OrePrefixes.dye.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        Dyes aDye = Dyes.get(aOreDictName);
        if ((aDye.mIndex >= 0) && (aDye.mIndex < 16) &&
                (GT_Utility.getContainerItem(aStack, true) == null)) {
            GT_ModHandler.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsOld.Glass, 8L), GT_Utility.copyAmount(1L, aStack), new ItemStack(Blocks.stained_glass, 8, 15 - aDye.mIndex), 200, 8, false);
            GT_ModHandler.addAlloySmelterRecipe(new ItemStack(Blocks.glass, 8, OreDictionary.WILDCARD_VALUE), GT_Utility.copyAmount(1L, aStack), new ItemStack(Blocks.stained_glass, 8, 15 - aDye.mIndex), 200, 8, false);
            RECIPE_ADDER_INSTANCE.addMixerRecipe(GT_Utility.copyAmount(1L, aStack), null, null, null, MaterialsOld.Water.getFluid(144L), FluidRegistry.getFluidStack("dye.watermixed." + aDye.name().toLowerCase(), 144), null, 16, 4);
            RECIPE_ADDER_INSTANCE.addMixerRecipe(GT_Utility.copyAmount(1L, aStack), null, null, null, GT_ModHandler.getDistilledWater(144L), FluidRegistry.getFluidStack("dye.watermixed." + aDye.name().toLowerCase(), 144), null, 16, 4);
        }
    }
}
