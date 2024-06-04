package com.qugor.zombilend.item;

import com.qugor.zombilend.zombilend;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsFood {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, zombilend.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> TANGERINE = ITEMS.register("tangerine",
            () -> new Item(new Item.Properties().tab(zombilend.ZOMBI_LAND_FOOD)));
}
