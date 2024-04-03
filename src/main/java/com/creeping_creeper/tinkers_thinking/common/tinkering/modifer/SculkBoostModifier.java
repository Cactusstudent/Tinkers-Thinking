package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import com.creeping_creeper.tinkers_thinking.common.things.ModEffects;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class SculkBoostModifier extends Modifier implements ConditionalStatModifierHook , BreakSpeedModifierHook{
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,  TinkerHooks.BREAK_SPEED,TinkerHooks.CONDITIONAL_STAT);
    }
    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        if (!isEffective) {
            return;
        }
        if (event.getEntity().hasEffect(ModEffects.sculk_power.get())){
            event.setNewSpeed((float) (event.getNewSpeed() * (1 + modifier.getLevel() * 0.2)));
        }
    }
    @Override
    public float modifyStat(IToolStackView tool, ModifierEntry modifier, LivingEntity living, FloatToolStat stat, float baseValue, float multiplier) {
        if (living.hasEffect(ModEffects.sculk_power.get())) {
            if (stat ==ToolStats.ATTACK_SPEED) {
                return (float) (baseValue*( 1+(0.2*modifier.getLevel())));
            }
            if (stat ==ToolStats.PROJECTILE_DAMAGE) {
                return (float) (baseValue*( 1+(0.2*modifier.getLevel())));
            }
            if (stat ==ToolStats.DRAW_SPEED) {
                return (float) (baseValue*( 1+(0.2*modifier.getLevel())));
            }
        }
        return baseValue;
    }
}
