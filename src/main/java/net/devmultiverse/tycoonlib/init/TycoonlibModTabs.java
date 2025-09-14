
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.devmultiverse.tycoonlib.TycoonlibMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TycoonlibModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TycoonlibMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(TycoonlibModBlocks.COUNTER.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_CAROUSEL.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_CASH_REGISTER.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_FRIDGE.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_CHAIR.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_ARCADE.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_TABLE.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_BALLPIT.get().asItem());
			tabData.accept(TycoonlibModBlocks.CRAPPY_OPEN_SIGN.get().asItem());
		}
	}
}
