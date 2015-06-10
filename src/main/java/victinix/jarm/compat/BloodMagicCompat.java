package victinix.jarm.compat;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class BloodMagicCompat {

    public static void postInit() {

        //crafting
        if(Loader.isModLoaded("AWWayofTime") && Loader.isModLoaded("arcanearteries")) {
            FMLLog.info("test");
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(GameRegistry.findItem("AWWayofTime", "blankSlate"), 1, 0), new Object[]{
                    new ItemStack(GameRegistry.findItem("arcanearteries", "arcanearteries manaSlate"))
            }));
        }
    }
}
