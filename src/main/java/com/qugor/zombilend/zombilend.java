package com.qugor.zombilend;

import com.mojang.logging.LogUtils;
import com.qugor.zombilend.block.ModBlocksBuild;
import com.qugor.zombilend.entity.ModEntities;
import com.qugor.zombilend.entity.client.ZombiSwordsManRenderer;
import com.qugor.zombilend.item.ModItemsBlock;
import com.qugor.zombilend.item.ModItemsFood;
import com.qugor.zombilend.item.ModItemsZombis;
import com.qugor.zombilend.world.feature.ModConfiguredFeatures;
import com.qugor.zombilend.world.feature.ModPlacedFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(zombilend.MOD_ID)
public class zombilend {

    public static final String MOD_ID = "zombilend";
    private static final Logger LOGGER = LogUtils.getLogger();

    public zombilend() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItemsFood.register(modEventBus);
        ModItemsBlock.register(modEventBus);
        ModBlocksBuild.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ModEntities.ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onClientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Ваши настройки
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        // Ваши настройки клиента
    }

    @Mod.EventBusSubscriber(modid = "zombilend", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class ClientSetup {
        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Ваши настройки клиента
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.ZOMBI_SWORDSMAN.get(), ZombiSwordsManRenderer::new);
            event.registerEntityRenderer(ModEntities.ZOMBI_MINER.get(), ZombiSwordsManRenderer::new);
        }
    }

}
