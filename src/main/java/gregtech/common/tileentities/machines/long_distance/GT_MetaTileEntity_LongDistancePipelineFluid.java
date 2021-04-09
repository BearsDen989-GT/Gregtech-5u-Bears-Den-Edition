package gregtech.common.tileentities.machines.long_distance;

import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class GT_MetaTileEntity_LongDistancePipelineFluid extends GT_MetaTileEntity_LongDistancePipelineBase {
    final static FluidTankInfo[] emptyTank = {new FluidTankInfo(null, Integer.MAX_VALUE)};

    public GT_MetaTileEntity_LongDistancePipelineFluid(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, "Sends fluids over long distances");
    }

    public GT_MetaTileEntity_LongDistancePipelineFluid(String aName, int aTier, String aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    @Override
    public boolean isSameClass(GT_MetaTileEntity_LongDistancePipelineBase other) {
        return other instanceof GT_MetaTileEntity_LongDistancePipelineFluid;
    }

    public int getPipeMeta() {
        return 0;
    }

    public IFluidHandler getTank() {
        final IGregTechTileEntity tTile = mTarget.getBaseMetaTileEntity();
        TileEntity tankTile = tTile.getTileEntityAtSide(tTile.getBackFacing());
        if (tankTile instanceof IFluidHandler) return (IFluidHandler)tankTile;
        else return null;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection aSide) {
        if (checkTarget()) {
            final IFluidHandler tankTile = getTank();
            if (tankTile != null) return tankTile.getTankInfo(aSide);

        }

        return emptyTank;
    }
    @Override
    public int fill(ForgeDirection aSide, FluidStack aFluid, boolean aDoFill) {
        if (checkTarget()) {
            final IGregTechTileEntity tTile = mTarget.getBaseMetaTileEntity();
            final IFluidHandler tankTile = getTank();
            if (tankTile != null) return tankTile.fill(ForgeDirection.getOrientation(tTile.getFrontFacing()), aFluid, aDoFill);
        }
        return 0;
    }
    @Override
    public FluidStack drain(ForgeDirection aSide, FluidStack aFluid, boolean aDoDrain) {
        return null;
    }
    @Override
    public FluidStack drain(ForgeDirection aSide, int aMaxDrain, boolean aDoDrain) {
        return null;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_LongDistancePipelineFluid(mName, mTier, mDescription, mTextures);
    }
    @Override
    public ITexture[][][] getTextureSet(ITexture[] aTextures) {
        return new ITexture[0][0][0];
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        if (aSide == aFacing)
            return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPELINE_FLUID_FRONT)};
        else if (aSide == GT_Utility.getOppositeSide(aFacing))
            return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPELINE_FLUID_BACK)};
        else
            return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPELINE_FLUID_SIDE)};
    }
}