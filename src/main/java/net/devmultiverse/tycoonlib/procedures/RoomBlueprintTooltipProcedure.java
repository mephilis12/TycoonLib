package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;

public class RoomBlueprintTooltipProcedure {
	public static String execute(ItemStack itemstack) {
		return "Position 1 (" + itemstack.getOrCreateTag().getDouble("block-1-x") + ", " + itemstack.getOrCreateTag().getDouble("block-1-z") + ")" + "\n" + "Position 2 (" + itemstack.getOrCreateTag().getDouble("block-2-x") + ", "
				+ itemstack.getOrCreateTag().getDouble("block-2-z") + ")";
	}
}
