package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class InspiredModifier extends Modifier implements BlockBreakModifierHook {
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.BLOCK_BREAK);
    }
    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        if (context.canHarvest() && context.isEffective() && !context.isAOE() && RANDOM.nextFloat() <  0.25) {
            LivingEntity living = context.getLiving();
            living.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,20,1,true,true));
            ToolDamageUtil.directDamage(tool, modifier.getLevel() * 5, living, living.getUseItem());
        }
    }
}
