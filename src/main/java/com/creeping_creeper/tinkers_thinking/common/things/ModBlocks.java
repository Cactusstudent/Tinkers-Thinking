package com.creeping_creeper.tinkers_thinking.common.things;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.creeping_creeper.tinkers_thinking.common.things.block.DryingRackBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.shared.block.PlatformBlock;

import static net.minecraft.world.level.block.SoundType.DEEPSLATE;
import static net.minecraft.world.level.block.SoundType.METAL;
import static net.minecraft.world.level.block.SoundType.STONE;
import static net.minecraft.world.level.block.SoundType.WOOD;
import static net.minecraft.world.level.block.SoundType.WOOL;
import static net.minecraft.world.level.block.SoundType.*;
import static net.minecraft.world.level.material.MaterialColor.*;
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TinkersThinking.MODID);

    public static final RegistryObject<Block> ardite_block = BLOCKS.register("ardite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> raw_ardite_block = BLOCKS.register("raw_ardite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> ardite_ore = BLOCKS.register("ardite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> tinkers_bronze_block = BLOCKS.register("tinkers_bronze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)));
    public static final RegistryObject<Block> obsidian_bronze_block = BLOCKS.register("obsidian_bronze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(15f).explosionResistance(1200).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)));
    public static final RegistryObject<Block> lightite_block = BLOCKS.register("lightite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(8f).explosionResistance(400).requiresCorrectToolForDrops().sound(WOOL).color(COLOR_GRAY)));
    public static final RegistryObject<Block> silky_jewel_block = BLOCKS.register("silky_jewel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)));
    public static final RegistryObject<Block> chlorophyll_ore = BLOCKS.register("chlorophyll_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(6f).explosionResistance(400).requiresCorrectToolForDrops().sound(STONE).color(COLOR_GREEN)));
    public static final RegistryObject<Block> deepslate_chlorophyll_ore = BLOCKS.register("deepslate_chlorophyll_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(9f).explosionResistance(400).requiresCorrectToolForDrops().sound(DEEPSLATE).color(COLOR_GREEN)));
    public static final RegistryObject<Block> chlorophyte_block = BLOCKS.register("chlorophyte_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(400).requiresCorrectToolForDrops().sound(METAL).color(COLOR_GREEN)));
    public static final RegistryObject<Block> spectre_block = BLOCKS.register("spectre_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(8f).explosionResistance(400).requiresCorrectToolForDrops().sound(METAL).color(COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> shroomite_block = BLOCKS.register("shroomite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(9f).explosionResistance(400).requiresCorrectToolForDrops().sound(METAL).color(COLOR_BLUE)));
    public static final RegistryObject<Block> electrical_steel_block = BLOCKS.register("electrical_steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_GRAY)));
    public static final RegistryObject<Block> ardite_platform = BLOCKS.register("ardite_platform",
            () -> new PlatformBlock(BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops().sound(ANCIENT_DEBRIS).color(COLOR_ORANGE)));
    public static final RegistryObject<Block> stone_ladder = BLOCKS.register("stone_ladder",
            () -> new LadderBlock(BlockBehaviour.Properties.copy(Blocks.LADDER).sound(STONE).strength(0.8f)));
    public static final RegistryObject<Block> stone_torch = BLOCKS.register("stone_torch",
            () -> new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {
                return 14;}).sound(STONE), ParticleTypes.FLAME));
    public static final RegistryObject<Block> wall_stone_torch = BLOCKS.register("wall_stone_torch",
            () -> new WallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {return 14;
            }).sound(STONE), ParticleTypes.FLAME));
    public static final RegistryObject<Block> stone_soul_torch = BLOCKS.register("stone_soul_torch",
            () -> new TorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {return 10;
            }).sound(STONE), ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> wall_stone_soul_torch = BLOCKS.register("wall_stone_soul_torch",
            () -> new WallTorchBlock(BlockBehaviour.Properties.of(Material.DECORATION).noCollission().strength(0.6f).lightLevel((p_50886_) -> {return 10;
            }).sound(STONE),ParticleTypes.SOUL_FIRE_FLAME));
    public static final RegistryObject<Block> drying_rack = BLOCKS.register("drying_rack",
            () -> new DryingRackBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.6f).sound(WOOD)));
    public static final RegistryObject<LiquidBlock> molten_ardite_block = BLOCKS.register("molten_ardite_block",
            ()->new LiquidBlock(ModFluids.source_molten_ardite,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_tinkers_bronze_block = BLOCKS.register("molten_tinkers_bronze_block",
            ()->new LiquidBlock(ModFluids.source_molten_tinkers_bronze,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_obsidian_bronze_block = BLOCKS.register("molten_obsidian_bronze_block",
            ()->new LiquidBlock(ModFluids.source_molten_obsidian_bronze,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_lightite_block = BLOCKS.register("molten_lightite_block",
            ()->new LiquidBlock(ModFluids.source_molten_lightite,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_cocoa_block = BLOCKS.register("molten_cocoa_block",
            ()->new LiquidBlock(ModFluids.source_molten_cocoa,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_black_chocolate_block = BLOCKS.register("molten_black_chocolate_block",
            ()->new LiquidBlock(ModFluids.source_molten_black_chocolate,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_white_chocolate_block = BLOCKS.register("molten_white_chocolate_block",
            ()->new LiquidBlock(ModFluids.source_molten_white_chocolate,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_chlorophyte_block = BLOCKS.register("molten_chlorophyte_block",
            ()->new LiquidBlock(ModFluids.source_molten_chlorophyte,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_spectre_block = BLOCKS.register("molten_spectre_block",
            ()->new LiquidBlock(ModFluids.source_molten_spectre,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_shroomite_block = BLOCKS.register("molten_shroomite_block",
            ()->new LiquidBlock(ModFluids.source_molten_shroomite,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> molten_electrical_steel_block = BLOCKS.register("molten_electrical_steel_block",
            ()->new LiquidBlock(ModFluids.source_molten_electrical_steel,BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<LiquidBlock> syrup_block = BLOCKS.register("syrup_block",
            ()->new LiquidBlock(ModFluids.source_syrup,BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static void registers(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
