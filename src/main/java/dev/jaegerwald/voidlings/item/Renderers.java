package dev.jaegerwald.voidlings.item;

import dev.jaegerwald.voidlings.Voidlings;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Renderers {
    public static Map<Item, Map<BiPredicate<ItemStack, ModelTransformationMode>, ModelIdentifier>> RENDERERS = new HashMap<>();
    public static final List<ModelIdentifier> FORCELOAD = new ArrayList<>();

    public static void register() {
        RENDERERS.put(ModItems.SURGEONS_BLADE, Map.of((stack, modelTransformationMode) -> {
            return modelTransformationMode != ModelTransformationMode.GUI; // The condition to apply the model
        }, forceLoad("surgeons_blade_in_hand")));
    }

    public static void apply(ItemStack stack, ModelTransformationMode mode, Consumer<ModelIdentifier> consumer) {
        Map<BiPredicate<ItemStack, ModelTransformationMode>, ModelIdentifier> renderer = Renderers.RENDERERS.get(stack.getItem());
        if (renderer != null) renderer.forEach(((predicate, modelIdentifier) -> {
            if (predicate.test(stack, mode)) consumer.accept(modelIdentifier);
        }));
    }

    private static ModelIdentifier forceLoad(String path) {
        ModelIdentifier modelID = modelID(path);
        FORCELOAD.add(modelID);
        return modelID;
    }

    private static ModelIdentifier modelID(String path) {
        return ModelIdentifier.ofInventoryVariant(Identifier.of(Voidlings.MOD_ID, path));
    }
}
