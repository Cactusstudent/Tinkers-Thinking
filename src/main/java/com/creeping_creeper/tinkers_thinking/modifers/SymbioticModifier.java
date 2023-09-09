package com.creeping_creeper.tinkers_thinking.modifers;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.utils.TooltipKey;
import slimeknights.tconstruct.library.utils.Util;

import javax.annotation.Nullable;
import java.util.List;

import static slimeknights.tconstruct.library.tools.helper.ModifierUtil.getModifierLevel;

public class SymbioticModifier extends Modifier {
    private static final Component Percent = tinkers_thinking.makeTranslation("modifier", "symbiotic.chance");
    @Override
    public void onInventoryTick(@NotNull IToolStackView tool, int level, @NotNull Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, @NotNull ItemStack stack) {
        int symbioticLevel =getModifierLevel(holder.getItemInHand(InteractionHand.MAIN_HAND), TinkersThinkingModifiers.Symbiotic.get().getId()) + getModifierLevel(holder.getItemInHand(InteractionHand.OFF_HAND), TinkersThinkingModifiers.Symbiotic.get().getId());
            // update 1 times a second, but skip when active (messes with pulling bow back)
            if (symbioticLevel > 0 && !tool.isBroken()&&holder.getHealth() < holder.getMaxHealth() && !world.isClientSide && holder.tickCount % 20 == 0 && holder.getUseItem() != stack) {
                int percent = (int) ( holder.getMaxHealth() - holder.getHealth());
                if (RANDOM.nextFloat() < Math.min( percent * level * 0.04,1)) {
                    holder.heal(Math.max(level,holder.getMaxHealth()*0.1f));
                    ToolDamageUtil.directDamage(tool,  level * 8, holder, holder.getUseItem());
                    holder.level.playSound(null, holder.getX(), holder.getY(), holder.getZ(), Sounds.NECROTIC_HEAL.getSound(), SoundSource.PLAYERS, 1.0f, 1.0f);
                    // take a bit of extra damage to heal
                }
            }
        }
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, @NotNull List<Component> tooltip, @NotNull TooltipKey key, @NotNull TooltipFlag flag) {
        if (tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE)) {
            float percent = 0;
            if (player != null) {
                percent = (float) Math.min(( (player.getMaxHealth() - player.getHealth() )* 0.04 *level),1);
            }
            tooltip.add(this.applyStyle((new TextComponent(Util.PERCENT_BOOST_FORMAT.format(percent) + " ")).append(Percent)));
        }
    }
}