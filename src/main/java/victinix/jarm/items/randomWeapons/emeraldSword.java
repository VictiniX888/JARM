package victinix.jarm.items.randomWeapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

import java.util.List;

public class emeraldSword extends ItemSword {

    private String name = "emeraldSword";

    public emeraldSword(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.emeraldSwordRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean something) {
        list.add(StatCollector.translateToLocal("jarm.emeraldSword.tooltip"));

    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityAttacked, EntityLivingBase entityAttacking) {

        if(Configurations.emeraldSwordFire) {
            entityAttacked.setFire(2);
        }

        return true;
    }
}
