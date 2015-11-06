package victinix.jarm.events;

import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {

    public static void postInit() {

        MinecraftForge.EVENT_BUS.register(new CrushingEventHandler());
        MinecraftForge.EVENT_BUS.register(new EventSquidDrops());
    }
}
