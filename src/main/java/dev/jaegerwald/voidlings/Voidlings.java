package dev.jaegerwald.voidlings;

import dev.jaegerwald.voidlings.item.ModItemGroups;
import dev.jaegerwald.voidlings.item.ModItems;
import dev.jaegerwald.voidlings.block.ModBlocks;
import dev.jaegerwald.voidlings.particle.Particles;
import dev.jaegerwald.voidlings.sound.ModSounds;
import dev.jaegerwald.voidlings.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Voidlings implements ModInitializer {
	public static final String MOD_ID = "voidlings";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Voidlings");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Particles.register();

		ModItemGroups.registerItemGroups();

		ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.register();
	}

	public static Identifier id(String name) {
		return Identifier.of(MOD_ID, name);
	}
}