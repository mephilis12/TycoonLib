package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;

public class CheckRemoveRoomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TycoonlibModBlocks.ROOM_AIR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TycoonlibModBlocks.REMOVE_BUILD_AIR.get().defaultBlockState(), 3);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == TycoonlibModBlocks.BUILD_ROOM_AIR.get()) {
			world.setBlock(BlockPos.containing(x, y, z), TycoonlibModBlocks.REMOVE_BUILD_AIR.get().defaultBlockState(), 3);
		}
	}
}
