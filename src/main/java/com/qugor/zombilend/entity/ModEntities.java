package com.qugor.zombilend.entity;

import com.qugor.zombilend.entity.custom.ZombiMiner;
import com.qugor.zombilend.zombilend;
import com.qugor.zombilend.entity.custom.ZombiSwordsMan;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

@Mod.EventBusSubscriber(modid = zombilend.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, zombilend.MOD_ID);

    public static final RegistryObject<EntityType<ZombiSwordsMan>> ZOMBI_SWORDSMAN = ENTITY_TYPES.register("zombie_swordsman",
            () -> EntityType.Builder.of(ZombiSwordsMan::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .build("zombie_swordsman"));

    public static final RegistryObject<EntityType<ZombiMiner>> ZOMBI_MINER = ENTITY_TYPES.register("zombi_miner",
            () -> EntityType.Builder.of(ZombiMiner::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .build("zombi_miner"));

//
//    public static final RegistryObject<EntityType<ZombiSwordsMan>> CUSTOM_ZOMBIE = ENTITY_TYPES.register("custom_zombie",
//            () -> EntityType.Builder.of(ZombiSwordsMan::new, MobCategory.MONSTER)
//                    .sized(0.6F, 1.95F)
//                    .build("custom_zombie"));

    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ZOMBI_SWORDSMAN.get(), ZombiSwordsMan.createAttributes().build());
        event.put(ZOMBI_MINER.get(), ZombiMiner.createAttributes().build());
    }
}
