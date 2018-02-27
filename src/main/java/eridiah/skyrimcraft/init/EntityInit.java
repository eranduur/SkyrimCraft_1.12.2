package eridiah.skyrimcraft.init;

import eridiah.skyrimcraft.Main;
import eridiah.skyrimcraft.entity.EntityDraugr;
import eridiah.skyrimcraft.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{
	public static void registerEntites()
	{
		registerEntity("draugr", EntityDraugr.class, Reference.ENTITY_DRAUGR, 50, 000000, 3947580);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
}
