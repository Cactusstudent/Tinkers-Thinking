package com.creeping_creeper.tinkers_thinking.things;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TinkersThinkingCreativeModeTab {
    public static final CreativeModeTab Tinkers_Thinking_Tab = new CreativeModeTab("tinkers_thinking") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(TinkersThinkingItems.chromatic_crystal.get());
        }
    };
}
