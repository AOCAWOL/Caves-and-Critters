package net.fabricmc.caveaoc.core;

import net.fabricmc.caveaoc.CavesAndCrittersMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.DirtPathBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("deprecation")
public class CACBlocks {
    public static List<Block> blocksList = new ArrayList<>();
    public static List<Block> flowerPotBlocks = new ArrayList<>();
    public static List<Identifier> flowerIDs = new ArrayList<>();
    //------------------------------------------------------------------------
    public static final Block PERIDOT_CLUSTER = createPlanks("peridot_cluster");



    //------------------------------------------------------------------------
    static Block createPlanks(String id) {
        Block createBlock = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN)
                .sounds(BlockSoundGroup.WOOD)
                .strength(2.0f, 3.0f));
        Registry.register(Registry.BLOCK, new Identifier(CavesAndCrittersMain.MOD_ID, id), createBlock);

        blocksList.add(createBlock);
        return createBlock;
    }

    static Block createBlock(Block block, String id) {
        Registry.register(Registry.BLOCK, new Identifier(CavesAndCrittersMain.MOD_ID, id), block);
        blocksList.add(block);
        return block;
    }

    public static void init() {
    }

    public static class GrassPathBlockAccess extends DirtPathBlock {

        public GrassPathBlockAccess(Settings settings) {
            super(settings);
        }
    }
}
