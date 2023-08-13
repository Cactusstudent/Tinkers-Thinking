package com.creeping_creeper.tinkers_thinking.modifers;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
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
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        int symbioticLevel =getModifierLevel(holder.getMainHandItem(), TinkersThinkingModifiers.Symbiotic.get().getId()) + getModifierLevel(holder.getOffhandItem(), TinkersThinkingModifiers.Symbiotic.get().getId());
            // update 1 times a second, but skip when active (messes with pulling bow back)
            if (symbioticLevel > 0 && !tool.isBroken()&&holder.getHealth() < holder.getMaxHealth() && !world.isClientSide && holder.tickCount % 20 == 0 && holder.getUseItem() != stack) {
                int percent = (int) ( holder.getMaxHealth() - holder.getHealth());
                if (RANDOM.nextFloat() < Math.min( percent * level * 0.04,1)) {
                    holder.heal(Math.max(level * 1,holder.getMaxHealth()*0.1f));
                    ToolDamageUtil.directDamage(tool,  level * 8, holder, holder.getUseItem());
                    holder.level.playSound(null, holder.getX(), holder.getY(), holder.getZ(), Sounds.NECROTIC_HEAL.getSound(), SoundSource.PLAYERS, 1.0f, 1.0f);
                    // take a bit of extra damage to heal
                }
            }
        }
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, TooltipKey key, TooltipFlag flag) {
        if (tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE)) {
            float percent = (float) Math.min(( (player.getMaxHealth() - player.getHealth() )* 0.04 *level),1);
            tooltip.add(this.applyStyle((new TextComponent(Util.PERCENT_BOOST_FORMAT.format((double)percent) + " ")).append(Percent)));
        }
    }
}