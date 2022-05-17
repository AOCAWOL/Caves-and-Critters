package potionstudios.cavesandcritters.common.features;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.reg.RegistrationProvider;

import java.util.List;

public class CACPlacedFeaturesUtil {

    public static final RegistrationProvider<PlacedFeature> PROVIDER = RegistrationProvider.get(BuiltinRegistries.PLACED_FEATURE, CavesAndCritters.MOD_ID);

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        return createPlacedFeature(id, feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(String id, Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        ResourceLocation resourceLocation = CavesAndCritters.createLocation(id);
        if (BuiltinRegistries.PLACED_FEATURE.keySet().contains(resourceLocation)) {
            throw new IllegalStateException("Placed Feature ID: \"" + resourceLocation.toString() + "\" already exists in the Placed Features registry!");
        }
        return PROVIDER.register(id, () -> new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers))).asHolder();
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(Holder<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
        return createPlacedFeature(feature, List.of(placementModifiers));
    }

    public static <FC extends FeatureConfiguration> Holder<PlacedFeature> createPlacedFeature(Holder<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
        return Holder.direct(new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placementModifiers)));
    }
}
