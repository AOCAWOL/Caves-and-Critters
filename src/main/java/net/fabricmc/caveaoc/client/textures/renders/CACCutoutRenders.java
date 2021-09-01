package net.fabricmc.caveaoc.client.textures.renders;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.core.CACBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class CACCutoutRenders {
    public static void renderCutOuts() {
        CavesAndCrittersMain.LOGGER.debug("BYG: Rendering Texture Cutouts...");

        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.PERIDOT_CLUSTER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.LARGE_PERIDOT_BUD, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.MEDIUM_PERIDOT_BUD, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.SMALL_PERIDOT_BUD, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(CACBlocks.MAGMATIC_VENT, RenderType.cutoutMipped());

        for (Block potBlock : CACBlocks.flowerPotBlocks)
            BlockRenderLayerMap.INSTANCE.putBlock(potBlock, RenderType.cutout());

        CavesAndCrittersMain.LOGGER.debug("BYG: Texture Cutouts Rendered!");
    }
    }
