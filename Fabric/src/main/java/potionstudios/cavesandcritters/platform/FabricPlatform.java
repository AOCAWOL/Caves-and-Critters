package potionstudios.cavesandcritters.platform;

import com.google.auto.service.AutoService;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import potionstudios.cavesandcritters.CavesAndCritters;
import potionstudios.cavesandcritters.common.items.CACItems;
import potionstudios.cavesandcritters.network.FabricNetworkHandler;
import potionstudios.cavesandcritters.network.S2CPacket;

@AutoService(ModPlatform.class)
public class FabricPlatform implements ModPlatform {

    public static final CreativeModeTab TAB = FabricItemGroupBuilder.build(CavesAndCritters.createLocation(CavesAndCritters.MOD_ID), () -> new ItemStack(CACItems.LURK_FRUIT.get()));

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <P extends S2CPacket> void sendToClient(ServerPlayer player, P packet) {
        FabricNetworkHandler.sendToPlayer(player, packet);
    }

    @Override
    public CreativeModeTab creativeTab() {
        return TAB;
    }
}
