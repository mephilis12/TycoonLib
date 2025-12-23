
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.devmultiverse.tycoonlib.TycoonlibMod;

public class TycoonlibModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TycoonlibMod.MODID);
	public static final RegistryObject<SimpleParticleType> MONEY = REGISTRY.register("money", () -> new SimpleParticleType(false));
}
