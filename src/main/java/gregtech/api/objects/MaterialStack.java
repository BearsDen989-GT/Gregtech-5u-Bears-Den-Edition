package gregtech.api.objects;

import gregtech.api.enums.Materials;

import static gregtech.api.enums.GT_Values.EMPTY_STRING;

public class MaterialStack {
    public long mAmount;
    public Materials mMaterial;

    public MaterialStack(Materials aMaterial, long aAmount) {
        mMaterial = aMaterial == null ? Materials._NULL : aMaterial;
        mAmount = aAmount;
    }

    /**
     * {@link MaterialStack} Copy constructor
     * Replaces the old cloneable implementation.
     * @param aMaterialStack {@link MaterialStack} to copy
     */
    public MaterialStack(MaterialStack aMaterialStack) {
        mMaterial = aMaterialStack.mMaterial;
        mAmount = aMaterialStack.mAmount;
    }

    public MaterialStack copy(long aAmount) {
        return new MaterialStack(mMaterial, aAmount);
    }

    @Override
    public boolean equals(Object aObject) {
        if (aObject == this) return true;
        if (aObject == null) return false;
        if (aObject instanceof Materials) return aObject == mMaterial;
        if (aObject instanceof MaterialStack)
            return ((MaterialStack) aObject).mMaterial == mMaterial
                    && (mAmount < 0
                        || ((MaterialStack) aObject).mAmount < 0
                        || ((MaterialStack) aObject).mAmount == mAmount);
        return false;
    }

    @Override
    public String toString() {
        return (mMaterial.getMaterialList().size() > 1 && mAmount > 1 ? "(" : EMPTY_STRING) + mMaterial.getToolTip(true) + (mMaterial.getMaterialList().size() > 1 && mAmount > 1 ? ")" : EMPTY_STRING) + (mAmount > 1 ? mAmount : EMPTY_STRING);
    }

    @Override
    public int hashCode() {
        return mMaterial.hashCode();
    }
}