package net.fabricmc.caveaoc.common.properties.blocks;

import net.fabricmc.caveaoc.core.CACBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Random;

public class BuddingPeridotBlock extends BuddingAmethystBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingPeridotBlock(Settings settings) {
        super(settings);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canGrowIn(blockState)) {
                block = CACBlocks.SMALL_PERIDOT_BUD;
            } else if (blockState.isOf(CACBlocks.SMALL_PERIDOT_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = CACBlocks.MEDIUM_PERIDOT_BUD;
            } else if (blockState.isOf(CACBlocks.MEDIUM_PERIDOT_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = CACBlocks.LARGE_PERIDOT_BUD;
            } else if (blockState.isOf(CACBlocks.LARGE_PERIDOT_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = CACBlocks.PERIDOT_CLUSTER;
            }

            if (block != null) {
                BlockState blockState2 = block.getDefaultState().with(AmethystClusterBlock.FACING, direction).with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }

        }
    }
}
