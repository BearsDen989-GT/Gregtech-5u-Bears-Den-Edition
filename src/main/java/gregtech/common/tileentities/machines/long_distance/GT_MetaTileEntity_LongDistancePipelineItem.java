package gregtech.common.tileentities.machines.long_distance;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class GT_MetaTileEntity_LongDistancePipelineItem extends GT_MetaTileEntity_LongDistancePipelineBase {
    final static int[] emptyIntArray = new int[0];

    public GT_MetaTileEntity_LongDistancePipelineItem(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, "Sends Items over long distances");
    }

    public GT_MetaTileEntity_LongDistancePipelineItem(String aName, int aTier, String aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    @Override
    public boolean isSameClass(GT_MetaTileEntity_LongDistancePipelineBase other) {
        return other instanceof GT_MetaTileEntity_LongDistancePipelineItem;
    }

    public int getPipeMeta() {
        return 1;
    }

    public IInventory getInventory() {
        final IGregTechTileEntity tTile = mTarget.getBaseMetaTileEntity();
        TileEntity invTile = tTile.getTileEntityAtSide(tTile.getBackFacing());
        if (invTile instanceof IInventory) return (IInventory)invTile;
        else return null;
    }

    @Override
    public ItemStack decrStackSize(int aSlot, int aDecrement) {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.decrStackSize(aSlot, aDecrement);
        }
        return null;
    }
    @Override
    public ItemStack getStackInSlotOnClosing(int aSlot) {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.getStackInSlotOnClosing(aSlot);
        }
        return null;
    }
    @Override
    public ItemStack getStackInSlot(int aSlot) {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.getStackInSlot(aSlot);
        }
        return null;
    }
    @Override
    public String getInventoryName() {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.getInventoryName();
        }
        return super.getInventoryName();
    }
    @Override
    public int getSizeInventory() {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.getSizeInventory();
        }
        return 0;
    }
    @Override
    public int getInventoryStackLimit() {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.getInventoryStackLimit();
        }
        return 0;
    }
    @Override
    public void setInventorySlotContents(int aSlot, ItemStack aStack) {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) iInventory.setInventorySlotContents(aSlot, aStack);
        }
    }
    @Override
    public boolean hasCustomInventoryName() {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.hasCustomInventoryName();
        }
        return false;
    }
    @Override
    public boolean isItemValidForSlot(int aSlot, ItemStack aStack) {
        if (checkTarget()) {
            IInventory iInventory = getInventory();
            if (iInventory != null) return iInventory.isItemValidForSlot(aSlot, aStack);
        }
        return false;
    }

//    // Relay Sided Inventories
//

    @Override
    public int[] getAccessibleSlotsFromSide(int aSide) {
        if (checkTarget()) {
            final IGregTechTileEntity tTile = mTarget.getBaseMetaTileEntity();
            IInventory iInventory = getInventory();
            if (iInventory instanceof ISidedInventory) return ((ISidedInventory)iInventory).getAccessibleSlotsFromSide(tTile.getBackFacing());
            if (iInventory != null) {
                int[] tReturn = new int[iInventory.getSizeInventory()];
                for (int i = 0; i < tReturn.length; i++) tReturn[i] = i;
                return tReturn;
            }
        }

        return emptyIntArray;
    }

    @Override
    public boolean canInsertItem(int aSlot, ItemStack aStack, int aSide) {
        if (checkTarget()) {
            final IGregTechTileEntity tTile = mTarget.getBaseMetaTileEntity();
            IInventory iInventory = getInventory();
            if (iInventory instanceof ISidedInventory) return ((ISidedInventory)iInventory).canInsertItem(aSlot, aStack, tTile.getBackFacing());
            return iInventory != null;
        }
        return false;
    }

    @Override
    public boolean canExtractItem(int aSlot, ItemStack aStack, int aSide) {
        return false;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_LongDistancePipelineItem(mName, mTier, mDescription, mTextures);
    }
    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing)
            return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPELINE_ITEM_FRONT)};
        else if (aSide == GT_Utility.getOppositeSide(aFacing))
            return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPELINE_ITEM_BACK)};
        else
            return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPELINE_ITEM_SIDE)};
    }
}