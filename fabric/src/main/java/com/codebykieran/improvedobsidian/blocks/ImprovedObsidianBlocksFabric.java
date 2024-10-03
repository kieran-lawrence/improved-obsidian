package com.codebykieran.improvedobsidian.blocks;

import com.codebykieran.improvedobsidian.Constants;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ImprovedObsidianBlocksFabric {
    public static void init() {
        registerBlock("obsidian_glass", ImprovedObsidianBlocks.OBSIDIAN_GLASS);
        registerBlock("obsidian_glass_pane",ImprovedObsidianBlocks.OBSIDIAN_GLASS_PANE);
        registerBlock("obsidian_block", ImprovedObsidianBlocks.OBSIDIAN_BLOCK);
        registerBlock("obsiderite_block",ImprovedObsidianBlocks.OBSIDERITE_BLOCK);
        registerBlock("compressed_obsidian",ImprovedObsidianBlocks.COMPRESSED_OBSIDIAN);
        registerBlock("obsidian_wall",ImprovedObsidianBlocks.OBSIDIAN_WALL);
        registerBlock("obsidian_stairs",ImprovedObsidianBlocks.OBSIDIAN_STAIRS);
        registerBlock("obsidian_table_lamp",ImprovedObsidianBlocks.OBSIDIAN_TABLE_LAMP);
        registerBlock("obsidian_end_table",ImprovedObsidianBlocks.OBSIDIAN_END_TABLE);
        registerBlock("obsidian_flower_pot",ImprovedObsidianBlocks.OBSIDIAN_FLOWER_POT);
        registerBlock("obsidian_slab",ImprovedObsidianBlocks.OBSIDIAN_SLAB);
    }

    public static void registerBlock(String name, Block block) {
        // Register the BlockItem first
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,name), new BlockItem(block, new Item.Properties()));
        // Then register the block itself
        Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,name), block);
    }
}
