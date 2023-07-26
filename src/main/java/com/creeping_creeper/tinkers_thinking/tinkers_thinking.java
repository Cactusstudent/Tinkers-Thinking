package com.creeping_creeper.tinkers_thinking;

import com.creeping_creeper.tinkers_thinking.modifers.TinkersThinkingModifiers;
import com.creeping_creeper.tinkers_thinking.things.*;
import com.mojang.logging.LogUtils;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(tinkers_thinking.MOD_ID)
public class tinkers_thinking {
    // Directly reference a slf4j logger
    public static final String MOD_ID = "tinkers_thinking";
    public static String tinkers_thinking;
    private static final Logger LOGGER = LogUtils.getLogger();

    public tinkers_thinking() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        TinkersThinkingItems.ITEMS.register(eventBus);
        TinkersThinkingBlocks.BLOCKS.register(eventBus);
        TinkersThinkingBlocks2.BLOCKS.register(eventBus);
        TinkersThinkingFluids.FLUIDS.register(eventBus);
        TinkersThinkingModifiers.MODIFIERS.register(eventBus);
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            gen.addProvider(new TinkersThinkingToolDefinitionDataProvider(gen));
            gen.addProvider(new TinkersThinkingToolSlotLayout(gen));

        }

}
}
