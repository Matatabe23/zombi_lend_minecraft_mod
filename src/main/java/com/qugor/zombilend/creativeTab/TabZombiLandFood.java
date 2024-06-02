package com.qugor.zombilend.creativeTab;

import com.qugor.zombilend.item.ModItemsFood;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabZombiLandFood extends CreativeModeTab {

    public TabZombiLandFood() {
        super("zombi_land_food");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItemsFood.MANDARIN.get());
    }
}
