
package net.devmultiverse.tycoonlib.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.devmultiverse.tycoonlib.entity.SeatEntityEntity;
import net.devmultiverse.tycoonlib.client.model.Modela;

public class SeatEntityRenderer extends MobRenderer<SeatEntityEntity, Modela<SeatEntityEntity>> {
	public SeatEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modela<SeatEntityEntity>(context.bakeLayer(Modela.LAYER_LOCATION)), 0.01f);
	}

	@Override
	public ResourceLocation getTextureLocation(SeatEntityEntity entity) {
		return new ResourceLocation("tycoonlib:textures/entities/seat.png");
	}
}
