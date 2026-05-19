package net.devmultiverse.tycoonlib.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;
import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;
import net.devmultiverse.tycoonlib.entity.LocatorEntityEntity;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class NPCDataUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xC = 0;
		double yC = 0;
		double zC = 0;
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
												_serverLevel.addFreshEntity(entityinstance);
											}
										}
										if (!world.getEntitiesOfClass(LocatorEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
											xC = new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[0]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[0]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[0]")).lastIndexOf("d")));
											yC = new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[1]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[1]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[1]")).lastIndexOf("d")));
											zC = new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).lastIndexOf("d")));
											TycoonlibMod.LOGGER.info((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).lastIndexOf("d")));
											if (entity instanceof Mob _entity)
												_entity.getNavigation().moveTo((xC - (new Object() {
													public Direction getDirection(BlockState _bs) {
														Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
														if (_prop instanceof DirectionProperty _dp)
															return _bs.getValue(_dp);
														_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
														return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
																? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
																: Direction.NORTH;
													}
												}.getDirection((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))))).getStepX()), yC, (zC - (new Object() {
													public Direction getDirection(BlockState _bs) {
														Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
														if (_prop instanceof DirectionProperty _dp)
															return _bs.getValue(_dp);
														_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
														return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
																? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
																: Direction.NORTH;
													}
												}.getDirection((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))))).getStepZ()), 1);
											entity.getPersistentData().putDouble("xC", new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[0]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[0]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[0]")).lastIndexOf("d"))));
											entity.getPersistentData().putDouble("yC", new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[1]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[1]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[1]")).lastIndexOf("d"))));
											entity.getPersistentData().putDouble("zC", new Object() {
												double convert(String s) {
													try {
														return Double.parseDouble(s.trim());
													} catch (Exception e) {
													}
													return 0;
												}
											}.convert((new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).substring((int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).lastIndexOf(" ") + " ".length(), (int) (new Object() {
												public String getResult(LevelAccessor world, Vec3 pos, String _command) {
													StringBuilder _result = new StringBuilder();
													if (world instanceof ServerLevel _level) {
														CommandSource _dataConsumer = new CommandSource() {
															@Override
															public void sendSystemMessage(Component message) {
																_result.append(message.getString());
															}

															@Override
															public boolean acceptsSuccess() {
																return true;
															}

															@Override
															public boolean acceptsFailure() {
																return true;
															}

															@Override
															public boolean shouldInformAdmins() {
																return false;
															}
														};
														_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(_dataConsumer, pos, Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null), _command);
													}
													return _result.toString();
												}
											}.getResult(world, new Vec3(x, y, z), "data get entity @e[sort=nearest, type=tycoonlib:locator_entity, limit=1, distance=..4] Pos[2]")).lastIndexOf("d"))));
											if (1.5 >= new Vec3(x, y, z).distanceTo(new Vec3((xC - (new Object() {
												public Direction getDirection(BlockState _bs) {
													Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
													if (_prop instanceof DirectionProperty _dp)
														return _bs.getValue(_dp);
													_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
													return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
															? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
															: Direction.NORTH;
												}
											}.getDirection((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))))).getStepX()), yC, (zC - (new Object() {
												public Direction getDirection(BlockState _bs) {
													Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
													if (_prop instanceof DirectionProperty _dp)
														return _bs.getValue(_dp);
													_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
													return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
															? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
															: Direction.NORTH;
												}
											}.getDirection((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))))).getStepZ())))) {
												entity.getPersistentData().putString("currentTask", "eatTask");
												entity.getPersistentData().putBoolean("hasTaskCompleted", false);
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
