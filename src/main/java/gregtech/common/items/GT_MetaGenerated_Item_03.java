package gregtech.common.items;

import gregtech.api.enums.MaterialsOld;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.items.GT_MetaGenerated_Item_X32;

public class GT_MetaGenerated_Item_03
        extends GT_MetaGenerated_Item_X32 {
    public static GT_MetaGenerated_Item_03 INSTANCE;

    public GT_MetaGenerated_Item_03() {
        super("metaitem.03", OrePrefixes.crateGtDust, OrePrefixes.crateGtIngot, OrePrefixes.crateGtGem, OrePrefixes.crateGtPlate);
        INSTANCE = this;
    }

    public boolean doesShowInCreative(OrePrefixes aPrefix, MaterialsOld aMaterial, boolean aDoShowAllItems) {
        return aDoShowAllItems;
    }
}
