package com.codebykieran.improvedobsidian.items;
import com.codebykieran.improvedobsidian.Constants;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianItems;
public class ImprovedObsidianItemsForge {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    private static void registerItems() {
        ITEMS.register("obsiderite_axe", () -> ImprovedObsidianItems.OBSIDERITE_AXE);
        ITEMS.register("obsiderite_boots", () -> ImprovedObsidianItems.OBSIDERITE_BOOTS);
        ITEMS.register("obsiderite_chestplate", () -> ImprovedObsidianItems.OBSIDERITE_CHESTPLATE);
        ITEMS.register("obsiderite_dust", () -> ImprovedObsidianItems.OBSIDERITE_DUST);
        ITEMS.register("obsiderite_hammer", () -> ImprovedObsidianItems.OBSIDERITE_HAMMER);
        ITEMS.register("obsiderite_helmet", () -> ImprovedObsidianItems.OBSIDERITE_HELMET);
        ITEMS.register("obsiderite_hoe", () -> ImprovedObsidianItems.OBSIDERITE_HOE);
        ITEMS.register("obsiderite_ingot", () -> ImprovedObsidianItems.OBSIDERITE_INGOT);
        ITEMS.register("obsiderite_leggings", () -> ImprovedObsidianItems.OBSIDERITE_LEGGINGS);
        ITEMS.register("obsiderite_pickaxe", () -> ImprovedObsidianItems.OBSIDERITE_PICKAXE);
        ITEMS.register("obsiderite_shovel", () -> ImprovedObsidianItems.OBSIDERITE_SHOVEL);
        ITEMS.register("obsiderite_sword", () -> ImprovedObsidianItems.OBSIDERITE_SWORD);
        ITEMS.register("obsidian_dust", () -> ImprovedObsidianItems.OBSIDIAN_DUST);
        ITEMS.register("obsidian_shard", () -> ImprovedObsidianItems.OBSIDIAN_SHARD);
    }
    public static void init() {
        registerItems();
    }
    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
    }
}
