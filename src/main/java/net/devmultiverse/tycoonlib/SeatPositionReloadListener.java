package net.devmultiverse.tycoonlib;

import com.google.gson.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.HashMap;
import java.util.Map;

public class SeatPositionReloadListener extends SimpleJsonResourceReloadListener {

	private static final Gson GSON = new GsonBuilder().create();

	public static final Map<ResourceLocation, DataSpace.SeatPositionData> SEAT_POSITION = new HashMap<>();

	public SeatPositionReloadListener() {
		super(GSON, "seat_positions");
	}

	public static DataSpace.SeatPositionData getSeatPosition(String seatPosition)
	{
		double height = 0.0F;
		for (Map.Entry<ResourceLocation, DataSpace.SeatPositionData> entry : SEAT_POSITION.entrySet()) {
			if (entry.getKey().toString().equals(seatPosition))
			{
				height = entry.getValue().height();
			}
		}
		return new DataSpace.SeatPositionData(height);
	}

	@Override
	protected void apply(Map<ResourceLocation, JsonElement> jsons,
						 ResourceManager manager,
						 ProfilerFiller profiler) {

		SEAT_POSITION.clear();

		jsons.forEach((id, json) -> {
			JsonObject obj = json.getAsJsonObject();

			// --- SEAT HEIGHT ---
			double height = 0.0F;
			if (obj.has("height"))
				height = obj.get("height").getAsDouble();

			SEAT_POSITION.put(id, new DataSpace.SeatPositionData(
					height
			));
		});
	}
}