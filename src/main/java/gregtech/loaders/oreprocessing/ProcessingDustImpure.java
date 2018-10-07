package gregtech.loaders.oreprocessing;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.GT_Values.RECIPE_ADDER_INSTANCE;

public class ProcessingDustImpure implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingDustImpure() {
        OrePrefixes.dustPure.add(this);
        OrePrefixes.dustImpure.add(this);
        OrePrefixes.dustRefined.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, MaterialsOld aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        MaterialsOld tByProduct = GT_Utility.selectItemInList(aPrefix == OrePrefixes.dustRefined ? 2 : aPrefix == OrePrefixes.dustPure ? 1 : 0, aMaterial, aMaterial.mOreByProducts);

        if (aPrefix == OrePrefixes.dustPure) {
            if (aMaterial.contains(SubTag.ELECTROMAGNETIC_SEPERATION_GOLD))
                RECIPE_ADDER_INSTANCE.addElectromagneticSeparatorRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Gold, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsOld.Gold, 1L), new int[]{10000, 4000, 2000}, 400, 24);
            if (aMaterial.contains(SubTag.ELECTROMAGNETIC_SEPERATION_IRON))
                RECIPE_ADDER_INSTANCE.addElectromagneticSeparatorRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsOld.Iron, 1L), new int[]{10000, 4000, 2000}, 400, 24);
            if (aMaterial.contains(SubTag.ELECTROMAGNETIC_SEPERATION_NEODYMIUM)) {
                RECIPE_ADDER_INSTANCE.addElectromagneticSeparatorRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dustSmall, MaterialsOld.Neodymium, 1L), GT_OreDictUnificator.get(OrePrefixes.nugget, MaterialsOld.Neodymium, 1L), new int[]{10000, 4000, 2000}, 400, 24);
            }
        }
        if (aMaterial.contains(SubTag.CRYSTALLISABLE)) {
            RECIPE_ADDER_INSTANCE.addAutoclaveRecipe(GT_Utility.copyAmount(1L, aStack), MaterialsOld.Water.getFluid(200L), GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L), 9000, 2000, 24);
            RECIPE_ADDER_INSTANCE.addAutoclaveRecipe(GT_Utility.copyAmount(1L, aStack), gregtech.api.util.GT_ModHandler.getDistilledWater(200L), GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L), 9500, 1500, 24);
        }

        ItemStack tStack = GT_OreDictUnificator.get(OrePrefixes.dustTiny, tByProduct, GT_OreDictUnificator.get(OrePrefixes.nugget, tByProduct, 1L), 1L);
        if (tStack == null) {
            tStack = GT_OreDictUnificator.get(OrePrefixes.dustSmall, tByProduct, 1L);
            if (tStack == null) {
                tStack = GT_OreDictUnificator.get(OrePrefixes.dust, tByProduct, GT_OreDictUnificator.get(OrePrefixes.gem, tByProduct, 1L), 1L);
                if (tStack == null) {
                    tStack = GT_OreDictUnificator.get(OrePrefixes.cell, tByProduct, 1L);
                    if (tStack == null) {
                        RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(1L, aStack), 0, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), null, null, null, null, null, (int) Math.max(1L, aMaterial.getMass()));
                    } else {
                        FluidStack tFluid = GT_Utility.getFluidForFilledItem(tStack, true);
                        if (tFluid == null) {
                            RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(9L, aStack), 1, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 9L), tStack, null, null, null, null, (int) Math.max(1L, aMaterial.getMass() * 72L));
                        } else {
                            tFluid.amount /= 10;
                            RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(1L, aStack), null, null, tFluid, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), null, null, null, null, null, null, (int) Math.max(1L, aMaterial.getMass() * 8L), 5);
                        }
                    }
                } else {
                    RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(9L, aStack), 0, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 9L), tStack, null, null, null, null, (int) Math.max(1L, aMaterial.getMass() * 72L));
                }
            } else {
                RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(2L, aStack), 0, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 2L), tStack, null, null, null, null, (int) Math.max(1L, aMaterial.getMass() * 16L));
            }
        } else {
            RECIPE_ADDER_INSTANCE.addCentrifugeRecipe(GT_Utility.copyAmount(1L, aStack), 0, GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L), tStack, null, null, null, null, (int) Math.max(1L, aMaterial.getMass() * 8L));
        }
    }
}
