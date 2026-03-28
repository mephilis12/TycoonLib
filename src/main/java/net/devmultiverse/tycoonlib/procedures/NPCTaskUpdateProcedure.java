package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

public class NPCTaskUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("debugTick", (entity.getPersistentData().getDouble("debugTick") + 1));
		if (entity.getPersistentData().getDouble("debugTick") % 100 == 0) {
			entity.getPersistentData().putBoolean("hasTaskCompleted", true);
		}
	}
}
