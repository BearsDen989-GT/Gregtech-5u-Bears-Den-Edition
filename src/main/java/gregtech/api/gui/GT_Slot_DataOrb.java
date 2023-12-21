package gregtech.api.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.ItemList;

public class GT_Slot_DataOrb extends Slot {

    public GT_Slot_DataOrb(IInventory inventory, int slotIndex, int xPos, int yPos) {
        super(inventory, slotIndex, xPos, yPos);
    }

    @Override
    public boolean isItemValid(ItemStack aStack) {
        return ItemList.Tool_DataOrb.isStackEqual(aStack, false, true);
    }
}
