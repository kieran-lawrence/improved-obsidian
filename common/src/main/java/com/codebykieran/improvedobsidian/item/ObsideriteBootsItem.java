package com.codebykieran.improvedobsidian.item;

import com.codebykieran.improvedobsidian.utils.ImprovedObsidianArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ObsideriteBootsItem extends ArmorItem {
    public ObsideriteBootsItem(Properties pProperties) {
        super(ImprovedObsidianArmorMaterials.OBSIDERITE, Type.BOOTS, pProperties);
    }
}
