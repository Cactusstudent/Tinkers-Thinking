package com.creeping_creeper.tinkers_thinking.modifers;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersThinkingModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(tinkers_thinking.MOD_ID);
    public static final StaticModifier<Modifier> Deposition = MODIFIERS.register("deposition", DepositionModifier::new);
    public static final StaticModifier<Modifier> Symbiotic = MODIFIERS.register("symbiotic", SymbioticModifier::new);
    public static final StaticModifier<Modifier> Stimulation = MODIFIERS.register("stimulation", StimulationModifier::new);
    public static final StaticModifier<Modifier> Inspired = MODIFIERS.register("inspired", InspiredModifier::new);
    public static final StaticModifier<Modifier> Concealer = MODIFIERS.register("concealer", ConcealerModifier::new);
    public static final StaticModifier<Modifier> LightPower = MODIFIERS.register("light_power", LightPowerModifier::new);
    public static void regeisters(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}

