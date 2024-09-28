package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.core.ModItems;
import com.codebykieran.improvedobsidian.items.ImprovedObsidianItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import java.util.stream.Stream;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ImprovedObsidian implements ModInitializer {
    
    @Override
    public void onInitialize() {
        // Initialise common mod components
        ImprovedObsidianItems.init();
        registerCreativeTabEntries();
    }

    private static void registerCreativeTabEntries() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.addAfter(Items.NETHERITE_HOE,ModItems.OBSIDERITE_HOE);
        });
    }
}
