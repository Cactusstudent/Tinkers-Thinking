package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;
import java.util.List;

public class DepositionModifier extends Modifier implements ToolDamageModifierHook, TooltipModifierHook {
    @Override
    public int getPriority() {
        return 180; // after , before
    }
    private static final Component prefix = TConstruct.makeTranslation("modifier", "deposition.chance");
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, TinkerHooks.TOOL_DAMAGE,TinkerHooks.TOOLTIP);
    }
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity holder)  {
        if (holder != null){
            Level world = holder.getCommandSenderWorld();
            double maxy = (world.getMaxBuildHeight() - world.getMinBuildHeight()) ;
            double y = holder.getY() - world.getMinBuildHeight();
            if (y > 0) {
                double chance =  Math.min((maxy - y)/maxy * modifier.getLevel() * 0.40,0.80); // up to  80% a chance at max
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
    public void addTooltip(IToolStackView tool, @NotNull ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {  if (tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE)) {
            Level world = null;
            if (player != null) {
                world = player.getCommandSenderWorld();
            }
            float chance = 0;
            if (world != null) {
                chance = (float) Math.min(((world.getMaxBuildHeight()  - player.getY()  )/ (world.getMaxBuildHeight() - world.getMinBuildHeight()) *modifier.getLevel() *0.40),0.80);
            }
            TooltipModifierHook.addPercentBoost(this,prefix,chance, tooltip);
        }
    }

}
