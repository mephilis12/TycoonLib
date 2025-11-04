
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.devmultiverse.tycoonlib.block.entity.RestaurantBoardBlockEntity;
import net.devmultiverse.tycoonlib.block.entity.CrappyCarouselTileEntity;
import net.devmultiverse.tycoonlib.block.entity.BatteryTear2BlockEntity;
import net.devmultiverse.tycoonlib.block.entity.BatteryTear1BlockEntity;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TycoonlibMod.MODID);
	public static final RegistryObject<BlockEntityType<CrappyCarouselTileEntity>> CRAPPY_CAROUSEL = REGISTRY.register("crappy_carousel",
			() -> BlockEntityType.Builder.of(CrappyCarouselTileEntity::new, TycoonlibModBlocks.CRAPPY_CAROUSEL.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> RESTAURANT_BOARD = register("restaurant_board", TycoonlibModBlocks.RESTAURANT_BOARD, RestaurantBoardBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BATTERY_TEAR_1 = register("battery_tear_1", TycoonlibModBlocks.BATTERY_TEAR_1, BatteryTear1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BATTERY_TEAR_2 = register("battery_tear_2", TycoonlibModBlocks.BATTERY_TEAR_2, BatteryTear2BlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
