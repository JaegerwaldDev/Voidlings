package dev.jaegerwald.voidlings.entity;

import dev.jaegerwald.voidlings.Voidlings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SomneerEntity> SOMNEER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Voidlings.MOD_ID, "somneer"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SomneerEntity::new)
                    .dimensions(EntityDimensions.fixed(4.0f,2.0f)).build()
    );
}
