package potionstudios.cavesandcritters;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CavesAndCritters {
    public static final String MOD_ID = "cavesandcritters";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
