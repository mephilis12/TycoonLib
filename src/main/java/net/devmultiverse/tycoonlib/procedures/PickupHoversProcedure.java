package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.item.ItemStack;

import net.devmultiverse.tycoonlib.init.TycoonlibModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PickupHoversProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getItem().getItem());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (TycoonlibModItems.RESTAURANT_BOARD_HOVER.get() == itemstack.getItem()) {
			itemstack.shrink(itemstack.getCount());
		}
	}
}
