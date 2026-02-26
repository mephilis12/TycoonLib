package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class SeatEntityTickProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.isVehicle()) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else if ((world.getBlockState(BlockPos.containing(x, entity.getPersistentData().getDouble("blockY"), z))).getBlock() == Blocks.AIR) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
