
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TycoonlibMod.MODID);
	public static final RegistryObject<CreativeModeTab> TYCOON_LIB_TAB = REGISTRY.register("tycoon_lib_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.tycoonlib.tycoon_lib_tab")).icon(() -> new ItemStack(TycoonlibModBlocks.RESTAURANT_BOARD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TycoonlibModBlocks.RESTAURANT_BOARD.get().asItem());
				tabData.accept(TycoonlibModItems.RESTAURANT_BLUEPRINT.get());
				tabData.accept(TycoonlibModItems.ROOM_BLUEPRINT.get());
				tabData.accept(TycoonlibModBlocks.BATTERY_TEAR_1.get().asItem());
				tabData.accept(TycoonlibModBlocks.BATTERY_TEAR_2.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_BALLPIT.get().asItem());
				tabData.accept(TycoonlibModBlocks.COUNTER.get().asItem());
				tabData.accept(TycoonlibModBlocks.WOODEN_STOOL.get().asItem());
				tabData.accept(TycoonlibModBlocks.GUEST_SPAWN_PLATE.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_OPEN_SIGN.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_CASH_REGISTER.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_CAROUSEL.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_FRIDGE.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_CHAIR.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_ARCADE.get().asItem());
				tabData.accept(TycoonlibModBlocks.CRAPPY_TABLE.get().asItem());
				tabData.accept(TycoonlibModItems.MANNEQUIN_SPAWN_EGG.get());
				tabData.accept(TycoonlibModItems.SPAWN_NPC.get());
			}).build());
}
