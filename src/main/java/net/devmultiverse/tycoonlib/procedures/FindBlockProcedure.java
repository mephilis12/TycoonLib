package net.devmultiverse.tycoonlib.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FindBlockProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, boolean CantBeUsed, String BlockTag) {
		if (BlockTag == null)
			return "";
		double FindRange = 0;
		double FindRangeHight = 0;
		double OutX = 0;
		double OutY = 0;
		double OutZ = 0;
		boolean Found = false;
		FindRange = 20;
		FindRangeHight = 2;
		for (int checkY = (int) 0; checkY < (int) (1 + FindRangeHight * 2); checkY++) {
			for (int checkX = (int) 0; checkX < (int) (1 + FindRange * 2); checkX++) {
				for (int checkZ = (int) 0; checkZ < (int) (1 + FindRange * 2); checkZ++) {
					if (CantBeUsed) {
						if (!(new Object() {
							public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getBoolean(tag);
								return false;
							}
						}.getValue(world, BlockPos.containing((x + checkX) - FindRange, (y + checkY) - FindRangeHight, (z + checkZ) - FindRange), "claimed"))) {
							if ((world.getBlockState(BlockPos.containing((x + checkX) - FindRange, (y + checkY) - FindRangeHight, (z + checkZ) - FindRange)))
									.is(BlockTags.create(new ResourceLocation((BlockTag).toLowerCase(java.util.Locale.ENGLISH))))) {
								OutX = (x + checkX) - FindRange;
								OutY = (y + checkY) - FindRangeHight;
								OutZ = (z + checkZ) - FindRange;
								Found = true;
							}
						}
					} else {
						if ((world.getBlockState(BlockPos.containing((x + checkX) - FindRange, (y + checkY) - FindRangeHight, (z + checkZ) - FindRange))).is(BlockTags.create(new ResourceLocation((BlockTag).toLowerCase(java.util.Locale.ENGLISH))))) {
							OutX = (x + checkX) - FindRange;
							OutY = (y + checkY) - FindRangeHight;
							OutZ = (z + checkZ) - FindRange;
							Found = true;
						}
					}
				}
			}
		}
		if (Found) {
			return "TTrueTX" + new java.text.DecimalFormat("#").format(Math.floor(OutX)) + "XY" + new java.text.DecimalFormat("#").format(Math.floor(OutY)) + "YZ" + new java.text.DecimalFormat("#").format(Math.floor(OutZ)) + "Z";
		}
		return "TFalseT";
	}
}
