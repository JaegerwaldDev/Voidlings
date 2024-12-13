package dev.jaegerwald.voidlings.mixin;

import dev.jaegerwald.voidlings.item.ModItems;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @Inject(method = "hasLabel(Lnet/minecraft/entity/LivingEntity;)Z", at = @At("HEAD"), cancellable = true)
    private void ermActuallyItDoesntHaveLabel(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
        if (livingEntity.getEquippedStack(EquipmentSlot.HEAD).isOf(ModItems.FENNEC_MASK)) cir.setReturnValue(false);
    }
}
