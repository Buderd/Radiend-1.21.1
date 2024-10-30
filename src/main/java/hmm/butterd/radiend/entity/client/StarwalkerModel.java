// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
package hmm.butterd.radiend.entity.client;

import hmm.butterd.radiend.entity.animation.ModAnimations;
import hmm.butterd.radiend.entity.custom.StarwalkerEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class StarwalkerModel<T extends StarwalkerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart starwalker;
	private final ModelPart head;

	public StarwalkerModel(ModelPart root) {
		this.starwalker = root.getChild("starwalker");
		this.head = this.starwalker.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData starwalker = modelPartData.addChild("starwalker", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = starwalker.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.5F, 0.0F));

		ModelPartData horns = head.addChild("horns", ModelPartBuilder.create().uv(14, 50).cuboid(-12.5F, -11.0F, 0.0F, 25.0F, 14.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.5F, 0.0F));

		ModelPartData leg_1 = starwalker.addChild("leg_1", ModelPartBuilder.create().uv(12, 18).cuboid(-1.5F, -2.0F, -1.5F, 3.0F, 20.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -18.0F, 0.0F));

		ModelPartData leg_2 = starwalker.addChild("leg_2", ModelPartBuilder.create().uv(0, 18).cuboid(-1.5F, -2.0F, -1.5F, 3.0F, 20.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -18.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(StarwalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(ModAnimations.STARWALKER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.STARWALKER_IDLE, ageInTicks, 1f);
	}
	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		starwalker.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return starwalker;
	}
}