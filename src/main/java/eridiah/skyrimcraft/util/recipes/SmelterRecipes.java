package eridiah.skyrimcraft.util.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import eridiah.skyrimcraft.init.BlockInit;
import eridiah.skyrimcraft.init.ItemInit;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class SmelterRecipes 
{
	private static final SmelterRecipes INSTANCE = new SmelterRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static SmelterRecipes getInstance()
	{
		return INSTANCE;
	}
	
	private SmelterRecipes() 
	{
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_CORUNDUM), new ItemStack(BlockInit.ORE_CORUNDUM), new ItemStack(ItemInit.INGOT_CORUNDUM), 6.0F);
	}

	/**
	 * A nice, compound fuction that allows me to easily add furnace recipes in the private constructor above.
	 * 
	 * This class is super long because smelting recipes are a bitch in 1.12
	 * 
	 * @param input1 - first item
	 * @param input2 - second item
	 * @param result - the result of the smelting recipe
	 * @param experience - how much experience is gained from smelting
	 */
	
	public void addSmeltingRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) 
	{
		if(getSmeltingResult(input1, input2) != ItemStack.EMPTY) 
			return;
		this.smeltingList.put(input1, input2, result);
		this.experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getSmeltingResult(ItemStack input1, ItemStack input2) 
	{
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet()) 
		{
			if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) 
					{
						return (ItemStack)ent.getValue();
					}
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getSmeltingExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}
