package victinix.jarm.events;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import victinix.jarm.libs.Configurations;

public class EventRegistry {

    public static void postInit() {

        MinecraftForge.EVENT_BUS.register(new EventSquidDrops());
        if(Configurations.crushingWandRegister) {
            MinecraftForge.EVENT_BUS.register(new EventCrushingDrops());
            MinecraftForge.EVENT_BUS.register(new EventWandMalfuntion());
        }
    }
}
