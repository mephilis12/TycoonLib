package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;

public class SpawnAdultGuestRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _serverLevel) {
			Entity entityinstance = TycoonlibModEntities.ADULT.get().create(_serverLevel, null, null, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED, false, false);
			if (entityinstance != null) {
				entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
				entityinstance.getPersistentData().putString("CurrentTask", "FindChair");
				entityinstance.getPersistentData().putBoolean("CantLeave", true);
				_serverLevel.addFreshEntity(entityinstance);
			}
		}
	}
}
