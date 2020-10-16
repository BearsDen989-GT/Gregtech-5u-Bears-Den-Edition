package e99999;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicTank;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

public class tankBasic
        extends GT_MetaTileEntity_BasicTank {
    public tankBasic(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, 3, "Stores " + ((int) (Math.pow(2, aTier) * 8000)) + "L of fluid & outputs front, melts at internal pipe temp");
    }

    public tankBasic(String aName, int aTier, String aDescription, ITexture[][][] aTextures) {
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
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        if (aBaseMetaTileEntity.isClientSide()) return true;
        aBaseMetaTileEntity.openGUI(aPlayer);
        return true;
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
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
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
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);
        if (getDrainableStack() != null){
            IFluidHandler tTank = aBaseMetaTileEntity.getITankContainerAtSide(aBaseMetaTileEntity.getFrontFacing());
            if (tTank != null) {
                FluidStack tDrained = drain(250, false);
                if (tDrained != null) {
                    int tFilledAmount = tTank.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), tDrained, false);
                    if (tFilledAmount > 0)
                        tTank.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), drain(tFilledAmount, true), true);
                }
            }

        }

        if (mFluid != null && mFluid.amount > 0) {
            int tLimit = 350; //default limit
        	if (mTier == 1) {
        		tLimit = 2000;
        	} else if (mTier == 2) {
        		tLimit = 2500;
        	} else if (mTier == 3) {
        		tLimit = 5000;
        	} else if (mTier == 4) {
        		tLimit = 12500;
        	}
        
        	int tTemperature = mFluid.getFluid().getTemperature(mFluid);
        	if (tTemperature > tLimit) {
        		if (aBaseMetaTileEntity.getRandomNumber(100) == 0) {
        			aBaseMetaTileEntity.setToFire();
        			return;
        		}
        		aBaseMetaTileEntity.setOnFire();
        	}

    	}
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
        return new tankBasic(mName, mTier, mDescription, mTextures);
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