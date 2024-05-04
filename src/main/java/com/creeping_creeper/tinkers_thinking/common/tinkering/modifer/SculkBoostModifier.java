package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import com.creeping_creeper.tinkers_thinking.common.things.ModEffects;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.utils.Util;

import java.util.List;

public class SculkBoostModifier extends Modifier implements TooltipModifierHook,ConditionalStatModifierHook , BreakSpeedModifierHook {
    private static final Component Boost = TConstruct.makeTranslation("modifier", "sculk_boost.boost");

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);

        hookBuilder.addHook(this, ModifierHooks.TOOLTIP,ModifierHooks.BREAK_SPEED,ModifierHooks.CONDITIONAL_STAT);
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
    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if ((tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE))&&player!=null) {
            float bonus = 0;
            if (player.hasEffect(ModEffects.sculk_power.get())) {
                bonus = (float) (0.20 * modifier.getLevel());
            }
            tooltip.add(applyStyle(Component.literal(Util.PERCENT_BOOST_FORMAT.format(bonus) + " ").append(Boost)));
        }
        }
    }
