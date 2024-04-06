package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import com.creeping_creeper.tinkers_thinking.common.things.ModEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

import static slimeknights.tconstruct.library.tools.helper.ModifierUtil.getModifierLevel;

public class SculkCatalyseModifier extends NoLevelsModifier implements ToolDamageModifierHook  {
    @SubscribeEvent
    public void onPlayerPickupXp(PlayerXpEvent.PickupXp event) {
        var orb = event.getOrb().getValue();
        var player = event.getEntity();
            if (player != null&&getModifierLevel(player.getItemInHand(InteractionHand.MAIN_HAND), ModModifiers.SculkCatalyse.get().getId()) + getModifierLevel(player.getItemInHand(InteractionHand.OFF_HAND), ModModifiers.SculkCatalyse.get().getId()) > 0) {
                int time = orb * 60;
                if (player.hasEffect(ModEffects.sculk_power.get())) {
                   time = time + Objects.requireNonNull(player.getEffect(ModEffects.sculk_power.get())).getDuration() ;
                }
                player.addEffect(new MobEffectInstance(ModEffects.sculk_power.get(), time));
                player.giveExperiencePoints(-orb);
            }
    }
    @Override
    protected void registerHooks(ModifierHookMap.@NotNull Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, TinkerHooks.TOOL_DAMAGE);
    }
    @Override
    public int getPriority() {
        return 200;
    }
    @Override
    public int onDamageTool(@NotNull IToolStackView tool, @NotNull ModifierEntry modifier, int amount, @Nullable LivingEntity holder) {
        if (holder!= null&&holder.hasEffect(ModEffects.sculk_power.get())){
            amount = 0;
        }
        return amount;
    }
}
