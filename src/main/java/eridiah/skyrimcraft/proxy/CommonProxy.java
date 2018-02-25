package eridiah.skyrimcraft.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy 
{	
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {}
	
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx)
	{
		return ctx.getServerHandler().player;
	}
}
