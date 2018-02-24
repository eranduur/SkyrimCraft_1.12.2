package eridiah.skyrimcraft.init;

import java.util.ArrayList;
import java.util.List;

import eridiah.skyrimcraft.objects.items.ItemBase;
import net.minecraft.item.Item;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item STRIPS_LEATHER = new ItemBase("strips_leather");
	
	//ingots
	public static final Item INGOT_CORUNDUM = new ItemBase("ingot_corundum");
	public static final Item INGOT_DWARVEN_METAL = new ItemBase("ingot_dwarven_metal");
	public static final Item INGOT_EBONY = new ItemBase("ingot_ebony");
	public static final Item INGOT_ORICHALCUM = new ItemBase("ingot_orichalcum");
	public static final Item INGOT_QUICKSILVER = new ItemBase("ingot_quicksilver");
	public static final Item INGOT_SILVER = new ItemBase("ingot_silver");
	public static final Item INGOT_STEEL = new ItemBase("ingot_steel");
	public static final Item MALACHITE_REFINED = new ItemBase("malachite_refined");
	public static final Item MOONSTONE_REFINED = new ItemBase("moonstone_refined");
}
