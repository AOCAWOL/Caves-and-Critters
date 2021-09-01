package net.fabricmc.caveaoc.core.worldgen;

import com.mojang.serialization.Lifecycle;
import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.common.features.CACBiomeFeatures;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.mixin.biome.BuiltinBiomesAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class CACBiomes {
    public static final ResourceKey<Biome> MAGMATIC_HOLLOWS = add("magmatic_hollows");

    @SuppressWarnings("deprecation") // bad fabric api
    public static void init() {
        register(MAGMATIC_HOLLOWS, magmaticHollows(0.1f, 0.2f));
//        register(PINE_FOREST_HILLS, pineForest(0.45f, 0.3f));
//        register(PINE_FOREST_CLEARING, pineForestClearing(0.1f, 0.2f));
//        register(PINE_MIRE, pineMire(0f, -0.1f));
//        register(KETTLE_POND, kettlePond(-0.3f, 0f));
//        register(FELL, fell(0.85f, 0.3f));
//        register(FELL_EDGE, fellEdge(0.5f, 0.3f));
//
        OverworldBiomes.addContinentalBiome(MAGMATIC_HOLLOWS, OverworldClimate.COOL, 1.0);
//        OverworldBiomes.addHillsBiome(PINE_FOREST, PINE_FOREST_HILLS, 1.0);
//        OverworldBiomes.addBiomeVariant(PINE_FOREST, PINE_FOREST_HILLS, 0.3);
//        OverworldBiomes.addContinentalBiome(PINE_MIRE, OverworldClimate.TEMPERATE, 1.0);
//        OverworldBiomes.addContinentalBiome(FELL, OverworldClimate.COOL, 1.0);
//        OverworldBiomes.addHillsBiome(FELL, BiomeKeys.SNOWY_MOUNTAINS, 1.0);
//        OverworldBiomes.addEdgeBiome(FELL, FELL_EDGE, 1.0);
    }



    private static ResourceKey<Biome> add(String id) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, CavesAndCrittersMain.id(id));
    }

    private static void register(ResourceKey<Biome> add, Biome biome) {
        ((WritableRegistry<Biome>) BuiltinRegistries.BIOME).register(add, biome, Lifecycle.stable());

        // Ensures that the biome is stored in the internal raw ID map of BuiltinBiomes.
        // Fabric API usually does this, but some of my biomes don't go through OverworldBiomes at all,
        // which means that won't always get done.
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getId(biome), add);
    }

    private static int calculateSkyColor(float f) {
        float g = f / 3.0F;
        g = Mth.clamp(g, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }

    public static Biome magmaticHollows() {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(builder);
        net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder2 = (new net.minecraft.world.level.biome.BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GIANT_TREE_TAIGA);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(builder2);
        builder2.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        BiomeDefaultFeatures.addDefaultCarvers(builder2);
        BiomeDefaultFeatures.addDefaultLakes(builder2);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder2);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder2);
        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);
        BiomeDefaultFeatures.addDripstone(builder2);
        BiomeDefaultFeatures.addGiantTaigaVegetation(builder2);
        BiomeDefaultFeatures.addSurfaceFreezing(builder2);
        CACBiomeFeatures.addPeridotGeode(builder2);
        CACBiomeFeatures.addMagmaticSurfaceVegetation(builder2);
        return (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.UNDERGROUND)
                .depth(0.1F).scale(0.2F)
                .temperature(0.5F).downfall(0.5F)
                .specialEffects((new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .grassColorOverride(5406551)
                        .foliageColorOverride(6589494)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(0.5F))
                        .build()).mobSpawnSettings(builder.build()).generationSettings(builder2.build()).build();
    }

    private static Biome magmaticHollows(float depth, float scale) {
        // noinspection CodeBlock2Expr
        return magmaticHollows();
    }

}