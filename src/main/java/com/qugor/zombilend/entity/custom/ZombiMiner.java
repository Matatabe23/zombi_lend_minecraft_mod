package com.qugor.zombilend.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;


public class ZombiMiner extends Zombie {

    public ZombiMiner(EntityType<? extends Zombie> type, Level world) {
        super(type, world);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType spawnReason, SpawnGroupData spawnData, CompoundTag dataTag) {
        SpawnGroupData data = super.finalizeSpawn(world, difficulty, spawnReason, spawnData, dataTag);

        // Устанавливаем случайную кирку в руку зомби
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(getRandomPickaxe()));
        // Устанавливаем золотой шлем на голову
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));

        return data;
    }


    // Метод для выбора случайной кирки из списка
    private Item getRandomPickaxe() {
        Item[] pickaxeChoices = {
                Items.WOODEN_PICKAXE,
                Items.STONE_PICKAXE,
                Items.IRON_PICKAXE,
                Items.DIAMOND_PICKAXE
        };
        return pickaxeChoices[this.random.nextInt(pickaxeChoices.length)];
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Zombie.createAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.ATTACK_DAMAGE, 10.0);
    }
}
