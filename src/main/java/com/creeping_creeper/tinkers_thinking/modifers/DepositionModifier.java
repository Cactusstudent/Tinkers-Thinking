package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;

public class DepositionModifier extends Modifier {
    @Override
    public int getPriority() {
        return 180; // after , before
    }
    public int onDamageTool(IToolStackView tool, int level, int amount, @Nullable LivingEntity holder)  {
            if (holder != null){
                Level world = holder.getCommandSenderWorld();
            double maxy = (world.getMaxBuildHeight() - world.getMinBuildHeight()) *0.5;
            double y = holder.getY() - world.getMinBuildHeight();
            if (y > 0) {
                double chance =  Math.min((maxy - y)/maxy * level * 0.80,0.80); // up to  80% a chance at max
                int maxDamage = amount;
                // for each damage we will take, if the random number is below chance, reduce
                for (int i = 0; i < maxDamage; i++) {
                    if (RANDOM.nextFloat() < chance) {
                        amount--;
                    }
                }
                }
            }
        return amount;
    }
}

