package gregtech.api.items;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;

public class GT_Generic_Block extends Block {
    protected final String mUnlocalizedName;

    protected GT_Generic_Block(Class<? extends ItemBlock> aItemClass, String aName, Material aMaterial) {
        super(aMaterial);
        setBlockName(mUnlocalizedName = aName);
        GameRegistry.registerBlock(this, aItemClass, getUnlocalizedName());
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + "." + OreDictionary.WILDCARD_VALUE + ".name", "Any Sub Block of this one");
    }
}