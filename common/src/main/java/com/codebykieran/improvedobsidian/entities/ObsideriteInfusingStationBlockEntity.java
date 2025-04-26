package com.codebykieran.improvedobsidian.entities;

import com.codebykieran.improvedobsidian.Constants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ObsideriteInfusingStationBlockEntity extends AbstractFurnaceBlockEntity {
    public ObsideriteInfusingStationBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModEntityTypes.OBSIDERITE_INFUSING_STATION, pos, blockState, RecipeType.SMELTING);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.infusing");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return null;
    }

    private static void registerBlockEntityType(String name,BlockEntityType<ObsideriteInfusingStationBlockEntity> blockEntityType) {

        ResourceKey<BlockEntityType<?>> key = ResourceKey.create(Registries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
        Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, key, blockEntityType);
    }
}
