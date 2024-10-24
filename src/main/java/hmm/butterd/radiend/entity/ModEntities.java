package hmm.butterd.radiend.entity;
import hmm.butterd.radiend.Radiend;
import hmm.butterd.radiend.entity.custom.StarwalkerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static  final EntityType<StarwalkerEntity> STARWALKER = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Radiend.MOD_ID, "starwalker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StarwalkerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());

}
