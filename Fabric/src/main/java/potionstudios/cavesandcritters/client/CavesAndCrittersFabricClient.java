package potionstudios.cavesandcritters.client;

import net.fabricmc.api.ClientModInitializer;
import potionstudios.cavesandcritters.client.textures.renders.CACRenderTypes;
import potionstudios.cavesandcritters.mixin.access.ItemBlockRenderTypeAccess;

public class CavesAndCrittersFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CACRenderTypes.renderTypes(blockRenderTypeMap -> ItemBlockRenderTypeAccess.byg_getTYPE_BY_BLOCK().putAll(blockRenderTypeMap));
    }
}
