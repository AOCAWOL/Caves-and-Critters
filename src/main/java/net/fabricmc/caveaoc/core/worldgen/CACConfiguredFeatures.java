package net.fabricmc.caveaoc.core.worldgen;

import com.google.common.collect.ImmutableList;
import net.fabricmc.caveaoc.core.CACBlockTags;
import net.fabricmc.caveaoc.core.CACBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;

public class CACConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> PERIDOT_GEODE;
    public static final ConfiguredFeature<?, ?> MOSS_VEGETATION_SURFACE;
    public static final ConfiguredFeature<?, ?> AZALEA_TREE_SURFACE;
    public static final ConfiguredFeature<?, ?> DEEP_CRUMBLY_STONE;
    public static final ConfiguredFeature<?, ?> PILLOW_LAVA_PATCH;
    public static final ConfiguredFeature<?, ?> MAGMATIC_HOLLOWS_VEGETATION;
    public static final ConfiguredFeature<?, ?> MAGMATIC_VENTS;
    public static final ConfiguredFeature<?, ?> PERIDOT_PATCH_CEILING;
    public static final ConfiguredFeature<?, ?> MAGMATIC_HOLLOWS_CEILING_VEGETATION;
    public static final ConfiguredFeature<?, ?> PERIDOT;

    public static final ConfiguredFeature<?, ?> CRUMBLY_VEGETATION;
    public static final ConfiguredFeature<?, ?> CRUMBLY_PATCH;
    public static final ConfiguredFeature<?, ?> CRUMBLY_CAVERNS_VEGETATION;
    public static final ConfiguredFeature<?, ?> CRUMBLY_PATCH_CEILING;
    public static final ConfiguredFeature<?, ?> CRUMBLY_CAVERNS_CEILING_VEGETATION;
    public static final ConfiguredFeature<?, ?> CRUMBLY_CEILING_VEGETATION;

    public static void init() {

    }

    public CACConfiguredFeatures() {
    }

    static SimpleWeightedRandomList.Builder<BlockState> weightedBlockStateBuilder() {
        return SimpleWeightedRandomList.builder();
    }

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String string, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, string, configuredFeature);
    }

    static {

        AZALEA_TREE_SURFACE = register("azalea_tree_surface", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(Features.AZALEA_TREE.weighted(0.025641026F), Features.AZALEA_TREE.weighted(0.30769232F), Features.PINE.weighted(0.33333334F)), Features.SPRUCE)).decorated(CACConfiguredFeatures.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.1F, 1))));
        PERIDOT_GEODE = register("peridot_geode", (ConfiguredFeature<FeatureConfiguration, Feature<FeatureConfiguration>>) ((ConfiguredFeature) ((ConfiguredFeature) Feature.GEODE.configured(new GeodeConfiguration(new GeodeBlockSettings(new SimpleStateProvider(Blocks.AIR.defaultBlockState()), new SimpleStateProvider(CACBlocks.RAW_PERIDOT_BLOCK.defaultBlockState()), new SimpleStateProvider(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK.defaultBlockState()), new SimpleStateProvider(Blocks.CALCITE.defaultBlockState()), new SimpleStateProvider(Blocks.SMOOTH_BASALT.defaultBlockState()), ImmutableList.of(CACBlocks.SMALL_PERIDOT_BUD.defaultBlockState(), CACBlocks.MEDIUM_PERIDOT_BUD.defaultBlockState(), CACBlocks.LARGE_PERIDOT_BUD.defaultBlockState(), CACBlocks.PERIDOT_CLUSTER.defaultBlockState()), BlockTags.FEATURES_CANNOT_REPLACE.getName(), BlockTags.GEODE_INVALID_BLOCKS.getName()), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D), new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true, UniformInt.of(4, 6), UniformInt.of(3, 4), UniformInt.of(1, 2), -16, 16, 0.05D, 1)).rangeUniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(46))).squared()).rarity(15));
        MOSS_VEGETATION_SURFACE = register("moss_vegetation_surface", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(new WeightedStateProvider(weightedBlockStateBuilder().add(Blocks.FLOWERING_AZALEA.defaultBlockState(), 4).add(Blocks.AZALEA.defaultBlockState(), 7).add(Blocks.MOSS_CARPET.defaultBlockState(), 25).add(Blocks.GRASS.defaultBlockState(), 50).add(Blocks.TALL_GRASS.defaultBlockState(), 10)))));

        PERIDOT = register("peridot", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.PERIDOT_CLUSTER.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 2).add(CACBlocks.SMALL_PERIDOT_BUD.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 15).add(CACBlocks.MEDIUM_PERIDOT_BUD.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 25).add(CACBlocks.LARGE_PERIDOT_BUD.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 50).add(Blocks.CAVE_AIR.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 10)))));
        DEEP_CRUMBLY_STONE = register("crumbly_stone", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, CACBlocks.DEEP_CRUMBLY_STONE.defaultBlockState(), 64)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(16))).squared()).count(2));
        MAGMATIC_VENTS = register("magmatic_vents", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.MAGMATIC_VENT.defaultBlockState(), 3).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(CACBlocks.MAGMATIC_VENT.defaultBlockState(), 3)))));
        PILLOW_LAVA_PATCH = register("pillow_lava_patch", Feature.VEGETATION_PATCH.configured(new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE.getName(), (new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.PILLOW_LAVA.defaultBlockState(), 5).add(CACBlocks.DEEP_CRUMBLY_STONE.defaultBlockState(), 4).add(Blocks.DEEPSLATE.defaultBlockState(), 15))), () -> MAGMATIC_VENTS, CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F)));
        MAGMATIC_HOLLOWS_VEGETATION = register("magmatic_hollows_vegetation", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)PILLOW_LAVA_PATCH.decorated(FeatureDecorator.CAVE_SURFACE.configured(new CaveDecoratorConfiguration(CaveSurface.FLOOR, 12))).range(CACConfiguredFeatures.Decorators.RANGE_BOTTOM_TO_60)).squared()).count(40));
        PERIDOT_PATCH_CEILING = register("peridot_patch_ceiling", Feature.VEGETATION_PATCH.configured(new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE.getName(), (new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.RAW_PERIDOT_BLOCK.defaultBlockState(), 5).add(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK.defaultBlockState(), 1).add(Blocks.DEEPSLATE.defaultBlockState(), 50))), () -> CACConfiguredFeatures.PERIDOT, CaveSurface.CEILING, UniformInt.of(1, 2), 0.0F, 5, 0.08F, UniformInt.of(4, 7), 0.3F)));
        MAGMATIC_HOLLOWS_CEILING_VEGETATION = register("magmatic_hollows_ceiling_vegetation", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)PERIDOT_PATCH_CEILING.decorated(FeatureDecorator.CAVE_SURFACE.configured(new CaveDecoratorConfiguration(CaveSurface.CEILING, 12))).range(CACConfiguredFeatures.Decorators.RANGE_BOTTOM_TO_60)).squared()).count(40));

        CRUMBLY_VEGETATION = register("crumbly_vegetation", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.CRUMBLY_ROSE.defaultBlockState(), 1).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(Blocks.MOSS_CARPET.defaultBlockState(), 25)))));
        CRUMBLY_PATCH = register("crumbly_patch", Feature.VEGETATION_PATCH.configured(new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE.getName(), (new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.CRUMBLY_STONE.defaultBlockState(), 2).add(Blocks.MOSS_BLOCK.defaultBlockState(), 5).add(CACBlocks.ROOTED_CRUMBLY_STONE.defaultBlockState(), 50))), () -> CRUMBLY_VEGETATION, CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F)));
        CRUMBLY_CAVERNS_VEGETATION = register("crumbly_caverns_vegetation", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)CRUMBLY_PATCH.decorated(FeatureDecorator.CAVE_SURFACE.configured(new CaveDecoratorConfiguration(CaveSurface.FLOOR, 12))).range(CACConfiguredFeatures.Decorators.RANGE_BOTTOM_TO_60)).squared()).count(40));

        CRUMBLY_CEILING_VEGETATION = register("crumbly_ceiling_vegetation", Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(new WeightedStateProvider(weightedBlockStateBuilder().add(Blocks.CAVE_AIR.defaultBlockState(), 45).add(CACBlocks.HANGING_CRUMBLY_ROOTS.defaultBlockState(), 25).add(CACBlocks.PRIM_SPECTRAL_VINES.defaultBlockState(), 35)))));
        CRUMBLY_PATCH_CEILING = register("crumbly_patch_ceiling", Feature.VEGETATION_PATCH.configured(new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE.getName(), (new WeightedStateProvider(weightedBlockStateBuilder().add(CACBlocks.CRUMBLY_STONE.defaultBlockState(), 2).add(Blocks.MOSS_BLOCK.defaultBlockState(), 5).add(CACBlocks.ROOTED_CRUMBLY_STONE.defaultBlockState(), 50))), () -> CRUMBLY_CEILING_VEGETATION, CaveSurface.CEILING, UniformInt.of(1, 2), 0.0F, 5, 0.08F, UniformInt.of(4, 7), 0.3F)));
        CRUMBLY_CAVERNS_CEILING_VEGETATION = register("crumbly_caverns_ceiling_vegetation", (ConfiguredFeature)((ConfiguredFeature)((ConfiguredFeature)CRUMBLY_PATCH_CEILING.decorated(FeatureDecorator.CAVE_SURFACE.configured(new CaveDecoratorConfiguration(CaveSurface.CEILING, 12))).range(CACConfiguredFeatures.Decorators.RANGE_BOTTOM_TO_60)).squared()).count(40));

    }


    protected static final class Decorators {
        public static final ConfiguredDecorator<HeightmapConfiguration> HEIGHTMAP;
        public static final ConfiguredDecorator<HeightmapConfiguration> HEIGHTMAP_TOP_SOLID;
        public static final ConfiguredDecorator<HeightmapConfiguration> HEIGHTMAP_WORLD_SURFACE;
        public static final ConfiguredDecorator<HeightmapConfiguration> HEIGHTMAP_OCEAN_FLOOR;
        public static final ConfiguredDecorator<HeightmapConfiguration> HEIGHTMAP_DOUBLE;
        public static final RangeDecoratorConfiguration FULL_RANGE;
        public static final RangeDecoratorConfiguration RANGE_10_10;
        public static final RangeDecoratorConfiguration RANGE_8_8;
        public static final RangeDecoratorConfiguration RANGE_4_4;
        public static final RangeDecoratorConfiguration RANGE_BOTTOM_TO_60;
        public static final ConfiguredDecorator<?> FIRE;
        public static final ConfiguredDecorator<?> ADD_32;
        public static final ConfiguredDecorator<?> HEIGHTMAP_WITH_TREE_THRESHOLD;
        public static final ConfiguredDecorator<?> HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED;
        public static final ConfiguredDecorator<?> HEIGHTMAP_SQUARE;
        public static final ConfiguredDecorator<?> HEIGHTMAP_DOUBLE_SQUARE;
        public static final ConfiguredDecorator<?> TOP_SOLID_HEIGHTMAP_SQUARE;
        public static final ConfiguredDecorator<?> DARK_OAK_DECORATOR;

        protected Decorators() {
        }

        static {
            HEIGHTMAP = FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING));
            HEIGHTMAP_TOP_SOLID = FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.OCEAN_FLOOR_WG));
            HEIGHTMAP_WORLD_SURFACE = FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.WORLD_SURFACE_WG));
            HEIGHTMAP_OCEAN_FLOOR = FeatureDecorator.HEIGHTMAP.configured(new HeightmapConfiguration(Heightmap.Types.OCEAN_FLOOR));
            HEIGHTMAP_DOUBLE = FeatureDecorator.HEIGHTMAP_SPREAD_DOUBLE.configured(new HeightmapConfiguration(Heightmap.Types.MOTION_BLOCKING));
            FULL_RANGE = new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.top()));
            RANGE_10_10 = new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10)));
            RANGE_8_8 = new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(8), VerticalAnchor.belowTop(8)));
            RANGE_4_4 = new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.aboveBottom(4), VerticalAnchor.belowTop(4)));
            RANGE_BOTTOM_TO_60 = new RangeDecoratorConfiguration(UniformHeight.of(VerticalAnchor.bottom(), VerticalAnchor.absolute(60)));
            FIRE = (ConfiguredDecorator) ((ConfiguredDecorator) FeatureDecorator.RANGE.configured(RANGE_4_4).squared()).countRandom(5);
            ADD_32 = FeatureDecorator.SPREAD_32_ABOVE.configured(NoneDecoratorConfiguration.INSTANCE);
            HEIGHTMAP_WITH_TREE_THRESHOLD = HEIGHTMAP_OCEAN_FLOOR.decorated(FeatureDecorator.WATER_DEPTH_THRESHOLD.configured(new WaterDepthThresholdConfiguration(0)));
            HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED = HEIGHTMAP_WITH_TREE_THRESHOLD.squared();
            HEIGHTMAP_SQUARE = HEIGHTMAP.squared();
            HEIGHTMAP_DOUBLE_SQUARE = HEIGHTMAP_DOUBLE.squared();
            TOP_SOLID_HEIGHTMAP_SQUARE = HEIGHTMAP_TOP_SOLID.squared();
            DARK_OAK_DECORATOR = HEIGHTMAP_WITH_TREE_THRESHOLD.decorated(FeatureDecorator.DARK_OAK_TREE.configured(DecoratorConfiguration.NONE));
        }


    }
}
