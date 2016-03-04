package victinix.jarm.tab;

import net.minecraft.item.ItemStack;
import victinix.jarm.items.ModItems;

public class CreativeTabRegistry {

    public static CreativeTabBase creativeTabJARM = new CreativeTabBase("creativeTabJARM");

    public static void init() {

        creativeTabJARM.setItemStack(new ItemStack(ModItems.random_gun));
    }
}
