package victinix.jarm.items.magic;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

public class ItemXProducer extends Item {

    public ItemXProducer() {

        super();
        setRegistryName(Data.MODID + ":" + "xproducer");
        setUnlocalizedName(Data.MODID + ":" + "xproducer");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.xProducerRegistry) {
            GameRegistry.register(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

        playerIn.attackEntityFrom(DamageSource.generic, 2f);
        playerIn.addExperience(10);

        return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
