package com.qugor.zombilend.creativeTab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TabZombiLandBlock extends CreativeModeTab {

    public TabZombiLandBlock() {
        super("zombi_land_block");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.ACACIA_WOOD);
    }
}
