package eridiah.skyrimcraft.util.handlers;

import eridiah.skyrimcraft.Main;
import eridiah.skyrimcraft.init.BlockInit;
import eridiah.skyrimcraft.init.EntityInit;
import eridiah.skyrimcraft.init.ItemInit;
import eridiah.skyrimcraft.init.NetworkInit;
import eridiah.skyrimcraft.util.Reference;
import eridiah.skyrimcraft.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
	}
	
	/**
	 * Removes crafting default crafting recipes from the game.
	 * 
	 * @param event - the registry event for crafting recipes
	 */
	
	@SubscribeEvent
	public static void removeCraftingRecipes(RegistryEvent.Register<IRecipe> event)
	{
		IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
		
		RecipeHandler.removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_ingot_from_block"), Reference.MODID);
		RecipeHandler.removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_ingot_from_nuggets"), Reference.MODID);
		RecipeHandler.removeRecipe(modRegistry, new ResourceLocation("minecraft:gold_ingot_from_block"), Reference.MODID);
		RecipeHandler.removeRecipe(modRegistry, new ResourceLocation("minecraft:gold_ingot_from_nuggets"), Reference.MODID);
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries()
	{
		NetworkInit.registerSimpleNetworking();
		EntityInit.registerEntites();
		RenderHandler.registerEntityRenders();
	}
	
	public static void initRegistries()
	{
		RecipeHandler.removeSmeltingRecipes();
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
}
