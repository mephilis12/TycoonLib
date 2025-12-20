package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;

public class ShopPageLeftProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("page", (entity.getPersistentData().getDouble("page") - 1));
		if (entity.getPersistentData().getDouble("page") == -1) {
			entity.getPersistentData().putDouble("page", (entity.getPersistentData().getDouble("max_pages")));
		}
		FindExampleShopItemsProcedure.execute(entity, entity.getPersistentData().getDouble("page"));
	}
}
