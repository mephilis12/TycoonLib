package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

public class ShopItemCostProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("0").format(entity.getPersistentData().getDouble("shop_item_cost"));
	}
}
