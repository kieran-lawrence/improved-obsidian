package com.codebykieran.improvedobsidian.items;

import com.codebykieran.improvedobsidian.Constants;
import com.codebykieran.improvedobsidian.core.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ImprovedObsidianItems {

    public static void init() {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite_hoe"), ModItems.OBSIDERITE_HOE);
    }
}
