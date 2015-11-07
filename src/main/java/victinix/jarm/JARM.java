package victinix.jarm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.*;
import victinix.jarm.blocks.ModBlocks;
import victinix.jarm.events.EventRegistry;
import victinix.jarm.gui.GuiHandler;
import victinix.jarm.items.ModItems;
import victinix.jarm.libs.*;
import victinix.jarm.libs.OreDictionary;

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
        ModBlocks.init();
        ModBlocks.registerTileEntities();
        OreDictionary.oreDictRegistry();
        Recipes.registerCraftingRecipes();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        new GuiHandler();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Tabs.postInit();
        EventRegistry.postInit();
    }

    @Mod.Instance(Data.MODID)
    public static JARM instance;
}
