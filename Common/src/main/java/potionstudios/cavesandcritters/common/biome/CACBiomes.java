package potionstudios.cavesandcritters.common.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.reg.RegistrationProvider;

import java.util.function.Supplier;

public class CACBiomes {
    public static final RegistrationProvider<Biome> PROVIDER = RegistrationProvider.get(BuiltinRegistries.BIOME, CavesAndCritters.MOD_ID);


    public static final ResourceKey<Biome> MAGMATIC_HOLLOWS = createBiome("magmatic_hollows", CACBiomeBuilders::magmaticHollows);
    public static final ResourceKey<Biome> CRUMBLY_CAVERNS = createBiome("crumbly_caverns", CACBiomeBuilders::crumblyCaverns);
    public static final ResourceKey<Biome> LURKED_HYPOGEAL = createBiome("lurked_hypogeal", CACBiomeBuilders::lurkedHypogeal);


    public static <B extends Biome> ResourceKey<Biome> createBiome(String id, Supplier<? extends B> biome) {
        ResourceLocation bygID = CavesAndCritters.createLocation(id);
        if (BuiltinRegistries.BIOME.keySet().contains(bygID)) {
            throw new IllegalStateException("Biome ID: \"" + bygID + "\" already exists in the Biome registry!");
        }
        PROVIDER.register(id, biome);
        return ResourceKey.create(Registry.BIOME_REGISTRY, bygID);
    }

    public static void bootstrap() {
    }
}
