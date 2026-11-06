package net.ferynafery.quailcutemod.datagen;

import net.ferynafery.quailcutemod.QuailCuteMod;
import net.ferynafery.quailcutemod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, QuailCuteMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(
                ModItems.QUAIL_EGG.get(),
                ModelTemplates.FLAT_ITEM
        );

        itemModels.generateFlatItem(
                ModItems.FRIED_QUAIL_EGG.get(),
                ModelTemplates.FLAT_ITEM
        );

        itemModels.generateFlatItem(
                ModItems.QUAIL_TAB_ICON.get(),
                ModelTemplates.FLAT_ITEM
        );

        //itemModels.generateFlatItem(ModItems.NEST_ASSIGNMENT_WAND.get(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModItems.QUAIL_FERTILIZER.get(), ModelTemplates.FLAT_ITEM);
        //itemModels.generateFlatItem(ModItems.SPOILED_QUAIL_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WATER_QUAIL_EGG_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.BOILED_QUAIL_EGG.get(), ModelTemplates.FLAT_ITEM);
    }



}
