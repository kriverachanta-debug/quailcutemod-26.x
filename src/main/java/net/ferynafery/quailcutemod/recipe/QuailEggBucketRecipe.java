
package net.ferynafery.quailcutemod.recipe;

import com.mojang.serialization.MapCodec;
import net.ferynafery.quailcutemod.component.ModDataComponents;
import net.ferynafery.quailcutemod.item.ModItems;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

public class QuailEggBucketRecipe extends CustomRecipe {
    public static final QuailEggBucketRecipe INSTANCE =
            new QuailEggBucketRecipe();

    public static final RecipeSerializer<QuailEggBucketRecipe> SERIALIZER =
            new RecipeSerializer<>(
                    MapCodec.unit(INSTANCE),
                    StreamCodec.unit(INSTANCE)
            );
    public QuailEggBucketRecipe() {
        super();
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        int bucketCount = 0;
        int eggCount = 0;
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.is(Items.WATER_BUCKET)) {
                bucketCount += stack.getCount();
            } else if (stack.is(ModItems.QUAIL_EGG.get())) {
                eggCount += stack.getCount();
            } else if (!stack.isEmpty()) {
                return false;
            }
        }
        return bucketCount == 1 && eggCount >= 1 && eggCount <= 5;
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        int eggCount = 0;
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.is(ModItems.QUAIL_EGG.get())) {
                eggCount += stack.getCount();
            }
        }
        ItemStack result = new ItemStack(
                ModItems.WATER_QUAIL_EGG_BUCKET.get()
        );
        result.set(ModDataComponents.EGG_COUNT.get(), eggCount);
        return result;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        return NonNullList.withSize(input.size(), ItemStack.EMPTY);
    }

    @Override
    public RecipeSerializer<? extends QuailEggBucketRecipe> getSerializer() {
        return SERIALIZER;
    }


}
