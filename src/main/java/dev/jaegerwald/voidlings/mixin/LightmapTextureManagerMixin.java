package dev.jaegerwald.voidlings.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.jaegerwald.voidlings.rendering.DarkeningDimensionEffects;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.world.ClientWorld;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
    @Unique
    private boolean shouldDisableBaseAmbientLighting;

    @Inject(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/DimensionEffects;shouldBrightenLighting()Z"))
    private void darkenLighting(float delta, CallbackInfo ci, @Local ClientWorld clientWorld) {
        shouldDisableBaseAmbientLighting = clientWorld.getDimensionEffects() instanceof DarkeningDimensionEffects effects && effects.shouldDisableBaseAmbientLighting();
    }

    @Redirect(method = "update", at = @At(value = "INVOKE", target = "Lorg/joml/Vector3f;lerp(Lorg/joml/Vector3fc;F)Lorg/joml/Vector3f;", ordinal = 6), remap = false)
    private Vector3f darkenLighting(Vector3f instance, Vector3fc other, float t) {
        return shouldDisableBaseAmbientLighting ? instance : instance.lerp(other, t);
    }
}
