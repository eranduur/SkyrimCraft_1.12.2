package eridiah.skyrimcraft.init;

import java.util.ArrayList;
import java.util.List;

import eridiah.skyrimcraft.objects.blocks.BlockBase;
import eridiah.skyrimcraft.objects.blocks.BlockDrawer;
import eridiah.skyrimcraft.objects.blocks.BlockSmelter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//ores
	public static final Block ORE_CORUNDUM = new BlockBase("ore_corundum", Material.ROCK);
	public static final Block ORE_EBONY = new BlockBase("ore_ebony", Material.ROCK);
	public static final Block ORE_ORICHALCUM = new BlockBase("ore_orichalcum", Material.ROCK);
	public static final Block ORE_QUICKSILVER = new BlockBase("ore_quicksilver", Material.ROCK);
	public static final Block ORE_SILVER = new BlockBase("ore_silver", Material.ROCK);
	public static final Block ORE_MALACHITE = new BlockBase("ore_malachite", Material.ROCK);
	public static final Block ORE_MOONSTONE = new BlockBase("ore_moonstone", Material.ROCK);
	
	public static final Block SMELTER = new BlockSmelter("smelter");
	
	public static final Block DRAWER = new BlockDrawer("drawer");
}
