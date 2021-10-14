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
    public static final ResourceKey<Biome> CRUMBLY_CAVERNS = add("crumbly_caverns");
    public static final ResourceKey<Biome> LURKED_HYPOGEAL = add("lurked_hypogeal");

    @SuppressWarnings("deprecation")
    public static void init() {
        register(MAGMATIC_HOLLOWS, magmaticHollows(0.1f, 0.2f));
        register(CRUMBLY_CAVERNS, crumblyCaverns(0.1f, 0.2f));
        register(LURKED_HYPOGEAL, lurkedHypogeal(0.1f, 0.2f));


        OverworldBiomes.addContinentalBiome(MAGMATIC_HOLLOWS, OverworldClimate.DRY, 1.0);
        OverworldBiomes.addContinentalBiome(CRUMBLY_CAVERNS, OverworldClimate.COOL, 1.0);
        OverworldBiomes.addContinentalBiome(LURKED_HYPOGEAL, OverworldClimate.TEMPERATE, 1.0);
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
        BiomeDefaultFeatures.addGiantTaigaVegetation(builder2);
        BiomeDefaultFeatures.addSurfaceFreezing(builder2);
        CACBiomeFeatures.addMagmaticHollowsVegetation(builder2);
        CACBiomeFeatures.addPeridotGeode(builder2);
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
        return magmaticHollows();
    }

    public static Biome crumblyCaverns() {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(builder);
        net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder2 = (new net.minecraft.world.level.biome.BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRAVELLY_MOUNTAIN);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(builder2);
        builder2.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        BiomeDefaultFeatures.addDefaultCarvers(builder2);
        BiomeDefaultFeatures.addDefaultLakes(builder2);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder2);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder2);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder2);
        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);
        BiomeDefaultFeatures.addMountainTrees(builder2);
        BiomeDefaultFeatures.addSurfaceFreezing(builder2);
        CACBiomeFeatures.addCrumblyCavernsVegetation(builder2);
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
    private static Biome crumblyCaverns(float depth, float scale) {
        return crumblyCaverns();
    }

    public static Biome lurkedHypogeal() {
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(builder);
        net.minecraft.world.level.biome.BiomeGenerationSettings.Builder builder2 = (new net.minecraft.world.level.biome.BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.SWAMP);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(builder2);
        builder2.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        BiomeDefaultFeatures.addDefaultCarvers(builder2);
        BiomeDefaultFeatures.addDefaultLakes(builder2);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder2);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder2);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder2);
        BiomeDefaultFeatures.addDefaultOres(builder2);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder2);
        BiomeDefaultFeatures.addMountainTrees(builder2);
        BiomeDefaultFeatures.addSurfaceFreezing(builder2);
        CACBiomeFeatures.addCrumblyCavernsVegetation(builder2);
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
    private static Biome lurkedHypogeal(float depth, float scale) {
        return lurkedHypogeal();
    }

}
