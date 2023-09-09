package com.creeping_creeper.tinkers_thinking.things;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.item.ModifiableLauncherItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.item.ModifiableBowItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

import static com.creeping_creeper.tinkers_thinking.things.TinkersThinkingCreativeModeTab.Tinkers_Thinking_Tab;

public class TinkersThinkingItems {
    private static final Item.Properties ToolItem = new Item.Properties().stacksTo(1).tab(Tinkers_Thinking_Tab);
    public static Item register() {
        return new Item(new Item.Properties().tab(Tinkers_Thinking_Tab));
    }
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, com.creeping_creeper.tinkers_thinking.tinkers_thinking.MOD_ID);

    public static final RegistryObject<Item> raw_ardite = ITEMS.register("raw_ardite", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));

    public static final RegistryObject<Item> ardite_ingot = ITEMS.register("ardite_ingot", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item> ardite_nugget = ITEMS.register("ardite_nugget", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  blood_crystal= ITEMS.register("blood_crystal", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  magma_crystal= ITEMS.register("magma_crystal", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  quartz_crystal= ITEMS.register("quartz_crystal", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  clay_crystal= ITEMS.register("clay_crystal", TinkersThinkingItems::register);
    public static final RegistryObject<Item> chromatic_crystal = ITEMS.register("chromatic_crystal", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  gilded_silky_cloth= ITEMS.register("gilded_silky_cloth", TinkersThinkingItems::register);

    public static final RegistryObject<Item>  lightite_ingot= ITEMS.register("lightite_ingot", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  lightite_nugget= ITEMS.register("lightite_nugget", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  lightite_compound= ITEMS.register("lightite_compound", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  lightite_reinforcement= ITEMS.register("lightite_reinforcement", TinkersThinkingItems::register);

    public static final RegistryObject<Item>  silky_jewel= ITEMS.register("silky_jewel", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  stone_stick= ITEMS.register("stone_stick", TinkersThinkingItems::register);
    public static final RegistryObject<Item> surging_wellspring = ITEMS.register("surging_wellspring", TinkersThinkingItems::register);

    public static final RegistryObject<Item>  tinkers_bronze_ingot= ITEMS.register("tinkers_bronze_ingot", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  tinkers_bronze_nugget= ITEMS.register("tinkers_bronze_nugget", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  chlorophyll_a= ITEMS.register("chlorophyll_a", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  chlorophyll_b= ITEMS.register("chlorophyll_b", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  chlorophyte_compound= ITEMS.register("chlorophyte_compound", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  chlorophyte_ingot= ITEMS.register("chlorophyte_ingot", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  chlorophyte_nugget= ITEMS.register("chlorophyte_nugget", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  spectre_compound= ITEMS.register("spectre_compound", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  spectre_ingot= ITEMS.register("spectre_ingot", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  spectre_nugget= ITEMS.register("spectre_nugget", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  shroomite_compound= ITEMS.register("shroomite_compound", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  shroomite_ingot= ITEMS.register("shroomite_ingot", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  shroomite_nugget= ITEMS.register("shroomite_nugget", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  narrow_blade_sand_cast= ITEMS.register("narrow_blade_sand_cast", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  narrow_blade_red_sand_cast= ITEMS.register("narrow_blade_red_sand_cast", TinkersThinkingItems::register);
    public static final RegistryObject<Item>  narrow_blade_gold_cast= ITEMS.register("narrow_blade_gold_cast", TinkersThinkingItems::register);
    //Foods
    public static final RegistryObject<Item>  Beef_Jerky= ITEMS.register("beef_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Beef_Jerky)));
    public static final RegistryObject<Item>  Pork_Jerky= ITEMS.register("pork_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Jerky)));
    public static final RegistryObject<Item>  Mutton_Jerky= ITEMS.register("mutton_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Jerky)));
    public static final RegistryObject<Item>  Rabbit_Jerky= ITEMS.register("rabbit_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Jerky)));
    public static final RegistryObject<Item>  Chicken_Jerky= ITEMS.register("chicken_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Jerky)));
    public static final RegistryObject<Item>  Cod_Jerky= ITEMS.register("cod_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Fish_Jerky)));
    public static final RegistryObject<Item>  Salmon_Jerky= ITEMS.register("salmon_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Fish_Jerky)));
    public static final RegistryObject<Item>  Clownfish_Jerky= ITEMS.register("clownfish_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Fish_Jerky)));
    public static final RegistryObject<Item>  Pufferfish_Jerky= ITEMS.register("pufferfish_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Fish_Jerky)));
    public static final RegistryObject<Item>  Rotten_Flesh_Jerky= ITEMS.register("rotten_flesh_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Rotten_Flesh_Jerky)));
    public static final RegistryObject<Item>  Fried_Egg= ITEMS.register("fried_egg", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Fried_Egg)));
    public static final RegistryObject<Item>  Earth_Slime_Drop= ITEMS.register("earth_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Earth_Slime_Drop)));
    public static final RegistryObject<Item>  Sky_Slime_Drop= ITEMS.register("sky_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Sky_Slime_Drop)));
    public static final RegistryObject<Item>  Magma_Slime_Drop= ITEMS.register("magma_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Magma_Slime_Drop)));
    public static final RegistryObject<Item>  Ichor_Slime_Drop= ITEMS.register("ichor_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Ichor_Slime_Drop)));
    public static final RegistryObject<Item>  Blood_Slime_Drop= ITEMS.register("blood_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Blood_Slime_Drop)));
    public static final RegistryObject<Item>  Ender_Slime_Drop= ITEMS.register("ender_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Ender_Slime_Drop)));
    public static final RegistryObject<Item>  Black_Chocolate= ITEMS.register("black_chocolate", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.Black_Chocolate)));
    public static final RegistryObject<Item>  White_Chocolate= ITEMS.register("white_chocolate", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(TinkersThinkingFoods.White_Chocolate)));
    //Tools&ToolParts
    public static final RegistryObject<ModifiableItem> Paxel = ITEMS.register("paxel", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Paxel));
    public static final RegistryObject<ModifiableItem> Knife = ITEMS.register("knife", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Knife));
    public static final RegistryObject<ModifiableLauncherItem> Arrow_Thrower = ITEMS.register("arrow_thrower", () -> new ModifiableBowItem(ToolItem,  TinkersThinkingToolDefinitions.Arrow_Thrower) );
    public static final RegistryObject<ModifiableItem> Magma_Staff = ITEMS.register("magma_staff", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Magma_STAFF));
    public static final RegistryObject<ModifiableItem> Blood_Staff = ITEMS.register("blood_staff", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Blood_STAFF));
    public static final RegistryObject<ModifiableItem> Clay_Staff = ITEMS.register("clay_staff", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Clay_STAFF));
    public static final RegistryObject<ModifiableItem> Quartz_Staff = ITEMS.register("quartz_staff", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Quartz_STAFF));
    public static final RegistryObject<ModifiableItem> Amethyst_Staff = ITEMS.register("amethyst_staff", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Amethyst_STAFF));
    public static final RegistryObject<ModifiableItem> Seared_Bucket = ITEMS.register("seared_bucket", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Seared_Bucket));
    public static final RegistryObject<ModifiableItem> Tinkers_Bronze_Bucket = ITEMS.register("tinkers_bronze_bucket", () -> new ModifiableItem(ToolItem, TinkersThinkingToolDefinitions.Tinkers_Bronze_Bucket));
    public static final RegistryObject<ModifiableItem> Battle_Bucket = ITEMS.register("battle_bucket", () -> new ModifiableItem(ToolItem.fireResistant(), TinkersThinkingToolDefinitions.Battle_Bucket));
    public static final RegistryObject<ToolPartItem> Narrow_Blade = ITEMS.register("narrow_blade", () -> new ToolPartItem(ToolItem, HeadMaterialStats.ID));
    //Buckets
    public static final RegistryObject<Item>  molten_ardite_bucket= ITEMS.register("molten_ardite_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_ardite, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_tinkers_bronze_bucket= ITEMS.register("molten_tinkers_bronze_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_tinkers_bronze, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  molten_lightite_bucket= ITEMS.register("molten_lightite_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_lightite, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  molten_cocoa_bucket= ITEMS.register("molten_cocoa_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_cocoa, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  syrup_bucket= ITEMS.register("syrup_bucket", () -> new BucketItem(TinkersThinkingFluids.syrup, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  molten_black_chocolate_bucket= ITEMS.register("molten_black_chocolate_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_black_chocolate, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_white_chocolate_bucket= ITEMS.register("molten_white_chocolate_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_white_chocolate, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_chlorophyte_bucket= ITEMS.register("molten_chlorophyte_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_chlorophyte, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_spectre_bucket= ITEMS.register("molten_spectre_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_spectre, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_shroomite_bucket= ITEMS.register("molten_shroomite_bucket", () -> new BucketItem(TinkersThinkingFluids.molten_shroomite, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));


    public static final RegistryObject<Item>  ardite_block = ITEMS.register("ardite_block", () -> new BlockItem(TinkersThinkingBlocks.ardite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  ardite_ore = ITEMS.register("ardite_ore", () -> new BlockItem(TinkersThinkingBlocks.ardite_ore.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  raw_ardite_block = ITEMS.register("raw_ardite_block", () -> new BlockItem(TinkersThinkingBlocks.raw_ardite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  tinkers_bronze_block = ITEMS.register("tinkers_bronze_block", () -> new BlockItem(TinkersThinkingBlocks.tinkers_bronze_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  lightite_block = ITEMS.register("lightite_block", () -> new BlockItem(TinkersThinkingBlocks.lightite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  silky_jewel_block = ITEMS.register("silky_jewel_block", () -> new BlockItem(TinkersThinkingBlocks.silky_jewel_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  deepslate_chlorophyll_ore = ITEMS.register("deepslate_chlorophyll_ore", () -> new BlockItem(TinkersThinkingBlocks.deepslate_chlorophyll_ore.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  chlorophyll_ore = ITEMS.register("chlorophyll_ore", () -> new BlockItem(TinkersThinkingBlocks.deepslate_chlorophyll_ore.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  chlorophyte_block = ITEMS.register("chlorophyte_block", () -> new BlockItem(TinkersThinkingBlocks.chlorophyte_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  spectre_block = ITEMS.register("spectre_block", () -> new BlockItem(TinkersThinkingBlocks.spectre_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  shroomite_block = ITEMS.register("shroomite_block", () -> new BlockItem(TinkersThinkingBlocks.shroomite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  ardite_platform = ITEMS.register("ardite_platform", () -> new BlockItem(TinkersThinkingBlocks.ardite_platform.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  stone_ladder = ITEMS.register("stone_ladder", () -> new BlockItem(TinkersThinkingBlocks.stone_ladder.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  stone_torch = ITEMS.register("stone_torch", () -> new StandingAndWallBlockItem(TinkersThinkingBlocks.stone_torch.get(), TinkersThinkingBlocks.wall_stone_torch.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  stone_soul_torch = ITEMS.register("stone_soul_torch", () -> new StandingAndWallBlockItem(TinkersThinkingBlocks.stone_soul_torch.get(), TinkersThinkingBlocks.wall_stone_soul_torch.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));

    public static void regeisters(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
