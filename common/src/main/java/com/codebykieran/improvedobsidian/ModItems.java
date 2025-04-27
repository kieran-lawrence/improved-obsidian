package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.items.ModArmorMaterials;
import com.codebykieran.improvedobsidian.items.ModToolMaterials;
import com.codebykieran.improvedobsidian.items.ObsideriteSmithingTemplateItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
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
    public static final Item OBSIDERITE_UPGRADE_SMITHING_TEMPLATE = registerItem(getItemId("obsiderite_upgrade_smithing_template"), ObsideriteSmithingTemplateItem::createObsideriteUpgradeTemplate, new Item.Properties().rarity(Rarity.RARE));
    public static final Item OBSIDERITE_INGOT = registerItem(getItemId("obsiderite_ingot"), Item::new, new Item.Properties().fireResistant());

    public static final Item OBSIDERITE_AXE = registerItem(
            getItemId("obsiderite_axe"), properties -> new AxeItem(ModToolMaterials.OBSIDERITE, 5.2F, -3.0F, properties), new Item.Properties().fireResistant()
    );
    public static final Item OBSIDERITE_HOE = registerItem(
            getItemId("obsiderite_hoe"), properties -> new HoeItem(ModToolMaterials.OBSIDERITE, -4.2F, 0.0F, properties), new Item.Properties().fireResistant()
    );
    public static final Item OBSIDERITE_SHOVEL = registerItem(
            getItemId("obsiderite_shovel"), properties -> new ShovelItem(ModToolMaterials.OBSIDERITE, 1.5F, -3.0F, properties), new Item.Properties().fireResistant()
    );
    public static final Item OBSIDERITE_PICKAXE = registerItem(
            getItemId("obsiderite_pickaxe"), Item::new, new Item.Properties().pickaxe(ModToolMaterials.OBSIDERITE, 1.2F, -2.8F).fireResistant()
    );
    public static final Item OBSIDERITE_SWORD = registerItem(
            getItemId("obsiderite_sword"),Item::new, new Item.Properties().sword(ModToolMaterials.OBSIDERITE, 3.2F, -2.4F).fireResistant()
    );

    public static final Item OBSIDERITE_HELMET = registerItem(
            getItemId("obsiderite_helmet"),Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.OBSIDERITE, ArmorType.HELMET).fireResistant()
    );
    public static final Item OBSIDERITE_CHESTPLATE = registerItem(
            getItemId("obsiderite_chestplate"), Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.OBSIDERITE, ArmorType.CHESTPLATE).fireResistant()
    );
    public static final Item OBSIDERITE_LEGGINGS = registerItem(
            getItemId("obsiderite_leggings"),Item::new, new Item.Properties().humanoidArmor(ModArmorMaterials.OBSIDERITE, ArmorType.LEGGINGS).fireResistant()
    );
    public static final Item OBSIDERITE_BOOTS = registerItem(
            getItemId("obsiderite_boots"), Item::new,new Item.Properties().humanoidArmor(ModArmorMaterials.OBSIDERITE, ArmorType.BOOTS).fireResistant()
    );

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
