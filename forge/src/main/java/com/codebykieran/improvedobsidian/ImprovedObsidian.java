package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.core.ImprovedObsidianItems;
import com.codebykieran.improvedobsidian.items.ImprovedObsidianItemsForge;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class ImprovedObsidian {

    public ImprovedObsidian() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Initialise common mod components
        ImprovedObsidianItemsForge.init();
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        CreativeModeTab.TabVisibility visibility = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.getEntries().putAfter(Items.NETHERITE_HOE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_SHOVEL.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_SHOVEL.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_PICKAXE.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_PICKAXE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_AXE.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_AXE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_HOE.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_HOE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_HAMMER.getDefaultInstance(), visibility);
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.getEntries().putAfter(Items.MACE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_HAMMER.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.NETHERITE_SWORD.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_SWORD.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.NETHERITE_AXE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_AXE.getDefaultInstance(), visibility);
            // After netherite boots
            // Helmet
            // Chest
            // Legs
            // Boots

        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.GUNPOWDER.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_DUST.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.GUNPOWDER.getDefaultInstance(), ImprovedObsidianItems.OBSIDIAN_DUST.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.GUNPOWDER.getDefaultInstance(), ImprovedObsidianItems.OBSIDIAN_SHARD.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.NETHERITE_INGOT.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_INGOT.getDefaultInstance(), visibility);
        }
    }
}