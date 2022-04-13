package com.mccreater.morearmortools.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum DemoArmorMaterial implements ArmorMaterial {
    INDUSTRYWOOL("industrywool", 5, new int[]{1,3,2,1}, 15, SoundEvents.BLOCK_WOOL_PLACE, 0.0F, () -> {
        return Ingredient.ofItems(Items.WHITE_WOOL);
    }),
    IRONGOLDINGOT("irongold",10,new int[]{2,6,4,2},35,SoundEvents.BLOCK_NETHER_GOLD_ORE_PLACE,1.5F,() -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    COPPER("copper",7,new int[]{1,3,2,1},25,SoundEvents.BLOCK_COPPER_PLACE,0.5F,() -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }),
    OBSIDIAN("obsidian",15,new int[]{3,9,6,3},40,SoundEvents.BLOCK_NETHER_GOLD_ORE_PLACE,2.0F,() -> {
        return Ingredient.ofItems(Items.OBSIDIAN);
    });

    private static final int[] BASE_DURABILITY = new int[]{6, 8, 8, 5};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantAbility;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private DemoArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantAbility, SoundEvent equipSound, float toughness, Supplier<Ingredient> ingredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantAbility = enchantAbility;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.repairIngredientSupplier = new Lazy<>(ingredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantAbility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}

