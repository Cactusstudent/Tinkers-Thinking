package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class StimulationModifier extends Modifier implements MeleeHitModifierHook {
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this,  TinkerHooks.MELEE_HIT);
    }
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (!context.isExtraAttack() && context.isFullyCharged()&&RANDOM.nextFloat() < 0.25) {
            LivingEntity attacker = context.getAttacker();
            attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,120 * modifier.getLevel(),2,true,true));
            ToolDamageUtil.directDamage(tool,  modifier.getLevel() * 5, attacker, attacker.getUseItem());
        }
    }
}
