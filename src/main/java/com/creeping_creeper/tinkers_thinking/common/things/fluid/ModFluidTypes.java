package com.creeping_creeper.tinkers_thinking.common.things.fluid;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final ResourceLocation Molten = new ResourceLocation("tconstruct:fluid/molten/still");
    public static final ResourceLocation Molten_Flowing = new ResourceLocation("tconstruct:fluid/molten/flowing");
    public static final ResourceLocation Stew = new ResourceLocation("tconstruct:fluid/food/stew/still");
    public static final ResourceLocation Stew_Flowing = new ResourceLocation("tconstruct:fluid/food/stew/flowing");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES,TinkersThinking.MODID);
    private static final FluidType.Properties common = FluidType.Properties.create()
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .motionScale(0.0023333333333333335D)
                .canExtinguish(true);
    private static final FluidType.Properties hot = FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .motionScale(0.0023333333333333335D)
                .canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null);

    public static final RegistryObject<FluidType> molten_ardite = FLUID_TYPES.register("molten_ardite",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0xFFcc4418,new Vector3f(204f/225f,68f/225f,24f/255f),
                    hot.temperature(1296).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_tinkers_bronze = FLUID_TYPES.register("molten_tinkers_bronze",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFFcea448,new Vector3f(206f/225f,164f/225f,72f/255f),
                    hot.temperature(550).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_obsidian_bronze = FLUID_TYPES.register("molten_obsidian_bronze",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFFa88848,new Vector3f(168f/225f,136f/225f,72f/255f),
                    hot.temperature(950).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_lightite = FLUID_TYPES.register("molten_lightite",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFFd8d8d8,new Vector3f(216f/225f,216f/225f,216f/255f),
                    hot.temperature(450).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_chlorophyte = FLUID_TYPES.register("molten_chlorophyte",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFF248810,new Vector3f(36f/225f,136f/225f,16f/255f),
                    hot.temperature(600).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_spectre = FLUID_TYPES.register("molten_spectre",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFF40d8e8,new Vector3f(64f/225f,216f/225f,232f/255f),
                    hot.temperature(600).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_shroomite = FLUID_TYPES.register("molten_shroomite",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFF108ce8,new Vector3f(16f/225f,140f/225f,232f/255f),
                    hot.temperature(600).lightLevel(7)));
    public static final RegistryObject<FluidType> molten_cocoa = FLUID_TYPES.register("molten_cocoa",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFF7a4820,new Vector3f(122f/225f,72f/225f,32f/255f),
                    hot.temperature(100).lightLevel(7)));
    public static final RegistryObject<FluidType> molten_black_chocolate = FLUID_TYPES.register("molten_black_chocolate",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFF483018,new Vector3f(72f/225f,48f/225f,24f/255f),
                    hot.temperature(90).lightLevel(7)));
    public static final RegistryObject<FluidType> molten_white_chocolate = FLUID_TYPES.register("molten_white_chocolate",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFFdaa86c,new Vector3f(218/225f,168f/225f,108f/255f),
                    hot.temperature(80).lightLevel(7)));
    public static final RegistryObject<FluidType> molten_electrical_steel = FLUID_TYPES.register("molten_electrical_steel",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFFb4b499,new Vector3f(180/225f,180f/225f,153f/255f),
                    hot.temperature(900).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_echo_bronze = FLUID_TYPES.register("molten_echo_bronze",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFF109090,new Vector3f(16/225f,144f/225f,144f/255f),
                    hot.temperature(150).lightLevel(3)));
    public static final RegistryObject<FluidType> molten_beetron = FLUID_TYPES.register("molten_beetron",
            ()->new BaseFluidType(Molten,Molten_Flowing,Molten,
                    0XFFb6484c,new Vector3f(182/225f,72f/225f,76f/255f),
                    hot.temperature(400).lightLevel(15)));
    public static final RegistryObject<FluidType> molten_echo = FLUID_TYPES.register("molten_echo",
            ()->new BaseFluidType(Stew,Stew_Flowing,Stew,
                    0XFF105060,new Vector3f(16f/225f,80f/225f,96f/255f),
                    common.temperature(50).lightLevel(3).density(2000).viscosity(10000)));
    public static final RegistryObject<FluidType> syrup = FLUID_TYPES.register("syrup",
            ()->new BaseFluidType(Stew,Stew_Flowing,Stew,
                    0XFFd88018,new Vector3f(216f/225f,128f/225f,24f/255f),
                    common.temperature(75).lightLevel(7).density(2000).viscosity(10000)));
    public static void registers(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }

}