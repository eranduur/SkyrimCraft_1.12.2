package eridiah.skyrimcraft.util.handlers;

import eridiah.skyrimcraft.container.ContainerSmelter;
import eridiah.skyrimcraft.gui.GuiSmelter;
import eridiah.skyrimcraft.tileentity.TileEntitySmelter;
import eridiah.skyrimcraft.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_SMELTER)
			return new ContainerSmelter(player.inventory, (TileEntitySmelter)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == Reference.GUI_SMELTER)
			return new GuiSmelter(player.inventory, (TileEntitySmelter)world.getTileEntity(new BlockPos(x, y, z)));
		return null;
	}	
}
