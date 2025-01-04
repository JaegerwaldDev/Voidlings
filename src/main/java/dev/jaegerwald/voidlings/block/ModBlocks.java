package dev.jaegerwald.voidlings.block;

import dev.jaegerwald.voidlings.Voidlings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;

public class ModBlocks {
    public static final Block BLACK_ACID = registerBlock("black_acid",
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_AQUA)
                            .instrument(Instrument.BASS)
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
                            .luminance(state -> 8)
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
            ),
            false
    );

    public static final Block LIQUID_ACID = registerBlock("liquid_acid",
            new SoulSandBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.BLACK)
                            .instrument(Instrument.COW_BELL)
                            .strength(1.0F)
                            .velocityMultiplier(0.15F)
                            .sounds(BlockSoundGroup.MUD)
                            .allowsSpawning(Blocks::always)
                            .solidBlock(Blocks::always)
                            .blockVision(Blocks::always)
                            .suffocates(Blocks::always)
            )
    );

    public static final Block VOID_VINES = registerBlock("void_vines",
            new VoidVinesHeadBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.CYAN)
                            .noCollision()
                            .luminance(VoidVines.getLuminanceSupplier(8))
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            false
    );
    public static final Block VOID_VINES_PLANT = registerBlock("void_vines_plant",
            new VoidVinesBodyBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.CYAN)
                            .noCollision()
                            .luminance(VoidVines.getLuminanceSupplier(8))
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            false
    );

    public static final Block VOID_BLOOM = registerBlock("void_bloom",
            new LilyPadBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.CYAN)
                            .breakInstantly()
                            .sounds(BlockSoundGroup.WET_GRASS)
                            .nonOpaque()
                            .noCollision()
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            false
    );

    public static final Block ACID_ENCASED_MURIA = registerBlock("acid_encased_muria",
            new ExperienceDroppingBlock(
                    AbstractBlock.Settings.create()
                                        .mapColor(MapColor.DARK_AQUA)
                                        .instrument(Instrument.BASS)
                                        .strength(3.0F, 2.0F)
                                        .sounds(BlockSoundGroup.WET_GRASS)
                                        .requiresTool(),
                    ConstantIntProvider.create(0)
            )
    );

    private static Block registerBlock(String name, Block block) {
        return registerBlock(name, block, true);
    }

    private static Block registerBlock(String name, Block block, boolean registerItem) {
        if (registerItem) registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Voidlings.id(name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Voidlings.id(name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
    }
}
