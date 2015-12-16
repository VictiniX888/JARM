package victinix.jarm;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.config.Configuration;
import victinix.jarm.blocks.ModBlocks;
import victinix.jarm.events.EventRegistry;
import victinix.jarm.gui.GuiHandler;
import victinix.jarm.items.ModItems;
import victinix.jarm.potion.PotionFlying;
import victinix.jarm.lib.*;
import victinix.jarm.lib.OreDictionary;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Mod(modid = Data.MODID, name = Data.MODNAME, version = Data.VERSION, dependencies = Data.DEPENDENCIES)

public class JARM {

    public static Potion flyingPotion;

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

        Potion[] potionTypes = null;

        for (Field f : Potion.class.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
                    Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes = new Potion[256];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            }
            catch (Exception e) {
                System.err.println("Severe error, please report this to the mod author:");
                System.err.println(e);
            }
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        new GuiHandler();
        flyingPotion = new PotionFlying(32, false, 0);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        Tabs.postInit();
        EventRegistry.postInit();
    }

    @Mod.Instance(Data.MODID)
    public static JARM instance;
}
