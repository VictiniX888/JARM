package victinix.jarm.items.materials;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

import java.util.List;

public class ItemDust extends Item {

    public ItemDust() {

        super();
        setRegistryName(Data.MODID + ":" + "dust");
        setUnlocalizedName(Data.MODID + ":" + "dust");
        setHasSubtypes(true);
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.dustRegistry) {
            GameRegistry.registerItem(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        final ModelResourceLocation[] resourceLocations = new ModelResourceLocation[7];
        for (int i = 0; i < 7; i++) {
            resourceLocations[i] = new ModelResourceLocation(getRegistryName() + "_" + i, "inventory");
        }

        ModelBakery.registerItemVariants(this, resourceLocations[0], resourceLocations[1], resourceLocations[2], resourceLocations[3], resourceLocations[4], resourceLocations[5], resourceLocations[6]);
        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {

                int i = 0;
                for (; i < 7; i++) {
                    if(stack.getItemDamage() == i) {
                        break;
                    }
                }
                return resourceLocations[i];
            }
        });
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {

        for (int i = 0; i < 7; i++) {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        return getUnlocalizedName() + stack.getItemDamage();
    }
}
