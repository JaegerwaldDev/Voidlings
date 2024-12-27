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
                    .icon(() -> new ItemStack(ModItems.VOID_LAMINA))
                    .displayName(Text.translatable("itemgroup.voidlings.items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VOID_LAMINA);
                        entries.add(ModItems.FRIED_LAMINA);

                        entries.add(ModBlocks.BLACK_ACID);
                        entries.add(ModItems.BLACK_ACID_CHUNK);
                        entries.add(ModBlocks.ACID_SPROUTS);

                        entries.add(ModBlocks.ACID_MILDEW);
                        entries.add(ModBlocks.ACID_MILDEW_CARPET);
                        entries.add(ModBlocks.VOID_TANGLE);

                        entries.add(ModBlocks.LIQUID_ACID);
                        entries.add(ModItems.VOID_BLOOM);

                        entries.add(ModBlocks.ACID_ENCASED_MURIA);
                        entries.add(ModItems.RAW_MURIA);
                        entries.add(ModItems.MURIA_PLATE);
                        entries.add(ModItems.MURIA_RING);
                        entries.add(ModItems.PROCESSED_MURIA_PLATE);
                        entries.add(ModItems.MURIA_SHELL);
                        entries.add(ModItems.MURIA_ROD);
                        entries.add(ModItems.FRAMED_CLOTH);

                        entries.add(ModItems.FENNEC_MASK);
                        entries.add(ModItems.REPLICA_WHISKERS);

                        entries.add(ModItems.SURGEONS_BLADE);
                        entries.add(ModItems.PIERCED_MURIA_HANDLE);

                        entries.add(ModItems.VOIDLING_HEART);
                        entries.add(ModItems.BROKEN_VOIDLING_HEART);
                    }).build());

    public static void registerItemGroups() {

    }
}
