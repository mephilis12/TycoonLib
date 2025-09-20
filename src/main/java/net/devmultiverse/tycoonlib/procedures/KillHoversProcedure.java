package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.init.TycoonlibModItems;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KillHoversProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ItemEntity) {
			if (TycoonlibModItems.RESTAURANT_BOARD_HOVER.get() == (entity instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem()) {
				TycoonlibMod.queueServerWork(1, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			}
		}
	}
}
