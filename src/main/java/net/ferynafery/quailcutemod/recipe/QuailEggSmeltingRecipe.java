package net.ferynafery.quailcutemod.recipe;

import com.mojang.serialization.MapCodec;
import net.ferynafery.quailcutemod.component.ModDataComponents;
import net.ferynafery.quailcutemod.item.ModItems;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategories;

public class QuailEggSmeltingRecipe extends AbstractCookingRecipe {

    public static final MapCodec<QuailEggSmeltingRecipe> MAP_CODEC =
            AbstractCookingRecipe.cookingMapCodec(
                    QuailEggSmeltingRecipe::new,
                    200
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, QuailEggSmeltingRecipe> STREAM_CODEC =
            AbstractCookingRecipe.cookingStreamCodec(
                    QuailEggSmeltingRecipe::new
            );

    public static final RecipeSerializer<QuailEggSmeltingRecipe> SERIALIZER =
            new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    public QuailEggSmeltingRecipe(
            Recipe.CommonInfo commonInfo,
            AbstractCookingRecipe.CookingBookInfo bookInfo,
            Ingredient ingredient,
            ItemStackTemplate result,
            float experience,
            int cookingTime
    ) {
        super(
                commonInfo,
                bookInfo,
                ingredient,
                result,
                experience,
                cookingTime
        );
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        ItemStack bucket = input.item();

        int eggCount = bucket.getOrDefault(
                ModDataComponents.EGG_COUNT.get(),
                0
        );

        return super.matches(input, level)
                && eggCount >= 1
                && eggCount <= 5;
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input) {
        ItemStack bucket = input.item();

        int eggCount = bucket.getOrDefault(
                ModDataComponents.EGG_COUNT.get(),
                0
        );

        if (eggCount < 1 || eggCount > 5) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(
                ModItems.BOILED_QUAIL_EGG.get(),
                eggCount
        );
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.FURNACE_FOOD;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RecipeSerializer<SmeltingRecipe> getSerializer() {
        return (RecipeSerializer<SmeltingRecipe>) (RecipeSerializer<?>) SERIALIZER;
    }

    @Override
    public RecipeType<? extends AbstractCookingRecipe> getType() {
        return RecipeType.SMELTING;
    }

    @Override
    protected Item furnaceIcon() {
        return Items.FURNACE;
    }
}