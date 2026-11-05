package net.ferynafery.quailcutemod.creativemodetab;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.ferynafery.quailcutemod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuailCuteMod.MOD_ID);

    public static final Supplier<CreativeModeTab> QUAIL_ITEMS_TAB = CREATIVE_MODE_TABS.register("quial_items_tabs",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.QUAIL_TAB_ICON.get()))
                    .title(Component.translatable("creativetab.quailcutemod.quail_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.QUAIL_EGG);

                    })
                    .build()
    );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
