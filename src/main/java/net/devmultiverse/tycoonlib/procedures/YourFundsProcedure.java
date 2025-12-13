package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.init.TycoonlibModAttributes;

public class YourFundsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("0")
				.format(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(TycoonlibModAttributes.FUNDS.get()) ? _livingEntity0.getAttribute(TycoonlibModAttributes.FUNDS.get()).getBaseValue() : 0);
	}
}
