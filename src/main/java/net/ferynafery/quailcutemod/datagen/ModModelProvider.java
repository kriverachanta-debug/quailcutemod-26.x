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
        itemModels.generateFlatItem(ModItems.QUAIL_EGG.get(), ModelTemplates.FLAT_ITEM);




    }
}
