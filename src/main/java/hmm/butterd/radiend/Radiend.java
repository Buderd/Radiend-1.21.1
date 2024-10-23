package hmm.butterd.radiend;

import hmm.butterd.radiend.block.ModBlocks;
import hmm.butterd.radiend.item.ModItems;
import net.fabricmc.api.ModInitializer;
//Giggity
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Radiend implements ModInitializer {
	public static final String MOD_ID = "radiend";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Viva la Radiation!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		StrippableBlockRegistry.register(ModBlocks.EDGEPINE_LOG, ModBlocks.STRIPPED_EDGEPINE_LOG);
		StrippableBlockRegistry.register(ModBlocks.EDGEPINE_WOOD, ModBlocks.STRIPPED_EDGEPINE_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDGEPINE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDGEPINE_PLANKS, 5, 15);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDGEPINE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EDGEPINE_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_EDGEPINE_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EDGEPINE_LEAVES, 35, 55);
	}
}