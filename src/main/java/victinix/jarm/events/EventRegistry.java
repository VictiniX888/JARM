package victinix.jarm.events;

import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {

    public static void postInit() {

        MinecraftForge.EVENT_BUS.register(new EventCrushingDrops());
        MinecraftForge.EVENT_BUS.register(new EventSquidDrops());
        MinecraftForge.EVENT_BUS.register(new EventWandMalfuntion());
    }
}
