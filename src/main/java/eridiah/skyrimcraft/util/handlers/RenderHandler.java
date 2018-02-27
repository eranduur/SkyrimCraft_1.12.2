package eridiah.skyrimcraft.util.handlers;

import eridiah.skyrimcraft.entity.EntityDraugr;
import eridiah.skyrimcraft.entity.render.RenderDraugr;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDraugr.class, new IRenderFactory<EntityDraugr>()
		{
			@Override
			public Render<? super EntityDraugr> createRenderFor(RenderManager manager) 
			{
				return new RenderDraugr(manager);
			}
		});
	}
}
