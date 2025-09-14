package net.devmultiverse.tycoonlib.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.devmultiverse.tycoonlib.block.model.CrappyCarouselBlockModel;
import net.devmultiverse.tycoonlib.block.entity.CrappyCarouselTileEntity;

public class CrappyCarouselTileRenderer extends GeoBlockRenderer<CrappyCarouselTileEntity> {
	public CrappyCarouselTileRenderer() {
		super(new CrappyCarouselBlockModel());
	}

	@Override
	public RenderType getRenderType(CrappyCarouselTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
