package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.utils.TooltipKey;

import javax.annotation.Nullable;
import java.util.List;

public class LightPowerModifier extends Modifier implements ProjectileHitModifierHook, ConditionalStatModifierHook {
    public LightPowerModifier() {
    }

    private static float getBonus(int level, @Nullable LivingEntity holder) {
        if (holder != null) {
            Level world = holder.getCommandSenderWorld();
            int light = Math.max(world.getBrightness(LightLayer.BLOCK,holder.blockPosition()) - (world.getBrightness(LightLayer.SKY, holder.blockPosition()) - world.getSkyDarken()),0);
            return (float) (level * light);
        }
        return 0;
    }



    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT, TinkerHooks.CONDITIONAL_STAT);
    }

    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        return damage + getBonus(level, context.getAttacker()) * 0.25f * tool.getMultiplier(ToolStats.ATTACK_DAMAGE);
    }
    @Override
    public float modifyStat(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, @NotNull LivingEntity living, @NotNull FloatToolStat stat, float baseValue, float multiplier) {
        if (stat == ToolStats.PROJECTILE_DAMAGE) {
            return baseValue += getBonus(modifier.getLevel(), living) * 0.25f * multiplier;
        }
        return baseValue;
    }

    public void addInformation(@NotNull IToolStackView tool, int level, @Nullable Player player, @NotNull List<Component> tooltip, @NotNull TooltipKey key, @NotNull TooltipFlag flag) {
        if (player!=null) {
            Level world = player.getCommandSenderWorld();
            float bonus = (float) (level * 0.25 * Math.max((world.getBrightness(LightLayer.BLOCK, player.blockPosition()) - (world.getBrightness(LightLayer.SKY, player.blockPosition()) - world.getSkyDarken())), 0));
            this.addDamageTooltip(tool, bonus, tooltip);
        }
    }
}

