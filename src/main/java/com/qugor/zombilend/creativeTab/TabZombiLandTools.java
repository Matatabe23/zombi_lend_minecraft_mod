package com.qugor.zombilend.creativeTab;

import com.qugor.zombilend.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TabZombiLandTools extends CreativeModeTab {

    public TabZombiLandTools() {
        super("zombi_land_tools");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.DIAMOND_SWORD);
    }
}
