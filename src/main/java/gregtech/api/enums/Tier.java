package gregtech.api.enums;

/**
 * Experimental Class for later
 */
public class Tier {
    public static final Tier[]
            ELECTRIC = new Tier[]{
            new Tier(SubTag.ENERGY_ELECTRICITY, 0, 8, 1, 1, 1, MaterialsOld.WroughtIron, ItemList.Hull_ULV, OrePrefixes.cableGt01.get(MaterialsOld.Lead), OrePrefixes.cableGt04.get(MaterialsOld.Lead), OrePrefixes.circuit.get(MaterialsOld.Primitive), OrePrefixes.circuit.get(MaterialsOld.Basic)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 1, 32, 1, 1, 1, MaterialsOld.Steel, ItemList.Hull_LV, OrePrefixes.cableGt01.get(MaterialsOld.Tin), OrePrefixes.cableGt04.get(MaterialsOld.Tin), OrePrefixes.circuit.get(MaterialsOld.Basic), OrePrefixes.circuit.get(MaterialsOld.Good)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 2, 128, 1, 1, 1, MaterialsOld.Aluminium, ItemList.Hull_MV, OrePrefixes.cableGt01.get(MaterialsOld.AnyCopper), OrePrefixes.cableGt04.get(MaterialsOld.AnyCopper), OrePrefixes.circuit.get(MaterialsOld.Good), OrePrefixes.circuit.get(MaterialsOld.Advanced)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 3, 512, 1, 1, 1, MaterialsOld.StainlessSteel, ItemList.Hull_HV, OrePrefixes.cableGt01.get(MaterialsOld.Gold), OrePrefixes.cableGt04.get(MaterialsOld.Gold), OrePrefixes.circuit.get(MaterialsOld.Advanced), OrePrefixes.circuit.get(MaterialsOld.Elite)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 4, 2048, 1, 1, 1, MaterialsOld.Titanium, ItemList.Hull_EV, OrePrefixes.cableGt01.get(MaterialsOld.Aluminium), OrePrefixes.cableGt04.get(MaterialsOld.Aluminium), OrePrefixes.circuit.get(MaterialsOld.Elite), OrePrefixes.circuit.get(MaterialsOld.Master)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 5, 8192, 1, 1, 1, MaterialsOld.TungstenSteel, ItemList.Hull_IV, OrePrefixes.cableGt01.get(MaterialsOld.Tungsten), OrePrefixes.cableGt04.get(MaterialsOld.Tungsten), OrePrefixes.circuit.get(MaterialsOld.Master), OrePrefixes.circuit.get(MaterialsOld.Ultimate)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 6, 32768, 1, 1, 1, MaterialsOld.Chrome, ItemList.Hull_LuV, OrePrefixes.cableGt01.get(MaterialsOld.Osmium), OrePrefixes.cableGt04.get(MaterialsOld.Osmium), OrePrefixes.circuit.get(MaterialsOld.Ultimate), OrePrefixes.circuit.get(MaterialsOld.Ultimate)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 7, 131072, 1, 1, 1, MaterialsOld.Iridium, ItemList.Hull_ZPM, OrePrefixes.cableGt04.get(MaterialsOld.Osmium), OrePrefixes.wireGt16.get(MaterialsOld.Osmium), OrePrefixes.circuit.get(MaterialsOld.Ultimate), OrePrefixes.circuit.get(MaterialsOld.Ultimate)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 8, 524288, 1, 1, 1, MaterialsOld.Osmium, ItemList.Hull_UV, OrePrefixes.wireGt16.get(MaterialsOld.Osmium), OrePrefixes.wireGt01.get(MaterialsOld.Superconductor), OrePrefixes.circuit.get(MaterialsOld.Ultimate), OrePrefixes.circuit.get(MaterialsOld.Ultimate)),
            new Tier(SubTag.ENERGY_ELECTRICITY, 9, Integer.MAX_VALUE, 1, 1, 1, MaterialsOld.Neutronium, ItemList.Hull_MAX, OrePrefixes.wireGt01.get(MaterialsOld.Superconductor), OrePrefixes.wireGt04.get(MaterialsOld.Superconductor), OrePrefixes.circuit.get(MaterialsOld.Ultimate), OrePrefixes.circuit.get(MaterialsOld.Ultimate)),
    }, ROTATIONAL = new Tier[]{
            new Tier(SubTag.ENERGY_ROTATIONAL, 1, 32, 1, 1, 1, MaterialsOld.Wood, OrePrefixes.frameGt.get(MaterialsOld.Wood), OrePrefixes.stick.get(MaterialsOld.Wood), OrePrefixes.ingot.get(MaterialsOld.Wood), OrePrefixes.gearGt.get(MaterialsOld.Wood), OrePrefixes.gearGt.get(MaterialsOld.Stone)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 1, 32, 1, 2, 2, MaterialsOld.WoodSealed, OrePrefixes.frameGt.get(MaterialsOld.WoodSealed), OrePrefixes.stick.get(MaterialsOld.WoodSealed), OrePrefixes.ingot.get(MaterialsOld.WoodSealed), OrePrefixes.gearGt.get(MaterialsOld.WoodSealed), OrePrefixes.gearGt.get(MaterialsOld.Stone)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 2, 128, 1, 1, 1, MaterialsOld.Stone, OrePrefixes.frameGt.get(MaterialsOld.Stone), OrePrefixes.stick.get(MaterialsOld.Stone), OrePrefixes.ingot.get(MaterialsOld.Stone), OrePrefixes.gearGt.get(MaterialsOld.Stone), OrePrefixes.gearGt.get(MaterialsOld.Bronze)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 2, 128, 1, 2, 2, MaterialsOld.IronWood, OrePrefixes.frameGt.get(MaterialsOld.IronWood), OrePrefixes.stick.get(MaterialsOld.IronWood), OrePrefixes.ingot.get(MaterialsOld.IronWood), OrePrefixes.gearGt.get(MaterialsOld.IronWood), OrePrefixes.gearGt.get(MaterialsOld.Bronze)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 3, 512, 1, 1, 1, MaterialsOld.Bronze, OrePrefixes.frameGt.get(MaterialsOld.Bronze), OrePrefixes.stick.get(MaterialsOld.Bronze), OrePrefixes.ingot.get(MaterialsOld.Bronze), OrePrefixes.gearGt.get(MaterialsOld.Bronze), OrePrefixes.gearGt.get(MaterialsOld.Steel)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 3, 512, 1, 2, 2, MaterialsOld.Brass, OrePrefixes.frameGt.get(MaterialsOld.Brass), OrePrefixes.stick.get(MaterialsOld.Brass), OrePrefixes.ingot.get(MaterialsOld.Brass), OrePrefixes.gearGt.get(MaterialsOld.Brass), OrePrefixes.gearGt.get(MaterialsOld.Steel)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 4, 2048, 1, 1, 1, MaterialsOld.Steel, OrePrefixes.frameGt.get(MaterialsOld.Steel), OrePrefixes.stick.get(MaterialsOld.Steel), OrePrefixes.ingot.get(MaterialsOld.Steel), OrePrefixes.gearGt.get(MaterialsOld.Steel), OrePrefixes.gearGt.get(MaterialsOld.TungstenSteel)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 4, 2048, 1, 2, 2, MaterialsOld.Titanium, OrePrefixes.frameGt.get(MaterialsOld.Titanium), OrePrefixes.stick.get(MaterialsOld.Titanium), OrePrefixes.ingot.get(MaterialsOld.Titanium), OrePrefixes.gearGt.get(MaterialsOld.Titanium), OrePrefixes.gearGt.get(MaterialsOld.TungstenSteel)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 5, 8192, 1, 1, 1, MaterialsOld.TungstenSteel, OrePrefixes.frameGt.get(MaterialsOld.TungstenSteel), OrePrefixes.stick.get(MaterialsOld.TungstenSteel), OrePrefixes.ingot.get(MaterialsOld.TungstenSteel), OrePrefixes.gearGt.get(MaterialsOld.TungstenSteel), OrePrefixes.gearGt.get(MaterialsOld.Iridium)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 6, 32768, 1, 1, 1, MaterialsOld.Iridium, OrePrefixes.frameGt.get(MaterialsOld.Iridium), OrePrefixes.stick.get(MaterialsOld.Iridium), OrePrefixes.ingot.get(MaterialsOld.Iridium), OrePrefixes.gearGt.get(MaterialsOld.Iridium), OrePrefixes.gearGt.get(MaterialsOld.Neutronium)),
            new Tier(SubTag.ENERGY_ROTATIONAL, 9, Integer.MAX_VALUE, 1, 1, 1, MaterialsOld.Neutronium, OrePrefixes.frameGt.get(MaterialsOld.Neutronium), OrePrefixes.stick.get(MaterialsOld.Neutronium), OrePrefixes.ingot.get(MaterialsOld.Neutronium), OrePrefixes.gearGt.get(MaterialsOld.Neutronium), OrePrefixes.gearGt.get(MaterialsOld.Neutronium)),
    }, STEAM = new Tier[]{
            new Tier(SubTag.ENERGY_STEAM, 1, 32, 1, 1, 1, MaterialsOld.Bronze, OrePrefixes.frameGt.get(MaterialsOld.Bronze), OrePrefixes.pipeMedium.get(MaterialsOld.Bronze), OrePrefixes.pipeHuge.get(MaterialsOld.Bronze), OrePrefixes.pipeMedium.get(MaterialsOld.Bronze), OrePrefixes.pipeLarge.get(MaterialsOld.Bronze)),
            new Tier(SubTag.ENERGY_STEAM, 2, 128, 1, 1, 1, MaterialsOld.Steel, OrePrefixes.frameGt.get(MaterialsOld.Steel), OrePrefixes.pipeMedium.get(MaterialsOld.Steel), OrePrefixes.pipeHuge.get(MaterialsOld.Steel), OrePrefixes.pipeMedium.get(MaterialsOld.Steel), OrePrefixes.pipeLarge.get(MaterialsOld.Steel)),
            new Tier(SubTag.ENERGY_STEAM, 3, 512, 1, 1, 1, MaterialsOld.Titanium, OrePrefixes.frameGt.get(MaterialsOld.Titanium), OrePrefixes.pipeMedium.get(MaterialsOld.Titanium), OrePrefixes.pipeHuge.get(MaterialsOld.Titanium), OrePrefixes.pipeMedium.get(MaterialsOld.Titanium), OrePrefixes.pipeLarge.get(MaterialsOld.Titanium)),
            new Tier(SubTag.ENERGY_STEAM, 4, 2048, 1, 1, 1, MaterialsOld.TungstenSteel, OrePrefixes.frameGt.get(MaterialsOld.TungstenSteel), OrePrefixes.pipeMedium.get(MaterialsOld.TungstenSteel), OrePrefixes.pipeHuge.get(MaterialsOld.TungstenSteel), OrePrefixes.pipeMedium.get(MaterialsOld.TungstenSteel), OrePrefixes.pipeLarge.get(MaterialsOld.TungstenSteel)),
            new Tier(SubTag.ENERGY_STEAM, 5, 8192, 1, 1, 1, MaterialsOld.Iridium, OrePrefixes.frameGt.get(MaterialsOld.Iridium), OrePrefixes.pipeMedium.get(MaterialsOld.Iridium), OrePrefixes.pipeHuge.get(MaterialsOld.Iridium), OrePrefixes.pipeMedium.get(MaterialsOld.Iridium), OrePrefixes.pipeLarge.get(MaterialsOld.Iridium)),
            new Tier(SubTag.ENERGY_STEAM, 9, Integer.MAX_VALUE, 1, 1, 1, MaterialsOld.Neutronium, OrePrefixes.frameGt.get(MaterialsOld.Neutronium), OrePrefixes.pipeMedium.get(MaterialsOld.Neutronium), OrePrefixes.pipeHuge.get(MaterialsOld.Neutronium), OrePrefixes.pipeMedium.get(MaterialsOld.Neutronium), OrePrefixes.pipeLarge.get(MaterialsOld.Neutronium)),
    };
    /**
     * Used for Crafting Recipes
     */
    public final Object mHullObject, mConductingObject, mLargerConductingObject, mManagingObject, mBetterManagingObject;
    private final SubTag mType;
    private final byte mRank;
    private final long mPrimaryValue, mSecondaryValue, mSpeedMultiplier, mEnergyCostMultiplier;
    private final MaterialsOld mMaterial;

    public Tier(SubTag aType, int aRank, long aPrimaryValue, long aSecondaryValue, long aSpeedMultiplier, long aEnergyCostMultiplier, MaterialsOld aMaterial, Object aHullObject, Object aConductingObject, Object aLargerConductingObject, Object aManagingObject, Object aBetterManagingObject) {
        mType = aType;
        mRank = (byte) aRank;
        mPrimaryValue = aPrimaryValue;
        mSecondaryValue = aSecondaryValue;
        mSpeedMultiplier = aSpeedMultiplier;
        mEnergyCostMultiplier = Math.max(mSpeedMultiplier, aEnergyCostMultiplier);
        mMaterial = aMaterial;

        mHullObject = aHullObject;
        mConductingObject = aConductingObject;
        mManagingObject = aManagingObject;
        mBetterManagingObject = aBetterManagingObject;
        mLargerConductingObject = aLargerConductingObject;
    }

    public byte getRank() {
        return mRank;
    }

    public SubTag getEnergyType() {
        return mType;
    }

    public long getEnergyPrimary() {
        return mPrimaryValue;
    }

    public long getEnergySecondary() {
        return mSecondaryValue;
    }

    public long getSpeedMultiplier() {
        return mSpeedMultiplier;
    }

    public long getEnergyCostMultiplier() {
        return mEnergyCostMultiplier;
    }

    public MaterialsOld getMaterial() {
        return mMaterial;
    }
}
