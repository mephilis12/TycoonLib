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

import net.devmultiverse.tycoonlib.world.inventory.SetSettingsGUIMenu;
import net.devmultiverse.tycoonlib.network.SetSettingsGUIButtonMessage;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SetSettingsGUIScreen extends AbstractContainerScreen<SetSettingsGUIMenu> {
	private final static HashMap<String, Object> guistate = SetSettingsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox room_type;
	Checkbox employees_only;
	Button button_save;

	public SetSettingsGUIScreen(SetSettingsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tycoonlib:textures/screens/set_settings_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		room_type.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (room_type.isFocused())
			return room_type.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		room_type.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String room_typeValue = room_type.getValue();
		super.resize(minecraft, width, height);
		room_type.setValue(room_typeValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.tycoonlib.set_settings_gui.label_room"), 7, 29, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		room_type = new EditBox(this.font, this.leftPos + 7, this.topPos + 41, 118, 18, Component.translatable("gui.tycoonlib.set_settings_gui.room_type")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.set_settings_gui.room_type").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.set_settings_gui.room_type").getString());
				else
					setSuggestion(null);
			}
		};
		room_type.setSuggestion(Component.translatable("gui.tycoonlib.set_settings_gui.room_type").getString());
		room_type.setMaxLength(32767);
		guistate.put("text:room_type", room_type);
		this.addWidget(this.room_type);
		button_save = Button.builder(Component.translatable("gui.tycoonlib.set_settings_gui.button_save"), e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new SetSettingsGUIButtonMessage(0, x, y, z));
				SetSettingsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 5, this.topPos + 141, 46, 20).build();
		guistate.put("button:button_save", button_save);
		this.addRenderableWidget(button_save);
		employees_only = new Checkbox(this.leftPos + 6, this.topPos + 6, 20, 20, Component.translatable("gui.tycoonlib.set_settings_gui.employees_only"), false);
		guistate.put("checkbox:employees_only", employees_only);
		this.addRenderableWidget(employees_only);
	}
}
