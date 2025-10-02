package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.devmultiverse.tycoonlib.init.TycoonlibModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class AddBlueprintStarProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		if (((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "entity");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TycoonlibModItems.RESTAURANT_BLUEPRINT.get()) {
			((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("star", (((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("star") + DoubleArgumentType.getDouble(arguments, "number")));
		} else if (((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "entity");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TycoonlibModItems.RESTAURANT_BLUEPRINT.get()) {
			((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("star", (((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("star") + DoubleArgumentType.getDouble(arguments, "number")));
		} else if (((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "entity");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TycoonlibModItems.ROOM_BLUEPRINT.get()) {
			((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("star", (((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("star") + DoubleArgumentType.getDouble(arguments, "number")));
		} else if (((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "entity");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TycoonlibModItems.ROOM_BLUEPRINT.get()) {
			((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("star", (((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "entity");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("star") + DoubleArgumentType.getDouble(arguments, "number")));
		}
	}
}
