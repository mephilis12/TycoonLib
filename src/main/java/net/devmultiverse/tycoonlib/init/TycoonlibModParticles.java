
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.devmultiverse.tycoonlib.client.particle.MoneyParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TycoonlibModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TycoonlibModParticleTypes.MONEY.get(), MoneyParticle::provider);
	}
}
