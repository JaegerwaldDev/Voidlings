package dev.jaegerwald.voidlings.entity;

import dev.jaegerwald.voidlings.Voidlings;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SomneerEntityRenderer extends GeoEntityRenderer<SomneerEntity> {
    public SomneerEntityRenderer(EntityRendererFactory.Context renderManager) {
    super(renderManager, new DefaultedEntityGeoModel<>(new Identifier(Voidlings.MOD_ID, "somneer")));
    }
}
