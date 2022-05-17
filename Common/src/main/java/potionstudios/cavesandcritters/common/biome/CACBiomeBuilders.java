package potionstudios.cavesandcritters.common.biome;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import potionstudios.cavesandcritters.common.features.CACDefaultBiomeFeatures;

import static potionstudios.cavesandcritters.mixin.access.OverworldBiomesAccess.cac_invokeCalculateSkyColor;

public class CACBiomeBuilders {

    public static Biome magmaticHollows() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addGiantTaigaVegetation(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
        CACDefaultBiomeFeatures.addMagmaticHollowsVegetation(generationSettings);
        CACDefaultBiomeFeatures.addPeridotGeode(generationSettings);
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.UNDERGROUND)
                .temperature(0.5F).downfall(0.5F)
                .specialEffects((new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .grassColorOverride(5406551)
                        .foliageColorOverride(6589494)
                        .fogColor(12638463)
                        .skyColor(cac_invokeCalculateSkyColor(0.5F))
                        .build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome crumblyCaverns() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addMountainTrees(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
        CACDefaultBiomeFeatures.addCrumblyCavernsVegetation(generationSettings);
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.UNDERGROUND)
                .temperature(0.5F).downfall(0.5F)
                .specialEffects((new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .grassColorOverride(5406551)
                        .foliageColorOverride(6589494)
                        .fogColor(12638463)
                        .skyColor(cac_invokeCalculateSkyColor(0.5F))
                        .build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

    public static Biome lurkedHypogeal() {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);

        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addMountainTrees(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
        CACDefaultBiomeFeatures.addCrumblyCavernsVegetation(generationSettings);
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.UNDERGROUND)
                .temperature(0.5F).downfall(0.5F)
                .specialEffects((new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .grassColorOverride(5406551)
                        .foliageColorOverride(6589494)
                        .fogColor(12638463)
                        .skyColor(cac_invokeCalculateSkyColor(0.5F))
                        .build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

}
