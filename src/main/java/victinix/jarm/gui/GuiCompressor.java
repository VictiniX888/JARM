package victinix.jarm.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import victinix.jarm.containers.ContainerCompressor;
import victinix.jarm.libs.Data;
import victinix.jarm.tileentities.TileEntityCompressor;

public class GuiCompressor extends GuiContainer {

    public static final ResourceLocation texture = new ResourceLocation(Data.MODID, "textures/gui/compressor.png");
    private final IInventory tileCompressor;
    private final InventoryPlayer inventoryPlayer;

    public GuiCompressor(InventoryPlayer invPlayer, TileEntityCompressor tileEntityCompressor) {

        super(new ContainerCompressor(invPlayer, tileEntityCompressor));

        xSize = 176;
        ySize = 165;

        inventoryPlayer = invPlayer;
        tileCompressor = tileEntityCompressor;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        String name = I18n.format("container.compressor");
        fontRendererObj.drawString(name, xSize/2-fontRendererObj.getStringWidth(name)/2, 6, 4210752);
        fontRendererObj.drawString(inventoryPlayer.getInventoryName(), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1f, 1f, 1f, 1f);
        mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
