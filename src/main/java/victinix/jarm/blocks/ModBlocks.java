package victinix.jarm.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import victinix.jarm.tileentities.TileEntityCompressor;

public class ModBlocks {

    public static Block compressor;

    public static void init() {

        compressor = new BlockCompressor(Material.rock);
    }

    public static void registerTileEntities() {

        GameRegistry.registerTileEntity(TileEntityCompressor.class, "compressorDirtHammer");
    }
}
