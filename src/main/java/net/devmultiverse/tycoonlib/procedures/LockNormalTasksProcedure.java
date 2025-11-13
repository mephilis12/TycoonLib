package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

public class LockNormalTasksProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity.getPersistentData().getBoolean("InChair") || entity.getPersistentData().getBoolean("PlayingArcade"));
	}
}
