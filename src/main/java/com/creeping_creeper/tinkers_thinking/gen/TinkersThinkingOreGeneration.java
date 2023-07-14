package com.creeping_creeper.tinkers_thinking.gen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class TinkersThinkingOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            base.add(TinkersThinkingPlacedFeatures.Ardite_Ore_Placed);
        }
    }
}