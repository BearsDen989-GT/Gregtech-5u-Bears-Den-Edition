package gregtech.loaders.load;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Recipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.MOD_ID_TC;
import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class GT_FuelLoader
        implements Runnable {
    public void run() {
        GT_Log.out.println("GT_Mod: Initializing various Fuels.");
        new GT_Recipe(new ItemStack(Items.lava_bucket), new ItemStack(Blocks.obsidian), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Electrum, 1L), 30, 2);

        GT_Recipe.GT_Recipe_Map.sSmallNaquadahReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, MaterialsOld.NaquadahEnriched, 1L)}, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.bolt, MaterialsOld.Naquadah, 1L)}, null, null, null, 0, 0, 25000);
        GT_Recipe.GT_Recipe_Map.sLargeNaquadahReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.NaquadahEnriched, 1L)}, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ingot, MaterialsOld.Naquadah, 1L)}, null, null, null, 0, 0, 200000);
        GT_Recipe.GT_Recipe_Map.sFluidNaquadahReactorFuels.addRecipe(true, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, MaterialsOld.NaquadahEnriched, 1L)}, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, MaterialsOld.Empty, 1L)}, null, null, null, 0, 0, 200000);

        RECIPE_ADDER_INSTANCE.addFuel(GT_ModHandler.getModItem(MOD_ID_TC, "ItemResource", 1L, 4), null, 4, 5);
        RECIPE_ADDER_INSTANCE.addFuel(new ItemStack(Items.experience_bottle, 1), null, 10, 5);
        RECIPE_ADDER_INSTANCE.addFuel(new ItemStack(Items.ghast_tear, 1), null, 50, 5);
        RECIPE_ADDER_INSTANCE.addFuel(new ItemStack(Blocks.beacon, 1), null, MaterialsOld.NetherStar.mFuelPower * 2, MaterialsOld.NetherStar.mFuelType);
    }
}
