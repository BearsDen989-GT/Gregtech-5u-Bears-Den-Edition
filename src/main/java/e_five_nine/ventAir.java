package e_five_nine;

import gregtech.api.enums.Materials;
import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.interfaces.tileentity.IMachineProgress;
import gregtech.api.util.GT_CoverBehavior;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidHandler;

public class ventAir
        extends GT_CoverBehavior {
    public int doCoverThings(byte aSide, byte aInputRedstone, int aCoverID, int aCoverVariable, ICoverable aTileEntity, long aTimer) {
        if ((aCoverVariable % 3 > 1) && (aTileEntity instanceof IMachineProgress) &&
                ((IMachineProgress) aTileEntity).isAllowedToWork() != aCoverVariable % 3 < 2) {
                return aCoverVariable;
            }
        if (aSide != 6) {
            Block tBlock = aTileEntity.getBlockAtSide(aSide);
            if ((aCoverVariable < 3) && (aTileEntity instanceof IFluidHandler)
                && (tBlock == Blocks.air)) {
                        ((IFluidHandler) aTileEntity).fill(ForgeDirection.getOrientation(aSide), Materials.Air.getGas(1000), true);
                    }
                }
                return aCoverVariable;
    }

    public boolean letsFluidIn(byte aSide, int aCoverID, int aCoverVariable, Fluid aFluid, ICoverable aTileEntity) {
        return ((IMachineProgress) aTileEntity).isAllowedToWork() == aCoverVariable < 2;
    }

    public boolean alwaysLookConnected(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return true;
    }

    public int getTickRate(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return aCoverVariable < 3 ? 50 : 1;
    }
}
