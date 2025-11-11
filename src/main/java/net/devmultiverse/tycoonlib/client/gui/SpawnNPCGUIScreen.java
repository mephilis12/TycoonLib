package net.devmultiverse.tycoonlib.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.devmultiverse.tycoonlib.world.inventory.SpawnNPCGUIMenu;
import net.devmultiverse.tycoonlib.network.SpawnNPCGUIButtonMessage;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SpawnNPCGUIScreen extends AbstractContainerScreen<SpawnNPCGUIMenu> {
	private final static HashMap<String, Object> guistate = SpawnNPCGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox current_task;
	Checkbox is_child;
	Button button_save;

	public SpawnNPCGUIScreen(SpawnNPCGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 132;
		this.imageHeight = 70;
	}

	private static final ResourceLocation texture = new ResourceLocation("tycoonlib:textures/screens/spawn_npcgui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		current_task.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (current_task.isFocused())
			return current_task.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		current_task.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String current_taskValue = current_task.getValue();
		super.resize(minecraft, width, height);
		current_task.setValue(current_taskValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.tycoonlib.spawn_npcgui.label_new_npc"), 6, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		current_task = new EditBox(this.font, this.leftPos + 6, this.topPos + 21, 118, 18, Component.translatable("gui.tycoonlib.spawn_npcgui.current_task")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.spawn_npcgui.current_task").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.spawn_npcgui.current_task").getString());
				else
					setSuggestion(null);
			}
		};
		current_task.setSuggestion(Component.translatable("gui.tycoonlib.spawn_npcgui.current_task").getString());
		current_task.setMaxLength(32767);
		guistate.put("text:current_task", current_task);
		this.addWidget(this.current_task);
		button_save = Button.builder(Component.translatable("gui.tycoonlib.spawn_npcgui.button_save"), e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new SpawnNPCGUIButtonMessage(0, x, y, z));
				SpawnNPCGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 79, this.topPos + 43, 46, 20).build();
		guistate.put("button:button_save", button_save);
		this.addRenderableWidget(button_save);
		is_child = new Checkbox(this.leftPos + 6, this.topPos + 43, 20, 20, Component.translatable("gui.tycoonlib.spawn_npcgui.is_child"), false);
		guistate.put("checkbox:is_child", is_child);
		this.addRenderableWidget(is_child);
	}
}
