package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;

public class AdultOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("xBoardPosition"), entity.getPersistentData().getDouble("yBoardPosition"), entity.getPersistentData().getDouble("zBoardPosition"))))
				.getBlock() == TycoonlibModBlocks.RESTAURANT_BOARD.get()) && entity.getPersistentData().getDouble("adult_age") > 10) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		AdultStateManagerProcedure.execute(entity);
		AdultLockerProcedure.execute(entity);
		entity.getPersistentData().putDouble("adult_age", (entity.getPersistentData().getDouble("adult_age") + 1));
	}
}
