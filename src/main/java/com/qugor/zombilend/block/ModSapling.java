package com.qugor.zombilend.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;

public class ModSapling extends RotatedPillarBlock {
    public ModSapling(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocksBuild.TANGERINE_LOG.get())) {
                return ModBlocksBuild.STRIPPED_TANGERINE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }

            if(state.is(ModBlocksBuild.TANGERINE_WOOD.get())) {
                return ModBlocksBuild.STRIPPED_TANGERINE_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
