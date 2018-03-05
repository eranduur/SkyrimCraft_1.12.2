package eridiah.skyrimcraft.util.handlers;

import eridiah.skyrimcraft.container.ContainerDrawer;
import eridiah.skyrimcraft.container.ContainerSmelter;
import eridiah.skyrimcraft.gui.GuiDrawer;
import eridiah.skyrimcraft.gui.GuiSmelter;
import eridiah.skyrimcraft.tileentity.TileEntityDrawer;
import eridiah.skyrimcraft.tileentity.TileEntitySmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static final int GUI_SMELTER_ID = 0;
	public static final int GUI_DRAWER_ID = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID) 
		{
			case GUI_SMELTER_ID:
				return new ContainerSmelter(player.inventory, (TileEntitySmelter) te);
			case GUI_DRAWER_ID:
				return new ContainerDrawer(player.inventory, (TileEntityDrawer) te);
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		switch(ID) 
		{
			case GUI_SMELTER_ID:
				return new GuiSmelter(player.inventory, (TileEntitySmelter) te);
			case GUI_DRAWER_ID:
				return new GuiDrawer(player.inventory, (TileEntityDrawer) te);
			default:
				return null;
		}
	}	
}
