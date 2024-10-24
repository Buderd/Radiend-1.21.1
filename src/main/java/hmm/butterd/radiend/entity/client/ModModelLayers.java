package hmm.butterd.radiend.entity.client;

import hmm.butterd.radiend.Radiend;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer STARWALKER =
            new EntityModelLayer(Identifier.of(Radiend.MOD_ID, "starwalker"), "main");
}