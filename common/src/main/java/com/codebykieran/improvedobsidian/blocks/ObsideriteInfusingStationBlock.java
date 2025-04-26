package com.codebykieran.improvedobsidian.blocks;

import com.codebykieran.improvedobsidian.entities.ObsideriteInfusingStationBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

public class ObsideriteInfusingStationBlock extends BaseEntityBlock {
    public static final MapCodec<ObsideriteInfusingStationBlock> CODEC = simpleCodec(ObsideriteInfusingStationBlock::new);
    public static final BooleanProperty LIT;
    public ObsideriteInfusingStationBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ObsideriteInfusingStationBlockEntity(pos,state);
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT});
    }
}
