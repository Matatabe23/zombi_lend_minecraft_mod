package com.qugor.zombilend.client.renderer;

import com.qugor.zombilend.mob.ModMobs;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;

public class CustomZombieRenderer extends ZombieRenderer {
    public CustomZombieRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTextureLocation(ModMobs.CustomZombie entity) {
        return new ResourceLocation("zombilend", "textures/entity/custom_zombie.png");
    }
}
