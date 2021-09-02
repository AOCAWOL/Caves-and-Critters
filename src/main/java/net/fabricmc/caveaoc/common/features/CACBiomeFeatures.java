package net.fabricmc.caveaoc.common.features;

import net.fabricmc.caveaoc.core.worldgen.CACConfiguredFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CACBiomeFeatures {
    public static void addPeridotGeode(BiomeGenerationSettings.Builder gen) {
        gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, CACConfiguredFeatures.PERIDOT_GEODE);
    }

    public static void addMagmaticHollowsVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACConfiguredFeatures.AZALEA_TREE_SURFACE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACConfiguredFeatures.MAGMATIC_HOLLOWS_VEGETATION);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACConfiguredFeatures.DEEP_CRUMBLY_STONE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACConfiguredFeatures.MAGMATIC_HOLLOWS_CEILING_VEGETATION);
    }

    public static void addCrumblyCavernsVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACConfiguredFeatures.CRUMBLY_CAVERNS_VEGETATION);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CACConfiguredFeatures.CRUMBLY_CAVERNS_CEILING_VEGETATION);
    }
}
