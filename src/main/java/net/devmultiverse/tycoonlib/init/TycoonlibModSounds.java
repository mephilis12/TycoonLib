
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TycoonlibMod.MODID);
	public static final RegistryObject<SoundEvent> SHOP_BUY = REGISTRY.register("shop.buy", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tycoonlib", "shop.buy")));
	public static final RegistryObject<SoundEvent> SHOP_ERROR = REGISTRY.register("shop.error", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("tycoonlib", "shop.error")));
}
