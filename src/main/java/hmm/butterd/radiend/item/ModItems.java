package hmm.butterd.radiend.item;

import hmm.butterd.radiend.Radiend;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new Item.Settings()));
    public static final Item LEAD_CRYSTAL = registerItem("lead_crystal", new Item(new Item.Settings().food(ModFoodComponents.LEAD_CRYSTAL)));
    public static final Item URANINITE = registerItem("uraninite", new Item(new Item.Settings()));
    public static final Item RAW_FRANCIUM = registerItem("raw_francium", new Item(new Item.Settings()));
    public static final Item EDGE_TAFFY = registerItem("edge_taffy", new Item(new Item.Settings().food(ModFoodComponents.EDGE_TAFFY).rarity(Rarity.UNCOMMON)));
    public static final Item EDGE_SAP_BOTTLE = registerItem("edge_sap_bottle", new Item(new Item.Settings()));
    public static final Item FRANCIUM_INGOT = registerItem("francium_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Radiend.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Radiend.LOGGER.info("Registering Custom Items for Radiend");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LEAD_INGOT);
            entries.add(LEAD_CRYSTAL);
            entries.add(RAW_FRANCIUM);
            entries.add(FRANCIUM_INGOT);
            entries.add(URANINITE);
            entries.add(EDGE_SAP_BOTTLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(LEAD_CRYSTAL);
            entries.add(EDGE_TAFFY);
        });
    }
}

