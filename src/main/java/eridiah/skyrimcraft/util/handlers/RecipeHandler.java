package eridiah.skyrimcraft.util.handlers;

import java.util.Iterator;
import java.util.Map;

import eridiah.skyrimcraft.util.Reference;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RecipeHandler 
{
	public static void addSmeltingRecipes()
	{
		
	}
	
	public static void removeSmeltingRecipes()
	{
		removeSmelting(new ItemStack(Items.IRON_INGOT), Reference.MODID);
		removeSmelting(new ItemStack(Items.GOLD_INGOT), Reference.MODID);
	}
	
	public static void removeSmelting(Item result, int stacksize, int meta, String modid)
	{
		ItemStack resultStack = new ItemStack(result, stacksize, meta);
		removeSmelting(resultStack, modid);
	}
	
	public static void removeSmelting(ItemStack result, String modid)
	{
		ItemStack recipeResult = null;
		Map<ItemStack,ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		Iterator<ItemStack> iterator = recipes.keySet().iterator();
		while(iterator.hasNext())
		{
			ItemStack tmpRecipe = iterator.next();
			recipeResult = recipes.get(tmpRecipe);
			if(ItemStack.areItemStacksEqual(result, recipeResult)) 
			{
				System.out.println(modid + " Removed Recipe: " + tmpRecipe + " -> " + recipeResult);
				iterator.remove();
			}
			
		}
		
	}
	
	public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe, String modid)
	{
		IRecipe p = (IRecipe)modRegistry.getValue(recipe);
		
		modRegistry.remove(recipe);
	}
}
