package victinix.jarm.items.food;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

import java.util.List;

public class ItemHotdog extends ItemFood {

    private String name = "hotdog";

    public ItemHotdog(int heal, float saturation, boolean wolfMeat) {

        super(heal, saturation, wolfMeat);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.hotdogRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean something) {
        list.add(StatCollector.translateToLocal("jarm.hotdog.tooltip"));
    }
}
