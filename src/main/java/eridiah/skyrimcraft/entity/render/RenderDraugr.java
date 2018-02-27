package eridiah.skyrimcraft.entity.render;

import eridiah.skyrimcraft.entity.EntityDraugr;
import eridiah.skyrimcraft.entity.model.ModelDraugr;
import eridiah.skyrimcraft.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDraugr extends RenderLiving<EntityDraugr>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/draugr.png");

	public RenderDraugr(RenderManager manager) 
	{
		super(manager, new ModelDraugr(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDraugr entity) 
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityDraugr entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
