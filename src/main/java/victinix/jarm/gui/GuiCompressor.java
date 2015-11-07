package victinix.jarm.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import victinix.jarm.containers.ContainerCompressor;
import victinix.jarm.libs.Data;
import victinix.jarm.tileentities.TileEntityCompressor;

public class GuiCompressor extends GuiContainer {

    public static final ResourceLocation texture = new ResourceLocation(Data.MODID, "textures/gui/compressor.png");

    public GuiCompressor(InventoryPlayer inventoryPlayer, TileEntityCompressor tileEntityCompressor) {

        super(new ContainerCompressor(inventoryPlayer, tileEntityCompressor));

        xSize = 176;
        ySize = 165;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1f, 1f, 1f, 1f);
        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
