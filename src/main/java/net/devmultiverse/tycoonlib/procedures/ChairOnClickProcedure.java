package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;
import net.devmultiverse.tycoonlib.entity.ChairEntity;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.List;
import java.util.Comparator;

public class ChairOnClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = TycoonlibModEntities.CHAIR.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		TycoonlibMod.queueServerWork(1, () -> {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof ChairEntity) {
						entity.startRiding(entityiterator);
						if (entityiterator instanceof ChairEntity _datEntSetL)
							_datEntSetL.getEntityData().set(ChairEntity.DATA_Used, true);
					}
				}
			}
		});
	}
}
