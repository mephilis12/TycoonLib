package net.devmultiverse.tycoonlib.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.devmultiverse.tycoonlib.world.inventory.SetNameGUIMenu;
import net.devmultiverse.tycoonlib.network.SetNameGUIButtonMessage;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SetNameGUIScreen extends AbstractContainerScreen<SetNameGUIMenu> {
	private final static HashMap<String, Object> guistate = SetNameGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox set_name;
	Button button_save;

	public SetNameGUIScreen(SetNameGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 136;
		this.imageHeight = 65;
	}

	private static final ResourceLocation texture = new ResourceLocation("tycoonlib:textures/screens/set_name_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		set_name.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (set_name.isFocused())
			return set_name.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		set_name.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String set_nameValue = set_name.getValue();
		super.resize(minecraft, width, height);
		set_name.setValue(set_nameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.tycoonlib.set_name_gui.label_name"), 7, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		set_name = new EditBox(this.font, this.leftPos + 9, this.topPos + 19, 118, 18, Component.translatable("gui.tycoonlib.set_name_gui.set_name")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.set_name_gui.set_name").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.set_name_gui.set_name").getString());
				else
					setSuggestion(null);
			}
		};
		set_name.setSuggestion(Component.translatable("gui.tycoonlib.set_name_gui.set_name").getString());
		set_name.setMaxLength(32767);
		guistate.put("text:set_name", set_name);
		this.addWidget(this.set_name);
		button_save = Button.builder(Component.translatable("gui.tycoonlib.set_name_gui.button_save"), e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new SetNameGUIButtonMessage(0, x, y, z));
				SetNameGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 39, 46, 20).build();
		guistate.put("button:button_save", button_save);
		this.addRenderableWidget(button_save);
	}
}
