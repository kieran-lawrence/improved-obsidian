package com.codebykieran.improvedobsidian.tags;

import com.codebykieran.improvedobsidian.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {
    public static final TagKey<Item> OBSIDERITE_TOOL_MATERIALS = bind("obsiderite_tool_materials");
    public static final TagKey<Item> REPAIRS_OBSIDERITE_ARMOR = bind("repairs_obsiderite_armor");

    private static TagKey<Item> bind(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }
}
