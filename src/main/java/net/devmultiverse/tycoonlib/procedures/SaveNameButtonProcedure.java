package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SaveNameButtonProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(Blocks.AIR.asItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name", (guistate.containsKey("text:set_name") ? ((EditBox) guistate.get("text:set_name")).getValue() : ""));
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setHoverName(Component.literal((guistate.containsKey("text:set_name") ? ((EditBox) guistate.get("text:set_name")).getValue() : "")));
		} else {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("name", (guistate.containsKey("text:set_name") ? ((EditBox) guistate.get("text:set_name")).getValue() : ""));
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setHoverName(Component.literal((guistate.containsKey("text:set_name") ? ((EditBox) guistate.get("text:set_name")).getValue() : "")));
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
