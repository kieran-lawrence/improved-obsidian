package com.codebykieran.improvedobsidian.blocks;

import com.codebykieran.improvedobsidian.ModBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingObsidianBlock extends AmethystBlock {
    public static final MapCodec<BuddingObsidianBlock> CODEC = simpleCodec(BuddingObsidianBlock::new);
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    public MapCodec<BuddingObsidianBlock> codec() { return CODEC; }

    public BuddingObsidianBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        if(random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos pos = blockPos.relative(direction);
            BlockState state = serverLevel.getBlockState(pos);
            Block block = null;

            if (canClusterGrowAtState(state)) {
                block = ModBlocks.SMALL_OBSIDIAN_BUD;
            } else if (state.is(ModBlocks.SMALL_OBSIDIAN_BUD) && state.getValue(ObsidianClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_OBSIDIAN_BUD;
            } else if (state.is(ModBlocks.MEDIUM_OBSIDIAN_BUD) && state.getValue(ObsidianClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_OBSIDIAN_BUD;
            } else if (state.is(ModBlocks.LARGE_OBSIDIAN_BUD) && state.getValue(ObsidianClusterBlock.FACING) == direction) {
                block = ModBlocks.OBSIDIAN_CLUSTER;
            }

            if(block != null) {
                BlockState blockState1 = block.defaultBlockState().setValue(ObsidianClusterBlock.FACING, direction)
                        .setValue(ObsidianClusterBlock.WATERLOGGED, state.getFluidState().getType() == Fluids.WATER);
                serverLevel.setBlockAndUpdate(pos,blockState1);
            }
        }
    }

    public static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }
}
