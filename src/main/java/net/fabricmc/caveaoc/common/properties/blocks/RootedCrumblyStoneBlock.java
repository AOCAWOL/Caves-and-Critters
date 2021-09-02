package net.fabricmc.caveaoc.common.properties.blocks;

import net.fabricmc.caveaoc.core.CACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.RootedDirtBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class RootedCrumblyStoneBlock extends RootedDirtBlock implements BonemealableBlock {

    public RootedCrumblyStoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, Random random, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlockAndUpdate(blockPos.below(), CACBlocks.HANGING_CRUMBLY_ROOTS.defaultBlockState());
    }
}
