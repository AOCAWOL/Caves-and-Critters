package net.fabricmc.caveaoc.common.properties.blocks;

import net.fabricmc.caveaoc.core.CACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class CrumblyRoseBlock extends FlowerBlock implements BonemealableBlock {

    public CrumblyRoseBlock(MobEffect mobEffect, int i, Properties properties) {
        super(mobEffect, i, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(CACBlocks.CRUMBLY_STONE) || blockState.is(CACBlocks.ROOTED_CRUMBLY_STONE) || super.mayPlaceOn(blockState, blockGetter, blockPos);
    }

    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean bl) {
        return blockGetter.getBlockState(blockPos.below()).is(CACBlocks.CRUMBLY_STONE);
    }

    public boolean isBonemealSuccess(Level level, Random random, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, Random random, BlockPos blockPos, BlockState blockState) {
        double d = (double) blockPos.getX() + random.nextDouble();
        double e = (double) blockPos.getY() + 1.0D;
        double f = (double) blockPos.getZ() + random.nextDouble();
        serverLevel.setBlockAndUpdate(blockPos.below(), CACBlocks.ROOTED_CRUMBLY_STONE.defaultBlockState());
        serverLevel.neighborChanged(blockPos.below(), CACBlocks.ROOTED_CRUMBLY_STONE, blockPos);
        serverLevel.playLocalSound(d, e, f, SoundEvents.ROOTED_DIRT_PLACE, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
    }
}
