package net.fabricmc.caveaoc.common.properties.blocks;

import net.fabricmc.caveaoc.core.CACBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class PrimSpectralVinesPlantBlock extends GrowingPlantBodyBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public PrimSpectralVinesPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) CACBlocks.PRIM_SPECTRAL_VINES;
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if ((entity instanceof LivingEntity livingEntity && entity.getType() == EntityType.PLAYER && entity.isCrouching())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 1, true, true));
        }
    }
}
