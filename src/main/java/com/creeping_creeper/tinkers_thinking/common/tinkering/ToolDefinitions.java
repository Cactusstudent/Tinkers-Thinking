package com.creeping_creeper.tinkers_thinking.common.tinkering;

import com.creeping_creeper.tinkers_thinking.common.things.ModItems;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;

public final class ToolDefinitions {
    public static final ToolDefinition PAXEL = ToolDefinition.builder(ModItems.paxel).meleeHarvest().build();
    public static final ToolDefinition KNIFE = ToolDefinition.builder(ModItems.knife).meleeHarvest().build();
    public static final ToolDefinition ARROW_THROWER = ToolDefinition.builder(ModItems.arrow_thrower).ranged().build();
    public static final ToolDefinition MAGMA_STAFF = ToolDefinition.builder(ModItems.magma_staff).noParts().build();
    public static final ToolDefinition CLAY_STAFF = ToolDefinition.builder(ModItems.clay_staff).noParts().build();
    public static final ToolDefinition QUARTZ_STAFF = ToolDefinition.builder(ModItems.quartz_staff).meleeHarvest().build();
    public static final ToolDefinition SEARED_BUCKET = ToolDefinition.builder(ModItems.seared_bucket).noParts().build();
    public static final ToolDefinition TINKERS_BRONZE_BUCKET = ToolDefinition.builder(ModItems.tinkers_bronze_bucket).noParts().build();
    public static final ToolDefinition BATTLE_BUCKET = ToolDefinition.builder(ModItems.battle_bucket).noParts().build();
}
