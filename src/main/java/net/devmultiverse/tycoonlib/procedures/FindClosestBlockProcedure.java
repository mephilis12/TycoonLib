package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.init.TycoonlibModEntities;
import net.devmultiverse.tycoonlib.entity.LocatorEntityEntity;

import java.util.Comparator;

public class FindClosestBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double FoundX = 0;
		double FoundY = 0;
		double FoundZ = 0;
		int horizontalRadiusSquare = (int) 10 - 1;
		int verticalRadiusSquare = (int) 3 - 1;
		int yIterationsSquare = verticalRadiusSquare;
		for (int i = -yIterationsSquare; i <= yIterationsSquare; i++) {
			for (int xi = -horizontalRadiusSquare; xi <= horizontalRadiusSquare; xi++) {
				for (int zi = -horizontalRadiusSquare; zi <= horizontalRadiusSquare; zi++) {
					// Execute the desired statements within the square/cube
					if (Blocks.RAW_GOLD_BLOCK == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = TycoonlibModEntities.LOCATOR_ENTITY.get().spawn(_level, BlockPos.containing(x + xi, y + i, z + zi), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (!world.getEntitiesOfClass(LocatorEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("" + Math.round(((Entity) world.getEntitiesOfClass(LocatorEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) != null
										? entity.distanceTo(((Entity) world.getEntitiesOfClass(LocatorEntityEntity.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null)))
										: -1))), true);
						}
					}
				}
			}
		}
	}
}
