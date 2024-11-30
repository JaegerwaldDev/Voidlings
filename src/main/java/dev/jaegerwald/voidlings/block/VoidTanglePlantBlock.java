package dev.jaegerwald.voidlings.block;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.TwistingVinesPlantBlock;

public class VoidTanglePlantBlock extends TwistingVinesPlantBlock {
    public VoidTanglePlantBlock(Settings settings) {
        super(settings);
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) ModBlocks.VOID_TANGLE;
    }
}
