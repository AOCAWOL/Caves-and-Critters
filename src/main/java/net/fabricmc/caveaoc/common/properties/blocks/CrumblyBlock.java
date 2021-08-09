package net.fabricmc.caveaoc.common.properties.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class CrumblyBlock extends FallingBlock {

    public CrumblyBlock(Properties properties) {
        super(properties);
    }
    public int getDustColor(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return -8356741;
    }

    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        Random random = new Random();
        if (!entity.isCrouching() && entity instanceof LivingEntity && entity.getType() != EntityType.SILVERFISH && entity.getType() != EntityType.CAVE_SPIDER) {
            if (isFree(level.getBlockState(blockPos.below())) && blockPos.getY() >= level.getMinBuildHeight()) {
                double d = (double) blockPos.getX() + random.nextDouble();
                double e = (double) blockPos.getY() + 1.0D;
                double f = (double) blockPos.getZ() + random.nextDouble();
                level.addParticle(ParticleTypes.LARGE_SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
                level.playLocalSound(d, e, f, SoundEvents.DRIPSTONE_BLOCK_BREAK, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
                FallingBlockEntity fallingBlockEntity = new FallingBlockEntity(level, (double)blockPos.getX() + 0.5D, blockPos.getY(), (double)blockPos.getZ() + 0.5D, level.getBlockState(blockPos));
                this.falling(fallingBlockEntity);
                level.addFreshEntity(fallingBlockEntity);
            }
        }

        super.stepOn(level, blockPos, blockState, entity);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
    }
}
