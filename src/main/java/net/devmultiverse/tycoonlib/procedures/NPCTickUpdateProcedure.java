package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class NPCTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("hasSetDefaultData")) {
			NPCAwakeProcedure.execute(entity);
			entity.getPersistentData().putBoolean("hasSetDefaultData", true);
		}
		NPCDataUpdateProcedure.execute(world, x, y, z, entity);
		NPCTaskUpdateProcedure.execute(entity);
	}
}
