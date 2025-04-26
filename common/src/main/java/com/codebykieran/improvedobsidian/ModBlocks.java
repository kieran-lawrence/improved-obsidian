package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.blocks.BuddingObsidianBlock;
import com.codebykieran.improvedobsidian.blocks.ObsideriteInfusingStationBlock;
import com.codebykieran.improvedobsidian.blocks.ObsidianClusterBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import java.util.function.Function;

public class ModBlocks {
    public static void initialize() {
    }
    public static final Block OBSIDIAN_CLUSTER = register(
            "obsidian_cluster",
            properties -> new ObsidianClusterBlock(7.0F, 10.0F, properties),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .forceSolidOn()
                    .noOcclusion()
                    .sound(SoundType.AMETHYST_CLUSTER)
                    .strength(3F)
                    .lightLevel(p_152632_ -> 5)
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final Block BUDDING_OBSIDIAN = register(
            "budding_obsidian",
            BuddingObsidianBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .randomTicks()
                    .strength(50.0F, 1200.0F)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .pushReaction(PushReaction.DESTROY)
                    .lightLevel(p_187433_ -> 10)
    );
    public static final Block LARGE_OBSIDIAN_BUD = register(
            "large_obsidian_bud",
            properties -> new ObsidianClusterBlock(5.0F, 10.0F, properties),
            BlockBehaviour.Properties.ofLegacyCopy(OBSIDIAN_CLUSTER).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(p_152629_ -> 4)
    );
    public static final Block MEDIUM_OBSIDIAN_BUD = register(
            "medium_obsidian_bud",
            properties -> new ObsidianClusterBlock(4.0F, 10.0F, properties),
            BlockBehaviour.Properties.ofLegacyCopy(OBSIDIAN_CLUSTER).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(p_152617_ -> 2)
    );
    public static final Block SMALL_OBSIDIAN_BUD = register(
            "small_obsidian_bud",
            properties -> new ObsidianClusterBlock(3.0F, 8.0F, properties),
            BlockBehaviour.Properties.ofLegacyCopy(OBSIDIAN_CLUSTER).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(p_187409_ -> 1)
    );
    public static final Block OBSIDERITE_INFUSING_STATION = register("obsiderite_infusing_station",
            ObsideriteInfusingStationBlock::new,
            BlockBehaviour.Properties.of()
                    .strength(50.0F, 1200.0F)
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .lightLevel(p_187409_ -> 13)
    );

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> resourceKey = getBlockId(name);
        Block block = factory.apply(properties.setId(resourceKey));
        return Registry.register(BuiltInRegistries.BLOCK, resourceKey, block);
    }


    private static ResourceKey<Block> getBlockId(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,name));
    }

}
