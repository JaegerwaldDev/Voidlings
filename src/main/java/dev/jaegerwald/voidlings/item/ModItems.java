package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import dev.jaegerwald.voidlings.block.ModBlocks;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
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
    public static final Item MURIA_INGOT = registerItem("muria_ingot", new Item(new Item.Settings()));

    public static final Item MURIA_SHOVEL = registerItem("muria_shovel", new ShovelItem(ModToolMaterials.MURIA, 1.5F, -2.0F, new Item.Settings()));
    public static final Item MURIA_PICKAXE = registerItem("muria_pickaxe", new PickaxeItem(ModToolMaterials.MURIA, 1, -2.0F, new Item.Settings()));
    public static final Item MURIA_AXE = registerItem("muria_axe", new AxeItem(ModToolMaterials.MURIA, 6.0F, -2.0F, new Item.Settings()));
    public static final Item MURIA_HOE = registerItem("muria_hoe", new HoeItem(ModToolMaterials.MURIA, -3, 0.0F, new Item.Settings()));

    public static final Item MURIA_HELMET = registerItem("muria_helmet", new ArmorItem(ModArmorMaterials.MURIA, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item MURIA_CHESTPLATE = registerItem(
            "muria_chestplate", new ArmorItem(ModArmorMaterials.MURIA, ArmorItem.Type.CHESTPLATE, new Item.Settings())
    );
    public static final Item MURIA_LEGGINGS = registerItem("muria_leggings", new ArmorItem(ModArmorMaterials.MURIA, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item MURIA_BOOTS = registerItem("muria_boots", new ArmorItem(ModArmorMaterials.MURIA, ArmorItem.Type.BOOTS, new Item.Settings()));


    public static final Item FENNEC_MASK = registerItem("fennec_mask", new FennecMaskItem(new Item.Settings()));
    public static final Item REPLICA_WHISKERS = registerItem("replica_whiskers", new Item(new Item.Settings()));

    public static final Item PIERCED_MURIA_HANDLE = registerItem("pierced_muria_handle", new Item(new Item.Settings()));
    public static final Item SURGEONS_BLADE = registerItem("surgeons_blade", new SurgeonsBladeItem(ModToolMaterials.MURIA, 6, -2.0F, new Item.Settings()));

    public static final Item REPLACEMENT_HEART = registerItem("replacement_heart", new HeartItem(new Item.Settings().maxCount(1))); // debug item

    public static final Item VOIDLING_HEART = registerItem("voidling_heart", new HeartItem(new Item.Settings().maxCount(1)));
    public static final Item BROKEN_VOIDLING_HEART = registerItem("broken_voidling_heart", new Item(new Item.Settings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Voidlings.id(name), item);
    }

    public static void registerModItems() {
        Renderers.register();
    }
}
