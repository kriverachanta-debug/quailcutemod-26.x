package net.ferynafery.quailcutemod.item;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(QuailCuteMod.MOD_ID);

    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite" );



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
