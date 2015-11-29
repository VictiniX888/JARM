package victinix.jarm.lib;

import net.minecraft.item.ItemStack;
import victinix.jarm.items.ModItems;

public class OreDictionary {

    public static void oreDictRegistry() {

        net.minecraftforge.oredict.OreDictionary.registerOre("dustIron", new ItemStack(ModItems.dust, 1, 0));
        net.minecraftforge.oredict.OreDictionary.registerOre("dustGold", new ItemStack(ModItems.dust, 1, 1));
        net.minecraftforge.oredict.OreDictionary.registerOre("dustCoal", new ItemStack(ModItems.dust, 1, 2));
        net.minecraftforge.oredict.OreDictionary.registerOre("dustDiamond", new ItemStack(ModItems.dust, 1, 3));
        net.minecraftforge.oredict.OreDictionary.registerOre("dustEmerald", new ItemStack(ModItems.dust, 1, 4));
        net.minecraftforge.oredict.OreDictionary.registerOre("dustLapis", new ItemStack(ModItems.dust, 1, 5));
    }
}
