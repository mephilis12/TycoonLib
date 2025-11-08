package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;

public class AdultOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		AdultTaskManagerProcedure.execute(world, x, y, z, entity);
		AdultStateManagerProcedure.execute(entity);
		AdultLockerProcedure.execute(entity);
		if (!((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("xBoardPosition"), entity.getPersistentData().getDouble("yBoardPosition"), entity.getPersistentData().getDouble("zBoardPosition"))))
				.getBlock() == TycoonlibModBlocks.RESTAURANT_BOARD.get()) && entity.getPersistentData().getDouble("adult_age") > 10) {
			if (entity.getPersistentData().getBoolean("InChair")) {
				entity.getPersistentData().putBoolean("InChair", false);
			}
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("xSpawn") + 0.5), (entity.getPersistentData().getDouble("ySpawn")), (entity.getPersistentData().getDouble("zSpawn") + 0.5), 1);
			if (1.25 > new Vec3(x, y, z).distanceTo(new Vec3((entity.getPersistentData().getDouble("xSpawn") + 0.5), (entity.getPersistentData().getDouble("ySpawn")), (entity.getPersistentData().getDouble("zSpawn") + 0.5)))) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		entity.getPersistentData().putDouble("adult_age", (entity.getPersistentData().getDouble("adult_age") + 1));
	}
}
