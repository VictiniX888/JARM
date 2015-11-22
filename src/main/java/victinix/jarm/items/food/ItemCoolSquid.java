package victinix.jarm.items.food;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class ItemCoolSquid extends ItemFood {

    private String name = "coolSquid";

    public ItemCoolSquid(int heal, float saturation, boolean wolfMeat) {

        super(heal, saturation, wolfMeat);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.coolSquidRegister)
            GameRegistry.registerItem(this, name);
    }
}
