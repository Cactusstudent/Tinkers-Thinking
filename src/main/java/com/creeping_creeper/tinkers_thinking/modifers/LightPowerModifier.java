package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
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
            int light = world.getBrightness(LightLayer.SKY, holder.blockPosition()) - world.getSkyDarken();
            return (float) (level * light);
        }
        return 0;
    }

    ;


    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT, TinkerHooks.CONDITIONAL_STAT);
    }

    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        return damage + getBonus(level, context.getAttacker()) * 0.2f * tool.getMultiplier(ToolStats.ATTACK_DAMAGE);
    }
    @Override
    public float modifyStat(IToolStackView tool, ModifierEntry modifier,  LivingEntity living, FloatToolStat stat, float baseValue, float multiplier) {
        if (stat == ToolStats.PROJECTILE_DAMAGE) {
            return baseValue += getBonus(modifier.getLevel(), (LivingEntity) living) * 0.2f * multiplier;
        }
        return baseValue;
    }

    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey key, TooltipFlag flag) {
        Level world = player.getCommandSenderWorld();
        float bonus = level * Math.abs(world.getBrightness(LightLayer.SKY, player.blockPosition()) - world.getSkyDarken());
        this.addDamageTooltip(tool, bonus, tooltip);
    }
}

