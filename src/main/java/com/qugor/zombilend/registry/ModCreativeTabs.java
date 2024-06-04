package com.qugor.zombilend.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import com.qugor.zombilend.item.ModItemsFood;

public class ModCreativeTabs {

    public static final CreativeModeTab ZOMBI_LAND_BLOCK = new CreativeModeTab("zombi_land_block") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ACACIA_WOOD);
        }
    };

    public static final CreativeModeTab ZOMBI_LAND_FOOD = new CreativeModeTab("zombi_land_food") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItemsFood.TANGERINE.get());
        }
    };

    public static final CreativeModeTab ZOMBI_LAND_TOOL = new CreativeModeTab("zombi_land_tool") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND_SWORD);
        }
    };

    public static final CreativeModeTab ZOMBI_LAND_ZOMBI = new CreativeModeTab("zombi_land_zombi") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ZOMBIE_SPAWN_EGG);
        }
    };

    public static void registerTabs() {
        // Этот метод может быть использован для регистрации вкладок,
        // если это требуется вашим модом.
    }
}
