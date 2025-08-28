
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.devmultiverse.tycoonlib.item.RoomBuilderItem;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TycoonlibMod.MODID);
	public static final RegistryObject<Item> ROOM_AIR = block(TycoonlibModBlocks.ROOM_AIR);
	public static final RegistryObject<Item> ROOM_BUILDER = REGISTRY.register("room_builder", () -> new RoomBuilderItem());
	public static final RegistryObject<Item> BUILD_ROOM_AIR = block(TycoonlibModBlocks.BUILD_ROOM_AIR);
	public static final RegistryObject<Item> REMOVE_BUILD_AIR = block(TycoonlibModBlocks.REMOVE_BUILD_AIR);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
