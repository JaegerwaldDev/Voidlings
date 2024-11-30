package dev.jaegerwald.voidlings.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SproutsBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AcidFolliageBlock extends SproutsBlock {
    public AcidFolliageBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.BLACK_ACID) || floor.isOf(ModBlocks.ACID_MILDEW) || super.canPlantOnTop(floor, world, pos);
    }
}
