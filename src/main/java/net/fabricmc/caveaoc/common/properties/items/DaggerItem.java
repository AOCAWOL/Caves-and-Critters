package net.fabricmc.caveaoc.common.properties.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.entity.layers.PhantomEyesLayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.RandomUtils;

public class DaggerItem extends SwordItem implements Vanishable {

    public DaggerItem(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);
    }

    public InteractionResultHolder<ItemStack> use(net.minecraft.world.level.Level level, Player player, InteractionHand interactionHand) {

        if (!player.getAbilities().instabuild) {
            player.getCooldowns().addCooldown(this, 200);
        }

        ItemStack itemStack = player.getItemInHand(interactionHand);

        player.level.addParticle(ParticleTypes.SWEEP_ATTACK, player.getX(), player.getY() + player.getRandom().nextDouble() * 2.0D, player.getZ(), player.getRandom().nextGaussian(), 0.0D, player.getRandom().nextGaussian());

        player.setDeltaMovement(player.getDeltaMovement().x, 0.8F, player.getDeltaMovement().z);

        player.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.0F, 1.0F/(RandomUtils.nextFloat()*.4F +.8F));

        player.level.addParticle(ParticleTypes.CRIT, player.getX() + 0.5D, player.getY() + 0.5D, player.getZ() + 0.5D, player.getRandom().nextFloat() / 2.0F, 5.0E-5D, player.getRandom().nextFloat() / 2.0F);
        player.level.addParticle(ParticleTypes.CRIT, player.getX() + 0.5D, player.getY() + 0.5D, player.getZ() + 0.5D, player.getRandom().nextFloat() / 2.0F, 5.0E-5D, player.getRandom().nextFloat() / 2.0F);
        player.level.addParticle(ParticleTypes.CRIT, player.getX() + 0.5D, player.getY() + 0.5D, player.getZ() + 0.5D, player.getRandom().nextFloat() / 2.0F, 5.0E-5D, player.getRandom().nextFloat() / 2.0F);

        itemStack.hurtAndBreak(1, player, (playerx) -> {
            playerx.broadcastBreakEvent(interactionHand);
        });

        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }
}
