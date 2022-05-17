package potionstudios.cavesandcritters.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class HangingCrumblyRoots extends HangingRootsBlock {

    public HangingCrumblyRoots(Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, Random random) {
        int i = blockPos.getX();
        int j = blockPos.getY();
        int k = blockPos.getZ();
        double d = (double)i + random.nextDouble();
        double e = (double)j + 0.7D;
        double f = (double)k + random.nextDouble();
        level.addParticle(ParticleTypes.MYCELIUM, d, e, f, 0.0D, 0.0D, 0.0D);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 14; ++l) {
            mutableBlockPos.set(i + Mth.nextInt(random, -10, 10), j - random.nextInt(10), k + Mth.nextInt(random, -10, 10));
            BlockState blockState2 = level.getBlockState(mutableBlockPos);
            if (!blockState2.isCollisionShapeFullBlock(level, mutableBlockPos)) {
                level.addParticle(ParticleTypes.MYCELIUM, (double)mutableBlockPos.getX() + random.nextDouble(), (double)mutableBlockPos.getY() + random.nextDouble(), (double)mutableBlockPos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
