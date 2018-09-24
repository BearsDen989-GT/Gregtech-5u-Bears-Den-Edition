package gregtech.common.tileentities.machines.multi;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.common.gui.GT_Container_BrickedBlastFurnace;
import gregtech.common.gui.GT_Container_BronzeBlastFurnace;
import gregtech.common.gui.GT_GUIContainer_BrickedBlastFurnace;
import gregtech.common.gui.GT_GUIContainer_BronzeBlastFurnace;
import net.minecraft.block.Block;
import net.minecraft.entity.player.InventoryPlayer;

public class GT_MetaTileEntity_BronzeBlastFurnace
        extends GT_MetaTileEntity_PrimitiveBlastFurnace {
    private static final ITexture[] FACING_SIDE = {new GT_RenderedTexture(Textures.BlockIcons.MACHINE_BRONZEPLATEDBRICKS)};
    private static final ITexture[] FACING_FRONT = {new GT_RenderedTexture(Textures.BlockIcons.MACHINE_BRONZEBLASTFURNACE)};
    private static final ITexture[] FACING_ACTIVE = {new GT_RenderedTexture(Textures.BlockIcons.MACHINE_BRONZEBLASTFURNACE_ACTIVE)};

    public GT_MetaTileEntity_BronzeBlastFurnace(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public GT_MetaTileEntity_BronzeBlastFurnace(String aName) {
        super(aName);
    }

    public String[] getDescription() {
        return new String[]{
                "Controller Block for the Bronze Blast Furnace",
                "How to get your first Steel",
                "Size(WxHxD): 3x4x3 (Hollow, with opening on top)",
                "Bronze Plated Bricks for the rest (32 at least!)",
                };
    }

    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing) {
            return aActive ? FACING_ACTIVE : FACING_FRONT;
        }
        return FACING_SIDE;
    }

    @Override
    protected boolean isCorrectCasingBlock(Block block) {
        return block == GregTech_API.sBlockCasings1;
    }

    @Override
    protected boolean isCorrectCasingMetaID(int metaID) {
        return metaID == 10;
    }

    @Override
    public Object getServerGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_Container_BronzeBlastFurnace(aPlayerInventory, aBaseMetaTileEntity);
    }

    @Override
    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_BronzeBlastFurnace(aPlayerInventory, aBaseMetaTileEntity);
    }
}