package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

public class NPCDataUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("hasTaskCompleted")) {
			if (("marketSeller").equals(entity.getPersistentData().getString("type"))) {
				if (("clockInTask").equals(entity.getPersistentData().getString("currentTask"))) {
					entity.getPersistentData().putString("currentTask", "jobTask");
					entity.getPersistentData().putBoolean("hasTaskCompleted", false);
				} else if (("jobTask").equals(entity.getPersistentData().getString("currentTask"))) {
					entity.getPersistentData().putString("currentTask", "clockOutTask");
					entity.getPersistentData().putBoolean("hasTaskCompleted", false);
				} else if (("clockOutTask").equals(entity.getPersistentData().getString("currentTask"))) {
					entity.getPersistentData().putString("currentTask", "exitTask");
					entity.getPersistentData().putBoolean("hasTaskCompleted", false);
				}
			} else {
				if (("child").equals(entity.getPersistentData().getString("type"))) {
					if (("findParentEnterTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "randomTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("randomTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "eatAtTableWithParent");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("eatAtTableWithParent").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "findParentExitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("findParentExitTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				} else if (("adult").equals(entity.getPersistentData().getString("type"))) {
					if (("findParentEnterTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "eatTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("eatTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "randomTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("randomTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				} else if (("staff").equals(entity.getPersistentData().getString("type"))) {
					if (("clockInTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "jobTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("jobTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "clockOutTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("clockOutTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				} else if (("inspector").equals(entity.getPersistentData().getString("type"))) {
					if (("inspectTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				}
			}
			if (("exitTask").equals(entity.getPersistentData().getString("currentTask"))) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
