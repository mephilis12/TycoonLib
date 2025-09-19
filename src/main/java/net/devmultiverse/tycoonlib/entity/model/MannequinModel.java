package net.devmultiverse.tycoonlib.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.devmultiverse.tycoonlib.entity.MannequinEntity;

public class MannequinModel extends GeoModel<MannequinEntity> {
	@Override
	public ResourceLocation getAnimationResource(MannequinEntity entity) {
		return new ResourceLocation("tycoonlib", "animations/mannequin.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MannequinEntity entity) {
		return new ResourceLocation("tycoonlib", "geo/mannequin.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MannequinEntity entity) {
		return new ResourceLocation("tycoonlib", "textures/entities/" + entity.getTexture() + ".png");
	}

}
