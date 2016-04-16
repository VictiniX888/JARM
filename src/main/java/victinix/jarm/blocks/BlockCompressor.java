package victinix.jarm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.JARM;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;
import victinix.jarm.tileentities.TileEntityCompressor;

public class BlockCompressor extends Block {

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockCompressor(Material materialIn) {

        super(materialIn);
        setRegistryName(Data.MODID + ":" + "compressor");
        setUnlocalizedName(Data.MODID + ":" + "compressor");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        GameRegistry.registerBlock(this);
        GameRegistry.registerTileEntity(TileEntityCompressor.class, (Data.MODID + ":" + "compressor"));
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public static EnumFacing getFacingFromEntity(BlockPos blockPos, EntityLivingBase entity) {

        return EnumFacing.getFacingFromVector((float)(entity.posX - blockPos.getX()), (float)(entity.posY - blockPos.getY()), (float)(entity.posZ - blockPos.getZ()));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        worldIn.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(pos, placer)), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        return state.getValue(FACING).getIndex();
    }

    @Override
    protected BlockState createBlockState() {

        return new BlockState(this, FACING);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {

        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {

        return new TileEntityCompressor();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {

        if(!worldIn.isRemote) {
            FMLNetworkHandler.openGui(playerIn, JARM.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }
}
