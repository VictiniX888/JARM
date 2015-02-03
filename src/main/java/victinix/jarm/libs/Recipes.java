package victinix.jarm.libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.items.modItems;

public class Recipes {

    public static void registerCraftingRecipes() {

        if(Configurations.hotdogRegister)
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(modItems.hotdog, Configurations.hotdogCraftingAmount, 0), new Object[]{
                    new ItemStack(Items.bread),
                    new ItemStack(Items.cooked_chicken)
            }));

        if(Configurations.emeraldSwordRegister)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(modItems.emeraldSword, 1, 0), new Object[]{
                    "A",
                    "A",
                    "B",
                    'A', "gemEmerald",
                    'B', "stickWood"
            }));

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
