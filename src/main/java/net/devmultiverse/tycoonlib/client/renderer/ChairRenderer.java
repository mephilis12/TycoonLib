
package net.devmultiverse.tycoonlib.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.devmultiverse.tycoonlib.entity.ChairEntity;
import net.devmultiverse.tycoonlib.client.model.ModelCustomModel;

public class ChairRenderer extends MobRenderer<ChairEntity, ModelCustomModel<ChairEntity>> {
	public ChairRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCustomModel<ChairEntity>(context.bakeLayer(ModelCustomModel.LAYER_LOCATION)), 0.01f);
	}

	@Override
	public ResourceLocation getTextureLocation(ChairEntity entity) {
		return new ResourceLocation("tycoonlib:textures/entities/air.png");
	}
}
