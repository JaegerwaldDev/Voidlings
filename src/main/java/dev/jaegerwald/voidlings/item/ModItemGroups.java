package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup VOIDLINGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Voidlings.MOD_ID, "voidlings"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.ACID_SPROUTS))
                    .displayName(Text.translatable("itemgroup.voidlings.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLACK_ACID);
                        entries.add(ModItems.ACID_SPROUTS);
                    }).build());

    public static void registerItemGroups() {

    }
}
