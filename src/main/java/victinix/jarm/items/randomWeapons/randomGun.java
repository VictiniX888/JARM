package victinix.jarm.items.randomWeapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

/**
 * Created by VictiniX888 on 31-Jan-2015.
 */

public class randomGun extends Item {

    private String name = "randomGun";

    public randomGun() {

        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        if (!world.isRemote) {

            entityPlayer.addChatMessage(new ChatComponentText(Configurations.randomGunText));
        }

        return itemStack;
    }
}
