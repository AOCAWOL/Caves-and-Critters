package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.common.properties.blocks.BuddingPeridotBlock;
import net.fabricmc.caveaoc.common.properties.blocks.CrumblyBlock;
import net.fabricmc.caveaoc.common.properties.blocks.MagmaticVentBlock;
import net.fabricmc.caveaoc.common.properties.blocks.PillowLavaBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.intellij.lang.annotations.Identifier;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@SuppressWarnings("deprecation")
public class CACBlocks {
    public static List<Block> blocksList = new ArrayList<>();
    public static List<Block> flowerPotBlocks = new ArrayList<>();
    public static List<ResourceLocation> flowerIDs = new ArrayList<>();
    //------------------------------------------------------------------------
    public static final Block PERIDOT_CLUSTER = createPeridotCrystal(13,7,3, SoundType.AMETHYST_CLUSTER,"peridot_cluster");
    public static final Block LARGE_PERIDOT_BUD = createPeridotCrystal(10,5,3, SoundType.LARGE_AMETHYST_BUD,"large_peridot_bud");
    public static final Block MEDIUM_PERIDOT_BUD = createPeridotCrystal(8,4,3, SoundType.MEDIUM_AMETHYST_BUD,"medium_peridot_bud");
    public static final Block SMALL_PERIDOT_BUD = createPeridotCrystal(5,3,4, SoundType.SMALL_AMETHYST_BUD,"small_peridot_bud");

    public static final Block PILLOW_LAVA = createPillowLavaBlock(8, SoundType.NETHERRACK,"pillow_lava");
    public static final Block RAW_PERIDOT_BLOCK = createPeridotBlock(5, SoundType.AMETHYST_CLUSTER,"raw_peridot_block");
    public static final Block RAW_BUDDING_PERIDOT_BLOCK = createBuddingPeridotBlock(5, SoundType.AMETHYST_CLUSTER,"raw_budding_peridot_block");
    public static final Block CRUMBLY_STONE = createCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.STONE,"crumbly_stone");
    public static final Block DEEP_CRUMBLY_STONE = createCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.DEEPSLATE,"deep_crumbly_stone");
    public static final Block MAGMATIC_VENT = createMagmaticVentBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.DEEPSLATE,"magmatic_vent");

    //------------------------------------------------------------------------
    static Block createPeridotCrystal(int light, int height, int xzOffset, SoundType sound, String id) {
        Block createBlock = new AmethystClusterBlock(height, xzOffset, BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).noOcclusion().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPeridotBlock(int light, SoundType sound, String id) {
        Block createBlock = new AmethystBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).requiresCorrectToolForDrops().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createBuddingPeridotBlock(int light, SoundType sound, String id) {
        Block createBlock = new BuddingPeridotBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).requiresCorrectToolForDrops().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPillowLavaBlock(int light, SoundType sound, String id) {
        Block createBlock = new PillowLavaBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createCrumblyStoneBlock(SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new CrumblyBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).strength(1.5f));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createMagmaticVentBlock(SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new MagmaticVentBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).randomTicks().strength(1.5f));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    public static void init() {
    }

    public static class GrassPathBlockAccess extends DirtPathBlock {

        public GrassPathBlockAccess(Properties properties) {
            super(properties);
        }
    }
}
