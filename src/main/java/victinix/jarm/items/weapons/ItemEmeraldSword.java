package victinix.jarm.items.weapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.lib.Tabs;

import java.util.List;

public class ItemEmeraldSword extends ItemSword {

    private String name = "emeraldSword";

    public ItemEmeraldSword(ToolMaterial toolMaterial) {

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

        itemStack.damageItem(1, entityAttacking);

        if(Configurations.emeraldSwordFire) {
            entityAttacked.setFire(2);
        }

        return true;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {

        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {

        ItemStack damagedSword = itemStack.copy();
        damagedSword.setItemDamage(damagedSword.getItemDamage() + (Configurations.cookedSquidCraftingAmount - 1));

        return damagedSword;
    }
}
