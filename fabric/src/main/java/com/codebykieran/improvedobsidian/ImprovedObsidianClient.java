package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.core.ImprovedObsidianBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ImprovedObsidianClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Improved obsidian loaded fabric client successfully");
        BlockRenderLayerMap.INSTANCE.putBlock(ImprovedObsidianBlocks.OBSIDIAN_GLASS, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ImprovedObsidianBlocks.OBSIDIAN_GLASS_PANE, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ImprovedObsidianBlocks.OBSIDIAN_FLOWER_POT, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ImprovedObsidianBlocks.OBSIDIAN_TABLE_LAMP, RenderType.translucent());
    }
}
