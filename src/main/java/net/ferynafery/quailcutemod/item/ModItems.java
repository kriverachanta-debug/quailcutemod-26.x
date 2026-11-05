package net.ferynafery.quailcutemod.item;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(QuailCuteMod.MOD_ID);

    public static final DeferredItem<Item> QUAIL_EGG = ITEMS.registerSimpleItem("quail_egg");

    public static final DeferredItem<Item> QUAIL_TAB_ICON = ITEMS.registerSimpleItem("quail_tab_icon");

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
