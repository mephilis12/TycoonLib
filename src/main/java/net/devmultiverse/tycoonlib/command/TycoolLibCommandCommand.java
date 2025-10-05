
package net.devmultiverse.tycoonlib.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.devmultiverse.tycoonlib.procedures.SetBlueprintStarProcedure;
import net.devmultiverse.tycoonlib.procedures.SetBlueprintLevelProcedure;
import net.devmultiverse.tycoonlib.procedures.SetBlueprintKitchenProcedure;
import net.devmultiverse.tycoonlib.procedures.SetBlueprintEmptyProcedure;
import net.devmultiverse.tycoonlib.procedures.ForceRestirantDifficultyProcedure;
import net.devmultiverse.tycoonlib.procedures.ForceRestirantDifficultyActiveProcedure;
import net.devmultiverse.tycoonlib.procedures.AddBlueprintStarProcedure;
import net.devmultiverse.tycoonlib.procedures.AddBlueprintLevelProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class TycoolLibCommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("tycoon_lib").requires(s -> s.hasPermission(2)).then(Commands.literal("restrant_settings").then(Commands.literal("blueprint")
				.then(Commands.literal("level").then(Commands.literal("set").then(Commands.argument("entity", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0, 10)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetBlueprintLevelProcedure.execute(arguments);
					return 0;
				})))).then(Commands.literal("add").then(Commands.argument("entity", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					AddBlueprintLevelProcedure.execute(arguments);
					return 0;
				}))))).then(Commands.literal("star").then(Commands.literal("set").then(Commands.argument("entity", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg(0, 10)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetBlueprintStarProcedure.execute(arguments);
					return 0;
				})))).then(Commands.literal("add").then(Commands.argument("entity", EntityArgument.player()).then(Commands.argument("number", DoubleArgumentType.doubleArg()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					AddBlueprintStarProcedure.execute(arguments);
					return 0;
				}))))).then(Commands.literal("room").then(Commands.literal("set").then(Commands.argument("entity", EntityArgument.player()).then(Commands.literal("empty").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetBlueprintEmptyProcedure.execute(arguments);
					return 0;
				})).then(Commands.literal("kitchen").executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetBlueprintKitchenProcedure.execute(arguments);
					return 0;
				}))))))).then(Commands.literal("game_settings").then(Commands.literal("forced_difficulty").then(Commands.argument("number", DoubleArgumentType.doubleArg(1, 3)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					ForceRestirantDifficultyProcedure.execute(arguments, entity);
					return 0;
				})).then(Commands.argument("active", BoolArgumentType.bool()).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					ForceRestirantDifficultyActiveProcedure.execute(arguments, entity);
					return 0;
				})))));
	}
}
