package victinix.jarm.items.magic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import victinix.jarm.libs.Data;

public class ItemXProducer extends Item {

    private String name = "xProducer";

    public ItemXProducer() {

        super();
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        player.attackEntityFrom(DamageSource.generic, 2f);
        player.addExperience(10);

        return itemStack;
    }
}
