package gregtech.common.covers;

import net.minecraftforge.common.util.ForgeDirection;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.interfaces.tileentity.IMachineProgress;
import gregtech.api.util.ISerializableObject;

public class GT_Cover_RedstoneReceiverInternal extends GT_Cover_RedstoneWirelessBase {

    /**
     * @deprecated use {@link #GT_Cover_RedstoneReceiverInternal(ITexture coverTexture)} instead
     */
    @Deprecated
    public GT_Cover_RedstoneReceiverInternal() {
        this(null);
    }

    public GT_Cover_RedstoneReceiverInternal(ITexture coverTexture) {
        super(coverTexture);
    }

    @Override
    public int doCoverThings(ForgeDirection side, byte aInputRedstone, int aCoverID, int aCoverVariable,
        ICoverable aTileEntity, long aTimer) {
        if (aTileEntity instanceof IMachineProgress) {
            if (getRedstoneInput(side, aInputRedstone, aCoverID, aCoverVariable, aTileEntity) > 0)
                ((IMachineProgress) aTileEntity).enableWorking();
            else((IMachineProgress) aTileEntity).disableWorking();
            ((IMachineProgress) aTileEntity).setWorkDataValue(aInputRedstone);
        }
        return aCoverVariable;
    }

    @Override
    protected boolean isRedstoneSensitiveImpl(ForgeDirection side, int aCoverID,
        ISerializableObject.LegacyCoverData aCoverVariable, ICoverable aTileEntity, long aTimer) {
        return true;
    }

    @Override
    public byte getRedstoneInput(ForgeDirection side, byte aInputRedstone, int aCoverID, int aCoverVariable,
        ICoverable aTileEntity) {
        return GregTech_API.sWirelessRedstone.get(aCoverVariable) == null ? 0
            : GregTech_API.sWirelessRedstone.get(aCoverVariable);
    }

    @Override
    public int getTickRate(ForgeDirection side, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return 1;
    }
}
