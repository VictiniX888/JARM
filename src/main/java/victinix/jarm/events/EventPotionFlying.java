package victinix.jarm.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import victinix.jarm.JARM;

public class EventPotionFlying {

    @SubscribeEvent
    public void flyingEvent(LivingEvent.LivingUpdateEvent event) {

        if(event.entityLiving.isPotionActive(JARM.flyingPotion)) {

            ((EntityPlayer)event.entityLiving).capabilities.allowFlying = true;
        }

        if(event.entityLiving instanceof EntityPlayer && event.entityLiving.isPotionActive(JARM.flyingPotion)) {
            if(event.entityLiving.getActivePotionEffect(JARM.flyingPotion).getDuration() == 100) {
                event.entityLiving.removePotionEffect(JARM.flyingPotion.id);
                ((EntityPlayer)event.entityLiving).capabilities.allowFlying = false;
                ((EntityPlayer)event.entityLiving).capabilities.isFlying = false;
                return;
            }
        }
    }
}
