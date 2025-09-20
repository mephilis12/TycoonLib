package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;

public class BlueprintTooltipProcedure {
	public static String execute(ItemStack itemstack) {
		return new java.text.DecimalFormat("#").format(Math.abs(itemstack.getOrCreateTag().getDouble("block-1-x") + itemstack.getOrCreateTag().getDouble("block-2-x"))) + "x"
				+ new java.text.DecimalFormat("#").format(Math.abs(itemstack.getOrCreateTag().getDouble("block-1-z") + itemstack.getOrCreateTag().getDouble("block-2-z")));
	}
}
