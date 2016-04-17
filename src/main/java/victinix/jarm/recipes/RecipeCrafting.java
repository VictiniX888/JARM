package victinix.jarm.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.blocks.ModBlocks;
import victinix.jarm.items.ModItems;
import victinix.jarm.lib.Configurations;

public class RecipeCrafting {

    public static void init() {

        if(Configurations.compressorRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.compressor, 1, 0), new Object[] {
                    "ABA",
                    "ACA",
                    "DED",
                    'A', "ingotIron",
                    'B', new ItemStack(Blocks.obsidian),
                    'C', "dustRedstone",
                    'D', "stone",
                    'E', new ItemStack(Items.lava_bucket)
            }));
        }

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

        if(Configurations.crushingWandRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.crushing_wand, 1, 0), new Object[]{
                    "  A",
                    " A ",
                    "AA ",
                    'A', "stickWood",
            }));
        }

        if(Configurations.dittoRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ditto, 1, 0), new Object[]{
                    "ABA",
                    "BCB",
                    "ABA",
                    'A', new ItemStack(Items.blaze_powder),
                    'B', new ItemStack(Items.ghast_tear),
                    'C', new ItemStack(Items.nether_star)
            }));
        }

        if(Configurations.superBurgerRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.super_burger, 1, 0), new Object[]{
                    "AAA",
                    "BBB",
                    "AAA",
                    'A', new ItemStack(Items.bread),
                    'B', new ItemStack(Blocks.tallgrass, 1, 1)
            }));
        }

        if(Configurations.xProducerRegistry) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.xproducer, 1, 0), new Object[]{
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', "ingotIron",
                    'B', new ItemStack(Blocks.stone_button)
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
