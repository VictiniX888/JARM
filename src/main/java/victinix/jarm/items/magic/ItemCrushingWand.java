package victinix.jarm.items.magic;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;

import java.util.Random;
import java.util.Set;

public class ItemCrushingWand extends ItemTool {

    public ItemCrushingWand(float attackDamage, ToolMaterial material, Set<Block> effectiveBlocks) {

        super(attackDamage, material, effectiveBlocks);
        setRegistryName(Data.MODID + ":" + "crushing_wand");
        setUnlocalizedName(Data.MODID + ":" + "crushing_wand");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        if(Configurations.crushingWandRegistry) {
            GameRegistry.registerItem(this);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public boolean canHarvestBlock(Block blockIn) {

        return super.canHarvestBlock(blockIn);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn) {

        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

        Random random = new Random();
        Block block = null;

        while(true) {
            int id = random.nextInt(4096);
            block = GameData.getBlockRegistry().getObjectById(id);
            if(block != null && block != Blocks.air) {
                break;
            }
        }

        if(!worldIn.isRemote) {
            worldIn.setBlockState(pos, block.getDefaultState());
            return true;
        }
        else {
            return false;
        }
    }
}
