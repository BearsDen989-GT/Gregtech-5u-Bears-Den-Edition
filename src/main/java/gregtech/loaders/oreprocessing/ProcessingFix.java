package gregtech.loaders.oreprocessing;


import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

/*Correct processing amounts for mixed ores. - e99999*/

public class ProcessingFix implements gregtech.api.interfaces.IOreRecipeRegistrator {
    private final OrePrefixes[] mSmeltingPrefixes = {OrePrefixes.ore, OrePrefixes.oreBlackgranite, OrePrefixes.oreNetherrack, OrePrefixes.oreEndstone, OrePrefixes.oreRedgranite, OrePrefixes.crushed, OrePrefixes.crushedPurified, OrePrefixes.crushedCentrifuged, OrePrefixes.dust, OrePrefixes.dustImpure, OrePrefixes.dustPure, OrePrefixes.dustRefined};

    public ProcessingFix() {
        for (OrePrefixes tPrefix : this.mSmeltingPrefixes) tPrefix.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        switch (aMaterial.mName) {
            case "Tetrahedrite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 3L));
                break;
            case "Malachite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 1L));
                break;
            case "Chalcopyrite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 2L));
                break;
            case "Pentlandite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Nickel, 4L));
                break;
            case "Sphalerite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Zinc, 4L));
                break;
            case "Pyrite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 3L));
                break;
            case "BasalticMineralSand":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 2L));
                break;
            case "GraniticMineralSand":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 2L));
                break;
            case "YellowLimonite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 2L));
                break;
            case "BrownLimonite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 2L));
                break;
            case "BandedIron":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 3L));
                break;
            case "Magnetite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 3L));
                break;
            case "Cassiterite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 7L));
                break;
            case "CassiteriteSand":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 7L));
                break;
            case "Chromite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Chrome, 2L));
                break;
            case "Garnierite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Nickel, 3L));
                break;
            case "Cobaltite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Cobalt, 2L));
                break;
            case "Stibnite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Antimony, 2L));
                break;
            case "Pyrolusite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Manganese, 2L));
                break;
            case "Molybdenite":
                GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Molybdenum, 2L));

                    }

                }
            }
