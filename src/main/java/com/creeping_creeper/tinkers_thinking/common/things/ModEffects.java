package com.creeping_creeper.tinkers_thinking.common.things;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TinkersThinking.MODID);
    public static final RegistryObject<MobEffect> overweight = MOB_EFFECTS.register("overweight",() -> new NoMilkEffect(MobEffectCategory.HARMFUL, 0x8f2e91,true).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "3407DE5E-7CE8-4030-940E-514C1F160890", 2, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final RegistryObject<MobEffect> weightless = MOB_EFFECTS.register("weightless",() -> new NoMilkEffect(MobEffectCategory.BENEFICIAL, 0x16b944,true).addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "3407DE5E-7CE8-4030-940E-514C1F160891", -0.5, AttributeModifier.Operation.MULTIPLY_BASE));
    public static final RegistryObject<MobEffect> sculk_power = MOB_EFFECTS.register("sculk_power",() -> new NoMilkEffect(MobEffectCategory.BENEFICIAL, 0x009295,true));
    public static final RegistryObject<MobEffect> modifier_immune = MOB_EFFECTS.register("modifier_immune",() -> new NoMilkEffect(MobEffectCategory.BENEFICIAL, 0xff7f27,true));
    public static void registers(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
