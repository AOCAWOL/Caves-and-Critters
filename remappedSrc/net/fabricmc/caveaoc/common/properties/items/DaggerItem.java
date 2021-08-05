package net.fabricmc.caveaoc.common.properties.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.layers.PhantomEyesLayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import org.apache.commons.lang3.RandomUtils;

public class DaggerItem extends SwordItem implements Vanishable {

    public DaggerItem(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);

    }

    public InteractionResultHolder<ItemStack> use(ServerLevel level, Player player, InteractionHand interactionHand){
        player.getCooldowns().addCooldown(this, 200);

        player.setDeltaMovement(player.getDeltaMovement().x, 0.5F, player.getDeltaMovement().z);
        player.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.0F, 1.0F/(RandomUtils.nextFloat()*.4F +.8F));
        player.level.addParticle(ParticleTypes.SWEEP_ATTACK, player.getX(), player.getY() + player.getRandom().nextDouble() * 2.0D, player.getZ(), player.getRandom().nextGaussian(), 0.0D, player.getRandom().nextGaussian());

        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }

}
