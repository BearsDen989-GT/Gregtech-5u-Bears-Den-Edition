package e99999;

import gregtech.api.enums.Materials;
import gregtech.api.interfaces.tileentity.ICoverable;
import gregtech.api.interfaces.tileentity.IMachineProgress;
import gregtech.api.util.GT_CoverBehavior;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.IFluidHandler;

public class ventAir
        extends GT_CoverBehavior {
    public int doCoverThings(byte aSide, byte aInputRedstone, int aCoverID, int aCoverVariable, ICoverable aTileEntity, long aTimer) {
        if ((aCoverVariable % 3 > 1) && ((aTileEntity instanceof IMachineProgress))) {
            if (((IMachineProgress) aTileEntity).isAllowedToWork() != aCoverVariable % 3 < 2) {
                return aCoverVariable;
            }
        }
        if (aSide != 6) {
        	Block tBlock = aTileEntity.getBlockAtSide(aSide);
            if ((aCoverVariable < 3) && ((aTileEntity instanceof IFluidHandler))) {
                if (

                        (aTileEntity.getYCoord() >= 28)) {
                    int tAmount = (int) (aTileEntity.getYCoord() * 5.0F);
                    if ((tAmount > 0) && (tBlock == Blocks.air)) {
                        ((IFluidHandler) aTileEntity).fill(ForgeDirection.getOrientation(aSide), Materials.Air.getGas(aTileEntity.getWorld().isThundering() ? tAmount * 2 : tAmount), true);
                    }
                }
            }
        }
        return aCoverVariable;
    }

    public boolean letsFluidIn(byte aSide, int aCoverID, int aCoverVariable, Fluid aFluid, ICoverable aTileEntity) {
        if ((aCoverVariable > 1) && ((aTileEntity instanceof IMachineProgress))) {
        }
        return ((IMachineProgress) aTileEntity).isAllowedToWork() == aCoverVariable < 2;
    }

    public boolean alwaysLookConnected(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return true;
    }

    public int getTickRate(byte aSide, int aCoverID, int aCoverVariable, ICoverable aTileEntity) {
        return aCoverVariable < 3 ? 50 : 1;
    }
}