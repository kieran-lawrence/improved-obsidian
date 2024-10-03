package com.codebykieran.improvedobsidian.core;

import com.codebykieran.improvedobsidian.item.*;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import static net.minecraft.world.item.Item.BASE_ATTACK_DAMAGE_ID;
import static net.minecraft.world.item.Item.BASE_ATTACK_SPEED_ID;

public class ImprovedObsidianItems {
    // Tools & Utilities
    public static final Item OBSIDERITE_AXE = new ObsideriteAxeItem(new Item.Properties()
        .stacksTo(1)
        .fireResistant()
        .attributes(generateItemAttributes(10,-3.0f)
    ));
    public static final Item OBSIDERITE_HAMMER = new ObsideriteHammerItem(new Item.Properties()
        .stacksTo(1)
        .fireResistant()
        .attributes(generateItemAttributes(9,-2.3f)
    ));
    public static final Item OBSIDERITE_HOE = new ObsideriteHoeItem(new Item.Properties()
        .stacksTo(1)
        .fireResistant()
        .attributes(generateItemAttributes(0,0.4f)
    ));
    public static final Item OBSIDERITE_PICKAXE = new ObsideritePickaxeItem(new Item.Properties()
        .stacksTo(1)
        .fireResistant()
        .attributes(generateItemAttributes(6,-2.7f)
    ));
    public static final Item OBSIDERITE_SHOVEL = new ObsideriteShovelItem(new Item.Properties()
        .stacksTo(1)
        .fireResistant()
        .attributes(generateItemAttributes(6.5,-3.0f)
    ));


    // Armor
    // OBSIDERITE_BOOTS
    // OBSIDERITE_CHESTPLATE
    // OBSIDERITE_HELMET
    // OBSIDERITE_LEGGINGS


    // Combat
    public static final Item OBSIDERITE_SWORD = new ObsideriteSwordItem(new Item.Properties()
        .stacksTo(1)
        .fireResistant()
        .attributes(generateItemAttributes(8,-2.3f)
    ));

    // Ingredients
    public static final Item OBSIDERITE_DUST = new ObsideriteDustItem(new Item.Properties());
    public static final Item OBSIDERITE_INGOT = new ObsideriteIngotItem(new Item.Properties());
    public static final Item OBSIDIAN_DUST = new ObsidianDustItem(new Item.Properties());
    public static final Item OBSIDIAN_SHARD = new ObsidianShardItem(new Item.Properties());

    private static ItemAttributeModifiers generateItemAttributes(double attackDamage,float attackSpeed) {
        return ItemAttributeModifiers.builder()
        // Set the items attack damage
        .add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        )
        // Set the items attack speed
        .add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        )
        .build();
    }
}
