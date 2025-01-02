package dev.jaegerwald.voidlings.particle;

import dev.jaegerwald.voidlings.Voidlings;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Particles {
    public static final ParticleType<DefaultParticleType> VOID_WISP = register("void_wisp", FabricParticleTypes.simple(false));

    public static void register() {
    }

    private static <T extends ParticleEffect> ParticleType<T> register(String name, ParticleType<T> particle) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Voidlings.MOD_ID, name), particle);
    }
}
