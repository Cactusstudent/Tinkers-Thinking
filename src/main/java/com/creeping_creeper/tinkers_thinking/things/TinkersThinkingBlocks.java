package com.creeping_creeper.tinkers_thinking.things;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import static net.minecraft.world.level.block.SoundType.*;
import static net.minecraft.world.level.block.SoundType.DEEPSLATE;
import static net.minecraft.world.level.block.SoundType.METAL;
import static net.minecraft.world.level.block.SoundType.STONE;
import static net.minecraft.world.level.block.SoundType.WOOL;
import static net.minecraft.world.level.material.MaterialColor.*;

public class TinkersThinkingBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, tinkers_thinking.MOD_ID);

    public static final RegistryObject<Block> ardite_block = BLOCKS.register("ardite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> raw_ardite_block = BLOCKS.register("raw_ardite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> ardite_ore = BLOCKS.register("ardite_ore", () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> tinkers_bronze_block = BLOCKS.register("tinkers_bronze_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)));
    public static final RegistryObject<Block> lightite_block = BLOCKS.register("lightite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(8f).explosionResistance(400).requiresCorrectToolForDrops().sound(WOOL).color(COLOR_GRAY)));
    public static final RegistryObject<Block> silky_jewel_block = BLOCKS.register("silky_jewel_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)));
    public static final RegistryObject<Block> chlorophyll_ore = BLOCKS.register("chlorophyll_ore", () -> new Block(
            BlockBehaviour.Properties.of(Material.DIRT).strength(6f).explosionResistance(400).requiresCorrectToolForDrops().sound(STONE).color(COLOR_GREEN)));
    public static final RegistryObject<Block> deepslate_chlorophyll_ore = BLOCKS.register("deepslate_chlorophyll_ore", () -> new Block(
            BlockBehaviour.Properties.of(Material.DIRT).strength(9f).explosionResistance(400).requiresCorrectToolForDrops().sound(DEEPSLATE).color(COLOR_GREEN)));
    public static final RegistryObject<Block> chlorophyte_block = BLOCKS.register("chlorophyte_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(400).requiresCorrectToolForDrops().sound(METAL).color(COLOR_GREEN)));
    public static final RegistryObject<Block> spectre_block = BLOCKS.register("spectre_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(8f).explosionResistance(400).requiresCorrectToolForDrops().sound(METAL).color(COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> shroomite_block = BLOCKS.register("shroomite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(9f).explosionResistance(400).requiresCorrectToolForDrops().sound(METAL).color(COLOR_BLUE)));

    public static final RegistryObject<Block> ardite_platform = BLOCKS.register("ardite_platform",() ->
            new PlatformBlock(BlockBehaviour.Properties.of(Material.METAL).strength(8f).explosionResistance(1200).requiresCorrectToolForDrops()
                            .sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));

    public static final RegistryObject<Block> stone_ladder = BLOCKS.register("stone_ladder", () ->
            new LadderBlock(
            BlockBehaviour.Properties.copy(Blocks.LADDER).sound(STONE).strength(0.8f)));
    public static final RegistryObject<Block> stone_torch = BLOCKS.register("stone_torch", () ->
            new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {
        return 14;
    }).sound(STONE), ParticleTypes.FLAME));
    public static final RegistryObject<Block> wall_stone_torch = BLOCKS.register("wall_stone_torch", () ->
            new WallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {
        return 14;
    }).sound(STONE).dropsLike(stone_torch.get()), ParticleTypes.FLAME));
    public static final RegistryObject<Block> stone_soul_torch = BLOCKS.register("stone_soul_torch", () ->
            new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {
        return 10;
    }).sound(STONE), ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> wall_stone_soul_torch = BLOCKS.register("wall_stone_soul_torch", () ->
            new WallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {
        return 10;
    }).sound(STONE).dropsLike(stone_soul_torch.get()),ParticleTypes.SOUL_FIRE_FLAME));



    public static void regeisters(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}