package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class PricklyModifier extends Modifier implements MeleeDamageModifierHook{

    public int getPriority() {
        return 95;
    }
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.MELEE_DAMAGE);
    }
    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && target.isAlive() && !context.isExtraAttack() && context.isFullyCharged() ) {
            float bonus = (float) (RANDOM.nextFloat()*0.12*modifier.getLevel());
            damage *=  1.0f+bonus;
        }
        return damage;
    }

}
