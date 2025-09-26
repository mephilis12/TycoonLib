package net.devmultiverse.tycoonlib.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.devmultiverse.tycoonlib.world.inventory.RestaurantBoardGUIMenu;
import net.devmultiverse.tycoonlib.procedures.RestaurantTitleProcedure;
import net.devmultiverse.tycoonlib.procedures.RestaurantLevel6CheckProcedure;
import net.devmultiverse.tycoonlib.procedures.RestaurantLevel5CheckProcedure;
import net.devmultiverse.tycoonlib.procedures.RestaurantLevel4CheckProcedure;
import net.devmultiverse.tycoonlib.procedures.RestaurantLevel3CheckProcedure;
import net.devmultiverse.tycoonlib.procedures.RestaurantLevel2CheckProcedure;
import net.devmultiverse.tycoonlib.procedures.RestaurantLevel1Procedure;
import net.devmultiverse.tycoonlib.procedures.PageTitleProcedure;
import net.devmultiverse.tycoonlib.procedures.PageSubtitleProcedure;
import net.devmultiverse.tycoonlib.procedures.GetLevelProcedure;
import net.devmultiverse.tycoonlib.network.RestaurantBoardGUIButtonMessage;
import net.devmultiverse.tycoonlib.TycoonlibMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RestaurantBoardGUIScreen extends AbstractContainerScreen<RestaurantBoardGUIMenu> {
	private final static HashMap<String, Object> guistate = RestaurantBoardGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_restaurant_board_left_arrow;
	ImageButton imagebutton_restaurant_board_right_arrow;

	public RestaurantBoardGUIScreen(RestaurantBoardGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 230;
		this.imageHeight = 219;
	}

	private static final ResourceLocation texture = new ResourceLocation("tycoonlib:textures/screens/restaurant_board_gui.png");

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

		guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 230, 219, 230, 219);

		if (RestaurantLevel2CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 181, this.topPos + 140, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel2CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 181, this.topPos + 158, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel3CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 181, this.topPos + 176, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel3CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 181, this.topPos + 194, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel4CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 199, this.topPos + 104, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel4CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 199, this.topPos + 122, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel5CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 199, this.topPos + 140, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel5CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 199, this.topPos + 158, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel6CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 199, this.topPos + 176, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel6CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 199, this.topPos + 194, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 181, this.topPos + 104, 0, 0, 18, 18, 18, 18);
		}
		if (RestaurantLevel1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("tycoonlib:textures/screens/restaurant_board_locked_slot.png"), this.leftPos + 181, this.topPos + 122, 0, 0, 18, 18, 18, 18);
		}
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
		guiGraphics.drawString(this.font,

				RestaurantTitleProcedure.execute(entity), 32, 114, -12829636, false);
		guiGraphics.drawString(this.font,

				GetLevelProcedure.execute(entity), 13, 10, -1, false);
		guiGraphics.drawString(this.font,

				PageTitleProcedure.execute(world, x, y, z), 120, 10, -1, false);
		guiGraphics.drawString(this.font,

				PageSubtitleProcedure.execute(world, x, y, z), 120, 20, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_restaurant_board_left_arrow = new ImageButton(this.leftPos + 117, this.topPos + 88, 11, 10, 0, 0, 10, new ResourceLocation("tycoonlib:textures/screens/atlas/imagebutton_restaurant_board_left_arrow.png"), 11, 20, e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new RestaurantBoardGUIButtonMessage(0, x, y, z));
				RestaurantBoardGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_restaurant_board_left_arrow", imagebutton_restaurant_board_left_arrow);
		this.addRenderableWidget(imagebutton_restaurant_board_left_arrow);
		imagebutton_restaurant_board_right_arrow = new ImageButton(this.leftPos + 209, this.topPos + 88, 11, 10, 0, 0, 10, new ResourceLocation("tycoonlib:textures/screens/atlas/imagebutton_restaurant_board_right_arrow.png"), 11, 20, e -> {
			if (true) {
				TycoonlibMod.PACKET_HANDLER.sendToServer(new RestaurantBoardGUIButtonMessage(1, x, y, z));
				RestaurantBoardGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_restaurant_board_right_arrow", imagebutton_restaurant_board_right_arrow);
		this.addRenderableWidget(imagebutton_restaurant_board_right_arrow);
	}
}
