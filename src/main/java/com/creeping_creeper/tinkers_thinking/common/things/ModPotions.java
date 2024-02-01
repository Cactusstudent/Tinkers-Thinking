package com.creeping_creeper.tinkers_thinking.common.things;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, TinkersThinking.MODID);
    public static final RegistryObject<Potion> overweight_potion = POTIONS.register("overweight_potion", () -> new Potion(new MobEffectInstance(ModEffects.overweight.get(), 1200, 0)));
    public static final RegistryObject<Potion> overweight_potion_long = POTIONS.register("overweight_potion_long", () -> new Potion(new MobEffectInstance(ModEffects.overweight.get(), 2400, 0)));
    public static final RegistryObject<Potion> overweight_potion_strong = POTIONS.register("overweight_potion_strong", () -> new Potion(new MobEffectInstance(ModEffects.overweight.get(), 600, 1)));
    public static final RegistryObject<Potion> weightless_potion = POTIONS.register("weightless_potion", () -> new Potion(new MobEffectInstance(ModEffects.weightless.get(), 1200, 0)));
    public static final RegistryObject<Potion> weightless_potion_long = POTIONS.register("weightless_potion_long", () -> new Potion(new MobEffectInstance(ModEffects.weightless.get(), 2400, 0)));
    public static final RegistryObject<Potion> weightless_potion_strong = POTIONS.register("weightless_potion_strong", () -> new Potion(new MobEffectInstance(ModEffects.weightless.get(), 600, 1)));

    public static void registers(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
