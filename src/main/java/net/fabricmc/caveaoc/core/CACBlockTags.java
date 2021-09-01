package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.caveaoc.mixin.access.BlockTagMixin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class CACBlockTags {
    private static final List<String> LOCATIONS = new ArrayList<>();
    public static final List<Tag.Named<Block>> SURFACE_TAGS = new ArrayList<>();

    public static final Tag.Named<Block> SURFACE_BLOCKS_OVERWORLD = createSurfaceTag("surface_blocks_overworld");




    private static Tag.Named<Block> createSurfaceTag(String location) {
        Tag.Named<Block> blockTag = createTag(location);
        SURFACE_TAGS.add(blockTag);
        return blockTag;
    }

    private static Tag.Named<Block> createTag(String location) {
        if (!LOCATIONS.contains(location)) {
            LOCATIONS.add(location);
            return createTag(new ResourceLocation(CavesAndCrittersMain.MOD_ID, location));
        } else {
            throw new RuntimeException("Duplicate key: " + location);
        }
    }

    private static Tag.Named<Block> createTag(ResourceLocation location) {
        return BlockTagMixin.invokeBind(location.toString());
    }

}
