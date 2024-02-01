package com.creeping_creeper.tinkers_thinking.common.world;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModPlacedFeatures
{
        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
                DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, TinkersThinking.MODID);
        public static final RegistryObject<PlacedFeature> NETHER_ARDITE_ORE_PLACED = PLACED_FEATURES.register("nether_ardite_ore_placed",
                () -> new PlacedFeature(ModConfiguredFeatures.NETHER_ARDITE_ORE.getHolder().get(),
                        commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(48)))));
        public static final RegistryObject<PlacedFeature> CHLOROPHYLL_ORE_PLACED = PLACED_FEATURES.register("chlorophyll_ore_placed",
                () -> new PlacedFeature(ModConfiguredFeatures.OVERWORLD_CHLOROPHYLL_ORE.getHolder().get(),
                        commonOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-48), VerticalAnchor.aboveBottom(48)))));
        private static List<PlacementModifier> orePlacement (PlacementModifier p_195347_, PlacementModifier p_195348_){
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }
        private static List<PlacementModifier> commonOrePlacement ( int p_195344_, PlacementModifier p_195345_){
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
        private static List<PlacementModifier> rareOrePlacement ( int p_195350_, PlacementModifier p_195351_){
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
    public static void registers(IEventBus modEventBus){
            PLACED_FEATURES.register(modEventBus);
     }
}