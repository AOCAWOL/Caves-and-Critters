package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.common.properties.blocks.BuddingPeridotBlock;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("deprecation")
public class CACBlocks {
    public static List<Block> blocksList = new ArrayList<>();
    public static List<Block> flowerPotBlocks = new ArrayList<>();
    public static List<Identifier> flowerIDs = new ArrayList<>();
    //------------------------------------------------------------------------
    public static final Block PERIDOT_CLUSTER = createPeridotCrystal(13,7,3, BlockSoundGroup.AMETHYST_CLUSTER,"peridot_cluster");
    public static final Block LARGE_PERIDOT_BUD = createPeridotCrystal(10,5,3, BlockSoundGroup.LARGE_AMETHYST_BUD,"large_peridot_bud");
    public static final Block MEDIUM_PERIDOT_BUD = createPeridotCrystal(8,4,3, BlockSoundGroup.MEDIUM_AMETHYST_BUD,"medium_peridot_bud");
    public static final Block SMALL_PERIDOT_BUD = createPeridotCrystal(5,3,4, BlockSoundGroup.SMALL_AMETHYST_BUD,"small_peridot_bud");

    public static final Block RAW_PERIDOT_BLOCK = createPeridotBlock(5, BlockSoundGroup.AMETHYST_CLUSTER,"raw_peridot_block");
    public static final Block RAW_BUDDING_PERIDOT_BLOCK = createBuddingPeridotBlock(5, BlockSoundGroup.AMETHYST_CLUSTER,"raw_budding_peridot_block");

    //------------------------------------------------------------------------
    static Block createPeridotCrystal(int light, int height, int xzOffset, BlockSoundGroup sound, String id) {
        Block createBlock = new AmethystClusterBlock(height, xzOffset, AbstractBlock.Settings.of(Material.AMETHYST, MapColor.EMERALD_GREEN).requiresTool().nonOpaque().sounds(sound).ticksRandomly().strength(1.5f).luminance((state) -> light));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createPeridotBlock(int light, BlockSoundGroup sound, String id) {
        Block createBlock = new AmethystBlock(AbstractBlock.Settings.of(Material.AMETHYST, MapColor.EMERALD_GREEN).requiresTool().sounds(sound).ticksRandomly().strength(1.5f).luminance((state) -> light));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createBuddingPeridotBlock(int light, BlockSoundGroup sound, String id) {
        Block createBlock = new BuddingPeridotBlock(AbstractBlock.Settings.of(Material.AMETHYST, MapColor.EMERALD_GREEN).requiresTool().sounds(sound).ticksRandomly().strength(1.5f).luminance((state) -> light));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createBlock(Block block, String id) {
        Registry.register(Registry.BLOCK, new Identifier(CavesAndCrittersMain.MOD_ID, id), block);
        blocksList.add(block);
        return block;
    }

    public static void init() {
    }

    public static class GrassPathBlockAccess extends DirtPathBlock {

        public GrassPathBlockAccess(Settings settings) {
            super(settings);
        }
    }
}
