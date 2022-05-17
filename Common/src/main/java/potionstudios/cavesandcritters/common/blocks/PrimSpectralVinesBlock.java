package potionstudios.cavesandcritters.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class PrimSpectralVinesBlock extends GrowingPlantHeadBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public PrimSpectralVinesBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    protected int getBlocksToGrowWhenBonemealed(Random random) {
        return NetherVines.getBlocksToGrowWhenBonemealed(random);
    }

    protected Block getBodyBlock() {
        return CACBlocks.PRIM_SPECTRAL_VINES_PLANT.get();
    }

    protected boolean canGrowInto(BlockState blockState) {
        return NetherVines.isValidGrowthState(blockState);
    }

    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if ((entity instanceof LivingEntity livingEntity && entity.getType() == EntityType.PLAYER && entity.isCrouching())) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 1, true, true));
        }
    }
}
