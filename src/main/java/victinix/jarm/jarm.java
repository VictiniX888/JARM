package victinix.jarm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import victinix.jarm.items.modItems;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

/**
 * Created by VictiniX888 on 30-Jan-2015.
 */

@Mod(modid = Data.MODID, name = Data.MODNAME, version = Data.VERSION)

public class jarm {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        modItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Tabs.postInit();
    }
}
