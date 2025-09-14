
package net.devmultiverse.tycoonlib.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class CrappyChairBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CrappyChairBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(13, 0, 13, 15, 9, 15), box(1, 0, 13, 3, 9, 15), box(1, 9, 1, 15, 11, 15), box(13, 0, 1, 15, 16, 3), box(1, 0, 1, 3, 16, 3), box(1, 11, 1.5, 15, 25, 2.5));
			case NORTH -> Shapes.or(box(1, 0, 1, 3, 9, 3), box(13, 0, 1, 15, 9, 3), box(1, 9, 1, 15, 11, 15), box(1, 0, 13, 3, 16, 15), box(13, 0, 13, 15, 16, 15), box(1, 11, 13.5, 15, 25, 14.5));
			case EAST -> Shapes.or(box(13, 0, 1, 15, 9, 3), box(13, 0, 13, 15, 9, 15), box(1, 9, 1, 15, 11, 15), box(1, 0, 1, 3, 16, 3), box(1, 0, 13, 3, 16, 15), box(1.5, 11, 1, 2.5, 25, 15));
			case WEST -> Shapes.or(box(1, 0, 13, 3, 9, 15), box(1, 0, 1, 3, 9, 3), box(1, 9, 1, 15, 11, 15), box(13, 0, 13, 15, 16, 15), box(13, 0, 1, 15, 16, 3), box(13.5, 11, 1, 14.5, 25, 15));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}
