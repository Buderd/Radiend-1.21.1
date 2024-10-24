package hmm.butterd.radiend.entity.client;

import hmm.butterd.radiend.Radiend;
import hmm.butterd.radiend.entity.custom.StarwalkerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class StarwalkerRenderer extends MobEntityRenderer<StarwalkerEntity, StarwalkerModel<StarwalkerEntity>> {

    private static final Identifier TEXTURE = Identifier.of(Radiend.MOD_ID, "textures/entity/starwalker.png");

    public StarwalkerRenderer(EntityRendererFactory.Context context) {
        super(context, new StarwalkerModel<>(context.getPart(ModModelLayers.STARWALKER)), 0.6f);
    }

    @Override
    public Identifier getTexture(StarwalkerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(StarwalkerEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
