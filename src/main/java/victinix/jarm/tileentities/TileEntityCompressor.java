package victinix.jarm.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import victinix.jarm.recipes.RecipeCompressorBase;

public class TileEntityCompressor extends TileEntity implements ISidedInventory, ITickable {

    ItemStack[] inventorySlots = new ItemStack[9];
    public int firstSlot = 0;
    public int lastSlot = 8;
    private String name = "compressor";
    public int timeCanCompress;
    public int ticksCompressItemSoFar;
    public int ticksPerItem;
    private ItemStack output;

    @Override
    public int[] getSlotsForFace(EnumFacing side) {

        if(side == EnumFacing.DOWN) {
            return new int[] { 8 };
        }
        else {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        }
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {

        return isItemValidForSlot(index, itemStackIn);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {

        return index == 8 && direction == EnumFacing.DOWN;
    }

    @Override
    public int getSizeInventory() {

        return inventorySlots.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {

        return inventorySlots[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {

        if(inventorySlots[index] != null) {
            if(inventorySlots[index].stackSize <= count) {
                ItemStack itemStack = inventorySlots[index];
                inventorySlots[index] = null;
                return itemStack;
            }
            else {
                ItemStack itemStack = inventorySlots[index].splitStack(count);
                if(inventorySlots[index].stackSize == 0) {
                    inventorySlots[index] = null;
                }
                return itemStack;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {

        if(inventorySlots[index] != null) {
            ItemStack itemStack = inventorySlots[index];
            inventorySlots[index] = null;
            return itemStack;
        }
        else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {

        boolean isSameItemStackAlreadyInSlot = stack != null && ItemStack.areItemStackTagsEqual(stack, inventorySlots[index]);
        inventorySlots[index] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }

        if(index == 0 && !isSameItemStackAlreadyInSlot) {
            ticksPerItem = compressingTime(stack);
            ticksCompressItemSoFar = 0;
            markDirty();
        }
    }

    @Override
    public int getInventoryStackLimit() {

        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {

        return worldObj.getTileEntity(pos) == this && player.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {

        return index != 8;
    }

    @Override
    public int getField(int id) {

        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {

        return 0;
    }

    @Override
    public void clear() {

        for (int i = 0; i < getSizeInventory(); i++) {
            setInventorySlotContents(i, null);
        }
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public boolean hasCustomName() {

        return getName() != null;
    }

    @Override
    public ITextComponent getDisplayName() {

        return new TextComponentString(getName());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {

        super.readFromNBT(compound);
        NBTTagList list = compound.getTagList("Compressor", 10);

        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound item = list.getCompoundTagAt(i);
            byte slot = item.getByte("SlotCompressor");
            if(slot >= 0 && slot < getSizeInventory()) {
                inventorySlots[slot] = ItemStack.loadItemStackFromNBT(item);
            }
        }

        timeCanCompress = compound.getInteger("timeCanCompress");
        ticksCompressItemSoFar = compound.getInteger("ticksCompressItemSoFar");
        ticksPerItem = compound.getInteger("ticksPerItem");
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {

        super.writeToNBT(compound);
        NBTTagList list = new NBTTagList();

        for (int i = 0; i < getSizeInventory(); i++) {
            if (inventorySlots[i] != null) {
                NBTTagCompound item = new NBTTagCompound();
                item.setByte("SlotCompressor", (byte)i);
                inventorySlots[i].writeToNBT(item);
                list.appendTag(item);
            }
        }

        compound.setTag("Compressor", list);
        compound.setInteger("timeCanCompress", timeCanCompress);
        compound.setInteger("ticksCompressItemSoFar", ticksCompressItemSoFar);
        compound.setInteger("ticksPerItem", ticksPerItem);
    }

    public boolean compressingSomething() {

        return true;
    }

    public int compressingTime(ItemStack itemStack) {

        if((Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment")) {
            return 200;
        }
        else {
            return 1000;
        }
    }

    public boolean canCompress() {

        boolean isSlotEmpty = false;

        for (int i = 0; i < getSizeInventory() - 1; i++) {
            if(inventorySlots[i] == null) {
                isSlotEmpty = true;
                break;
            }
        }
        if(isSlotEmpty) {
            return false;
        }
        else {
            for (ItemStack input : RecipeCompressorBase.map.keySet()) {
                for (int i = 0; i < getSizeInventory() - 1; i++) {
                    if(inventorySlots[i].getItem() == input.getItem() && inventorySlots[i].getItemDamage() == input.getItemDamage()) {
                        output = RecipeCompressorBase.map.get(input);
                    }
                    else {
                        output = null;
                        break;
                    }
                }
                if(output != null) {
                    break;
                }
            }
            if(output != null) {
                if(inventorySlots[8] != null) {
                    int result = inventorySlots[8].stackSize + output.stackSize;
                    return inventorySlots[8].isItemEqual(output) && result <= getInventoryStackLimit();
                }
                else {
                    int result = output.stackSize;
                    return result <= getInventoryStackLimit();
                }
            }
            else {
                return false;
            }
        }
    }

    public void compressItem() {

        if(canCompress()) {
            if(inventorySlots[8] == null) {
                inventorySlots[8] = output.copy();
            }
            else if(inventorySlots[8].getItem() == output.getItem()) {
                inventorySlots[8].stackSize += output.stackSize;
            }

            for (int i = 0; i < 8; i++) {
                inventorySlots[i].stackSize--;

                if(inventorySlots[i].stackSize <= 0) {
                    inventorySlots[i] = null;
                }
            }
        }
    }

    @Override
    public void update() {

        boolean hasBeenCompressing = compressingSomething();
        boolean changedCompressingState = false;

        if(!worldObj.isRemote) {

            for (int i = 0; i < 8; i++) {
                if(inventorySlots[i] != null) {
                    if(compressingSomething() && canCompress()) {
                        ticksCompressItemSoFar++;
                        if(ticksCompressItemSoFar == ticksPerItem) {
                            ticksCompressItemSoFar = 0;
                            ticksPerItem = compressingTime(inventorySlots[1]);
                            compressItem();
                            changedCompressingState = true;
                        }
                    }
                    else {
                        ticksCompressItemSoFar = 0;
                    }
                }
            }
        }

        if(hasBeenCompressing != compressingSomething()) {
            changedCompressingState = true;
        }

        if(changedCompressingState) {
            markDirty();
        }
    }
}