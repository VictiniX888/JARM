package victinix.jarm.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.potion.PotionEffect;
import victinix.jarm.items.ModItems;

public class EventBurgerTick {

    @SubscribeEvent
    public void burgerTickEvent(TickEvent.PlayerTickEvent event) {

        if(event.player.getHeldItem() != null && event.player.getHeldItem().getItem() == ModItems.superBurger) {

            event.player.addPotionEffect(new PotionEffect(23, 20));
        }
    }
}
