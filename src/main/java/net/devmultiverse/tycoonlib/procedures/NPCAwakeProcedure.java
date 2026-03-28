package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.TycoonlibMod;

public class NPCAwakeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("emotions", "normal");
		entity.getPersistentData().putString("type", "adult");
		if (("marketSeller").equals(entity.getPersistentData().getString("type"))) {
			TycoonlibMod.LOGGER.info("Spawn At Corresponding Building");
			entity.getPersistentData().putString("currentTask", "clockInTask");
			entity.getPersistentData().putBoolean("hasTaskCompleted", false);
		} else {
			TycoonlibMod.LOGGER.info("Spawn At Entrance");
			if (("child").equals(entity.getPersistentData().getString("type"))) {
				entity.getPersistentData().putString("currentTask", "findParentEnterTask");
				entity.getPersistentData().putBoolean("hasTaskCompleted", false);
			} else if (("adult").equals(entity.getPersistentData().getString("type"))) {
				entity.getPersistentData().putString("currentTask", "payToEnterTask");
				entity.getPersistentData().putBoolean("hasTaskCompleted", false);
			} else if (("staff").equals(entity.getPersistentData().getString("type"))) {
				entity.getPersistentData().putString("currentTask", "clockInTask");
				entity.getPersistentData().putBoolean("hasTaskCompleted", false);
			} else if (("inspector").equals(entity.getPersistentData().getString("type"))) {
				entity.getPersistentData().putString("currentTask", "inspectTask");
				entity.getPersistentData().putBoolean("hasTaskCompleted", false);
			}
		}
	}
}
