package net.ferynafery.quailcutemod.item;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.ferynafery.quailcutemod.item.custom.FriedQuailEgg;
import net.ferynafery.quailcutemod.item.custom.WaterQuailEggBucket;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ferynafery.quailcutemod.item.custom.QuailEgg;

import net.ferynafery.quailcutemod.item.custom.BoiledQuailEgg;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(QuailCuteMod.MOD_ID);

    //public static final DeferredItem<Item> QUAIL_EGG = ITEMS.registerSimpleItem("quail_egg");
    public static final DeferredItem<QuailEgg> QUAIL_EGG = ITEMS.registerItem(
            "quail_egg",
            QuailEgg::new,
            properties -> properties
                    .stacksTo(16)
    );

    public static final DeferredItem<FriedQuailEgg> FRIED_QUAIL_EGG =
            ITEMS.registerItem(
                    "fried_quail_egg",
                    FriedQuailEgg::new,
                    properties -> properties
                            .stacksTo(64)
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(3)
                                            .saturationModifier(0.3f)
                                            .build()
                            )
            );

    public static final DeferredItem<BoiledQuailEgg> BOILED_QUAIL_EGG =
            ITEMS.registerItem(
                    "boiled_quail_egg",
                    BoiledQuailEgg::new,
                    properties -> properties
                            .stacksTo(64)
                            .food(
                                    new FoodProperties.Builder()
                                            .nutrition(3)
                                            .saturationModifier(0.3f)
                                            .build()
                            )
            );

    public static final DeferredItem<WaterQuailEggBucket> WATER_QUAIL_EGG_BUCKET =
            ITEMS.registerItem(
                    "water_quail_egg_bucket",
                    WaterQuailEggBucket::new,
                    properties -> properties.stacksTo(1) .craftRemainder(Items.BUCKET)
            );

    public static final DeferredItem<Item> QUAIL_TAB_ICON = ITEMS.registerSimpleItem("quail_tab_icon");

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
