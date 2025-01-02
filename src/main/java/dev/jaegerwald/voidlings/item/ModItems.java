package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import dev.jaegerwald.voidlings.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.*;
import dev.jaegerwald.voidlings.item.FennecMaskItem;
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

    public static final Item BLACK_ACID_CHUNK = registerItem("black_acid_chunk", new Item(new Item.Settings()));

    public static final Item VOID_LAMINA = registerItem("void_lamina", new AliasedBlockItem(ModBlocks.VOID_VINES, new Item.Settings()));
    public static final Item FRIED_LAMINA = registerItem("fried_lamina",
            new Item(
                    new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(2.0F).build())
            )
    );

    public static final Item VOID_BLOOM = registerItem("void_bloom", new PlaceableOnWaterItem(ModBlocks.VOID_BLOOM, new Item.Settings()));

    public static final Item RAW_MURIA = registerItem("raw_muria", new Item(new Item.Settings()));
    public static final Item MURIA_PLATE = registerItem("muria_plate", new Item(new Item.Settings()));
    public static final Item MURIA_RING = registerItem("muria_ring", new Item(new Item.Settings()));
    public static final Item PROCESSED_MURIA_PLATE = registerItem("processed_muria_plate", new Item(new Item.Settings()));
    public static final Item MURIA_SHELL = registerItem("muria_shell", new Item(new Item.Settings()));
    public static final Item MURIA_ROD = registerItem("muria_rod", new Item(new Item.Settings()));
    public static final Item FRAMED_CLOTH = registerItem("framed_cloth", new Item(new Item.Settings()));

    public static final Item FENNEC_MASK = registerItem("fennec_mask", new FennecMaskItem(new Item.Settings()));
    public static final Item REPLICA_WHISKERS = registerItem("replica_whiskers", new Item(new Item.Settings()));

    public static final Item PIERCED_MURIA_HANDLE = registerItem("pierced_muria_handle", new Item(new Item.Settings()));
    public static final Item SURGEONS_BLADE = registerItem("surgeons_blade", new SurgeonsBladeItem(ModToolMaterials.MURIA, 6, -2.0F, new Item.Settings()));

    public static final Item REPLACEMENT_HEART = registerItem("replacement_heart", new HeartItem(new Item.Settings().maxCount(1))); // debug item

    public static final Item VOIDLING_HEART = registerItem("voidling_heart", new HeartItem(new Item.Settings().maxCount(1)));
    public static final Item BROKEN_VOIDLING_HEART = registerItem("broken_voidling_heart", new Item(new Item.Settings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Voidlings.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Renderers.register();
    }
}
