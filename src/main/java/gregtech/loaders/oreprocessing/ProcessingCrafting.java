package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OreDictNames;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.enums.GT_Values.MOD_ID_AE;
import static gregtech.api.enums.GT_Values.MOD_ID_BC_SILICON;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingCrafting implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingCrafting() {
        OrePrefixes.crafting.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.equals(OreDictNames.craftingQuartz.toString())) {
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(new ItemStack(Blocks.redstone_torch, 3, OreDictionary.WILDCARD_VALUE), GT_Utility.copyAmount(1L, aStack), Materials.Concrete.getMolten(144L), new ItemStack(net.minecraft.init.Items.comparator, 1, 0), 800, 1);
        } else if (aOreDictName.equals(OreDictNames.craftingWireCopper.toString())) {
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(ItemList.Circuit_Basic.get(1L), GT_Utility.copyAmount(1L, aStack), GT_ModHandler.getIC2Item("frequencyTransmitter", 1L), 800, 1);
        } else if (aOreDictName.equals(OreDictNames.craftingWireTin.toString())) {
            RECIPE_ADDER_INSTANCE.addAssemblerRecipe(ItemList.Circuit_Basic.get(1L), GT_Utility.copyAmount(1L, aStack), GT_ModHandler.getIC2Item("frequencyTransmitter", 1L), 800, 1);
        } else if (aOreDictName.equals(OreDictNames.craftingLensBlue.toString())) {
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 13), 2000, 1920);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 13), 2000, 1920);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(ItemList.IC2_LapotronCrystal.getWildcard(1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Crystal_Chip_Master.get(3L), 256, 480);
        } else if (aOreDictName.equals(OreDictNames.craftingLensYellow.toString())) {
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 14), 2000, 1920);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 14), 2000, 1920);
        } else if (aOreDictName.equals(OreDictNames.craftingLensCyan.toString())) {
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 15), 2000, 1920);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 15), 2000, 1920);
        } else if (aOreDictName.equals(OreDictNames.craftingLensRed.toString())) {
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_BC_SILICON, "redstoneChipset", 1L, 0), 50, 120);

            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Wiring_Basic.get(1L), 64, 30);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnnealedCopper, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Wiring_Basic.get(1L), 64, 30);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gold, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Wiring_Advanced.get(1L), 64, 120);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Electrum, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Wiring_Advanced.get(1L), 64, 120);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Platinum, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Wiring_Elite.get(1L), 64, 480);
        } else if (aOreDictName.equals(OreDictNames.craftingLensGreen.toString())) {
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), 256, 480);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1L), GT_Utility.copyAmount(0L, aStack), ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L), 256, 480);
        } else if (aOreDictName.equals(OreDictNames.craftingLensWhite.toString())) {
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Iron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 19), 2000, 1920);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.WroughtIron, 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "item.ItemMultiMaterial", 1L, 19), 2000, 1920);

            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(new ItemStack(Blocks.sandstone, 1, 2), GT_Utility.copyAmount(0L, aStack), new ItemStack(Blocks.sandstone, 1, 1), 50, 16);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(new ItemStack(Blocks.stone, 1, 0), GT_Utility.copyAmount(0L, aStack), new ItemStack(Blocks.stonebrick, 1, 3), 50, 16);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(new ItemStack(Blocks.quartz_block, 1, 0), GT_Utility.copyAmount(0L, aStack), new ItemStack(Blocks.quartz_block, 1, 1), 50, 16);
            RECIPE_ADDER_INSTANCE.addLaserEngraverRecipe(GT_ModHandler.getModItem(MOD_ID_AE, "tile.BlockQuartz", 1L), GT_Utility.copyAmount(0L, aStack), GT_ModHandler.getModItem(MOD_ID_AE, "tile.BlockQuartzChiseled", 1L), 50, 16);
        }
    }
}
