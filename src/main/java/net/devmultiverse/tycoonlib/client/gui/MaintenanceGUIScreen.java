package net.devmultiverse.tycoonlib.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.devmultiverse.tycoonlib.world.inventory.MaintenanceGUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MaintenanceGUIScreen extends AbstractContainerScreen<MaintenanceGUIMenu> {
	private final static HashMap<String, Object> guistate = MaintenanceGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_break;
	Button button_fix;

	public MaintenanceGUIScreen(MaintenanceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tycoonlib:textures/screens/maintenance_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.tycoonlib.maintenance_gui.label_this_gui_is_for_testing"), 6, 27, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_break = Button.builder(Component.translatable("gui.tycoonlib.maintenance_gui.button_break"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 6, 51, 20).build();
		guistate.put("button:button_break", button_break);
		this.addRenderableWidget(button_break);
		button_fix = Button.builder(Component.translatable("gui.tycoonlib.maintenance_gui.button_fix"), e -> {
		}).bounds(this.leftPos + 59, this.topPos + 6, 40, 20).build();
		guistate.put("button:button_fix", button_fix);
		this.addRenderableWidget(button_fix);
	}
}
