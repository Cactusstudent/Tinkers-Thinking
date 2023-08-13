package com.creeping_creeper.tinkers_thinking.modifers;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.utils.TooltipKey;
import slimeknights.tconstruct.library.utils.Util;

import javax.annotation.Nullable;
import java.util.List;

public class DepositionModifier extends Modifier {
    @Override
    public int getPriority() {
        return 180; // after , before
    }
    private static final Component Percent = tinkers_thinking.makeTranslation("modifier", "deposition.chance");
    public int onDamageTool(IToolStackView tool, int level, int amount, @Nullable LivingEntity holder)  {
            if (holder != null){
                Level world = holder.getCommandSenderWorld();
            double maxy = (world.getMaxBuildHeight() - world.getMinBuildHeight()) ;
            double y = holder.getY() - world.getMinBuildHeight();
            if (y > 0) {
                double chance =  Math.min((maxy - y)/maxy * level * 0.40,0.80); // up to  80% a chance at max
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
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey key, TooltipFlag flag) {
        if (tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE)) {
            Level world = player.getCommandSenderWorld();
            float chance = (float) Math.min(((world.getMaxBuildHeight()  - player.getY()  )/ (world.getMaxBuildHeight() - world.getMinBuildHeight()) *level *0.40),0.80);
            tooltip.add(this.applyStyle((new TextComponent(Util.PERCENT_BOOST_FORMAT.format((double)chance) + " ")).append(Percent)));
        }
    }
}

