package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.world.inventory.ShopGUIMenu;

import io.netty.buffer.Unpooled;

public class OpenShopBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String namespace, String shop) {
		if (entity == null || namespace == null || shop == null)
			return;
		entity.getPersistentData().putDouble("page", 0);
		entity.getPersistentData().putString("shop_gui_namespace", namespace);
		entity.getPersistentData().putString("shop_gui_name", shop);
		FindExampleShopItemsProcedure.execute(entity, 0);
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("ShopGUI");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new ShopGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}
