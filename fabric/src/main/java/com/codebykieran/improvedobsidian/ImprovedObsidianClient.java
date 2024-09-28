package com.codebykieran.improvedobsidian;

import net.fabricmc.api.ClientModInitializer;

public class ImprovedObsidianClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Improved obsidian loaded fabric client successfully");
    }
}
