package victinix.jarm.items.weapons;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

public class ItemEmeraldSword extends ItemSword {

    public ItemEmeraldSword(Item.ToolMaterial toolMaterial) {

        super(toolMaterial);
        setRegistryName(Data.MODID + ":" + "emerald_sword");
        setUnlocalizedName(Data.MODID + ":" + "emerald_sword");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.emeraldSwordRegistry) {
            GameRegistry.register(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        stack.damageItem(1, attacker);
        target.setFire(5);

        return true;
    }
}
