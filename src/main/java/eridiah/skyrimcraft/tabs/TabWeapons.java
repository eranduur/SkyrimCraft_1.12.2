package eridiah.skyrimcraft.tabs;

import eridiah.skyrimcraft.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabWeapons extends CreativeTabs {

	public TabWeapons(String label) 
	{
		super("tab_weapons");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.SWORD_GLASS);
	}

}
