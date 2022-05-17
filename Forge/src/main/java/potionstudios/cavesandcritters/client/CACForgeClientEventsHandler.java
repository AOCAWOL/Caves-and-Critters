package potionstudios.cavesandcritters.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CACForgeClientEventsHandler {

    @SubscribeEvent
    public static void cac_onColorHandlerEvent$Block(ColorHandlerEvent.Block event) {
    }

    @SubscribeEvent
    public static void cac_onColorHandlerEvent$Item(ColorHandlerEvent.Item event) {
    }

    @SubscribeEvent
    public static void cac_onEntityRenderersEvent$RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
    }

    @SubscribeEvent
    public static void cac_registerParticleFactories(ParticleFactoryRegisterEvent event) {
    }
}