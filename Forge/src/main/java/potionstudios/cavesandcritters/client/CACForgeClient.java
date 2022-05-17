package potionstudios.cavesandcritters.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import potionstudios.cavesandcritters.client.textures.renders.CACRenderTypes;

public class CACForgeClient {

    public static void load() {
        CACRenderTypes.renderTypes(blockRenderTypeMap -> blockRenderTypeMap.forEach(ItemBlockRenderTypes::setRenderLayer));
    }
}
