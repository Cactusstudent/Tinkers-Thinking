package com.creeping_creeper.tinkers_thinking.things;

import com.creeping_creeper.tinkers_thinking.tinkers_thinking;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class TinkersThinkingFluids {
    public static final ResourceLocation Molten = new ResourceLocation("tconstruct:block/fluid/molten/still");
    public static final ResourceLocation Molten_Flowing = new ResourceLocation("tconstruct:block/fluid/molten/flowing");
    public static final ResourceLocation Stew = new ResourceLocation("tconstruct:block/fluid/stew/still");
    public static final ResourceLocation Stew_Flowing = new ResourceLocation("tconstruct:block/fluid/stew/flowing");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, tinkers_thinking.MOD_ID);
    public static final RegistryObject<Fluid> molten_ardite =  FLUIDS.register("molten_ardite", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.molten_ardite_PROPERTIES ));
    public static final RegistryObject<Fluid> molten_ardite_flowing =  FLUIDS.register("molten_ardite_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.molten_ardite_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties molten_ardite_PROPERTIES = new ForgeFlowingFluid.Properties(() -> molten_ardite.get(),() -> molten_ardite_flowing.get(), FluidAttributes.builder(Molten,Molten_Flowing)
            .color(0XFFD25204).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY_LAVA,SoundEvents.BUCKET_FILL_LAVA)).block(() -> TinkersThinkingFluids.molten_ardite_block.get()).bucket(() -> TinkersThinkingItems.molten_ardite_bucket.get());
    public static final RegistryObject<LiquidBlock> molten_ardite_block = TinkersThinkingBlocks.BLOCKS.register("molten_ardite_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.molten_ardite.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));


    public static final RegistryObject<Fluid> molten_tinkers_bronze =  FLUIDS.register("molten_tinkers_bronze", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.molten_tinkers_bronze_PROPERTIES ));
    public static final RegistryObject<Fluid> molten_tinkers_bronze_flowing =  FLUIDS.register("molten_tinkers_bronze_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.molten_tinkers_bronze_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties molten_tinkers_bronze_PROPERTIES = new ForgeFlowingFluid.Properties(() -> molten_tinkers_bronze.get(),() -> molten_tinkers_bronze_flowing.get(), FluidAttributes.builder(Molten,Molten_Flowing)
            .color(0XFFcea447).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY_LAVA,SoundEvents.BUCKET_FILL_LAVA)).block(() -> TinkersThinkingFluids.molten_tinkers_bronze_block.get()).bucket(() -> TinkersThinkingItems.molten_tinkers_bronze_bucket.get());
    public static final RegistryObject<LiquidBlock> molten_tinkers_bronze_block = TinkersThinkingBlocks.BLOCKS.register("molten_tinkers_bronze_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.molten_tinkers_bronze.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));


    public static final RegistryObject<Fluid> molten_lightite =  FLUIDS.register("molten_lightite", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.molten_lightite_PROPERTIES ));
    public static final RegistryObject<Fluid> molten_lightite_flowing =  FLUIDS.register("molten_lightite_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.molten_lightite_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties molten_lightite_PROPERTIES = new ForgeFlowingFluid.Properties(() -> molten_lightite.get(),() -> molten_lightite_flowing.get(), FluidAttributes.builder(Molten,Molten_Flowing)
            .color(0XFFddd8d8).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY_LAVA,SoundEvents.BUCKET_FILL_LAVA)).block(() -> TinkersThinkingFluids.molten_lightite_block.get()).bucket(() -> TinkersThinkingItems.molten_lightite_bucket.get());
    public static final RegistryObject<LiquidBlock> molten_lightite_block = TinkersThinkingBlocks.BLOCKS.register("molten_lightite_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.molten_lightite.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));


    public static final RegistryObject<Fluid> molten_cocoa =  FLUIDS.register("molten_cocoa", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.molten_cocoa_PROPERTIES ));
    public static final RegistryObject<Fluid> molten_cocoa_flowing =  FLUIDS.register("molten_cocoa_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.molten_cocoa_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties molten_cocoa_PROPERTIES = new ForgeFlowingFluid.Properties(() -> molten_cocoa.get(),() -> molten_cocoa_flowing.get(), FluidAttributes.builder(Stew,Stew_Flowing)
            .color(0XFF7a4621).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY_LAVA,SoundEvents.BUCKET_FILL_LAVA)).block(() -> TinkersThinkingFluids.molten_cocoa_block.get()).bucket(() -> TinkersThinkingItems.molten_cocoa_bucket.get());
    public static final RegistryObject<LiquidBlock> molten_cocoa_block = TinkersThinkingBlocks.BLOCKS.register("molten_cocoa_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.molten_cocoa.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));


    public static final RegistryObject<Fluid> syrup =  FLUIDS.register("syrup", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.syrup_PROPERTIES ));
    public static final RegistryObject<Fluid> syrup_flowing =  FLUIDS.register("syrup_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.syrup_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties syrup_PROPERTIES = new ForgeFlowingFluid.Properties(() -> syrup.get(),() -> syrup_flowing.get(), FluidAttributes.builder(Stew,Stew_Flowing)
            .color(0XFFd27814).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY,SoundEvents.BUCKET_FILL)).block(() -> TinkersThinkingFluids.syrup_block.get()).bucket(() -> TinkersThinkingItems.syrup_bucket.get());
    public static final RegistryObject<LiquidBlock> syrup_block = TinkersThinkingBlocks.BLOCKS.register("syrup_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.syrup.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));


    public static final RegistryObject<Fluid> molten_black_chocolate =  FLUIDS.register("molten_black_chocolate", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.molten_black_chocolate_PROPERTIES ));
    public static final RegistryObject<Fluid> molten_black_chocolate_flowing =  FLUIDS.register("molten_black_chocolate_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.molten_black_chocolate_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties molten_black_chocolate_PROPERTIES = new ForgeFlowingFluid.Properties(() -> molten_black_chocolate.get(),() -> molten_black_chocolate_flowing.get(), FluidAttributes.builder(Molten,Molten_Flowing)
            .color(0XFF4f2b19).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY_LAVA,SoundEvents.BUCKET_FILL_LAVA)).block(() -> TinkersThinkingFluids.molten_black_chocolate_block.get()).bucket(() -> TinkersThinkingItems.molten_black_chocolate_bucket.get());
    public static final RegistryObject<LiquidBlock> molten_black_chocolate_block = TinkersThinkingBlocks.BLOCKS.register("molten_black_chocolate_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.molten_black_chocolate.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));


    public static final RegistryObject<Fluid> molten_white_chocolate =  FLUIDS.register("molten_white_chocolate", () -> new ForgeFlowingFluid.Source(TinkersThinkingFluids.molten_white_chocolate_PROPERTIES ));
    public static final RegistryObject<Fluid> molten_white_chocolate_flowing =  FLUIDS.register("molten_white_chocolate_flowing", () -> new ForgeFlowingFluid.Flowing(TinkersThinkingFluids.molten_white_chocolate_PROPERTIES ));
    public static final ForgeFlowingFluid.Properties molten_white_chocolate_PROPERTIES = new ForgeFlowingFluid.Properties(() -> molten_white_chocolate.get(),() -> molten_white_chocolate_flowing.get(), FluidAttributes.builder(Molten,Molten_Flowing)
            .color(0XFFdba76d).density(2000).luminosity(6).viscosity(10000).sound(SoundEvents.BUCKET_EMPTY_LAVA,SoundEvents.BUCKET_FILL_LAVA)).block(() -> TinkersThinkingFluids.molten_white_chocolate_block.get()).bucket(() -> TinkersThinkingItems.molten_white_chocolate_bucket.get());
    public static final RegistryObject<LiquidBlock> molten_white_chocolate_block = TinkersThinkingBlocks.BLOCKS.register("molten_white_chocolate_block", () -> new LiquidBlock(() -> (FlowingFluid) TinkersThinkingFluids.molten_white_chocolate.get(), BlockBehaviour.Properties.of(Material.LAVA).noCollission().strength(100f)
            .noDrops()));
    public static void regeisters(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
