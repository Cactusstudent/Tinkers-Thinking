package com.creeping_creeper.tinkers_thinking.base.block.entity;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.creeping_creeper.tinkers_thinking.common.things.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TinkersThinking.MODID);

    public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> Drying_Rack =
            BLOCK_ENTITIES.register("drying_rack",
                    ()->BlockEntityType.Builder.of(DryingRackBlockEntity::new,
                            ModBlocks.drying_rack.get()).build(null));
    public static void registers(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
