package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.blocks.ImprovedObsidianBlocksFabric;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianBlocks;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianItems;
import com.codebykieran.improvedobsidian.items.ImprovedObsidianItemsFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class ImprovedObsidian implements ModInitializer {
    
    @Override
    public void onInitialize() {
        // Initialise common mod components
        ImprovedObsidianItemsFabric.init();
        ImprovedObsidianBlocksFabric.init();
        registerCreativeTabEntries();
    }

    private static void registerCreativeTabEntries() {
        // Add items to the Tools tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.addAfter(Items.NETHERITE_HOE, ImprovedObsidianItems.OBSIDERITE_SHOVEL);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_SHOVEL, ImprovedObsidianItems.OBSIDERITE_PICKAXE);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_PICKAXE, ImprovedObsidianItems.OBSIDERITE_AXE);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_AXE, ImprovedObsidianItems.OBSIDERITE_HOE);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_HOE, ImprovedObsidianItems.OBSIDERITE_HAMMER);
        });
        // Add items to the combat tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.addAfter(Items.MACE, ImprovedObsidianItems.OBSIDERITE_HAMMER);
            entries.addAfter(Items.NETHERITE_SWORD, ImprovedObsidianItems.OBSIDERITE_SWORD);
            entries.addAfter(Items.NETHERITE_AXE,ImprovedObsidianItems.OBSIDERITE_AXE);
            entries.addAfter(Items.NETHERITE_BOOTS, ImprovedObsidianItems.OBSIDERITE_HELMET);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_HELMET, ImprovedObsidianItems.OBSIDERITE_CHESTPLATE);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_CHESTPLATE, ImprovedObsidianItems.OBSIDERITE_LEGGINGS);
            entries.addAfter(ImprovedObsidianItems.OBSIDERITE_LEGGINGS, ImprovedObsidianItems.OBSIDERITE_BOOTS);
        });
        // Add items to the Ingredients tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.GUNPOWDER, ImprovedObsidianItems.OBSIDERITE_DUST);
            entries.addAfter(Items.GUNPOWDER, ImprovedObsidianItems.OBSIDIAN_DUST);
            entries.addAfter(Items.GUNPOWDER, ImprovedObsidianItems.OBSIDIAN_SHARD);
            entries.addAfter(Items.NETHERITE_INGOT, ImprovedObsidianItems.OBSIDERITE_INGOT);
            
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Items.GLASS, ImprovedObsidianBlocks.OBSIDIAN_GLASS);
            entries.addAfter(ImprovedObsidianBlocks.OBSIDIAN_GLASS, ImprovedObsidianBlocks.OBSIDIAN_GLASS_PANE);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_BLOCK);
            entries.accept(ImprovedObsidianBlocks.OBSIDERITE_BLOCK);
            entries.accept(ImprovedObsidianBlocks.COMPRESSED_OBSIDIAN);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_TABLE_LAMP);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_END_TABLE);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_FLOWER_POT);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_STAIRS);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_WALL);
            entries.accept(ImprovedObsidianBlocks.OBSIDIAN_SLAB);
        });

    }
}
