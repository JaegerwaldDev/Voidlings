package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import dev.jaegerwald.voidlings.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final ItemGroup VOIDLINGS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Voidlings.id("voidlings"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.VOID_LAMINA))
                    .displayName(Text.translatable("itemgroup.voidlings"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.VOID_LAMINA);
                        entries.add(ModItems.FRIED_LAMINA);

                        entries.add(ModBlocks.BLACK_ACID);
                        entries.add(ModBlocks.BLACK_ACID_BRICKS);
                        entries.add(ModBlocks.CRACKED_BLACK_ACID_BRICKS);
                        entries.add(ModBlocks.BLACK_ACID_BRICK_STAIRS);
                        entries.add(ModBlocks.BLACK_ACID_BRICK_SLAB);
                        entries.add(ModBlocks.BLACK_ACID_BRICK_WALL);
                        entries.add(ModBlocks.CHISELED_BLACK_ACID_BRICKS);
                        entries.add(ModBlocks.CHISELED_BLACK_ACID_PILLAR);
                        entries.add(ModItems.BLACK_ACID_CHUNK);

                        entries.add(ModBlocks.ACID_SPROUTS);
                        entries.add(ModBlocks.ACID_ROOTS);

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
                        entries.add(ModItems.MURIA_INGOT);
                        entries.add(ModBlocks.MURIA_BLOCK);

                        entries.add(ModItems.MURIA_SHOVEL);
                        entries.add(ModItems.MURIA_PICKAXE);
                        entries.add(ModItems.MURIA_AXE);
                        entries.add(ModItems.MURIA_HOE);

                        entries.add(ModItems.MURIA_HELMET);
                        entries.add(ModItems.MURIA_CHESTPLATE);
                        entries.add(ModItems.MURIA_LEGGINGS);
                        entries.add(ModItems.MURIA_BOOTS);

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
