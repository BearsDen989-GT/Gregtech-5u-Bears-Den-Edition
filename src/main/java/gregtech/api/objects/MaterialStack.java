package gregtech.api.objects;

import gregtech.api.enums.MaterialsOld;

import static gregtech.api.enums.GT_Values.EMPTY_STRING;

public class MaterialStack implements Cloneable {
    public long mAmount;
    public MaterialsOld mMaterial;

    public MaterialStack(MaterialsOld aMaterial, long aAmount) {
        mMaterial = aMaterial == null ? MaterialsOld._NULL : aMaterial;
        mAmount = aAmount;
    }

    public MaterialStack copy(long aAmount) {
        return new MaterialStack(mMaterial, aAmount);
    }

    @Override
    public MaterialStack clone() {
        return new MaterialStack(mMaterial, mAmount);
    }

    @Override
    public boolean equals(Object aObject) {
        if (aObject == this) return true;
        if (aObject == null) return false;
        if (aObject instanceof MaterialsOld) return aObject == mMaterial;
        if (aObject instanceof MaterialStack)
            return ((MaterialStack) aObject).mMaterial == mMaterial && (mAmount < 0 || ((MaterialStack) aObject).mAmount < 0 || ((MaterialStack) aObject).mAmount == mAmount);
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