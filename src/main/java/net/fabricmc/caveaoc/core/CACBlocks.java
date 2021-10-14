package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.common.properties.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
    public static final Block PERIDOT_CLUSTER = createPeridotClusterBlock(13,7,3, SoundType.AMETHYST_CLUSTER,"peridot_cluster");
    public static final Block LARGE_PERIDOT_BUD = createPeridotBudBlock(10,5,3, SoundType.LARGE_AMETHYST_BUD,"large_peridot_bud");
    public static final Block MEDIUM_PERIDOT_BUD = createPeridotBudBlock(8,4,3, SoundType.MEDIUM_AMETHYST_BUD,"medium_peridot_bud");
    public static final Block SMALL_PERIDOT_BUD = createPeridotBudBlock(5,3,4, SoundType.SMALL_AMETHYST_BUD,"small_peridot_bud");

    public static final Block PILLOW_LAVA = createPillowLavaBlock(8, SoundType.NETHERRACK,"pillow_lava");
    public static final Block RAW_PERIDOT_BLOCK = createPeridotBlock(5, SoundType.AMETHYST_CLUSTER,"raw_peridot_block");
    public static final Block RAW_BUDDING_PERIDOT_BLOCK = createBuddingPeridotBlock(5, SoundType.AMETHYST_CLUSTER,"raw_budding_peridot_block");
    public static final Block DEEP_CRUMBLY_STONE = createCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.DEEPSLATE,"deep_crumbly_stone");
    public static final Block MAGMATIC_VENT = createMagmaticVentBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.DEEPSLATE,"magmatic_vent");

    public static final Block CRUMBLY_STONE = createCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.STONE,"crumbly_stone");
    public static final Block ROOTED_CRUMBLY_STONE = createRootedCrumblyStoneBlock(SoundType.DRIPSTONE_BLOCK, MaterialColor.STONE,"rooted_crumbly_stone");
    public static final Block HANGING_CRUMBLY_ROOTS = createHangingCrumblyRootsBlock(SoundType.ROOTED_DIRT, MaterialColor.TERRACOTTA_GREEN,"hanging_crumbly_roots");
    public static final Block CRUMBLY_ROSE = createCrumblyRoseBlock(SoundType.GRASS, MaterialColor.TERRACOTTA_MAGENTA,"crumbly_rose");
    public static final Block PRIM_SPECTRAL_VINES = createPrimSpectralVinesBlock(10, SoundType.CAVE_VINES, MaterialColor.TERRACOTTA_WHITE,"prim_spectral_vines");
    public static final Block PRIM_SPECTRAL_VINES_PLANT = createPrimSpectralVinesPlantBlock(10, SoundType.CAVE_VINES, MaterialColor.TERRACOTTA_WHITE,"prim_spectral_vines_plant");

    public static final Block LURKWOOD_LOG = createLogBlock(MaterialColor.GRASS, MaterialColor.WOOD, SoundType.WOOD,"lurkwood_log");
    public static final Block LURKWOOD_WOOD = createLogBlock(MaterialColor.GRASS, MaterialColor.GRASS, SoundType.WOOD,"lurkwood_wood");
    public static final Block STRIPPED_LURKWOOD_LOG = createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, SoundType.WOOD,"stripped_lurkwood_log");
    public static final Block STRIPPED_LURKWOOD_WOOD = createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD, SoundType.WOOD,"stripped_lurkwood_wood");
    public static final Block LURKWOOD_PLANKS = createPlanksBlock(MaterialColor.WOOD, SoundType.WOOD,"lurkwood_planks");

    public static final Block LURKWOOD_SAPLING = createSaplingBlock(MaterialColor.PLANT, SoundType.AZALEA,"lurkwood_sapling");
    public static final Block LURKWOOD_LEAVES = createLeavesBlock(MaterialColor.TERRACOTTA_GREEN, SoundType.AZALEA_LEAVES,"lurkwood_leaves");

    //------------------------------------------------------------------------
    static Block createLogBlock(MaterialColor materialColor, MaterialColor materialColor2, SoundType sound, String id) {
        Block createBlock = new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (blockState) -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? materialColor : materialColor2).sound(sound).strength(2.0f));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPlanksBlock(MaterialColor materialColor, SoundType sound, String id) {
        Block createBlock = new Block(BlockBehaviour.Properties.of(Material.WOOD, materialColor).sound(sound).strength(2.0f,3.0f));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createSaplingBlock(MaterialColor materialColor, SoundType sound, String id) {
        Block createBlock = new FlowerBlock(MobEffects.MOVEMENT_SLOWDOWN, 5, BlockBehaviour.Properties.of(Material.PLANT, materialColor).sound(sound).noCollission().instabreak());
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createLeavesBlock(MaterialColor materialColor, SoundType sound, String id) {
        Block createBlock = new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, materialColor).sound(sound).randomTicks().noOcclusion().isValidSpawn(CACBlocks::ocelotOrParrot).isSuffocating(CACBlocks::never).isViewBlocking(CACBlocks::never));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }


    static Block createPeridotBudBlock(int light, int height, int xzOffset, SoundType sound, String id) {
        Block createBlock = new AmethystClusterBlock(height, xzOffset, BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).noOcclusion().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPeridotClusterBlock(int light, int height, int xzOffset, SoundType sound, String id) {
        Block createBlock = new PeridotClusterBlock(height, xzOffset, BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).noOcclusion().sound(sound).randomTicks().strength(1.5f).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPeridotBlock(int light, SoundType sound, String id) {
        Block createBlock = new AmethystBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.EMERALD).requiresCorrectToolForDrops().sound(sound).strength(1.5f).lightLevel((state) -> light));
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
        Block createBlock = new PillowLavaBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().sound(sound).strength(1.5f).lightLevel((state) -> light));
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
        Block createBlock = new MagmaticVentBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).strength(1.5f));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createHangingCrumblyRootsBlock(SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new HangingCrumblyRoots(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, materialColor).noCollission().instabreak().sound(sound));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createRootedCrumblyStoneBlock(SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new RootedCrumblyStoneBlock(BlockBehaviour.Properties.of(Material.STONE, materialColor).requiresCorrectToolForDrops().sound(sound).strength(1.5f));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createCrumblyRoseBlock(SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new CrumblyRoseBlock(MobEffects.REGENERATION, 5, BlockBehaviour.Properties.of(Material.PLANT, materialColor).noCollission().instabreak().sound(sound));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPrimSpectralVinesBlock(int light, SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new PrimSpectralVinesBlock(BlockBehaviour.Properties.of(Material.PLANT, materialColor).randomTicks().noCollission().instabreak().sound(sound).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createPrimSpectralVinesPlantBlock(int light, SoundType sound, MaterialColor materialColor, String id) {
        Block createBlock = new PrimSpectralVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, materialColor).randomTicks().noCollission().instabreak().sound(sound).lightLevel((state) -> light));
        Registry.register(Registry.BLOCK, new ResourceLocation(CavesAndCrittersMain.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }

    private static Boolean ocelotOrParrot(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    public static void init() {
    }



    public static class GrassPathBlockAccess extends DirtPathBlock {

        public GrassPathBlockAccess(Properties properties) {
            super(properties);
        }
    }
}
