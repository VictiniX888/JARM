package victinix.jarm.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import victinix.jarm.items.ModItems;

public class RecipeCompressor {

    static RecipeCompressorBase base = new RecipeCompressorBase();

    public static void init() {

        base.addRecipe(new ItemStack(ModItems.dust, 1, 0), new ItemStack(Items.iron_ingot));
        base.addRecipe(new ItemStack(ModItems.dust, 1, 1), new ItemStack(Items.gold_ingot));
        base.addRecipe(new ItemStack(ModItems.dust, 1, 2), new ItemStack(Items.coal));
        base.addRecipe(new ItemStack(ModItems.dust, 1, 3), new ItemStack(Items.diamond));
        base.addRecipe(new ItemStack(ModItems.dust, 1, 4), new ItemStack(Items.emerald));
        base.addRecipe(new ItemStack(ModItems.dust, 1, 5), new ItemStack(Items.dye, 1, 4));
    }
}
