package victinix.jarm.libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.items.modItems;

/**
 * Created by VictiniX888 on 01-Feb-2015.
 * It's distributed as part of the JARM Mod.
 * Get the Source Code in github:
 * https://github.com/VictiniX888/JARM
 *
 * JARM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike
 * 4.0 International Public License
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

        if(Configurations.hotdogRegister)
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(modItems.hotdog, 2, 0), new Object[]{
                    new ItemStack(Items.bread),
                    new ItemStack(Items.cooked_chicken)
            }));
    }
}
