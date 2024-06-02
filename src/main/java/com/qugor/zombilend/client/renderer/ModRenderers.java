package com.qugor.zombilend.client.renderer;

import com.qugor.zombilend.mob.ModMobs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "zombilend", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModRenderers {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModMobs.CUSTOM_ZOMBIE.get(), CustomZombieRenderer::new);
    }
}
