
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.devmultiverse.tycoonlib.client.gui.SetSettingsGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.SetNameGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.RestaurantBoardGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TycoonlibModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TycoonlibModMenus.RESTAURANT_BOARD_GUI.get(), RestaurantBoardGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.SET_NAME_GUI.get(), SetNameGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.SET_SETTINGS_GUI.get(), SetSettingsGUIScreen::new);
		});
	}
}
