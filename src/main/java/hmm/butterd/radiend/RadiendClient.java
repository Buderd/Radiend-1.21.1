package hmm.butterd.radiend;

import hmm.butterd.radiend.block.ModBlocks;
import hmm.butterd.radiend.entity.ModEntities;
import hmm.butterd.radiend.entity.client.ModModelLayers;
import hmm.butterd.radiend.entity.client.StarwalkerModel;
import hmm.butterd.radiend.entity.client.StarwalkerRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class RadiendClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EDGEPINE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EDGEPINE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EDGEPINE_LEAVES, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.STARWALKER, StarwalkerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.STARWALKER, StarwalkerModel::getTexturedModelData);
    }
}
