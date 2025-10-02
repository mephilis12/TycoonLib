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

import net.devmultiverse.tycoonlib.world.inventory.SetRestaurantBlueprintSettingsGUIMenu;
import net.devmultiverse.tycoonlib.network.SetRestaurantBlueprintSettingsGUIButtonMessage;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SetRestaurantBlueprintSettingsGUIScreen extends AbstractContainerScreen<SetRestaurantBlueprintSettingsGUIMenu> {
	private final static HashMap<String, Object> guistate = SetRestaurantBlueprintSettingsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox floor_level;
	Button button_save;

	public SetRestaurantBlueprintSettingsGUIScreen(SetRestaurantBlueprintSettingsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tycoonlib:textures/screens/set_restaurant_blueprint_settings_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		floor_level.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (floor_level.isFocused())
			return floor_level.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		floor_level.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String floor_levelValue = floor_level.getValue();
		super.resize(minecraft, width, height);
		floor_level.setValue(floor_levelValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.tycoonlib.set_restaurant_blueprint_settings_gui.label_floor_level"), 6, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		floor_level = new EditBox(this.font, this.leftPos + 6, this.topPos + 16, 118, 18, Component.translatable("gui.tycoonlib.set_restaurant_blueprint_settings_gui.floor_level")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.set_restaurant_blueprint_settings_gui.floor_level").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.tycoonlib.set_restaurant_blueprint_settings_gui.floor_level").getString());
				else
					setSuggestion(null);
			}
		};
		floor_level.setSuggestion(Component.translatable("gui.tycoonlib.set_restaurant_blueprint_settings_gui.floor_level").getString());
		floor_level.setMaxLength(32767);
		guistate.put("text:floor_level", floor_level);
		this.addWidget(this.floor_level);
		button_save = Button.builder(Component.translatable("gui.tycoonlib.set_restaurant_blueprint_settings_gui.button_save"), e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new SetRestaurantBlueprintSettingsGUIButtonMessage(0, x, y, z));
				SetRestaurantBlueprintSettingsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 140, 46, 20).build();
		guistate.put("button:button_save", button_save);
		this.addRenderableWidget(button_save);
	}
}
