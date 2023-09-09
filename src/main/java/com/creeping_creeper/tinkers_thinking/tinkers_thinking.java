package com.creeping_creeper.tinkers_thinking;

import com.creeping_creeper.tinkers_thinking.configs.TinkersThinkingClientConfigs;
import com.creeping_creeper.tinkers_thinking.configs.TinkersThinkingCommanConfigs;
import com.creeping_creeper.tinkers_thinking.modifers.TinkersThinkingModifiers;
import com.creeping_creeper.tinkers_thinking.things.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.utils.Util;

import java.util.Locale;
import java.util.function.Supplier;

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
        TinkersThinkingFluids.FLUIDS.register(eventBus);
        TinkersThinkingModifiers.MODIFIERS.register(eventBus);
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, TinkersThinkingClientConfigs.SPEC,"tinkers_thinking-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TinkersThinkingCommanConfigs.SPEC,"tinkers_thinking-common.toml");
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void clientSetup(final FMLClientSetupEvent event)

    {
        ItemBlockRenderTypes.setRenderLayer(TinkersThinkingBlocks.ardite_platform.get(),  RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TinkersThinkingBlocks.stone_ladder.get(),  RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TinkersThinkingBlocks.stone_torch.get(),  RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TinkersThinkingBlocks.wall_stone_torch.get(),  RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TinkersThinkingBlocks.stone_soul_torch.get(),  RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(TinkersThinkingBlocks.wall_stone_soul_torch.get(),  RenderType.cutoutMipped());
    }
    public static ResourceLocation getResource(String name) {
        return new ResourceLocation("tinkers_thinking", name);
    }

    public static <T> TinkerDataCapability.TinkerDataKey<T> createKey(String name) {
        return TinkerDataCapability.TinkerDataKey.of(getResource(name));
    }

    public static <T> TinkerDataCapability.ComputableDataKey<T> createKey(String name, Supplier<T> constructor) {
        return TinkerDataCapability.ComputableDataKey.of(getResource(name), constructor);
    }

    public static String resourceString(String res) {
        return String.format("%s:%s", "tinkers_thinking", res);
    }

    public static String prefix(String name) {
        return String.format("%s.%s", "tinkers_thinking", name.toLowerCase(Locale.US));
    }
    public static String makeTranslationKey(String base, String name) {
        return Util.makeTranslationKey(base, getResource(name));
    }
    public static MutableComponent makeTranslation(String base, String name) {
        return new TranslatableComponent(makeTranslationKey(base, name));
    }

    public static MutableComponent makeTranslation(String base, String name, Object... arguments) {
        return new TranslatableComponent(makeTranslationKey(base, name), arguments);
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

}
}
