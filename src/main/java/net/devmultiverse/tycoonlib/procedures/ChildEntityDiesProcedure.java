package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class ChildEntityDiesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("InChair")) {
			{
				BlockPos _pos = BlockPos.containing(entity.getPersistentData().getDouble("chairPositionX"), entity.getPersistentData().getDouble("chairPositionY"), entity.getPersistentData().getDouble("chairPositionZ"));
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("claimed") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		}
		if (entity.getPersistentData().getBoolean("PlayingArcade")) {
			{
				BlockPos _pos = BlockPos.containing(entity.getPersistentData().getDouble("arcadePositionX"), entity.getPersistentData().getDouble("arcadePositionY"), entity.getPersistentData().getDouble("arcadePositionZ"));
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("claimed") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		}
	}
}
