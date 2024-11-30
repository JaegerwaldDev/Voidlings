package dev.jaegerwald.voidlings.block;

import net.minecraft.block.*;
import net.minecraft.util.math.Direction;

public class VoidTangleBlock extends TwistingVinesBlock {
    public VoidTangleBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected Block getPlant() {
        return ModBlocks.VOID_TANGLE_PLANT;
    }
}
