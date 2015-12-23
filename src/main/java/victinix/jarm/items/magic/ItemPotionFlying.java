package victinix.jarm.items.magic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import victinix.jarm.JARM;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.lib.Tabs;

public class ItemPotionFlying extends Item {

    public String name = "potionFlying";

    public ItemPotionFlying() {

        super();
        setMaxStackSize(1);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.flyingPotionRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        player.addPotionEffect(new PotionEffect(JARM.flyingPotion.id, 200, 0));
        itemStack.stackSize--;

        return itemStack;
    }
}
