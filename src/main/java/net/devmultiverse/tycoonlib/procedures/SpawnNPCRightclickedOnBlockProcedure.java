package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.world.inventory.SpawnNPCGUIMenu;
import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;

import io.netty.buffer.Unpooled;

public class SpawnNPCRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("SpawnNPCGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SpawnNPCGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if (itemstack.getOrCreateTag().getBoolean("IsChild")) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = TycoonlibModEntities.CHILD.get().create(_serverLevel, null, null, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						entityinstance.getPersistentData().putString("CurrentTask", (itemstack.getOrCreateTag().getString("CurrentTask")));
						entityinstance.getPersistentData().putBoolean("CantLeave", true);
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
			} else {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = TycoonlibModEntities.ADULT.get().create(_serverLevel, null, null, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						entityinstance.getPersistentData().putDouble("Skin", (Mth.nextInt(RandomSource.create(), 0, 8)));
						entityinstance.getPersistentData().putString("CurrentTask", (itemstack.getOrCreateTag().getString("CurrentTask")));
						entityinstance.getPersistentData().putBoolean("CantLeave", true);
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
			}
		}
	}
}
