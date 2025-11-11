package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class AdultTaskManagerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String GetBlockData = "";
		if (("GetEntryPass").equals(entity.getPersistentData().getString("CurrentTask"))) {
			if (!entity.getPersistentData().getBoolean("InChair")) {
				GetBlockData = FindBlockProcedure.execute(world, x, y, z, true, "tycoonlib:cash_register");
				if (("True").equals(GetBlockData.substring((int) GetBlockData.indexOf("T") + "T".length(), (int) GetBlockData.lastIndexOf("T")))) {
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo(ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("X") + "X".length(), (int) GetBlockData.lastIndexOf("X"))),
								ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Y") + "Y".length(), (int) GetBlockData.lastIndexOf("Y"))),
								ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Z") + "Z".length(), (int) GetBlockData.lastIndexOf("Z"))), 1);
					if (2 > new Vec3(x, y, z).distanceTo(new Vec3((ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("X") + "X".length(), (int) GetBlockData.lastIndexOf("X"))) + 0.5),
							ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Y") + "Y".length(), (int) GetBlockData.lastIndexOf("Y"))),
							(ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Z") + "Z".length(), (int) GetBlockData.lastIndexOf("Z"))) + 0.5)))) {
						entity.getPersistentData().putString("CurrentTask", "FindChair");
					}
				}
			}
		} else if (("FindChair").equals(entity.getPersistentData().getString("CurrentTask"))) {
			if (entity.getPersistentData().getBoolean("foundChair")) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("chairPositionX")), (entity.getPersistentData().getDouble("chairPositionY")), (entity.getPersistentData().getDouble("chairPositionZ")), 1);
				if (2 > new Vec3(x, y, z)
						.distanceTo(new Vec3((entity.getPersistentData().getDouble("chairPositionX") + 0.5), (entity.getPersistentData().getDouble("chairPositionY")), (entity.getPersistentData().getDouble("chairPositionZ") + 0.5)))) {
					entity.getPersistentData().putBoolean("InChair", true);
					entity.getPersistentData().putString("CurrentTask", "AskForFood");
					{
						Entity _ent = entity;
						_ent.teleportTo((entity.getPersistentData().getDouble("chairPositionX") + 0.5), (entity.getPersistentData().getDouble("chairPositionY") + 0.625), (entity.getPersistentData().getDouble("chairPositionZ") + 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("chairPositionX") + 0.5), (entity.getPersistentData().getDouble("chairPositionY") + 0.625),
									(entity.getPersistentData().getDouble("chairPositionZ") + 0.5), _ent.getYRot(), _ent.getXRot());
					}
				}
			} else {
				GetBlockData = FindBlockProcedure.execute(world, x, y, z, true, "tycoonlib:chair");
				if (("True").equals(GetBlockData.substring((int) GetBlockData.indexOf("T") + "T".length(), (int) GetBlockData.lastIndexOf("T")))) {
					{
						BlockPos _pos = BlockPos.containing(ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("X") + "X".length(), (int) GetBlockData.lastIndexOf("X"))),
								ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Y") + "Y".length(), (int) GetBlockData.lastIndexOf("Y"))),
								ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Z") + "Z".length(), (int) GetBlockData.lastIndexOf("Z"))));
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("claimed") instanceof BooleanProperty _booleanProp)
							world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
					}
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo(ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("X") + "X".length(), (int) GetBlockData.lastIndexOf("X"))),
								ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Y") + "Y".length(), (int) GetBlockData.lastIndexOf("Y"))),
								ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Z") + "Z".length(), (int) GetBlockData.lastIndexOf("Z"))), 1);
					entity.getPersistentData().putDouble("chairPositionX", ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("X") + "X".length(), (int) GetBlockData.lastIndexOf("X"))));
					entity.getPersistentData().putDouble("chairPositionY", ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Y") + "Y".length(), (int) GetBlockData.lastIndexOf("Y"))));
					entity.getPersistentData().putDouble("chairPositionZ", ConvertStringToNumberProcedure.execute(GetBlockData.substring((int) GetBlockData.indexOf("Z") + "Z".length(), (int) GetBlockData.lastIndexOf("Z"))));
					entity.getPersistentData().putBoolean("foundChair", true);
				}
			}
		} else if (("AskForFood").equals(entity.getPersistentData().getString("CurrentTask"))) {
			if (entity.getPersistentData().getBoolean("InChair")) {
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getPersistentData().getDouble("chairPositionX") + 0.5), (entity.getPersistentData().getDouble("chairPositionY") + 0.625), (entity.getPersistentData().getDouble("chairPositionZ") + 0.5));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("chairPositionX") + 0.5), (entity.getPersistentData().getDouble("chairPositionY") + 0.625),
								(entity.getPersistentData().getDouble("chairPositionZ") + 0.5), _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
