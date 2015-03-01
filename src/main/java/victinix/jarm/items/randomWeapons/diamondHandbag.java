package victinix.jarm.items.randomWeapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

import java.util.List;
import java.util.Random;

public class diamondHandbag extends ItemSword {

    private String name = "diamondHandbag";

    Random random = new Random();

    public diamondHandbag(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.diamondHandbagRegister) {
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
        if(Configurations.diamondHandbagRecoil) {
            if (recoilChance <= Configurations.diamondHandbagRecoilChance) {
                entityAttacking.attackEntityFrom(DamageSource.generic, 4);
            }
        }

        return true;
    }
}
