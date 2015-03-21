package victinix.jarm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import victinix.jarm.items.ModItems;
import victinix.jarm.events.SquidEventHandler;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Recipes;
import victinix.jarm.libs.Tabs;

import java.io.File;

@Mod(modid = Data.MODID, name = Data.MODNAME, version = Data.VERSION, dependencies = Data.DEPENDENCIES)

public class JARM {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        File configFile = event.getSuggestedConfigurationFile();
        Configurations.configExists = configFile.exists();
        Configurations.config = new Configuration(configFile);
        Configurations.config.load();
        Configurations.refreshConfig();

        ModItems.init();
        Recipes.registerCraftingRecipes();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Tabs.postInit();
        MinecraftForge.EVENT_BUS.register(new SquidEventHandler());
    }
}
