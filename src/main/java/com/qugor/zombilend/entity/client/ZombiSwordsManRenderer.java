package com.qugor.zombilend.entity.client;

import com.qugor.zombilend.entity.custom.ZombiSwordsMan;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class ZombiSwordsManRenderer extends ZombieRenderer {

    private static final ResourceLocation TEXTURE = new ResourceLocation("zombilend", "textures/entity/zombie_swordsman.png");

    public ZombiSwordsManRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie entity) {
        if (entity instanceof ZombiSwordsMan) {
            return TEXTURE;
        } else {
            // Возвращаем текстуру для обычного зомби
            return super.getTextureLocation(entity);
        }
    }
}
