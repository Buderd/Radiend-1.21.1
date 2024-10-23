package hmm.butterd.radiend.datagen;

import hmm.butterd.radiend.block.ModBlocks;
import hmm.butterd.radiend.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.LEAD_BLOCK);
        addDrop(ModBlocks.RADIUM_BLOCK);
        addDrop(ModBlocks.URANINITE_ORE, multipleOreDrops(ModBlocks.URANINITE_ORE, ModItems.URANINITE, 1, 4));
        addDrop(ModBlocks.FRANCIUM_ORE, multipleOreDrops(ModBlocks.FRANCIUM_ORE, ModItems.RAW_FRANCIUM, 1, 3));

        addDrop(ModBlocks.EDGEPINE_PLANKS);
        addDrop(ModBlocks.EDGEPINE_STAIRS);
        addDrop(ModBlocks.EDGEPINE_BUTTON);
        addDrop(ModBlocks.EDGEPINE_SLAB, slabDrops(ModBlocks.EDGEPINE_SLAB));
        addDrop(ModBlocks.EDGEPINE_PRESSURE_PLATE);
        addDrop(ModBlocks.EDGEPINE_FENCE);
        addDrop(ModBlocks.EDGEPINE_FENCE_GATE);
        addDrop(ModBlocks.EDGEPINE_DOOR, doorDrops(ModBlocks.EDGEPINE_DOOR));
        addDrop(ModBlocks.EDGEPINE_TRAPDOOR);
        addDrop(ModBlocks.EDGEPINE_LOG);
        addDrop(ModBlocks.EDGEPINE_WOOD);
        addDrop(ModBlocks.STRIPPED_EDGEPINE_LOG);
        addDrop(ModBlocks.STRIPPED_EDGEPINE_WOOD);
        addDrop(ModBlocks.EDGEPINE_DOOR, leavesDrops(ModBlocks.EDGEPINE_LEAVES, ModBlocks.EDGEPINE_FENCE, 0.003f));




    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
