package com.codebykieran.improvedobsidian.item;

import com.codebykieran.improvedobsidian.utils.ImprovedObsidianTiers;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;

public class ObsideriteHammerItem  extends DiggerItem {
    public ObsideriteHammerItem(Properties properties) {
        super(ImprovedObsidianTiers.OBSIDERITE, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }
}
