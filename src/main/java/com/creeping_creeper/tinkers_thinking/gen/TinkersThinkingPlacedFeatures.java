package com.creeping_creeper.tinkers_thinking.gen;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


public class TinkersThinkingPlacedFeatures {
    public static final Holder<PlacedFeature> Ardite_Ore_Placed = PlacementUtils.register("ardite_ore_placed",
            TinkersThinkingConfiguredFeatures.Ardite_Ore, TinkersThinkingPlaceMent.commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0),
                    VerticalAnchor.aboveBottom(48))));
}
