package net.devmultiverse.tycoonlib.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.devmultiverse.tycoonlib.entity.AdultEntity;

public class AdultModel extends GeoModel<AdultEntity> {
	@Override
	public ResourceLocation getAnimationResource(AdultEntity entity) {
		return new ResourceLocation("tycoonlib", "animations/adult.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AdultEntity entity) {
		return new ResourceLocation("tycoonlib", "geo/adult.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AdultEntity entity) {
		return new ResourceLocation("tycoonlib", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(AdultEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("Head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
