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

    public ShopReloadListener() {
        super(GSON, "shops");
    }

    public static DataSpace.ShopData getShop(String shop)
    {
        ArrayList<DataSpace.ShopItem> data = new ArrayList<>();
        String texture = "";
        for (Map.Entry<ResourceLocation, DataSpace.ShopData> entry : SHOPS.entrySet()) {
            if (entry.getKey().getPath().equals(shop))
            {
                if (entry.getValue().override())
                    return entry.getValue();

                data.addAll(entry.getValue().items());
                texture = entry.getValue().name();
            }
        }
        return new DataSpace.ShopData(texture, false, data);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons,
                         ResourceManager manager,
                         ProfilerFiller profiler) {

        SHOPS.clear();

        jsons.forEach((id, json) -> {
            JsonObject obj = json.getAsJsonObject();

            // --- NAME ---
            String texture = "";
            if (obj.has("name"))
                texture = obj.get("name").getAsString();

            boolean override = false;
            if (obj.has("override"))
                override = obj.get("override").getAsBoolean();


            // --- ITEMS ---
            List<DataSpace.ShopItem> items = new ArrayList<>();
            JsonArray list = obj.getAsJsonArray("list");

            if (obj.has("list")) {
                for (JsonElement e : list) {
                    JsonObject entry = e.getAsJsonObject();

                    String description_line_1 = "blank";
                    if (entry.has("description_line_1"))
                        description_line_1 = entry.get("description_line_1").getAsString();

                    String description_line_2 = "blank";
                    if (entry.has("description_line_2"))
                        description_line_2 = entry.get("description_line_2").getAsString();

                    String description_line_3 = "blank";
                    if (entry.has("description_line_3"))
                        description_line_3 = entry.get("description_line_3").getAsString();

                    String description_line_4 = "blank";
                    if (entry.has("description_line_4"))
                        description_line_4 = entry.get("description_line_4").getAsString();

                    String description_line_5 = "blank";
                    if (entry.has("description_line_5"))
                        description_line_5 = entry.get("description_line_5").getAsString();

                    int stack = 1;
                    if (entry.has("stack"))
                        stack = entry.get("stack").getAsInt();

                    int cost = 1;
                    if (entry.has("cost"))
                        cost = entry.get("cost").getAsInt();

                    items.add(new DataSpace.ShopItem(
                            new ResourceLocation(entry.get("item").getAsString()),
                            description_line_1,
                            description_line_2,
                            description_line_3,
                            description_line_4,
                            description_line_5,
                            cost,
                            stack
                    ));
                }
            }


            SHOPS.put(id, new DataSpace.ShopData(
                    texture,
                    override,
                    items
            ));
        });
    }
}