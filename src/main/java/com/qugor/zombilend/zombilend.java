package com.qugor.zombilend;

import com.mojang.logging.LogUtils;
import com.qugor.zombilend.creativeTab.TabZombiLandFood;
import com.qugor.zombilend.creativeTab.TabZombiLandTools;
import com.qugor.zombilend.creativeTab.TabZombiLandZombi;
import com.qugor.zombilend.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(zombilend.MOD_ID)
public class zombilend
{
    public static final CreativeModeTab ZOMBI_LAND_FOOD = new TabZombiLandFood();
    public static final CreativeModeTab ZOMBI_LAND_TOOLS = new TabZombiLandTools();
    public static final CreativeModeTab ZOMBI_LAND_WEAPONS = new TabZombiLandZombi();

    public static final String MOD_ID = "zombilend";
    private static final Logger LOGGER = LogUtils.getLogger();

    public zombilend()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Ваши настройки
    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Настройки клиента
        }
    }
}
