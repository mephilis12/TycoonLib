package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;

public class RoomAirOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBrightness(LightLayer.SKY, BlockPos.containing(x, y, z)) == 15) {
			world.setBlock(BlockPos.containing(x, y, z), TycoonlibModBlocks.REMOVE_BUILD_AIR.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y, z), TycoonlibModBlocks.ROOM_AIR.get().defaultBlockState(), 3);
			CheckFillRoomProcedure.execute(world, x + 1, y, z);
			CheckFillRoomProcedure.execute(world, x - 1, y, z);
			CheckFillRoomProcedure.execute(world, x, y + 1, z);
			CheckFillRoomProcedure.execute(world, x, y - 1, z);
			CheckFillRoomProcedure.execute(world, x, y, z + 1);
			CheckFillRoomProcedure.execute(world, x, y, z - 1);
		}
	}
}
