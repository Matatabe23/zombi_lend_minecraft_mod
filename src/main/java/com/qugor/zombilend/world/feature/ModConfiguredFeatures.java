package com.qugor.zombilend.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.qugor.zombilend.zombilend;
import com.qugor.zombilend.block.ModBlocksBuild;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, zombilend.MOD_ID);

//    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
//            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocksBuild.ZIRCON_ORE.get().defaultBlockState()),
//            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocksBuild.DEEPSLATE_ZIRCON_ORE.get().defaultBlockState())));
//    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
//            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocksBuild.ENDSTONE_ZIRCON_ORE.get().defaultBlockState())));
//    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
//            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocksBuild.NETHERRACK_ZIRCON_ORE.get().defaultBlockState())));


//    public static final RegistryObject<ConfiguredFeature<?, ?>> ZIRCON_ORE = CONFIGURED_FEATURES.register("zircon_ore",
//            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ZIRCON_ORES.get(),7)));
//    public static final RegistryObject<ConfiguredFeature<?, ?>> END_ZIRCON_ORE = CONFIGURED_FEATURES.register("end_zircon_ore",
//            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_ZIRCON_ORES.get(), 9)));
//    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_ZIRCON_ORE = CONFIGURED_FEATURES.register("nether_zircon_ore",
//            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ZIRCON_ORES.get(), 9)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> TANGERINE =
            CONFIGURED_FEATURES.register("tangerine", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocksBuild.TANGERINE_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(ModBlocksBuild.TANGERINE_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TANGERINE_SPAWN =
            CONFIGURED_FEATURES.register("tangerine_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.TANGERINE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.TANGERINE_CHECKED.getHolder().get())));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
