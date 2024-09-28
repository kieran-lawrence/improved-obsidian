package com.codebykieran.improvedobsidian;

import com.codebykieran.improvedobsidian.core.ModItems;
import com.codebykieran.improvedobsidian.items.ImprovedObsidianItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class ImprovedObsidian {

    public ImprovedObsidian() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Initialise common mod components
        ImprovedObsidianItems.init();
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.getEntries().putAfter(Items.NETHERITE_HOE.getDefaultInstance(), ModItems.OBSIDERITE_HOE.getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
    private void registerItems() {

    }
}