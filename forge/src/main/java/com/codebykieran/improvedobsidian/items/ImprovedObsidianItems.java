package com.codebykieran.improvedobsidian.items;
import com.codebykieran.improvedobsidian.Constants;
import com.codebykieran.improvedobsidian.core.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.HoeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.RegistryObject;

public class ImprovedObsidianItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    public static final RegistryObject<? extends Item> OBSIDERITE_HOE = ITEMS.register("obsiderite_hoe", () ->
            ModItems.OBSIDERITE_HOE);

    public static void init() {
        final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modBus);
    }
}
