package net.devmultiverse.tycoonlib.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.devmultiverse.tycoonlib.block.model.CrappyCarouselDisplayModel;
import net.devmultiverse.tycoonlib.block.display.CrappyCarouselDisplayItem;

public class CrappyCarouselDisplayItemRenderer extends GeoItemRenderer<CrappyCarouselDisplayItem> {
	public CrappyCarouselDisplayItemRenderer() {
		super(new CrappyCarouselDisplayModel());
	}

	@Override
	public RenderType getRenderType(CrappyCarouselDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
