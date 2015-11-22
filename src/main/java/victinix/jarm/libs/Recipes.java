package victinix.jarm.libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.blocks.ModBlocks;
import victinix.jarm.items.ModItems;

public class Recipes {

    public static void registerCraftingRecipes() {

        if(Configurations.compressorRegister) {
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

        if(Configurations.cookedSquidRegister) {
            if(Configurations.emeraldSwordRegister) {
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.cookedSquid, Configurations.cookedSquidCraftingAmount, 0), new Object[]{
                        "A",
                        "B",
                        'A', new ItemStack(ModItems.emeraldSword, 1, OreDictionary.WILDCARD_VALUE),
                        'B', new ItemStack(ModItems.coolSquid)
                }));
            }
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.cookedSquid, Configurations.cookedSquidCraftingAmount, 0), new Object[]{
                    "AC",
                    "B ",
                    'A', new ItemStack(Items.diamond_sword, 1, OreDictionary.WILDCARD_VALUE),
                    'B', new ItemStack(ModItems.coolSquid),
                    'C', new ItemStack(Items.blaze_powder)
            }));
        }

        if(Configurations.hotdogRegister) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.hotdog, Configurations.hotdogCraftingAmount, 0), new Object[]{
                    new ItemStack(Items.bread),
                    new ItemStack(Items.cooked_chicken)
            }));
        }

        if(Configurations.crushingWandRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.crushingWand, 1, 0), new Object[]{
                    "  A",
                    " A ",
                    "AA ",
                    'A', "stickWood",
            }));
        }

        if(Configurations.dittoRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ditto, 1, 0), new Object[]{
                    "ABA",
                    "BCB",
                    "ABA",
                    'A', new ItemStack(Items.blaze_powder),
                    'B', new ItemStack(Items.ghast_tear),
                    'C', new ItemStack(Items.nether_star)
            }));
        }

        if(Configurations.xProducerRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.xProducer, 1, 0), new Object[]{
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', "ingotIron",
                    'B', new ItemStack(Blocks.stone_button)
            }));
        }

        if(Configurations.diamondHandbagRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamondHandbag, 1, 0), new Object[]{
                    "AAA",
                    "A A",
                    "BBB",
                    'A', "gemDiamond",
                    'B', "blockDiamond"
            }));
        }

        if(Configurations.emeraldSwordRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.emeraldSword, 1, 0), new Object[]{
                    "A",
                    "A",
                    "B",
                    'A', "gemEmerald",
                    'B', "stickWood"
            }));
        }

        if(Configurations.randomGunRegister) {
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
