package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.blocks.ImprovedObsidianBlocksForge;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianBlocks;
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
        ImprovedObsidianItemsForge.register(modEventBus);
        ImprovedObsidianItemsForge.init();
        ImprovedObsidianBlocksForge.register(modEventBus);
        ImprovedObsidianBlocksForge.init();
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
            event.getEntries().putAfter(Items.NETHERITE_BOOTS.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_HELMET.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_HELMET.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_CHESTPLATE.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_CHESTPLATE.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_LEGGINGS.getDefaultInstance(), visibility);
            event.getEntries().putAfter(ImprovedObsidianItems.OBSIDERITE_LEGGINGS.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_BOOTS.getDefaultInstance(), visibility);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.GUNPOWDER.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_DUST.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.GUNPOWDER.getDefaultInstance(), ImprovedObsidianItems.OBSIDIAN_DUST.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.GUNPOWDER.getDefaultInstance(), ImprovedObsidianItems.OBSIDIAN_SHARD.getDefaultInstance(), visibility);
            event.getEntries().putAfter(Items.NETHERITE_INGOT.getDefaultInstance(), ImprovedObsidianItems.OBSIDERITE_INGOT.getDefaultInstance(), visibility);
        } else if(event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
           event.accept(ImprovedObsidianBlocks.OBSIDIAN_GLASS);
           event.accept(ImprovedObsidianBlocks.OBSIDIAN_GLASS_PANE);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_BLOCK);
            event.accept(ImprovedObsidianBlocks.OBSIDERITE_BLOCK);
            event.accept(ImprovedObsidianBlocks.COMPRESSED_OBSIDIAN);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_TABLE_LAMP);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_END_TABLE);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_FLOWER_POT);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_STAIRS);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_WALL);
            event.accept(ImprovedObsidianBlocks.OBSIDIAN_SLAB);
        }
    }
}