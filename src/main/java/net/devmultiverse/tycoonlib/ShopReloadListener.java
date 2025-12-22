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

            // --- NAME ---
            String texture = obj.get("name").getAsString();

            // --- ITEMS ---
            List<DataSpace.ShopItem> items = new ArrayList<>();
            JsonArray list = obj.getAsJsonArray("list");

            for (JsonElement e : list) {
                JsonObject entry = e.getAsJsonObject();

                items.add(new DataSpace.ShopItem(
                        new ResourceLocation(entry.get("item").getAsString()),
                        entry.get("description_line_1").getAsString(),
                        entry.get("description_line_2").getAsString(),
                        entry.get("description_line_3").getAsString(),
                        entry.get("description_line_4").getAsString(),
                        entry.get("description_line_5").getAsString(),
                        entry.get("cost").getAsInt(),
                        entry.get("stack").getAsInt()
                ));
            }

            SHOPS.put(id, new DataSpace.ShopData(
                    texture,
                    items
            ));
        });
    }
}