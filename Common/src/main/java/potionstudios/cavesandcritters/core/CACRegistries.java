package potionstudios.cavesandcritters.core;

import potionstudios.cavesandcritters.common.biome.CACBiomes;
import potionstudios.cavesandcritters.common.blocks.CACBlocks;
import potionstudios.cavesandcritters.common.features.CACFeatures;
import potionstudios.cavesandcritters.common.items.CACItems;

public class CACRegistries {

    public static void bootstrap() {
        CACBlocks.bootstrap();
        CACItems.bootstrap();
        CACFeatures.bootstrap();
        CACBiomes.bootstrap();
    }
}
