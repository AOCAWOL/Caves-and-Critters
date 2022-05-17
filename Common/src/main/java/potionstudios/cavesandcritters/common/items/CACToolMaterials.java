package potionstudios.cavesandcritters.common.items;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public record CACToolMaterials(int level, int uses, float speed, float damage, int enchantmentValue,
                               Supplier<Ingredient> repairIngredient) implements Tier {
    public static final CACToolMaterials PERIDOT = new CACToolMaterials(3, 950, 6.5F, 1.5F, 15, () -> Ingredient.of(CACItems.RAW_PERIDOT.get()));


    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
