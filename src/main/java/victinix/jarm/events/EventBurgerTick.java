package victinix.jarm.events;

import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import victinix.jarm.items.ModItems;

public class EventBurgerTick {

    @SubscribeEvent
    public void eventBurgerTick(TickEvent.PlayerTickEvent event) {

        if(event.player.getHeldItem() != null) {
            if(event.player.getHeldItem().getItem() == ModItems.super_burger) {
                event.player.addPotionEffect(new PotionEffect(23, 1));
            }
        }
    }
}
