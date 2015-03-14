package victinix.jarm.items.food;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import victinix.jarm.libs.Configurationss;
import victinix.jarm.libs.Dataa;
import victinix.jarm.libs.Tabss;

import java.util.List;

public class Hotdogg extends ItemFood {

    private String name = "hotdog";

    public Hotdogg(int heal, float saturation, boolean wolfMeat) {

        super(heal, saturation, wolfMeat);
        setUnlocalizedName(Dataa.MODID + ":" + name);
        setTextureName(Dataa.MODID + ":" + name);
        setCreativeTab(Tabss.tabRandom);
        if(Configurationss.hotdogRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean something) {
        list.add(StatCollector.translateToLocal("jarm.hotdog.tooltip"));
    }
}
