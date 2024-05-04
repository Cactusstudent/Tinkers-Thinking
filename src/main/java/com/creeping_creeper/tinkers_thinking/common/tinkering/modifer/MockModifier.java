package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.mantle.data.predicate.damage.DamageSourcePredicate;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.ModifyDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.armor.ProtectionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.armor.ProtectionModule;
import slimeknights.tconstruct.library.modifiers.modules.unserializable.SlotInChargeModule;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;
import slimeknights.tconstruct.library.utils.Util;
import slimeknights.tconstruct.tools.stats.ToolType;

import java.util.List;

public class MockModifier extends Modifier implements  TooltipModifierHook, MeleeDamageModifierHook,MeleeHitModifierHook, ProjectileHitModifierHook, ModifyDamageModifierHook, ProtectionModifierHook {
    private static final Component ATTACK_DAMAGE = TConstruct.makeTranslation("modifier", "mock.attack_damage");
    private static final TinkerDataCapability.TinkerDataKey<SlotInChargeModule.SlotInCharge> SLOT_IN_CHARGE = TConstruct.createKey("mock_slot");
    public int getPriority() {
        return 90;
    }
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this,  ModifierHooks.PROJECTILE_HIT,  ModifierHooks.MELEE_DAMAGE, ModifierHooks.MELEE_HIT,ModifierHooks.TOOLTIP,ModifierHooks.MODIFY_DAMAGE, ModifierHooks.PROTECTION);
        hookBuilder.addModule(new SlotInChargeModule(SLOT_IN_CHARGE));
    }
    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && target.isAlive() && !context.isExtraAttack() && context.isFullyCharged()&& target.hasEffect(MobEffects.INVISIBILITY) ) {
            float bonus = (float) (0.2*modifier.getLevel());
            damage *=  1.0f+bonus;
        }
        return damage;
    }
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (!context.isExtraAttack() && context.isFullyCharged()) {
            LivingEntity target = context.getLivingTarget();
            if (target != null) {
                target.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,200,2,true,true));
            }
        }
    }
    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @javax.annotation.Nullable LivingEntity attacker, @javax.annotation.Nullable LivingEntity target) {
        if (target != null  && projectile instanceof AbstractArrow) {
            target.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2, true, true));
         }
        if (target != null && target.isAlive() && target.hasEffect(MobEffects.INVISIBILITY) && projectile instanceof AbstractArrow arrow) {
            arrow.setBaseDamage(arrow.getBaseDamage() * ((float) (modifier.getLevel() * 0.2) + 1));
        }
        return false;
    }
    @Override
    public float modifyDamageTaken(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slotType, DamageSource source, float amount, boolean isDirectDamage) {
        if (source.getEntity() != null && SlotInChargeModule.isInCharge(context.getTinkerData(), SLOT_IN_CHARGE, slotType)) {
            context.getEntity().addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2, true, true));
        }
        return amount;
    }

    @Override
    public float getProtectionModifier(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slotType, DamageSource source, float modifierValue) {
        if (DamageSourcePredicate.CAN_PROTECT.matches(source) && tool.hasTag(TinkerTags.Items.ARMOR)) {
            modifierValue += modifier.getLevel();
        }
        return modifierValue;
    }
    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        ToolType type = ToolType.from(tool.getItem(), ToolType.NO_MELEE);
        if (type == ToolType.ARMOR){
            ProtectionModule.addResistanceTooltip(tool, this,  modifier.getLevel(), player, tooltip);
        }
        else  {
            tooltip.add(applyStyle(Component.literal(Util.PERCENT_BOOST_FORMAT.format((float) (0.20 * modifier.getLevel())) + " ").append(ATTACK_DAMAGE)));
        }
    }

}
