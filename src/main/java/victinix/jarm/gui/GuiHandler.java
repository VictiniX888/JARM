package victinix.jarm.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import victinix.jarm.JARM;
import victinix.jarm.containers.ContainerCompressor;
import victinix.jarm.tileentities.TileEntityCompressor;

public class GuiHandler implements IGuiHandler {

    public GuiHandler() {

        NetworkRegistry.INSTANCE.registerGuiHandler(JARM.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        switch(ID) {
            case 0:
                if(tileEntity != null && tileEntity instanceof TileEntityCompressor) {
                    return new ContainerCompressor(player.inventory, (TileEntityCompressor) tileEntity);
                }
                else {
                    return null;
                }
            default :
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

        switch(ID) {
            case 0:
                if(tileEntity != null && tileEntity instanceof TileEntityCompressor) {
                    return new GuiCompressor(player.inventory, (TileEntityCompressor) tileEntity);
                }
                else {
                    return null;
                }
            default :
                return null;
        }
    }
}
