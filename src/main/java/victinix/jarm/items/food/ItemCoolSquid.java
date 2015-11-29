package victinix.jarm.items.food;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.lib.Tabs;

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
