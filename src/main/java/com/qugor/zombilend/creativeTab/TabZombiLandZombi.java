package com.qugor.zombilend.creativeTab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TabZombiLandZombi extends CreativeModeTab {

    public TabZombiLandZombi() {
        super("zombi_land_zombi");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.ZOMBIE_SPAWN_EGG);
    }
}
