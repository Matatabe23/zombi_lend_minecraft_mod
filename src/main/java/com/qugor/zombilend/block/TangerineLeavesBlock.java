package com.qugor.zombilend.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;

public class TangerineLeavesBlock extends LeavesBlock {

    public TangerineLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
        if (!state.getValue(PERSISTENT)) {
            boolean hasLogNearby = false;
            for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -4, -4), pos.offset(4, 4, 4))) {
                if (worldIn.getBlockState(blockpos).is(ModBlocksBuild.TANGERINE_LOG.get())) {
                    hasLogNearby = true;
                    break;
                }
            }
            if (!hasLogNearby) {
                dropResources(state, worldIn, pos);
                worldIn.removeBlock(pos, false);
            }
        }
    }
}
