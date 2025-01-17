package dev.jaegerwald.voidlings;

import dev.jaegerwald.voidlings.block.ModBlocks;
import dev.jaegerwald.voidlings.entity.ModEntities;
import dev.jaegerwald.voidlings.entity.SomneerEntityRenderer;
import dev.jaegerwald.voidlings.particle.Particles;
import dev.jaegerwald.voidlings.particle.VoidWispParticle;
import dev.jaegerwald.voidlings.rendering.HollowDimensionEffects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.DimensionRenderingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class VoidlingsClient implements ClientModInitializer {
	private static final Identifier HOLLOW = Voidlings.id("hollow");

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		registerBlockCutout(ModBlocks.ACID_SPROUTS);
		registerBlockCutout(ModBlocks.ACID_ROOTS);
		registerBlockCutout(ModBlocks.VOID_TANGLE);
		registerBlockCutout(ModBlocks.VOID_TANGLE_PLANT);
		registerBlockCutout(ModBlocks.POTTED_VOID_TANGLE);
		registerBlockCutout(ModBlocks.VOID_VINES);
		registerBlockCutout(ModBlocks.VOID_VINES_PLANT);
		registerBlockCutout(ModBlocks.VOID_BLOOM);

		registerParticlesBcSplitSourcesBS();

		DimensionRenderingRegistry.registerDimensionEffects(HOLLOW, new HollowDimensionEffects());
		DimensionRenderingRegistry.registerCloudRenderer(RegistryKey.of(RegistryKeys.WORLD, HOLLOW), new HollowDimensionEffects.CloudRenderer());

		EntityRendererRegistry.register(ModEntities.SOMNEER, SomneerEntityRenderer::new);
	}

	private void registerBlockCutout(Block block) {
		BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
	}

	private static void registerParticlesBcSplitSourcesBS() {
		ParticleFactoryRegistry particleRegistry = ParticleFactoryRegistry.getInstance();

		particleRegistry.register(Particles.VOID_WISP, VoidWispParticle.Factory::new);
	}
}