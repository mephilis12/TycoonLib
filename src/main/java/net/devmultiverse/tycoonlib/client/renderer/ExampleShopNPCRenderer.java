
package net.devmultiverse.tycoonlib.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.devmultiverse.tycoonlib.entity.model.ExampleShopNPCModel;
import net.devmultiverse.tycoonlib.entity.ExampleShopNPCEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ExampleShopNPCRenderer extends GeoEntityRenderer<ExampleShopNPCEntity> {
	public ExampleShopNPCRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ExampleShopNPCModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(ExampleShopNPCEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ExampleShopNPCEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 0.95f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
