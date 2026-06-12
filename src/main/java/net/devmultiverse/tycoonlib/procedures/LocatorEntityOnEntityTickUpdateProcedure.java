package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import java.util.function.BiFunction;
import java.util.UUID;

public class LocatorEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(((new BiFunction<LevelAccessor, String, Entity>() {
			@Override
			public Entity apply(LevelAccessor levelAccessor, String uuid) {
				if (levelAccessor instanceof ServerLevel serverLevel) {
					try {
						return serverLevel.getEntity(UUID.fromString(uuid));
					} catch (Exception e) {
					}
				}
				return null;
			}
		}).apply(world, (entity.getPersistentData().getString("target")))) == null)) {
			if (!(entity == ((new BiFunction<LevelAccessor, String, Entity>() {
				@Override
				public Entity apply(LevelAccessor levelAccessor, String uuid) {
					if (levelAccessor instanceof ServerLevel serverLevel) {
						try {
							return serverLevel.getEntity(UUID.fromString(uuid));
						} catch (Exception e) {
						}
					}
					return null;
				}
			}).apply(world, (((new BiFunction<LevelAccessor, String, Entity>() {
				@Override
				public Entity apply(LevelAccessor levelAccessor, String uuid) {
					if (levelAccessor instanceof ServerLevel serverLevel) {
						try {
							return serverLevel.getEntity(UUID.fromString(uuid));
						} catch (Exception e) {
						}
					}
					return null;
				}
			}).apply(world, (entity.getPersistentData().getString("target")))).getPersistentData().getString("cTarget"))))) && ((new BiFunction<LevelAccessor, String, Entity>() {
				@Override
				public Entity apply(LevelAccessor levelAccessor, String uuid) {
					if (levelAccessor instanceof ServerLevel serverLevel) {
						try {
							return serverLevel.getEntity(UUID.fromString(uuid));
						} catch (Exception e) {
						}
					}
					return null;
				}
			}).apply(world, (entity.getPersistentData().getString("target")))).getPersistentData().getBoolean("foundDisToCTarget")) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (!world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
