
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.devmultiverse.tycoonlib.block.RoomAirBlock;
import net.devmultiverse.tycoonlib.block.RemoveBuildAirBlock;
import net.devmultiverse.tycoonlib.block.BuildRoomAirBlock;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TycoonlibMod.MODID);
	public static final RegistryObject<Block> ROOM_AIR = REGISTRY.register("room_air", () -> new RoomAirBlock());
	public static final RegistryObject<Block> BUILD_ROOM_AIR = REGISTRY.register("build_room_air", () -> new BuildRoomAirBlock());
	public static final RegistryObject<Block> REMOVE_BUILD_AIR = REGISTRY.register("remove_build_air", () -> new RemoveBuildAirBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
