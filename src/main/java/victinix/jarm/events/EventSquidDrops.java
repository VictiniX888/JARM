package victinix.jarm.events;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import victinix.jarm.items.ModItems;

public class EventSquidDrops {

    @SubscribeEvent
    public void eventSquidDrops(LivingDropsEvent event) {

        if(event.entity instanceof EntitySquid) {
            ItemStack drops = new ItemStack(ModItems.cool_squid, 1);
            event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, drops));
        }
    }
}
