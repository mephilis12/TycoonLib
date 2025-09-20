package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.init.TycoonlibModItems;

import java.util.function.Supplier;
import java.util.Map;

public class RestaurantTitleProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == TycoonlibModItems.RESTAURANT_BLUEPRINT
				.get()) {
			if (((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getDisplayName().getString())
					.equals(new ItemStack(TycoonlibModItems.RESTAURANT_BLUEPRINT.get()).getDisplayName().getString())) {
				return "Untitled Restaurant";
			}
			return ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getDisplayName().getString()).substring(1,
					(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getDisplayName().getString())).length() - 1);
		}
		return "";
	}
}
