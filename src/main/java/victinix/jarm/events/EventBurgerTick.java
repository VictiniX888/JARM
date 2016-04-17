package victinix.jarm.events;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import victinix.jarm.items.ModItems;

public class EventBurgerTick {

    @SubscribeEvent
    public void eventBurgerTick(TickEvent.PlayerTickEvent event) {

        if(event.player.getHeldItem(event.player.getActiveHand()) != null) {
            if(event.player.getHeldItem(event.player.getActiveHand()).getItem() == ModItems.super_burger) {
                event.player.addPotionEffect(new PotionEffect(MobEffects.saturation, 2));
            }
        }
    }
}
