package potionstudios.cavesandcritters;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import potionstudios.cavesandcritters.client.CACForgeClient;
import potionstudios.cavesandcritters.core.CACRegistries;
import potionstudios.cavesandcritters.network.ForgeNetworkHandler;
import potionstudios.cavesandcritters.terrablender.CavesAndCrittersRegion;
import terrablender.api.Regions;

@Mod(CavesAndCritters.MOD_ID)
public class CavesAndCrittersForge {

    public CavesAndCrittersForge() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        CACRegistries.bootstrap();
        modBus.addListener(this::commonLoad);
        modBus.addListener(this::loadFinish);
        modBus.addListener(this::clientLoad);
    }

    private void commonLoad(FMLCommonSetupEvent event) {
        event.enqueueWork(ForgeNetworkHandler::init);
    }

    private void loadFinish(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new CavesAndCrittersRegion());
        });
    }


    private void clientLoad(FMLClientSetupEvent event) {
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> CACForgeClient::load);
    }
}
