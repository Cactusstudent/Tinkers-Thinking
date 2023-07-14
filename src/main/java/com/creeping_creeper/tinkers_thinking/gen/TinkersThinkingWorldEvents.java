package com.creeping_creeper.tinkers_thinking.gen;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.creeping_creeper.tinkers_thinking.tinkers_thinking;

@Mod.EventBusSubscriber(modid = tinkers_thinking.MOD_ID)
public class TinkersThinkingWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event)
    {TinkersThinkingOreGeneration.generateOres(event);
    }
}
