package gregtech.loaders.oreprocessing;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.MOD_ID_FR;
import static gregtech.api.enums.GT_Values.MOD_ID_RC;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingStone
        implements IOreRecipeRegistrator {
    public ProcessingStone() {
        OrePrefixes.stone.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        Block aBlock = GT_Utility.getBlockFromStack(aStack);
        switch (aMaterial) {
            case _NULL:
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(3L, aStack), new ItemStack(Blocks.redstone_torch, 2), Materials.Redstone.getMolten(144L), new ItemStack(Items.repeater, 1), 100, 4);
                break;
            case Sand:
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), new ItemStack(Blocks.sand, 1, 0), null, 10, false);
                break;
            case Endstone:
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Endstone, 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tungsten, 1L), 5, false);
                break;
            case Netherrack:
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Netherrack, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Gold, 1L), 5, false);
                break;
            case NetherBrick:
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new ItemStack(Blocks.nether_brick_fence, 1), 100, 4);
                break;
            case Obsidian:
                if (aBlock != Blocks.air) aBlock.setResistance(20.0F);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 2L), GT_Utility.copyAmount(5L, aStack), Materials.Glass.getMolten(72L), GT_ModHandler.getModItem(MOD_ID_FR, "thermionicTubes", 4L, 6), 64, 32);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1L), GT_Utility.copyAmount(3L, aStack), Materials.Glass.getMolten(720L), new ItemStack(Blocks.beacon, 1, 0), 32, 16);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(1L, aStack), ItemList.IC2_Compressed_Coal_Ball.get(8L), ItemList.IC2_Compressed_Coal_Chunk.get(1L), 400, 4);
                RECIPE_ADDER_INSTANCE.addAssemblerRecipe(GT_Utility.copyAmount(8L, aStack), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1L), new ItemStack(Blocks.ender_chest, 1), 400, 4);
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_ModHandler.getModItem(MOD_ID_RC, "cube.crushed.obsidian", 1L, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L)), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), 10, true);
                RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 200, 32);
                break;
            case Concrete:
                RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 100, 32);
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L));
                break;
            case Redrock:
            case Marble:
            case Basalt:
            case Quartzite:
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), 10, false);
                break;
            case Flint:
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 2L), new ItemStack(Items.flint, 1), 50, false);
                break;
            case GraniteBlack:
                RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 200, 32);
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1L), 1, false);
                break;
            case GraniteRed:
                RECIPE_ADDER_INSTANCE.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 1L), null, 200, 32);
                GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dustImpure, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Uranium, 1L), 1, false);
        }
    }
}
