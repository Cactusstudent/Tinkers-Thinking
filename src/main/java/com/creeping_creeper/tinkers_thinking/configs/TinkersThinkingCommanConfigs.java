package com.creeping_creeper.tinkers_thinking.configs;

import net.minecraftforge.common.ForgeConfigSpec;

public class TinkersThinkingCommanConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Boolean> Ardite_Ore_Spawn;
    public static final ForgeConfigSpec.ConfigValue<Integer> Ardite_Ore_Veins_Per_Chunk;
    public static final ForgeConfigSpec.ConfigValue<Integer> Ardite_Ore_Veins_Size;
    public static final ForgeConfigSpec.ConfigValue<Boolean> Chlorophyll_Ore_Spawn;
    public static final ForgeConfigSpec.ConfigValue<Integer> Chlorophyll_Ore_Veins_Per_Chunk;
    public static final ForgeConfigSpec.ConfigValue<Integer> Chlorophyll_Ore_Veins_Size;

    static {
        BUILDER.push("configs for Tinkers' Thinking");
        Ardite_Ore_Spawn = BUILDER.comment("If true,Ardite Ore spawn will spawn in Nether.").define("Ardite Ore spawn",true);
        Ardite_Ore_Veins_Per_Chunk = BUILDER.comment("How many Ardite Ore Veins spawn per chunk.").define("Ardite Veins per chunk",5);
        Ardite_Ore_Veins_Size = BUILDER.comment("How many Ardite Ore Blocks spawn in one Vein.").defineInRange("Ardite Vein Size",4,0,32);
        Chlorophyll_Ore_Spawn = BUILDER.comment("If true,Chlorophyll Ore spawn will spawn in Jungle and Lush Caves.").define("Chlorophyll Ore spawn",true);
        Chlorophyll_Ore_Veins_Per_Chunk = BUILDER.comment("How many Chlorophyll Ore Veins spawn per chunk.").define("Chlorophyll Veins per chunk",7);
        Chlorophyll_Ore_Veins_Size = BUILDER.comment("How many Chlorophyll Ore Blocks spawn in one Vein.").defineInRange("Chlorophyll Vein Size",6,0,32);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
