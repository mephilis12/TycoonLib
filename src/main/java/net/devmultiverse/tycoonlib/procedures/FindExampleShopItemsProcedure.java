package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

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
			entity.getPersistentData().putString("shop_item_namespace", shopData.items().get((int) id).item().getNamespace());
			entity.getPersistentData().putString("shop_item_name", shopData.items().get((int) id).item().getPath());
			entity.getPersistentData().putString("shop_background", namespace + ":textures/screens/shop/" + shopData.name());
			entity.getPersistentData().putString("shop_line1", shopData.items().get((int) id).item().toLanguageKey());
			entity.getPersistentData().putString("shop_line2", shopData.items().get((int) id).line1());
			entity.getPersistentData().putString("shop_line3", shopData.items().get((int) id).line2());
			entity.getPersistentData().putString("shop_line4", shopData.items().get((int) id).line3());
			entity.getPersistentData().putString("shop_line5", shopData.items().get((int) id).line4());
			entity.getPersistentData().putString("shop_line6", shopData.items().get((int) id).line5());
			if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_1")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 1);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_2")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 2);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_3")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 3);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_4")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 4);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_5")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 5);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_6")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 6);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_7")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 7);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_8")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 8);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:atmosphere_9")))) {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 9);
			} else {
				entity.getPersistentData().putDouble("shop_item_atmosphere", 0);
			}
			if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_1")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 1);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_2")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 2);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_3")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 3);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_4")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 4);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_5")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 5);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_6")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 6);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_7")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 7);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_8")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 8);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:health_and_safety_9")))) {
				entity.getPersistentData().putDouble("shop_item_health_safety", 9);
			} else {
				entity.getPersistentData().putDouble("shop_item_health_safety", 0);
			}
			if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_1")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 1);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_2")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 2);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_3")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 3);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_4")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 4);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_5")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 5);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_6")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 6);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_7")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 7);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_8")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 8);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:entertainment_9")))) {
				entity.getPersistentData().putDouble("shop_item_entertainment", 9);
			} else {
				entity.getPersistentData().putDouble("shop_item_entertainment", 0);
			}
			if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_1")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 1);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_2")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 2);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_3")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 3);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_4")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 4);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_5")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 5);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_6")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 6);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_7")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 7);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_8")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 8);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH))))
					.is(ItemTags.create(new ResourceLocation("tycoonlib:bonus_revenue_9")))) {
				entity.getPersistentData().putDouble("shop_item_bonus", 9);
			} else {
				entity.getPersistentData().putDouble("shop_item_bonus", 0);
			}
			if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_1")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 1);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_2")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 2);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_3")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 3);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_4")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 4);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_5")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 5);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_6")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 6);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_7")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 7);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_8")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 8);
			} else if (new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation((shopData.items().get((int) id).item().toString()).toLowerCase(java.util.Locale.ENGLISH)))).is(ItemTags.create(new ResourceLocation("tycoonlib:risk_9")))) {
				entity.getPersistentData().putDouble("shop_item_risk", 9);
			} else {
				entity.getPersistentData().putDouble("shop_item_risk", 0);
			}
			entity.getPersistentData().putDouble("shop_item_cost", shopData.items().get((int) id).cost());
			entity.getPersistentData().putDouble("shop_item_amount", shopData.items().get((int) id).stack());
		}
	}
}
