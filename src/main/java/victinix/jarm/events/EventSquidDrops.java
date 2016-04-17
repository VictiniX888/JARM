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

        if(event.getEntity() instanceof EntitySquid) {
            ItemStack drops = new ItemStack(ModItems.cool_squid, 1);
            event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, drops));
        }
    }
}
