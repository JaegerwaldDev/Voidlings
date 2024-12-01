package dev.jaegerwald.voidlings;

import dev.jaegerwald.voidlings.block.ModBlocks;
import dev.jaegerwald.voidlings.particle.Particles;
import dev.jaegerwald.voidlings.particle.VoidWispParticle;
import dev.jaegerwald.voidlings.rendering.HollowDimensionEffects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class VoidlingsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACID_SPROUTS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_TANGLE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_TANGLE_PLANT, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_VINES, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_VINES_PLANT, RenderLayer.getCutout());

		registerParticlesBcSplitSourcesBS();

		DimensionRenderingRegistry.registerDimensionEffects(Identifier.of(Voidlings.MOD_ID, "hollow"), new HollowDimensionEffects());
		DimensionRenderingRegistry.registerCloudRenderer(RegistryKey.of(RegistryKeys.WORLD, Identifier.of(Voidlings.MOD_ID, "hollow")), new HollowDimensionEffects.CloudRenderer());
	}

	private static void registerParticlesBcSplitSourcesBS() {
		ParticleFactoryRegistry particleRegistry = ParticleFactoryRegistry.getInstance();

		particleRegistry.register(Particles.VOID_WISP, VoidWispParticle.Factory::new);
	}
}