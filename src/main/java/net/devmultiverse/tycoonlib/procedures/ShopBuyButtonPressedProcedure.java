package net.devmultiverse.tycoonlib.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModBlocks;
import net.devmultiverse.tycoonlib.init.TycoonlibModAttributes;

public class ShopBuyButtonPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()) ? _livingEntity0.getAttribute(TycoonlibModAttributes.FUNDS.get()).getValue() : 0) >= 5) {
			if (world instanceof Level)
				((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tycoonlib:shop.buy")), SoundSource.NEUTRAL, 1, 1);
			if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()))
				_livingEntity3.getAttribute(TycoonlibModAttributes.FUNDS.get()).setBaseValue(
						((entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()) ? _livingEntity2.getAttribute(TycoonlibModAttributes.FUNDS.get()).getValue() : 0) - 5));
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(TycoonlibModBlocks.CRAPPY_ARCADE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (world instanceof Level)
				((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tycoonlib:shop.error")), SoundSource.NEUTRAL, 1, 1);
		}
	}
}
