package net.fabricmc.caveaoc.client.textures.renders;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.core.CACBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class CACCutoutRenders {
    public static void renderCutOuts() {
        CavesAndCrittersMain.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.PERIDOT_CLUSTER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.LARGE_PERIDOT_BUD, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.MEDIUM_PERIDOT_BUD, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.SMALL_PERIDOT_BUD, RenderLayer.getCutoutMipped());

        for (Block potBlock : CACBlocks.flowerPotBlocks)
            BlockRenderLayerMap.INSTANCE.putBlock(potBlock, RenderLayer.getCutout());

        CavesAndCrittersMain.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
    }
