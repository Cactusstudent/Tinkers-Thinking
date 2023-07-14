package com.creeping_creeper.tinkers_thinking.gen;

import com.creeping_creeper.tinkers_thinking.things.TinkersThinkingBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class TinkersThinkingConfiguredFeatures {
    public static final List<OreConfiguration.TargetBlockState> NETHER_Ardite_Ore = List.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, TinkersThinkingBlocks.ardite_ore.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> Ardite_Ore = FeatureUtils.register("ardite_ore", Feature.ORE, new OreConfiguration(NETHER_Ardite_Ore, 3));
}
