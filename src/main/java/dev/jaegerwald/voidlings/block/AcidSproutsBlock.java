package dev.jaegerwald.voidlings.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SproutsBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AcidSproutsBlock extends SproutsBlock {
    public AcidSproutsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.BLACK_ACID) || super.canPlantOnTop(floor, world, pos);
    }
}
