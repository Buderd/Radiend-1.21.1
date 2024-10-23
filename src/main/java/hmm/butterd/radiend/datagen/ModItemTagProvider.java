package hmm.butterd.radiend.datagen;

import hmm.butterd.radiend.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.EDGEPINE_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
            .add(ModBlocks.EDGEPINE_LOG.asItem())
            .add(ModBlocks.EDGEPINE_WOOD.asItem())
            .add(ModBlocks.STRIPPED_EDGEPINE_LOG.asItem())
            .add(ModBlocks.STRIPPED_EDGEPINE_WOOD.asItem());
    }
}
