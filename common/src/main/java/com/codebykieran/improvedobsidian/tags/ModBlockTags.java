package com.codebykieran.improvedobsidian.tags;

import com.codebykieran.improvedobsidian.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {
    public static final TagKey<Block> INCORRECT_FOR_OBSIDERITE_TOOL = create("incorrect_for_obsiderite_tool");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }
}
