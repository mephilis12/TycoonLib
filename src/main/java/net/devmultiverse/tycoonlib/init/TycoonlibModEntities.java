
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.devmultiverse.tycoonlib.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.devmultiverse.tycoonlib.entity.SeatEntityEntity;
import net.devmultiverse.tycoonlib.entity.MannequinEntity;
import net.devmultiverse.tycoonlib.entity.ChildEntity;
import net.devmultiverse.tycoonlib.entity.AdultEntity;
import net.devmultiverse.tycoonlib.TycoonlibMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TycoonlibModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TycoonlibMod.MODID);
	public static final RegistryObject<EntityType<MannequinEntity>> MANNEQUIN = register("mannequin",
			EntityType.Builder.<MannequinEntity>of(MannequinEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MannequinEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SeatEntityEntity>> SEAT_ENTITY = register("seat_entity", EntityType.Builder.<SeatEntityEntity>of(SeatEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(SeatEntityEntity::new).fireImmune().sized(0.25f, 0.25f));
	public static final RegistryObject<EntityType<AdultEntity>> ADULT = register("adult",
			EntityType.Builder.<AdultEntity>of(AdultEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(AdultEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ChildEntity>> CHILD = register("child",
			EntityType.Builder.<ChildEntity>of(ChildEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(ChildEntity::new)

					.sized(0.6f, 1.3f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MannequinEntity.init();
			SeatEntityEntity.init();
			AdultEntity.init();
			ChildEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MANNEQUIN.get(), MannequinEntity.createAttributes().build());
		event.put(SEAT_ENTITY.get(), SeatEntityEntity.createAttributes().build());
		event.put(ADULT.get(), AdultEntity.createAttributes().build());
		event.put(CHILD.get(), ChildEntity.createAttributes().build());
	}
}
