package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.utils.Util;

import java.util.List;

public class MockModifier extends Modifier implements ConditionalStatModifierHook, TooltipModifierHook, MeleeDamageModifierHook,MeleeHitModifierHook, ProjectileHitModifierHook {
    private static final Component ATTACK_DAMAGE = TConstruct.makeTranslation("modifier", "mock.attack_damage");
    public int getPriority() {
        return 90;
    }
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this,  TinkerHooks.PROJECTILE_HIT, TinkerHooks.CONDITIONAL_STAT, TinkerHooks.MELEE_DAMAGE, TinkerHooks.MELEE_HIT,TinkerHooks.TOOLTIP);
    }
    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && target.isAlive() && !context.isExtraAttack() && context.isFullyCharged()&& target.hasEffect(MobEffects.INVISIBILITY) ) {
            float bonus = (float) (0.2*modifier.getLevel());
            damage *=  1.0f+bonus;
        }
        return damage;
    }
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (!context.isExtraAttack() && context.isFullyCharged()) {
            LivingEntity target = context.getLivingTarget();
            target.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,200,2,true,true));
        }
    }
    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @javax.annotation.Nullable LivingEntity attacker, @javax.annotation.Nullable LivingEntity target) {
        if (target != null  && projectile instanceof AbstractArrow arrow) {
            target.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2, true, true));
         }
        if (target.isAlive()&&target.hasEffect(MobEffects.INVISIBILITY) && projectile instanceof AbstractArrow arrow) {
                arrow.setBaseDamage(arrow.getBaseDamage() * ((float) (modifier.getLevel() * 0.2) + 1));
         }
        return false;
    }
    @Override
    public float modifyStat(IToolStackView tool, ModifierEntry modifier, LivingEntity living, FloatToolStat stat, float baseValue, float multiplier) {
        return 0;
    }
    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if (tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE)) {
            float bonus = (float) (0.20*modifier.getLevel());
            tooltip.add(applyStyle(Component.literal(Util.PERCENT_BOOST_FORMAT.format(bonus) + " ").append(ATTACK_DAMAGE)));
        }
    }
}
