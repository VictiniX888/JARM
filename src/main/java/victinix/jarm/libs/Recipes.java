package victinix.jarm.libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import victinix.jarm.items.modItems;

/**
 * Created by VictiniX888 on 01-Feb-2015.
 */

public class Recipes {

    public static void registerCraftingRecipes() {

        if(Configurations.randomGunRegister)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(modItems.randomGun, 1, 0), new Object[] {
                    "AAA",
                    " BA",
                    "  A",
                    'A', "ingotIron",
                    'B', new ItemStack(Blocks.stone_button)
            }));
    }
}
