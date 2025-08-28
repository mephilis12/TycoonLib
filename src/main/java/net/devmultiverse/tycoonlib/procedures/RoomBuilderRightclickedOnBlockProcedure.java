package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class RoomBuilderRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		if (direction == Direction.UP && (world.getBlockState(BlockPos.containing(x, y + 1, z))).canBeReplaced()) {
			world.setBlock(BlockPos.containing(x, y + 1, z), TycoonlibModBlocks.BUILD_ROOM_AIR.get().defaultBlockState(), 3);
			TycoonlibMod.queueServerWork(10, () -> {
				if (TycoonlibModBlocks.ROOM_AIR.get() == (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Created Room"), true);
				} else {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Failed to Created Room"), true);
				}
			});
		}
	}
}
