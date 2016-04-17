package victinix.jarm.items.magic;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

public class ItemSuperBurger extends Item {

    public ItemSuperBurger() {

        super();
        setRegistryName(Data.MODID + ":" + "super_burger");
        setUnlocalizedName(Data.MODID + ":" + "super_burger");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.superBurgerRegistry) {
            GameRegistry.register(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
