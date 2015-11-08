package victinix.jarm.events;

import akka.actor.dsl.Creators;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import victinix.jarm.items.ModItems;
import victinix.jarm.libs.Configurations;

import java.util.Arrays;

public class EventWandMalfuntion {

    @SubscribeEvent
    public void malfunctionEvent(PlayerInteractEvent event) {

        Block[] canCrush = ModItems.canCrush.toArray(new Block[ModItems.canCrush.size()]);

        if(event.action != null && event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK) {
            if(event.entityPlayer.getHeldItem().getItem() == ModItems.crushingWand) {
                for (int i = 0; i < ModItems.canCrush.size(); i++) {
                    if(!Arrays.asList(canCrush).contains(event.world.getBlock(event.x, event.y, event.z))) {
                        event.world.setRainStrength(1f);
                        event.world.addWeatherEffect(new EntityLightningBolt(event.world, (int)event.entityPlayer.posX, (int)event.entityPlayer.posY, (int)event.entityPlayer.posZ));
                    }
                }
            }
        }
    }
}
