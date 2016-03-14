package victinix.jarm.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.items.ModItems;

public class Recipes {

    public static void init() {

        if(Configurations.cookedSquidRegistry && Configurations.coolSquidRegistry) {
            if(Configurations.emeraldSwordRegistry) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.cooked_squid, 8, 0), new Object[]{
                        "A",
                        "B",
                        'A', new ItemStack(ModItems.emerald_sword, 1, OreDictionary.WILDCARD_VALUE),
                        'B', new ItemStack(ModItems.cool_squid)
                }));
            }
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.cooked_squid, 8, 0), new Object[]{
                    new ItemStack(Items.diamond_sword.setContainerItem(Items.diamond_sword)),
                    new ItemStack(ModItems.cool_squid),
                    new ItemStack(Items.blaze_powder)
            }));
        }

        if(Configurations.hotdogRegistry) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.hotdog, 2, 0), new Object[]{
                    new ItemStack(Items.bread),
                    new ItemStack(Items.cooked_chicken)
            }));
        }

        if(Configurations.diamondHandbagRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamond_handbag, 1, 0), new Object[]{
                    "AAA",
                    "A A",
                    "BBB",
                    'A', "gemDiamond",
                    'B', "blockDiamond"
            }));
        }

        if(Configurations.emeraldSwordRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.emerald_sword, 1, 0), new Object[]{
                    "A",
                    "A",
                    "B",
                    'A', "gemEmerald",
                    'B', "stickWood"
            }));
        }

        if(Configurations.randomGunRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.random_gun, 1, 0), new Object[]{
                    "AAA",
                    " BA",
                    "  A",
                    'A', "ingotIron",
                    'B', new ItemStack(Blocks.stone_button)
            }));
        }
    }
}
