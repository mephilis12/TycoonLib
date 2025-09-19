package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.MannequinEntity;

public class MannequinRightClickedOnEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 0) {
			{
				Entity _ent = entity;
				_ent.setYRot(0);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 1);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 1) {
			{
				Entity _ent = entity;
				_ent.setYRot(45);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 2);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 2) {
			{
				Entity _ent = entity;
				_ent.setYRot(90);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 3);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 3) {
			{
				Entity _ent = entity;
				_ent.setYRot(135);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 4);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 4) {
			{
				Entity _ent = entity;
				_ent.setYRot(180);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 5);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 5) {
			{
				Entity _ent = entity;
				_ent.setYRot(225);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 6);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 6) {
			{
				Entity _ent = entity;
				_ent.setYRot(270);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 7);
		} else if ((entity instanceof MannequinEntity _datEntI ? _datEntI.getEntityData().get(MannequinEntity.DATA_rotation) : 0) == 7) {
			{
				Entity _ent = entity;
				_ent.setYRot(315);
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof MannequinEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MannequinEntity.DATA_rotation, 0);
		}
	}
}
