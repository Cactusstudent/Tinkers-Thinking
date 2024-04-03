package com.creeping_creeper.tinkers_thinking.common.things;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.creeping_creeper.tinkers_thinking.common.things.fluid.ModFluidTypes;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, TinkersThinking.MODID);
    public static final RegistryObject<FlowingFluid> source_molten_ardite = FLUIDS.register("molten_ardite",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_ardite));
    public static final RegistryObject<FlowingFluid> flowing_molten_ardite = FLUIDS.register("molten_ardite_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_ardite));

    public static final ForgeFlowingFluid.Properties molten_ardite = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_ardite, source_molten_ardite,flowing_molten_ardite).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_ardite_block).bucket(ModItems.molten_ardite_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_tinkers_bronze = FLUIDS.register("molten_tinkers_bronze",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_tinkers_bronze));
    public static final RegistryObject<FlowingFluid> flowing_molten_tinkers_bronze = FLUIDS.register("molten_tinkers_bronze_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_tinkers_bronze));

    public static final ForgeFlowingFluid.Properties molten_tinkers_bronze = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_tinkers_bronze, source_molten_tinkers_bronze,flowing_molten_tinkers_bronze).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_tinkers_bronze_block).bucket(ModItems.molten_tinkers_bronze_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_obsidian_bronze = FLUIDS.register("molten_obsidian_bronze",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_obsidian_bronze));
    public static final RegistryObject<FlowingFluid> flowing_molten_obsidian_bronze = FLUIDS.register("molten_obsidian_bronze_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_obsidian_bronze));

    public static final ForgeFlowingFluid.Properties molten_obsidian_bronze= new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_obsidian_bronze, source_molten_obsidian_bronze,flowing_molten_obsidian_bronze).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_obsidian_bronze_block).bucket(ModItems.molten_obsidian_bronze_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_lightite = FLUIDS.register("molten_lightite",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_lightite));
    public static final RegistryObject<FlowingFluid> flowing_molten_lightite = FLUIDS.register("molten_lightite_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_lightite));

    public static final ForgeFlowingFluid.Properties molten_lightite = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_lightite, source_molten_lightite,flowing_molten_lightite).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_lightite_block).bucket(ModItems.molten_lightite_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_cocoa = FLUIDS.register("molten_cocoa",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_cocoa));
    public static final RegistryObject<FlowingFluid> flowing_molten_cocoa = FLUIDS.register("molten_cocoa_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_cocoa));

    public static final ForgeFlowingFluid.Properties molten_cocoa = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_cocoa, source_molten_cocoa,flowing_molten_cocoa).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_cocoa_block).bucket(ModItems.molten_cocoa_bucket);
    public static final RegistryObject<FlowingFluid> source_syrup = FLUIDS.register("syrup",
            ()->new ForgeFlowingFluid.Source(ModFluids.syrup));
    public static final RegistryObject<FlowingFluid> flowing_syrup = FLUIDS.register("syrup_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.syrup));

    public static final ForgeFlowingFluid.Properties syrup = new ForgeFlowingFluid.Properties(
            ModFluidTypes.syrup, source_syrup,flowing_syrup).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.syrup_block).bucket(ModItems.syrup_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_black_chocolate = FLUIDS.register("molten_black_chocolate",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_black_chocolate));
    public static final RegistryObject<FlowingFluid> flowing_molten_black_chocolate = FLUIDS.register("molten_black_chocolate_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_black_chocolate));

    public static final ForgeFlowingFluid.Properties molten_black_chocolate = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_black_chocolate, source_molten_black_chocolate,flowing_molten_black_chocolate).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_black_chocolate_block).bucket(ModItems.molten_black_chocolate_bucket);  
    public static final RegistryObject<FlowingFluid> source_molten_white_chocolate = FLUIDS.register("molten_white_chocolate",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_white_chocolate));
    public static final RegistryObject<FlowingFluid> flowing_molten_white_chocolate = FLUIDS.register("molten_white_chocolate_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_white_chocolate));

    public static final ForgeFlowingFluid.Properties molten_white_chocolate = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_white_chocolate, source_molten_white_chocolate,flowing_molten_white_chocolate).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_white_chocolate_block).bucket(ModItems.molten_white_chocolate_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_chlorophyte = FLUIDS.register("molten_chlorophyte",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_chlorophyte));
    public static final RegistryObject<FlowingFluid> flowing_molten_chlorophyte = FLUIDS.register("molten_chlorophyte_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_chlorophyte));

    public static final ForgeFlowingFluid.Properties molten_chlorophyte = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_chlorophyte, source_molten_chlorophyte,flowing_molten_chlorophyte).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_chlorophyte_block).bucket(ModItems.molten_chlorophyte_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_spectre = FLUIDS.register("molten_spectre",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_spectre));
    public static final RegistryObject<FlowingFluid> flowing_molten_spectre = FLUIDS.register("molten_spectre_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_spectre));

    public static final ForgeFlowingFluid.Properties molten_spectre = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_spectre, source_molten_spectre,flowing_molten_spectre).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_spectre_block).bucket(ModItems.molten_spectre_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_shroomite = FLUIDS.register("molten_shroomite",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_shroomite));
    public static final RegistryObject<FlowingFluid> flowing_molten_shroomite = FLUIDS.register("molten_shroomite_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_shroomite));

    public static final ForgeFlowingFluid.Properties molten_shroomite = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_shroomite, source_molten_shroomite,flowing_molten_shroomite).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_shroomite_block).bucket(ModItems.molten_shroomite_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_electrical_steel = FLUIDS.register("molten_electrical_steel",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_electrical_steel));
    public static final RegistryObject<FlowingFluid> flowing_molten_electrical_steel = FLUIDS.register("molten_electrical_steel_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_electrical_steel));

    public static final ForgeFlowingFluid.Properties molten_electrical_steel = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_electrical_steel, source_molten_electrical_steel,flowing_molten_electrical_steel).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_electrical_steel_block).bucket(ModItems.molten_electrical_steel_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_echo_bronze = FLUIDS.register("molten_echo_bronze",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_echo_bronze));
    public static final RegistryObject<FlowingFluid> flowing_molten_echo_bronze = FLUIDS.register("molten_echo_bronze_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_echo_bronze));

    public static final ForgeFlowingFluid.Properties molten_echo_bronze = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_echo_bronze, source_molten_echo_bronze,flowing_molten_echo_bronze).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_echo_bronze_block).bucket(ModItems.molten_echo_bronze_bucket);
    public static final RegistryObject<FlowingFluid> source_molten_echo = FLUIDS.register("molten_echo",
            ()->new ForgeFlowingFluid.Source(ModFluids.molten_echo));
    public static final RegistryObject<FlowingFluid> flowing_molten_echo = FLUIDS.register("molten_echo_flowing",
            ()->new ForgeFlowingFluid.Flowing(ModFluids.molten_echo));

    public static final ForgeFlowingFluid.Properties molten_echo = new ForgeFlowingFluid.Properties(
            ModFluidTypes.molten_echo, source_molten_echo,flowing_molten_echo).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.molten_echo_block).bucket(ModItems.molten_echo_bucket);
    public static void registers(IEventBus eventBus)  {
        FLUIDS.register(eventBus);
    }
}
