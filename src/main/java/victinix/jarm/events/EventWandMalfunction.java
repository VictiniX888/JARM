package victinix.jarm.events;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import victinix.jarm.items.ModItems;
import victinix.jarm.lib.Configurations;

public class EventWandMalfunction {

    @SubscribeEvent
    public void eventWandMalfunction(PlayerInteractEvent.LeftClickBlock event) {

        boolean malfunction = true;

        if(event.getEntityPlayer().getHeldItem(event.getHand()) != null && event.getEntityPlayer().getHeldItem(event.getHand()).getItem() == ModItems.crushing_wand) {
            for (int i = 0; i < Configurations.canCrush.length; i++) {
                if(event.getWorld().getBlockState(event.getPos()).getBlock().getLocalizedName().equals(Configurations.canCrush[i])) {
                    malfunction = false;
                }
            }
            if(malfunction) {
                event.getWorld().setRainStrength(1f);
                event.getWorld().addWeatherEffect(new EntityLightningBolt(event.getWorld(), (int) event.getEntityPlayer().posX, (int) event.getEntityPlayer().posY, (int) event.getEntityPlayer().posZ, true));
                event.setCanceled(true);
            }
        }
    }
}
