package com.creeping_creeper.tinkers_thinking.configs;

import net.minecraftforge.common.ForgeConfigSpec;

public class TinkersThinkingClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("configs for Tinkers' Thinking");
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
