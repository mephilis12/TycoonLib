package net.devmultiverse.tycoonlib.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlockEntities;
import net.devmultiverse.tycoonlib.block.renderer.CrappyCarouselTileRenderer;
import net.devmultiverse.tycoonlib.TycoonlibMod;

@Mod.EventBusSubscriber(modid = TycoonlibMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(TycoonlibModBlockEntities.CRAPPY_CAROUSEL.get(), context -> new CrappyCarouselTileRenderer());
	}
}
