package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;

public class RestaurantBoardOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemSlotChangedRestaurantBoardProcedure.execute(world, x, y, z);
		FullRestaurantItemsProcedure.execute(world, x, y, z);
		RestaurantItemsProcedure.execute(world, x, y, z);
	}
}
