
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.devmultiverse.tycoonlib.block.entity.RemoveBuildAirBlockEntity;
import net.devmultiverse.tycoonlib.block.entity.BuildRoomAirBlockEntity;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TycoonlibMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ROOM_AIR = register("room_air", TycoonlibModBlocks.ROOM_AIR, RoomAirBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BUILD_ROOM_AIR = register("build_room_air", TycoonlibModBlocks.BUILD_ROOM_AIR, BuildRoomAirBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REMOVE_BUILD_AIR = register("remove_build_air", TycoonlibModBlocks.REMOVE_BUILD_AIR, RemoveBuildAirBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
