package com.creeping_creeper.tinkers_thinking.common.recipes;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TinkersThinking.MODID);

    public static final RegistryObject<RecipeSerializer<DryingRackRecipes>> Drying_Rack =
            SERIALIZERS.register("drying_rack", () -> DryingRackRecipes.Serializer.INSTANCE);

    public static void registers(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
