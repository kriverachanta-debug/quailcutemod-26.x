package net.ferynafery.quailcutemod.mixin;

import net.ferynafery.quailcutemod.item.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class AbstractFurnaceBlockEntityMixin {

    @Unique
    private static final ThreadLocal<Boolean> quailcutemod$isQuailBucket =
            ThreadLocal.withInitial(() -> false);

    @Inject(method = "burn", at = @At("HEAD"))
    private static void quailcutemod$checkInput(
            NonNullList<ItemStack> items,
            ItemStack inputItemStack,
            ItemStack result,
            CallbackInfo ci
    ) {
        quailcutemod$isQuailBucket.set(
                inputItemStack.is(ModItems.WATER_QUAIL_EGG_BUCKET.get())
        );
    }

    @Inject(method = "burn", at = @At("RETURN"))
    private static void quailcutemod$returnEmptyBucket(
            NonNullList<ItemStack> items,
            ItemStack inputItemStack,
            ItemStack result,
            CallbackInfo ci
    ) {
        boolean isQuailBucket = quailcutemod$isQuailBucket.get();
        quailcutemod$isQuailBucket.remove();

        if (!isQuailBucket) {
            return;
        }

        if (items.get(0).isEmpty()) {
            items.set(0, new ItemStack(Items.BUCKET));
        }
    }
}