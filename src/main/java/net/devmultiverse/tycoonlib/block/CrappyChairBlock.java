
package net.devmultiverse.tycoonlib.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.devmultiverse.tycoonlib.block.entity.CrappyChairBlockEntity;

public class CrappyChairBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public CrappyChairBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.LANTERN).strength(1f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CrappyChairBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof CrappyChairBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof CrappyChairBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
