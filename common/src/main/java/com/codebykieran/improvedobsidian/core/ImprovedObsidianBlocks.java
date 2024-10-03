package com.codebykieran.improvedobsidian.core;

import com.codebykieran.improvedobsidian.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class ImprovedObsidianBlocks {
    public static final Block OBSIDIAN_GLASS = new ObsidianGlassBlock(BlockBehaviour.Properties.of().strength(0.1F,600.0F).sound(SoundType.GLASS).noOcclusion());
    public static final Block OBSIDIAN_GLASS_PANE = new ObsidianGlassPaneBlock(BlockBehaviour.Properties.of().strength(0.1F,600.0F).instrument(NoteBlockInstrument.HAT).sound(SoundType.GLASS).noOcclusion());
    public static final Block OBSIDIAN_BLOCK = new ObsidianBlock(BlockBehaviour.Properties.of().strength(0.5F,600.0F).requiresCorrectToolForDrops());
    public static final Block OBSIDERITE_BLOCK = new ObsideriteBlock(BlockBehaviour.Properties.of().strength(0.5F,600.0F).requiresCorrectToolForDrops());
    public static final Block COMPRESSED_OBSIDIAN = new CompressedObsidianBlock(BlockBehaviour.Properties.of().strength(0.5F,600.0F).requiresCorrectToolForDrops());
    public static final Block OBSIDIAN_TABLE_LAMP = new ObsidianTableLampBlock(BlockBehaviour.Properties.of().strength(0.2F,600.0F).requiresCorrectToolForDrops().noOcclusion().lightLevel(x -> 15));
    public static final Block OBSIDIAN_END_TABLE = new ObsidianEndTableBlock(BlockBehaviour.Properties.of().strength(0.1F,600.0F).requiresCorrectToolForDrops().noOcclusion());
    public static final Block OBSIDIAN_FLOWER_POT = new ObsidianFlowerPotBlock(Blocks.AIR,BlockBehaviour.Properties.of().strength(0.1F,600.0F).requiresCorrectToolForDrops());
    public static final Block OBSIDIAN_STAIRS = new ObsidianStairsBlock(OBSIDIAN_BLOCK.defaultBlockState(),BlockBehaviour.Properties.of().strength(0.2F,600.0F).requiresCorrectToolForDrops());
    public static final Block OBSIDIAN_WALL = new ObsidianWallBlock(BlockBehaviour.Properties.of().strength(0.1F,600.0F).requiresCorrectToolForDrops().forceSolidOn());
    public static final Block OBSIDIAN_SLAB = new ObsidianSlabBlock(BlockBehaviour.Properties.of().strength(0.1F,600.0F).requiresCorrectToolForDrops().forceSolidOn());

//
//    //Obsidian Infusing Station
//    public static final Block OBSIDERITE_INFUSING_STATION = registerBlock("obsiderite_infusing_station",
//            new ObsideriteInfusingStationBlock(FabricBlockSettings.of(Material.STONE)
//                    .strength(3.0F,600.0F).requiresTool().nonOpaque()), ModItemGroup.OBSIDIAN);
//    public static final Block OBSIDERITE_CHEST = registerBlock("obsiderite_chest",
//            new ObsideriteChestBlock(FabricBlockSettings.of(Material.STONE)
//                    .strength(3.0F,600.0F).requiresTool().nonOpaque()), ModItemGroup.OBSIDIAN);
//
//
//
//    public static final Block OBSIDIAN_GRINDER = registerBlock("obsidian_grinder",
//            new ObsidianGrinderBlock(FabricBlockSettings.of(Material.STONE)
//                    .strength(3.0F,600.0F).requiresTool().nonOpaque()), ModItemGroup.OBSIDIAN);
//
//    public static final Block OBSIDIAN_LAMP = registerBlock("obsidian_lamp",
//            new ObsidianLampBlock(FabricBlockSettings.of(Material.STONE).strength(0.2F,600.0F).requiresTool()
//                    .luminance(state -> state.get(ObsidianLampBlock.LIT) ? 15 : 0).sounds(BlockSoundGroup.GLASS)), ModItemGroup.OBSIDIAN);
//
//

}
