package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;

public class CheckFillRoomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("tycoonlib:air_blocks")))) {
			world.setBlock(BlockPos.containing(x, y, z), TycoonlibModBlocks.BUILD_ROOM_AIR.get().defaultBlockState(), 3);
		}
	}
}
