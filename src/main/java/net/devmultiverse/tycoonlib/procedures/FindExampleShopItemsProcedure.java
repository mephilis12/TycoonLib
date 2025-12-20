package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

import net.devmultiverse.tycoonlib.TycoonlibMod;
import net.devmultiverse.tycoonlib.ShopReloadListener;
import net.devmultiverse.tycoonlib.DataSpace;

public class FindExampleShopItemsProcedure {
	public static void execute(Entity entity, double id) {
		if (entity == null)
			return;
		String namespace = "";
		String shop = "";
		shop = entity.getPersistentData().getString("shop_gui_name");
		namespace = entity.getPersistentData().getString("shop_gui_namespace");
		DataSpace.ShopData shopData = ShopReloadListener.SHOPS.get(new ResourceLocation(namespace, shop));
		entity.getPersistentData().putDouble("max_pages", (shopData.items().size() - 1));
		if (id < shopData.items().size()) {
			TycoonlibMod.LOGGER.info(shopData.items().get((int) id).item());
			entity.getPersistentData().putString("shop_item_namespace", shopData.items().get((int) id).item().getNamespace());
			entity.getPersistentData().putString("shop_item_name", shopData.items().get((int) id).item().getPath());
			entity.getPersistentData().putDouble("shop_item_cost", shopData.items().get((int) id).cost());
			entity.getPersistentData().putDouble("shop_item_amount", shopData.items().get((int) id).stack());
		}
	}
}
