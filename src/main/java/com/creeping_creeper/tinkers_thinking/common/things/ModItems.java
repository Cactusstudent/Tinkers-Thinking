package com.creeping_creeper.tinkers_thinking.common.things;

import com.creeping_creeper.tinkers_thinking.TinkersThinking;
import com.creeping_creeper.tinkers_thinking.common.tinkering.ToolDefinitions;
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

import static com.creeping_creeper.tinkers_thinking.common.things.ModCreativeModeTab.Tinkers_Thinking_Tab;

public class ModItems {
    private static final Item.Properties ToolItem = new Item.Properties().stacksTo(1).tab(Tinkers_Thinking_Tab);
    public static Item register() {
        return new Item(new Item.Properties().tab(Tinkers_Thinking_Tab));
    }
    //Tools&ToolParts
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinkersThinking.MODID);
    public static final RegistryObject<Item>  paxel = ITEMS.register( "paxel", () -> new ModifiableItem(ToolItem, ToolDefinitions.PAXEL));
    public static final RegistryObject<Item>  knife = ITEMS.register( "knife", () -> new ModifiableItem(ToolItem, ToolDefinitions.KNIFE));
    public static final RegistryObject<ModifiableLauncherItem> arrow_thrower = ITEMS.register("arrow_thrower", () -> new ModifiableBowItem(ToolItem,  ToolDefinitions.ARROW_THROWER));
    public static final RegistryObject<ModifiableItem> magma_staff = ITEMS.register("magma_staff", () -> new ModifiableItem(ToolItem, ToolDefinitions.MAGMA_STAFF));
    public static final RegistryObject<ModifiableItem> clay_staff = ITEMS.register("clay_staff", () -> new ModifiableItem(ToolItem, ToolDefinitions.CLAY_STAFF));
    public static final RegistryObject<ModifiableItem> quartz_staff = ITEMS.register("quartz_staff", () -> new ModifiableItem(ToolItem, ToolDefinitions.QUARTZ_STAFF));
    public static final RegistryObject<ModifiableItem> seared_bucket = ITEMS.register("seared_bucket", () -> new ModifiableItem(ToolItem, ToolDefinitions.SEARED_BUCKET));
    public static final RegistryObject<ModifiableItem> tinkers_bronze_bucket = ITEMS.register("tinkers_bronze_bucket", () -> new ModifiableItem(ToolItem, ToolDefinitions.TINKERS_BRONZE_BUCKET));
    public static final RegistryObject<ModifiableItem> battle_bucket = ITEMS.register("battle_bucket", () -> new ModifiableItem(ToolItem.fireResistant(), ToolDefinitions.BATTLE_BUCKET));
    public static final RegistryObject<ToolPartItem> narrow_blade = ITEMS.register("narrow_blade", () -> new ToolPartItem(new Item.Properties().tab(Tinkers_Thinking_Tab), HeadMaterialStats.ID));
    //Common Items
    public static final RegistryObject<Item> raw_ardite = ITEMS.register("raw_ardite", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item> ardite_ingot = ITEMS.register("ardite_ingot", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item> ardite_nugget = ITEMS.register("ardite_nugget", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  blood_crystal= ITEMS.register("blood_crystal", ModItems::register);
    public static final RegistryObject<Item>  magma_crystal= ITEMS.register("magma_crystal", ModItems::register);
    public static final RegistryObject<Item>  quartz_crystal= ITEMS.register("quartz_crystal", ModItems::register);
    public static final RegistryObject<Item>  clay_crystal= ITEMS.register("clay_crystal", ModItems::register);
    public static final RegistryObject<Item> chromatic_crystal = ITEMS.register("chromatic_crystal", ModItems::register);
    public static final RegistryObject<Item>  gilded_silky_cloth= ITEMS.register("gilded_silky_cloth", ModItems::register);

    public static final RegistryObject<Item>  lightite_ingot= ITEMS.register("lightite_ingot", ModItems::register);
    public static final RegistryObject<Item>  lightite_nugget= ITEMS.register("lightite_nugget", ModItems::register);
    public static final RegistryObject<Item>  lightite_compound= ITEMS.register("lightite_compound", ModItems::register);
    public static final RegistryObject<Item>  lightite_reinforcement= ITEMS.register("lightite_reinforcement", ModItems::register);

    public static final RegistryObject<Item>  silky_jewel= ITEMS.register("silky_jewel", ModItems::register);
    public static final RegistryObject<Item>  stone_stick= ITEMS.register("stone_stick", ModItems::register);
    public static final RegistryObject<Item> surging_wellspring = ITEMS.register("surging_wellspring", ModItems::register);

    public static final RegistryObject<Item>  tinkers_bronze_ingot= ITEMS.register("tinkers_bronze_ingot", ModItems::register);
    public static final RegistryObject<Item>  tinkers_bronze_nugget= ITEMS.register("tinkers_bronze_nugget", ModItems::register);
    public static final RegistryObject<Item>  obsidian_bronze_ingot= ITEMS.register("obsidian_bronze_ingot", ModItems::register);
    public static final RegistryObject<Item>  obsidian_bronze_nugget= ITEMS.register("obsidian_bronze_nugget", ModItems::register);
    public static final RegistryObject<Item>  chlorophyll_a= ITEMS.register("chlorophyll_a", ModItems::register);
    public static final RegistryObject<Item>  chlorophyll_b= ITEMS.register("chlorophyll_b", ModItems::register);
    public static final RegistryObject<Item>  chlorophyte_compound= ITEMS.register("chlorophyte_compound", ModItems::register);
    public static final RegistryObject<Item>  chlorophyte_ingot= ITEMS.register("chlorophyte_ingot", ModItems::register);
    public static final RegistryObject<Item>  chlorophyte_nugget= ITEMS.register("chlorophyte_nugget", ModItems::register);
    public static final RegistryObject<Item>  spectre_compound= ITEMS.register("spectre_compound", ModItems::register);
    public static final RegistryObject<Item>  spectre_ingot= ITEMS.register("spectre_ingot", ModItems::register);
    public static final RegistryObject<Item>  spectre_nugget= ITEMS.register("spectre_nugget", ModItems::register);
    public static final RegistryObject<Item>  shroomite_compound= ITEMS.register("shroomite_compound", ModItems::register);
    public static final RegistryObject<Item>  shroomite_ingot= ITEMS.register("shroomite_ingot", ModItems::register);
    public static final RegistryObject<Item>  shroomite_nugget= ITEMS.register("shroomite_nugget", ModItems::register);
    public static final RegistryObject<Item>  electrical_steel_ingot= ITEMS.register("electrical_steel_ingot", ModItems::register);
    public static final RegistryObject<Item>  electrical_steel_nugget= ITEMS.register("electrical_steel_nugget", ModItems::register);
    public static final RegistryObject<Item>  narrow_blade_sand_cast= ITEMS.register("narrow_blade_sand_cast", ModItems::register);
    public static final RegistryObject<Item>  narrow_blade_red_sand_cast= ITEMS.register("narrow_blade_red_sand_cast", ModItems::register);
    public static final RegistryObject<Item>  narrow_blade_gold_cast= ITEMS.register("narrow_blade_gold_cast", ModItems::register);
    //Foods
    public static final RegistryObject<Item>  Beef_Jerky= ITEMS.register("beef_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Beef_Jerky)));
    public static final RegistryObject<Item>  Pork_Jerky= ITEMS.register("pork_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Beef_Jerky)));
    public static final RegistryObject<Item>  Mutton_Jerky= ITEMS.register("mutton_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Mutton_Jerky)));
    public static final RegistryObject<Item>  Rabbit_Jerky= ITEMS.register("rabbit_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Rabbit_Jerky)));
    public static final RegistryObject<Item>  Chicken_Jerky= ITEMS.register("chicken_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Rabbit_Jerky)));
    public static final RegistryObject<Item>  Cod_Jerky= ITEMS.register("cod_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Rabbit_Jerky)));
    public static final RegistryObject<Item>  Salmon_Jerky= ITEMS.register("salmon_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Mutton_Jerky)));
    public static final RegistryObject<Item>  Tropical_Fish_Jerky= ITEMS.register("tropical_fish_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Fish_Jerky)));
    public static final RegistryObject<Item>  Pufferfish_Jerky= ITEMS.register("pufferfish_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Fish_Jerky)));
    public static final RegistryObject<Item>  Rotten_Flesh_Jerky= ITEMS.register("rotten_flesh_jerky", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Rotten_Flesh_Jerky)));
    public static final RegistryObject<Item>  Fried_Egg= ITEMS.register("fried_egg", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Fried_Egg)));
    public static final RegistryObject<Item>  Earth_Slime_Drop= ITEMS.register("earth_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Earth_Slime_Drop)));
    public static final RegistryObject<Item>  Sky_Slime_Drop= ITEMS.register("sky_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Sky_Slime_Drop)));
    public static final RegistryObject<Item>  Magma_Slime_Drop= ITEMS.register("magma_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Magma_Slime_Drop)));
    public static final RegistryObject<Item>  Ichor_Slime_Drop= ITEMS.register("ichor_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Ichor_Slime_Drop)));
    public static final RegistryObject<Item>  Blood_Slime_Drop= ITEMS.register("blood_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Blood_Slime_Drop)));
    public static final RegistryObject<Item>  Ender_Slime_Drop= ITEMS.register("ender_slime_drop", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Ender_Slime_Drop)));
    public static final RegistryObject<Item>  Black_Chocolate= ITEMS.register("black_chocolate", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.Black_Chocolate)));
    public static final RegistryObject<Item>  White_Chocolate= ITEMS.register("white_chocolate", () -> new Item(new Item.Properties().tab(Tinkers_Thinking_Tab).food(ModFoods.White_Chocolate)));
    //BlockItems
    public static final RegistryObject<Item>  ardite_block = ITEMS.register("ardite_block", () -> new BlockItem(ModBlocks.ardite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  ardite_ore = ITEMS.register("ardite_ore", () -> new BlockItem(ModBlocks.ardite_ore.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  raw_ardite_block = ITEMS.register("raw_ardite_block", () -> new BlockItem(ModBlocks.raw_ardite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  tinkers_bronze_block = ITEMS.register("tinkers_bronze_block", () -> new BlockItem(ModBlocks.tinkers_bronze_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  obsidian_bronze_block = ITEMS.register("obsidian_bronze_block", () -> new BlockItem(ModBlocks.obsidian_bronze_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  lightite_block = ITEMS.register("lightite_block", () -> new BlockItem(ModBlocks.lightite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  silky_jewel_block = ITEMS.register("silky_jewel_block", () -> new BlockItem(ModBlocks.silky_jewel_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  deepslate_chlorophyll_ore = ITEMS.register("deepslate_chlorophyll_ore", () -> new BlockItem(ModBlocks.deepslate_chlorophyll_ore.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  chlorophyll_ore = ITEMS.register("chlorophyll_ore", () -> new BlockItem(ModBlocks.chlorophyll_ore.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  chlorophyte_block = ITEMS.register("chlorophyte_block", () -> new BlockItem(ModBlocks.chlorophyte_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  spectre_block = ITEMS.register("spectre_block", () -> new BlockItem(ModBlocks.spectre_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  shroomite_block = ITEMS.register("shroomite_block", () -> new BlockItem(ModBlocks.shroomite_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  electrical_steel_block = ITEMS.register("electrical_steel_block", () -> new BlockItem(ModBlocks.electrical_steel_block.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  ardite_platform = ITEMS.register("ardite_platform", () -> new BlockItem(ModBlocks.ardite_platform.get(),new Item.Properties().tab(Tinkers_Thinking_Tab).fireResistant()));
    public static final RegistryObject<Item>  stone_ladder = ITEMS.register("stone_ladder", () -> new BlockItem(ModBlocks.stone_ladder.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  stone_torch = ITEMS.register("stone_torch", () -> new StandingAndWallBlockItem(ModBlocks.stone_torch.get(), ModBlocks.wall_stone_torch.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  stone_soul_torch = ITEMS.register("stone_soul_torch", () -> new StandingAndWallBlockItem(ModBlocks.stone_soul_torch.get(), ModBlocks.wall_stone_soul_torch.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    public static final RegistryObject<Item>  drying_rack = ITEMS.register("drying_rack", () -> new BlockItem( ModBlocks.drying_rack.get(), new Item.Properties().tab(Tinkers_Thinking_Tab)));
    //Buckets
    public static final RegistryObject<Item>  molten_ardite_bucket= ITEMS.register("molten_ardite_bucket", () -> new BucketItem(ModFluids.source_molten_ardite, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_tinkers_bronze_bucket= ITEMS.register("molten_tinkers_bronze_bucket", () -> new BucketItem(ModFluids.source_molten_tinkers_bronze, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_obsidian_bronze_bucket= ITEMS.register("molten_obsidian_bronze_bucket", () -> new BucketItem(ModFluids.source_molten_obsidian_bronze, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  molten_lightite_bucket= ITEMS.register("molten_lightite_bucket", () -> new BucketItem(ModFluids.source_molten_lightite, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  molten_cocoa_bucket= ITEMS.register("molten_cocoa_bucket", () -> new BucketItem(ModFluids.source_molten_cocoa, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  syrup_bucket= ITEMS.register("syrup_bucket", () -> new BucketItem(ModFluids.source_syrup, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));

    public static final RegistryObject<Item>  molten_black_chocolate_bucket= ITEMS.register("molten_black_chocolate_bucket", () -> new BucketItem(ModFluids.source_molten_black_chocolate, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_white_chocolate_bucket= ITEMS.register("molten_white_chocolate_bucket", () -> new BucketItem(ModFluids.source_molten_white_chocolate, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_chlorophyte_bucket= ITEMS.register("molten_chlorophyte_bucket", () -> new BucketItem(ModFluids.source_molten_chlorophyte, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_spectre_bucket= ITEMS.register("molten_spectre_bucket", () -> new BucketItem(ModFluids.source_molten_spectre, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_shroomite_bucket= ITEMS.register("molten_shroomite_bucket", () -> new BucketItem(ModFluids.source_molten_shroomite, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));
    public static final RegistryObject<Item>  molten_electrical_steel_bucket= ITEMS.register("molten_electrical_steel_bucket", () -> new BucketItem(ModFluids.source_molten_electrical_steel, new Item.Properties().tab(Tinkers_Thinking_Tab).stacksTo(1)));


    public static void registers(IEventBus eventBus)  {
        ITEMS.register(eventBus);
    }
}
