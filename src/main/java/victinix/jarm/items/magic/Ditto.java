package victinix.jarm.items.magic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class Ditto extends Item {

    private String name = "ditto";

    public Ditto() {

        super();
        setMaxStackSize(1);
        setUnlocalizedName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.dittoRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        ItemStack itemToBeDuped = entityPlayer.inventory.getStackInSlot(0);

        if(itemToBeDuped != null && itemToBeDuped.stackSize == 1) {
            itemStack.stackSize--;
            return itemToBeDuped.copy();
        }

        else {
            return itemStack;
        }
    }
}
