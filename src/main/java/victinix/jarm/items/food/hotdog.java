package victinix.jarm.items.food;

import net.minecraft.item.ItemFood;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class hotdog extends ItemFood {

    private String name = "hotdog";

    public hotdog(int heal, float saturation, boolean wolfMeat) {

        super(heal, saturation, wolfMeat);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
    }
}
