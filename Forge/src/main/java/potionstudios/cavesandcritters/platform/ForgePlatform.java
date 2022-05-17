package potionstudios.cavesandcritters.platform;

import com.google.auto.service.AutoService;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import potionstudios.cavesandcritters.common.items.CACItems;
import potionstudios.cavesandcritters.network.ForgeNetworkHandler;
import potionstudios.cavesandcritters.network.S2CPacket;

@AutoService(ModPlatform.class)
public class ForgePlatform implements ModPlatform {

    public static final CreativeModeTab TAB = new CreativeModeTab("cavesandcritters.cavesandcritters") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CACItems.LURK_FRUIT.get());
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public boolean canScroll() {
            return true;
        }

        @Override
        public ResourceLocation getBackgroundImage() {
            return new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png");
        }
    };

    @Override
    public String getPlatformName() {
        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public <P extends S2CPacket> void sendToClient(ServerPlayer player, P packet) {
        ForgeNetworkHandler.sendToPlayer(player, packet);
    }

    @Override
    public CreativeModeTab creativeTab() {
        return TAB;
    }
}
