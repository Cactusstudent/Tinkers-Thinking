package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class InspiredModifier extends Modifier {
     public void afterBlockBreak(IToolStackView tool, int level, ToolHarvestContext context) {
         {
             if (context.canHarvest() && context.isEffective() && !context.isAOE() && RANDOM.nextFloat() < Math.min(level * 0.25, 1)) {
                 LivingEntity living = context.getLiving();
                 MobEffectInstance effect = new MobEffectInstance(MobEffects.DIG_SPEED, 200, 2);
                 living.addEffect(effect);
                 ToolDamageUtil.directDamage(tool, level * 5, living, living.getUseItem());
             }
         }
     }
}
