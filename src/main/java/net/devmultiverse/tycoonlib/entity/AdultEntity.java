
package net.devmultiverse.tycoonlib.entity;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoEntity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.devmultiverse.tycoonlib.procedures.LockNormalTasksProcedure;
import net.devmultiverse.tycoonlib.procedures.AdultOnInitialEntitySpawnProcedure;
import net.devmultiverse.tycoonlib.procedures.AdultOnEntityTickUpdateProcedure;
import net.devmultiverse.tycoonlib.procedures.AdultEntityDiesProcedure;
import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;

import javax.annotation.Nullable;

public class AdultEntity extends PathfinderMob implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> DATA_type = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_animation = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_xBoardPosition = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_yBoardPosition = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_zBoardPosition = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_adult_age = SynchedEntityData.defineId(AdultEntity.class, EntityDataSerializers.INT);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public AdultEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TycoonlibModEntities.ADULT.get(), world);
	}

	public AdultEntity(EntityType<AdultEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setMaxUpStep(0.6f);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "john_yorker");
		this.entityData.define(DATA_type, "guest");
		this.entityData.define(DATA_animation, 0);
		this.entityData.define(DATA_xBoardPosition, 0);
		this.entityData.define(DATA_yBoardPosition, 0);
		this.entityData.define(DATA_zBoardPosition, 0);
		this.entityData.define(DATA_adult_age, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new TemptGoal(this, 1, Ingredient.of(Items.DEBUG_STICK), false) {
			@Override
			public boolean canUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canUse() && LockNormalTasksProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canContinueToUse() && LockNormalTasksProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.2) {
			@Override
			public boolean canUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canUse() && LockNormalTasksProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canContinueToUse() && LockNormalTasksProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canUse() && LockNormalTasksProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canContinueToUse() && LockNormalTasksProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new FloatGoal(this) {
			@Override
			public boolean canUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canUse() && LockNormalTasksProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = AdultEntity.this.getX();
				double y = AdultEntity.this.getY();
				double z = AdultEntity.this.getZ();
				Entity entity = AdultEntity.this;
				Level world = AdultEntity.this.level();
				return super.canContinueToUse() && LockNormalTasksProcedure.execute(entity);
			}
		});
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		AdultEntityDiesProcedure.execute(this.level(), this);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		AdultOnInitialEntitySpawnProcedure.execute(world, this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putString("Datatype", this.entityData.get(DATA_type));
		compound.putInt("Dataanimation", this.entityData.get(DATA_animation));
		compound.putInt("DataxBoardPosition", this.entityData.get(DATA_xBoardPosition));
		compound.putInt("DatayBoardPosition", this.entityData.get(DATA_yBoardPosition));
		compound.putInt("DatazBoardPosition", this.entityData.get(DATA_zBoardPosition));
		compound.putInt("Dataadult_age", this.entityData.get(DATA_adult_age));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("Datatype"))
			this.entityData.set(DATA_type, compound.getString("Datatype"));
		if (compound.contains("Dataanimation"))
			this.entityData.set(DATA_animation, compound.getInt("Dataanimation"));
		if (compound.contains("DataxBoardPosition"))
			this.entityData.set(DATA_xBoardPosition, compound.getInt("DataxBoardPosition"));
		if (compound.contains("DatayBoardPosition"))
			this.entityData.set(DATA_yBoardPosition, compound.getInt("DatayBoardPosition"));
		if (compound.contains("DatazBoardPosition"))
			this.entityData.set(DATA_zBoardPosition, compound.getInt("DatazBoardPosition"));
		if (compound.contains("Dataadult_age"))
			this.entityData.set(DATA_adult_age, compound.getInt("Dataadult_age"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		AdultOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 0.95);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 128);
		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.model.idle"));
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(AdultEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
