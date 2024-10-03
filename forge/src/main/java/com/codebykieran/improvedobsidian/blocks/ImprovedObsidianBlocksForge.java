package com.codebykieran.improvedobsidian.blocks;

import com.codebykieran.improvedobsidian.Constants;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianBlocks;
import com.codebykieran.improvedobsidian.items.ImprovedObsidianItemsForge;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ImprovedObsidianBlocksForge {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);

    public static void init() {
        registerBlock("obsidian_glass", () -> ImprovedObsidianBlocks.OBSIDIAN_GLASS);
        registerBlock("obsidian_glass_pane", () -> ImprovedObsidianBlocks.OBSIDIAN_GLASS_PANE);
        registerBlock("obsidian_block", () -> ImprovedObsidianBlocks.OBSIDIAN_BLOCK);
        registerBlock("obsiderite_block",() -> ImprovedObsidianBlocks.OBSIDERITE_BLOCK);
        registerBlock("compressed_obsidian",() -> ImprovedObsidianBlocks.COMPRESSED_OBSIDIAN);
        registerBlock("obsidian_wall",() -> ImprovedObsidianBlocks.OBSIDIAN_WALL);
        registerBlock("obsidian_stairs",() -> ImprovedObsidianBlocks.OBSIDIAN_STAIRS);
        registerBlock("obsidian_table_lamp",() -> ImprovedObsidianBlocks.OBSIDIAN_TABLE_LAMP);
        registerBlock("obsidian_end_table",() -> ImprovedObsidianBlocks.OBSIDIAN_END_TABLE);
        registerBlock("obsidian_flower_pot",() -> ImprovedObsidianBlocks.OBSIDIAN_FLOWER_POT);
        registerBlock("obsidian_slab",() ->  ImprovedObsidianBlocks.OBSIDIAN_SLAB);
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private static <T extends Block> void registerBlock(String name, Supplier<T> block) {
        // Register the Block Item first
        RegistryObject<Block> registeredBlock = BLOCKS.register(name,block);
        // Then register the block itself
        ImprovedObsidianItemsForge.ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
    }
}
