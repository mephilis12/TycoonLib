package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.Checkbox;

import java.util.HashMap;

public class SaveSettingsButtonProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(Blocks.AIR.asItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("employees_only",
					(guistate.containsKey("checkbox:employees_only") && ((Checkbox) guistate.get("checkbox:employees_only")).selected()));
		} else {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("employees_only",
					(guistate.containsKey("checkbox:employees_only") && ((Checkbox) guistate.get("checkbox:employees_only")).selected()));
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
