package com.codebykieran.improvedobsidian;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;

public class ImprovedObsidianFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        ImprovedObsidianCommon.init();
        registerCreativeTabEntries();
        enableTransparentBlocks();
    }

    private static void registerCreativeTabEntries() {
        // Add items to the Ingredients tab
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register((itemGroup) -> {
            itemGroup.accept(ModItems.OBSIDIAN_CLUSTER);
            itemGroup.accept(ModItems.BUDDING_OBSIDIAN);
            itemGroup.accept(ModItems.SMALL_OBSIDIAN_BUD);
            itemGroup.accept(ModItems.MEDIUM_OBSIDIAN_BUD);
            itemGroup.accept(ModItems.LARGE_OBSIDIAN_BUD);
            itemGroup.accept(ModItems.OBSIDIAN_SHARD);
            itemGroup.accept(ModItems.OBSIDERITE_UPGRADE_SMITHING_TEMPLATE);
        });
    }
    private static void enableTransparentBlocks() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OBSIDIAN_CLUSTER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_OBSIDIAN_BUD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_OBSIDIAN_BUD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_OBSIDIAN_BUD, RenderType.cutout());
    }
}
