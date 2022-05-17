package potionstudios.cavesandcritters.terrablender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.common.biome.CACBiomes;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class CavesAndCrittersRegion extends Region {
    private static int count = 0;

    public CavesAndCrittersRegion() {
        super(CavesAndCritters.createLocation("region_" + count++), RegionType.OVERWORLD, 10);
    }


    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, modifiedVanillaOverworldBuilder -> {
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.LUSH_CAVES, CACBiomes.CRUMBLY_CAVERNS);
            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.DRIPSTONE_CAVES, CACBiomes.MAGMATIC_HOLLOWS);
        });
        super.addBiomes(registry, mapper);
    }
}
