package net.elredl.adventure.entity.client;

import net.elredl.adventure.Adventure;
import net.elredl.adventure.entity.custom.GoblinEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GoblinRenderer extends MobEntityRenderer<GoblinEntity, GoblinModel> {

    public GoblinRenderer(EntityRendererFactory.Context context) {
        super(context, new GoblinModel(context.getPart(ModEntityModelLayers.GOBLIN)), 0.5f);
    }

    @Override
    public Identifier getTexture(GoblinEntity entity) {
        return Identifier.of(Adventure.MOD_ID, "textures/entity/goblin/goblin_h1s1o1.png");
    }

    @Override
    public void render(GoblinEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.75f, 0.75f, 0.75f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
