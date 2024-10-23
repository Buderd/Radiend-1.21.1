package hmm.butterd.radiend.datagen;

import hmm.butterd.radiend.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FRANCIUM_ORE)
                .add(ModBlocks.URANINITE_ORE)
                .add(ModBlocks.BUDDING_ENDSTONE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BUDDING_ENDSTONE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FRANCIUM_ORE)
                .add(ModBlocks.URANINITE_ORE);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.EDGEPINE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.EDGEPINE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EDGEPINE_LOG)
                .add(ModBlocks.EDGEPINE_WOOD)
                .add(ModBlocks.STRIPPED_EDGEPINE_LOG)
                .add(ModBlocks.STRIPPED_EDGEPINE_WOOD);
    }
}
