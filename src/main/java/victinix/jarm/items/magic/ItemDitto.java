package victinix.jarm.items.magic;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

public class ItemDitto extends Item {

    public ItemDitto() {

        super();
        setMaxStackSize(1);
        setRegistryName(Data.MODID + ":" + "ditto");
        setUnlocalizedName(Data.MODID + ":" + "ditto");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.dittoRegistry) {
            GameRegistry.registerItem(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {

        ItemStack itemDupe = playerIn.inventory.getStackInSlot(playerIn.inventory.currentItem + 1);
        if(itemDupe != null && itemDupe.stackSize == 1) {
            boolean inBlacklist = false;
            for (int i = 0; i < Configurations.dittoBlacklist.length; i++) {
                if(Configurations.dittoBlacklist[i].equals(itemDupe.getDisplayName())) {
                    inBlacklist = true;
                }
            }
            if(!inBlacklist) {
                return itemDupe;
            }
            else {
                return itemStackIn;
            }
        }
        else {
            return itemStackIn;
        }
    }
}
