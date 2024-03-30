package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;

public class DuritaeModifier extends Modifier implements ToolDamageModifierHook{
    @Override
    public int getPriority() {
        return 1875; // after , before
    }
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, TinkerHooks.TOOL_DAMAGE);
    }
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity holder)  {
        if (holder != null){
               float chance1 = (float) Math.pow(0.70,modifier.getLevel());
               float chance2 =  (float) Math.pow(0.95,modifier.getLevel());
                int maxDamage = amount;
                // for each damage we will take, if the random number is below chance, reduce
                for (int i = 0; i < maxDamage; i++) {
                    if (RANDOM.nextFloat() > chance1) {
                        amount--;
                    }
                    if (RANDOM.nextFloat() > chance2) {
                        amount++;
                    }
            }
        }
        return amount;
    }
}
