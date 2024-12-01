package dev.jaegerwald.voidlings.block;

import dev.jaegerwald.voidlings.item.ModItems;
import dev.jaegerwald.voidlings.sound.ModSounds;
import dev.jaegerwald.voidlings.state.property.ModProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CaveVines;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public interface VoidVines extends CaveVines {
    BooleanProperty LAMINA = ModProperties.LAMINA;

    static ActionResult pickLamina(@Nullable Entity picker, BlockState state, World world, BlockPos pos) {
        if ((Boolean)state.get(LAMINA)) {
            Block.dropStack(world, pos, new ItemStack(ModItems.VOID_LAMINA, 1));
            float f = MathHelper.nextBetween(world.random, 0.8F, 1.2F);
            world.playSound(null, pos, ModSounds.BLOCK_VOID_VINES_PICK_LAMINA, SoundCategory.BLOCKS, 1.0F, f);
            BlockState blockState = state.with(LAMINA, Boolean.valueOf(false));
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(picker, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    static boolean hasLamina(BlockState state) {
        return state.contains(LAMINA) && (Boolean)state.get(LAMINA);
    }

    static ToIntFunction<BlockState> getLuminanceSupplier(int luminance) {
        return state -> state.get(ModProperties.LAMINA) ? luminance : 0;
    }
}
