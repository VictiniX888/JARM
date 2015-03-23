package victinix.jarm.libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import victinix.jarm.items.ModItems;

public class Recipes {

    public static void registerCraftingRecipes() {

        if(Configurations.cookedSquidRegister) {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.cookedSquid, 8, 0), new Object[]{
                    "A",
                    "B",
                    'A', new ItemStack(ModItems.emeraldSword, 1, OreDictionary.WILDCARD_VALUE),
                    'B', new ItemStack(ModItems.coolSquid)
            }));
        }

        if(Configurations.hotdogRegister) {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.hotdog, Configurations.hotdogCraftingAmount, 0), new Object[]{
                    new ItemStack(Items.bread),
                    new ItemStack(Items.cooked_chicken)
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
