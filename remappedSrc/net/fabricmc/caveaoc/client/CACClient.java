package net.fabricmc.caveaoc.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.caveaoc.client.textures.renders.CACCutoutRenders;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

@Environment(EnvType.CLIENT)
public class CACClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CACCutoutRenders.renderCutOuts();
//        BlockColorManager.onBlockColorsInit();
//        BlockColorManager.onItemColorsInit();
//        ClientSidePacketRegistry.INSTANCE.register(CustomEntitySpawnS2CPacket.SPAWN_PACKET_ID, CustomEntitySpawnS2CPacket::receiveSpawnPacket);
//        EntityRendererRegistry.INSTANCE.register(BYGEntities.BOAT, (entityRenderDispatcher, context) -> new BYGBoatRenderer(entityRenderDispatcher));
    }
}
