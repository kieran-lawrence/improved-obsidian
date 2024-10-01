package com.codebykieran.improvedobsidian;

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
            // After netherite boots
            // Helmet
            // Chest
            // Legs
            // Boots
        });
        // Add items to the Ingredients tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.GUNPOWDER, ImprovedObsidianItems.OBSIDERITE_DUST);
            entries.addAfter(Items.GUNPOWDER, ImprovedObsidianItems.OBSIDIAN_DUST);
            entries.addAfter(Items.GUNPOWDER, ImprovedObsidianItems.OBSIDIAN_SHARD);
            entries.addAfter(Items.NETHERITE_INGOT, ImprovedObsidianItems.OBSIDERITE_INGOT);
        });

    }
}
