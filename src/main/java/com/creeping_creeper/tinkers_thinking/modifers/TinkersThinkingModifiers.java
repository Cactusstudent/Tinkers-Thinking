package com.creeping_creeper.tinkers_thinking.modifers;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class TinkersThinkingModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(tinkers_thinking.MOD_ID);
    public static final StaticModifier<DepositionModifier> Deposition = MODIFIERS.register("deposition", DepositionModifier::new);
    public static final StaticModifier<SymbioticModifier> Symbiotic = MODIFIERS.register("symbiotic", SymbioticModifier::new);
    public static void regeisters(IEventBus eventBus) {
        MODIFIERS.register(eventBus);
    }
}

