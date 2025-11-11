package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;

import net.devmultiverse.tycoonlib.init.TycoonlibModItems;

import java.util.HashMap;

public class SaveSpawnNPCDataProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (TycoonlibModItems.SPAWN_NPC.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("CurrentTask", (guistate.containsKey("text:current_task") ? ((EditBox) guistate.get("text:current_task")).getValue() : ""));
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("IsChild", (guistate.containsKey("checkbox:is_child") && ((Checkbox) guistate.get("checkbox:is_child")).selected()));
		} else {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putString("CurrentTask", (guistate.containsKey("text:current_task") ? ((EditBox) guistate.get("text:current_task")).getValue() : ""));
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("IsChild", (guistate.containsKey("checkbox:is_child") && ((Checkbox) guistate.get("checkbox:is_child")).selected()));
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
