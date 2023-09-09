package com.creeping_creeper.tinkers_thinking.client;

import com.creeping_creeper.tinkers_thinking.things.TinkersThinkingItems;
import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import slimeknights.mantle.data.ISafeManagerReloadListener;
import slimeknights.tconstruct.common.ClientEventBase;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.network.TinkerNetwork;
import slimeknights.tconstruct.library.client.materials.MaterialTooltipCache;
import slimeknights.tconstruct.library.client.model.DynamicTextureLoader;
import slimeknights.tconstruct.library.client.model.TinkerItemProperties;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;
import slimeknights.tconstruct.library.client.modifiers.ModifierModelManager;
import slimeknights.tconstruct.library.modifiers.ModifierManager;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.client.ArmorModelHelper;
import slimeknights.tconstruct.tools.client.PlateArmorModel;
import slimeknights.tconstruct.tools.modifiers.ability.armor.DoubleJumpModifier;
import slimeknights.tconstruct.tools.network.TinkerControlPacket;

@SuppressWarnings("unused")

@Mod.EventBusSubscriber(modid = tinkers_thinking.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)

public class ToolClientEvents extends ClientEventBase {

    private static final ISafeManagerReloadListener MODIFIER_RELOAD_LISTENER;
    private static boolean wasJumping;
    public ToolClientEvents() {
    }
    @SubscribeEvent
    static void addResourceListener(RegisterClientReloadListenersEvent manager) {
        ModifierModelManager.init(manager);
        MaterialTooltipCache.init(manager);
        DynamicTextureLoader.init(manager);
        manager.registerReloadListener(MODIFIER_RELOAD_LISTENER);
        manager.registerReloadListener(PlateArmorModel.RELOAD_LISTENER);
    }
    @SubscribeEvent
    static void clientSetupEvent(FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(com.creeping_creeper.tinkers_thinking.client.ToolClientEvents::handleKeyBindings);
        MinecraftForge.EVENT_BUS.addListener(com.creeping_creeper.tinkers_thinking.client.ToolClientEvents::handleInput);
        ArmorModelHelper.init();
        event.enqueueWork(() -> {
            TinkerItemProperties.registerBowProperties(TinkersThinkingItems.Arrow_Thrower.get().asItem());
        });
    }
    private static void handleInput(MovementInputUpdateEvent event) {
        Player player = event.getPlayer();
        if (player.isUsingItem() && !player.isPassenger()) {
            ItemStack using = player.getUseItem();
            if (using.is(TinkerTags.Items.HELD)) {
                ToolStack tool = ToolStack.from(using);
                float speed = 5.0F * (Float)tool.getStats().get(ToolStats.USE_ITEM_SPEED);
                if (tool.getVolatileData().getBoolean(IModifiable.FAST_USE_ITEM)) {
                    speed = Math.min(5.0F, speed + 3.0F);
                }

                Input input = event.getInput();
                input.leftImpulse *= speed;
                input.forwardImpulse *= speed;
            }
        }

    }
    private static void handleKeyBindings(TickEvent.PlayerTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && minecraft.player == event.player && event.phase == TickEvent.Phase.START && event.side == LogicalSide.CLIENT && !minecraft.player.isSpectator()) {
            boolean isJumping = minecraft.options.keyJump.isDown();
            if (!wasJumping && isJumping && DoubleJumpModifier.extraJump(event.player)) {
                TinkerNetwork.getInstance().sendToServer(TinkerControlPacket.DOUBLE_JUMP);
            }

            wasJumping = isJumping;

        }

    }
    @SubscribeEvent
    static void registerModelLoaders(ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(tinkers_thinking.getResource("tool"), ToolModel.LOADER);
    }
    static {
        MODIFIER_RELOAD_LISTENER = (manager) -> {
            ModifierManager.INSTANCE.getAllValues().forEach((modifier) -> {
                modifier.clearCache(PackType.CLIENT_RESOURCES);
            });
        };
    }
}



