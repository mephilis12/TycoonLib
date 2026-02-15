package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.AdultEntity;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class AdultOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TycoonlibMod.queueServerWork(2, () -> {
			if (0 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("stephan");
			} else if (1 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("stelle");
			} else if (2 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("marcelogtoonz");
			} else if (3 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("8bit_ryan");
			} else if (4 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("razzbowski");
			} else if (5 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("corryxkenshin");
			} else if (6 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("vassilisdoragokami");
			} else if (7 == entity.getPersistentData().getDouble("Skin")) {
				if (entity instanceof AdultEntity animatable)
					animatable.setTexture("somethingfunky");
			}
		});
	}
}
