package victinix.jarm.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.tileentities.TileEntityCompressor;

public class ContainerCompressor extends Container {

    private TileEntityCompressor compressor;
    private int timeCanCompress;
    private int ticksCompressItemSoFar;
    private int ticksPerItem;

    public ContainerCompressor(InventoryPlayer inventory, TileEntityCompressor compressor) {

        this.compressor = compressor;
        for (int i = 0; i < 8; i++) {
            addSlotToContainer(new Slot(compressor, i, 17 + i * 18, 17));
        }
        addSlotToContainer(new Slot(compressor, 8, 80, 58) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, 9 + j + i * 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for(int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {

        return compressor.isUseableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

        ItemStack stack = null;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack stackInSlot = slot.getStack();
            stack = stackInSlot.copy();

            if (index < compressor.getSizeInventory()) {
                if (!mergeItemStack(stackInSlot, compressor.getSizeInventory(), inventorySlots.size(), false)) {
                    return null;
                }
            }
            else if (!mergeItemStack(stackInSlot, compressor.firstSlot, compressor.lastSlot, false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return stack;
    }

    @Override
    public void detectAndSendChanges() {

        super.detectAndSendChanges();

        for(int i = 0; i < crafters.size(); i++) {
            ICrafting iCrafting = crafters.get(i);
            if(timeCanCompress != compressor.timeCanCompress) {
                iCrafting.sendProgressBarUpdate(this, 0, compressor.timeCanCompress);
            }
            if(ticksCompressItemSoFar != compressor.ticksCompressItemSoFar) {
                iCrafting.sendProgressBarUpdate(this, 1, compressor.ticksCompressItemSoFar);
            }
            if(ticksPerItem != compressor.ticksPerItem) {
                iCrafting.sendProgressBarUpdate(this, 2, compressor.ticksPerItem);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {

        if(id == 0) {
            compressor.timeCanCompress = data;
        }
        if(id == 1) {
            compressor.ticksCompressItemSoFar = data;
        }
        if(id == 2) {
            compressor.ticksPerItem = data;
        }
    }
}
