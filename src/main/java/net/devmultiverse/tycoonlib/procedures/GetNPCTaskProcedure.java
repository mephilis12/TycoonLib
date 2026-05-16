package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.devmultiverse.tycoonlib.entity.NPCEntity;

public class GetNPCTaskProcedure {
	public static String execute() {
		if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) == null)
				&& (Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) instanceof NPCEntity) {
			return "Current Task: " + ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getPersistentData().getString("currentTask"));
		}
		return "Current Task: None";
	}
}
