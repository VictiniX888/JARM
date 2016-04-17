package victinix.jarm.items.food;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

public class ItemCoolSquid extends ItemFood {

    public ItemCoolSquid(int amount, float saturation, boolean isWolfFood) {

        super(amount, saturation, isWolfFood);
        setRegistryName(Data.MODID + ":" + "cool_squid");
        setUnlocalizedName(Data.MODID + ":" + "cool_squid");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.coolSquidRegistry) {
            GameRegistry.register(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
