
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.devmultiverse.tycoonlib.client.gui.StaffManagerNewspaperGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.SpawnNPCGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.SetSettingsGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.SetRestaurantBlueprintSettingsGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.SetNameGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.RestaurantBoardGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.NewspaperGUIScreen;
import net.devmultiverse.tycoonlib.client.gui.MaintenanceGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TycoonlibModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TycoonlibModMenus.RESTAURANT_BOARD_GUI.get(), RestaurantBoardGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.SET_NAME_GUI.get(), SetNameGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.SET_SETTINGS_GUI.get(), SetSettingsGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.SET_RESTAURANT_BLUEPRINT_SETTINGS_GUI.get(), SetRestaurantBlueprintSettingsGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.NEWSPAPER_GUI.get(), NewspaperGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.STAFF_MANAGER_NEWSPAPER_GUI.get(), StaffManagerNewspaperGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.MAINTENANCE_GUI.get(), MaintenanceGUIScreen::new);
			MenuScreens.register(TycoonlibModMenus.SPAWN_NPCGUI.get(), SpawnNPCGUIScreen::new);
		});
	}
}
