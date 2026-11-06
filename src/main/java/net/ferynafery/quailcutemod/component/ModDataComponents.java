package net.ferynafery.quailcutemod.component;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import com.mojang.serialization.Codec;

public class ModDataComponents {

    public static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.createDataComponents(
                    Registries.DATA_COMPONENT_TYPE,
                    QuailCuteMod.MOD_ID
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> EGG_COUNT =
            COMPONENTS.registerComponentType(
                    "egg_count",
                    builder -> builder
                            .persistent(Codec.intRange(1, 5))
                            .networkSynchronized(ByteBufCodecs.VAR_INT)
            );

}
