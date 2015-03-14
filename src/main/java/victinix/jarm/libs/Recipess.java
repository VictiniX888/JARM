package victinix.jarm.libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.items.ModItems;

public class Recipess {

    public static void registerCraftingRecipes() {

        if(Configurationss.hotdogRegister) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.hotdog, Configurationss.hotdogCraftingAmount, 0), new Object[]{
                    new ItemStack(Items.bread),
                    new ItemStack(Items.cooked_chicken)
            }));
        }

        if(Configurationss.diamondHandbagRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamondHandbag, 1, 0), new Object[]{
                    "AAA",
                    "A A",
                    "BBB",
                    'A', "gemDiamond",
                    'B', "blockDiamond"
            }));
        }

        if(Configurationss.emeraldSwordRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.emeraldSword, 1, 0), new Object[]{
                    "A",
                    "A",
                    "B",
                    'A', "gemEmerald",
                    'B', "stickWood"
            }));
        }

        if(Configurationss.randomGunRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.randomGun, 1, 0), new Object[]{
                    "AAA",
                    " BA",
                    "  A",
                    'A', "ingotIron",
                    'B', new ItemStack(Blocks.stone_button)
            }));
        }
    }
}
