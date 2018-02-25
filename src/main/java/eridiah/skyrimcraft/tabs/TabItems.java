package eridiah.skyrimcraft.tabs;

import eridiah.skyrimcraft.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabItems extends CreativeTabs 
{
	public TabItems(String label) 
	{
		super("tab_items");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.INGOT_ORICHALCUM);
	}
}
