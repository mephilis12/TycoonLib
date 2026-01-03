package net.devmultiverse.tycoonlib;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class DataSpace {
	public record ShopItem(
        ResourceLocation item,
		String line1,
		String line2,
		String line3,
		String line4,
		String line5,
        int cost,
        int stack
	) {}
	public record ShopData(
			String name,
			boolean override,
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
