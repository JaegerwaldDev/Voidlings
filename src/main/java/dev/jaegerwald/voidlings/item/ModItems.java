package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BLACK_ACID = registerItem("black_acid", new Item(new Item.Settings()));
    public static final Item ACID_SPROUTS = registerItem("acid_sprouts", new Item(new Item.Settings()));

    public static final Item ACID_MILDEW = registerItem("acid_mildew", new Item(new Item.Settings()));
    public static final Item ACID_MILDEW_CARPET = registerItem("acid_mildew_carpet", new Item(new Item.Settings()));

    public static final Item VOID_TANGLE = registerItem("void_tangle", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Voidlings.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
        });
    }
}
