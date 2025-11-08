package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.AdultEntity;

public class AdultStateManagerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("InChair")) {
			if (entity instanceof AdultEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AdultEntity.DATA_animation, 7);
		} else {
			if (entity instanceof AdultEntity _datEntSetI)
				_datEntSetI.getEntityData().set(AdultEntity.DATA_animation, 0);
			if (0.0025 < entity.getDeltaMovement().z() || 0.0025 < entity.getDeltaMovement().x()) {
				if (entity instanceof AdultEntity _datEntSetI)
					_datEntSetI.getEntityData().set(AdultEntity.DATA_animation, 1);
			}
		}
	}
}
