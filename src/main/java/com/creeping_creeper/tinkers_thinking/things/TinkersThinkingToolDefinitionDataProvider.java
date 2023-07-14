package com.creeping_creeper.tinkers_thinking.things;


import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

import static slimeknights.tconstruct.tools.TinkerModifiers.*;
import static slimeknights.tconstruct.tools.TinkerToolParts.*;
import static slimeknights.tconstruct.tools.data.ModifierIds.antiaquatic;
import static slimeknights.tconstruct.tools.data.ModifierIds.killager;


public class TinkersThinkingToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {

    public TinkersThinkingToolDefinitionDataProvider(DataGenerator generator) {
        super(generator, tinkers_thinking.MOD_ID);
    }

    @Override
    protected void addToolDefinitions() {
    define(TinkersThinkingToolDefinitions.Paxel)
            // parts
                .part(smallAxeHead)
                .part(toolHandle)
                .part(pickHead)
    // stats
                .stat(ToolStats.ATTACK_DAMAGE, 4.5f)
                .stat(ToolStats.ATTACK_SPEED, 1.1f)
                .multiplier(ToolStats.MINING_SPEED, 0.8f)
                .multiplier(ToolStats.DURABILITY, 1.25f)
                .largeToolStartingSlots()
    // traits
                .trait(killager)
                .trait(axeScrape);

    define(TinkersThinkingToolDefinitions.Knife)
    // parts
                .part(TinkersThinkingItems.Narrow_Blade)
                .part(toolHandle)
                .part(TinkersThinkingItems.Narrow_Blade)
    // stats
                .stat(ToolStats.ATTACK_DAMAGE, 3.5f)
                .stat(ToolStats.ATTACK_SPEED, 1.8f)
                .multiplier(ToolStats.MINING_SPEED, 1.2f)
                .multiplier(ToolStats.DURABILITY, 0.8f)
                .multiplier(ToolStats.ATTACK_DAMAGE, 0.8f)
                .largeToolStartingSlots()
    // traits
                .trait(antiaquatic);

    define(TinkersThinkingToolDefinitions.Arrow_Thrower)
                // parts
                .part(bowGrip)
                .part(bowLimb)
                .part(bowGrip)
                // stats
                .stat(ToolStats.DURABILITY, 100)
                .stat(ToolStats.VELOCITY, 0.65f)
                .stat(ToolStats.ACCURACY,0.65f)
                .stat(ToolStats.ATTACK_DAMAGE,2.5f)
                .stat(ToolStats.ATTACK_SPEED, 1.2f)
                .stat(ToolStats.USE_ITEM_SPEED,0.65f)
                .multiplier(ToolStats.DURABILITY, 1.25f)
                .multiplier(ToolStats.DRAW_SPEED,10.0f)
                .multiplier(ToolStats.PROJECTILE_DAMAGE,0.5f)
                .largeToolStartingSlots();

    }

    @Nonnull
    @Override
    public String getName() {
        return "Tinkers Thinking Tool Definitions";
    }
}