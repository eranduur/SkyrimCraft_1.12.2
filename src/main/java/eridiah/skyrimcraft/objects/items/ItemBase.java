package eridiah.skyrimcraft.objects.items;

import eridiah.skyrimcraft.Main;
import eridiah.skyrimcraft.init.ItemInit;
import eridiah.skyrimcraft.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
	public ItemBase(String name)
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		//creative tab line
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
