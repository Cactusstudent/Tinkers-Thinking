package com.creeping_creeper.tinkers_thinking.gen;

import com.creeping_creeper.tinkers_thinking.configs.TinkersThinkingCommanConfigs;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class TinkersThinkingOreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        if (TinkersThinkingCommanConfigs.Ardite_Ore_Spawn.get() && event.getCategory() == Biome.BiomeCategory.NETHER){
            base.add(TinkersThinkingPlacedFeatures.Ardite_Ore_Placed);
        };
        if ((TinkersThinkingCommanConfigs.Chlorophyll_Ore_Spawn.get() && (event.getCategory() == Biome.BiomeCategory.JUNGLE || is(Biomes.LUSH_CAVES))))
         {
            base.add(TinkersThinkingPlacedFeatures.Chlorophyll_Ore_Placed);
        }
    }

    private static boolean is(ResourceKey<Biome> LUSH_CAVE) {
        return true;
    }
}
