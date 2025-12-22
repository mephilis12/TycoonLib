package net.devmultiverse.tycoonlib.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.devmultiverse.tycoonlib.world.inventory.ShopGUIMenu;
import net.devmultiverse.tycoonlib.procedures.YourFundsProcedure;
import net.devmultiverse.tycoonlib.procedures.ShopItemCostProcedure;
import net.devmultiverse.tycoonlib.network.ShopGUIButtonMessage;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ShopGUIScreen extends AbstractContainerScreen<ShopGUIMenu> {
	private final static HashMap<String, Object> guistate = ShopGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_shop_gui_buy_button;
	ImageButton imagebutton_shop_gui_left_cycle_button;
	ImageButton imagebutton_shop_gui_right_cycle_button;

	public ShopGUIScreen(ShopGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 251;
		this.imageHeight = 196;
	}

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

		guiGraphics.blit(new ResourceLocation(entity.getPersistentData().getString("shop_background") + ".png"), this.leftPos + -1, this.topPos + -1, 0, 0, 253, 198, 253, 198);

		guiGraphics.blit(new ResourceLocation(entity.getPersistentData().getString("shop_item_namespace") + ":textures/screens/shop/icons/" + entity.getPersistentData().getString("shop_item_name") + ".png"), this.leftPos + 130, this.topPos + 39, 0, 0, 112, 90, 112, 90);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.tycoonlib.shop_gui.label_buy"), 151, 153, -1, false);
		guiGraphics.drawString(this.font,

				ShopItemCostProcedure.execute(entity), 159, 44, -1, false);
		guiGraphics.drawString(this.font,

				YourFundsProcedure.execute(entity), 140, 134, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop." + entity.getPersistentData().getString("shop_line1")), 13, 39, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop." + entity.getPersistentData().getString("shop_line2")), 13, 60, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop." + entity.getPersistentData().getString("shop_line3")), 13, 70, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop." + entity.getPersistentData().getString("shop_line4")), 13, 80, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop." + entity.getPersistentData().getString("shop_line5")), 13, 90, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop." + entity.getPersistentData().getString("shop_line6")), 13, 100, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop.tycoonlib.atmosphere." + new java.text.DecimalFormat("0").format(entity.getPersistentData().getDouble("shop_item_atmosphere"))), 13, 118, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop.tycoonlib.health_safety." + new java.text.DecimalFormat("0").format(entity.getPersistentData().getDouble("shop_item_health_safety"))), 13, 129, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop.tycoonlib.bonus_revenue." + new java.text.DecimalFormat("0").format(entity.getPersistentData().getDouble("shop_item_bonus"))), 13, 151, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("shop.tycoonlib.liability_risk." + new java.text.DecimalFormat("0").format(entity.getPersistentData().getDouble("shop_item_risk"))), 13, 162, -39322, false);
		guiGraphics.drawString(this.font, Component.translatable("shop.tycoonlib.entertainment." + new java.text.DecimalFormat("0").format(entity.getPersistentData().getDouble("shop_item_entertainment"))), 13, 140, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_shop_gui_buy_button = new ImageButton(this.leftPos + 130, this.topPos + 151, 58, 18, 0, 0, 18, new ResourceLocation("tycoonlib:textures/screens/atlas/imagebutton_shop_gui_buy_button.png"), 58, 36, e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(0, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_shop_gui_buy_button", imagebutton_shop_gui_buy_button);
		this.addRenderableWidget(imagebutton_shop_gui_buy_button);
		imagebutton_shop_gui_left_cycle_button = new ImageButton(this.leftPos + 133, this.topPos + 102, 18, 20, 0, 0, 20, new ResourceLocation("tycoonlib:textures/screens/atlas/imagebutton_shop_gui_left_cycle_button.png"), 18, 40, e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(1, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_shop_gui_left_cycle_button", imagebutton_shop_gui_left_cycle_button);
		this.addRenderableWidget(imagebutton_shop_gui_left_cycle_button);
		imagebutton_shop_gui_right_cycle_button = new ImageButton(this.leftPos + 221, this.topPos + 102, 18, 20, 0, 0, 20, new ResourceLocation("tycoonlib:textures/screens/atlas/imagebutton_shop_gui_right_cycle_button.png"), 18, 40, e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new ShopGUIButtonMessage(2, x, y, z));
				ShopGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_shop_gui_right_cycle_button", imagebutton_shop_gui_right_cycle_button);
		this.addRenderableWidget(imagebutton_shop_gui_right_cycle_button);
	}
}
