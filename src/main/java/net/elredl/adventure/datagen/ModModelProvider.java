package net.elredl.adventure.datagen;

import net.elredl.adventure.block.ModBlocks;
import net.elredl.adventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCRAP_WOOD_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SWORD_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARTIFICIAL_SWORD_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCRAP_WOOD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOBLIN_SLOP, Models.GENERATED);

        itemModelGenerator.register(ModItems.GOBLIN_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
