package net.elredl.adventure;

import net.elredl.adventure.entity.ModEntities;
import net.elredl.adventure.entity.client.GoblinModel;
import net.elredl.adventure.entity.client.GoblinRenderer;
import net.elredl.adventure.entity.client.ModEntityModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class AdventureModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.GOBLIN, GoblinModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GOBLIN, GoblinRenderer::new);
    }
}
