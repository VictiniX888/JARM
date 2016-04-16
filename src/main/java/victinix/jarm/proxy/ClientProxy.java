package victinix.jarm.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import victinix.jarm.blocks.ModBlocks;
import victinix.jarm.items.ModItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {

        super.preInit(event);
        ModBlocks.initModels();
        ModItems.initModels();
    }
}
