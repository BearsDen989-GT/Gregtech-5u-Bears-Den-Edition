package e_five_nine;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicTank;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;


//TODO: make portable, then only output bottom
//TODO: output pressure reflects crafting tier pipe

public class BasicTank
        extends GT_MetaTileEntity_BasicTank {

    private static final int[] sMaxTemps = {350, 2000, 2500, 5000, 12500};

    public BasicTank(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, 3, "Null");
    }

    private BasicTank(String aName, int aTier, String aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, 3, aDescription, aTextures);
    }

    @Override
    public ITexture[][][] getTextureSet(ITexture[] aTextures) {
        return new ITexture[0][0][0];
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        return aSide == aFacing ? new ITexture[]{Textures.BlockIcons.STORAGESTUFF[mTier][aColorIndex + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)} : new ITexture[]{Textures.BlockIcons.STORAGESTUFF[mTier][aColorIndex + 1]};
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        return (aBaseMetaTileEntity.isClientSide() || aBaseMetaTileEntity.openGUI(aPlayer));
    }

    @Override
    public boolean isSimpleMachine() {
        return true;
    }

    @Override
    public boolean isFacingValid(byte aFacing) {
        return true;
    }

    @Override
    public boolean isAccessAllowed(EntityPlayer aPlayer) {
        return true;
    }

    @Override
    public final byte getUpdateData() {
        return 0x00;
    }

    @Override
    public boolean doesFillContainers() {
        return true;
    }

    @Override
    public boolean doesEmptyContainers() {
        return true;
    }

    @Override
    public boolean canTankBeFilled() {
        return true;
    }

    @Override
    public String[] getDescription() {
        return new String[]{
                "Stores " + Integer.toString(getCapacity()) + "L",
                "Melts at " + sMaxTemps[mTier] + "k",
                isGasProof() ?
                        "Can store gaseous fluids" :
                        "Leaks gaseous fluids",
                "Outputs to Facing"};
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (aBaseMetaTileEntity.isClientSide()) return;
        if (mFluid == null || mFluid.amount <= 0) return;

        checkGasLeak(aTick);
        doFluidTransfer(aBaseMetaTileEntity);

        if (aTick % 20 == 0) {
            checkHeat(aBaseMetaTileEntity);
        }
    }

    private void doFluidTransfer(IGregTechTileEntity aBaseMetaTileEntity) {
        if (getDrainableStack() == null) return;
        IFluidHandler tTank = aBaseMetaTileEntity.getITankContainerAtSide(aBaseMetaTileEntity.getFrontFacing());
        if (tTank == null) return;
        FluidStack tDrained = drain(250, true);
        if (tDrained == null) return;
        int tFilledAmount = tTank.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), tDrained, false);
        if (tFilledAmount > 0)
            tTank.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), drain(tFilledAmount, true), true);
    }

    private void checkHeat(IGregTechTileEntity aBaseMetaTileEntity) {
        int tTemperature = mFluid.getFluid().getTemperature();
        if (tTemperature > sMaxTemps[mTier]) {
            Block tFluidBlock = mFluid.getFluid().getBlock();
            if (tFluidBlock == null) {
                if (mFluid.getFluid().getTemperature() < 1300) {
                    tFluidBlock = Blocks.fire;
                }
                else {
                    tFluidBlock = Blocks.lava;
                }
            }
            int tX = aBaseMetaTileEntity.getXCoord();
            int tY = aBaseMetaTileEntity.getYCoord();
            int tZ = aBaseMetaTileEntity.getZCoord();
            aBaseMetaTileEntity.getWorld().setBlock(tX, tY, tZ, tFluidBlock,7,2);
            aBaseMetaTileEntity.setOnFire();
            inValidate();
        }
    }

    private void checkGasLeak(long aTick) {
        if (isGasProof() || !(mFluid.getFluid().isGaseous())) return;

        FluidStack tDrained = drain(5, true);
        if (tDrained == null) return;
        mFluid.amount -= tDrained.amount;
        if (aTick % 200 == 0) sendSound((byte) 9); // Avoid sound spamming
    }

    private boolean isGasProof() {
        return (mTier > 0);
    }

    @Override
    public boolean canTankBeEmptied() {
        return true;
    }

    @Override
    public boolean displaysItemStack() {
        return true;
    }

    @Override
    public boolean displaysStackSize() {
        return false;
    }

    @Override
    public void doSound(byte aIndex, double aX, double aY, double aZ) {
        super.doSound(aIndex, aX, aY, aZ);
        if (aIndex == 9) {
            GT_Utility.doSoundAtClient(GregTech_API.sSoundList.get(4), 5, 1.0F, aX, aY, aZ);
            for (byte i = 0; i < 6; i++)
                for (int l = 0; l < 2; ++l)
                    getBaseMetaTileEntity().getWorld().spawnParticle("largesmoke", aX - 0.5 + Math.random(), aY - 0.5 + Math.random(), aZ - 0.5 + Math.random(), ForgeDirection.getOrientation(i).offsetX / 5.0, ForgeDirection.getOrientation(i).offsetY / 5.0, ForgeDirection.getOrientation(i).offsetZ / 5.0);
        }
    }


    @Override
    public String[] getInfoData() {

        if (mFluid == null) {
            return new String[]{
                    "Basic Tank",
                    "Stored Fluid:",
                    "No Fluid",
                    Integer.toString(0) + "L",
                    Integer.toString(getCapacity()) + "L"};
        }
        return new String[]{
                "Basic Tank",
                "Stored Fluid:",
                mFluid.getLocalizedName(),
                Integer.toString(mFluid.amount) + "L",
                Integer.toString(getCapacity()) + "L"};
    }

    @Override
    public boolean isGivingInformation() {
        return true;
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new BasicTank(mName, mTier, mDescription, mTextures);
    }

    @Override
    public int getCapacity() {
        return (int) (Math.pow(2, mTier) * 8000);
    }

    @Override
    public int getTankPressure() {
        return 100;
    }

}