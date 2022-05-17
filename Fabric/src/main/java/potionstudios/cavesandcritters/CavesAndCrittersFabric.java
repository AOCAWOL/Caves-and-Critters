package potionstudios.cavesandcritters;

import net.fabricmc.api.ModInitializer;
import potionstudios.cavesandcritters.core.CACRegistries;

import java.util.Objects;

public class CavesAndCrittersFabric implements ModInitializer {

    private static String firstInitialized = null;

    @Override
    public void onInitialize() {
        init("Fabric Mod Initializer");
    }

    public static void init(String initializedFrom) {
        Objects.requireNonNull(initializedFrom, "Caves And Critters must be told where it was initialized from.");
        if (firstInitialized != null) {
            CavesAndCritters.LOGGER.debug(String.format("Attempted to Initialize Caves And Critters from \"%s\" but Caves And Critters already was initialized from \"%s\", this should not be a problem.", initializedFrom, firstInitialized));
            return;
        }
        firstInitialized = initializedFrom;
        CACRegistries.bootstrap();

    }
}
