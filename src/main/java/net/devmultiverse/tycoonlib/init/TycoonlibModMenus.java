
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.devmultiverse.tycoonlib.world.inventory.SetFloorLevelMenu;
import net.devmultiverse.tycoonlib.world.inventory.RestaurantBoardGUIMenu;
import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TycoonlibMod.MODID);
	public static final RegistryObject<MenuType<RestaurantBoardGUIMenu>> RESTAURANT_BOARD_GUI = REGISTRY.register("restaurant_board_gui", () -> IForgeMenuType.create(RestaurantBoardGUIMenu::new));
	public static final RegistryObject<MenuType<SetFloorLevelMenu>> SET_FLOOR_LEVEL = REGISTRY.register("set_floor_level", () -> IForgeMenuType.create(SetFloorLevelMenu::new));
}
