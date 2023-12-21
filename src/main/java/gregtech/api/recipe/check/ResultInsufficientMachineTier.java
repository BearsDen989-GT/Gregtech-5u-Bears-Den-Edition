package gregtech.api.recipe.check;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.StatCollector;

import gregtech.api.util.GT_Utility;

public class ResultInsufficientMachineTier implements CheckRecipeResult {

    private int required;

    ResultInsufficientMachineTier(int required) {
        this.required = required;
    }

    @Override
    public String getID() {
        return "insufficient_machine_tier";
    }

    @Override
    public boolean wasSuccessful() {
        return false;
    }

    @Override
    public String getDisplayString() {
        return StatCollector
            .translateToLocalFormatted("GT5U.gui.text.insufficient_machine_tier", GT_Utility.formatNumbers(required));
    }

    @Override
    public CheckRecipeResult newInstance() {
        return new ResultInsufficientMachineTier(0);
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeVarIntToBuffer(required);
    }

    @Override
    public void decode(PacketBuffer buffer) {
        required = buffer.readVarIntFromBuffer();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultInsufficientMachineTier that = (ResultInsufficientMachineTier) o;
        return required == that.required;
    }
}
