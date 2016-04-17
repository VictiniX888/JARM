package victinix.jarm.proxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import victinix.jarm.blocks.ModBlocks;
import victinix.jarm.events.EventRegistry;
import victinix.jarm.gui.GuiHandler;
import victinix.jarm.items.ModItems;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Recipes;
import victinix.jarm.recipes.RecipeCompressor;
import victinix.jarm.tab.CreativeTabRegistry;

import java.io.File;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

        File configFile = event.getSuggestedConfigurationFile();
        Configurations.configExists = configFile.exists();
        Configurations.config = new Configuration(configFile);
        Configurations.config.load();
        Configurations.refreshConfig();

        ModBlocks.initBlocks();
        ModItems.initToolMaterials();
        ModItems.initItems();
    }

    public void init(FMLInitializationEvent event) {

        Recipes.init();
        RecipeCompressor.init();
        new GuiHandler();
    }

    public void postInit(FMLPostInitializationEvent event) {

        CreativeTabRegistry.init();
        EventRegistry.init();
    }
}
