package gregtech.common.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import gregtech.api.util.GT_LanguageManager;

public class GT_Item_Concretes extends GT_Item_Stones_Abstract {

    private final String mRunFasterToolTip = GT_LanguageManager
        .addStringLocalization("gt.runfastertooltip", "You can walk faster on this Block");

    public GT_Item_Concretes(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack aStack, EntityPlayer aPlayer, List<String> aList, boolean aF3_H) {
        super.addInformation(aStack, aPlayer, aList, aF3_H);
        aList.add(this.mRunFasterToolTip);
    }
}
