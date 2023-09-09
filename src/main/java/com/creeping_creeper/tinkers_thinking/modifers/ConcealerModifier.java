package com.creeping_creeper.tinkers_thinking.modifers;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;
import slimeknights.tconstruct.library.utils.TooltipKey;
import slimeknights.tconstruct.library.utils.Util;

import javax.annotation.Nullable;
import java.util.List;

public class ConcealerModifier extends Modifier implements ProjectileHitModifierHook {
    private static final Component ATTACK_DAMAGE = TConstruct.makeTranslation("modifier", "concealer.attack_damage");
    public ConcealerModifier() {
    }

    public int getPriority() {
        return 90;
    }
    protected void registerHooks(ModifierHookMap.@NotNull Builder hookBuilder)
    {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }
    private static float getBonus(LivingEntity attacker, int level) {
        return 0.25f*(float) level;
    }

    public float getEntityDamage(@NotNull IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && target.isAlive() && !context.isExtraAttack() && context.isFullyCharged()&& target.hasEffect(MobEffects.INVISIBILITY) ) {
            float bonus = getBonus(context.getAttacker(), level);
            damage *=  1.0f+bonus;
        }
        return damage;
    }
    public int afterEntityHit(@NotNull IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
            if (target != null && target.isAlive() && !context.isExtraAttack() && context.isFullyCharged()){
                target.setLastHurtMob(context.getAttacker());
                MobEffectInstance effect = new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2);
                target.addEffect(effect);
            }
        return 0;
    }
    public boolean onProjectileHitEntity(@NotNull ModifierNBT modifiers, @NotNull NamespacedNBT persistentData, @NotNull ModifierEntry modifier, @NotNull Projectile projectile, @NotNull EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (target != null && (!(projectile instanceof AbstractArrow arrow) || arrow.isCritArrow()) && target.isAlive() ) {
            Entity owner = projectile.getOwner();
            if (owner != null) {
                target.setLastHurtMob(owner);
            }
            MobEffectInstance effect = new MobEffectInstance(MobEffects.INVISIBILITY, 200, 2);
            target.addEffect(effect);
        }
        if (target != null && target.hasEffect(MobEffects.INVISIBILITY)  && projectile instanceof AbstractArrow arrow) {
            float bonus = (float) (modifier.getLevel() * 0.25);
            arrow.setBaseDamage(arrow.getBaseDamage() * (double)(bonus + 1));
        }
        return false;
    }
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, @NotNull TooltipKey key, @NotNull TooltipFlag flag) {
        if (tool.hasTag(TinkerTags.Items.RANGED) || tool.hasTag(TinkerTags.Items.MELEE)) {
            float bonus = 0.25F * (float)level;
            tooltip.add(this.applyStyle((new TextComponent(Util.PERCENT_BOOST_FORMAT.format(bonus) + " ")).append(ATTACK_DAMAGE)));
        }
    }
}
