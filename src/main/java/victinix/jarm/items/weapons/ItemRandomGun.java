package victinix.jarm.items.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

import java.util.Random;

public class ItemRandomGun extends Item {

    String[] textures = {"ak", "msbs", "pistol", "sniper", "submachine_gun"};
    Random random = new Random();
    int r = random.nextInt(textures.length);

    public ItemRandomGun() {

        super();
        setRegistryName(Data.MODID + ":" + "random_gun");
        setUnlocalizedName(Data.MODID + ":" + "random_gun");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.randomGunRegistry) {
            GameRegistry.register(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName() + "_" + textures[r], "inventory"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand) {

        if(worldIn.isRemote)
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new TextComponentString(Configurations.randomGunText));

        return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
