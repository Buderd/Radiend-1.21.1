package hmm.butterd.radiend.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent LEAD_CRYSTAL = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600), 0.95f).build();
    public static final FoodComponent EDGE_TAFFY = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 300), 0.95f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200),1f).build();
}
