package victinix.jarm.compat;

import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.items.ShapedBloodOrbRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BloodMagicCompat {

    public static void init() {

        //Crafting recipes
        GameRegistry.addRecipe(new ShapedBloodOrbRecipe(new ItemStack(GameRegistry.findItem("AWayofTime", "bloodRune")), "sss", "mom", "sss", 's', new ItemStack(Blocks.stone, 1, OreDictionary.WILDCARD_VALUE), 'm', new ItemStack(GameRegistry.findItem("arcanearteries", "manaSlate"), 1, OreDictionary.WILDCARD_VALUE), 'o', new ItemStack(GameRegistry.findItem("AWayofTime", "weakBloodOrb"), 1, OreDictionary.WILDCARD_VALUE)));

        //Altar recipes
        AltarRecipeRegistry.registerAltarRecipe(new ItemStack(GameRegistry.findItem("AWWayofTime", "reinforcedSlate")), new ItemStack(GameRegistry.findItem("arcanearteries", "manaSlate")), 2, 2000, 5, 5, false);
    }
}
