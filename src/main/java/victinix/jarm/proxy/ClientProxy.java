package victinix.jarm.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import victinix.jarm.items.ModItems;
import victinix.jarm.items.weapons.ItemRandomGun;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {

        super.preInit(event);
        ModItems.initModel();
    }
}
