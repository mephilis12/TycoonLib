package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class RemoveAirOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		CheckRemoveRoomProcedure.execute(world, x + 1, y, z);
		CheckRemoveRoomProcedure.execute(world, x - 1, y, z);
		CheckRemoveRoomProcedure.execute(world, x, y + 1, z);
		CheckRemoveRoomProcedure.execute(world, x, y - 1, z);
		CheckRemoveRoomProcedure.execute(world, x, y, z + 1);
		CheckRemoveRoomProcedure.execute(world, x, y, z - 1);
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
	}
}
