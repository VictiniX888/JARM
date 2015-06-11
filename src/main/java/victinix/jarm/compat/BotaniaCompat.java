package victinix.jarm.compat;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;

public class BotaniaCompat {

    @Optional.Method(modid = "Botania")
    public static void postInit() {

        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(GameRegistry.findItem("AWWayofTime", "reinforcedSlate")), new ItemStack(GameRegistry.findItem("AWWayofTime", "blankSlate")), 2000);
        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(GameRegistry.findItem("AWWayofTime", "imbuedSlate")), new ItemStack(GameRegistry.findItem("AWWayofTime", "reinforcedSlate")), 5000);
        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(GameRegistry.findItem("AWWayofTime", "demonicSlate")), new ItemStack(GameRegistry.findItem("AWWayofTime", "imbuedSlate")), 15000);
        BotaniaAPI.registerManaInfusionRecipe(new ItemStack(GameRegistry.findItem("AWWayofTime", "bloodMagicBaseItems"), 1, 27), new ItemStack(GameRegistry.findItem("AWWayofTime", "demonicSlate")), 30000);
    }
}
