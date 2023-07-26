package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static slimeknights.tconstruct.library.tools.helper.ModifierUtil.getModifierLevel;

public class SymbioticModifier extends Modifier {
    @Override
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        int symbioticLevel =getModifierLevel(holder.getMainHandItem(), TinkersThinkingModifiers.Symbiotic.get().getId()) + getModifierLevel(holder.getOffhandItem(), TinkersThinkingModifiers.Symbiotic.get().getId());
            // update 1 times a second, but skip when active (messes with pulling bow back)
            if (symbioticLevel > 0 && !tool.isBroken()&&holder.getHealth() < holder.getMaxHealth() && !world.isClientSide && holder.tickCount % 20 == 0 && holder.getUseItem() != stack) {
                int percent = (int) ( holder.getMaxHealth() - holder.getHealth());
                // has a 5% chance of restoring each second per level
                if (RANDOM.nextFloat() < Math.min( percent * level * 0.04,1)) {
                    holder.heal(level * 2);
                    ToolDamageUtil.directDamage(tool,  level * 8, holder, holder.getUseItem());
                    holder.level.playSound(null, holder.getX(), holder.getY(), holder.getZ(), Sounds.NECROTIC_HEAL.getSound(), SoundSource.PLAYERS, 1.0f, 1.0f);
                    // take a bit of extra damage to heal
                }
            }
        }
}