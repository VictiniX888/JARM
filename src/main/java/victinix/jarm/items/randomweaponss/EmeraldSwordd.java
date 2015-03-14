package victinix.jarm.items.randomweaponss;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;
import victinix.jarm.libs.Configurationss;
import victinix.jarm.libs.Dataa;
import victinix.jarm.libs.Tabss;

import java.util.List;

public class EmeraldSwordd extends ItemSword {

    private String name = "emeraldSword";

    public EmeraldSwordd(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Dataa.MODID + ":" + name);
        setTextureName(Dataa.MODID + ":" + name);
        setCreativeTab(Tabss.tabRandom);
        if(Configurationss.emeraldSwordRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean something) {
        list.add(StatCollector.translateToLocal("jarm.emeraldSword.tooltip"));

    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityAttacked, EntityLivingBase entityAttacking) {

        if(Configurationss.emeraldSwordFire) {
            entityAttacked.setFire(2);
        }

        return true;
    }
}
