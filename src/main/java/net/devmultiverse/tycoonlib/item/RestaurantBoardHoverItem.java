
package net.devmultiverse.tycoonlib.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RestaurantBoardHoverItem extends Item {
	public RestaurantBoardHoverItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
