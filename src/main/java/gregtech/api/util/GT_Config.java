package gregtech.api.util;

import static gregtech.api.enums.GT_Values.E;
import gregtech.api.GregTech_API;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.text.DecimalFormat;

public class GT_Config implements Runnable {
    public static boolean troll = false;

    public final Configuration mConfig;

    public GT_Config(Configuration aConfig) {
        mConfig = aConfig;
        mConfig.load();
        mConfig.save();
        GregTech_API.sAfterGTPreload.add(this); // in case of crash on startup
        GregTech_API.sAfterGTLoad.add(this); // in case of crash on startup
        GregTech_API.sAfterGTPostload.add(this);
    }

    public void setCathegoryComment(String aCategry, String aComment) {
        mConfig.setCategoryComment(aCategry, aComment);
    }

    public static String getStackConfigName(ItemStack aStack) {
        if (GT_Utility.isStackInvalid(aStack)) return E;
        Object rName = GT_OreDictUnificator.getAssociation(aStack);
        if (rName != null) return rName.toString();
        try {
            if (GT_Utility.isStringValid(rName = aStack.getUnlocalizedName())) return rName.toString();
        } catch (Throwable e) {/*Do nothing*/}
        String sName = aStack.getItem().toString();
        String[] tmp = sName.split("@");
        if (tmp.length > 0) sName = tmp[0];
        return sName + "." + aStack.getItemDamage();
    }

    public boolean get(Object aCategory, ItemStack aStack, boolean aDefault) {
        String aName = getStackConfigName(aStack);
        return get(aCategory, aName, aDefault);
    }

    public boolean get(Object aCategory, String aName, boolean aDefault) {
        return get(aCategory, aName, aDefault, "Boolean");
    }

    public boolean get(Object aCategory, String aName, boolean aDefault, String aComment) {
        if (GT_Utility.isStringInvalid(aName)) return aDefault;
        Property tProperty = mConfig.get(aCategory.toString(), aName, aDefault, String.format("%s default: %b", aComment, aDefault));
        boolean rResult = tProperty.getBoolean(aDefault);
        if (!tProperty.wasRead() && GregTech_API.sPostloadFinished) mConfig.save();
        return rResult;
    }


    public int get(Object aCategory, ItemStack aStack, int aDefault) {
        return get(aCategory, getStackConfigName(aStack), aDefault);
    }

    public int get(Object aCategory, String aName, int aDefault) {
        return get(aCategory, aName, aDefault, "Integer");
    }

    public int get(Object aCategory, String aName, int aDefault, String aComment) {
        if (GT_Utility.isStringInvalid(aName)) return aDefault;
        Property tProperty = mConfig.get(aCategory.toString(), aName, aDefault, String.format("%s default: %d", aComment, aDefault));
        int rResult = tProperty.getInt(aDefault);
        if (!tProperty.wasRead() && GregTech_API.sPostloadFinished) mConfig.save();
        return rResult;
    }

    public double get(Object aCategory, ItemStack aStack, double aDefault) {
        return get(aCategory, getStackConfigName(aStack), aDefault);
    }

    public double get(Object aCategory, String aName, double aDefault) {
        return get(aCategory, aName, aDefault, "Double");
    }

    public double get(Object aCategory, String aName, double aDefault, String aComment) {
        if (GT_Utility.isStringInvalid(aName)) return aDefault;
        Property tProperty = mConfig.get(aCategory.toString(), aName, aDefault, String.format("%s default: %s", aComment, new DecimalFormat("#.##").format(aDefault)));
        double rResult = tProperty.getDouble(aDefault);
        if (!tProperty.wasRead() && GregTech_API.sPostloadFinished) mConfig.save();
        return rResult;
    }

    @Override
    public void run() {
        mConfig.save();
    }
}