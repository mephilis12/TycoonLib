
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.devmultiverse.tycoonlib.client.renderer.SeatEntityRenderer;
import net.devmultiverse.tycoonlib.client.renderer.MannequinRenderer;
import net.devmultiverse.tycoonlib.client.renderer.ChildRenderer;
import net.devmultiverse.tycoonlib.client.renderer.AdultRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TycoonlibModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TycoonlibModEntities.MANNEQUIN.get(), MannequinRenderer::new);
		event.registerEntityRenderer(TycoonlibModEntities.SEAT_ENTITY.get(), SeatEntityRenderer::new);
		event.registerEntityRenderer(TycoonlibModEntities.ADULT.get(), AdultRenderer::new);
		event.registerEntityRenderer(TycoonlibModEntities.CHILD.get(), ChildRenderer::new);
	}
}
