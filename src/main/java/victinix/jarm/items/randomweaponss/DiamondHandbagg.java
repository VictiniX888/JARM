package victinix.jarm.items.randomweaponss;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import victinix.jarm.libs.Configurationss;
import victinix.jarm.libs.Dataa;
import victinix.jarm.libs.Tabss;

import java.util.List;
import java.util.Random;

public class DiamondHandbagg extends ItemSword {

    private String name = "diamondHandbag";

    Random random = new Random();

    public DiamondHandbagg(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Dataa.MODID + ":" + name);
        setTextureName(Dataa.MODID + ":" + name);
        setCreativeTab(Tabss.tabRandom);
        if(Configurationss.diamondHandbagRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean something) {
        list.add(StatCollector.translateToLocal("jarm.diamondHandbag.tooltip"));

    }

    @Override
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityAttacked, EntityLivingBase entityAttacking) {

        entityAttacked.addPotionEffect(new PotionEffect(Potion.wither.id, 100));

        float recoilChance = random.nextFloat();
        if(Configurationss.diamondHandbagRecoil) {
            if (recoilChance <= Configurationss.diamondHandbagRecoilChance) {
                entityAttacking.attackEntityFrom(DamageSource.generic, 4);
            }
        }

        return true;
    }
}
