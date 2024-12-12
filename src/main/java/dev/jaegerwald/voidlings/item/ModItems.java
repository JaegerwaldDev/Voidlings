package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import dev.jaegerwald.voidlings.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.item.FennecMaskItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // public static final Item BLACK_ACID = registerItem("black_acid", new Item(new Item.Settings()));
    // public static final Item ACID_SPROUTS = registerItem("acid_sprouts", new Item(new Item.Settings()));

    // public static final Item ACID_MILDEW = registerItem("acid_mildew", new Item(new Item.Settings()));
    // public static final Item ACID_MILDEW_CARPET = registerItem("acid_mildew_carpet", new Item(new Item.Settings()));

    // public static final Item VOID_TANGLE = registerItem("void_tangle", new Item(new Item.Settings()));

    // public static final Item LIQUID_ACID = registerItem("liquid_acid", new Item(new Item.Settings()));

    public static final Item VOID_LAMINA = registerItem("void_lamina", new AliasedBlockItem(ModBlocks.VOID_VINES, new Item.Settings()));

    public static final Item VOID_BLOOM = registerItem("void_bloom", new PlaceableOnWaterItem(ModBlocks.VOID_BLOOM, new Item.Settings()));

    public static final Item RAW_MURIA = registerItem("raw_muria", new Item(new Item.Settings()));

    public static final Item FENNEC_MASK = registerItem("fennec_mask", new FennecMaskItem(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Voidlings.MOD_ID, name), item);
    }

    public static void registerModItems() {
    }
}
