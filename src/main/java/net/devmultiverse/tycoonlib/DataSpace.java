package net.devmultiverse.tycoonlib;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class DataSpace {
	public record ShopItem(
        ResourceLocation item,
        int cost,
        int stack
	) {}
	public record ShopData(
		List<ResourceLocation> blocks,
		List<ResourceLocation> entities,
        ResourceLocation texture,
        List<ShopItem> items
	) {}
	public record SalvageItem(
        ResourceLocation item,
        int sell
	) {}
	public record SalvageData(
		boolean replace,
        List<SalvageItem> values
	) {}

}
