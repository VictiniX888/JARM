package victinix.jarm.items.randomWeapons;

import net.minecraft.item.ItemSword;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class emeraldSword extends ItemSword {

    private String name = "emeraldSword";

    public emeraldSword(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
    }
}
