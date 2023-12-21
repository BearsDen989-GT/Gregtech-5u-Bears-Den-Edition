package gregtech.api.items;

import static gregtech.api.enums.GT_Values.W;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import gregtech.api.GregTech_API;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_OreDictUnificator;

public class GT_SolderingTool_Item extends GT_Tool_Item {

    public GT_SolderingTool_Item(String aUnlocalized, String aEnglish, int aMaxDamage, int aEntityDamage,
        int aDischargedGTID) {
        super(
            aUnlocalized,
            aEnglish,
            "To repair and construct Circuitry",
            aMaxDamage,
            aEntityDamage,
            true,
            -1,
            aDischargedGTID);
        GT_OreDictUnificator.registerOre(ToolDictNames.craftingToolSolderingIron, new ItemStack(this, 1, W));
        GregTech_API.registerSolderingTool(new ItemStack(this, 1, W));
    }

    @Override
    public void addAdditionalToolTips(List<String> aList, ItemStack aStack, EntityPlayer aPlayer) {
        aList.add(
            GT_LanguageManager
                .addStringLocalization(getUnlocalizedName() + ".tooltip_1", "Sets the Strength of outputted Redstone"));
        aList.add(
            GT_LanguageManager
                .addStringLocalization(getUnlocalizedName() + ".tooltip_2", "Needs Soldering Metal in Inventory!"));
    }

    @Override
    public boolean onItemUseFirst(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ,
        int ordinalSide, float hitX, float hitY, float hitZ) {
        super.onItemUseFirst(aStack, aPlayer, aWorld, aX, aY, aZ, ordinalSide, hitX, hitY, hitZ);
        return false;
    }
}
