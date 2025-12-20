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

public class SalvageReloadListener extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = new GsonBuilder().create();

    public static final Map<ResourceLocation, DataSpace.SalvageData> SALVAGE = new HashMap<>();
    
    /* EXAMPLE: 
    DataSpace.SalvageData salvage = SalvageReloadListener.SALVAGE.get(
        new ResourceLocation("tycoonlib", "wallmart")
	);
	*/

    public SalvageReloadListener() {
        super(GSON, "salvage");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsons,
                         ResourceManager manager,
                         ProfilerFiller profiler) {

        SALVAGE.clear();

        jsons.forEach((id, json) -> {
            JsonObject obj = json.getAsJsonObject();

            boolean replace = obj.has("replace") && obj.get("replace").getAsBoolean();

            List<DataSpace.SalvageItem> values = new ArrayList<>();
            JsonArray list = obj.getAsJsonArray("values");

            for (JsonElement e : list) {
                JsonObject entry = e.getAsJsonObject();

                values.add(new DataSpace.SalvageItem(
                        new ResourceLocation(entry.get("item").getAsString()),
                        entry.get("sell").getAsInt()
                ));
            }

            SALVAGE.put(id, new DataSpace.SalvageData(
                    replace,
                    values
            ));
        });
    }
}