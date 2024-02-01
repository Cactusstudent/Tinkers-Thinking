package com.creeping_creeper.tinkers_thinking.common.things;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModMobEffect extends MobEffect {
    public ModMobEffect(MobEffectCategory typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    public void tick(LivingTickEvent event) {}

    public void onPotionAdded(MobEffectEvent.Added event) {}

    public void isPotionApplicable(MobEffectEvent.Applicable event) {}

    public void onPotionRemove(MobEffectEvent.Remove event) {}

    public void onPotionExpiry(MobEffectEvent.Expired event) {}
}