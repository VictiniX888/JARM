package victinix.jarm.items.bauble;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.lib.Tabs;

public class ItemBurgerRing extends Item implements IBauble {

    private String name = "burgerRing";

    public ItemBurgerRing() {

        super();
        setMaxStackSize(1);
        setUnlocalizedName(Data.MODID + ":" + name);
        setTextureName(Data.MODID + ":" + name);
        setCreativeTab(Tabs.tabRandom);
        if(Loader.isModLoaded("Baubles") && Configurations.burgerRingRegister) {
            GameRegistry.registerItem(this, name);
        }
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {

        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemStack, EntityLivingBase entityLivingBase) {

        entityLivingBase.addPotionEffect(new PotionEffect(23, 40));
    }

    @Override
    public void onEquipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public void onUnequipped(ItemStack itemStack, EntityLivingBase entityLivingBase) {

    }

    @Override
    public boolean canEquip(ItemStack itemStack, EntityLivingBase entityLivingBase) {

        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemStack, EntityLivingBase entityLivingBase) {
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if(!world.isRemote) {
            IInventory baubles = BaublesApi.getBaubles(player);
            if(baubles.getStackInSlot(1) == null) {
                baubles.setInventorySlotContents(1, itemStack);
                player.inventory.getCurrentItem().stackSize--;
            }
            else if(baubles.getStackInSlot(2) == null) {
                baubles.setInventorySlotContents(2, itemStack);
                player.inventory.getCurrentItem().stackSize--;
            }
            else {
                return itemStack;
            }
        }

        return itemStack;
    }
}
