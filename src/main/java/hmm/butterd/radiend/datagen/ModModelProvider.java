package hmm.butterd.radiend.datagen;

import hmm.butterd.radiend.block.ModBlocks;
import hmm.butterd.radiend.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GUILLOTINE_BLADE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RADIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_ENDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURPUR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANINITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FRANCIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EDGEPINE_LEAVES);
        blockStateModelGenerator.registerLog(ModBlocks.EDGEPINE_LOG).log(ModBlocks.EDGEPINE_LOG).wood(ModBlocks.EDGEPINE_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_EDGEPINE_LOG).log(ModBlocks.STRIPPED_EDGEPINE_LOG).wood(ModBlocks.STRIPPED_EDGEPINE_WOOD);
        BlockStateModelGenerator.BlockTexturePool edgepine_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EDGEPINE_PLANKS);
        edgepine_pool.stairs(ModBlocks.EDGEPINE_STAIRS);
        edgepine_pool.slab(ModBlocks.EDGEPINE_SLAB);
        edgepine_pool.button(ModBlocks.EDGEPINE_BUTTON);
        edgepine_pool.fence(ModBlocks.EDGEPINE_FENCE);
        edgepine_pool.fenceGate(ModBlocks.EDGEPINE_FENCE_GATE);
        edgepine_pool.pressurePlate(ModBlocks.EDGEPINE_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.EDGEPINE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EDGEPINE_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.EDGE_TAFFY, Models.GENERATED);
        itemModelGenerator.register(ModItems.URANINITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EDGE_SAP_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FRANCIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRANCIUM_INGOT, Models.GENERATED);
    }
}
