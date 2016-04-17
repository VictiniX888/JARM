package victinix.jarm.events;

import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import victinix.jarm.items.ModItems;

public class EventWandMalfunction {

    @SubscribeEvent
    public void eventWandMalfunction(PlayerInteractEvent event) {

        Block[] canCrush = ModItems.canCrush.toArray(new Block[ModItems.canCrush.size()]);
        boolean malfunction = true;

        if(event.getEntityPlayer().getHeldItem(event.getHand()) != null && event.getEntityPlayer().getHeldItem(event.getHand()).getItem() == ModItems.crushing_wand) {
            if(event.action != null && event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
                for (int i = 0; i < canCrush.length; i++) {
                    if(event.getWorld().getBlockState(event.getPos()).getBlock() == canCrush[i]) {
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
}
