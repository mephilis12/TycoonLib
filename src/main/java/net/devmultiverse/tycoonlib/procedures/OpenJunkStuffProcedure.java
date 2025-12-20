package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OpenJunkStuffProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel().getBlockState(event.getPos()));
	}

	public static void execute(BlockState blockstate) {
		execute(null, blockstate);
	}

	private static void execute(@Nullable Event event, BlockState blockstate) {
		if (blockstate.is(BlockTags.create(new ResourceLocation("tycoonlib:junk_and_stuff")))) {
			net.devmultiverse.tycoonlib.OpenShop.open("tycoonlib", "junk_and_stuff", (PlayerInteractEvent.RightClickBlock) event);
		}
	}
}
