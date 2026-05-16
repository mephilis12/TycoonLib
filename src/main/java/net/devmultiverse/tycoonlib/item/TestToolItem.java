
package net.devmultiverse.tycoonlib.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TestToolItem extends Item {
	public TestToolItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}
