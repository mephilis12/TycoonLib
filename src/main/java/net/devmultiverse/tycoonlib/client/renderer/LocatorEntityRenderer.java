
package net.devmultiverse.tycoonlib.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.devmultiverse.tycoonlib.entity.LocatorEntityEntity;
import net.devmultiverse.tycoonlib.client.model.Modela;

public class LocatorEntityRenderer extends MobRenderer<LocatorEntityEntity, Modela<LocatorEntityEntity>> {
	public LocatorEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modela<LocatorEntityEntity>(context.bakeLayer(Modela.LAYER_LOCATION)), 0.01f);
	}

	@Override
	public ResourceLocation getTextureLocation(LocatorEntityEntity entity) {
		return new ResourceLocation("tycoonlib:textures/entities/seat.png");
	}
}
