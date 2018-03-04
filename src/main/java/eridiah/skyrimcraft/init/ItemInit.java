package eridiah.skyrimcraft.init;

import java.util.ArrayList;
import java.util.List;

import eridiah.skyrimcraft.objects.items.ItemBase;
import eridiah.skyrimcraft.objects.tools.ToolDagger;
import eridiah.skyrimcraft.objects.tools.ToolSword;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//materials
	public static final ToolMaterial TOOL_GLASS = EnumHelper.addToolMaterial("tool_glass", 2, 250, 5.0F, 2.5F, 10);
	
	//items
	public static final Item STRIPS_LEATHER = new ItemBase("strips_leather");
	
	//ingots
	public static final Item INGOT_CORUNDUM = new ItemBase("ingot_corundum");
	public static final Item INGOT_DWARVEN_METAL = new ItemBase("ingot_dwarven_metal");
	public static final Item INGOT_EBONY = new ItemBase("ingot_ebony");
	public static final Item INGOT_ORICHALCUM = new ItemBase("ingot_orichalcum");
	public static final Item INGOT_QUICKSILVER = new ItemBase("ingot_quicksilver");
	public static final Item INGOT_SILVER = new ItemBase("ingot_silver");
	public static final Item INGOT_STEEL = new ItemBase("ingot_steel");
	public static final Item INGOT_GOLD = new ItemBase("ingot_gold");
	public static final Item INGOT_IRON = new ItemBase("ingot_iron");
	public static final Item MALACHITE_REFINED = new ItemBase("malachite_refined");
	public static final Item MOONSTONE_REFINED = new ItemBase("moonstone_refined");
	
	//dwarven scrap metals
	public static final Item METAL_SOLID_DWEMER = new ItemBase("metal_solid_dwemer");
	public static final Item METAL_BENT_DWEMER_SCRAP = new ItemBase("metal_bent_dwemer_scrap");
	public static final Item METAL_LARGE_DWEMER_PLATE = new ItemBase("metal_large_dwemer_plate");
	public static final Item METAL_SMALL_DWEMER_PLATE = new ItemBase("metal_small_dwemer_plate");
	public static final Item STRUT_LARGE_DWEMER = new ItemBase("strut_large_dwemer");
	public static final Item STRUT_LARGE_DECORATIVE_DWEMER = new ItemBase("strut_large_decorative_dwemer");
	
	
	//daggers
	public static final Item DAGGER_GLASS = new ToolDagger("dagger_glass", TOOL_GLASS);
	
	//swords
	public static final Item SWORD_GLASS = new ToolSword("sword_glass", TOOL_GLASS);
}
