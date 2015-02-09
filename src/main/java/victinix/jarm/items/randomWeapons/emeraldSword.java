package victinix.jarm.items.randomWeapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemSword;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class emeraldSword extends ItemSword {

    private String name = "emeraldSword";

    public emeraldSword(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.emeraldSwordRegister)
            GameRegistry.registerItem(this, name);
    }
}
