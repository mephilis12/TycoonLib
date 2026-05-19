
package net.devmultiverse.tycoonlib.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.devmultiverse.tycoonlib.procedures.GetNPCTaskProcedure;
import net.devmultiverse.tycoonlib.procedures.GetNPCTaskPositionProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class NPCHudOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					GetNPCTaskProcedure.execute(), 4, h / 2 + -5, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					GetNPCTaskPositionProcedure.execute(), 4, h / 2 + 6, -1, false);
		}
	}
}
