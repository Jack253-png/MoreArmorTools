package com.mccreater.morearmortools.blocks;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.entity.EquipmentSlot;

public class Group {
    public static final ItemGroup Tools = FabricItemGroupBuilder.build(
            new Identifier("morearmortools", "tools_group"),
            () -> new ItemStack(Items.DIAMOND_PICKAXE));
    public static final ItemGroup Armors = FabricItemGroupBuilder.build(
            new Identifier("morearmortools","armors_group"),
            () -> new ItemStack(Items.DIAMOND_CHESTPLATE));
    public static final ItemGroup Materials = FabricItemGroupBuilder.build(
            new Identifier("morearmortools","materials_group"),
            () -> new ItemStack(Items.STICK));


    public static final Item WoolHelmet = new WoolHamlet(DemoArmorMaterial.INDUSTRYWOOL, EquipmentSlot.HEAD, new Item.Settings().group(Armors));
    public static final Item WoolChestplate = new WoolChestplate(DemoArmorMaterial.INDUSTRYWOOL, EquipmentSlot.CHEST, new Item.Settings().group(Armors));
    public static final Item WoolLeggings = new WoolLeggings(DemoArmorMaterial.INDUSTRYWOOL, EquipmentSlot.LEGS, new Item.Settings().group(Armors));
    public static final Item WoolBoots = new WoolBoots(DemoArmorMaterial.INDUSTRYWOOL, EquipmentSlot.FEET, new Item.Settings().group(Armors));
    public static final Item IronGoldHemlet = new IronGoldHemlet(DemoArmorMaterial.IRONGOLDINGOT, EquipmentSlot.HEAD, new Item.Settings().group(Armors));
    public static final Item IronGoldChestplate = new IronGoldChestPlate(DemoArmorMaterial.IRONGOLDINGOT, EquipmentSlot.CHEST, new Item.Settings().group(Armors));
    public static final Item IronGoldLeggings = new IronGoldLeggings(DemoArmorMaterial.IRONGOLDINGOT, EquipmentSlot.LEGS, new Item.Settings().group(Armors));
    public static final Item IronGoldBoots = new IronGoldBoots(DemoArmorMaterial.IRONGOLDINGOT, EquipmentSlot.FEET, new Item.Settings().group(Armors));

    public static final Item WoolAxe = new WoolAxe(new Item.Settings().group(Tools));
    public static final Item WoolSword = new WoolSword(new Item.Settings().group(Tools));
    public static final Item WoolPickaxe = new WoolPickaxe(new Item.Settings().group(Tools));
    public static final Item WoolShovel = new WoolShovel(new Item.Settings().group(Tools));
    public static final Item WoolHoe = new WoolHoe(new Item.Settings().group(Tools));
    public static final Item CompressionWoodSword = new CompressionWoodSword(new Item.Settings().group(Tools));
    public static final Item IronGoldAxe = new IronGoldAxe(new Item.Settings().group(Tools));
    public static final Item IronGoldPickaxe = new IronGoldPickaxe(new Item.Settings().group(Tools));
    public static final Item IronGoldSword = new IronGoldSword(new Item.Settings().group(Tools));
    public static final Item IronGoldShovel = new IronGoldShovel(new Item.Settings().group(Tools));
    public static final Item IronGoldHoe = new IronGoldHoe(new Item.Settings().group(Tools));

    public static final Block IndustryWool = new IndustryWool(FabricBlockSettings.of(Material.WOOL).hardness(0.7f));

    public static final Item CompressionStick1x = new CompressionStick1x(new Item.Settings().group(Materials));
    public static final Item CompressionStick2x = new CompressionStick2x(new Item.Settings().group(Materials));
    public static final Item CompressionStick3x = new CompressionStick3x(new Item.Settings().group(Materials));
    public static final Item CompressionStick4x = new CompressionStick4x(new Item.Settings().group(Materials));
    public static final Item CompressionStick5x = new CompressionStick5x(new Item.Settings().group(Materials));
    public static final Item CompressionStick6x = new CompressionStick6x(new Item.Settings().group(Materials));
    public static final Item CompressionStick7x = new CompressionStick7x(new Item.Settings().group(Materials));
    public static final Item CompressionStick8x = new CompressionStick8x(new Item.Settings().group(Materials));
    public static final Item CompressionStick9x = new CompressionStick9x(new Item.Settings().group(Materials));
    public static final Item IronGoldIngot = new IronGoldIngot(new Item.Settings().group(Materials));

}
