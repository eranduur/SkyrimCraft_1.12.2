package eridiah.skyrimcraft.util.handlers;

import eridiah.skyrimcraft.tileentity.TileEntitySmelter;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "smelter");
	}
}
