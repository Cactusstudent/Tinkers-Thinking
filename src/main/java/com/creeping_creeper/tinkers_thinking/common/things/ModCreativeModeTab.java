package com.creeping_creeper.tinkers_thinking.common.things;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {public static final CreativeModeTab Tinkers_Thinking_Tab = new CreativeModeTab("tinkers_thinking") {

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.chromatic_crystal.get());
    }
};
}
