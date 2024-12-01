package dev.jaegerwald.voidlings.sound;

import dev.jaegerwald.voidlings.Voidlings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent BLOCK_VOID_VINES_PICK_LAMINA = registerSoundEvent("block.void_vines.pick_lamina");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Voidlings.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {

    }
}
