package eridiah.skyrimcraft.container;

import eridiah.skyrimcraft.tileentity.TileEntityDrawer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerDrawer extends Container
{
	public ContainerDrawer(InventoryPlayer inventoryPlayer, TileEntityDrawer tileEntity) 
	{
		if(tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH))
		{
			IItemHandler inventory = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
			
			//custom drawer slots
			
			
			//player inventory
			for(int y = 0; y < 3; y++)
			{
				for(int x = 0; x < 9; x++)
				{
					addSlotToContainer(new Slot(inventoryPlayer, x + (y * 9) + 9, 8 + x * 18, 84 + y * 18));
				}
			}
			
			//player hotbar
			for(int i = 0; i < 9; i++)
			{
				addSlotToContainer(new Slot(inventoryPlayer, i, 8 + (i * 18), 142));
			}
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) 
	{
		return super.transferStackInSlot(playerIn, index);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return true;
	}
}
