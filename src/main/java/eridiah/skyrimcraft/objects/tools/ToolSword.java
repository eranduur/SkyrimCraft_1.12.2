package eridiah.skyrimcraft.objects.tools;

import eridiah.skyrimcraft.Main;
import eridiah.skyrimcraft.init.ItemInit;
import eridiah.skyrimcraft.util.interfaces.IExtendedReach;
import eridiah.skyrimcraft.util.interfaces.IHasModel;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel, IExtendedReach
{
	public ToolSword(String name, ToolMaterial material) 
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.TAB_ITEMS);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public float getReach() 
	{
		return 20.0F;
	}
}
