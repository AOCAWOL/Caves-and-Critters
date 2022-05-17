package potionstudios.cavesandcritters.common.features;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import static potionstudios.cavesandcritters.mixin.access.OrePlacementsAccess.cac_invokeCommonOrePlacement;

public class CACPlacedFeatures {

    private static final PlacementModifier[] CAVE_FLOOR = new PlacementModifier[]{CountPlacement.of(125), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome()};
    private static final PlacementModifier[] CAVE_CEILING = new PlacementModifier[]{CountPlacement.of(125), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()};

    public static final Holder<PlacedFeature> AZALEA_TREE_SURFACE = CACPlacedFeaturesUtil.createPlacedFeature("azalea_tree_surface", CACConfiguredFeatures.AZALEA_TREE_SURFACE, PlacementUtils.countExtra(1, 0.25F, 2));
    public static final Holder<PlacedFeature> PILLOW_LAVA_PATCH = CACPlacedFeaturesUtil.createPlacedFeature("pillow_lava_patch", CACConfiguredFeatures.PILLOW_LAVA_PATCH, CAVE_FLOOR);
    public static final Holder<PlacedFeature> PERIDOT_PATCH_CEILING = CACPlacedFeaturesUtil.createPlacedFeature("peridot_patch_ceiling", CACConfiguredFeatures.PERIDOT_PATCH_CEILING, CAVE_CEILING);
    public static final Holder<PlacedFeature> CRUMBLY_PATCH = CACPlacedFeaturesUtil.createPlacedFeature("crumbly_patch", CACConfiguredFeatures.CRUMBLY_PATCH, CAVE_FLOOR);
    public static final Holder<PlacedFeature> CRUMBLY_PATCH_CEILING = CACPlacedFeaturesUtil.createPlacedFeature("crumbly_patch_ceiling", CACConfiguredFeatures.CRUMBLY_PATCH_CEILING, CAVE_CEILING);
    public static final Holder<PlacedFeature> DEEP_CRUMBLY_STONE = CACPlacedFeaturesUtil.createPlacedFeature("deep_crumbly_stone", CACConfiguredFeatures.CRUMBLY_STONE, cac_invokeCommonOrePlacement(40, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(16))));

    public static final Holder<PlacedFeature> PERIDOT_GEODE = CACPlacedFeaturesUtil.createPlacedFeature("peridot_geode", CACConfiguredFeatures.PERIDOT_GEODE, cac_invokeCommonOrePlacement(15, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));

    public static void bootstrap() {
    }
}
