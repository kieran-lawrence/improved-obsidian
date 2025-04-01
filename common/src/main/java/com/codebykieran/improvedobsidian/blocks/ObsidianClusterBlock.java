package com.codebykieran.improvedobsidian.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.Map;

public class ObsidianClusterBlock extends AmethystBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<ObsidianClusterBlock> CODEC = RecordCodecBuilder.mapCodec(
            builder -> builder.group(
                            Codec.FLOAT.fieldOf("height").forGetter(getter -> getter.height),
                            Codec.FLOAT.fieldOf("width").forGetter(getter -> getter.width),
                            propertiesCodec()
                    )
                    .apply(builder, ObsidianClusterBlock::new)
    );
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    private final float height;
    private final float width;
    private final Map<Direction, VoxelShape> shapes;

    @Override
    public MapCodec<ObsidianClusterBlock> codec() {
        return CODEC;
    }

    public ObsidianClusterBlock(float height, float aabbOffset, BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false).setValue(FACING, Direction.UP));
        this.shapes = Shapes.rotateAll(Block.boxZ(aabbOffset, 16.0F - height, 16.0));
        this.height = height;
        this.width = aabbOffset;

    }


    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter getter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.shapes.get(blockState.getValue(FACING));
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        Direction direction = blockState.getValue(FACING);
        BlockPos blockpos = blockPos.relative(direction.getOpposite());
        return levelReader.getBlockState(blockpos).isFaceSturdy(levelReader, blockpos, direction);
    }

    @Override
    protected BlockState updateShape(
            BlockState blockState,
            LevelReader levelReader,
            ScheduledTickAccess scheduledTickAccess,
            BlockPos blockPos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            RandomSource randomSource
    ) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        return direction == blockState.getValue(FACING).getOpposite() && !blockState.canSurvive(levelReader, blockPos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborPos, neighborState, randomSource);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        LevelAccessor levelaccessor = blockPlaceContext.getLevel();
        BlockPos blockpos = blockPlaceContext.getClickedPos();
        return this.defaultBlockState()
                .setValue(WATERLOGGED, levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)
                .setValue(FACING, blockPlaceContext.getClickedFace());
    }

    @Override
    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(WATERLOGGED, FACING);
    }
}
