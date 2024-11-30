package dev.jaegerwald.voidlings.block;

import dev.jaegerwald.voidlings.Voidlings;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLACK_ACID = registerBlock("black_acid",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_AQUA)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(3.0F, 2.0F)
                            .sounds(BlockSoundGroup.WET_GRASS)
            )
    );
    public static final Block ACID_SPROUTS = registerBlock("acid_sprouts",
            new AcidFolliageBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_AQUA)
                            .replaceable()
                            .noCollision()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .offset(AbstractBlock.OffsetType.XZ)
                            .pistonBehavior(PistonBehavior.DESTROY)
                            .luminance(state -> 10)
            )
    );

    public static final Block ACID_MILDEW = registerBlock("acid_mildew",
            new AcidMildewBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_AQUA)
                            .strength(0.1F)
                            .sounds(BlockSoundGroup.MOSS_BLOCK)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final Block ACID_MILDEW_CARPET = registerBlock("acid_mildew_carpet",
            new CarpetBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_AQUA)
                            .strength(0.1F)
                            .sounds(BlockSoundGroup.MOSS_CARPET)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    public static final Block VOID_TANGLE = registerBlock("void_tangle",
            new VoidTangleBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.CYAN)
                            .noCollision()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );
    public static final Block VOID_TANGLE_PLANT = registerBlock("void_tangle_plant",
            new VoidTanglePlantBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.CYAN)
                            .noCollision()
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .pistonBehavior(PistonBehavior.DESTROY)
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
    }
}
