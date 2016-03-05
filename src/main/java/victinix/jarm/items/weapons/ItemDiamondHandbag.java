package victinix.jarm.items.weapons;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

import java.util.Random;

public class ItemDiamondHandbag extends ItemSword {

    public ItemDiamondHandbag(ToolMaterial toolMaterial) {

        super(toolMaterial);
        setRegistryName(Data.MODID + ":" + "diamond_handbag");
        setUnlocalizedName(Data.MODID + ":" + "diamond_handbag");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.diamondHandbagRegistry) {
            GameRegistry.registerItem(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        target.addPotionEffect(new PotionEffect(Potion.wither.id, 500));

        Random random = new Random();
        int recoilChance = random.nextInt(100);
        if(Configurations.diamondHandbagRecoil) {
            if (recoilChance < Configurations.diamondHandbagRecoilChance) {
                attacker.attackEntityFrom(DamageSource.generic, 4);
            }
        }

        return true;
    }
}
