package com.codebykieran.improvedobsidian.utils;

import com.codebykieran.improvedobsidian.Constants;
import com.codebykieran.improvedobsidian.core.ImprovedObsidianItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ImprovedObsidianArmorMaterials extends ArmorMaterials {

    public static final Holder<ArmorMaterial> OBSIDERITE = register(Util.make(new EnumMap<>(ArmorItem.Type.class), slot -> {
        slot.put(ArmorItem.Type.BOOTS, 4);
        slot.put(ArmorItem.Type.LEGGINGS, 7);
        slot.put(ArmorItem.Type.CHESTPLATE, 9);
        slot.put(ArmorItem.Type.HELMET, 4);
        slot.put(ArmorItem.Type.BODY, 12);
    }), () -> Ingredient.of(ImprovedObsidianItems.OBSIDERITE_INGOT));

    private static Holder<ArmorMaterial> register(
            EnumMap<ArmorItem.Type, Integer> pDefense,
            Supplier<Ingredient> pRepairIngredient
    ) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite")));

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, pDefense.get(armoritem$type));
        }

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID,"obsiderite"),
                new ArmorMaterial(enummap, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, pRepairIngredient, layers, 3.5f, 0.15f)
        );
    }


}
