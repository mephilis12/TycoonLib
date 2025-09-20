package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class RestaurantLevel4CheckProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return !(4 <= ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("level") instanceof IntegerProperty _getip1 ? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip1) : -1));
	}
}
