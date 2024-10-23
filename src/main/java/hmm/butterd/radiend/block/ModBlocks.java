package hmm.butterd.radiend.block;

import com.mojang.serialization.MapCodec;
import hmm.butterd.radiend.Radiend;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;


import static net.minecraft.block.Blocks.*;

public class ModBlocks {
    public static final Block PURPUR = registerBlock("purpur",
            new Block(AbstractBlock.Settings.create().strength(3f).sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block GUILLOTINE_BLADE = registerBlock("guillotine_blade",
            new AnvilBlock(AbstractBlock.Settings.create().strength(3f).sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block RADIUM_BLOCK = registerBlock("radium_block",
            new RedstoneBlock(AbstractBlock.Settings.create().strength(3f).sounds(BlockSoundGroup.METAL).ticksRandomly()));

    public static final Block EDGEPINE_PLANKS = registerBlock("edgepine_planks",
            new Block(AbstractBlock.Settings.copy(OAK_PLANKS).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block EDGEPINE_LOG = registerBlock("edgepine_log",
            new PillarBlock(AbstractBlock.Settings.copy(OAK_LOG).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_EDGEPINE_LOG = registerBlock("stripped_edgepine_log",
            new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_LOG).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block EDGEPINE_WOOD = registerBlock("edgepine_wood",
            new PillarBlock(AbstractBlock.Settings.copy(OAK_WOOD).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block STRIPPED_EDGEPINE_WOOD = registerBlock("stripped_edgepine_wood",
            new PillarBlock(AbstractBlock.Settings.copy(STRIPPED_OAK_WOOD).strength(2f).sounds(BlockSoundGroup.WOOD)));

    public static final Block EDGEPINE_LEAVES = registerBlock("edgepine_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(OAK_LEAVES).strength(3f).sounds(BlockSoundGroup.AZALEA_LEAVES).nonOpaque()));

    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(AbstractBlock.Settings.create().strength(6f).sounds(BlockSoundGroup.CHAIN).requiresTool()));

    public static final Block BUDDING_ENDSTONE = registerBlock("budding_endstone",
            new Block(AbstractBlock.Settings.create().strength(6f).sounds(BlockSoundGroup.CHAIN).requiresTool()));

    public static final Block EDGEPINE_STAIRS = registerBlock("edgepine_stairs",
            new StairsBlock(ModBlocks.EDGEPINE_PLANKS.getDefaultState(), AbstractBlock.Settings.create().strength(1f)));

    public static final Block EDGEPINE_SLAB = registerBlock("edgepine_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1f)));

    public static final Block EDGEPINE_BUTTON = registerBlock("edgepine_button",
            new ButtonBlock(BlockSetType.BIRCH, 15, AbstractBlock.Settings.create().strength(1f).noCollision()));

    public static final Block EDGEPINE_PRESSURE_PLATE = registerBlock("edgepine_pressure_plate",
            new PressurePlateBlock(BlockSetType.BIRCH, AbstractBlock.Settings.create().strength(1f)));

    public static final Block EDGEPINE_FENCE = registerBlock("edgepine_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(1f)));

    public static final Block EDGEPINE_FENCE_GATE = registerBlock("edgepine_fence_gate",
            new FenceGateBlock(WoodType.BIRCH, AbstractBlock.Settings.create().strength(1f)));

    public static final Block EDGEPINE_DOOR = registerBlock("edgepine_door",
            new DoorBlock(BlockSetType.BIRCH, AbstractBlock.Settings.create().strength(1f).nonOpaque()));

    public static final Block EDGEPINE_TRAPDOOR = registerBlock("edgepine_trapdoor",
            new TrapdoorBlock(BlockSetType.BIRCH, AbstractBlock.Settings.create().strength(1f).nonOpaque()));

    public static final Block URANINITE_ORE = registerBlock("uraninite_ore",
           new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                   AbstractBlock.Settings.create().strength(7f).requiresTool()) );

    public static final Block FRANCIUM_ORE = registerBlock("francium_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 4),
                    AbstractBlock.Settings.create().strength(8f).requiresTool()) );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Radiend.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Radiend.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Radiend.LOGGER.info("blocks for the radiend");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PURPUR);
            entries.add(ModBlocks.LEAD_BLOCK);
            entries.add(ModBlocks.BUDDING_ENDSTONE);
            entries.add(ModBlocks.EDGEPINE_BUTTON);
            entries.add(ModBlocks.EDGEPINE_DOOR);
            entries.add(ModBlocks.EDGEPINE_PLANKS);
            entries.add(ModBlocks.EDGEPINE_FENCE);
            entries.add(ModBlocks.EDGEPINE_FENCE_GATE);
            entries.add(ModBlocks.EDGEPINE_PRESSURE_PLATE);
            entries.add(ModBlocks.EDGEPINE_STAIRS);
            entries.add(ModBlocks.EDGEPINE_TRAPDOOR);
            entries.add(ModBlocks.EDGEPINE_SLAB);
            entries.add(ModBlocks.GUILLOTINE_BLADE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(FRANCIUM_ORE);
            entries.add(URANINITE_ORE);
            entries.add(EDGEPINE_LOG);
            entries.add(EDGEPINE_WOOD);
            entries.add(STRIPPED_EDGEPINE_LOG);
            entries.add(STRIPPED_EDGEPINE_WOOD);
            entries.add(EDGEPINE_LEAVES);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(RADIUM_BLOCK);
        });
    }
}
