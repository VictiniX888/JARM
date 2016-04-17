package victinix.jarm.recipes;

import net.minecraft.item.ItemStack;

import java.util.HashMap;

public class RecipeCompressorBase {

    public static HashMap<ItemStack, ItemStack> map = new HashMap<ItemStack, ItemStack>();

    public void addRecipe(ItemStack input, ItemStack output) {

        map.put(input, output);
    }
}
