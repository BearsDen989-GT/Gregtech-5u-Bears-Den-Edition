package gregtech.api.enums;

import gregtech.api.objects.IColorModulationContainer;
import gregtech.api.objects.GT_ArrayList;
import gregtech.api.util.GT_Utility;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;

public enum Dyes {
    /**
     * The valid Colors, see VALUES Array below
     */
    dyeBlack(0, 0x00202020, "Black"),
    dyeRed(1, 0x00ff0000, "Red"),
    dyeGreen(2, 0x0000ff00, "Green"),
    dyeBrown(3, 0x00604000, "Brown"),
    dyeBlue(4, 0x000000ff, "Blue"),
    dyePurple(5, 0x00800080, "Purple"),
    dyeCyan(6, 0x0000ffff, "Cyan"),
    dyeLightGray(7, 0x00c0c0c0, "Light Gray"),
    dyeGray(8, 0x00808080, "Gray"),
    dyePink(9, 0x00ffc0c0, "Pink"),
    dyeLime(10, 0x0080ff80, "Lime"),
    dyeYellow(11, 0x00ffff00, "Yellow"),
    dyeLightBlue(12, 0x008080ff, "Light Blue"),
    dyeMagenta(13, 0x00ff00ff, "Magenta"),
    dyeOrange(14, 0x00ff8000, "Orange"),
    dyeWhite(15, 0x00ffffff, "White"),
    /**
     * The NULL Color
     */
    _NULL(-1, 0x00ffffff, "INVALID COLOR"),
    /**
     * Additional Colors only used for direct Color referencing
     */
    CABLE_INSULATION(-1, 0x00404040, "Cable Insulation"),
    CONSTRUCTION_FOAM(-1, 0x00404040, "Construction Foam"),
    MACHINE_METAL(-1, 0x00ffffff, "Machine Metal");

    public static final Dyes VALUES[] = {dyeBlack, dyeRed, dyeGreen, dyeBrown, dyeBlue, dyePurple, dyeCyan, dyeLightGray, dyeGray, dyePink, dyeLime, dyeYellow, dyeLightBlue, dyeMagenta, dyeOrange, dyeWhite};

    public final byte mIndex;
    public final String mName;
    private IColorModulationContainer mRGBa;
    private final ArrayList<Fluid> mFluidDyes = new GT_ArrayList<>(false, 1);

    /**
     * @deprecated replaced by single int ARGB
     */
    @Deprecated
    Dyes(int aIndex, int aR, int aG, int aB, String aName) {
        mIndex = (byte) aIndex;
        mName = aName;
        mRGBa = new IColorModulationContainer(aR, aG, aB, 0);
    }

    Dyes(int aIndex, int aARGB, String aName) {
        mIndex = (byte) aIndex;
        mName = aName;
        mRGBa = new IColorModulationContainer(aARGB);
    }

    public static Dyes get(int aColor) {
        if (aColor >= 0 && aColor < 16) return VALUES[aColor];
        return _NULL;
    }

    public static short[] getModulation(int aColor, short[] aDefaultModulation) {
        if (aColor >= 0 && aColor < 16) return VALUES[aColor].mRGBa.getRGBA();
        return aDefaultModulation;
    }

    public static Dyes get(String aColor) {
        Object tObject = GT_Utility.getFieldContent(Dyes.class, aColor, false, false);
        if (tObject instanceof Dyes) return (Dyes) tObject;
        return _NULL;
    }

    public static boolean isAnyFluidDye(FluidStack aFluid) {
        return aFluid != null && isAnyFluidDye(aFluid.getFluid());
    }

    public static boolean isAnyFluidDye(Fluid aFluid) {
        if (aFluid != null) for (Dyes tDye : VALUES) if (tDye.isFluidDye(aFluid)) return true;
        return false;
    }

    public boolean isFluidDye(FluidStack aFluid) {
        return aFluid != null && isFluidDye(aFluid.getFluid());
    }

    public boolean isFluidDye(Fluid aFluid) {
        return aFluid != null && mFluidDyes.contains(aFluid);
    }

    public boolean addFluidDye(Fluid aDye) {
        if (aDye == null || mFluidDyes.contains(aDye)) return false;
        mFluidDyes.add(aDye);
        return true;
    }

    public int getSizeOfFluidList() {
        return mFluidDyes.size();
    }

    /**
     * @param aAmount 1 Fluid Material Unit (144) = 1 Dye Item
     */
    public FluidStack getFluidDye(int aIndex, long aAmount) {
        if (aIndex >= mFluidDyes.size() || aIndex < 0) return null;
        return new FluidStack(mFluidDyes.get(aIndex), (int) aAmount);
    }

    public void setColor(IColorModulationContainer aColor) {
        mRGBa = aColor;
    }

    public IColorModulationContainer getColor() {
        return mRGBa;
    }

    public short[] getRGBa() {
        return mRGBa.getRGBA();
    }
}