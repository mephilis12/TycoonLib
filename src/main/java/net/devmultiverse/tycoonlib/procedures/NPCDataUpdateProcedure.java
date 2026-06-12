package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;
import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;

import java.util.function.BiFunction;
import java.util.UUID;

public class NPCDataUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xC = 0;
		double yC = 0;
		double zC = 0;
		Entity UUIDEntity = null;
		if (entity.getPersistentData().getBoolean("hasTaskCompleted")) {
			if (("marketSeller").equals(entity.getPersistentData().getString("type"))) {
				if (("clockInTask").equals(entity.getPersistentData().getString("currentTask"))) {
					entity.getPersistentData().putString("currentTask", "jobTask");
					entity.getPersistentData().putBoolean("hasTaskCompleted", false);
				} else if (("jobTask").equals(entity.getPersistentData().getString("currentTask"))) {
					entity.getPersistentData().putString("currentTask", "clockOutTask");
					entity.getPersistentData().putBoolean("hasTaskCompleted", false);
				} else if (("clockOutTask").equals(entity.getPersistentData().getString("currentTask"))) {
					entity.getPersistentData().putString("currentTask", "exitTask");
					entity.getPersistentData().putBoolean("hasTaskCompleted", false);
				}
			} else {
				if (("child").equals(entity.getPersistentData().getString("type"))) {
					if (("findParentEnterTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "randomTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("randomTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "eatAtTableWithParent");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("eatAtTableWithParent").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "findParentExitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("findParentExitTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				} else if (("adult").equals(entity.getPersistentData().getString("type"))) {
					if (("payToEnterTask").equals(entity.getPersistentData().getString("currentTask"))) {
						if (entity.getPersistentData().getBoolean("foundDisToCTarget")) {
							UUIDEntity = (new BiFunction<LevelAccessor, String, Entity>() {
								@Override
								public Entity apply(LevelAccessor levelAccessor, String uuid) {
									if (levelAccessor instanceof ServerLevel serverLevel) {
										try {
											return serverLevel.getEntity(UUID.fromString(uuid));
										} catch (Exception e) {
										}
									}
									return null;
								}
							}).apply(world, (entity.getPersistentData().getString("cTarget")));
							if (!(UUIDEntity == null)) {
								if (entity instanceof Mob _entity)
									_entity.getNavigation().moveTo((UUIDEntity.getX()), (UUIDEntity.getY()), (UUIDEntity.getZ()), 1);
								if (1.5 >= new Vec3(x, y, z).distanceTo(new Vec3((UUIDEntity.getX()), (UUIDEntity.getY()), (UUIDEntity.getZ())))) {
									entity.getPersistentData().putString("currentTask", "eatTask");
									entity.getPersistentData().putBoolean("hasTaskCompleted", false);
									entity.getPersistentData().putBoolean("foundDisToCTarget", false);
								}
							} else {
								entity.getPersistentData().putString("currentTask", "exitTask");
								entity.getPersistentData().putBoolean("hasTaskCompleted", false);
								entity.getPersistentData().putBoolean("foundDisToCTarget", false);
							}
						} else {
							int horizontalRadiusSquare = (int) 20 - 1;
							int verticalRadiusSquare = (int) 3 - 1;
							int yIterationsSquare = verticalRadiusSquare;
							for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
								for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
									for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
										// Execute the desired statements within the square/cube
										if (TycoonlibModBlocks.CRAPPY_CASH_REGISTER.get() == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
											if (world instanceof ServerLevel _serverLevel) {
												Entity entityinstance = TycoonlibModEntities.LOCATOR_ENTITY.get().create(_serverLevel, null, null, BlockPos.containing(x + xi, y + i, z + zi), MobSpawnType.MOB_SUMMONED, false, false);
												if (entityinstance != null) {
													entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
													entityinstance.getPersistentData().putString("target", (entity.getStringUUID()));
													if (entity.getPersistentData().getDouble("disToCTarget") > new Vec3(x, y, z).distanceTo(new Vec3((entityinstance.getX()), (entityinstance.getY()), (entityinstance.getZ())))) {
														entity.getPersistentData().putString("cTarget", (entityinstance.getStringUUID()));
														entity.getPersistentData().putDouble("disToCTarget", new Vec3(x, y, z).distanceTo(new Vec3((entityinstance.getX()), (entityinstance.getY()), (entityinstance.getZ()))));
														entity.getPersistentData().putBoolean("foundDisToCTarget", true);
													}
													_serverLevel.addFreshEntity(entityinstance);
												}
											}
										}
									}
								}
							}
						}
					} else if (("eatTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "randomTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("randomTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				} else if (("staff").equals(entity.getPersistentData().getString("type"))) {
					if (("clockInTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "jobTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("jobTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "clockOutTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					} else if (("clockOutTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				} else if (("inspector").equals(entity.getPersistentData().getString("type"))) {
					if (("inspectTask").equals(entity.getPersistentData().getString("currentTask"))) {
						entity.getPersistentData().putString("currentTask", "exitTask");
						entity.getPersistentData().putBoolean("hasTaskCompleted", false);
					}
				}
			}
			if (("exitTask").equals(entity.getPersistentData().getString("currentTask"))) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}
