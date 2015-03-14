package victinix.jarm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import victinix.jarm.items.ModiiItems;
import victinix.jarm.libs.Configurationss;
import victinix.jarm.libs.Dataa;
import victinix.jarm.libs.Recipess;
import victinix.jarm.libs.Tabss;

import java.io.File;

@Mod(modid = Dataa.MODID, name = Dataa.MODNAME, version = Dataa.VERSION)

public class JARMM {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        File configFile = event.getSuggestedConfigurationFile();
        Configurationss.configExists = configFile.exists();
        Configurationss.config = new Configuration(configFile);
        Configurationss.config.load();
        Configurationss.refreshConfig();

        ModiiItems.init();
        Recipess.registerCraftingRecipes();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Tabss.postInit();
    }
}
