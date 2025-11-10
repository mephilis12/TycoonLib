package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.AdultEntity;

public class AdultLockerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (0 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.idle");
			}
		} else if (1 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.walk");
			}
		} else if (2 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.moping");
			}
		} else if (3 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.handing");
			}
		} else if (4 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.cash_give");
			}
		} else if (5 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.cash_take");
			}
		} else if (6 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.fix");
			}
		} else if (7 == (entity instanceof AdultEntity _datEntI ? _datEntI.getEntityData().get(AdultEntity.DATA_animation) : 0)) {
			if (entity instanceof AdultEntity) {
				((AdultEntity) entity).setAnimation("animation.model.siting");
			}
		}
	}
}
