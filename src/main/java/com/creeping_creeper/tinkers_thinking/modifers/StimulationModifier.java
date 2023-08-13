package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class StimulationModifier extends Modifier {
    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        if (!context.isExtraAttack() && context.isFullyCharged()&&RANDOM.nextFloat() < Math.min(level*0.25,1)) {
            LivingEntity attacker = context.getAttacker();
            MobEffectInstance effect = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2);
            attacker.addEffect(effect);
            ToolDamageUtil.directDamage(tool,  level * 5, attacker, attacker.getUseItem());
        }
        return 0;
    }
}


