package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraftforge.fluids.FluidRegistry;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingCrop implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingCrop() {
        OrePrefixes.crop.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, net.minecraft.item.ItemStack aStack) {
        GT_ModHandler.addCompressionRecipe(gregtech.api.util.GT_Utility.copyAmount(8L, aStack), ItemList.IC2_PlantballCompressed.get(1L));
        if (aOreDictName.equals("cropTea")) {
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, FluidRegistry.WATER, FluidRegistry.getFluid("potion.tea"), false);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, GT_ModHandler.getDistilledWater(1L).getFluid(), FluidRegistry.getFluid("potion.tea"), false);
        } else if (aOreDictName.equals("cropGrape")) {
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, FluidRegistry.WATER, FluidRegistry.getFluid("potion.grapejuice"), false);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, GT_ModHandler.getDistilledWater(1L).getFluid(), FluidRegistry.getFluid("potion.grapejuice"), false);
        } else if (aOreDictName.equals("cropChilipepper")) {
            GT_ModHandler.addPulverisationRecipe(aStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chili, 1L));
        } else if (aOreDictName.equals("cropCoffee")) {
            GT_ModHandler.addPulverisationRecipe(aStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coffee, 1L));
        } else if (aOreDictName.equals("cropPotato")) {
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Raw_PotatoChips.get(1L), 64, 4);
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Stripes.get(0L), ItemList.Food_Raw_Fries.get(1L), 64, 4);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, FluidRegistry.WATER, FluidRegistry.getFluid("potion.potatojuice"), true);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, GT_ModHandler.getDistilledWater(1L).getFluid(), FluidRegistry.getFluid("potion.potatojuice"), true);
        } else if (aOreDictName.equals("cropLemon")) {
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Lemon.get(4L), 64, 4);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, FluidRegistry.WATER, FluidRegistry.getFluid("potion.lemonjuice"), false);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, GT_ModHandler.getDistilledWater(1L).getFluid(), FluidRegistry.getFluid("potion.lemonjuice"), false);
            RECIPE_ADDER_INSTANCE.addBrewingRecipe(aStack, FluidRegistry.getFluid("potion.vodka"), FluidRegistry.getFluid("potion.leninade"), true);
        } else if (aOreDictName.equals("cropTomato")) {
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Tomato.get(4L), 64, 4);
        } else if (aOreDictName.equals("cropCucumber")) {
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Cucumber.get(4L), 64, 4);
        } else if (aOreDictName.equals("cropOnion")) {
            RECIPE_ADDER_INSTANCE.addSlicerRecipe(aStack, ItemList.Shape_Slicer_Flat.get(0L), ItemList.Food_Sliced_Onion.get(4L), 64, 4);
        }
    }
}
