package dev.jaegerwald.voidlings;

import dev.jaegerwald.voidlings.item.ModItemGroups;
import dev.jaegerwald.voidlings.item.ModItems;
import dev.jaegerwald.voidlings.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Voidlings implements ModInitializer {
	public static final String MOD_ID = "voidlings";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Voidlings");


	public static final SimpleParticleType SPARKLE_PARTICLE = FabricParticleTypes.simple();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("smoke weed everyday");

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}