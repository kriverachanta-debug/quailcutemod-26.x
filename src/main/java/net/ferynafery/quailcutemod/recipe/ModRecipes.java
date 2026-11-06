
package net.ferynafery.quailcutemod.recipe;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(
                    Registries.RECIPE_SERIALIZER,
                    QuailCuteMod.MOD_ID
            );

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

    public static final net.neoforged.neoforge.registries.DeferredHolder<
            RecipeSerializer<?>,
            RecipeSerializer<QuailEggBucketRecipe>
            > QUAIL_EGG_BUCKET =
            SERIALIZERS.register(
                    "quail_egg_bucket",
                    () -> QuailEggBucketRecipe.SERIALIZER
            );

    public static final net.neoforged.neoforge.registries.DeferredHolder<
            RecipeSerializer<?>,
            RecipeSerializer<QuailEggSmeltingRecipe>
            > QUAIL_EGG_SMELTING =
            SERIALIZERS.register(
                    "quail_egg_smelting",
                    () -> QuailEggSmeltingRecipe.SERIALIZER
            );

}
