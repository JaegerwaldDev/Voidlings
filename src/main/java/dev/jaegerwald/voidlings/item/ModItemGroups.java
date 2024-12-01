package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import dev.jaegerwald.voidlings.block.ModBlocks;
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
                        entries.add(ModItems.VOID_LAMINA);

                        entries.add(ModBlocks.BLACK_ACID);
                        entries.add(ModBlocks.ACID_SPROUTS);

                        entries.add(ModBlocks.ACID_MILDEW);
                        entries.add(ModBlocks.ACID_MILDEW_CARPET);

                        entries.add(ModBlocks.VOID_TANGLE);

                        entries.add(ModBlocks.LIQUID_ACID);
                    }).build());

    public static void registerItemGroups() {

    }
}
