package dev.jaegerwald.voidlings.util;

import dev.jaegerwald.voidlings.entity.ModEntities;
import dev.jaegerwald.voidlings.entity.SomneerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class ModRegistries {
    public static void register() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.SOMNEER, SomneerEntity.setAttributes());
    }
}
