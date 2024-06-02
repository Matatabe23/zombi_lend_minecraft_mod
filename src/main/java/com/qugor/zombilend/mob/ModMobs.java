package com.qugor.zombilend.mob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMobs {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "zombilend");

    public static final RegistryObject<EntityType<CustomZombie>> CUSTOM_ZOMBIE = ENTITIES.register("custom_zombie",
            () -> EntityType.Builder.of(CustomZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F)
                    .build("custom_zombie"));

    public static class CustomZombie extends Zombie {
        public CustomZombie(EntityType<? extends Zombie> type, Level world) {
            super(type, world);
        }

        @Override
        protected void registerGoals() {
            this.goalSelector.addGoal(1, new FloatGoal(this));
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
            this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0D));
            this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        }
    }
}
