package eridiah.skyrimcraft.objects.blocks;

import eridiah.skyrimcraft.Main;
import eridiah.skyrimcraft.tileentity.TileEntityDrawer;
import eridiah.skyrimcraft.util.handlers.GuiHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockDrawer extends BlockBase implements ITileEntityProvider
{
	public BlockDrawer(String name) 
	{
		super(name, Material.WOOD);
		this.setSoundType(SoundType.WOOD);
		this.setCreativeTab(Main.TAB_BLOCKS);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		TileEntityDrawer te = (TileEntityDrawer) world.getTileEntity(pos);
		if(te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH))
		{
			player.openGui(Main.instance, GuiHandler.GUI_DRAWER_ID, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileEntityDrawer te = (TileEntityDrawer) world.getTileEntity(pos);
		if(te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH))
		{
			IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
			if(inventory != null)
			{
				for(int i = 0; i < inventory.getSlots(); i++)
				{
					if(inventory.getStackInSlot(i) != ItemStack.EMPTY)
					{
						EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));
						
						float multiplier = 0.1F;
						float motionX = world.rand.nextFloat() - 0.5F;
						float motionY = world.rand.nextFloat() - 0.5F;
						float motionZ = world.rand.nextFloat() - 0.5F;
						
						item.motionX = motionX * multiplier;
						item.motionY = motionY * multiplier;
						item.motionZ = motionZ * multiplier;
						
						world.spawnEntity(item);
 					}
				}
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityDrawer();
	}
}
