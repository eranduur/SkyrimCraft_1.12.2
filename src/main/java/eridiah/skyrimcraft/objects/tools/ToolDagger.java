package eridiah.skyrimcraft.objects.tools;

import com.google.common.collect.Multimap;

import eridiah.skyrimcraft.Main;
import eridiah.skyrimcraft.init.ItemInit;
import eridiah.skyrimcraft.util.interfaces.IExtendedReach;
import eridiah.skyrimcraft.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ToolDagger extends Item implements IHasModel
{
	private final float attackDamage;
	private final Item.ToolMaterial material;
	
	public ToolDagger(String name, Item.ToolMaterial toolMaterial) 
	{
		this.material = toolMaterial;
		this.setMaxStackSize(1);
		this.setMaxDamage(material.getMaxUses());
		this.attackDamage = 3.0F + material.getAttackDamage();
		this.setCreativeTab(Main.TAB_WEAPONS);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		
		ItemInit.ITEMS.add(this);
	}
	
	public float getAttackDamage()
	{
		return this.material.getAttackDamage();
	}
	
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Block block = state.getBlock();

        if (block == Blocks.WEB)
        {
            return 15.0F;
        }
        else
        {
            Material material = state.getMaterial();
            return material != Material.PLANTS && material != Material.VINE && material != Material.CORAL && material != Material.LEAVES && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }
    
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }
    
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }

    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return blockIn.getBlock() == Blocks.WEB;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }
    
    public String getToolMaterialName()
    {
        return this.material.toString();
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.material.getRepairItemStack();
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
    
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }

        return multimap;
    }
    
    @Override
    public void registerModels() 
    {
    		Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
