package net.devmultiverse.tycoonlib;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TycoonlibMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ReloadListenerRegistry {

    @SubscribeEvent
    public static void onReload(AddReloadListenerEvent event) {
        event.addListener(new ShopReloadListener());
        event.addListener(new SalvageReloadListener());
    }
}