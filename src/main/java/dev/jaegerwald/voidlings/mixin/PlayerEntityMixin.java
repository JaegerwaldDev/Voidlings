package dev.jaegerwald.voidlings.mixin;

import dev.jaegerwald.voidlings.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(method = "shouldRenderName", at = @At("HEAD"), cancellable = true)
    private void overrideRenderName(CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isOf(ModItems.FENNEC_MASK)) cir.setReturnValue(false);
    }
}
