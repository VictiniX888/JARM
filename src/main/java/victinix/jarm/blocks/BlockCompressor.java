package victinix.jarm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import victinix.jarm.JARM;
import victinix.jarm.lib.Configurations;
import victinix.jarm.lib.Data;
import victinix.jarm.tab.CreativeTabRegistry;
import victinix.jarm.tileentities.TileEntityCompressor;

public class BlockCompressor extends Block {

    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    Item itemBlock = new ItemBlock(this);

    public BlockCompressor(Material materialIn) {

        super(materialIn);
        setRegistryName(Data.MODID + ":" + "compressor");
        setUnlocalizedName(Data.MODID + ":" + "compressor");
        itemBlock.setRegistryName(Data.MODID + ":" + "compressor");
        setCreativeTab(CreativeTabRegistry.creativeTabJARM);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        if(Configurations.compressorRegistry) {
            GameRegistry.register(this);
            GameRegistry.register(itemBlock);
            GameRegistry.registerTileEntity(TileEntityCompressor.class, (Data.MODID + ":" + "compressor"));
        }
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
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, FACING);
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
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack itemStack, EnumFacing side, float hitX, float hitY, float hitZ) {

        if(!worldIn.isRemote) {
            FMLNetworkHandler.openGui(playerIn, JARM.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {

        TileEntityCompressor compressor = (TileEntityCompressor)world.getTileEntity(pos);

        if(compressor != null) {
            for (int i = 0; i < compressor.getSizeInventory(); i++) {
                ItemStack drops = compressor.getStackInSlot(i);
                if(drops != null) {
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), drops);
                    if(drops.hasTagCompound()) {
                        entityItem.getEntityItem().setTagCompound((NBTTagCompound)drops.getTagCompound().copy());
                    }
                    world.spawnEntityInWorld(entityItem);
                }
            }
        }

        super.breakBlock(world, pos, state);
    }
}
