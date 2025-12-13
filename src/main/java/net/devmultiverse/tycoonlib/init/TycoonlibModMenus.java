
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.devmultiverse.tycoonlib.world.inventory.StaffManagerNewspaperGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.SpawnNPCGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.ShopGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.SetSettingsGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.SetRestaurantBlueprintSettingsGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.SetNameGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.RestaurantBoardGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.NewspaperGUIMenu;
import net.devmultiverse.tycoonlib.world.inventory.MaintenanceGUIMenu;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TycoonlibMod.MODID);
	public static final RegistryObject<MenuType<RestaurantBoardGUIMenu>> RESTAURANT_BOARD_GUI = REGISTRY.register("restaurant_board_gui", () -> IForgeMenuType.create(RestaurantBoardGUIMenu::new));
	public static final RegistryObject<MenuType<SetNameGUIMenu>> SET_NAME_GUI = REGISTRY.register("set_name_gui", () -> IForgeMenuType.create(SetNameGUIMenu::new));
	public static final RegistryObject<MenuType<SetSettingsGUIMenu>> SET_SETTINGS_GUI = REGISTRY.register("set_settings_gui", () -> IForgeMenuType.create(SetSettingsGUIMenu::new));
	public static final RegistryObject<MenuType<SetRestaurantBlueprintSettingsGUIMenu>> SET_RESTAURANT_BLUEPRINT_SETTINGS_GUI = REGISTRY.register("set_restaurant_blueprint_settings_gui",
			() -> IForgeMenuType.create(SetRestaurantBlueprintSettingsGUIMenu::new));
	public static final RegistryObject<MenuType<NewspaperGUIMenu>> NEWSPAPER_GUI = REGISTRY.register("newspaper_gui", () -> IForgeMenuType.create(NewspaperGUIMenu::new));
	public static final RegistryObject<MenuType<StaffManagerNewspaperGUIMenu>> STAFF_MANAGER_NEWSPAPER_GUI = REGISTRY.register("staff_manager_newspaper_gui", () -> IForgeMenuType.create(StaffManagerNewspaperGUIMenu::new));
	public static final RegistryObject<MenuType<MaintenanceGUIMenu>> MAINTENANCE_GUI = REGISTRY.register("maintenance_gui", () -> IForgeMenuType.create(MaintenanceGUIMenu::new));
	public static final RegistryObject<MenuType<SpawnNPCGUIMenu>> SPAWN_NPCGUI = REGISTRY.register("spawn_npcgui", () -> IForgeMenuType.create(SpawnNPCGUIMenu::new));
	public static final RegistryObject<MenuType<ShopGUIMenu>> SHOP_GUI = REGISTRY.register("shop_gui", () -> IForgeMenuType.create(ShopGUIMenu::new));
}
