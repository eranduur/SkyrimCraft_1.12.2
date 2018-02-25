package eridiah.skyrimcraft.init;

import eridiah.skyrimcraft.network.packets.MessageExtendedReachAttack;
import eridiah.skyrimcraft.util.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ModNetworking 
{
	public static final String NETWORK_CHANNEL_NAME = Reference.MODID;
	public static SimpleNetworkWrapper network;
	
	public static void registerSimpleNetworking()
	{
		// DEBUG
		System.out.println("Registering simple networking");
		network = NetworkRegistry.INSTANCE.newSimpleChannel(NETWORK_CHANNEL_NAME);
		
		int packetId = 0;
		// registers messages from client to server
		network.registerMessage(MessageExtendedReachAttack.Handler.class, MessageExtendedReachAttack.class, packetId++, Side.SERVER);
	}
}
