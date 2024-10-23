package hmm.butterd.radiend.datagen;

import hmm.butterd.radiend.Radiend;
import hmm.butterd.radiend.block.ModBlocks;
import hmm.butterd.radiend.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> FRANCIUM_SMELTABLES = List.of(ModItems.RAW_FRANCIUM, ModBlocks.FRANCIUM_ORE);

        offerSmelting(exporter, FRANCIUM_SMELTABLES, RecipeCategory.MISC, ModItems.FRANCIUM_INGOT, 0.5f, 300, "francium");
        offerBlasting(exporter, FRANCIUM_SMELTABLES, RecipeCategory.MISC, ModItems.FRANCIUM_INGOT, 0.5f, 200, "francium");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_INGOT)
                .pattern("CCC")
                .pattern("CCC")
                .input('C', ModItems.LEAD_CRYSTAL)
                .criterion(hasItem(ModItems.LEAD_CRYSTAL), conditionsFromItem(ModItems.LEAD_CRYSTAL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .input('I', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_INGOT, 9)
                .input(ModBlocks.LEAD_BLOCK)
                .criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK))
                .offerTo(exporter, Identifier.of(Radiend.MOD_ID, "lead_ingot_from_lead_block"));



    }
}
