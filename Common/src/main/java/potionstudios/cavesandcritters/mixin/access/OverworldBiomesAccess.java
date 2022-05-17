package potionstudios.cavesandcritters.mixin.access;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomes.class)
public interface OverworldBiomesAccess {

    @Invoker("globalOverworldGeneration")
    static void cac_invokeGlobalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("calculateSkyColor")
    static int cac_invokeCalculateSkyColor(float f) {
        throw new Error("Mixin did not apply!");
    }
}
