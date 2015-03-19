package victinix.jarm.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import victinix.jarm.items.ModItems;
import victinix.jarm.libs.Configurations;

public class SquidEventHandler {

    @SubscribeEvent
    public void squidEvent(LivingDropsEvent event) {

        if(event.entity instanceof EntitySquid) {
            ItemStack itemStack = new ItemStack(ModItems.coolSquid, 1);
            event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, itemStack));
        }
    }
}
