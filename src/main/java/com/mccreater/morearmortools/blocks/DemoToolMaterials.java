package com.mccreater.morearmortools.blocks;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import java.util.function.Supplier;
import net.minecraft.util.Lazy;

public enum DemoToolMaterials implements ToolMaterial {

    INDUSTRYWOOL(0, 32, 1.0F, 0.0F, 20, () -> {
        return Ingredient.fromTag(ItemTags.WOOL);
    }),
    COMPRESSIONSTICK(20,45,5.0F,3.0F,100,() -> {
        return Ingredient.fromTag(ItemTags.LOGS);
    }),
    IRONGOLDINGOT(15,35,4.0F,2.0F,60,() -> {
        return Ingredient.fromTag(ItemTags.IRON_ORES);
    }),
    COPPER(15,40,3.0F,1.5F,70,() -> {
        return Ingredient.fromTag(ItemTags.COPPER_ORES);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private DemoToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient) this.repairIngredient.get();
    }

}
