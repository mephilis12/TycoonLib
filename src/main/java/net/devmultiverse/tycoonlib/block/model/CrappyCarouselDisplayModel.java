package net.devmultiverse.tycoonlib.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.devmultiverse.tycoonlib.block.display.CrappyCarouselDisplayItem;

public class CrappyCarouselDisplayModel extends GeoModel<CrappyCarouselDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(CrappyCarouselDisplayItem animatable) {
		return new ResourceLocation("tycoonlib", "animations/carousel.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrappyCarouselDisplayItem animatable) {
		return new ResourceLocation("tycoonlib", "geo/carousel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrappyCarouselDisplayItem entity) {
		return new ResourceLocation("tycoonlib", "textures/block/crappy-carousel.png");
	}
}
