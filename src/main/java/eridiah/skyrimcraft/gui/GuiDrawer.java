package eridiah.skyrimcraft.gui;

import java.awt.Color;

import eridiah.skyrimcraft.container.ContainerDrawer;
import eridiah.skyrimcraft.tileentity.TileEntityDrawer;
import eridiah.skyrimcraft.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class GuiDrawer extends GuiContainer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/drawer.png");
	
	public GuiDrawer(InventoryPlayer player, TileEntityDrawer tileEntity) 
	{
		super(new ContainerDrawer(player, tileEntity));
		xSize = 176;
		ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		fontRenderer.drawString(new TextComponentTranslation("tile.drawer.name").getFormattedText(), 5, 5, Color.darkGray.getRGB());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
