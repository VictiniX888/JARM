package victinix.jarm.items.magicStuff;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class magicCarpet extends Item {

    private String name = "magicCarpet";

    public magicCarpet() {

        super();
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        GameRegistry.registerItem(this, name);
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {

        EntityPlayer entityPlayer = (EntityPlayer) entity;

        if(entityPlayer.getHeldItem() != null && entityPlayer.getHeldItem().getItem() == this)
            entityPlayer.capabilities.allowFlying = true;
        if(entityPlayer.getHeldItem().getItem() != this && !entityPlayer.capabilities.isCreativeMode) {
            entityPlayer.capabilities.allowFlying = false;
            if(entityPlayer.capabilities.isFlying)
                entityPlayer.capabilities.isFlying = false;
        }
    }
}
