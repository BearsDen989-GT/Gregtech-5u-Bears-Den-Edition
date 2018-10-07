package gregtech.loaders.oreprocessing;

import appeng.core.Api;
import gregtech.GT_Mod;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingNugget implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingNugget() {
        OrePrefixes.nugget.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial == MaterialsOld.Iron)
            GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsOld.WroughtIron, 1L));
        if (!aMaterial.contains(SubTag.NO_WORKING))
            RECIPE_ADDER_INSTANCE.addLatheRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.round, aMaterial, 1L), null, (int) Math.max(aMaterial.getMass() / 4L, 1L), 8);
        RECIPE_ADDER_INSTANCE.addAlloySmelterRecipe(GT_Utility.copyAmount(9L, aStack), aMaterial.contains(SubTag.SMELTING_TO_GEM) ? ItemList.Shape_Mold_Ball.get(0L) : ItemList.Shape_Mold_Ingot.get(0L), GT_OreDictUnificator.get(aMaterial.contains(SubTag.SMELTING_TO_GEM) ? OrePrefixes.gem : OrePrefixes.ingot, aMaterial.mSmeltInto, 1L), 200, 2);
        if (aMaterial.mStandardMoltenFluid != null)
            RECIPE_ADDER_INSTANCE.addFluidSolidifierRecipe(ItemList.Shape_Mold_Nugget.get(0L), aMaterial.getMolten(16L), GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial, 1L), 16, 4);
        GT_RecipeRegistrator.registerReverseFluidSmelting(aStack, aMaterial, aPrefix.mMaterialAmount, null);
        GT_RecipeRegistrator.registerReverseMacerating(aStack, aMaterial, aPrefix.mMaterialAmount, null, null, null, false);

        if (GT_Mod.gregtechproxy.mAE2Integration) {
            Api.INSTANCE.registries().matterCannon().registerAmmo(GT_OreDictUnificator.get(OrePrefixes.round, aMaterial, 1L), aMaterial.getMass());
        }
    }
}
