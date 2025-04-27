package com.codebykieran.improvedobsidian.items;

import com.codebykieran.improvedobsidian.tags.ModBlockTags;
import com.codebykieran.improvedobsidian.tags.ModItemTags;
import net.minecraft.world.item.ToolMaterial;

public record ModToolMaterials() {
    public static final ToolMaterial OBSIDERITE = new ToolMaterial(
            ModBlockTags.INCORRECT_FOR_OBSIDERITE_TOOL, 2437, 9.5F, 4.2F, 15, ModItemTags.OBSIDERITE_TOOL_MATERIALS
    );
}
