package victinix.jarm.items.materials;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.lib.Tabs;

import java.util.List;

public class ItemDustBase extends Item {

    private String name = "dust";
    private IIcon[] icons = new IIcon[7];

    public ItemDustBase() {

        super();
        setUnlocalizedName(Data.MODID + ":" + name);
        setHasSubtypes(true);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.dustRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {

        for (int i = 0; i < icons.length; i++) {
            icons[i] = iconRegister.registerIcon(Data.MODID + ":" + name + i);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {

        if(meta > 6) {
            meta = 0;
        }

        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {

        for (int i = 0; i < icons.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {

        return getUnlocalizedName() + itemStack.getItemDamage();
    }
}
