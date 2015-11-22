package victinix.jarm.events;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import victinix.jarm.items.ModItems;
import victinix.jarm.libs.Configurations;

public class EventCrafting {

    @SubscribeEvent
    public void craftingEvent(PlayerEvent.ItemCraftedEvent event) {

        for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
            ItemStack itemStackInSlot = event.craftMatrix.getStackInSlot(i);
            if(itemStackInSlot.getItem() == Items.diamond_sword) {
                ItemStack damagedItem = new ItemStack(Items.diamond_sword, 1, (itemStackInSlot.getItemDamage() + Configurations.cookedSquidCraftingAmount));
                event.craftMatrix.setInventorySlotContents(i, damagedItem);
            }
            else {
                return;
            }
        }
    }
}
