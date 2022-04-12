package com.mccreater.morearmortools.blocks;

import net.minecraft.item.AxeItem;
import com.mccreater.morearmortools.blocks.DemoToolMaterials;

public class WoolAxe extends AxeItem {
    protected WoolAxe(Settings settings) {
        super(DemoToolMaterials.INDUSTRYWOOL, 5, -3.5F, settings);
    }
}
