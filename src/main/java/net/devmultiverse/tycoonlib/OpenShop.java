package net.devmultiverse.tycoonlib;

import net.devmultiverse.tycoonlib.procedures.OpenShopBlockProcedure;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.Nullable;

public class OpenShop {
	public static void openB(String namespace, String shop, @Nullable PlayerInteractEvent.RightClickBlock event)
	{
        assert event != null;
        OpenShopBlockProcedure.execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity(), namespace, shop);
	}
	public static void openE(String namespace, String shop, PlayerInteractEvent.EntityInteract event)
	{
        OpenShopBlockProcedure.execute(event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity(), namespace, shop);
	}
}
