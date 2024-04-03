package com.creeping_creeper.tinkers_thinking.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {
    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;
    public static class Common {
        public final ForgeConfigSpec.IntValue ArditeOreSpawnPerChunk;
        public final ForgeConfigSpec.IntValue ChlorophyllOreSpawnPerChunk;
        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Ore Spawn");
            ArditeOreSpawnPerChunk = builder
                    .comment("Weight of Ardite Ore Spawn")
                    .worldRestart()
                    .defineInRange("ardite_ore_spawn_per_chunk", 5, 0, 40);
            ChlorophyllOreSpawnPerChunk = builder
                    .comment("Weight of chlorophyll Ore Spawn")
                    .worldRestart()
                    .defineInRange("chlorophyll_ore_spawn_per_chunk", 9, 0, 40);
            builder.pop();
        }
    }
        static {
            final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
            commonSpec = specPair.getRight();
            COMMON = specPair.getLeft();
            ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModConfigs.commonSpec);
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        }
}
