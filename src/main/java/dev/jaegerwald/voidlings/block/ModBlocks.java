package dev.jaegerwald.voidlings.block;

import dev.jaegerwald.voidlings.Voidlings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLACK_ACID = registerBlock("black_acid",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DEEPSLATE_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresTool()
                            .strength(3.0F, 6.0F)
                            .sounds(BlockSoundGroup.WET_GRASS)
            )
    );
    public static final Block ACID_SPROUTS = registerBlock("acid_sprouts",
            new AcidSproutsBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DEEPSLATE_GRAY)
                            .replaceable()
                            .noCollision()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .offset(AbstractBlock.OffsetType.XZ)
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .luminance(state -> 10)
            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Voidlings.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Voidlings.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BLACK_ACID);
            entries.add(ModBlocks.ACID_SPROUTS);
        });
    }
}
