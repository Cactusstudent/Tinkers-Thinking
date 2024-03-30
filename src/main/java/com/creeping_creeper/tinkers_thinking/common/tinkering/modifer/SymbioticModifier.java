package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

import javax.annotation.Nullable;

public class SymbioticModifier extends Modifier implements GeneralInteractionModifierHook, ProjectileLaunchModifierHook {
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.GENERAL_INTERACT,TinkerHooks.PROJECTILE_LAUNCH);
    }
    @Override
    public int getPriority() {
        return 15;
    }
    @Override
    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, InteractionSource source) {
        if (source == InteractionSource.RIGHT_CLICK && !tool.isBroken() &&player.getMaxHealth()>player.getHealth()) {
            GeneralInteractionModifierHook.startUsing(tool, modifier.getId(), player, hand);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
    @Override
    public void onFinishUsing(IToolStackView tool, ModifierEntry modifier, LivingEntity entity) {
        // remove is eating tag to prevent from messing with other modifiers
        ModDataNBT persistentData = tool.getPersistentData();
        if (entity.getMaxHealth()>entity.getHealth()&&!tool.isBroken() && entity instanceof Player player && player.canEat(false)) {
            // eat the food
            int level = modifier.getLevel();
            Level world = entity.getLevel();
            player.heal(Math.max(level,player.getMaxHealth()*0.2f));
            player.awardStat(Stats.ITEM_USED.get(tool.getItem()));
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.4F);
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP, SoundSource.NEUTRAL, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
            player.level.playSound(null, player.getX(), player.getY(),player.getZ(), Sounds.NECROTIC_HEAL.getSound(), SoundSource.PLAYERS, 1.0f, 1.0f);
            // take a bit of extra damage to heal
            // 8 damage for a bite per level, does not process reinforced/overslime, your teeth are tough
            if (ToolDamageUtil.directDamage(tool, 8 * level, player, player.getUseItem())) {
                player.broadcastBreakEvent(player.getUsedItemHand());
            }
        }
    }

    @Override
    public UseAnim getUseAction(IToolStackView tool, ModifierEntry modifier) {
        return UseAnim.EAT;
    }

    @Override
    public int getUseDuration(IToolStackView tool, ModifierEntry modifier) {
        return 8;
    }
    @Override
    public void onProjectileLaunch(IToolStackView tool, ModifierEntry modifier, LivingEntity entity, Projectile projectile, @Nullable AbstractArrow arrow, NamespacedNBT persistentData, boolean primary) {
        if (entity.getMaxHealth()>entity.getHealth()&&!tool.isBroken() && entity instanceof Player player && player.canEat(false)) {
            int level = modifier.getLevel();
            player.heal(Math.max(level,player.getMaxHealth()*0.2f));
            player.level.playSound(null, player.getX(), player.getY(),player.getZ(), Sounds.NECROTIC_HEAL.getSound(), SoundSource.PLAYERS, 1.0f, 1.0f);
            if (ToolDamageUtil.directDamage(tool, 8 * level, player, player.getUseItem())) {
                player.broadcastBreakEvent(player.getUsedItemHand());
            }
        }
    }
}
