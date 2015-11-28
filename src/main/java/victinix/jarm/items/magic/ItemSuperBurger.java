package victinix.jarm.items.magic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class ItemSuperBurger extends Item {

    private String name = "superBurger";

    public ItemSuperBurger() {

        super();
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setMaxStackSize(1);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.superBurgerRegister) {
            GameRegistry.registerItem(this, name);
        }
    }
}
