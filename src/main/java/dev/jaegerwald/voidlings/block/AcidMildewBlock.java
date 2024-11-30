package dev.jaegerwald.voidlings.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.MossBlock;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcidMildewBlock extends MossBlock {
    public static final Logger LOGGER = LoggerFactory.getLogger("Voidlings");

    public AcidMildewBlock(Settings settings) {
        super(settings);
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        LOGGER.warn("yeah uhhhhhhhh how the fuck would i implement this dawn please help ;-;");
    }
}
