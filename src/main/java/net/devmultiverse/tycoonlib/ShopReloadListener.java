package net.devmultiverse.tycoonlib;

import com.google.gson.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopReloadListener extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = new GsonBuilder().create();

    public static final Map<ResourceLocation, DataSpace.ShopData> SHOPS = new HashMap<>();
    
    /* EXAMPLE: 
    DataSpace.ShopData shop = ShopReloadListener.SHOPS.get(
        new ResourceLocation("tycoonlib", "wallmart")
	);
	*/

    public ShopReloadListener() {
        super(GSON, "shops");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons,
                         ResourceManager manager,
                         ProfilerFiller profiler) {

        SHOPS.clear();

        jsons.forEach((id, json) -> {
            JsonObject obj = json.getAsJsonObject();

            // --- BLOCKS ---
            List<ResourceLocation> blocks = new ArrayList<>();
            JsonArray blockArray = obj.getAsJsonArray("block");
            for (JsonElement e : blockArray) {
                blocks.add(new ResourceLocation(e.getAsString()));
            }

            // --- ENTITIES ---
            List<ResourceLocation> entities = new ArrayList<>();
            JsonArray entityArray = obj.getAsJsonArray("entity");
            for (JsonElement e : entityArray) {
                entities.add(new ResourceLocation(e.getAsString()));
            }

            // --- TEXTURE ---
            ResourceLocation texture =
                    new ResourceLocation(obj.get("texture").getAsString());

            // --- ITEMS ---
            List<DataSpace.ShopItem> items = new ArrayList<>();
            JsonArray list = obj.getAsJsonArray("list");

            for (JsonElement e : list) {
                JsonObject entry = e.getAsJsonObject();

                items.add(new DataSpace.ShopItem(
                        new ResourceLocation(entry.get("item").getAsString()),
                        entry.get("cost").getAsInt(),
                        entry.get("stack").getAsInt()
                ));
            }

            SHOPS.put(id, new DataSpace.ShopData(
                    blocks,
                    entities,
                    texture,
                    items
            ));
        });
    }
}