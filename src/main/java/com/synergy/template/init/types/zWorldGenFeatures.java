package com.synergy.template.init.types;

import static com.synergy.template.Main.MODULE_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zWorldGenFeatures {
        public static void register(IEventBus bus) {
                TrunkPlacer.register(bus);
                Features.register(bus);
        }

        public class Features {
                public static void register(IEventBus bus) {
                        zFeatures.register(bus);
                }

                public static final DeferredRegister<Feature<?>> zFeatures = DeferredRegister
                                .create(Registries.FEATURE, MODULE_ID);

                // public static final DeferredHolder<Feature<?>, X> ID = zFeatures
                // .register("ID", () -> new X());

        }

        public class TrunkPlacer {
                public static void register(IEventBus bus) {
                        zTrunks.register(bus);
                }

                public static final DeferredRegister<TrunkPlacerType<?>> zTrunks = DeferredRegister
                                .create(Registries.TRUNK_PLACER_TYPE, MODULE_ID);

                // public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<X>> ID
                // = zTrunks
                // .register("id", () -> new TrunkPlacerType<>(X.CODEC));

        }

        public class PlacedFeatures {
                // public static final ResourceKey<PlacedFeature> ID = RegistryUtils
                // .createPlacedFeature(MODULE_ID, "id");

        }

        public class ConfiguredFeatures {
                // public static final ResourceKey<ConfiguredFeature<?, ?>> ID = RegistryUtils
                // .createConfiguredFeature(MODULE_ID, "id");

        }

        public class BiomeModifiers {
                // public static final ResourceKey<BiomeModifier> ID = RegistryUtils
                // .createBiomeModifier(MODULE_ID, "id");

        }

}