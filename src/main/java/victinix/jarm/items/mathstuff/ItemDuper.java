package victinix.jarm.items.mathstuff;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import victinix.jarm.libs.Configurations;
import victinix.jarm.libs.Data;
import victinix.jarm.libs.Tabs;

public class ItemDuper extends Item {

    private String name = "itemDuper";

    public ItemDuper() {

        super();
        setMaxStackSize(1);
        setUnlocalizedName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Configurations.itemDuperRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {

        ItemStack itemToBeDuped = entityPlayer.inventory.getStackInSlot(0);

        if(itemToBeDuped != null && entityPlayer.inventory.getFirstEmptyStack() != -1) {
            itemStack.stackSize--;
            return itemToBeDuped;
        }

        else {
            return itemStack;
        }
    }
}
