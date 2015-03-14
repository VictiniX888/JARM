package victinix.jarm.items.randomweaponss;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import victinix.jarm.libs.Configurationss;
import victinix.jarm.libs.Dataa;
import victinix.jarm.libs.Tabss;

import java.util.List;
import java.util.Random;

public class RandomGunn extends Item {

    private String[] name3 = {"ak", "msbs", "pistol", "sniper", "submachineGun"};
    private String name = "randomGun";
    private String name2 = Configurationss.randomGunTextureFixed;

    Random random = new Random();
    int texture = random.nextInt(name3.length);

    public RandomGunn() {

        super();
        setUnlocalizedName(Dataa.MODID + ":" + name);
        if(Configurationss.randomGunTextureRandom) {
            setTextureName(Dataa.MODID + ":" + name3[texture]);
        }
        else {
            setTextureName(Dataa.MODID + ":" + name2);
        }
        setMaxStackSize(1);
        setCreativeTab(Tabss.tabRandom);
        if(Configurationss.randomGunRegister) {
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
            entityPlayer.addChatMessage(new ChatComponentText(Configurationss.randomGunText));
        }

        return itemStack;
    }
}
