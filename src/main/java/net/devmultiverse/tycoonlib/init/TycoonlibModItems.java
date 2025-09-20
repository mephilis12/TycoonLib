
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.devmultiverse.tycoonlib.item.RoomBlueprintItem;
import net.devmultiverse.tycoonlib.item.RestaurantBoardHoverItem;
import net.devmultiverse.tycoonlib.item.RestaurantBlueprintItem;
import net.devmultiverse.tycoonlib.block.display.CrappyCarouselDisplayItem;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TycoonlibMod.MODID);
	public static final RegistryObject<Item> COUNTER = block(TycoonlibModBlocks.COUNTER);
	public static final RegistryObject<Item> CRAPPY_CAROUSEL = REGISTRY.register(TycoonlibModBlocks.CRAPPY_CAROUSEL.getId().getPath(), () -> new CrappyCarouselDisplayItem(TycoonlibModBlocks.CRAPPY_CAROUSEL.get(), new Item.Properties()));
	public static final RegistryObject<Item> CRAPPY_CASH_REGISTER = block(TycoonlibModBlocks.CRAPPY_CASH_REGISTER);
	public static final RegistryObject<Item> CRAPPY_FRIDGE = block(TycoonlibModBlocks.CRAPPY_FRIDGE);
	public static final RegistryObject<Item> CRAPPY_CHAIR = block(TycoonlibModBlocks.CRAPPY_CHAIR);
	public static final RegistryObject<Item> CRAPPY_ARCADE = block(TycoonlibModBlocks.CRAPPY_ARCADE);
	public static final RegistryObject<Item> CRAPPY_TABLE = block(TycoonlibModBlocks.CRAPPY_TABLE);
	public static final RegistryObject<Item> CRAPPY_BALLPIT = block(TycoonlibModBlocks.CRAPPY_BALLPIT);
	public static final RegistryObject<Item> CRAPPY_OPEN_SIGN = block(TycoonlibModBlocks.CRAPPY_OPEN_SIGN);
	public static final RegistryObject<Item> WOODEN_STOOL = block(TycoonlibModBlocks.WOODEN_STOOL);
	public static final RegistryObject<Item> RESTAURANT_BOARD = block(TycoonlibModBlocks.RESTAURANT_BOARD);
	public static final RegistryObject<Item> RESTAURANT_BLUEPRINT = REGISTRY.register("restaurant_blueprint", () -> new RestaurantBlueprintItem());
	public static final RegistryObject<Item> ROOM_BLUEPRINT = REGISTRY.register("room_blueprint", () -> new RoomBlueprintItem());
	public static final RegistryObject<Item> MANNEQUIN_SPAWN_EGG = REGISTRY.register("mannequin_spawn_egg", () -> new ForgeSpawnEggItem(TycoonlibModEntities.MANNEQUIN, -6057888, -15572359, new Item.Properties()));
	public static final RegistryObject<Item> RESTAURANT_BOARD_HOVER = REGISTRY.register("restaurant_board_hover", () -> new RestaurantBoardHoverItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
