package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.ChildEntity;

public class ChildLockerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ChildEntity) {
			((ChildEntity) entity).setAnimation("empty");
		}
		if (0 == (entity instanceof ChildEntity _datEntI ? _datEntI.getEntityData().get(ChildEntity.DATA_animation) : 0)) {
			if (entity instanceof ChildEntity) {
				((ChildEntity) entity).setAnimation("animation.child.idle");
			}
		} else if (1 == (entity instanceof ChildEntity _datEntI ? _datEntI.getEntityData().get(ChildEntity.DATA_animation) : 0)) {
			if (entity instanceof ChildEntity) {
				((ChildEntity) entity).setAnimation("animation.child.walk");
			}
		} else if (2 == (entity instanceof ChildEntity _datEntI ? _datEntI.getEntityData().get(ChildEntity.DATA_animation) : 0)) {
			if (entity instanceof ChildEntity) {
				((ChildEntity) entity).setAnimation("animation.child.sit");
			}
		} else if (3 == (entity instanceof ChildEntity _datEntI ? _datEntI.getEntityData().get(ChildEntity.DATA_animation) : 0)) {
			if (entity instanceof ChildEntity) {
				((ChildEntity) entity).setAnimation("animation.child.eating");
			}
		} else if (4 == (entity instanceof ChildEntity _datEntI ? _datEntI.getEntityData().get(ChildEntity.DATA_animation) : 0)) {
			if (entity instanceof ChildEntity) {
				((ChildEntity) entity).setAnimation("animation.child.arcadeinteract");
			}
		}
	}
}
