package eridiah.skyrimcraft.tabs;

import eridiah.skyrimcraft.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabBlocks extends CreativeTabs {

	public TabBlocks(String label) 
	{
		super("tab_blocks");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(BlockInit.ORE_CORUNDUM);
	}

}
