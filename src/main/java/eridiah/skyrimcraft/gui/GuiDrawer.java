package eridiah.skyrimcraft.gui;

import java.awt.Color;

import eridiah.skyrimcraft.container.ContainerDrawer;
import eridiah.skyrimcraft.tileentity.TileEntityDrawer;
import eridiah.skyrimcraft.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDrawer extends GuiContainer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/drawer.png");
	private TileEntityDrawer tileentity;
	
	public GuiDrawer(InventoryPlayer player, TileEntityDrawer tileentity) 
	{
		super(new ContainerDrawer(player, tileentity));
		this.tileentity = tileentity;
		xSize = 176;
		ySize = 133;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		fontRenderer.drawString(tileentity.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
	}
}
