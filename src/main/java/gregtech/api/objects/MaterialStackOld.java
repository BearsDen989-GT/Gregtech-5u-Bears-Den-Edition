package gregtech.api.objects;

import gregtech.api.enums.MaterialsOld;

import static gregtech.api.enums.GT_Values.EMPTY_STRING;

public class MaterialStackOld {
    public long mAmount;
    public MaterialsOld mMaterial;

    public MaterialStackOld(MaterialsOld aMaterial, long aAmount) {
        mMaterial = aMaterial == null ? MaterialsOld._NULL : aMaterial;
        mAmount = aAmount;
    }

    /**
     * {@link MaterialStackOld} Copy constructor
     * Replaces the old cloneable implementation.
     * @param aMaterialStack {@link MaterialStackOld} to copy
     */
    public MaterialStackOld(MaterialStackOld aMaterialStack) {
        mMaterial = aMaterialStack.mMaterial;
        mAmount = aMaterialStack.mAmount;
    }

    public MaterialStackOld copy(long aAmount) {
        return new MaterialStackOld(mMaterial, aAmount);
    }

    @Override
    public boolean equals(Object aObject) {
        if (aObject == this) return true;
        if (aObject == null) return false;
        if (aObject instanceof MaterialsOld) return aObject == mMaterial;
        if (aObject instanceof MaterialStackOld)
            return ((MaterialStackOld) aObject).mMaterial == mMaterial
                    && (mAmount < 0
                    || ((MaterialStackOld) aObject).mAmount < 0
                    || ((MaterialStackOld) aObject).mAmount == mAmount);
        return false;
    }

    @Override
    public String toString() {
        return (mMaterial.mMaterialList.size() > 1 && mAmount > 1 ? "(" : EMPTY_STRING) + mMaterial.getToolTip(true) + (mMaterial.mMaterialList.size() > 1 && mAmount > 1 ? ")" : EMPTY_STRING) + (mAmount > 1 ? mAmount : EMPTY_STRING);
    }

    @Override
    public int hashCode() {
        return mMaterial.hashCode();
    }
}