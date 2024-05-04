package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import com.creeping_creeper.tinkers_thinking.common.things.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

public class SculkLevitateModifier extends NoLevelsModifier implements MeleeHitModifierHook, ProjectileHitModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT,ModifierHooks.PROJECTILE_HIT);

    }
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (!context.isExtraAttack() && context.isFullyCharged()) {
            LivingEntity attacker = context.getAttacker();
            LivingEntity target = context.getLivingTarget();
            if (attacker.hasEffect(ModEffects.sculk_power.get())&&target!=null&&!target.hasEffect(ModEffects.modifier_immune.get())) {
                target.addEffect(new MobEffectInstance(MobEffects.LEVITATION,20,1,true,true));
                target.addEffect(new MobEffectInstance(ModEffects.weightless.get(),120,2,true,true));
                target.addEffect(new MobEffectInstance(ModEffects.modifier_immune.get(), 360/modifier.getLevel(), 1));
            }
        }
    }
    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @javax.annotation.Nullable LivingEntity attacker, @javax.annotation.Nullable LivingEntity target) {
        if (target!=null&&!target.hasEffect(ModEffects.modifier_immune.get())&&projectile instanceof AbstractArrow &&attacker!=null&&attacker.hasEffect(ModEffects.sculk_power.get())) {
            target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 1,true,true));
            target.addEffect(new MobEffectInstance(ModEffects.weightless.get(), 120, 2,true,true));
            target.addEffect(new MobEffectInstance(ModEffects.modifier_immune.get(), 360/modifier.getLevel(), 1));
        }
        return false;
    }
}
