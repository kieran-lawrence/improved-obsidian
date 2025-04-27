package com.codebykieran.improvedobsidian.items;

import com.codebykieran.improvedobsidian.Constants;
import com.codebykieran.improvedobsidian.tags.ModItemTags;
import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.*;
import java.util.Map;
import static net.minecraft.world.item.equipment.EquipmentAssets.ROOT_ID;

public interface ModArmorMaterials extends ArmorMaterials {
    ArmorMaterial OBSIDERITE = new ArmorMaterial(
            41, makeDefense(4, 7, 9, 4, 12), 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, ModItemTags.REPAIRS_OBSIDERITE_ARMOR,
            createEquipmentAsset("obsiderite")
    );

    private static Map<ArmorType, Integer> makeDefense(int bootArmorAmount, int leggingsArmorAmount, int chestplateArmorAmount, int helmetArmorAmount, int bodyArmorAmount) {
        return Maps.newEnumMap(
                Map.of(
                        ArmorType.BOOTS,
                        bootArmorAmount,
                        ArmorType.LEGGINGS,
                        leggingsArmorAmount,
                        ArmorType.CHESTPLATE,
                        chestplateArmorAmount,
                        ArmorType.HELMET,
                        helmetArmorAmount,
                        ArmorType.BODY,
                        bodyArmorAmount
                )
        );
    }

    static ResourceKey<EquipmentAsset> createEquipmentAsset(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name));
    }
}
