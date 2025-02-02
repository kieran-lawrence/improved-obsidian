package com.codebykieran.improvedobsidian.items;

import com.codebykieran.improvedobsidian.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianItems;
public class ImprovedObsidianItemsFabric {

    public static void init() {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_axe"), ImprovedObsidianItems.OBSIDERITE_AXE);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "obsiderite_boots"),ImprovedObsidianItems.OBSIDERITE_BOOTS);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "obsiderite_chestplate"),ImprovedObsidianItems.OBSIDERITE_CHESTPLATE);

        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_dust"), ImprovedObsidianItems.OBSIDERITE_DUST);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_hammer"), ImprovedObsidianItems.OBSIDERITE_HAMMER);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "obsiderite_helmet"),ImprovedObsidianItems.OBSIDERITE_HELMET);

        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_hoe"), ImprovedObsidianItems.OBSIDERITE_HOE);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_ingot"), ImprovedObsidianItems.OBSIDERITE_INGOT);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "obsiderite_leggings"),ImprovedObsidianItems.OBSIDERITE_LEGGINGS);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_pickaxe"), ImprovedObsidianItems.OBSIDERITE_PICKAXE);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_shovel"), ImprovedObsidianItems.OBSIDERITE_SHOVEL);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_sword"), ImprovedObsidianItems.OBSIDERITE_SWORD);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsidian_dust"), ImprovedObsidianItems.OBSIDIAN_DUST);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsidian_shard"), ImprovedObsidianItems.OBSIDIAN_SHARD);
        

    }
}
