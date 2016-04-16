package victinix.jarm.blocks;


import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static BlockCompressor compressor;

    public static void initBlocks() {

        compressor = new BlockCompressor(Material.rock);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {

        compressor.initModel();
    }
}
