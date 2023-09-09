package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.slotless.OverslimeModifier;

public class OvereatModifier extends Modifier {
    public OvereatModifier() {

    }

    public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
        ((OverslimeModifier) TinkerModifiers.overslime.get()).setFriend(volatileData);
    }

    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (!world.isClientSide && holder.tickCount % 20 == 0 && holder.getUseItem() != stack) {
            OverslimeModifier overslime = (OverslimeModifier) TinkerModifiers.overslime.get();
            if (0 < overslime.getOverslime(tool) && 0 < tool.getDamage() &&(double) RANDOM.nextFloat() < (double) (level * 0.15)) {
                ToolDamageUtil.repair(tool, 1);
                if ((double) RANDOM.nextFloat() < 0.33){
                    overslime.addOverslime(tool, -1);
                }
            }
        }

    }
}
