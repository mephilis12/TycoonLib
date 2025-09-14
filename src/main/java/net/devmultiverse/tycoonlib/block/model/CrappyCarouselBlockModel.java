package net.devmultiverse.tycoonlib.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.devmultiverse.tycoonlib.block.entity.CrappyCarouselTileEntity;

public class CrappyCarouselBlockModel extends GeoModel<CrappyCarouselTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(CrappyCarouselTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("tycoonlib", "animations/carousel_on.animation.json");
		return new ResourceLocation("tycoonlib", "animations/carousel.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CrappyCarouselTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("tycoonlib", "geo/carousel_on.geo.json");
		return new ResourceLocation("tycoonlib", "geo/carousel.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CrappyCarouselTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("tycoonlib", "textures/block/crappy-carousel.png");
		return new ResourceLocation("tycoonlib", "textures/block/crappy-carousel.png");
	}
}
