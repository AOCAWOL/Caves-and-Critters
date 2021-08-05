package net.fabricmc.caveaoc.common.properties.blocks;

import net.fabricmc.caveaoc.core.CACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

import java.util.Random;

public class BuddingPeridotBlock extends BuddingAmethystBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingPeridotBlock(Properties properties) {
        super(properties);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos2 = blockPos.relative(direction);
            BlockState blockState2 = serverLevel.getBlockState(blockPos2);
            Block block = null;
            if (canClusterGrowAtState(blockState2)) {
                block = CACBlocks.SMALL_PERIDOT_BUD;
            } else if (blockState2.is(CACBlocks.SMALL_PERIDOT_BUD) && blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
                block = CACBlocks.MEDIUM_PERIDOT_BUD;
            } else if (blockState2.is(CACBlocks.MEDIUM_PERIDOT_BUD) && blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
                block = CACBlocks.LARGE_PERIDOT_BUD;
            } else if (blockState2.is(CACBlocks.LARGE_PERIDOT_BUD) && blockState2.getValue(AmethystClusterBlock.FACING) == direction) {
                block = CACBlocks.PERIDOT_CLUSTER;
            }

            if (block != null) {
                BlockState blockState3 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, blockState2.getFluidState().getType() == Fluids.WATER);
                serverLevel.setBlockAndUpdate(blockPos2, blockState3);
            }

        }
    }
}
