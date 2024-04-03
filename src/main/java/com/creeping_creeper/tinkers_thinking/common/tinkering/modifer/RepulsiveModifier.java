package com.creeping_creeper.tinkers_thinking.common.tinkering.modifer;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.unserializable.ArmorLevelModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class RepulsiveModifier extends Modifier implements BlockBreakModifierHook, MeleeHitModifierHook, ProjectileHitModifierHook {
    /** Player modifier data key for haste */
    private static final TinkerDataCapability.TinkerDataKey<Integer> REPULSIVE = TConstruct.createKey("repulsive");
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,  TinkerHooks.BLOCK_BREAK, TinkerHooks.MELEE_HIT,TinkerHooks.PROJECTILE_HIT);
        hookBuilder.addModule(new ArmorLevelModule(REPULSIVE, false));
    }
    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        if (!context.isAOE()) {
            TinkerModifiers.repulsiveEffect.get().apply(context.getLiving(), 10, modifier.getLevel()*2 - 1);
        }
    }
    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (!context.isExtraAttack()) {
            TinkerModifiers.repulsiveEffect.get().apply(context.getAttacker(), 10, modifier.getLevel()*2  - 1);
        }
    }
    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @javax.annotation.Nullable LivingEntity attacker, @javax.annotation.Nullable LivingEntity target) {
        if (target != null  && projectile instanceof AbstractArrow arrow) {
            TinkerModifiers.repulsiveEffect.get().apply(attacker, 10, modifier.getLevel()*2 - 1);
        }
        return false;
    }
}
