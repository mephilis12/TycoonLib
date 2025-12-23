package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OpenEntityExampleJunkStuffStoreProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		String usehand = "";
		if (event.getHand() == InteractionHand.MAIN_HAND) {
			usehand = "mainhand";
		} else {
			usehand = "offhand";
		}
		execute(event, event.getTarget());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		String namespace = "";
		String store = "";
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("tycoonlib:junk_and_stuff")))) {
			namespace = "tycoonlib";
			store = "junk_and_stuff";
			net.devmultiverse.tycoonlib.OpenShop.openE(namespace, store, (PlayerInteractEvent.EntityInteract) event);
		}
	}
}
