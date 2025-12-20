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

import net.devmultiverse.tycoonlib.init.TycoonlibModAttributes;

public class ShopBuyButtonPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()) ? _livingEntity0.getAttribute(TycoonlibModAttributes.FUNDS.get()).getValue() : 0) >= entity
				.getPersistentData().getDouble("shop_item_cost")) {
			if (world instanceof Level)
				((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tycoonlib:shop.buy")), SoundSource.NEUTRAL, 1, 1);
			if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()))
				_livingEntity5.getAttribute(TycoonlibModAttributes.FUNDS.get())
						.setBaseValue(((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()) ? _livingEntity3.getAttribute(TycoonlibModAttributes.FUNDS.get()).getValue() : 0)
								- entity.getPersistentData().getDouble("shop_item_cost")));
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(
						ForgeRegistries.ITEMS.getValue(new ResourceLocation(((entity.getPersistentData().getString("shop_item_namespace") + ":" + entity.getPersistentData().getString("shop_item_name"))).toLowerCase(java.util.Locale.ENGLISH))))
						.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("shop_item_amount"));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (world instanceof Level)
				((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tycoonlib:shop.error")), SoundSource.NEUTRAL, 1, 1);
		} /*guiGraphics.blit(new ResourceLocation(entity.getPersistentData().getString("shop_item_namespace") + ":textures/screens/shop/icons/" + entity.getPersistentData().getString("shop_item_name") + ".png"), this.leftPos + 86, this.topPos + 39, 0, 0, 112, 90, 112, 90);*/
	}
}
