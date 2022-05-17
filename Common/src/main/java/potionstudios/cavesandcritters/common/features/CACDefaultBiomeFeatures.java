package potionstudios.cavesandcritters.common.features;

import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CACDefaultBiomeFeatures {
    public static void addPeridotGeode(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CACPlacedFeatures.PERIDOT_GEODE);
    }

    public static void addMagmaticHollowsVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACPlacedFeatures.AZALEA_TREE_SURFACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACPlacedFeatures.PILLOW_LAVA_PATCH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACPlacedFeatures.DEEP_CRUMBLY_STONE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACPlacedFeatures.PERIDOT_PATCH_CEILING);
    }

    public static void addCrumblyCavernsVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACPlacedFeatures.CRUMBLY_PATCH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACPlacedFeatures.CRUMBLY_PATCH_CEILING);
    }
}
