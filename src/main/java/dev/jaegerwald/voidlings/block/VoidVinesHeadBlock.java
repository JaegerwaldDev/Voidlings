package dev.jaegerwald.voidlings.block;

import com.mojang.serialization.MapCodec;
import dev.jaegerwald.voidlings.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class VoidVinesHeadBlock extends AbstractPlantStemBlock implements Fertilizable, VoidVines {
    public static final MapCodec<VoidVinesHeadBlock> CODEC = createCodec(VoidVinesHeadBlock::new);
    private static final float GROW_CHANCE = 0.11F;

    @Override
    protected MapCodec<VoidVinesHeadBlock> getCodec() {
        return CODEC;
    }

    public VoidVinesHeadBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, Integer.valueOf(0)).with(LAMINA, Boolean.valueOf(false)));
    }

    @Override
    protected int getGrowthLength(Random random) {
        return 1;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isAir();
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.VOID_VINES_PLANT;
    }

    @Override
    protected BlockState copyState(BlockState from, BlockState to) {
        return to.with(LAMINA, (Boolean)from.get(LAMINA));
    }

    @Override
    protected BlockState age(BlockState state, Random random) {
        return super.age(state, random).with(LAMINA, Boolean.valueOf(random.nextFloat() < 0.11F));
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.VOID_LAMINA);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        return VoidVines.pickLamina(player, state, world, pos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LAMINA);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !(Boolean)state.get(LAMINA);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(LAMINA, Boolean.valueOf(true)), Block.NOTIFY_LISTENERS);
    }
}
