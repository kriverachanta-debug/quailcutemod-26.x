package net.ferynafery.quailcutemod;

import net.ferynafery.quailcutemod.component.ModDataComponents;
import net.ferynafery.quailcutemod.creativemodetab.ModCreativeModeTabs;
import net.ferynafery.quailcutemod.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import net.ferynafery.quailcutemod.recipe.ModRecipes;

@Mod(QuailCuteMod.MOD_ID)
public class QuailCuteMod {
    // Definimos el ID del mod en un lugar común para que todas las partes del código puedan utilizarlo.
    public static final String MOD_ID = "quailcutemod";

    public static final Logger LOGGER = LogUtils.getLogger();

    // El constructor de la clase del mod es el primer código que se ejecuta cuando se carga nuestro mod.
    // FML reconocerá automáticamente algunos tipos de parámetros, como IEventBus o ModContainer
    public QuailCuteMod(IEventBus modEventBus, ModContainer modContainer) {
        // Registramos el metodo commonSetup para que se ejecute durante la carga del mod.
        modEventBus.addListener(this::commonSetup);

        ModDataComponents.COMPONENTS.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
        // Registramos el metodo addCreative para añadir objetos a una pestaña del inventario creativo.
        modEventBus.addListener(this::addCreative);
        // Registramos el ModConfigSpec de nuestro mod para que FML pueda crear y cargar el archivo de configuración automáticamente.
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Añadimos el objeto correspondiente a nuestro bloque a la pestaña de bloques de construcción.
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){

            
        }
    }

    // Podemos utilizar @SubscribeEvent y dejar que el Event Bus descubra automáticamente los métodos que debe ejecutar.
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
