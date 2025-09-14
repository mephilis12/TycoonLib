
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.devmultiverse.tycoonlib.block.WoodenStoolBlock;
import net.devmultiverse.tycoonlib.block.RoomAirBlock;
import net.devmultiverse.tycoonlib.block.RemoveBuildAirBlock;
import net.devmultiverse.tycoonlib.block.CrappyTableBlock;
import net.devmultiverse.tycoonlib.block.CrappyOpenSignBlock;
import net.devmultiverse.tycoonlib.block.CrappyFridgeBlock;
import net.devmultiverse.tycoonlib.block.CrappyChairBlock;
import net.devmultiverse.tycoonlib.block.CrappyCashRegisterBlock;
import net.devmultiverse.tycoonlib.block.CrappyCarouselBlock;
import net.devmultiverse.tycoonlib.block.CrappyBallpitBlock;
import net.devmultiverse.tycoonlib.block.CrappyArcadeBlock;
import net.devmultiverse.tycoonlib.block.CounterBlock;
import net.devmultiverse.tycoonlib.block.BuildRoomAirBlock;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TycoonlibMod.MODID);
	public static final RegistryObject<Block> ROOM_AIR = REGISTRY.register("room_air", () -> new RoomAirBlock());
	public static final RegistryObject<Block> BUILD_ROOM_AIR = REGISTRY.register("build_room_air", () -> new BuildRoomAirBlock());
	public static final RegistryObject<Block> REMOVE_BUILD_AIR = REGISTRY.register("remove_build_air", () -> new RemoveBuildAirBlock());
	public static final RegistryObject<Block> COUNTER = REGISTRY.register("counter", () -> new CounterBlock());
	public static final RegistryObject<Block> CRAPPY_CAROUSEL = REGISTRY.register("crappy_carousel", () -> new CrappyCarouselBlock());
	public static final RegistryObject<Block> CRAPPY_CASH_REGISTER = REGISTRY.register("crappy_cash_register", () -> new CrappyCashRegisterBlock());
	public static final RegistryObject<Block> CRAPPY_FRIDGE = REGISTRY.register("crappy_fridge", () -> new CrappyFridgeBlock());
	public static final RegistryObject<Block> CRAPPY_CHAIR = REGISTRY.register("crappy_chair", () -> new CrappyChairBlock());
	public static final RegistryObject<Block> CRAPPY_ARCADE = REGISTRY.register("crappy_arcade", () -> new CrappyArcadeBlock());
	public static final RegistryObject<Block> CRAPPY_TABLE = REGISTRY.register("crappy_table", () -> new CrappyTableBlock());
	public static final RegistryObject<Block> CRAPPY_BALLPIT = REGISTRY.register("crappy_ballpit", () -> new CrappyBallpitBlock());
	public static final RegistryObject<Block> CRAPPY_OPEN_SIGN = REGISTRY.register("crappy_open_sign", () -> new CrappyOpenSignBlock());
	public static final RegistryObject<Block> WOODEN_STOOL = REGISTRY.register("wooden_stool", () -> new WoodenStoolBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
