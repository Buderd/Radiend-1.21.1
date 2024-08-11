package hmm.butterd.radiend;

import net.fabricmc.api.ModInitializer;
//Giggity
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
	}
}