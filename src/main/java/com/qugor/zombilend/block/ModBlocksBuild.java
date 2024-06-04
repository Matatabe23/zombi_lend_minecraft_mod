package com.qugor.zombilend.block;

import com.qugor.zombilend.item.ModItemsBlock;
import com.qugor.zombilend.world.feature.tree.TangerineTreeGrower;
import com.qugor.zombilend.zombilend;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocksBuild {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, zombilend.MOD_ID);


    public static final RegistryObject<Block> TANGERINE_LOG = registerBlock("tangerine_log",
            () -> new ModSapling(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), zombilend.ZOMBI_LAND_BLOCK);
    public static final RegistryObject<Block> TANGERINE_WOOD = registerBlock("tangerine_wood",
            () -> new ModSapling(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), zombilend.ZOMBI_LAND_BLOCK);
    public static final RegistryObject<Block> STRIPPED_TANGERINE_LOG = registerBlock("stripped_tangerine_log",
            () -> new ModSapling(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), zombilend.ZOMBI_LAND_BLOCK);
    public static final RegistryObject<Block> STRIPPED_TANGERINE_WOOD = registerBlock("stripped_tangerine_wood",
            () -> new ModSapling(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), zombilend.ZOMBI_LAND_BLOCK);

    public static final RegistryObject<Block> TANGERINE_PLANKS = registerBlock("tangerine_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
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
                    return 20;
                }
            }, zombilend.ZOMBI_LAND_BLOCK);
    public static final RegistryObject<Block> TANGERINE_LEAVES = registerBlock("tangerine_leaves",
            () -> new TangerineLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, zombilend.ZOMBI_LAND_BLOCK);

    public static final RegistryObject<Block> TANGERINE_SAPLING = registerBlock("tangerine_sapling",
            () -> new SaplingBlock(new TangerineTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), zombilend.ZOMBI_LAND_BLOCK);








    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItemsBlock.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
