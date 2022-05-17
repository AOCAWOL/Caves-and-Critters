package potionstudios.cavesandcritters.common.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.common.blocks.CACBlocks;
import potionstudios.cavesandcritters.reg.RegistrationProvider;

import java.util.function.Supplier;

import static potionstudios.cavesandcritters.common.features.CACPlacedFeaturesUtil.createPlacedFeature;

public class CACConfiguredFeatures {

    public static final RegistrationProvider<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = RegistrationProvider.get(BuiltinRegistries.CONFIGURED_FEATURE, CavesAndCritters.MOD_ID);

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> PERIDOT_GEODE = createConfiguredFeature("peridot_geode", () -> Feature.GEODE,
            new GeodeConfiguration(
                    new GeodeBlockSettings(
                            BlockStateProvider.simple(Blocks.AIR.defaultBlockState()),
                            BlockStateProvider.simple(CACBlocks.RAW_PERIDOT_BLOCK.defaultBlockState()),
                            BlockStateProvider.simple(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK.defaultBlockState()),
                            BlockStateProvider.simple(Blocks.CALCITE.defaultBlockState()),
                            BlockStateProvider.simple(Blocks.SMOOTH_BASALT.defaultBlockState()),
                            ImmutableList.of(
                                    CACBlocks.SMALL_PERIDOT_BUD.defaultBlockState(),
                                    CACBlocks.MEDIUM_PERIDOT_BUD.defaultBlockState(),
                                    CACBlocks.LARGE_PERIDOT_BUD.defaultBlockState(),
                                    CACBlocks.PERIDOT_CLUSTER.defaultBlockState()
                            ),
                            BlockTags.FEATURES_CANNOT_REPLACE,
                            BlockTags.GEODE_INVALID_BLOCKS
                    ), new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                    new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                    0.083D, true,
                    UniformInt.of(4, 6),
                    UniformInt.of(3, 4),
                    UniformInt.of(1, 2),
                    -16, 16, 0.05D, 1)
    );


    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> MOSS_VEGETATION_SURFACE = createConfiguredFeature("moss_vegetation_surface", () -> Feature.SIMPLE_BLOCK,
            new SimpleBlockConfiguration(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(Blocks.FLOWERING_AZALEA.defaultBlockState(), 4)
                            .add(Blocks.AZALEA.defaultBlockState(), 7)
                            .add(Blocks.MOSS_CARPET.defaultBlockState(), 25)
                            .add(Blocks.GRASS.defaultBlockState(), 50)
                            .add(Blocks.TALL_GRASS.defaultBlockState(), 10)
                            .build())));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> AZALEA_TREE_SURFACE = createConfiguredFeature("azalea_tree_surface", () -> Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(createPlacedFeature(TreeFeatures.AZALEA_TREE), 0.333F), new WeightedPlacedFeature(createPlacedFeature(TreeFeatures.PINE), 0.333F)), createPlacedFeature(TreeFeatures.PINE)));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CRUMBLY_STONE = createConfiguredFeature("crumbly_stone", () -> Feature.ORE, new OreConfiguration(new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD), CACBlocks.DEEP_CRUMBLY_STONE.defaultBlockState(), 64));

    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> MAGMATIC_VENTS = createConfiguredFeature("magmatic_vents", () -> Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.MAGMATIC_VENT.defaultBlockState(), 3).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(CACBlocks.MAGMATIC_VENT.defaultBlockState(), 3).build())));

    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> PILLOW_LAVA_PATCH = createConfiguredFeature("pillow_lava_patch", () -> Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.PILLOW_LAVA.defaultBlockState(), 5).add(CACBlocks.DEEP_CRUMBLY_STONE.defaultBlockState(), 4).add(Blocks.DEEPSLATE.defaultBlockState(), 15).build()), createPlacedFeature(MAGMATIC_VENTS), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> PERIDOT = createConfiguredFeature("peridot", () -> Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.PERIDOT_CLUSTER.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 2).add(CACBlocks.SMALL_PERIDOT_BUD.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 15).add(CACBlocks.MEDIUM_PERIDOT_BUD.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 25).add(CACBlocks.LARGE_PERIDOT_BUD.defaultBlockState().setValue(AmethystClusterBlock.FACING, Direction.DOWN), 50).add(Blocks.CAVE_AIR.defaultBlockState(), 10).build())));

    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> PERIDOT_PATCH_CEILING = createConfiguredFeature("peridot_patch_ceiling", () -> Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.RAW_PERIDOT_BLOCK.defaultBlockState(), 5).add(CACBlocks.RAW_BUDDING_PERIDOT_BLOCK.defaultBlockState(), 1).add(Blocks.DEEPSLATE.defaultBlockState(), 50).build()), createPlacedFeature(PERIDOT), CaveSurface.CEILING, UniformInt.of(1, 2), 0.0F, 5, 0.08F, UniformInt.of(4, 7), 0.3F));
    ;
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRUMBLY_VEGETATION = createConfiguredFeature("crumbly_vegetation", () -> Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.CRUMBLY_ROSE.defaultBlockState(), 1).add(Blocks.CAVE_AIR.defaultBlockState(), 50).add(Blocks.MOSS_CARPET.defaultBlockState(), 25).build())));
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> CRUMBLY_PATCH = createConfiguredFeature("crumbly_patch", () -> Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.CRUMBLY_STONE.defaultBlockState(), 2).add(Blocks.MOSS_BLOCK.defaultBlockState(), 5).add(CACBlocks.ROOTED_CRUMBLY_STONE.defaultBlockState(), 50).build()), createPlacedFeature(CRUMBLY_VEGETATION), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> CRUMBLY_CEILING_VEGETATION = createConfiguredFeature("crumbly_ceiling_vegetation", () -> Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(Blocks.CAVE_AIR.defaultBlockState(), 45).add(CACBlocks.HANGING_CRUMBLY_ROOTS.defaultBlockState(), 25).add(CACBlocks.PRIM_SPECTRAL_VINES.defaultBlockState(), 35).build())));

    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> CRUMBLY_PATCH_CEILING = createConfiguredFeature("crumbly_patch_ceiling", () -> Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, (new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(CACBlocks.CRUMBLY_STONE.defaultBlockState(), 2).add(Blocks.MOSS_BLOCK.defaultBlockState(), 5).add(CACBlocks.ROOTED_CRUMBLY_STONE.defaultBlockState(), 50))), createPlacedFeature(CRUMBLY_CEILING_VEGETATION), CaveSurface.CEILING, UniformInt.of(1, 2), 0.0F, 5, 0.08F, UniformInt.of(4, 7), 0.3F));

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(String id, Supplier<? extends F> feature, FC config) {
        return CONFIGURED_FEATURES.<ConfiguredFeature<FC, ?>>register(id, () -> new ConfiguredFeature<>(feature.get(), config)).asHolder();
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeatureSupplierConfig(String id, Supplier<? extends F> feature, Supplier<? extends FC> config) {
        return CONFIGURED_FEATURES.<ConfiguredFeature<FC, ?>>register(id, () -> new ConfiguredFeature<>(feature.get(), config.get())).asHolder();
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(F feature, FC config) {
        return Holder.direct(new ConfiguredFeature<>(feature, config));
    }

    public static void bootstrap() {
    }
}
