package com.mccreater.morearmortools.blocks;

import net.minecraft.item.PickaxeItem;
import com.mccreater.morearmortools.blocks.DemoToolMaterials;

public class WoolPickaxe extends PickaxeItem {
    protected WoolPickaxe(Settings settings) {
        super(DemoToolMaterials.INDUSTRYWOOL, 2, -3.6F, settings);
    }
}
