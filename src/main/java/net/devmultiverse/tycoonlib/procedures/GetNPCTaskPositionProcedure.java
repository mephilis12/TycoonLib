package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import net.devmultiverse.tycoonlib.entity.NPCEntity;

public class GetNPCTaskPositionProcedure {
	public static String execute() {
		if (!((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) == null)
				&& (Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null) instanceof NPCEntity) {
			return "Current Task: x" + ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getPersistentData().getDouble("xC")) + " y"
					+ ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getPersistentData().getDouble("yC")) + " z"
					+ ((Minecraft.getInstance().hitResult instanceof EntityHitResult _entityHitResult ? _entityHitResult.getEntity() : (Entity) null).getPersistentData().getDouble("zC"));
		}
		return "Current Task: x? y? z?";
	}
}
