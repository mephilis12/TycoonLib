package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.ChairEntity;

public class ChairKillCheckProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ChairEntity _datEntL0 && _datEntL0.getEntityData().get(ChairEntity.DATA_Used)) {
			if ((entity.getFirstPassenger()) == null) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
