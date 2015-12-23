package victinix.jarm.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import victinix.jarm.JARM;

public class EventPotionFlying {

    @SubscribeEvent
    public void flyingEvent(TickEvent.PlayerTickEvent event) {

        if(event.player.isPotionActive(JARM.flyingPotion)) {

            if(event.player.getActivePotionEffect(JARM.flyingPotion).getDuration() > 0) {
                event.player.capabilities.allowFlying = true;
            }
            else {
                event.player.removePotionEffect(JARM.flyingPotion.id);
            }
        }
        else if(!event.player.capabilities.isCreativeMode) {
            event.player.capabilities.allowFlying = false;
            event.player.capabilities.isFlying = false;
        }
    }
}
