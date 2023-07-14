package com.creeping_creeper.tinkers_thinking.things;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.SoundType.METAL;
import static net.minecraft.world.level.block.SoundType.WOOL;
import static net.minecraft.world.level.material.MaterialColor.COLOR_GRAY;
import static net.minecraft.world.level.material.MaterialColor.COLOR_YELLOW;


public class TinkersThinkingBlocks2 {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, tinkers_thinking.MOD_ID);
    public static final RegistryObject<Block> tinkers_bronze_block = registerBlock("tinkers_bronze_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)), TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab);
    public static final RegistryObject<Block> lightite_block = registerBlock("lightite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(8f).explosionResistance(400).requiresCorrectToolForDrops().sound(WOOL).color(COLOR_GRAY)), TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab);
    public static final RegistryObject<Block> silky_jewel_block = registerBlock("silky_jewel_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(10f).explosionResistance(600).requiresCorrectToolForDrops().sound(METAL).color(COLOR_YELLOW)), TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                    CreativeModeTab tab) {
        return TinkersThinkingItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}
