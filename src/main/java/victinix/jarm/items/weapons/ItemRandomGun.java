package victinix.jarm.items.weapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

import java.util.List;
import java.util.Random;

public class ItemRandomGun extends Item {

    private String[] name3 = {"ak", "msbs", "pistol", "sniper", "submachineGun"};
    private String name = "randomGun";
    private String name2 = Configurations.randomGunTextureFixed;

    Random random = new Random();
    int texture = random.nextInt(name3.length);

    public ItemRandomGun() {

        super();
        setUnlocalizedName(Data.MODID + ":" + name);
        if(Configurations.randomGunTextureRandom) {
            setTextureName(Data.MODID + ":" + name3[texture]);
        }
        else {
            setTextureName(Data.MODID + ":" + name2);
        }
        setMaxStackSize(1);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.randomGunRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean something) {

        list.add(StatCollector.translateToLocal("jarm.randomGun.tooltip"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        if(!world.isRemote) {
            entityPlayer.addChatMessage(new ChatComponentText(Configurations.randomGunText));
        }

        return itemStack;
    }
}
