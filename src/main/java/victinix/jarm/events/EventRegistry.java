package victinix.jarm.events;

import net.minecraftforge.common.MinecraftForge;
import victinix.jarm.lib.Configurations;

public class EventRegistry {

    public static void init() {

        if(Configurations.coolSquidRegistry) {
            MinecraftForge.EVENT_BUS.register(new EventSquidDrops());
        }
        if(Configurations.superBurgerRegistry) {
            MinecraftForge.EVENT_BUS.register(new EventBurgerTick());
        }
    }
}
