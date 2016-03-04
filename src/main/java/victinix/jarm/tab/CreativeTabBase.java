package victinix.jarm.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabBase extends CreativeTabs {

    private ItemStack itemStack;

    @Override
    public Item getTabIconItem() {
        return itemStack.getItem();
    }

    public CreativeTabBase(String label) {

        super(label);
    }

    public void setItemStack(ItemStack stack) {

        itemStack = stack;
    }
}
