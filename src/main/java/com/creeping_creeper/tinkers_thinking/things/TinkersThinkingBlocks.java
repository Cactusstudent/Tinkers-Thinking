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
public class TinkersThinkingBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, tinkers_thinking.MOD_ID);

    public static final RegistryObject<Block> ardite_block = registerBlock("ardite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops()), TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab);
    public static final RegistryObject<Block> raw_ardite_block = registerBlock("raw_ardite_block", () -> new Block(
            BlockBehaviour.Properties.of(Material.METAL).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops()), TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab);
    public static final RegistryObject<Block> ardite_ore = registerBlock("ardite_ore", () -> new Block(
            BlockBehaviour.Properties.of(Material.STONE).strength(30f).explosionResistance(1200).requiresCorrectToolForDrops()), TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab);
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return TinkersThinkingItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab).fireResistant()));
    }
    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }
}