package net.ferynafery.quailcutemod.item.custom;

import net.ferynafery.quailcutemod.component.ModDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class WaterQuailEggBucket extends Item {

    public WaterQuailEggBucket(Item.Properties properties){
        super(properties);
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            Item.TooltipContext context,
            TooltipDisplay display,
            Consumer<Component> textConsumer,
            TooltipFlag flag
    ) {
        if (stack.has(ModDataComponents.EGG_COUNT.get())) {

            int eggCount = stack.getOrDefault(
                    ModDataComponents.EGG_COUNT.get(),
                    0
            );

            textConsumer.accept(
                    Component.translatable(
                            "tooltip.quailcutemod.water_quail_egg_bucket.contains",
                            eggCount
                    ).withStyle(ChatFormatting.GRAY)
            );
        }
    }
}
