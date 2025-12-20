
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.devmultiverse.tycoonlib.block.WoodenStoolBlock;
import net.devmultiverse.tycoonlib.block.RestaurantBoardBlock;
import net.devmultiverse.tycoonlib.block.GuestSpawnPlateBlock;
import net.devmultiverse.tycoonlib.block.ExampleShopBlockBlock;
import net.devmultiverse.tycoonlib.block.CrappyTableBlock;
import net.devmultiverse.tycoonlib.block.CrappyFridgeBlock;
import net.devmultiverse.tycoonlib.block.CrappyChairBlock;
import net.devmultiverse.tycoonlib.block.CrappyCashRegisterBlock;
import net.devmultiverse.tycoonlib.block.CrappyCarouselBlock;
import net.devmultiverse.tycoonlib.block.CrappyBallpitBlock;
import net.devmultiverse.tycoonlib.block.CrappyArcadeBlock;
import net.devmultiverse.tycoonlib.block.CounterBlock;
import net.devmultiverse.tycoonlib.block.BatteryTear2Block;
import net.devmultiverse.tycoonlib.block.BatteryTear1Block;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TycoonlibMod.MODID);
	public static final RegistryObject<Block> COUNTER = REGISTRY.register("counter", () -> new CounterBlock());
	public static final RegistryObject<Block> CRAPPY_CAROUSEL = REGISTRY.register("crappy_carousel", () -> new CrappyCarouselBlock());
	public static final RegistryObject<Block> CRAPPY_CASH_REGISTER = REGISTRY.register("crappy_cash_register", () -> new CrappyCashRegisterBlock());
	public static final RegistryObject<Block> CRAPPY_FRIDGE = REGISTRY.register("crappy_fridge", () -> new CrappyFridgeBlock());
	public static final RegistryObject<Block> CRAPPY_CHAIR = REGISTRY.register("crappy_chair", () -> new CrappyChairBlock());
	public static final RegistryObject<Block> CRAPPY_ARCADE = REGISTRY.register("crappy_arcade", () -> new CrappyArcadeBlock());
	public static final RegistryObject<Block> CRAPPY_TABLE = REGISTRY.register("crappy_table", () -> new CrappyTableBlock());
	public static final RegistryObject<Block> CRAPPY_BALLPIT = REGISTRY.register("crappy_ballpit", () -> new CrappyBallpitBlock());
	public static final RegistryObject<Block> WOODEN_STOOL = REGISTRY.register("wooden_stool", () -> new WoodenStoolBlock());
	public static final RegistryObject<Block> RESTAURANT_BOARD = REGISTRY.register("restaurant_board", () -> new RestaurantBoardBlock());
	public static final RegistryObject<Block> GUEST_SPAWN_PLATE = REGISTRY.register("guest_spawn_plate", () -> new GuestSpawnPlateBlock());
	public static final RegistryObject<Block> BATTERY_TEAR_1 = REGISTRY.register("battery_tear_1", () -> new BatteryTear1Block());
	public static final RegistryObject<Block> BATTERY_TEAR_2 = REGISTRY.register("battery_tear_2", () -> new BatteryTear2Block());
	public static final RegistryObject<Block> EXAMPLE_SHOP_BLOCK = REGISTRY.register("example_shop_block", () -> new ExampleShopBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
