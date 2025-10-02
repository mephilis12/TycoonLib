package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;

public class BlueprintTooltipProcedure {
	public static String execute(ItemStack itemstack) {
		double blockScaleX = 0;
		double blockScaleZ = 0;
		if (itemstack.getOrCreateTag().getDouble("block-1-x") < itemstack.getOrCreateTag().getDouble("block-2-x")) {
			blockScaleX = itemstack.getOrCreateTag().getDouble("block-2-x") - itemstack.getOrCreateTag().getDouble("block-1-x");
		} else {
			blockScaleX = itemstack.getOrCreateTag().getDouble("block-1-x") - itemstack.getOrCreateTag().getDouble("block-2-x");
		}
		if (itemstack.getOrCreateTag().getDouble("block-1-z") < itemstack.getOrCreateTag().getDouble("block-2-z")) {
			blockScaleZ = itemstack.getOrCreateTag().getDouble("block-2-z") - itemstack.getOrCreateTag().getDouble("block-1-z");
		} else {
			blockScaleZ = itemstack.getOrCreateTag().getDouble("block-1-z") - itemstack.getOrCreateTag().getDouble("block-2-z");
		}
		return new java.text.DecimalFormat("#").format(blockScaleX + 1) + "x" + new java.text.DecimalFormat("#").format(blockScaleZ + 1);
	}
}
