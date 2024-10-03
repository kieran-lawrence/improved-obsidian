package com.codebykieran.improvedobsidian.block;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.TorchBlock;

public class ObsidianTableLampBlock extends TorchBlock {


    public ObsidianTableLampBlock(Properties properties) {
        super(ParticleTypes.FLAME, properties);
    }
}
