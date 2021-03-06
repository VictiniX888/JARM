package victinix.jarm.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import victinix.jarm.containers.ContainerCompressor;
import victinix.jarm.lib.Data;
import victinix.jarm.tileentities.TileEntityCompressor;

public class GuiCompressor extends GuiContainer {

    private static final ResourceLocation texture = new ResourceLocation(Data.MODID, "textures/gui/compressor.png");
    private TileEntityCompressor compressor;

    GuiCompressor(InventoryPlayer inventorySlotsIn, TileEntityCompressor compressor) {

        super(new ContainerCompressor(inventorySlotsIn, compressor));
        xSize = 176;
        ySize = 166;
        this.compressor = compressor;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        String nameCompressor = I18n.format("container.compressor");
        String nameInventory = I18n.format("container.inventory");
        fontRendererObj.drawString(nameCompressor, xSize/2-fontRendererObj.getStringWidth(nameCompressor)/2, 6, 4210752);
        fontRendererObj.drawString(nameInventory, 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

        GL11.glColor4f(1f, 1f, 1f, 1f);
        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if(compressor.canCompress() && compressor.compressingSomething()) {
            int progress = compressor.ticksCompressItemSoFar / (compressor.compressingTime() / 12);
            drawTexturedModalRect(guiLeft + 85, guiTop + 39, 176, 0, 6, progress + 1);
        }
        else {
            drawTexturedModalRect(guiLeft + 85, guiTop + 39, 176, 0, 6, 0);
        }
    }
}
