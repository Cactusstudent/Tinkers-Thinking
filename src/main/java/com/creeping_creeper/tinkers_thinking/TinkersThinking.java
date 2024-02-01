package com.creeping_creeper.tinkers_thinking;

import com.creeping_creeper.tinkers_thinking.base.block.entity.ModBlockEntities;
import com.creeping_creeper.tinkers_thinking.base.networking.ModMessages;
import com.creeping_creeper.tinkers_thinking.common.recipes.ModBrewingRecipe;
import com.creeping_creeper.tinkers_thinking.common.recipes.ModRecipes;
import com.creeping_creeper.tinkers_thinking.common.things.ModBlocks;
import com.creeping_creeper.tinkers_thinking.common.things.ModEffects;
import com.creeping_creeper.tinkers_thinking.common.things.ModItems;
import com.creeping_creeper.tinkers_thinking.common.things.ModPotions;
import com.creeping_creeper.tinkers_thinking.common.world.ModConfiguredFeatures;
import com.creeping_creeper.tinkers_thinking.common.world.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TinkersThinking.MODID)
public class TinkersThinking
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tinkers_thinking";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public TinkersThinking()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.registers(modEventBus);
        ModBlocks.registers(modEventBus);
        ModEffects.registers(modEventBus);
        ModPotions.registers(modEventBus);
        ModConfiguredFeatures.registers(modEventBus);
        ModPlacedFeatures.registers(modEventBus);
        ModBlockEntities.registers(modEventBus);
        ModRecipes.registers(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    public void commonSetup(final FMLCommonSetupEvent event) {
        ModMessages.register();
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD,ModItems.clay_crystal.get(),ModPotions.weightless_potion.get()));
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.weightless_potion.get(),Items.REDSTONE,ModPotions.weightless_potion_long.get()));
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.weightless_potion.get(),Items.GLOWSTONE_DUST,ModPotions.weightless_potion_strong.get()));

        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.weightless_potion.get(),Items.FERMENTED_SPIDER_EYE,ModPotions.overweight_potion.get()));
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.weightless_potion_long.get(),Items.FERMENTED_SPIDER_EYE,ModPotions.overweight_potion_long.get()));
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.weightless_potion_strong.get(),Items.FERMENTED_SPIDER_EYE,ModPotions.overweight_potion_strong.get()));
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.overweight_potion.get(),Items.REDSTONE,ModPotions.overweight_potion_long.get()));
        BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.overweight_potion.get(),Items.GLOWSTONE_DUST,ModPotions.overweight_potion_strong.get()));
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
