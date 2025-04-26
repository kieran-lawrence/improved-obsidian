package com.codebykieran.improvedobsidian;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems {
    public static void initialise() {}

    public static final Item OBSIDIAN_CLUSTER = registerBlockItem(ModBlocks.OBSIDIAN_CLUSTER,BlockItem::new,new Item.Properties());
    public static final Item BUDDING_OBSIDIAN = registerBlockItem(ModBlocks.BUDDING_OBSIDIAN,BlockItem::new,new Item.Properties());
    public static final Item SMALL_OBSIDIAN_BUD = registerBlockItem(ModBlocks.SMALL_OBSIDIAN_BUD,BlockItem::new,new Item.Properties());
    public static final Item MEDIUM_OBSIDIAN_BUD = registerBlockItem(ModBlocks.MEDIUM_OBSIDIAN_BUD,BlockItem::new,new Item.Properties());
    public static final Item LARGE_OBSIDIAN_BUD = registerBlockItem(ModBlocks.LARGE_OBSIDIAN_BUD,BlockItem::new,new Item.Properties());
    public static final Item OBSIDERITE_INFUSING_STATION = registerBlockItem(ModBlocks.OBSIDERITE_INFUSING_STATION, BlockItem::new, new Item.Properties());
    public static final Item OBSIDIAN_SHARD = registerItem(getItemId("obsidian_shard"),Item::new, new Item.Properties()); //.trimMaterial(TrimMaterials.AMETHYST)); //TODO: Create new trim material

    private static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> blockId) {
        return ResourceKey.create(Registries.ITEM, blockId.location());
    }

    public static Item registerBlockItem(Block block, BiFunction<Block, Item.Properties, Item> factory, Item.Properties properties) {
        return registerItem(
                blockIdToItemId(block.builtInRegistryHolder().key()), key -> factory.apply(block, key), properties.useBlockDescriptionPrefix()
        );
    }

    public static Item registerItem(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties properties) {
        Item item = factory.apply(properties.setId(key));
        if (item instanceof BlockItem blockitem) {
            blockitem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static ResourceKey<Item> getItemId(String name) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,name));
    }
}
