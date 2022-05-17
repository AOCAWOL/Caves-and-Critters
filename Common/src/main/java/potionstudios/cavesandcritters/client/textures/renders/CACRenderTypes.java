package potionstudios.cavesandcritters.client.textures.renders;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import potionstudios.cavesandcritters.common.blocks.CACBlocks;
import potionstudios.cavesandcritters.reg.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class CACRenderTypes {
    public static void renderTypes(Consumer<Map<Block, RenderType>> mapConsumer) {
        Map<Block, RenderType> map = new HashMap<>();

        map.put(CACBlocks.PERIDOT_CLUSTER.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.LARGE_PERIDOT_BUD.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.MEDIUM_PERIDOT_BUD.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.SMALL_PERIDOT_BUD.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.MAGMATIC_VENT.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.CRUMBLY_ROSE.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.HANGING_CRUMBLY_ROOTS.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.PRIM_SPECTRAL_VINES.get(), RenderType.translucent());
        map.put(CACBlocks.PRIM_SPECTRAL_VINES_PLANT.get(), RenderType.translucent());
        map.put(CACBlocks.LURKWOOD_LEAVES.get(), RenderType.cutoutMipped());
        map.put(CACBlocks.LURKWOOD_SAPLING.get(), RenderType.cutoutMipped());

        for (RegistryObject<Block> potBlock : CACBlocks.flowerPotBlocks) {
            map.put(potBlock.get(), RenderType.cutout());
        }
        mapConsumer.accept(map);
    }
}
