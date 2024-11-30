package dev.jaegerwald.voidlings.rendering;

import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.util.math.Vec3d;

public class HollowDimensionEffects extends DimensionEffects implements DarkeningDimensionEffects {
    public HollowDimensionEffects() {
        super(0, true, SkyType.NONE, false, false);
    }

    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return color;
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return true;
    }

    @Override
    public boolean shouldDisableBaseAmbientLighting() {
        return true;
    }

    public static class CloudRenderer implements DimensionRenderingRegistry.CloudRenderer {
        @Override
        public void render(WorldRenderContext context) {

        }
    }
}
