package gregtech.api.multitileentity.enums;

import gregtech.api.enums.GT_Values;

public enum GT_MultiTileCasing {

    CokeOven(0),
    Chemical(1),
    NONE(GT_Values.W);

    private final int meta;

    GT_MultiTileCasing(int meta) {
        this.meta = meta;
    }

    public int getId() {
        return meta;
    }
}
