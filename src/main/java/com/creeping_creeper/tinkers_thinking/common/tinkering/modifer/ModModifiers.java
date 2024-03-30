package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;
public class ModModifiers {
    public static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(TinkersThinking.MODID);
    public static final StaticModifier<Modifier> Deposition = MODIFIERS.register("deposition",DepositionModifier ::new);
    public static final StaticModifier<Modifier> Symbiotic = MODIFIERS.register("symbiotic", SymbioticModifier::new);
    public static final StaticModifier<Modifier> Stimulation = MODIFIERS.register("stimulation", StimulationModifier::new);
    public static final StaticModifier<Modifier> Inspired = MODIFIERS.register("inspired", InspiredModifier::new);
    public static final StaticModifier<Modifier> Mock = MODIFIERS.register("mock", MockModifier::new);
    public static final StaticModifier<Modifier> Shady = MODIFIERS.register("shady", ShadyModifier::new);
    public static final StaticModifier<Modifier> Overeat = MODIFIERS.register("overeat",OvereatModifier::new);
    public static final StaticModifier<Modifier> Repulsive = MODIFIERS.register("repulsive",RepulsiveModifier::new);
    public static final StaticModifier<Modifier> Prickly = MODIFIERS.register("prickly",PricklyModifier::new);
    public static final StaticModifier<Modifier> Sprinting = MODIFIERS.register("sprinting",SprintingModifier::new);
    public static final StaticModifier<Modifier> Duritae = MODIFIERS.register("duritae",SprintingModifier::new);
    public static void regeisters(IEventBus eventBus) {
        MODIFIERS.register(eventBus);}
}
