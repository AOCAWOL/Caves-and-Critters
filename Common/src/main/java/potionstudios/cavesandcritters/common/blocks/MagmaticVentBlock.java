package potionstudios.cavesandcritters.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.RandomUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MagmaticVentBlock extends Block implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED;
    private static final VoxelShape BASE_SHAPE;

    public MagmaticVentBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));

    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, Random random) {
        BlockPos blockPos2 = blockPos.above();
        if (level.getBlockState(blockPos2).isAir() && !level.getBlockState(blockPos2).isSolidRender(level, blockPos2)) {
            if (random.nextInt(100) == 0) {
                double d = (double) blockPos.getX() + random.nextDouble();
                double e = (double) blockPos.getY() + 1.0D;
                double f = (double) blockPos.getZ() + random.nextDouble();
                level.addParticle(ParticleTypes.LARGE_SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
                level.playLocalSound(d, e, f, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }

            if (random.nextInt(200) == 0) {
                level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
            }
        }
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return BASE_SHAPE;
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        Random random = new Random();
        if (!level.hasNeighborSignal(blockPos)) {
            if (random.nextInt(50) == 0) {
            double d = (double) blockPos.getX() + random.nextDouble();
            double e = (double) blockPos.getY() + 1.0D;
            double f = (double) blockPos.getZ() + random.nextDouble();
            level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
            level.neighborChanged(blockPos, Blocks.AIR, blockPos);
            level.addParticle(ParticleTypes.LARGE_SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
            level.playLocalSound(d, e, f, SoundEvents.DRIPSTONE_BLOCK_BREAK, SoundSource.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
        }
    }

        if (!level.hasNeighborSignal(blockPos)) {
            if (random.nextInt(50) == 0) {
                Direction[] var5 = Direction.values();
                int var6 = var5.length;
                for (int var7 = 0; var7 < var6; ++var7) {
                    Direction direction = var5[var7];
                    BlockPos blockPos2 = blockPos.relative(direction);
                    if (!level.getBlockState(blockPos2).isSolidRender(level, blockPos2)) {
                        Direction.Axis axis = direction.getAxis();
                        double e = axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getStepX() : (double) random.nextFloat();
                        double f = axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getStepY() : (double) random.nextFloat();
                        double g = axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getStepZ() : (double) random.nextFloat();
                        level.addParticle(ParticleTypes.LARGE_SMOKE, (double) blockPos.getX() + e, (double) blockPos.getY() + f, (double) blockPos.getZ() + g, 0.0D, 0.0D, 0.0D);
                    }
                }
                entity.playSound(SoundEvents.LAVA_EXTINGUISH, 1.0F, 1.0F / (RandomUtils.nextFloat() * .4F + .8F));

                entity.setDeltaMovement(entity.getDeltaMovement().x, 0.8F, entity.getDeltaMovement().z);
            }
        }

        if (level.hasNeighborSignal(blockPos)) {
            Direction[] var5 = Direction.values();
            int var6 = var5.length;
            for (int var7 = 0; var7 < var6; ++var7) {
                Direction direction = var5[var7];
                BlockPos blockPos2 = blockPos.relative(direction);
                if (!level.getBlockState(blockPos2).isSolidRender(level, blockPos2)) {
                    Direction.Axis axis = direction.getAxis();
                    double e = axis == Direction.Axis.X ? 0.5D + 0.5625D * (double) direction.getStepX() : (double) random.nextFloat();
                    double f = axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double) direction.getStepY() : (double) random.nextFloat();
                    double g = axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double) direction.getStepZ() : (double) random.nextFloat();
                    level.addParticle(ParticleTypes.LARGE_SMOKE, (double) blockPos.getX() + e, (double) blockPos.getY() + f, (double) blockPos.getZ() + g, 0.0D, 0.0D, 0.0D);
                }
            }
            entity.playSound(SoundEvents.LAVA_EXTINGUISH, 1.0F, 1.0F / (RandomUtils.nextFloat() * .4F + .8F));

            entity.setDeltaMovement(entity.getDeltaMovement().x, 0.8F, entity.getDeltaMovement().z);
        }

        super.stepOn(level, blockPos, blockState, entity);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
        boolean bl = fluidState.getType() == Fluids.WATER;
        return super.getStateForPlacement(blockPlaceContext).setValue(WATERLOGGED, bl);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return Block.canSupportCenter(levelReader, blockPos.below(), Direction.UP);
    }

    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D);

    }
}

