package net.elredl.adventure.entity.client;

import net.elredl.adventure.entity.client.animation.GoblinAnimations;
import net.elredl.adventure.entity.custom.GoblinEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class GoblinModel extends SinglePartEntityModel<GoblinEntity> {

    private final ModelPart Head;
    private final ModelPart Body;

    public GoblinModel(ModelPart root) {
        this.Head = root.getChild("Head");
        this.Body = root.getChild("Body");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Head = modelPartData.addChild("Head", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -3.4F, -3.7F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(29, 18).cuboid(-1.0F, 0.6F, -4.7F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(3.0F, -3.4F, -0.7F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-6.0F, -3.4F, -0.7F, 3.0F, 6.0F, 0.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-3.0F, -3.4F, -3.7F, 6.0F, 6.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 12.4F, 0.7F));

        ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(18, 12).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 0).cuboid(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 2.0F, new Dilation(0.25F)), ModelTransform.of(0.0F, 17.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData RightArm = Body.addChild("RightArm", ModelPartBuilder.create().uv(0, 31).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(28, 27).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.25F)), ModelTransform.pivot(-3.0F, -1.5F, 0.0F));

        ModelPartData LeftArm = Body.addChild("LeftArm", ModelPartBuilder.create().uv(28, 16).mirrored().cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(28, 4).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.25F)), ModelTransform.pivot(3.0F, -1.5F, 0.0F));

        ModelPartData RightLeg = Body.addChild("RightLeg", ModelPartBuilder.create().uv(16, 27).mirrored().cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                .uv(8, 24).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.25F)), ModelTransform.pivot(-0.9F, 2.5F, 0.0F));

        ModelPartData LeftLeg = Body.addChild("LeftLeg", ModelPartBuilder.create().uv(0, 24).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
                .uv(22, 22).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.25F)), ModelTransform.pivot(0.9F, 2.5F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(GoblinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(GoblinAnimations.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, GoblinAnimations.idle, ageInTicks, 1f);

    }

    private void setHeadAngles(float headYaw, float headPitch) {
        this.Head.yaw = headYaw * (float) (Math.PI / 180.0);
        this.Head.pitch = headPitch * (float) (Math.PI / 180.0);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Head.render(matrices, vertexConsumer, light, overlay, color);
        Body.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return this.Body;
    }
}
