package victinix.jarm.libs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 * It's distributed as part of the JARM Mod.
 * Get the Source Code in github:
 * https://github.com/VictiniX888/JARM
 *
 * JARM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike
 * 4.0 International Public License
 */

public class Tabs {

    private static class CustomCreativeTab extends CreativeTabs {

        private ItemStack stack;

        public CustomCreativeTab(String label) {
            super(label);
        }

        @Override
        public Item getTabIconItem() {
            return stack.getItem();
        }

        public void setTabIconItemStack(ItemStack stack) {
            this.stack = stack;
        }

        @Override
        public ItemStack getIconItemStack() {
            return stack;
        }
    }

    public static final CustomCreativeTab tabRandom = new CustomCreativeTab("tabRandom");

    public static void postInit() {

        tabRandom.setTabIconItemStack(new ItemStack(Items.ender_eye));
    }
}
