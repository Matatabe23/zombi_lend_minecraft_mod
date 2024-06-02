package com.qugor.zombilend.creativeTab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TabZombiLandTool extends CreativeModeTab {

    public TabZombiLandTool() {
        super("zombi_land_tool");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.DIAMOND_SWORD);
    }
}
