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
	
	/**
	 * In order for the recipe to work, the two items being smelted MUST be from the same Init class. For example, I can only smelt two items from the BlockInit or 
	 * Blocks (default Minecraft class) classes. I CANNOT smelt an item from each one. I'm currently working on a way around this, but I have to use a .equals() method
	 * which really limits what I can do. 
	 * 
	 * Also, I still have no clue how much xp is actually given per thing smelted, so I'll have to go back and test that at a later date.
	 */
	
	private SmelterRecipes() 
	{
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_CORUNDUM), new ItemStack(BlockInit.ORE_CORUNDUM), new ItemStack(ItemInit.INGOT_CORUNDUM), 6.0F);
		//add Gold recipe
		//add Iron recipe
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_EBONY), new ItemStack(BlockInit.ORE_EBONY), new ItemStack(ItemInit.INGOT_EBONY), 6.0F);
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_ORICHALCUM), new ItemStack(BlockInit.ORE_ORICHALCUM), new ItemStack(ItemInit.INGOT_ORICHALCUM), 6.0F);
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_QUICKSILVER), new ItemStack(BlockInit.ORE_QUICKSILVER), new ItemStack(ItemInit.INGOT_QUICKSILVER), 6.0F);
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_MALACHITE), new ItemStack(BlockInit.ORE_MALACHITE), new ItemStack(ItemInit.MALACHITE_REFINED), 6.0F);
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_MOONSTONE), new ItemStack(BlockInit.ORE_MOONSTONE), new ItemStack(ItemInit.MOONSTONE_REFINED), 6.0F);
		this.addSmeltingRecipe(new ItemStack(BlockInit.ORE_SILVER), new ItemStack(BlockInit.ORE_SILVER), new ItemStack(ItemInit.INGOT_SILVER), 6.0F);
		//Add Steel recipe
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
