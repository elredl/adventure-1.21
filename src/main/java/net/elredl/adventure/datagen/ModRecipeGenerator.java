package net.elredl.adventure.datagen;

import net.elredl.adventure.block.ModBlocks;
import net.elredl.adventure.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ARTIFICIAL_SWORD_CORE)
                .pattern("#T#")
                .pattern("RSR")
                .pattern("#T#")
                .input('#', Items.DIAMOND)
                .input('R', Items.NETHERITE_INGOT)
                .input('S', Items.HEAVY_CORE)
                .input('T', Blocks.REDSTONE_BLOCK)
                .criterion(hasItem(Items.HEAVY_CORE), conditionsFromItem(Items.HEAVY_CORE))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.SCRAP_WOOD_BLOCK, ModItems.SCRAP_WOOD);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOBLIN_SLOP, 2)
                .input(ItemTags.MEAT)
                .input(Items.BONE_MEAL)
                .input(Items.WHEAT_SEEDS)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .offerTo(exporter);
    }
}
