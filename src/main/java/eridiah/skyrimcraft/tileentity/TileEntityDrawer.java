package eridiah.skyrimcraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import scala.actors.threadpool.Arrays;

public class TileEntityDrawer extends TileEntity implements IInventory
{
	private final int NUMBER_OF_SLOTS = 9;
	private ItemStack[] itemStacks;
	
	public TileEntityDrawer() 
	{
		itemStacks = new ItemStack[NUMBER_OF_SLOTS];
		clear();
	}
	
	@Override
	public int getSizeInventory() 
	{
		return itemStacks.length;
	}
	
	@Override
	public boolean isEmpty() 
	{
		for(ItemStack itemstack : itemStacks)
		{
			if(!itemstack.isEmpty())
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return itemStacks[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		ItemStack itemStackInSlot = getStackInSlot(index);
		if(itemStackInSlot.isEmpty())
			return ItemStack.EMPTY;
		
		ItemStack itemStackRemoved;
		if(itemStackInSlot.getCount() <= count) 
		{
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(index, ItemStack.EMPTY);
		}
		else
		{
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if(itemStackInSlot.getCount() == 0)
			{
				setInventorySlotContents(index, ItemStack.EMPTY);
			}
		}
		markDirty();
		return itemStackRemoved;
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		itemStacks[index] = stack;
		if(stack.isEmpty() && stack.getCount() > getInventoryStackLimit())
		{
			stack.setCount(getInventoryStackLimit());
		}
		markDirty();
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		if(this.world.getTileEntity(this.pos) != this)
			return true;
		
		final double X_CENTER_OFFSET = 0.5;
		final double Y_CENTER_OFFSET = 0.5;
		final double Z_CENTER_OFFSET = 0.5;
		final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
		
		return player.getDistanceSq(pos.getX() + X_CENTER_OFFSET, pos.getY() + Y_CENTER_OFFSET, pos.getZ() + Z_CENTER_OFFSET) < MAXIMUM_DISTANCE_SQ;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		
		NBTTagList dataForAllSlots = new NBTTagList();
		for(int i = 0; i < this.itemStacks.length; ++i)
		{
			if(!this.itemStacks[i].isEmpty())
			{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		
		compound.setTag("Items", dataForAllSlots);
		
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		final byte NBT_TYPE_COMPOUND = 10;
		NBTTagList dataForAllSlots = compound.getTagList("Items", NBT_TYPE_COMPOUND);
		
		Arrays.fill(itemStacks, ItemStack.EMPTY);
		for(int i = 0; i < dataForAllSlots.tagCount(); ++i)
		{
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			int slotIndex = dataForOneSlot.getByte("Slot") & 255;
			
			if(slotIndex >= 0 && slotIndex < this.itemStacks.length)
			{
				this.itemStacks[slotIndex] = new ItemStack(dataForOneSlot);
			}
		}
	}
	
	@Override
	public void clear() 
	{
		Arrays.fill(itemStacks, ItemStack.EMPTY);
	}
	
	@Override
	public String getName() 
	{
		return "container.drawer.name";
	}
	
	@Override
	public boolean hasCustomName() 
	{
		return false;
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		ItemStack itemStack = getStackInSlot(index);
		if(itemStack.isEmpty())
			setInventorySlotContents(index, ItemStack.EMPTY);
		
		return itemStack;
	}
	
	@Override
	public void openInventory(EntityPlayer player) {}
	
	@Override
	public void closeInventory(EntityPlayer player) {}
	
	@Override
	public int getField(int id) 
	{
		return 0;
	}
	
	@Override
	public void setField(int id, int value) {}
	
	@Override
	public int getFieldCount() 
	{
		return 0;
	}
}
