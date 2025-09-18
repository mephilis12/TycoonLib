package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class RoomBlueprintFindDataProcedure {
	public static void execute(double x, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			itemstack.getOrCreateTag().putDouble("block-2-x", x);
			itemstack.getOrCreateTag().putDouble("block-2-z", z);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Saved position 2 (" + x + ", " + z + ")")), false);
		} else {
			itemstack.getOrCreateTag().putDouble("block-1-x", x);
			itemstack.getOrCreateTag().putDouble("block-1-z", z);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Saved position 1 (" + x + ", " + z + ")")), false);
		}
	}
}
