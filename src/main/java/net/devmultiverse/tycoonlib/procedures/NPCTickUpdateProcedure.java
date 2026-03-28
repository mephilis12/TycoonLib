package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

public class NPCTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.getPersistentData().getBoolean("hasSetDefaultData")) {
			NPCAwakeProcedure.execute(entity);
			entity.getPersistentData().putBoolean("hasSetDefaultData", true);
		}
		NPCDataUpdateProcedure.execute(entity);
		NPCTaskUpdateProcedure.execute(entity);
	}
}
