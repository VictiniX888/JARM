package victinix.jarm.events;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import victinix.jarm.libs.Configurations;

public class EventRegistry {

    public static void postInit() {

        if(Configurations.coolSquidRegister) {
            MinecraftForge.EVENT_BUS.register(new EventSquidDrops());
        }
        if(Configurations.crushingWandRegister) {
            MinecraftForge.EVENT_BUS.register(new EventCrushingDrops());
            MinecraftForge.EVENT_BUS.register(new EventWandMalfuntion());
        }
        if(Configurations.superBurgerRegister) {
            FMLCommonHandler.instance().bus().register(new EventBurgerTick());
        }
    }
}
